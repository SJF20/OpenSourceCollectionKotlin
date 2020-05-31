package com.shijingfeng.wan_android.source.network

import android.annotation.SuppressLint
import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.base.util.RetrofitUtil
import com.shijingfeng.wan_android.common.constant.SERVER_SUCCESS
import com.shijingfeng.wan_android.entity.adapter.HomeBannerItem
import com.shijingfeng.wan_android.entity.adapter.HomeBannerListItem
import com.shijingfeng.wan_android.entity.adapter.HomeTopArticleItem
import com.shijingfeng.wan_android.entity.HomeArticleEntity
import com.shijingfeng.wan_android.entity.HomeDataEntity
import com.shijingfeng.wan_android.entity.ResultEntity
import com.shijingfeng.wan_android.source.network.api.ArticleApi
import com.shijingfeng.wan_android.source.network.api.BannerApi
import com.shijingfeng.wan_android.source.network.api.CollectionApi
import com.shijingfeng.wan_android.utils.apiRequest
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function3
import com.shijingfeng.wan_android.view_model.HOME_FIRST_PAGE

/** 单例实例 */
@Volatile
private var sInstance: HomeNetworkSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getHomeNetworkSourceInstance(): HomeNetworkSource {
    if (sInstance == null) {
        synchronized(HomeNetworkSource::class.java) {
            if (sInstance == null) {
                sInstance = HomeNetworkSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 首页 网络源
 * Date: 2020/2/12 10:26
 * Description:
 * @author ShiJingFeng
 */
internal class HomeNetworkSource : BaseNetworkSource() {

    /** 轮播图 Api  */
    private val mBannerApi = RetrofitUtil.create(BannerApi::class.java)
    /** 文章 Api  */
    private val mArticleApi = RetrofitUtil.create(ArticleApi::class.java)
    /** 收藏 Api  */
    private val mCollectionApi = RetrofitUtil.create(CollectionApi::class.java)

    /**
     * 获取首页数据
     * @param page 页码 (从 [HOME_FIRST_PAGE] 开始，为了兼容以前的)
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    @SuppressLint("CheckResult")
    fun getHomeDataList(page: Int, onSuccess: onSuccess<HomeDataEntity?>, onFailure: onFailure) {
        val disposable: Disposable

        if (page == HOME_FIRST_PAGE) {
            //获取 轮播图数据, 置顶列表 和 第一页的文章列表
            disposable = apiRequest(
                single = Single.zip(
                    mBannerApi.getHomeBannerList(),
                    mArticleApi.getHomeTopArticleList(),
                    mArticleApi.getHomeArticleList(page),
                    Function3<
                            ResultEntity<List<HomeBannerItem>>,
                            ResultEntity<List<HomeTopArticleItem>>,
                            ResultEntity<HomeArticleEntity>,
                            ResultEntity<HomeDataEntity>
                    > { homeBannerListResult,
                        homeSetToTopItemListResult,
                        homeArticleResult ->

                        val code: Int
                        var msg = ""
                        val homeData =
                            HomeDataEntity()

                        homeBannerListResult.data?.let { homeBannerList ->
                            homeData.homeBannerListItem = HomeBannerListItem(homeBannerList)
                        }
                        homeSetToTopItemListResult.data?.let { homeSetToTopItemList ->
                            homeData.homeTopArticleItemList = homeSetToTopItemList
                        }
                        homeArticleResult.data?.let { homeArticle ->
                            homeData.homeArticle = homeArticle
                        }

                        when(SERVER_SUCCESS) {
                            homeBannerListResult.code,
                            homeSetToTopItemListResult.code,
                            homeArticleResult.code -> {
                                code = SERVER_SUCCESS
                            }
                            else -> {
                                code = homeBannerListResult.code
                                msg = homeArticleResult.msg
                            }
                        }

                        return@Function3 ResultEntity(
                            code,
                            msg,
                            homeData
                        )
                    }
                ),
                onSuccess = onSuccess,
                onFailure = onFailure
            )
        } else {
            //获取指定页码的文章列表
            disposable = apiRequest(
                single = mArticleApi.getHomeArticleList(page),
                onSuccess = { data ->
                    onSuccess(
                        HomeDataEntity()
                            .also { homeData ->
                        data?.let { homeArticle ->
                            homeData.homeArticle = homeArticle
                        }
                    })
                },
                onFailure = onFailure
            )
        }

        addDisposable(disposable)
    }

    /**
     * 收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调函数
     */
    fun collected(articleId: String, onSuccess: onSuccess<Any?>) {
        addDisposable(apiRequest(
            single = mCollectionApi.collectedInSitesArticle(articleId),
            onSuccess = onSuccess
        ))
    }

    /**
     * 取消收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调函数
     */
    fun uncollected(articleId: String, onSuccess: onSuccess<Any?>) {
        addDisposable(apiRequest(
            single = mCollectionApi.uncollectedInArticleList(articleId),
            onSuccess = onSuccess
        ))
    }

    /**
     * 清除数据
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }
}