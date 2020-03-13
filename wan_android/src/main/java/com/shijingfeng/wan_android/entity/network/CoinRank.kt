package com.shijingfeng.wan_android.entity.network

import com.google.gson.annotations.SerializedName
import com.shijingfeng.base.base.entity.BaseEntity

/**
 * Function: 积分排行榜 实体类 集合
 * Date: 2020/2/3 21:32
 * Description:
 * @author ShiJingFeng
 */

/**
 * 积分排行榜 实体类
 */
data class CoinRankEntity(

    /** 此页开始的下标  */
    @SerializedName("offset")
    var offset: Int = 0,

    /**  */
    @SerializedName("over")
    var over: Boolean = false,

    /** 当前页面的页码  */
    @SerializedName("curPage")
    var curPage: Int = 1,

    /** 页面的数量  */
    @SerializedName("pageCount")
    var pageCount: Int = 1,

    /** 当前页的Item数量  */
    @SerializedName("size")
    var size: Int = 0,

    /** Item总数  */
    @SerializedName("total")
    var total: Int = 0,

    @SerializedName("datas")
    var coinRankItemList: List<CoinRankItem> = ArrayList()

) : BaseEntity()

/**
 * 积分排行榜 Item 实体类
 */
data class CoinRankItem(

    @SerializedName("userId")
    var userId: String = "",

    @SerializedName("username")
    var username: String = "",

    @SerializedName("level")
    var level: Int = 1,

    @SerializedName("rank")
    var rank: Int = 1,

    @SerializedName("coinCount")
    var coinCount: Int = 0

) : BaseEntity() {

    /**
     * 获取ID
     * @return ID
     */
    override fun getId(): String {
        return userId
    }

}