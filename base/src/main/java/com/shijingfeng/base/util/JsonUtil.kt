package com.shijingfeng.base.util

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.lang.reflect.Type

/**
 * Function: Json转换工具类
 * Date: 2020/1/29 9:57
 * Description:
 * @author ShiJingFeng
 */
class JsonUtil {

    companion object {

        /** Gson实例  */
        @Volatile
        private var sGson: Gson? = null

        /**
         * 获取 Gson 单例 (DCL双重检查模式)
         * @return Gson 单例
         */
        fun getGson(): Gson {
            if (sGson == null) {
                synchronized(JsonUtil::class.java) {
                    if (sGson == null) {
                        sGson = initGson()
                    }
                }
            }
            return sGson as Gson
        }

        /**
         * 初始化 Gson
         * @return 获得 Gson
         */
        private fun initGson(): Gson {
            return GsonBuilder() //允许超长字符串
                .setLenient() //禁止转码
                .disableHtmlEscaping() //支持Map的key为复杂对象的形式
                .enableComplexMapKeySerialization() //智能解决 NULL
                .serializeNulls() //美化格式打印
                .setPrettyPrinting()
                .create()
        }

        /**
         * 将对象准换为json字符串
         * @param object 要序列化的对象
         * @param <T> 对象类型
         * @return Json序列化字符串
         */
        fun <T> serialize(any: T): String {
            return getGson().toJson(any)
        }

        /**
         * 将json字符串转换为对象
         * @param json Json字符串
         * @param type 对象类型
         * @param <T> 对象泛型类型
         * @return 对象
         */
        fun <T> deserialize(json: String, type: Type): T {
            return getGson().fromJson(json, type)
        }

        /**
         * 将json字符串转换为对象
         * @param json Json字符串
         * @param clz 对象类型
         * @param <T> 对象泛型类型
         * @return 对象
         */
        fun <T> deserialize(json: String, clz: Class<T>): T {
            return getGson().fromJson(json, clz)
        }

    }

}