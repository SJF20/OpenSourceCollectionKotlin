package com.shijingfeng.todo.view_model

import com.blankj.utilcode.util.TimeUtils
import com.kingja.loadsir.callback.Callback
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import com.shijingfeng.base.annotation.define.PageOperateType
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent
import com.shijingfeng.base.livedata.SingleLiveEvent
import com.shijingfeng.todo.base.TodoBaseViewModel
import com.shijingfeng.todo.constant.TYPE_ALL
import com.shijingfeng.todo.entity.MainTodoItem
import com.shijingfeng.todo.entity.adapter.MainTodoGroupItem
import com.shijingfeng.todo.source.repository.MainTodoRepository
import com.shijingfeng.todo.ui.activity.MAIN_TODO

/** 第一页 页码  */
const val MAIN_TODO_FIRST_PAGE = 1

/**
 * Function: 主页 -> 待办 ViewModel
 * Date: 2020/5/19 9:42
 * Description:
 * @author ShiJingFeng
 */
internal class MainTodoViewModel(
    repository: MainTodoRepository? = null
) : TodoBaseViewModel<MainTodoRepository>(
    repository
) {

    /** 当前页码  */
    private var mPage = MAIN_TODO_FIRST_PAGE

    /** 页面操作类型  */
    @PageOperateType private var mPageOperateType = PAGE_OPERATE_TYPE_LOAD

    /** 待办列表 (性能优化技巧: 因为以天为单位的毫秒值是从小到大的顺序，故可以使用二分查找) */
    val mMainTodoItemList = mutableListOf<MainTodoGroupItem>()

    /** 列表数据改变 LiveData Event  */
    var mListDataChangeEvent = SingleLiveEvent<ListDataChangeEvent<MainTodoGroupItem>>()

    /** LoadService 重新加载监听器  */
    val mReloadListener = Callback.OnReloadListener {
        if (mLoadServiceStatus == LOAD_SERVICE_LOADING) {
            return@OnReloadListener
        }
        showCallback(LOAD_SERVICE_LOADING)
        load()
    }

    /** 下拉刷新  */
    val mOnRefreshListener = OnRefreshListener { refresh() }

    /** 上拉加载  */
    val mOnLoadMoreListener = OnLoadMoreListener { loadMore() }

    /**
     * 初始化
     */
    override fun init() {
        super.init()
//        load()
    }

    /**
     * 加载数据
     */
    private fun load() {
        mPageOperateType = PAGE_OPERATE_TYPE_LOAD
        getTodoData(MAIN_TODO_FIRST_PAGE)
    }

    /**
     * 下拉刷新
     */
    private fun refresh() {
        mPageOperateType = PAGE_OPERATE_TYPE_REFRESH
        //下拉刷新 期间禁止 上拉加载
        getTodoData(MAIN_TODO_FIRST_PAGE)
    }

    /**
     * 上拉加载
     */
    private fun loadMore() {
        mPageOperateType = PAGE_OPERATE_TYPE_LOAD_MORE
        getTodoData(mPage + 1)
    }

    /**
     * 获取 待办 数据
     * @param page 页码 (从 [MAIN_TODO_FIRST_PAGE] 开始)
     */
    private fun getTodoData(page: Int) {
        mRepository?.getTodoData(
            page = page,
            postMap = hashMapOf<String, Any>().apply {
                put("status", MAIN_TODO)
                put("type", TYPE_ALL)
            },
            onSuccess = onSuccessLabel@{ todo ->
                val todoItemList = todo?.todoItemList
                val event = ListDataChangeEvent<MainTodoGroupItem>()

                when (mPageOperateType) {
                    // 加载数据 或 重新加载
                    PAGE_OPERATE_TYPE_LOAD -> {
//                        mPage = MAIN_TODO_FIRST_PAGE
//                        mMainTodoItemList.clear()
//                        if (!todoItemList.isNullOrEmpty()) {
//                            //分组
//
//                            mMainTodoItemList.addAll(todoItemList)
//                        }
//
//                        event.type = LOAD
//                        event.dataList = todoItemList
//
//                        mListDataChangeEvent.value = event
//                        showCallback(if (mMainTodoItemList.isEmpty()) LOAD_SERVICE_EMPTY else LOAD_SERVICE_SUCCESS)
                    }
                    // 下拉刷新
                    PAGE_OPERATE_TYPE_REFRESH -> {
//                        mPage = MAIN_TODO_FIRST_PAGE
//                        mMainTodoItemList.clear()
//                        if (!todoItemList.isNullOrEmpty()) {
//                            mMainTodoItemList.addAll(todoItemList)
//                        }
//
//                        event.type = REFRESH
//                        event.dataList = todoItemList
//
//                        mListDataChangeEvent.value = event
//                        updateRefreshLoadMoreStatus(REFRESH_SUCCESS)
//                        // 数据为空
//                        if (mMainTodoItemList.isEmpty()) {
//                            showCallback(LOAD_SERVICE_EMPTY)
//                        }
                    }
                    // 上拉加载
                    PAGE_OPERATE_TYPE_LOAD_MORE -> {
//                        if (todoItemList.isNullOrEmpty()) {
//                            updateRefreshLoadMoreStatus(LOAD_MORE_ALL)
//                            return@onSuccessLabel
//                        }
//                        ++mPage
//
//                        event.type = ADD
//                        event.dataList = todoItemList
//                        event.extraData = mMainTodoItemList.size
//
//                        //添加数据
//                        mMainTodoItemList.addAll(todoItemList)
//                        mListDataChangeEvent.value = event
//                        updateRefreshLoadMoreStatus(LOAD_MORE_SUCCESS)
                    }
                    else -> {}
                }
            },
            onFailure = {
                when (mPageOperateType) {
                    // 加载数据
                    PAGE_OPERATE_TYPE_LOAD -> showCallback(LOAD_SERVICE_LOAD_FAIL)
                    // 下拉刷新
                    PAGE_OPERATE_TYPE_REFRESH -> updateRefreshLoadMoreStatus(REFRESH_FAIL)
                    // 上拉加载
                    PAGE_OPERATE_TYPE_LOAD_MORE -> updateRefreshLoadMoreStatus(LOAD_MORE_FAIL)
                    else -> {}
                }
            }
        )
    }

    /**
     * 通过日期进行分组
     *
     * @param todoItemList 要分组的列表
     */
    private fun groupByDate(todoItemList: List<MainTodoItem>) {
        if (todoItemList.isNullOrEmpty()) {
            return
        }

        val firstTodoItem = todoItemList[0]
        val firstTodoItemDayMs = firstTodoItem.date / 86400000L
        // 使用二分查找算法查到 position
        val resultMap = binarySearch(0, mMainTodoItemList.size - 1, firstTodoItemDayMs)
        val find = resultMap["find"] as Boolean
        val position = resultMap["position"] as Int

        if (find) {
            // 查找到了
        } else {
            if (position != mMainTodoItemList.size - 1) {
                // 要归到的分组 在 已加载的列表中
                val locationTodoItem = mMainTodoItemList[position]

                // position: 在该 定位Item 之前    position + 1: 在该 定位Item 之后
                mMainTodoItemList.add(if (firstTodoItemDayMs > locationTodoItem.identity) position else (position + 1), MainTodoGroupItem(
                    identity = firstTodoItemDayMs,
                    completeDateStr = TimeUtils.millis2String(firstTodoItem.date, "yyyy/MM/dd"),
                    todoItemList = mutableListOf(firstTodoItem)
                ))
            }
        }

        // 剩下的列表数据肯定在列表第一个数据附近
        for (index in 1 until todoItemList.size) {
            val todoItem = todoItemList[index]
            val dayMs = todoItem.date / 86400000L


        }
    }

    /**
     * 二分查找 适配器列表 position
     */
    private fun binarySearch(
        startPosition: Int,
        endPosition: Int,
        target: Long
    ): Map<String, Any> {
        var low = startPosition
        var high = endPosition

        while (low <= high) {
            val mid = low + (high - low).shr(1)
            val todoItem = mMainTodoItemList[mid]

            when {
                // 向列表头部方向查找
                todoItem.identity < target -> high = mid - 1
                // 向列表尾部方向查找
                todoItem.identity > target -> low = mid + 1
                // 命中
                else -> return hashMapOf<String, Any>().apply {
                    put("find", true)
                    put("position", mid)
                }
            }
        }
        return hashMapOf<String, Any>().apply {
            put("find", false)
            put("position", low)
        }
    }

}