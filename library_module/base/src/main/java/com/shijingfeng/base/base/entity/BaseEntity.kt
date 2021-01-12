package com.shijingfeng.base.base.entity

import com.shijingfeng.base.util.*

/**
 * Function: 实体类基类
 * Author: ShiJingFeng
 * Date: 2019/11/14 10:43
 * Description:
 * Author: ShiJingFeng
 */
abstract class BaseEntity {

    /**
     * 获取ID
     * @return ID
     */
    open fun getId() = ""

    /**
     * 获取子类
     * @param <T> 子类类型
     * @return 子类
     */
    fun <T : BaseEntity> get(): T = cast(this)

}
