package com.shijingfeng.base.gson

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken
import com.shijingfeng.base.util.cast

/**
 * Function: Gson 类型处理 Factory (用于空处理，类型纠正)
 * Date: 2020/5/16 22:09
 * Description:
 * @author ShiJingFeng
 */
class TypeHandleAdapterFactory : TypeAdapterFactory {

    /**
     * 创建 TypeAdapter
     * @param gson Gson
     * @param type TypeToken
     */
    override fun <T : Any?> create(gson: Gson?, typeToken: TypeToken<T>?): TypeAdapter<T>? {
        return when (typeToken?.rawType) {
            String::class.java -> cast(StringTypeAdapter())
            Int::class.java -> cast(IntTypeAdapter())
            Boolean::class.java -> cast(BooleanTypeAdapter())
            else -> null
        }
    }
}