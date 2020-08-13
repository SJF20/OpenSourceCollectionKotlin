/** 生成的 Java 类名 */
@file:JvmName("Extension")
package com.shijingfeng.skin_changer.global

/**
 * Function: 扩展函数, 别名 等扩展操作
 * Date: 2020/7/22 15:20
 * Description:
 * @author ShiJingFeng
 */

/**
 * 扩展函数 如果列表中没有该元素，则可以添加
 */
internal fun <E> MutableList<E>.addIfNotExist(e: E) {
    if (e == null) {
        return
    }
    if (!this.contains(e)) {
        this.add(e)
    }
}