/** 生成的 Java 类名 */
@file:JvmName("JsonUtil")
package com.shijingfeng.base.util

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.shijingfeng.base.gson.TypeHandleAdapterFactory
import java.lang.reflect.Type

/**
 * Function: Json转换工具类
 * Date: 2020/1/29 9:57
 * Description:
 * Author: ShiJingFeng
 */

/** Gson实例  */
val gson by lazy { initGson() }

/**
 * 初始化 Gson
 * @return 获得 Gson
 */
private fun initGson(): Gson {
    return GsonBuilder()
        //允许超长字符串
        .setLenient()
        //禁止转码
        .disableHtmlEscaping()
        //支持Map的key为复杂对象的形式
        .enableComplexMapKeySerialization()
        //智能解决 NULL
        .serializeNulls()
        //美化格式打印
        .setPrettyPrinting()
        //Gson 类型处理 Factory (用于空处理，类型纠正)
        .registerTypeAdapterFactory(TypeHandleAdapterFactory())
        .create()
}

/**
 * 将对象准换为json字符串
 * @param any 要序列化的对象
 * @param <T> 对象类型
 * @return Json序列化字符串
 */
fun <T> serialize(any: T?): String {
    if (any == null) {
        return ""
    }
    return gson.toJson(any)
}

/**
 * 将json字符串转换为对象
 * @param json Json字符串
 * @param type 对象类型
 * @param <T> 对象泛型类型
 * @return 对象
 */
fun <T> deserialize(json: String, type: Type): T {
    return gson.fromJson(json, type)
}

/**
 * 将json字符串转换为对象
 * @param json Json字符串
 * @param clz 对象类型
 * @param <T> 对象泛型类型
 * @return 对象
 */
fun <T> deserialize(json: String, clz: Class<T>): T {
    return gson.fromJson(json, clz)
}