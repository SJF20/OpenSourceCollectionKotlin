package com.shijingfeng.wan_android.database.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.shijingfeng.wan_android.constant.*

/**
 * Function: 首页 轮播图 Item 本地 实体类
 * Date: 2020/5/10 14:26
 * Description:
 * @author ShiJingFeng
 */
@Entity(tableName = HOME_BANNER_TABLE_NAME)
internal data class HomeBannerLocal (

    /** ID  */
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = HOME_BANNER_ID, index = true, defaultValue = "0")
    @SerializedName(HOME_BANNER_ID)
    var identity: Int = 0,

    /** 描述  */
    @ColumnInfo(name = HOME_BANNER_DESC, defaultValue = "")
    @SerializedName(HOME_BANNER_DESC)
    var desc: String = "",

    /** 图片地址  */
    @ColumnInfo(name = HOME_BANNER_IMAGE_PATH, defaultValue = "")
    @SerializedName(HOME_BANNER_IMAGE_PATH)
    var imagePath: String = "",

    /**  */
    @ColumnInfo(name = HOME_BANNER_IS_VISIBLE, defaultValue = "1")
    @SerializedName(HOME_BANNER_IS_VISIBLE)
    var isVisible: Int = 1,

    /** 顺序 (从0开始)  */
    @ColumnInfo(name = HOME_BANNER_ORDER, defaultValue = "0")
    @SerializedName(HOME_BANNER_ORDER)
    var order: Int = 0,

    /** 标题  */
    @ColumnInfo(name = HOME_BANNER_TITLE, defaultValue = "")
    @SerializedName(HOME_BANNER_TITLE)
    var title: String = "",

    /**  */
    @ColumnInfo(name = HOME_BANNER_TYPE, defaultValue = "0")
    @SerializedName(HOME_BANNER_TYPE)
    var type: Int = 0,

    /** 点击跳转的URL  */
    @ColumnInfo(name = HOME_BANNER_URL, defaultValue = "")
    @SerializedName(HOME_BANNER_URL)
    var url: String = ""

)