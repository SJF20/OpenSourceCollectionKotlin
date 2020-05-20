package com.shijingfeng.todo.source.network.api

import com.shijingfeng.base.common.constant.BASE_URL_NAME_WAN_ANDROID
import com.shijingfeng.base.common.constant.DOMAIN_HEADER
import com.shijingfeng.todo.entity.ResultEntity
import com.shijingfeng.todo.entity.Todo
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.QueryMap

/**
 * Function: 待办事项 相关 Api
 * Date: 2020/5/20 21:38
 * Description:
 * @author ShiJingFeng
 */
internal interface TodoApi {

    /**
     * 获取 待办事项 数据
     *
     * @param page 页码
     * @param postMap 查询携带的参数
     * @return Single<ResultEntity>
     */
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @GET("lg/todo/v2/list/{page}/json")
    fun getTodoData(
        @Path("page") page: Int,
        @QueryMap postMap: Map<String, Any>? = null
    ): Single<ResultEntity<Todo>>

}