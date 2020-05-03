package com.shijingfeng.wan_android.entity.network

import com.google.gson.annotations.SerializedName
import com.shijingfeng.base.base.entity.BaseEntity

/**
 * Function: 项目二级数据 实体类
 * Date: 20-4-29 下午9:12
 * Description:
 * @author shijingfeng
 */
internal data class ProjectChildEntity(

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
    var projectChildItemList: List<ProjectChildItem> = mutableListOf()

) : BaseEntity()

/**
 * 项目二级数据 Item 实体类
 */
internal data class ProjectChildItem(

    @SerializedName("id")
    var identity: String = "",

    @SerializedName("apkLink")
    var apkLink: String = "",

    @SerializedName("audit")
    var audit: Int = 0,

    /** 文章的作者  */
    @SerializedName("author")
    var author: String = "",

    /** 是否可编辑　*/
    @SerializedName("canEdit")
    var canEdit: Boolean = false,

    /** 文章领域的类型 ID  */
    @SerializedName("chapterId")
    var chapterId: Int = 0,

    /** 文章领域的类型 名称 (例如 Flutter)  */
    @SerializedName("chapterName")
    var chapterName: String = "",

    @SerializedName("collect")
    var collected: Boolean = false,

    @SerializedName("courseId")
    var courseId: Int = 0,

    /** 简介 */
    @SerializedName("desc")
    var desc: String = "",

    @SerializedName("descMd")
    var descMd: String = "",

    @SerializedName("envelopePic")
    var envelopePic: String = "",

    /** 是否是最新的  */
    @SerializedName("fresh")
    var fresh: Boolean = false,

    /** 文章链接  */
    @SerializedName("link")
    var link: String = "",

    @SerializedName("niceDate")
    var niceDate: String = "",

    @SerializedName("niceShareDate")
    var niceShareDate: String = "",

    @SerializedName("origin")
    var origin: String = "",

    @SerializedName("prefix")
    var prefix: String = "",

    @SerializedName("projectLink")
    var projectLink: String = "",

    @SerializedName("publishTime")
    var publishTime: Long = 0L,

    @SerializedName("selfVisible")
    var selfVisible: Int = 0,

    /** 分享时的时间戳  */
    @SerializedName("shareDate")
    var shareDate: Long = 0L,

    /** 分享文章的用户  */
    @SerializedName("shareUser")
    var shareUser: String = "",

    /** 所属的文章领域类型 ID  */
    @SerializedName("superChapterId")
    var superChapterId: Int = 0,

    /** 所属的文章领域类型 名称 (例如 跨平台)  */
    @SerializedName("superChapterName")
    var superChapterName: String = "",

    /** 标签列表 (例如: 问答, 导航, 公众号) */
    @SerializedName("tags")
    var tagList: List<ProjectChildTag> = ArrayList(),

    /** 文章标题  */
    @SerializedName("title")
    var title: String = "",

    @SerializedName("type")
    var itemType: Int = 0,

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
    override fun getId(): String {
        return identity
    }
}

/**
 * 项目二级数据 标签 实体类
 */
internal data class ProjectChildTag(

    @SerializedName("name")
    var name: String? = "",

    @SerializedName("url")
    var url: String = ""

) : BaseEntity()