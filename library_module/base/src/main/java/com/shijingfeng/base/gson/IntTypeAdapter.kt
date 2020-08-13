package com.shijingfeng.base.gson

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter

/**
 * Function: Gson Int 类型 适配器
 * Date: 2020/5/16 22:05
 * Description:
 * @author ShiJingFeng
 */
class IntTypeAdapter : TypeAdapter<Int>() {

    /**
     * 序列化
     */
    override fun write(writer: JsonWriter?, value: Int?) {
        writer?.value(value)
    }

    /**
     * 反序列化
     */
    override fun read(reader: JsonReader): Int {
        return when (reader.peek()) {
            JsonToken.NULL -> {
                reader.nextNull()
                return 0
            }
            else -> reader.nextInt()
        }
    }

}