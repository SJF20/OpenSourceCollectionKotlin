/** 生成的 Java 类名 */
@file:JvmName("CommonExtension")
package com.shijingfeng.todo.extension

import com.blankj.utilcode.util.GsonUtils
import com.google.gson.JsonParser
import com.shijingfeng.todo.annotation.define.TodoChildType.ITEM_TYPE_IMAGE
import com.shijingfeng.todo.annotation.define.TodoChildType.ITEM_TYPE_TEXT
import com.shijingfeng.todo.constant.JSON_FIELD_DATA
import com.shijingfeng.todo.constant.JSON_FIELD_TYPE
import com.shijingfeng.todo.entity.adapter.TodoChildImageItem
import com.shijingfeng.todo.entity.adapter.TodoChildItem
import com.shijingfeng.todo.entity.adapter.TodoChildTextItem

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
                    val todoChildItemObject = todoChildItemElement.asJsonObject
                    val typeElement = todoChildItemObject.get(JSON_FIELD_TYPE)
                    val dataElement = todoChildItemObject.get(JSON_FIELD_DATA)

                    if (typeElement != null && !typeElement.isJsonNull && typeElement.isJsonPrimitive) {
                        val typePrimitive = typeElement.asJsonPrimitive

                        if (typePrimitive.isNumber) {
                            when (typePrimitive.asInt) {
                                // 文本类型 Item
                                ITEM_TYPE_TEXT -> {
                                    if (dataElement != null && !dataElement.isJsonNull && dataElement.isJsonPrimitive) {
                                        val todoChildTextItem = GsonUtils.getGson().fromJson(dataElement, TodoChildTextItem::class.java)

                                        todoChildItemList.add(todoChildTextItem)
                                    }
                                }
                                // 图片列表类型 Item
                                ITEM_TYPE_IMAGE -> {
                                    if (dataElement != null && !dataElement.isJsonNull && dataElement.isJsonObject) {
                                        val todoChildImageItem = GsonUtils.getGson().fromJson(dataElement, TodoChildImageItem::class.java)

                                        todoChildItemList.add(todoChildImageItem)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        return todoChildItemList
    }
}