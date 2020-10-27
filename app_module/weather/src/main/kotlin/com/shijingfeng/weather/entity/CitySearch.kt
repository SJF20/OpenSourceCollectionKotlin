package com.shijingfeng.weather.entity

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

    /** 城市编码, 瞎返数据, 省级是数组, 其他是字符串, 故废弃使用 */
//    @SerializedName("citycode")
//    var cityCode: String = "",

    /** 区域编码 注: 街道没有独有的adCode，均继承父类（区县）的adCode*/
    @SerializedName("adcode")
    val adCode: String = "",

    /** 行政区名称 */
    @SerializedName("name")
    val name: String = "",

    /** 区域中心点 例子: "经度,纬度" */
    @SerializedName("center")
    val center: String = "",

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

    /**
     * 获取经度
     */
    val longitude: Double by lazy {
        try {
            val lngLat = center.split(",")

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
            val lngLat = center.split(",")

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