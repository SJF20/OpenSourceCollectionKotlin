/** 生成的 Java 类名 */
@file:JvmName("Extension")
package com.shijingfeng.skin_changer.global

import android.view.View
import com.shijingfeng.skin_changer.entity.SkinAttribute
import org.json.JSONObject
import java.lang.StringBuilder
import kotlin.Exception

/**
 * Function: 扩展函数, 别名 等扩展操作
 * Date: 2020/7/22 15:20
 * Description:
 * @author ShiJingFeng
 */

/**
 * 自定义处理主题资源更换逻辑
 *
 * @param view 当前解析的View
 * @param skinAttribute 当前解析的属性实体
 * @return true: 自定义处理  false: 框架处理
 */
internal typealias ExecuteListener = (view: View, skinAttribute: SkinAttribute) -> Boolean

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

/**
 * 序列化 (List<SkinAttribute 转 Json字符串)
 */
internal fun List<SkinAttribute>.toJsonString(): String {
    val stringBuilder = StringBuilder()
    var b = false

    stringBuilder.append("{ ")
    this.forEach { skinAttribute ->
        if (b) stringBuilder.append(", ") else b = true

        stringBuilder.run {
            append("\"")
            append(skinAttribute.name)
            append("\": \"")
            append(skinAttribute.data)
            append("\"")
        }
    }
    stringBuilder.append(" }")

    return stringBuilder.toString()
}

/**
 * 反序列化 (Json字符串 转 Map对象)
 */
internal fun String.toMapObject(): Map<String, String> {
    val dataMap = mutableMapOf<String, String>()

    if (this.isEmpty()) {
       return dataMap
    }
    try {
        val jsonObject = JSONObject(this)

        jsonObject.keys().forEach { key ->
            dataMap[key] = jsonObject.getString(key)
        }
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        return dataMap
    }
}

/**
 * 反序列化 (Json字符串 转 List<SkinAttribute>)
 */
internal fun String.toSkinAttributeList(): List<SkinAttribute> {
    val skinAttributeList = mutableListOf<SkinAttribute>()

    if (this.isEmpty()) {
        return skinAttributeList
    }
    try {
        val jsonObject = JSONObject(this)

        jsonObject.keys().forEach { key ->
            skinAttributeList.add(SkinAttribute(key, jsonObject.getString(key)))
        }
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        return skinAttributeList
    }
}