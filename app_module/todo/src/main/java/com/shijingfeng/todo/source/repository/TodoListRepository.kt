package com.shijingfeng.todo.source.repository

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.todo.entity.network.TodoEntity
import com.shijingfeng.todo.source.network.TodoListNetworkSource

/** 单例实例 */
@Volatile
private var sInstance: TodoListRepository? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getTodoListRepositoryInstance(
    networkSource: TodoListNetworkSource? = null
): TodoListRepository {
    if (sInstance == null) {
        synchronized(TodoListRepository::class.java) {
            if (sInstance == null) {
                sInstance = TodoListRepository(
                    networkSource = networkSource
                )
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 主页 -> 待办 仓库
 * Date: 2020/5/17 16:33
 * Description:
 * @author ShiJingFeng
 */
internal class TodoListRepository(
    networkSource: TodoListNetworkSource? = null
) : BaseRepository<BaseLocalSource, TodoListNetworkSource>(
    mNetworkSource = networkSource
) {

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
        mNetworkSource?.getTodoData(page, postMap, onSuccess, onFailure)
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
        mNetworkSource?.remove(id, onSuccess, onFailure)
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
        mNetworkSource?.updateStatus(id, status, onSuccess, onFailure)
    }

    /**
     * 销毁回调
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }
}