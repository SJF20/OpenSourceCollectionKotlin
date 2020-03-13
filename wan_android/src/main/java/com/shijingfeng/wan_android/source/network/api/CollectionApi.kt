package com.shijingfeng.wan_android.source.network.api

import com.shijingfeng.base.base.entity.BaseEntity
import com.shijingfeng.base.common.constant.BASE_URL_NAME_WAN_ANDROID
import com.shijingfeng.base.common.constant.DOMAIN_HEADER
import com.shijingfeng.wan_android.entity.network.ArticleCollectedListEntity
import com.shijingfeng.wan_android.entity.network.ResultEntity
import io.reactivex.Single
import retrofit2.http.*

/**
 * Function: 收藏 API
 * Date: 2020/2/12 10:31
 * Description:
 * @author ShiJingFeng
 */
interface CollectionApi {

    /**
     * 获取文章收藏列表
     * @param page 页码 (从 0 开始)
     * @return RxJava Single
     */
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @GET("lg/collect/list/{page}/json")
    fun getArticleCollectedList(@Path("page") page: Int): Single<ResultEntity<ArticleCollectedListEntity>>

    /**
     * 收藏站内文章
     * @param articleId 文章ID
     * @return RxJava Single
     */
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @POST("lg/collect/{articleId}/json")
    fun collectedInSitesArticle(@Path("articleId") articleId: String): Single<ResultEntity<Any>>

    /**
     * 收藏站外文章
     * @param postMap 请求参数集合  title，author，link
     * @return RxJava Single
     */
    @JvmSuppressWildcards //Java和Kotlin交互问题: 防止 Map<String, Any> 解析成 Map<String, ?>
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @FormUrlEncoded
    @POST("lg/collect/add/json")
    fun collectedOutSitesArticle(@FieldMap postMap: Map<String, Any>): Single<ResultEntity<Any>>

    /**
     * 文章列表中的文章 取消收藏
     * @param articleId 文章ID
     * @return RxJava Single
     */
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @POST("lg/uncollect_originId/{articleId}/json")
    fun uncollectedInArticleList(@Path("articleId") articleId: String): Single<ResultEntity<Any>>

    /**
     * 收藏列表中 取消收藏
     * @param articleId 文章ID
     * @param originId 列表页下发，无则为-1
     * @return RxJava Single
     */
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @FormUrlEncoded
    @POST("lg/uncollect/{articleId}/json")
    fun uncollectedInCollectedList(
        @Path("articleId") articleId: String,
        @Field("originId") originId: String
    ): Single<ResultEntity<Any>>

}