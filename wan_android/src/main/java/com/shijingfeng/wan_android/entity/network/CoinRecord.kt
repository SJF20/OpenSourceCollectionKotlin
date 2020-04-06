package com.shijingfeng.wan_android.entity.network

import com.google.gson.annotations.SerializedName
import com.shijingfeng.base.base.entity.BaseEntity
import java.util.*

/**
 * Function: 积分记录 实体类 集合
 * Date: 2020/2/3 21:42
 * Description:
 * @author ShiJingFeng
 */

/**
 * 积分记录 实体类
 */
internal data class CoinRecordEntity(

    /** 当前页码  */
    @SerializedName("curPage")
    var curPage: Int = 1,

    /** 全部 页 数量  */
    @SerializedName("pageCount")
    var pageCount: Int = 1,

    /** 当前 条 位置（从0开始） */
    @SerializedName("offset")
    var offset: Int = 0,

    /** 当前 页 有多少 条  */
    @SerializedName("size")
    var size: Int = 0,

    /** 全部 条 数量  */
    @SerializedName("total")
    var total: Int = 0,

    /**  */
    @SerializedName("over")
    var over: Boolean = true,

    /** 当前 页 的 条 列表数据  */
    @SerializedName("datas")
    var coinRecordItemList: List<CoinRecordItem> = ArrayList()

) : BaseEntity()

/**
 * 积分记录 Item 实体类
 */
internal data class CoinRecordItem(

    /** 此条记录 的 ID  */
    @SerializedName("id")
    var identity: String = "",

    /** 此条记录 的 所有者ID  */
    @SerializedName("userId")
    var userId: String = "",

    /** 此条记录 的 所有者用户名  */
    @SerializedName("userName")
    var username: String = "",

    /** 此记录 的 积分总数量  */
    @SerializedName("coinCount")
    var coinCount: Int = 0,

    /** 日期时间 毫秒值 时间戳  */
    @SerializedName("date")
    var timestamp: Long = 0L,

    /** 此条记录 的 描述  */
    @SerializedName("desc")
    var desc: String = "",

    /** 此条记录 的 积分用途或获得途径  */
    @SerializedName("reason")
    var reason: String = "",

    /**  */
    @SerializedName("type")
    var type: Int = 0

) : BaseEntity() {

    /**
     * 获取ID
     * @return ID
     */
    override fun getId() = identity

}