package com.shijingfeng.todo.source.network

import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.base.util.RetrofitUtil
import com.shijingfeng.todo.entity.Todo
import com.shijingfeng.todo.source.network.api.TodoApi
import com.shijingfeng.todo.util.apiRequest

/** 单例实例 */
@Volatile
private var sInstance: MainTodoNetworkSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getMainTodoNetworkSourceInstance(): MainTodoNetworkSource {
    if (sInstance == null) {
        synchronized(MainTodoNetworkSource::class.java) {
            if (sInstance == null) {
                sInstance = MainTodoNetworkSource()
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
internal class MainTodoNetworkSource : BaseNetworkSource() {

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
        onSuccess: onSuccess<Todo?>,
        onFailure: onFailure
    ) {
        addDisposable(apiRequest(
            single = mTodoApi.getTodoData(page, postMap),
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