package com.shijingfeng.todo.view_model

import com.kingja.loadsir.callback.Callback
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import com.shijingfeng.base.annotation.define.PageOperateType
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent
import com.shijingfeng.base.livedata.SingleLiveEvent
import com.shijingfeng.todo.base.TodoBaseViewModel
import com.shijingfeng.todo.constant.ORDER_BY
import com.shijingfeng.todo.constant.ORDER_BY_COMPLETE_DATE_ASC
import com.shijingfeng.todo.constant.PRIORITY
import com.shijingfeng.todo.constant.PRIORITY_ALL
import com.shijingfeng.todo.constant.TYPE
import com.shijingfeng.todo.constant.TYPE_ALL
import com.shijingfeng.todo.entity.adapter.TodoGroupItem
import com.shijingfeng.todo.entity.adapter.TodoItem
import com.shijingfeng.todo.source.repository.TodoRepository

/** 第一页 页码  */
internal const val MAIN_DONE_FIRST_PAGE = 1

/**
 * Function: 主页 -> 已完成 ViewModel
 * Date: 2020/5/19 9:42
 * Description:
 * @author ShiJingFeng
 */
internal class MainDoneViewModel(
    repository: TodoRepository? = null
) : TodoBaseViewModel<TodoRepository>(
    repository
) {

    /** 当前页码  */
    private var mPage = MAIN_DONE_FIRST_PAGE

    /** 页面操作类型  */
    @PageOperateType
    private var mPageOperateType = PAGE_OPERATE_TYPE_LOAD

    /** 完成列表 (性能优化技巧: 因为以天为单位的毫秒值是从小到大的顺序，故可以使用二分查找) */
    val mTodoGroupItemList = mutableListOf<TodoGroupItem>()

    /** 列表数据改变 LiveData Event  */
    var mListDataChangeEvent = SingleLiveEvent<ListDataChangeEvent<TodoGroupItem>>()

    /** 请求参数 Map */
    val mRequestParamMap = hashMapOf<String, Any>()

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
        mParamBundle?.run {
            mRequestParamMap[TYPE] = getInt(TYPE, TYPE_ALL)
            mRequestParamMap[PRIORITY] = getInt(PRIORITY, PRIORITY_ALL)
            mRequestParamMap[ORDER_BY] = getInt(ORDER_BY, ORDER_BY_COMPLETE_DATE_ASC)
        }
        load()
    }

    /**
     * 加载数据
     */
    fun load() {
        mPageOperateType = PAGE_OPERATE_TYPE_LOAD
        getTodoData(MAIN_DONE_FIRST_PAGE)
    }

    /**
     * 下拉刷新
     */
    private fun refresh() {
        mPageOperateType = PAGE_OPERATE_TYPE_REFRESH
        //下拉刷新 期间禁止 上拉加载
        getTodoData(MAIN_DONE_FIRST_PAGE)
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
     * @param page 页码 (从 [MAIN_DONE_FIRST_PAGE] 开始)
     */
    private fun getTodoData(page: Int) {
        mRepository?.getTodoData(
            page = page,
            postMap = mRequestParamMap,
            onSuccess = onSuccessLabel@{ todo ->
                val todoItemList = todo?.todoItemList
                val event = ListDataChangeEvent<TodoGroupItem>()

                when (mPageOperateType) {
                    // 加载数据 或 重新加载
                    PAGE_OPERATE_TYPE_LOAD -> {
                        mPage = MAIN_DONE_FIRST_PAGE
                        mTodoGroupItemList.clear()
                        // 按天进行分组
                        groupByDay(todoItemList)

                        event.type = LOAD
                        event.dataList = mTodoGroupItemList

                        mListDataChangeEvent.value = event
                        showCallback(if (mTodoGroupItemList.isEmpty()) LOAD_SERVICE_EMPTY else LOAD_SERVICE_SUCCESS)
                    }
                    // 下拉刷新
                    PAGE_OPERATE_TYPE_REFRESH -> {
                        mPage = MAIN_DONE_FIRST_PAGE
                        mTodoGroupItemList.clear()
                        // 按天进行分组
                        groupByDay(todoItemList)

                        event.type = REFRESH
                        event.dataList = mTodoGroupItemList

                        mListDataChangeEvent.value = event
                        updateRefreshLoadMoreStatus(REFRESH_SUCCESS)
                        // 数据为空
                        if (mTodoGroupItemList.isEmpty()) {
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
                        event.dataList = mTodoGroupItemList
                        event.extraData = mTodoGroupItemList.size
                        // 按天进行分组
                        groupByDay(todoItemList)

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
     * 按天进行分组
     *
     * @param todoItemList
     */
    private fun groupByDay(todoItemList: List<TodoItem>?) {
        if (!todoItemList.isNullOrEmpty()) {
            //分组
            todoItemList.forEach { todoItem ->
                val day = todoItem.date / 86400000L

                if (mTodoGroupItemList.isEmpty()) {
                    mTodoGroupItemList.add(TodoGroupItem(
                        identity = day,
                        dateStr = todoItem.dateStr,
                        todoItemList = mutableListOf(todoItem)
                    ))
                } else {
                    val lastTodoGroupItem = mTodoGroupItemList[mTodoGroupItemList.size - 1]

                    if (lastTodoGroupItem.identity == day) {
                        lastTodoGroupItem.todoItemList.add(todoItem)
                    } else {
                        mTodoGroupItemList.add(TodoGroupItem(
                            identity = day,
                            dateStr = todoItem.dateStr,
                            todoItemList = mutableListOf(todoItem)
                        ))
                    }
                }
            }
        }
    }

}