package com.shijingfeng.todo.source.local

import com.shijingfeng.base.base.source.BaseLocalSource

/** 单例实例 */
@Volatile
private var sInstance: MainLocalSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getMainLocalSourceInstance(): MainLocalSource {
    if (sInstance == null) {
        synchronized(MainLocalSource::class.java) {
            if (sInstance == null) {
                sInstance = MainLocalSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 主页 本地源
 * Date: 2020/5/17 16:34
 * Description:
 * @author ShiJingFeng
 */
internal class MainLocalSource : BaseLocalSource() {

    /**
     * 清除数据
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }
}