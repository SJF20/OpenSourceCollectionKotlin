package com.shijingfeng.wan_android.view_model

import android.util.SparseArray
import com.blankj.utilcode.util.ToastUtils
import com.kingja.loadsir.callback.Callback.OnReloadListener
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import com.shijingfeng.base.annotation.define.PageOperateType
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent
import com.shijingfeng.base.mvvm.livedata.SingleLiveEvent
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
import com.shijingfeng.wan_android.common.constant.KEY_ARTICLE_ID
import com.shijingfeng.wan_android.common.constant.KEY_COLLECTED
import com.shijingfeng.wan_android.entity.event.ArticleCollectionEvent
import com.shijingfeng.wan_android.entity.SquareItem
import com.shijingfeng.wan_android.source.network.getSquareNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.SquareRepository
import com.shijingfeng.wan_android.source.repository.getSquareRepositoryInstance
import com.shijingfeng.wan_android.ui.fragment.SquareFragment
import org.greenrobot.eventbus.EventBus

/** 第一页 页码  */
const val SQUARE_FIRST_PAGE = 0

/**
 * Function: 广场 ViewModel
 * Date: 2020/2/12 17:06
 * Description:
 * Author: ShiJingFeng
 */
internal class SquareViewModel : WanAndroidBaseViewModel<SquareRepository>() {

    /** 当前页码  */
    private var mPage = SQUARE_FIRST_PAGE
    /** 页面操作类型  */
    @PageOperateType private var mPageOperateType = PAGE_OPERATE_TYPE_LOAD
    /** 广场 Item 数据列表  */
    val mSquareItemList = mutableListOf<SquareItem>()

    /** 列表数据改变 LiveData Event  */
    var mListDataChangeEvent =
        SingleLiveEvent<ListDataChangeEvent<SquareItem>>()
    /** 文章收藏状态 SingleLiveEvent  true 收藏  false 取消收藏  */
    val mCollectedStatusEvent =
        SingleLiveEvent<SparseArray<Any?>>()

    /** 是否需要更新主题(当Fragment在没有显示的情况下，RecyclerView更新Adapter无反应)  true: 需要  false: 不需要 */
    var mNeedUpdateTheme = false

    /** LoadService 重新加载监听器  */
    val mReloadListener = OnReloadListener {
        if (mLoadServiceStatus == LOAD_SERVICE_LOADING) {
            return@OnReloadListener
        }
        showCallback(LOAD_SERVICE_LOADING)
        load()
    }

    /** 下拉刷新 */
    val mOnRefreshListener = OnRefreshListener { refresh() }

    /** 上拉加载 */
    val mOnLoadMoreListener = OnLoadMoreListener { loadMore() }

    /**
     * 获取 Repository
     * @return Repository
     */
    override fun getRepository() = getSquareRepositoryInstance(
        networkSource = getSquareNetworkSourceInstance()
    )

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
        getSquareList(SQUARE_FIRST_PAGE)
    }

    /**
     * 下拉刷新
     */
    fun refresh() {
        mPageOperateType = PAGE_OPERATE_TYPE_REFRESH
        getSquareList(SQUARE_FIRST_PAGE)
    }

    /**
     * 上拉加载
     */
    private fun loadMore() {
        mPageOperateType = PAGE_OPERATE_TYPE_LOAD_MORE
        getSquareList(mPage + 1)
    }

    /**
     * 获取 广场 列表
     * @param page 页码 (从 [SQUARE_FIRST_PAGE] 开始)
     */
    private fun getSquareList(page: Int) {
        mRepository?.getSquareList(page, onSuccess = onSuccessLabel@{ square ->
            val squareItemList = square?.dataList
            val event = ListDataChangeEvent<SquareItem>()

            when (mPageOperateType) {
                // 加载数据
                PAGE_OPERATE_TYPE_LOAD -> {
                    mPage = SQUARE_FIRST_PAGE
                    mSquareItemList.clear()
                    if (!squareItemList.isNullOrEmpty()) {
                        mSquareItemList.addAll(squareItemList)
                    }

                    event.type = LOAD
                    event.dataList = squareItemList

                    mListDataChangeEvent.value = event
                    showCallback(if (mSquareItemList.isEmpty()) LOAD_SERVICE_EMPTY else LOAD_SERVICE_SUCCESS)
                }
                // 下拉刷新
                PAGE_OPERATE_TYPE_REFRESH -> {
                    mPage = SQUARE_FIRST_PAGE
                    mSquareItemList.clear()
                    if (!squareItemList.isNullOrEmpty()) {
                        mSquareItemList.addAll(squareItemList)
                    }

                    event.type = REFRESH
                    event.dataList = squareItemList

                    mListDataChangeEvent.value = event
                    updateRefreshLoadMoreStatus(REFRESH_SUCCESS)
                    // 数据为空
                    if (mSquareItemList.isEmpty()) {
                        showCallback(LOAD_SERVICE_EMPTY)
                    }
                }
                // 上拉加载
                PAGE_OPERATE_TYPE_LOAD_MORE -> {
                    if (squareItemList.isNullOrEmpty()) {
                        updateRefreshLoadMoreStatus(LOAD_MORE_ALL)
                        return@onSuccessLabel
                    }
                    ++mPage

                    event.type = ADD
                    event.dataList = squareItemList
                    event.extraData = mSquareItemList.size

                    mSquareItemList.addAll(squareItemList)
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

    /**
     * 收藏
     * @param articleId 文章ID
     */
    fun collected(articleId: String) {
        mRepository?.collected(articleId, onSuccess = {
            ToastUtils.showShort(getStringById(R.string.收藏成功))
            mCollectedStatusEvent.value = SparseArray<Any?>().apply {
                put(KEY_COLLECTED, true)
                put(KEY_ARTICLE_ID, articleId)
            }
            // 收藏该文章 广播出去
            EventBus.getDefault().post(ArticleCollectionEvent(
                fromName = SquareFragment::class.java.name,
                id = articleId,
                collected = true
            ))
        })
    }

    /**
     * 取消收藏
     * @param articleId 文章ID
     */
    fun uncollected(articleId: String) {
        mRepository?.uncollected(articleId, onSuccess = {
            ToastUtils.showShort(getStringById(R.string.取消收藏成功))
            mCollectedStatusEvent.value = SparseArray<Any?>().apply {
                put(KEY_COLLECTED, false)
                put(KEY_ARTICLE_ID, articleId)
            }
            // 取消收藏该文章 广播出去
            EventBus.getDefault().post(ArticleCollectionEvent(
                fromName = SquareFragment::class.java.name,
                id = articleId,
                collected = false
            ))
        })
    }

}