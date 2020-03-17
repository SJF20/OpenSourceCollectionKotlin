package com.shijingfeng.wan_android.view_model

import android.util.SparseArray
import com.blankj.utilcode.util.ToastUtils
import com.kingja.loadsir.callback.Callback.OnReloadListener
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_LOGIN
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.entity.event.ListDataChangeEvent
import com.shijingfeng.base.livedata.SingleLiveEvent
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
import com.shijingfeng.wan_android.constant.KEY_ARTICLE_ID
import com.shijingfeng.wan_android.constant.KEY_COLLECTED
import com.shijingfeng.wan_android.constant.SERVER_NEED_LOGIN
import com.shijingfeng.wan_android.entity.adapter.HomeBannerItem
import com.shijingfeng.wan_android.entity.adapter.HomeItem
import com.shijingfeng.wan_android.source.repository.HomeRepository

/**
 * Function: 首页 ViewModel
 * Date: 2020/2/12 13:25
 * Description:
 * @author ShiJingFeng
 */
class HomeViewModel(
    repository: HomeRepository? = null
) : WanAndroidBaseViewModel<HomeRepository>(repository) {

    /** 当前页码  */
    private var mPage = 0
    /** 数据操作类型  */
    private var mDataOperateType = DATA_OPERATE_TYPE_LOAD

    /** 首页 数据列表 (用于适配器)  */
    var mHomeItemDataList = mutableListOf<HomeItem>()

    /** 首页数据改变 SingleLiveEvent  */
    val mHomeDataChangeEvent = SingleLiveEvent<ListDataChangeEvent<HomeItem>>()
    /** 文章收藏状态 SingleLiveEvent  true 收藏  false 取消收藏  */
    val mCollectedStatusEvent = SingleLiveEvent<SparseArray<Any?>>()

    /** LoadService 重新加载监听器  */
    val mReloadListener = OnReloadListener {
        mDataOperateType = DATA_OPERATE_TYPE_LOAD
        getLoadServiceStatusEvent().value = LOADING
        getHomeData(0)
    }
    /** 下拉刷新  */
    val mOnRefreshListener = OnRefreshListener { refresh() }
    /** 上拉加载  */
    val mOnLoadMoreListener = OnLoadMoreListener { load() }

    /**
     * 初始化
     */
    override fun init() {
        super.init()
        mDataOperateType = DATA_OPERATE_TYPE_LOAD
        getHomeData(0)
    }

    /**
     * 下拉刷新
     */
    fun refresh() {
        mDataOperateType = DATA_OPERATE_TYPE_REFRESH
        getHomeData(0)
    }

    /**
     * 上拉加载
     */
    fun load() {
        mDataOperateType = DATA_OPERATE_TYPE_LOAD_MORE
        getHomeData(mPage + 1)
    }

    /**
     * 获取首页数据
     * @param page 页码 (从0开始, 为了兼容以前)
     */
    private fun getHomeData(page: Int) {
        mRepository?.getHomeDataList(page, onSuccess = { homeData ->
            val homeBannerList = homeData?.homeBannerList
            val homeSetToTopItemList = homeData?.homeSetToTopItemList
            val homeArticle = homeData?.homeArticle
            val homeArticleItemList = homeArticle?.dataList
            val event = ListDataChangeEvent<HomeItem>()

            when (mDataOperateType) {
                //加载数据
                DATA_OPERATE_TYPE_LOAD -> {
                    mPage = 0
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
                    getLoadServiceStatusEvent().value = if (mHomeItemDataList.isEmpty()) EMPTY else SUCCESS
                }
                //下拉刷新
                DATA_OPERATE_TYPE_REFRESH -> {
                    mPage = 0
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
                    getRefreshLoadMoreStatusEvent().value = REFRESH_SUCCESS
                    if (mHomeItemDataList.isEmpty()) {
                        getLoadServiceStatusEvent().value = EMPTY
                    }
                }
                //上拉加载
                DATA_OPERATE_TYPE_LOAD_MORE -> {
                    if (homeArticleItemList.isNullOrEmpty()) {
                        getRefreshLoadMoreStatusEvent().value = LOAD_MORE_ALL
                        return@getHomeDataList
                    }
                    ++mPage

                    event.type = ADD
                    event.dataList = homeArticleItemList
                    event.extraData = mHomeItemDataList.size

                    mHomeItemDataList.addAll(homeArticleItemList)
                    mHomeDataChangeEvent.value = event
                    getRefreshLoadMoreStatusEvent().value = LOAD_MORE_SUCCESS
                }
                else -> {}
            }
        }, onFailure = {
            when (mDataOperateType) {
                //加载数据
                DATA_OPERATE_TYPE_LOAD -> getLoadServiceStatusEvent().value = LOAD_FAIL
                //下拉刷新
                DATA_OPERATE_TYPE_REFRESH -> getRefreshLoadMoreStatusEvent().value = REFRESH_FAIL
                //上拉加载
                DATA_OPERATE_TYPE_LOAD_MORE -> getRefreshLoadMoreStatusEvent().value = LOAD_MORE_FAIL
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
            ToastUtils.showShort("收藏成功")
            mCollectedStatusEvent.value = SparseArray<Any?>().apply {
                put(KEY_COLLECTED, true)
                put(KEY_ARTICLE_ID, articleId)
            }
        }, onFailure = { httpException ->
            if (httpException?.errorCode == SERVER_NEED_LOGIN) {
                //需要登录
                navigation(path = ACTIVITY_WAN_ANDROID_LOGIN)
            }
        })
    }

    /**
     * 取消收藏
     * @param articleId 文章ID
     */
    fun uncollected(articleId: String) {
        mRepository?.uncollected(articleId, onSuccess = {
            ToastUtils.showShort("取消收藏成功")
            mCollectedStatusEvent.value = SparseArray<Any?>().apply {
                put(KEY_COLLECTED, false)
                put(KEY_ARTICLE_ID, articleId)
            }
        }, onFailure = { httpException ->
            if (httpException?.errorCode == SERVER_NEED_LOGIN) {
                //需要登录
                navigation(path = ACTIVITY_WAN_ANDROID_LOGIN)
            }
        })
    }

}