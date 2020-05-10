@file:JvmName("EntityUtil")
package com.shijingfeng.base.util

import android.text.TextUtils
import com.shijingfeng.base.base.entity.BaseEntity

/**
 * Function: 实体操作 工具类
 * Date: 2020/3/28 9:44
 * Description:
 * @author ShiJingFeng
 */

/**
 * 通过 ID 获取 索引
 * @param id ID
 * @param dataList 数据列表
 * @return 索引
 */
fun <T : BaseEntity> getPositionById(id: String, dataList: List<T>): Int {
    if (TextUtils.isEmpty(id)) {
        return -1
    }
    val size = dataList.size

    for (i in 0 until size) {
        val data = dataList[i]
        val currentId: String = data.getId()

        if (id == currentId) {
            return i
        }
    }
    return -1
}