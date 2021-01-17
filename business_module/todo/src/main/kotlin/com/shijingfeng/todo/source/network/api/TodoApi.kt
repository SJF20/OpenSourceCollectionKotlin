package com.shijingfeng.todo.source.network.api

import com.shijingfeng.network.constant.BASE_URL_NAME_WAN_ANDROID
import com.shijingfeng.network.constant.DOMAIN_HEADER
import com.shijingfeng.todo.entity.network.AddTodoEntity
import com.shijingfeng.todo.entity.network.ResultEntity
import com.shijingfeng.todo.entity.network.TodoEntity
import io.reactivex.Single
import retrofit2.http.*

/**
 * Function: 待办事项 相关 Api
 * Date: 2020/5/20 21:38
 * Description:
 * Author: ShiJingFeng
 */
internal interface TodoApi {

    /**
     * 获取 待办事项 数据
     *
     * @param page 页码
     * @param postMap 查询携带的参数
     * @return Single<ResultEntity>
     */
    @JvmSuppressWildcards //Java和Kotlin交互问题: 防止 Map<String, Any> 解析成 Map<String, ?>
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @GET("lg/todo/v2/list/{page}/json")
    fun getTodoData(
        @Path("page") page: Int,
        @QueryMap postMap: Map<String, Any>
    ): Single<ResultEntity<TodoEntity>>

    /**
     * 删除
     *
     * @param id ID
     */
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @POST("lg/todo/delete/{id}/json")
    fun remove(
        @Path("id") id: String
    ): Single<ResultEntity<Any>>

    /**
     * 更新状态
     *
     * @param id ID
     * @param status 状态 0或1，传1代表未完成到已完成，反之则反之。
     */
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @FormUrlEncoded
    @POST("lg/todo/done/{id}/json")
    fun updateStatus(
        @Path("id") id: String,
        @Field("status") status: Int
    ): Single<ResultEntity<Any>>

    /**
     * 添加 待办事项
     *
     * @param postMap 携带的参数
     */
    @JvmSuppressWildcards //Java和Kotlin交互问题: 防止 Map<String, Any> 解析成 Map<String, ?>
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @FormUrlEncoded
    @POST("lg/todo/add/json")
    fun addTodo(
        @FieldMap postMap: Map<String, Any>
    ): Single<ResultEntity<AddTodoEntity>>

}