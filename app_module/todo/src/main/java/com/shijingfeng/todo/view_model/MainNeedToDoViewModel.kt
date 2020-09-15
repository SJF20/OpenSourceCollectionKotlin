package com.shijingfeng.todo.view_model

import com.blankj.utilcode.util.ToastUtils
import com.kingja.loadsir.callback.Callback
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import com.shijingfeng.base.annotation.define.PageOperateType
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent
import com.shijingfeng.base.livedata.SingleLiveEvent
import com.shijingfeng.todo.annotation.define.TodoStatus
import com.shijingfeng.todo.base.TodoBaseViewModel
import com.shijingfeng.todo.constant.*
import com.shijingfeng.todo.constant.PRIORITY
import com.shijingfeng.todo.constant.PRIORITY_ALL
import com.shijingfeng.todo.constant.TYPE
import com.shijingfeng.todo.constant.TYPE_ALL
import com.shijingfeng.todo.entity.adapter.TodoGroupItem
import com.shijingfeng.todo.entity.adapter.TodoItem
import com.shijingfeng.todo.source.repository.TodoRepository
import com.shijingfeng.todo.ui.activity.MAIN_DONE
import com.shijingfeng.todo.ui.activity.MAIN_NEED_TO_DO
import com.shijingfeng.todo.constant.PAGE_TYPE
import com.shijingfeng.todo.entity.event.DataUpdateEvent
import com.shijingfeng.todo.ui.activity.MAIN_ALL
import com.shijingfeng.todo.ui.activity.MAIN_NONE
import org.greenrobot.eventbus.EventBus

/** 第一页 页码  */
internal const val MAIN_NEED_TO_DO_FIRST_PAGE = 1

/**
 * Function: 主页 -> 待办 ViewModel
 * Date: 2020/5/19 9:42
 * Description:
 * @author ShiJingFeng
 */
internal class MainNeedToDoViewModel(
    repository: TodoRepository? = null
) : TodoBaseViewModel<TodoRepository>(
    repository
) {

    /** 当前页码  */
    private var mPage = MAIN_NEED_TO_DO_FIRST_PAGE

    /** 页面操作类型  */
    @PageOperateType
    private var mPageOperateType = PAGE_OPERATE_TYPE_LOAD

    /** 页面类型 */
    var mPageType = MAIN_NONE

    /** 待办列表 (性能优化技巧: 因为以天为单位的毫秒值是从小到大的顺序，故可以使用二分查找) */
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
            mPageType = getInt(PAGE_TYPE, MAIN_NONE)
            when (mPageType) {
                // 待办
                MAIN_NEED_TO_DO -> mRequestParamMap[STATUS] = STATUS_NEED_TO_DO
                // 已完成
                MAIN_DONE -> mRequestParamMap[STATUS] = STATUS_DONE
            }
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
        getTodoData(MAIN_NEED_TO_DO_FIRST_PAGE)
    }

    /**
     * 重新加载数据
     */
    fun reload() {
        showLoadingView()
        mPageOperateType = PAGE_OPERATE_TYPE_RELOAD
        getTodoData(MAIN_NEED_TO_DO_FIRST_PAGE)
    }

    /**
     * 下拉刷新
     */
    private fun refresh() {
        mPageOperateType = PAGE_OPERATE_TYPE_REFRESH
        //下拉刷新 期间禁止 上拉加载
        getTodoData(MAIN_NEED_TO_DO_FIRST_PAGE)
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
     * @param page 页码 (从 [MAIN_NEED_TO_DO_FIRST_PAGE] 开始)
     */
    private fun getTodoData(page: Int) {
        mRepository?.getTodoData(
            page = page,
            postMap = mRequestParamMap,
            onSuccess = onSuccessLabel@{ todo ->
                val todoItemList = todo?.todoItemList
                val event = ListDataChangeEvent<TodoGroupItem>()

                when (mPageOperateType) {
                    // 加载数据
                    PAGE_OPERATE_TYPE_LOAD,
                    // 重新加载
                    PAGE_OPERATE_TYPE_RELOAD -> {
                        mPage = MAIN_NEED_TO_DO_FIRST_PAGE
                        mTodoGroupItemList.clear()
                        // 按天进行分组
                        groupByDay(todoItemList)

                        event.type = LOAD
                        event.dataList = mTodoGroupItemList

                        mListDataChangeEvent.value = event
                        showCallback(if (mTodoGroupItemList.isEmpty()) LOAD_SERVICE_EMPTY else LOAD_SERVICE_SUCCESS)
                        hideLoadingView()
                    }
                    // 下拉刷新
                    PAGE_OPERATE_TYPE_REFRESH -> {
                        mPage = MAIN_NEED_TO_DO_FIRST_PAGE
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
                    // 重新加载数据
                    PAGE_OPERATE_TYPE_RELOAD -> hideLoadingDialog()
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
     * 删除
     * @param id ID
     */
    fun remove(id: String) {
        showLoadingDialog("删除中...")
        mRepository?.remove(id, onSuccess = {
            hideLoadingDialog()
            ToastUtils.showShort("删除成功")
            // 因为接口问题 (因为有删除，而返回的条数不确定)，所以只能重新请求数据
            EventBus.getDefault().post(DataUpdateEvent(
                pageType = mPageType
            ))
        }, onFailure = {
            hideLoadingDialog()
        })
    }

    /**
     * 更新状态
     * @param id ID
     * @param status 状态 0或1，传1代表未完成到已完成，反之则反之。
     */
    fun updateStatus(
        id: String,
        @TodoStatus status: Int
    ) {
        showLoadingDialog("提交中...")
        mRepository?.updateStatus(id, status, onSuccess = {
            hideLoadingDialog()
            when (status) {
                STATUS_NEED_TO_DO -> {
                    ToastUtils.showShort("撤回成功")
                }
                STATUS_DONE -> {
                    ToastUtils.showShort("完成成功")
                }
            }
            // 因为接口问题 (因为有删除，而返回的条数不确定)，所以只能重新请求数据
            EventBus.getDefault().post(DataUpdateEvent(
                pageType = MAIN_ALL
            ))
        }, onFailure = {
            hideLoadingDialog()
        })
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