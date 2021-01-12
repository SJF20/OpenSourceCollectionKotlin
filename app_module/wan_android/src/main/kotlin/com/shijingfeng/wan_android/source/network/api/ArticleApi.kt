package com.shijingfeng.wan_android.source.network.api

import com.shijingfeng.base.common.constant.BASE_URL_NAME_WAN_ANDROID
import com.shijingfeng.base.common.constant.DOMAIN_HEADER
import com.shijingfeng.wan_android.entity.adapter.HomeTopArticleItem
import com.shijingfeng.wan_android.entity.HomeArticleEntity
import com.shijingfeng.wan_android.entity.KnowledgeClassifyDetailChildEntity
import com.shijingfeng.wan_android.entity.ResultEntity
import com.shijingfeng.wan_android.view_model.HOME_FIRST_PAGE
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Function: 文章 API
 * Date: 2020/2/12 10:29
 * Description:
 * Author: ShiJingFeng
 */
internal interface ArticleApi {

    /**
     * 获取 首页置顶文章 列表
     * @return Single<ResultEntity>
     */
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @GET("article/top/json")
    fun getHomeTopArticleList(): Single<ResultEntity<List<HomeTopArticleItem>>>

    /**
     * 获取 首页文章 列表
     * @param page 页码 (从 [HOME_FIRST_PAGE] 开始，为了兼容旧版本)
     * @return Single<ResultEntity>
     */
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @GET("article/list/{page}/json")
    fun getHomeArticleList(@Path("page") page: Int): Single<ResultEntity<HomeArticleEntity>>

    /**
     * 获取 知识体系 二级数据 列表
     * @param page 页码 (为了兼容以前的, 从0开始)
     * @param id 二级数据 ID
     * @return Single<ResultEntity>
     */
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @GET("article/list/{page}/json")
    fun getKnowledgeClassifyChildList(
        @Path("page") page: Int,
        @Query("cid") id: String
    ): Single<ResultEntity<KnowledgeClassifyDetailChildEntity>>

}