package com.shijingfeng.todo.view_model

import com.kingja.loadsir.callback.Callback
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import com.shijingfeng.base.annotation.define.PageOperateType
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent
import com.shijingfeng.base.livedata.SingleLiveEvent
import com.shijingfeng.todo.base.TodoBaseViewModel
import com.shijingfeng.todo.entity.adapter.TodoGroupItem
import com.shijingfeng.todo.source.repository.MainTodoRepository

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

    /** 分组后的待办列表 */
    val mTodoGroupItemList = mutableListOf<TodoGroupItem>()

    /** 列表数据改变 LiveData Event  */
    var mListDataChangeEvent = SingleLiveEvent<ListDataChangeEvent<TodoGroupItem>>()

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
        getCoinRecordList(COIN_RECORD_FIRST_PAGE)
    }

    /**
     * 下拉刷新
     */
    private fun refresh() {
        mPageOperateType = PAGE_OPERATE_TYPE_REFRESH
        //下拉刷新 期间禁止 上拉加载
        getCoinRecordList(COIN_RECORD_FIRST_PAGE)
    }

    /**
     * 上拉加载
     */
    private fun loadMore() {
        mPageOperateType = PAGE_OPERATE_TYPE_LOAD_MORE
        getCoinRecordList(mPage + 1)
    }

    /**
     * 获取 待办 数据
     * @param page 页码 (从 [MAIN_TODO_FIRST_PAGE] 开始)
     */
    private fun getCoinRecordList(page: Int) {
        val postMap = mapOf<String, Any>()

        mRepository?.getTodoData(page, onSuccess = onSuccessLabel@{ todo ->
            val coinRecordItemList = todo?.
            val event = ListDataChangeEvent<CoinRecordItem>()

            when (mPageOperateType) {
                // 加载数据 或 重新加载
                PAGE_OPERATE_TYPE_LOAD -> {
                    mPage = MAIN_TODO_FIRST_PAGE
                    mCoinRecordItemList.clear()
                    if (!coinRecordItemList.isNullOrEmpty()) {
                        mCoinRecordItemList.addAll(coinRecordItemList)
                    }

                    event.type = LOAD
                    event.dataList = coinRecordItemList

                    mListDataChangeEvent.value = event
                    showCallback(if (mCoinRecordItemList.isEmpty()) LOAD_SERVICE_EMPTY else LOAD_SERVICE_SUCCESS)
                }
                // 下拉刷新
                PAGE_OPERATE_TYPE_REFRESH -> {
                    mPage = MAIN_TODO_FIRST_PAGE
                    mCoinRecordItemList.clear()
                    if (!coinRecordItemList.isNullOrEmpty()) {
                        mCoinRecordItemList.addAll(coinRecordItemList)
                    }

                    event.type = REFRESH
                    event.dataList = coinRecordItemList

                    mListDataChangeEvent.value = event
                    updateRefreshLoadMoreStatus(REFRESH_SUCCESS)
                    // 数据为空
                    if (mCoinRecordItemList.isEmpty()) {
                        showCallback(LOAD_SERVICE_EMPTY)
                    }
                }
                // 上拉加载
                PAGE_OPERATE_TYPE_LOAD_MORE -> {
                    if (coinRecordItemList.isNullOrEmpty()) {
                        updateRefreshLoadMoreStatus(LOAD_MORE_ALL)
                        return@onSuccessLabel
                    }
                    ++mPage

                    event.type = ADD
                    event.dataList = coinRecordItemList
                    event.extraData = mCoinRecordItemList.size

                    //添加数据
                    mCoinRecordItemList.addAll(coinRecordItemList)
                    mListDataChangeEvent.value = event
                    updateRefreshLoadMoreStatus(LOAD_MORE_SUCCESS)
                }
                else -> {}
            }
        }, onFailure = {
            when (mPageOperateType) {
                // 加载数据
                PAGE_OPERATE_TYPE_LOAD -> showCallback(LOAD_SERVICE_LOAD_FAIL)
                // 下拉刷新
                PAGE_OPERATE_TYPE_REFRESH -> updateRefreshLoadMoreStatus(REFRESH_FAIL)
                // 上拉加载
                PAGE_OPERATE_TYPE_LOAD_MORE -> updateRefreshLoadMoreStatus(LOAD_MORE_FAIL)
                else -> {}
            }
        })
    }

}