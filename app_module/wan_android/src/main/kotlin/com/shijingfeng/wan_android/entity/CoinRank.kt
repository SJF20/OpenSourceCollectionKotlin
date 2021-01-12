package com.shijingfeng.wan_android.entity

import com.google.gson.annotations.SerializedName
import com.shijingfeng.base.annotation.define.DataSource
import com.shijingfeng.base.base.entity.BaseEntity
import com.shijingfeng.base.common.constant.DATA_SOURCE_NETWORK

/**
 * Function: 积分排行榜 实体类 集合
 * Date: 2020/2/3 21:32
 * Description:
 * Author: ShiJingFeng
 */

/**
 * 积分排行榜 实体类
 */
internal data class CoinRankEntity(

    /** 数据来源 默认 [DATA_SOURCE_NETWORK] */
    @DataSource var dataSource: Int = DATA_SOURCE_NETWORK,

    /** 此页开始的下标  */
    @SerializedName("offset")
    var offset: Int = 0,

    /**  */
    @SerializedName("over")
    var over: Boolean = false,

    /** 当前页面的页码 (-1 代表从本地获取的 全部 Item)  */
    @SerializedName("curPage")
    var curPage: Int = -1,

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
    var coinRankItemList: MutableList<CoinRankItem> = ArrayList()

) : BaseEntity()

/**
 * 积分排行榜 Item 实体类
 */
internal data class CoinRankItem(

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
    override fun getId() = userId

}