package com.shijingfeng.base.gson

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter

/**
 * Function: Gson String 类型 适配器
 * Date: 2020/5/16 22:00
 * Description:
 * Author: ShiJingFeng
 */
class StringTypeAdapter : TypeAdapter<String>() {

    /**
     * 序列化
     */
    override fun write(writer: JsonWriter, value: String?) {
        writer.value(value)
    }

    /**
     * 反序列化
     */
    override fun read(reader: JsonReader): String {
        return when (reader.peek()) {
            JsonToken.NULL -> {
                reader.nextNull()
                ""
            }
            else -> reader.nextString()
        }
    }
}