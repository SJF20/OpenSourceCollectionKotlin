package com.shijingfeng.background_service.entity

import com.google.gson.annotations.SerializedName
import com.shijingfeng.base.base.entity.BaseEntity

/**
 * Function: 最新 App 版本信息 实体类
 * Date: 2020/5/24 10:55
 * Description:
 * @author ShiJingFeng
 */
internal data class NewestAppInfoEntity(

    /** 版本号, 默认为1.0 (是应用向用户宣传时候用到的标识，例如：1.1、8.2.1等。) */
    @SerializedName("buildVersion")
    val buildVersion: String = "",

    /** 上传包的版本编号，默认为1 (即编译的版本号，一般来说，编译一次会变动一次这个版本号, 在 Android 上叫 Version Code。对于 iOS 来说，是字符串类型；对于 Android 来说是一个整数。例如：1001，28等。) */
    @SerializedName("buildVersionNo")
    val buildVersionNo: Int = 1,

    /** 蒲公英生成的用于区分历史版本的build号 */
    @SerializedName("buildBuildVersion")
    val buildBuildVersion: Int = 0,

    /** 应用更新说明 */
    @SerializedName("buildUpdateDescription")
    val buildUpdateDescription: String = "",

    /** 应用短链接 */
    @SerializedName("buildShortcutUrl")
    val buildShortcutUrl: String = "",

    /** 是否有新版本 */
    @SerializedName("buildHaveNewVersion")
    val buildHaveNewVersion: Boolean = false,

    /** 应用安装地址 */
    @SerializedName("downloadURL")
    val downloadURL: String = ""

) : BaseEntity()