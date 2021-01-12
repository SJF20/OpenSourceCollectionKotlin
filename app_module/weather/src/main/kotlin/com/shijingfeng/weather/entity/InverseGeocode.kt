package com.shijingfeng.weather.entity

import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.annotations.SerializedName
import com.shijingfeng.base.base.entity.BaseEntity
import com.shijingfeng.weather.common.constant.AMAP_CITY
import com.shijingfeng.weather.common.constant.AMAP_COUNTRY
import com.shijingfeng.weather.common.constant.AMAP_DISTRICT
import com.shijingfeng.weather.common.constant.AMAP_PROVINCE

/**
 * Function: 逆地理编码 实体类
 * Date: 2020/10/29 17:07
 * Description:
 * Author: ShiJingFeng
 */
/**
 * 逆地理编码 实体类
 * 注意: data class 会导致 lazy字段 获取为null, 故不采用
 */
internal data class InverseGeocodeEntity(

    /** 返回值为 0 或 1，0 表示请求失败；1 表示请求成功。 */
    @SerializedName("status")
    val status: String = "0",

    /** 当 status 为 0 时，info 会返回具体错误原因，否则返回“OK”。详情可以参考 info状态表 [https://lbs.amap.com/api/webservice/guide/tools/info] */
    @SerializedName("info")
    val info: String = "",

    /** 详情可以参考 info状态表 [https://lbs.amap.com/api/webservice/guide/tools/info] */
    @SerializedName("infocode")
    val infoCode: String = "0",

    /** 信息列表 */
    @SerializedName("regeocodes")
    val dataList: List<InverseGeocodeInfoEntity> = emptyList(),

) : BaseEntity()

/**
 * 逆地理编码信息 实体类
 * 注意: data class 会导致 lazy字段 获取为null, 故不采用
 */
internal data class InverseGeocodeInfoEntity(

    /** 格式化的地址 */
    @SerializedName("formatted_address")
    val formattedAddress: String = "",

    /** 详情 */
    @SerializedName("addressComponent")
    val detail: InverseGeocodeInfoDetailEntity,

) : BaseEntity()

/**
 * 逆地理编码信息详情 实体类
 * 注意: data class 会导致 lazy字段 获取为null, 故不采用
 */
internal data class InverseGeocodeInfoDetailEntity(

    /** 城市编码 例如：010 */
    @SerializedName("citycode")
    val cityCode: String = "",

    /** 行政区编码(不是邮政编码) 例如：110108 */
    @SerializedName("adcode")
    val adCode: String = "",

    /** 国家 国内地址默认返回中国  例如：中国 */
    @SerializedName(AMAP_COUNTRY)
    private val countryJsonElement: JsonElement = JsonPrimitive(""),

    /** 坐标点所在省名称  例如：北京市 */
    @SerializedName(AMAP_PROVINCE)
    private val provinceJsonElement: JsonElement = JsonPrimitive(""),

    /** 坐标点所在城市名称 请注意：当城市是省直辖县时返回为空，以及城市为北京、上海、天津、重庆四个直辖市时，该字段返回为空；请看省直辖县列表 [https://lbs.amap.com/faq/webservice/webservice-api/geocoding/43267]  */
    @SerializedName(AMAP_CITY)
    private val cityJsonElement: JsonElement = JsonPrimitive(""),

    /** 坐标点所在区  例如：海淀区 */
    @SerializedName(AMAP_DISTRICT)
    private val districtJsonElement: JsonElement = JsonPrimitive(""),

) : BaseEntity() {

    /**
     * 获取 国家
     */
    val country: String by lazy {
        try {
            if (countryJsonElement.isJsonPrimitive) {
                val jsonPrimitive = countryJsonElement.asJsonPrimitive

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
     * 获取 省，直辖市，自治区，特别行政区，台湾省
     */
    val province: String by lazy {
        try {
            if (provinceJsonElement.isJsonPrimitive) {
                val jsonPrimitive = provinceJsonElement.asJsonPrimitive

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
     * 获取 市(地级市)
     */
    val city: String by lazy {
        try {
            if (cityJsonElement.isJsonPrimitive) {
                val jsonPrimitive = cityJsonElement.asJsonPrimitive

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
     * 获取 县，县级市，市区
     */
    val district: String by lazy {
        try {
            if (districtJsonElement.isJsonPrimitive) {
                val jsonPrimitive = districtJsonElement.asJsonPrimitive

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

}
