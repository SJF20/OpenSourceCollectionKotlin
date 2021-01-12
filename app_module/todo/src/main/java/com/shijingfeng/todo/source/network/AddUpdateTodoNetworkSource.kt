package com.shijingfeng.todo.source.network

import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.base.util.RetrofitUtil
import com.shijingfeng.todo.entity.network.AddTodoEntity
import com.shijingfeng.todo.source.network.api.TodoApi
import com.shijingfeng.todo.util.apiRequest

/** 单例实例 */
@Volatile
private var sInstance: AddUpdateTodoNetworkSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getAddUpdateTodoNetworkSourceInstance(): AddUpdateTodoNetworkSource {
    if (sInstance == null) {
        synchronized(AddUpdateTodoNetworkSource::class.java) {
            if (sInstance == null) {
                sInstance = AddUpdateTodoNetworkSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 添加 待办事项 网络源
 * Date: 2020/5/20 21:34
 * Description:
 * Author: ShiJingFeng
 */
internal class AddUpdateTodoNetworkSource : BaseNetworkSource() {

    /** 待办事项 相关 Api */
    private val mTodoApi = RetrofitUtil.create(TodoApi::class.java)

    /**
     * 添加 待办事项
     *
     * @param postMap 携带的参数
     * @param onSuccess 成功回调
     * @param onFailure 失败回调
     */
    fun addTodo(
        postMap: Map<String, Any>,
        onSuccess: onSuccess<AddTodoEntity?>,
        onFailure: onFailure
    ) = addDisposable(apiRequest(
        single = mTodoApi.addTodo(postMap),
        onSuccess = onSuccess,
        onFailure = onFailure
    ))

    /**
     * 清除数据
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }

}