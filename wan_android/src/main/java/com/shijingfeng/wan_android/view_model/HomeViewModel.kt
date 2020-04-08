package com.shijingfeng.wan_android.view_model

import android.util.SparseArray
import com.blankj.utilcode.util.ToastUtils
import com.kingja.loadsir.callback.Callback.OnReloadListener
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import com.shijingfeng.base.annotation.define.PageOperateType
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent
import com.shijingfeng.base.livedata.SingleLiveEvent
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
import com.shijingfeng.wan_android.constant.KEY_ARTICLE_ID
import com.shijingfeng.wan_android.constant.KEY_COLLECTED
import com.shijingfeng.wan_android.entity.adapter.HomeBannerItem
import com.shijingfeng.wan_android.entity.adapter.HomeItem
import com.shijingfeng.wan_android.entity.event.ArticleCollectionEvent
import com.shijingfeng.wan_android.source.repository.HomeRepository
import com.shijingfeng.wan_android.ui.fragment.HomeFragment
import org.greenrobot.eventbus.EventBus

/**
 * Function: 首页 ViewModel
 * Date: 2020/2/12 13:25
 * Description:
 * @author ShiJingFeng
 */
internal class HomeViewModel(
    repository: HomeRepository? = null
) : WanAndroidBaseViewModel<HomeRepository>(repository) {

    /** 第一页 页码  */
    private val FIRST_PAGE = 0

    /** 当前页码  */
    private var mPage = FIRST_PAGE
    /** 页面操作类型  */
    @PageOperateType private var mPageOperateType = PAGE_OPERATE_TYPE_LOAD

    /** 首页 数据列表 (用于适配器)  */
    var mHomeItemDataList = mutableListOf<HomeItem>()

    /** 首页数据改变 SingleLiveEvent  */
    val mHomeDataChangeEvent = SingleLiveEvent<ListDataChangeEvent<HomeItem>>()
    /** 文章收藏状态 SingleLiveEvent  true 收藏  false 取消收藏  */
    val mCollectedStatusEvent = SingleLiveEvent<SparseArray<Any?>>()

    /** LoadService 重新加载监听器  */
    val mReloadListener = OnReloadListener {
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
        getHomeData(FIRST_PAGE)
    }

    /**
     * 下拉刷新
     */
    fun refresh() {
        mPageOperateType = PAGE_OPERATE_TYPE_REFRESH
        getHomeData(FIRST_PAGE)
    }

    /**
     * 上拉加载
     */
    private fun loadMore() {
        mPageOperateType = PAGE_OPERATE_TYPE_LOAD_MORE
        getHomeData(mPage + 1)
    }

    /**
     * 获取首页数据
     * @param page 页码 (从 [FIRST_PAGE] 开始, 为了兼容以前)
     */
    private fun getHomeData(page: Int) {
        mRepository?.getHomeDataList(page, onSuccess = { homeData ->
            val homeBannerList = homeData?.homeBannerList
            val homeSetToTopItemList = homeData?.homeSetToTopItemList
            val homeArticle = homeData?.homeArticle
            val homeArticleItemList = homeArticle?.dataList
            val event =
                ListDataChangeEvent<HomeItem>()

            when (mPageOperateType) {
                //加载数据
                PAGE_OPERATE_TYPE_LOAD -> {
                    mPage = FIRST_PAGE
                    mHomeItemDataList.clear()
                    //添加轮播图数据
                    if (!homeBannerList.isNullOrEmpty()) {
                        mHomeItemDataList.add(HomeBannerItem(homeBannerList))
                    }
                    //添加置顶数据
                    if (!homeSetToTopItemList.isNullOrEmpty()) {
                        mHomeItemDataList.addAll(homeSetToTopItemList)
                    }
                    //添加文章数据
                    if (!homeArticleItemList.isNullOrEmpty()) {
                        mHomeItemDataList.addAll(homeArticleItemList)
                    }

                    event.type = LOAD
                    event.dataList = mHomeItemDataList

                    mHomeDataChangeEvent.value = event
                    showCallback(if (mHomeItemDataList.isEmpty()) LOAD_SERVICE_EMPTY else LOAD_SERVICE_SUCCESS)
                }
                //下拉刷新
                PAGE_OPERATE_TYPE_REFRESH -> {
                    mPage = FIRST_PAGE
                    mHomeItemDataList.clear()
                    //添加轮播图数据
                    if (!homeBannerList.isNullOrEmpty()) {
                        mHomeItemDataList.add(HomeBannerItem(homeBannerList))
                    }
                    //添加置顶数据
                    if (!homeSetToTopItemList.isNullOrEmpty()) {
                        mHomeItemDataList.addAll(homeSetToTopItemList)
                    }
                    //添加文章数据
                    if (!homeArticleItemList.isNullOrEmpty()) {
                        mHomeItemDataList.addAll(homeArticleItemList)
                    }

                    event.type = REFRESH
                    event.dataList = mHomeItemDataList

                    mHomeDataChangeEvent.value = event
                    updateRefreshLoadMoreStatus(REFRESH_SUCCESS)
                    if (mHomeItemDataList.isEmpty()) {
                        showCallback(LOAD_SERVICE_EMPTY)
                    }
                }
                //上拉加载
                PAGE_OPERATE_TYPE_LOAD_MORE -> {
                    if (homeArticleItemList.isNullOrEmpty()) {
                        updateRefreshLoadMoreStatus(LOAD_MORE_ALL)
                        return@getHomeDataList
                    }
                    ++mPage

                    event.type = ADD
                    event.dataList = homeArticleItemList
                    event.extraData = mHomeItemDataList.size

                    mHomeItemDataList.addAll(homeArticleItemList)
                    mHomeDataChangeEvent.value = event
                    updateRefreshLoadMoreStatus(LOAD_MORE_SUCCESS)
                }
                else -> {}
            }
        }, onFailure = {
            when (mPageOperateType) {
                //加载数据
                PAGE_OPERATE_TYPE_LOAD -> showCallback(LOAD_SERVICE_LOAD_FAIL)
                //下拉刷新
                PAGE_OPERATE_TYPE_REFRESH -> updateRefreshLoadMoreStatus(REFRESH_FAIL)
                //上拉加载
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
                fromName = HomeFragment::class.java.name,
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
                fromName = HomeFragment::class.java.name,
                id = articleId,
                collected = false
            ))
        })
    }

}