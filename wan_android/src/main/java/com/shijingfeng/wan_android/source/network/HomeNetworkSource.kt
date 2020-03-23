package com.shijingfeng.wan_android.source.network

import android.annotation.SuppressLint
import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.base.http.exception.ServerException
import com.shijingfeng.base.util.RetrofitUtil
import com.shijingfeng.wan_android.constant.SERVER_SUCCESS
import com.shijingfeng.wan_android.entity.adapter.HomeSetToTopItem
import com.shijingfeng.wan_android.entity.network.HomeArticleEntity
import com.shijingfeng.wan_android.entity.network.HomeBannerEntity
import com.shijingfeng.wan_android.entity.network.HomeDataEntity
import com.shijingfeng.wan_android.entity.network.ResultEntity
import com.shijingfeng.wan_android.source.network.api.ArticleApi
import com.shijingfeng.wan_android.source.network.api.BannerApi
import com.shijingfeng.wan_android.source.network.api.CollectionApi
import com.shijingfeng.wan_android.utils.apiRequest
import com.shijingfeng.wan_android.utils.handle
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function3
import io.reactivex.schedulers.Schedulers

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
    private val mBannerApi: BannerApi = RetrofitUtil.create(BannerApi::class.java)
    /** 文章 Api  */
    private val mArticleApi: ArticleApi = RetrofitUtil.create(ArticleApi::class.java)
    /** 收藏 Api  */
    private val mCollectionApi: CollectionApi = RetrofitUtil.create(CollectionApi::class.java)

    /**
     * 获取首页数据
     * @param page 页码 (从0开始，为了兼容以前的)
     * @param listener 回调监听器
     */
    @SuppressLint("CheckResult")
    fun getHomeDataList(page: Int, onSuccess: onSuccess<HomeDataEntity?>, onFailure: onFailure) {
        if (page == 0) {
            //获取 轮播图数据, 置顶列表 和 第一页的文章列表
            addDisposable(
                Single.zip(
                    mBannerApi.getHomeBannerData(),
                    mArticleApi.getHomeSetToTopList(),
                    mArticleApi.getHomeArticleList(page),
                    Function3<
                        ResultEntity<List<HomeBannerEntity>>,
                        ResultEntity<List<HomeSetToTopItem>>,
                        ResultEntity<HomeArticleEntity>,
                        ResultEntity<HomeDataEntity>
                    > { homeBannerListResult,
                        homeSetToTopItemListResult,
                        homeArticleResult ->

                        val code: Int
                        var msg = ""
                        val homeData = HomeDataEntity()

                        homeBannerListResult.data?.let { homeBannerList ->
                            homeData.homeBannerList = homeBannerList
                        }
                        homeSetToTopItemListResult.data?.let { homeSetToTopItemList ->
                            homeData.homeSetToTopItemList = homeSetToTopItemList
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

                        return@Function3 ResultEntity(code, msg, homeData)
                    }
                )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    if (result.code == SERVER_SUCCESS) {
                        onSuccess(result.data)
                    } else {
                        onFailure(handle(ServerException(result.code, result.msg)))
                    }
                }, { throwable ->
                    onFailure(handle(throwable))
                })
            )
        } else {
            //获取指定页码的文章列表
            addDisposable(
                mArticleApi
                    .getHomeArticleList(page)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ result ->
                        if (result.code == SERVER_SUCCESS) {
                            onSuccess(HomeDataEntity().also { homeData ->
                                result.data?.let { homeArticle ->
                                    homeData.homeArticle = homeArticle
                                }
                            })
                        } else {
                            onFailure(handle(ServerException(result.code, result.msg)))
                        }
                    }, { throwable ->
                        onFailure(handle(throwable))
                    })
            )
        }
    }

    /**
     * 收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun collected(articleId: String, onSuccess: onSuccess<Any?>, onFailure: onFailure) {
        addDisposable(apiRequest(mCollectionApi.collectedInSitesArticle(articleId), onSuccess, onFailure))
    }

    /**
     * 取消收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun uncollected(articleId: String, onSuccess: onSuccess<Any?>, onFailure: onFailure) {
        addDisposable(apiRequest(mCollectionApi.uncollectedInArticleList(articleId), onSuccess, onFailure))
    }

    /**
     * 清除数据
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }
}