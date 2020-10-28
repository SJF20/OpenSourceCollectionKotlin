package com.shijingfeng.weather.entity

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import com.shijingfeng.base.base.entity.BaseEntity
import java.lang.Exception

/**
 * Function: 城市查询 实体类
 * Date: 2020/10/26 15:43
 * Description:
 * @author ShiJingFeng
 */
/**
 * 城市查询实体
 */
internal data class CitySearchEntity(

    @SerializedName("status")
    val status: String = "0",

    @SerializedName("info")
    val info: String = "",

    @SerializedName("infocode")
    val infoCode: String = "0",

    @SerializedName("count")
    val count: String = "0",

    @SerializedName("districts")
    val districts: List<CitySearchInfoEntity> = emptyList()

) : BaseEntity()

/**
 * 城市搜索信息数据
 */
internal data class CitySearchInfoEntity(

    /** 城市编码, 省级(省, 自治区)是数组, 其他(直辖市, 特别行政区, 台湾省, 外国)是字符串, 需判断 是 JsonArray 还是 JsonPrimitive */
    @SerializedName("citycode")
    private val cityCodeElement: JsonElement,

    /** 区域编码 注: 不是邮政编码, 街道没有独有的adCode，均继承父类（区县）的adCode */
    @SerializedName("adcode")
    val adCode: String = "",

    /** 行政区名称 */
    @SerializedName("name")
    val name: String = "",

    /** 区域中心点 外国是数组(JsonArray), 其他是字符串(JsonPrimitive)  例子: "经度,纬度" */
    @SerializedName("center")
    private val center: JsonElement,

    /**
     * 行政区划级别
     * country:国家
     * province:省份（直辖市会在province和city显示）
     * city:市（直辖市会在province和city显示）
     * district:区县
     * street:街道
     */
    @SerializedName("level")
    val level: String = "",

    /** 下一级 */
    @SerializedName("districts")
    val districts: List<CitySearchInfoEntity> = emptyList()

) : BaseEntity() {

    companion object {
        /** 地区级别: 国家 */
        internal const val DISTRICTS_COUNTRY = "country"
        /** 地区级别: 省，直辖市，自治区，特别行政区，台湾省 */
        internal const val DISTRICTS_PROVINCE = "province"
        /** 地区级别: 地级市 */
        internal const val DISTRICTS_CITY = "city"
        /** 地区级别: 市区(包括直辖市和省会), 县级市, 县 */
        internal const val DISTRICTS_DISTRICT = "district"
        /** 地区级别: 乡, 镇 */
        internal const val DISTRICTS_STREET = "street"
    }

    /**
     * 获取 cityCode
     */
    val cityCode: String by lazy {
        if (cityCodeElement.isJsonPrimitive) {
            val jsonPrimitive = cityCodeElement.asJsonPrimitive

            if (jsonPrimitive.isString) {
                jsonPrimitive.asString
            } else if (jsonPrimitive.isNumber) {
                jsonPrimitive.asNumber.toString()
            }
        }
        ""
    }

    /**
     * 获取经度
     */
    val longitude: Double by lazy {
        try {
            var lngLat = emptyList<String>()

            if (center.isJsonPrimitive) {
                val jsonPrimitive = center.asJsonPrimitive

                if (jsonPrimitive.isString) {
                    val str = jsonPrimitive.asString

                    if (str.isNotEmpty()) {
                        lngLat = str.split(",")
                    }
                }
            }
            if (lngLat.isNotEmpty()) {
                lngLat[0].toDouble()
            } else {
                0.0
            }
        } catch (e: Exception) {
            0.0
        }
    }

    /**
     * 获取纬度
     */
    val latitude: Double by lazy {
        try {
            var lngLat = emptyList<String>()

            if (center.isJsonPrimitive) {
                val jsonPrimitive = center.asJsonPrimitive

                if (jsonPrimitive.isString) {
                    val str = jsonPrimitive.asString

                    if (str.isNotEmpty()) {
                        lngLat = str.split(",")
                    }
                }
            }
            if (lngLat.size >= 2) {
                lngLat[1].toDouble()
            } else {
                0.0
            }
        } catch (e: Exception) {
            0.0
        }
    }

}