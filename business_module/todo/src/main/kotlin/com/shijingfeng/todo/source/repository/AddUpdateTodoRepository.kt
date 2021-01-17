package com.shijingfeng.todo.source.repository

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.network.extension.onFailure
import com.shijingfeng.network.extension.onSuccess
import com.shijingfeng.todo.entity.network.AddTodoEntity
import com.shijingfeng.todo.source.network.AddUpdateTodoNetworkSource

/** 单例实例 */
@Volatile
private var sInstance: AddUpdateTodoRepository? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getAddUpdateTodoRepositoryInstance(
    networkSource: AddUpdateTodoNetworkSource? = null
): AddUpdateTodoRepository {
    if (sInstance == null) {
        synchronized(AddUpdateTodoRepository::class.java) {
            if (sInstance == null) {
                sInstance = AddUpdateTodoRepository(
                    networkSource = networkSource
                )
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 添加 待办事项 仓库
 * Date: 2020/9/17 10:37
 * Description:
 * Author: ShiJingFeng
 */
internal class AddUpdateTodoRepository(
    networkSource: AddUpdateTodoNetworkSource? = null
) : BaseRepository<BaseLocalSource, AddUpdateTodoNetworkSource>(
    mNetworkSource = networkSource
) {

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
    ) = mNetworkSource?.addTodo(postMap, onSuccess, onFailure)

    /**
     * 销毁回调
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }
}