package com.shijingfeng.network.http.factory;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Function: 自定义 Retrofit Gson 转换Factory
 * Author: ShiJingFeng
 * Date: 2019/10/11 12:42
 * Description:
 * @author ShiJingFeng
 */
public final class CustomGsonConverterFactory extends Converter.Factory {

    private final Gson mGson;

    private CustomGsonConverterFactory(Gson mGson) {
        if (mGson == null) {
            final String errorTips = "mGson不能为空";

            throw new NullPointerException(errorTips);
        }
        this.mGson = mGson;
    }

    public static CustomGsonConverterFactory create() {
        return create(new Gson());
    }

    public static CustomGsonConverterFactory create(Gson gson) {
        return new CustomGsonConverterFactory(gson);
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        TypeAdapter<?> adapter = mGson.getAdapter(TypeToken.get(type));
        return new CustomGsonResponseBodyConverter<>(mGson, adapter);
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        TypeAdapter<?> adapter = mGson.getAdapter(TypeToken.get(type));
        return new CustomGsonRequestBodyConverter<>(mGson, adapter);
    }
}
