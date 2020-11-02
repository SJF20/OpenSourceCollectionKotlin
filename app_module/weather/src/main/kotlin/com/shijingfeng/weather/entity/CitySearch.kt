package com.shijingfeng.weather.entity

import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.annotations.SerializedName
import com.shijingfeng.base.base.entity.BaseEntity

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
    var districts: List<CitySearchInfoEntity> = emptyList()

) : BaseEntity()

/**
 * 城市搜索信息数据
 */
internal data class CitySearchInfoEntity(

    /** 城市编码, 省级(省, 自治区)是数组, 其他(直辖市, 特别行政区, 台湾省, 外国)是字符串, 需判断 是 JsonArray 还是 JsonPrimitive */
    @SerializedName("citycode")
    private val cityCodeJsonElement: JsonElement = JsonPrimitive(""),

    /** 区域编码 注: 不是邮政编码, 街道没有独有的adCode，均继承父类（区县）的adCode */
    @SerializedName("adcode")
    val adCode: String = "",

    /** 行政区名称 */
    @SerializedName("name")
    val cityName: String = "",

    /** 区域中心点 外国是数组(JsonArray), 其他是字符串(JsonPrimitive)  例子: "经度,纬度" */
    @SerializedName("center")
    private val centerJsonElement: JsonElement = JsonPrimitive(""),

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

    /** 是否已添加 */
    var isAdded: Boolean = false,

    /** 包括上几级行政区的城市名称 */
    var cityFullName: String = "",

    /** 城市名称 所在 包括上几级行政区的城市名称 的下标   0下标: 开始下标   1下标: 长度 */
    val cityNameIndex: IntArray = intArrayOf(0, 0)

) : BaseEntity() {

    /**
     * 获取 cityCode
     */
    val cityCode: String by lazy {
        try {
            if (cityCodeJsonElement.isJsonPrimitive) {
                val jsonPrimitive = cityCodeJsonElement.asJsonPrimitive

                if (jsonPrimitive.isString) {
                    return@lazy jsonPrimitive.asString
                } else if (jsonPrimitive.isNumber) {
                    return@lazy jsonPrimitive.asNumber.toString()
                }
            }
            return@lazy ""
        } catch (e: Exception) {
            e.printStackTrace()
            return@lazy ""
        }
    }

    /**
     * 经纬度组合字符串
     */
    val lngLatStr: String by lazy {
        try {
            if (centerJsonElement.isJsonPrimitive) {
                val jsonPrimitive = centerJsonElement.asJsonPrimitive

                if (jsonPrimitive.isString) {
                    return@lazy jsonPrimitive.asString
                }
            }
            return@lazy ""
        } catch (e: Exception) {
            e.printStackTrace()
            return@lazy ""
        }
    }

    /**
     * 获取经度
     */
    val longitude: Double by lazy {
        if (lngLatStr.isNotEmpty()) {
            val lngLat = lngLatStr.split(",")

            if (lngLat.isNotEmpty()) {
                return@lazy lngLat[0].toDouble()
            }
        }
        return@lazy 0.0
    }

    /**
     * 获取纬度
     */
    val latitude: Double by lazy {
        if (lngLatStr.isNotEmpty()) {
            val lngLat = lngLatStr.split(",")

            if (lngLat.size > 1) {
                return@lazy lngLat[1].toDouble()
            }
        }
        return@lazy 0.0
    }

}