package com.shijingfeng.wan_android.source.network.api

import com.shijingfeng.base.common.constant.BASE_URL_NAME_WAN_ANDROID
import com.shijingfeng.base.common.constant.DOMAIN_HEADER
import com.shijingfeng.wan_android.entity.ProjectChildEntity
import com.shijingfeng.wan_android.entity.ProjectIndexEntity
import com.shijingfeng.wan_android.entity.ResultEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Function: 项目相关 Api
 * Date: 20-4-29 下午8:40
 * Description:
 * @author shijingfeng
 */
internal interface ProjectApi {

    /**
     * 获取 项目索引数据
     * @return RxJava Single
     */
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @GET("project/tree/json")
    fun getProjectIndex(): Single<ResultEntity<List<ProjectIndexEntity>>>

    /**
     * 获取 项目二级数据
     * @param page 页码
     * @param id 　项目索引数据 ID
     * @return RxJava Single
     */
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @GET("project/list/{page}/json")
    fun getProjectChild(
        @Path("page") page: Int,
        @Query("cid") id: String
    ): Single<ResultEntity<ProjectChildEntity>>

}