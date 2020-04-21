package com.shijingfeng.wan_android.source.network.api

import com.shijingfeng.base.common.constant.BASE_URL_NAME_WAN_ANDROID
import com.shijingfeng.base.common.constant.DOMAIN_HEADER
import com.shijingfeng.wan_android.entity.network.KnowledgeClassifyEntity
import com.shijingfeng.wan_android.entity.network.NavigationClassifyEntity
import com.shijingfeng.wan_android.entity.network.ResultEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

/**
 * Function: 分类 Api
 * Date: 2020/2/12 10:28
 * Description:
 * @author ShiJingFeng
 */
internal interface ClassifyApi {

    /**
     * 获取 分类 -> 知识体系 数据
     * @return Single<ResultEntity>
     */
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @GET("tree/json")
    fun getKnowledgeClassifyList(): Single<ResultEntity<List<KnowledgeClassifyEntity>>>

    /**
     * 获取 分类 -> 导航分类 数据
     * @return Single<ResultEntity>
     */
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @GET("navi/json")
    fun getNavigationClassifyList(): Single<ResultEntity<List<NavigationClassifyEntity>>>

}