package com.shijingfeng.wan_android.entity

import com.google.gson.annotations.SerializedName
import com.shijingfeng.base.base.entity.BaseEntity
import java.util.*

/**
 * Function: 我的收藏 -> 文章收藏列表 实体类 集合
 * Date: 2020/2/3 20:04
 * Description:
 * Author: ShiJingFeng
 */

/**
 * 我的收藏 -> 文章收藏列表 实体类
 */
internal data class PersonalCollectionArticleEntity(

    /** 当前页码  */
    @SerializedName("curPage")
    var curPage: Int = 1,

    /** 当前 条 位置（从0开始） */
    @SerializedName("offset")
    var offset: Int = 0,

    @SerializedName("over")
    var over: Boolean = false,

    /** 全部 页 数量  */
    @SerializedName("pageCount")
    var pageCount: Int = 0,

    /** 当前 页 有多少 条  */
    @SerializedName("size")
    var size: Int = 0,

    /** 全部 条 数量  */
    @SerializedName("total")
    var total: Int = 0,

    /** 当前 页 的 条 列表数据  */
    @SerializedName("datas")
    var articleCollectedItemList: List<PersonalCollectionArticleItem> = ArrayList()

) : BaseEntity()

/**
 * 我的收藏 -> 文章收藏列表 Item 实体类
 */
internal data class PersonalCollectionArticleItem(

    @SerializedName("id")
    var identity: String = "",

    /** 文章的作者  */
    @SerializedName("author")
    var author: String = "",

    /** 文章领域的类型 ID  */
    @SerializedName("chapterId")
    var chapterId: Int = 0,

    /** 文章领域的类型 名称 (例如 Flutter)  */
    @SerializedName("chapterName")
    var chapterName: String = "",

    @SerializedName("courseId")
    var courseId: Int = 0,

    @SerializedName("desc")
    var desc: String = "",

    @SerializedName("envelopePic")
    var envelopePic: String = "",

    /** 文章链接  */
    @SerializedName("link")
    var link: String = "",

    @SerializedName("niceDate")
    var niceDate: String = "",

    @SerializedName("origin")
    var origin: String = "",

    @SerializedName("originId")
    var originId: String = "",

    @SerializedName("publishTime")
    var publishTime: Long = 0L,

    /** 文章标题  */
    @SerializedName("title")
    var title: String = "",

    @SerializedName("userId")
    var userId: Int = 0,

    @SerializedName("visible")
    var visible: Int = 0,

    @SerializedName("zan")
    var zan: Int = 0

) : BaseEntity() {

    /**
     * 获取ID
     * @return ID
     */
    override fun getId() = identity

}