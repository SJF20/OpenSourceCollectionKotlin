package com.shijingfeng.wan_android.entity.network

import com.google.gson.annotations.SerializedName
import com.shijingfeng.base.base.entity.BaseEntity
import java.util.*

/**
 * Function: 用户信息实体类
 * Date: 2020/2/3 15:20
 * Description:
 * @author ShiJingFeng
 */
internal data class UserInfoEntity(

    /** ID  */
    @SerializedName("id")
    var identity: String = "",

    /** Token令牌  */
    @SerializedName("token")
    var token: String = "",

    /** 头像  */
    @SerializedName("icon")
    var portrait: String = "",

    /** 用户名  */
    @SerializedName("username")
    var username: String = "",

    /** 昵称  */
    @SerializedName("nickname")
    var nickname: String = "",

    /** 公共名称  */
    @SerializedName("publicName")
    var publicName: String = "",

    /** 密码  */
    @SerializedName("password")
    var password: String = "",

    /** 邮箱  */
    @SerializedName("email")
    var email: String = "",

    /**   */
    @SerializedName("admin")
    var admin: Boolean = false,

    /**   */
    @SerializedName("type")
    var type: Int = 0,

    /** 置顶列表  */
    @SerializedName("chapterTops")
    var chapterTopList: List<Any> = ArrayList(),

    /** 收藏列表  */
    @SerializedName("collectIds")
    var collectIdList: List<Any> = ArrayList()

) : BaseEntity() {

    /**
     * 获取ID
     * @return ID
     */
    override fun getId(): String {
        return identity
    }

}