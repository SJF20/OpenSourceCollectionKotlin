package com.shijingfeng.base.util

/**
 * Function: 资源工具类
 * Date: 2020/2/2 21:25
 * Description:
 * @author ShiJingFeng
 */

/**
 * 通过发射获取资源ID
 * @param variableName 资源ID 名称
 * @param cls 资源ID 类型
 * @return 资源ID
 */
fun getResId(variableName: String, cls: Class<*>): Int {
    return try {
        val idField = cls.getDeclaredField(variableName)

        idField.getInt(idField)
    } catch (e: NoSuchFieldException) {
        e.printStackTrace()
        0
    } catch (e: IllegalAccessException) {
        e.printStackTrace()
        0
    }
}