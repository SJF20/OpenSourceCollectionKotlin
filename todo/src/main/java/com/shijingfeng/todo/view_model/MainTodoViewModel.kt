package com.shijingfeng.todo.view_model

import com.kingja.loadsir.callback.Callback
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import com.shijingfeng.base.annotation.define.PageOperateType
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent
import com.shijingfeng.base.livedata.SingleLiveEvent
import com.shijingfeng.todo.base.TodoBaseViewModel
import com.shijingfeng.todo.constant.TYPE_ALL
import com.shijingfeng.todo.constant.TYPE_NO_CLASSIFY
import com.shijingfeng.todo.entity.MainTodoGroupItem
import com.shijingfeng.todo.entity.adapter.MainTodoItem
import com.shijingfeng.todo.entity.adapter.TodoGroupItem
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

    /** 待办列表 */
    val mMainTodoItemList = mutableListOf<MainTodoItem>()

    /**
     * 待办 Map 列表
     * Key: 毫秒值 (以天为单位)
     * Value: [mMainTodoItemList] 下标
     */
    val mMainTodoItemMapList = mutableMapOf<Long, Int>()

    /** 列表数据改变 LiveData Event  */
    var mListDataChangeEvent = SingleLiveEvent<ListDataChangeEvent<MainTodoItem>>()

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
        load()
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
                val event = ListDataChangeEvent<MainTodoItem>()

                when (mPageOperateType) {
                    // 加载数据 或 重新加载
                    PAGE_OPERATE_TYPE_LOAD -> {
                        mPage = MAIN_TODO_FIRST_PAGE
                        mMainTodoItemList.clear()
                        if (!todoItemList.isNullOrEmpty()) {
                            //分组

                            mMainTodoItemList.addAll(todoItemList)
                        }

                        event.type = LOAD
                        event.dataList = todoItemList

                        mListDataChangeEvent.value = event
                        showCallback(if (mMainTodoItemList.isEmpty()) LOAD_SERVICE_EMPTY else LOAD_SERVICE_SUCCESS)
                    }
                    // 下拉刷新
                    PAGE_OPERATE_TYPE_REFRESH -> {
                        mPage = MAIN_TODO_FIRST_PAGE
                        mMainTodoItemList.clear()
                        if (!todoItemList.isNullOrEmpty()) {
                            mMainTodoItemList.addAll(todoItemList)
                        }

                        event.type = REFRESH
                        event.dataList = todoItemList

                        mListDataChangeEvent.value = event
                        updateRefreshLoadMoreStatus(REFRESH_SUCCESS)
                        // 数据为空
                        if (mMainTodoItemList.isEmpty()) {
                            showCallback(LOAD_SERVICE_EMPTY)
                        }
                    }
                    // 上拉加载
                    PAGE_OPERATE_TYPE_LOAD_MORE -> {
                        if (todoItemList.isNullOrEmpty()) {
                            updateRefreshLoadMoreStatus(LOAD_MORE_ALL)
                            return@onSuccessLabel
                        }
                        ++mPage

                        event.type = ADD
                        event.dataList = todoItemList
                        event.extraData = mMainTodoItemList.size

                        //添加数据
                        mMainTodoItemList.addAll(todoItemList)
                        mListDataChangeEvent.value = event
                        updateRefreshLoadMoreStatus(LOAD_MORE_SUCCESS)
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
    private fun groupByDate(todoItemList: List<MainTodoGroupItem>) {
        if (todoItemList.isNullOrEmpty()) {
            return
        }

        val mainTodoItemMap = LinkedHashMap<Long, MainTodoItem>()

        mMainTodoItemList.forEach { mainTodoItem ->
            mainTodoItemMap[mainTodoItem.identity] = mainTodoItem
        }

        todoItemList.forEach { todoItem ->
            val dayMs = todoItem.date / 86400000L
            val mainTodoItem = mainTodoItemMap[dayMs]

            if (mainTodoItem != null) {
                mainTodoItem.todoItemList.add(todoItem)
            } else {
                mainTodoItemMap[dayMs] = MainTodoItem(
                    identity = dayMs,
                    date = todoItem.dateStr,
                    todoItemList = mutableListOf<MainTodoGroupItem>().apply {
                        add(todoItem)
                    }
                )
            }
        }
        mainTodoItemMap.forEach { entry ->

        }
    }

}