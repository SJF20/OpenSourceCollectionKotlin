package com.shijingfeng.base.base.repository

import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.base.util.cast

/**
 * Function: Repository基类
 * Date: 2020/1/17 19:20
 * Description:
 * Author: ShiJingFeng
 */
abstract class BaseRepository<L : BaseLocalSource, N : BaseNetworkSource>(
    // 本地源
    protected var mLocalSource: L? = null,
    // 网络源
    protected var mNetworkSource: N? = null
) {

//    /**
//     * 设置本地源
//     * @param localSource 本地源
//     * @param <T> 泛型
//     * @return Repository
//     */
//    fun <T : BaseRepository<L, N>> setLocalSource(localSource: L) : T {
//        this.mLocalSource = localSource
//        return cast(this)
//    }
//
//    /**
//     * 设置网络源
//     * @param networkSource 网络源
//     * @param <T> 泛型
//     * @return Repository
//     */
//    fun <T : BaseRepository<L, N>> setNetworkSource(networkSource: N) : T {
//        this.mNetworkSource = networkSource
//        return cast(this)
//    }

    /**
     * 获取子类类型实例
     * @param <T> 泛型
     * @return 子类类型实例
     */
    fun <T : BaseRepository<L, N>> get() : T {
        return cast(this)
    }

    /**
     * 销毁回调
     */
    open fun onCleared() {
        //调用本地源销毁回调
        mLocalSource?.onCleared()
        //调用网络源销毁回调
        mNetworkSource?.onCleared()
    }

}