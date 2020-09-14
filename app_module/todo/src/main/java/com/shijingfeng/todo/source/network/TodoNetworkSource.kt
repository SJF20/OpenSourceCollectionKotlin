package com.shijingfeng.todo.source.network

import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.base.util.RetrofitUtil
import com.shijingfeng.todo.entity.TodoEntity
import com.shijingfeng.todo.source.network.api.TodoApi
import com.shijingfeng.todo.util.apiRequest
import kotlin.math.sin

/** 单例实例 */
@Volatile
private var sInstance: TodoNetworkSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getTodoNetworkSourceInstance(): TodoNetworkSource {
    if (sInstance == null) {
        synchronized(TodoNetworkSource::class.java) {
            if (sInstance == null) {
                sInstance = TodoNetworkSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 主页 -> 待办 网络源
 * Date: 2020/5/20 21:34
 * Description:
 * @author ShiJingFeng
 */
internal class TodoNetworkSource : BaseNetworkSource() {

    /** 待办事项 相关 Api */
    private val mTodoApi = RetrofitUtil.create(TodoApi::class.java)

    /**
     * 获取 待办事项 数据
     *
     * @param page 页码
     * @param postMap 查询携带的参数
     * @param onSuccess 成功回调
     * @param onFailure 失败回调
     */
    fun getTodoData(
        page: Int,
        postMap: Map<String, Any>,
        onSuccess: onSuccess<TodoEntity?>,
        onFailure: onFailure
    ) {
        addDisposable(apiRequest(
            single = mTodoApi.getTodoData(page, postMap),
            onSuccess = onSuccess,
            onFailure = onFailure
        ))
    }

    /**
     * 删除
     * @param id ID
     */
    fun remove(
        id: String,
        onSuccess: onSuccess<Any?>,
        onFailure: onFailure
    ) {
        addDisposable(apiRequest(
            single = mTodoApi.remove(id),
            onSuccess = onSuccess,
            onFailure = onFailure
        ))
    }

    /**
     * 更新状态
     * @param id ID
     * @param status 状态 0或1，传1代表未完成到已完成，反之则反之。
     */
    fun updateStatus(
        id: String,
        status: Int,
        onSuccess: onSuccess<Any?>,
        onFailure: onFailure
    ) {
        addDisposable(apiRequest(
            single = mTodoApi.updateStatus(id, status),
            onSuccess = onSuccess,
            onFailure = onFailure
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