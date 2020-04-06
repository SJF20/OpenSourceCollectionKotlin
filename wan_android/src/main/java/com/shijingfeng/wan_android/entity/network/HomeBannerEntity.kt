package com.shijingfeng.wan_android.entity.network

import com.google.gson.annotations.SerializedName
import com.shijingfeng.base.base.entity.BaseEntity

/**
 * Function: 首页Banner数据
 * Date: 2020/2/3 19:17
 * Description:
 * @author ShiJingFeng
 */
internal data class HomeBannerEntity(

    /** ID  */
    @SerializedName("id")
    var identity: String = "",

    /** 描述  */
    @SerializedName("desc")
    var desc: String = "",

    /** 图片地址  */
    @SerializedName("imagePath")
    var imagePath: String = "",

    /**  */
    @SerializedName("isVisible")
    var isVisible: Int = 1,

    /** 顺序 (从0开始)  */
    @SerializedName("order")
    var order: Int = 0,

    /** 标题  */
    @SerializedName("title")
    var title: String = "",

    /**  */
    @SerializedName("type")
    var type: Int = 0,

    /** 点击跳转的URL  */
    @SerializedName("url")
    var url: String = ""

) : BaseEntity() {

    /**
     * 获取ID
     * @return ID
     */
    override fun getId() = identity

}