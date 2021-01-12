/** 生成的 Java 类名 */
@file:JvmName("ListExt")
package com.shijingfeng.base.common.extension

/**
 * Function: 列表相关 扩展函数
 * Date: 2020/10/31 9:42
 * Description:
 * Author: ShiJingFeng
 */

/**
 * 移动元素
 *
 * @param oldIndex 旧的下标位置
 * @param newIndex 新的下标位置
 * @return true: 移动成功   false: 移动失败(不需移动)
 */
fun <E> MutableList<E>?.move(
    oldIndex: Int,
    newIndex: Int
): Boolean {
    if (this == null || this.size < 2) throw IllegalArgumentException("列表不能为空 且 列表大小必须大于等于2")
    if (oldIndex < 0 || oldIndex > this.size - 1) throw IllegalArgumentException("移动前的索引下标超界")
    if (newIndex < 0 || newIndex > this.size - 1) throw IllegalArgumentException("移动后的索引下标超界")
    if (oldIndex == newIndex) return false

    val e = this[oldIndex]

    if (newIndex > oldIndex) {
        // 向后移动, 应先插后删
        this.add(newIndex, e)
        this.removeAt(oldIndex)
    } else {
        // 向前移动, 应先删后插
        this.removeAt(oldIndex)
        this.add(newIndex, e)
    }
    return true
}

/**
 * 交换元素
 *
 * @param index1 第一个元素的下标位置
 * @param index2 第二个元素的下标位置
 * @return true: 交换成功  false: 交换失败(不需交换)
 */
fun <E> MutableList<E>?.swap(
    index1: Int,
    index2: Int
): Boolean {
    if (this == null || this.size < 2) throw IllegalArgumentException("列表不能为空 且 列表大小必须大于等于2")
    if (index1 < 0 || index1 > this.size - 1) throw IllegalArgumentException("索引下标超界")
    if (index2 < 0 || index2 > this.size - 1) throw IllegalArgumentException("索引下标超界")
    if (index1 == index2) return false

    val e = this[index1]

    this[index1] = this[index2]
    this[index2] = e
    return true
}