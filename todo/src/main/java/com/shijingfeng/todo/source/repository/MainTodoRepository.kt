package com.shijingfeng.todo.source.repository

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.todo.entity.Todo
import com.shijingfeng.todo.source.local.MainLocalSource
import com.shijingfeng.todo.source.network.MainNetworkSource
import com.shijingfeng.todo.source.network.MainTodoNetworkSource
import com.shijingfeng.todo.util.apiRequest

/** 单例实例 */
@Volatile
private var sInstance: MainTodoRepository? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getMainTodoRepositoryInstance(
    networkSource: MainTodoNetworkSource? = null
): MainTodoRepository {
    if (sInstance == null) {
        synchronized(MainTodoRepository::class.java) {
            if (sInstance == null) {
                sInstance = MainTodoRepository(
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
internal class MainTodoRepository(
    networkSource: MainTodoNetworkSource? = null
) : BaseRepository<BaseLocalSource, MainTodoNetworkSource>(
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
        onSuccess: onSuccess<Todo?>,
        onFailure: onFailure
    ) {
        mNetworkSource?.getTodoData(page, postMap, onSuccess, onFailure)
    }

    /**
     * 销毁回调
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }
}