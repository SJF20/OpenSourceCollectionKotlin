package com.shijingfeng.wan_android.entity

import com.google.gson.annotations.SerializedName
import com.shijingfeng.base.base.entity.BaseEntity

/**
 * Function: 积分信息 实体类
 * Date: 2020/2/3 16:10
 * Description:
 * @author ShiJingFeng
 */
internal data class CoinInfoEntity(

    /** 用户ID  */
    @SerializedName("userId")
    var userId: String = "",

    /** 用户名  */
    @SerializedName("username")
    var username: String = "",

    /** 总积分  */
    @SerializedName("coinCount")
    var coinCount: Int = 0,

    /** 当前排名  */
    @SerializedName("rank")
    var rank: Int = 0,

    /** 等级  */
    @SerializedName("level")
    var level: Int = 0

) : BaseEntity() {

    /**
     * 获取ID
     * @return ID
     */
    override fun getId() = userId

}