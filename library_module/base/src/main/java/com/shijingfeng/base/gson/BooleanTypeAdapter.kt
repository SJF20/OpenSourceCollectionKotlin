package com.shijingfeng.base.gson

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter

/**
 * Function: Gson Int 类型 适配器
 * Date: 2020/5/16 22:14
 * Description:
 * @author ShiJingFeng
 */
class BooleanTypeAdapter : TypeAdapter<Boolean>() {

    /**
     * Writes one JSON value (an array, object, string, number, boolean or null)
     * for `value`.
     *
     * @param value the Java object to write. May be null.
     */
    override fun write(writer: JsonWriter, value: Boolean?) {
        writer.value(value)
    }

    /**
     * Reads one JSON value (an array, object, string, number, boolean or null)
     * and converts it to a Java object. Returns the converted object.
     *
     * @return the converted Java object. May be null.
     */
    override fun read(reader: JsonReader): Boolean {
        return when (reader.peek()) {
            JsonToken.NULL -> {
                reader.nextNull()
                false
            }
            else -> reader.nextBoolean()
        }
    }
}