/** 生成的 Java 类名 */
@file:JvmName("CommonExtension")
package com.shijingfeng.todo.extension

import com.blankj.utilcode.util.GsonUtils
import com.google.gson.JsonParser
import com.shijingfeng.todo.entity.adapter.TodoChildItem

/**
 * Function: 通用 扩展类
 * Date: 2020/9/18 17:18
 * Description:
 * @author ShiJingFeng
 */

/**
 * TodoChild Item列表 序列化
 */
internal fun List<TodoChildItem>.toJson() = GsonUtils.toJson(this)

/**
 * TodoChild Item列表 反序列化
 */
internal fun String.convertToTodoChildItemList(): List<TodoChildItem> {
    val todoChildItemList = mutableListOf<TodoChildItem>()

    if (this.isEmpty()) {
        return todoChildItemList
    }

    try {
        val jsonParser = JsonParser.parseString(this)

        if (jsonParser != null && !jsonParser.isJsonNull && jsonParser.isJsonArray) {
            val rootArray = jsonParser.asJsonArray

            rootArray.forEach { todoChildItemElement ->
                if (todoChildItemElement != null && !todoChildItemElement.isJsonNull && todoChildItemElement.isJsonObject) {
                    todoChildItemElement
                }
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        return todoChildItemList
    }
}