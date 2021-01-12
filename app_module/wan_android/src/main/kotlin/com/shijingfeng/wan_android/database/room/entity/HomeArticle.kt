package com.shijingfeng.wan_android.database.room.entity

import androidx.room.*
import com.google.gson.annotations.SerializedName
import com.shijingfeng.wan_android.common.constant.*

/**
 * Function: 首页 文章 Item 本地 实体类
 * Date: 2020/5/10 14:29
 * Description:
 * Author: ShiJingFeng
 */

/**
 * 首页文章 和 首页文章中标签列表 组合 本地实体类
 * 原因: Room Entity 中 不允许 嵌套 Entity
 * 详解: 分为 [HOME_ARTICLE_TABLE_NAME]表 (1表), [HOME_ARTICLE_TAG_TABLE_NAME]表 (2表)
 * 所有的文章数据放在 1表 中，所有的文章标签放在 2表 中，因为 2表 中 有 [HOME_ARTICLE_FOREIGN_ID]，
 * 所以可以根据 文章ID 查询到 对应的文章标签列表，那么 文章 和 文章标签列表 就 一对多 对应起来了
 */
internal data class HomeArticleCombineLocal(

    /** 首页 文章 */
    @Embedded
    var homeArticle: HomeArticleLocal?,

    /**
     * 首页文章中的标签列表
     */
    @Relation(
        /** [HomeArticleLocal] 中的 关联键 */
        parentColumn = HOME_ARTICLE_ID,
        /** [HomeArticleTagLocal] 中的 关联键 */
        entityColumn = HOME_ARTICLE_FOREIGN_ID
    )
    var homeArticleTagList: List<HomeArticleTagLocal>?

)

/**
 * 首页 文章 本地实体类
 */
//@Entity(tableName = HOME_ARTICLE_TABLE_NAME)
internal data class HomeArticleLocal(

    /** ID  */
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = HOME_ARTICLE_ID, index = true, defaultValue = "0")
    @SerializedName(HOME_ARTICLE_ID)
    var identity: Int = 0,

    @ColumnInfo(name = HOME_ARTICLE_APK_LINK, defaultValue = "")
    @SerializedName(HOME_ARTICLE_APK_LINK)
    var apkLink: String = "",

    @ColumnInfo(name = HOME_ARTICLE_AUDIT, defaultValue = "0")
    @SerializedName(HOME_ARTICLE_AUDIT)
    var audit: Int = 0,

    /** 文章的作者  */
    @ColumnInfo(name = HOME_ARTICLE_AUTHOR, defaultValue = "")
    @SerializedName(HOME_ARTICLE_AUTHOR)
    var author: String = "",

    /** 文章领域的类型 ID  */
    @ColumnInfo(name = HOME_ARTICLE_CHAPTER_ID, defaultValue = "0")
    @SerializedName(HOME_ARTICLE_CHAPTER_ID)
    var chapterId: Int = 0,

    /** 文章领域的类型 名称 (例如 Flutter)  */
    @ColumnInfo(name = HOME_ARTICLE_CHAPTER_NAME, defaultValue = "")
    @SerializedName(HOME_ARTICLE_CHAPTER_NAME)
    var chapterName: String = "",

    /** 注: Sqlite 不支持 布尔类型，所以使用 0 (false) 1 (true) */
    @ColumnInfo(name = HOME_ARTICLE_COLLECT, defaultValue = "false")
    @SerializedName(HOME_ARTICLE_COLLECT)
    var collected: Int = 0,

    @ColumnInfo(name = HOME_ARTICLE_COURSE_ID, defaultValue = "0")
    @SerializedName(HOME_ARTICLE_COURSE_ID)
    var courseId: Int = 0,

    @ColumnInfo(name = HOME_ARTICLE_DESC, defaultValue = "")
    @SerializedName(HOME_ARTICLE_DESC)
    var desc: String = "",

    @ColumnInfo(name = HOME_ARTICLE_ENVELOPE_PIC, defaultValue = "")
    @SerializedName(HOME_ARTICLE_ENVELOPE_PIC)
    var envelopePic: String = "",

    /** 是否是最新的 (注: Sqlite 不支持 布尔类型，所以使用 0 (false) 1 (true)) */
    @ColumnInfo(name = HOME_ARTICLE_FRESH, defaultValue = "false")
    @SerializedName(HOME_ARTICLE_FRESH)
    var fresh: Int = 0,

    /** 文章链接  */
    @ColumnInfo(name = HOME_ARTICLE_LINK, defaultValue = "")
    @SerializedName(HOME_ARTICLE_LINK)
    var link: String = "",

    @ColumnInfo(name = HOME_ARTICLE_NICE_DATE, defaultValue = "")
    @SerializedName(HOME_ARTICLE_NICE_DATE)
    var niceDate: String = "",

    @ColumnInfo(name = HOME_ARTICLE_NICE_SHARE_DATE, defaultValue = "")
    @SerializedName(HOME_ARTICLE_NICE_SHARE_DATE)
    var niceShareDate: String = "",

    @ColumnInfo(name = HOME_ARTICLE_ORIGIN, defaultValue = "")
    @SerializedName(HOME_ARTICLE_ORIGIN)
    var origin: String = "",

    @ColumnInfo(name = HOME_ARTICLE_PREFIX, defaultValue = "")
    @SerializedName(HOME_ARTICLE_PREFIX)
    var prefix: String = "",

    @ColumnInfo(name = HOME_ARTICLE_PROJECT_LINK, defaultValue = "")
    @SerializedName(HOME_ARTICLE_PROJECT_LINK)
    var projectLink: String = "",

    @ColumnInfo(name = HOME_ARTICLE_PUBLISH_TIME, defaultValue = "0")
    @SerializedName(HOME_ARTICLE_PUBLISH_TIME)
    var publishTime: Long = 0L,

    @ColumnInfo(name = HOME_ARTICLE_SELF_VISIBLE, defaultValue = "0")
    @SerializedName(HOME_ARTICLE_SELF_VISIBLE)
    var selfVisible: Int = 0,

    /** 分享时的时间戳  */
    @ColumnInfo(name = HOME_ARTICLE_SHARE_DATE, defaultValue = "0")
    @SerializedName(HOME_ARTICLE_SHARE_DATE)
    var shareDate: Long = 0L,

    /** 分享文章的用户  */
    @ColumnInfo(name = HOME_ARTICLE_SHARE_USER, defaultValue = "")
    @SerializedName(HOME_ARTICLE_SHARE_USER)
    var shareUser: String = "",

    /** 所属的文章领域类型 ID  */
    @ColumnInfo(name = HOME_ARTICLE_SUPER_CHAPTER_ID, defaultValue = "0")
    @SerializedName(HOME_ARTICLE_SUPER_CHAPTER_ID)
    var superChapterId: Int = 0,

    /** 所属的文章领域类型 名称 (例如 跨平台)  */
    @ColumnInfo(name = HOME_ARTICLE_SUPER_CHAPTER_NAME, defaultValue = "")
    @SerializedName(HOME_ARTICLE_SUPER_CHAPTER_NAME)
    var superChapterName: String = "",

    /** 文章标题  */
    @ColumnInfo(name = HOME_ARTICLE_TITLE, defaultValue = "")
    @SerializedName(HOME_ARTICLE_TITLE)
    var title: String = "",

    @ColumnInfo(name = HOME_ARTICLE_TYPE, defaultValue = "0")
    @SerializedName(HOME_ARTICLE_TYPE)
    var itemType: Int = 0,

    @ColumnInfo(name = HOME_ARTICLE_USER_ID, defaultValue = "0")
    @SerializedName(HOME_ARTICLE_USER_ID)
    var userId: Int = 0,

    @ColumnInfo(name = HOME_ARTICLE_VISIBLE, defaultValue = "0")
    @SerializedName(HOME_ARTICLE_VISIBLE)
    var visible: Int = 0,

    @ColumnInfo(name = HOME_ARTICLE_ZAN, defaultValue = "0")
    @SerializedName(HOME_ARTICLE_ZAN)
    var zan: Int = 0

)

/**
 * 首页 文章 标签 本地实体类
 */
//@Entity(tableName = HOME_ARTICLE_TAG_TABLE_NAME)
internal data class HomeArticleTagLocal(

    /** 用于关联 */
    @ColumnInfo(name = HOME_ARTICLE_FOREIGN_ID, index = true, defaultValue = "0")
    var homeArticleId: Int = 0,

    /** 标签名 */
    @ColumnInfo(name = HOME_ARTICLE_TAG_NAME, defaultValue = "")
    @SerializedName("name")
    var name: String? = "",

    /** 标签 URL */
    @ColumnInfo(name = HOME_ARTICLE_TAG_URL, defaultValue = "")
    @SerializedName("url")
    var url: String = ""

)