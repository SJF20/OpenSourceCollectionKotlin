package com.shijingfeng.base.base.source

import com.shijingfeng.base.util.cast

/**
 * Function: 本地资源 基类
 * Date: 2020/1/17 19:24
 * Description:
 * Author: ShiJingFeng
 */
abstract class BaseLocalSource {

    /**
     * 获取子类类型实例
     * @param <T> 泛型
     * @return 子类类型实例
     */
    fun <T : BaseLocalSource> get() : T = cast(this)

    /**
     * 清除数据
     */
    open fun onCleared() {}

}