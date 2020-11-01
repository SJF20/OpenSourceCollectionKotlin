package com.shijingfeng.weather.api

import com.shijingfeng.base.common.constant.*
import com.shijingfeng.weather.entity.CitySearchEntity
import com.shijingfeng.weather.entity.InverseGeocodeEntity
import com.shijingfeng.weather.entity.Weather
import io.reactivex.Single
import retrofit2.http.*

/**
 * Function: 城市搜索 Api
 * Date: 2020/10/27 14:57
 * Description:
 * @author ShiJingFeng
 */
internal interface CitySearchApi {

    /**
     * 城市搜索
     */
    @JvmSuppressWildcards //Java和Kotlin交互问题: 防止 Map<String, Any> 解析成 Map<String, ?>
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_AMAP_CITY_SEARCH)
    @GET("config/district")
    fun search(
        @QueryMap dataMap: Map<String, Any>
    ): Single<CitySearchEntity>

    /**
     * 通过经纬度查询地址 (可批量查询，一次最多20个)
     *
     * @param key 高德服务端Api Key
     * @param location 经纬度, 可批量查询，一次最多20个  格式例子: "经度,纬度|经度,纬度"
     * @param extensions 返回结果控制 extensions 参数默认取值是 base，也就是返回基本地址信息；extensions 参数取值为 all 时会返回基本地址信息、附近 POI 内容、道路信息以及道路交叉口信息。
     * @param batch batch 参数设置为 true 时进行批量查询操作，最多支持 20 个经纬度点进行批量地址查询操作。batch 参数设置为 false 时进行单点查询，此时即使传入多个经纬度也只返回第一个经纬度的地址解析查询结果。
     * @param output 可选输入内容包括：JSON，XML。设置 JSON 返回结果数据将会以JSON结构构成；如果设置 XML 返回结果数据将以 XML 结构构成。
     */
    @JvmSuppressWildcards //Java和Kotlin交互问题: 防止 Map<String, Any> 解析成 Map<String, ?>
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_AMAP_CITY_SEARCH)
    @GET("geocode/regeo")
    fun getAddressByLngLat(
        @Query("key") key: String = AMAP_SERVICE_KEY,
        @Query("location") lngLatBatchStr: String,
        @Query("extensions") extensions: String = "base",
        @Query("batch") batch: Boolean = true,
        @Query("output") output: String = "JSON"
    ): Single<InverseGeocodeEntity>

    /**
     * 获取天气数据
     *
     * @param token 彩云天气 Token
     * @param longitude 经度
     * @param latitude 纬度
     */
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WEATHER)
    @GET("{token}/{longitude},{latitude}/weather.json")
    fun getWeatherData(
        @Path("token") token: String = CAI_YUN_WEATHER_KEY,
        @Path("longitude") longitude: Double,
        @Path("latitude") latitude: Double
    ): Single<Weather>

}