package com.shijingfeng.wan_android.common.constant

/**
 * Function: 实体类 常量
 * Date: 2020/5/10 17:06
 * Description:
 * Author: ShiJingFeng
 */

/**
 * 首页 轮播图 表名 字段名
 */
/** 表名 */
const val HOME_BANNER_TABLE_NAME = "home_banner"
/** ID */
const val HOME_BANNER_ID = "id"
/** 描述 */
const val HOME_BANNER_DESC = "desc"
/** 图片地址 */
const val HOME_BANNER_IMAGE_PATH = "imagePath"
const val HOME_BANNER_IS_VISIBLE = "isVisible"
const val HOME_BANNER_ORDER = "order"
/** 标题 */
const val HOME_BANNER_TITLE = "title"
const val HOME_BANNER_TYPE = "type"
/** URL */
const val HOME_BANNER_URL = "url"

/**
 * 首页 文章 表名 字段名
 */
/** 表名 */
const val HOME_ARTICLE_TABLE_NAME = "home_article"
/** ID */
const val HOME_ARTICLE_ID = "id"
const val HOME_ARTICLE_APK_LINK = "apkLink"
const val HOME_ARTICLE_AUDIT = "audit"
/** 文章的作者  */
const val HOME_ARTICLE_AUTHOR = "author"
/** 文章领域的类型 ID  */
const val HOME_ARTICLE_CHAPTER_ID = "chapterId"
/** 文章领域的类型 名称 (例如 Flutter)  */
const val HOME_ARTICLE_CHAPTER_NAME = "chapterName"
/** 是否已收藏  true: 已收藏  false: 未收藏 */
const val HOME_ARTICLE_COLLECT = "collect"
const val HOME_ARTICLE_COURSE_ID = "courseId"
/** 文章描述 */
const val HOME_ARTICLE_DESC = "desc"
/** 展示图片 (项目中用到) */
const val HOME_ARTICLE_ENVELOPE_PIC = "envelopePic"
/** 是否是最新的 */
const val HOME_ARTICLE_FRESH = "fresh"
/** 文章链接 */
const val HOME_ARTICLE_LINK = "link"
const val HOME_ARTICLE_NICE_DATE = "niceDate"
const val HOME_ARTICLE_NICE_SHARE_DATE = "niceShareDate"
const val HOME_ARTICLE_ORIGIN = "origin"
const val HOME_ARTICLE_PREFIX = "prefix"
const val HOME_ARTICLE_PROJECT_LINK = "projectLink"
const val HOME_ARTICLE_PUBLISH_TIME = "publishTime"
const val HOME_ARTICLE_SELF_VISIBLE = "selfVisible"
/** 分享时的时间戳  */
const val HOME_ARTICLE_SHARE_DATE = "shareDate"
/** 分享文章的用户  */
const val HOME_ARTICLE_SHARE_USER = "shareUser"
/** 所属的文章领域类型 ID  */
const val HOME_ARTICLE_SUPER_CHAPTER_ID = "superChapterId"
/** 所属的文章领域类型 名称 (例如 跨平台)  */
const val HOME_ARTICLE_SUPER_CHAPTER_NAME = "superChapterName"
/** 文章标题  */
const val HOME_ARTICLE_TITLE = "title"
const val HOME_ARTICLE_TYPE = "type"
const val HOME_ARTICLE_USER_ID = "userId"
const val HOME_ARTICLE_VISIBLE = "visible"
const val HOME_ARTICLE_ZAN = "zan"

/**
 * 首页 文章 标签 表名 字段名
 */
/** 表名 */
const val HOME_ARTICLE_TAG_TABLE_NAME = "home_article_tag"
/** 用于关联 [HOME_ARTICLE_ID] (值相同), 因为 Room Entity 不允许 嵌套 Entity */
const val HOME_ARTICLE_FOREIGN_ID = "home_article_foreign_id"
/** 标签名 */
const val HOME_ARTICLE_TAG_NAME = "name"
/** 标签 URL */
const val HOME_ARTICLE_TAG_URL = "url"

/**
 * 首页 置顶文章 表名 字段名
 */
/** 表名 */
const val HOME_TOP_ARTICLE_TABLE_NAME = "home_top_article"
/** ID */
const val HOME_TOP_ARTICLE_ID = "id"
const val HOME_TOP_ARTICLE_APK_LINK = "apkLink"
const val HOME_TOP_ARTICLE_AUDIT = "audit"
/** 文章的作者  */
const val HOME_TOP_ARTICLE_AUTHOR = "author"
/** 文章领域的类型 ID  */
const val HOME_TOP_ARTICLE_CHAPTER_ID = "chapterId"
/** 文章领域的类型 名称 (例如 Flutter)  */
const val HOME_TOP_ARTICLE_CHAPTER_NAME = "chapterName"
/** 是否已收藏  true: 已收藏  false: 未收藏 */
const val HOME_TOP_ARTICLE_COLLECT = "collect"
const val HOME_TOP_ARTICLE_COURSE_ID = "courseId"
/** 文章描述 */
const val HOME_TOP_ARTICLE_DESC = "desc"
/** 展示图片 (项目中用到) */
const val HOME_TOP_ARTICLE_ENVELOPE_PIC = "envelopePic"
/** 是否是最新的 */
const val HOME_TOP_ARTICLE_FRESH = "fresh"
/** 文章链接 */
const val HOME_TOP_ARTICLE_LINK = "link"
const val HOME_TOP_ARTICLE_NICE_DATE = "niceDate"
const val HOME_TOP_ARTICLE_NICE_SHARE_DATE = "niceShareDate"
const val HOME_TOP_ARTICLE_ORIGIN = "origin"
const val HOME_TOP_ARTICLE_PREFIX = "prefix"
const val HOME_TOP_ARTICLE_PROJECT_LINK = "projectLink"
const val HOME_TOP_ARTICLE_PUBLISH_TIME = "publishTime"
const val HOME_TOP_ARTICLE_SELF_VISIBLE = "selfVisible"
/** 分享时的时间戳  */
const val HOME_TOP_ARTICLE_SHARE_DATE = "shareDate"
/** 分享文章的用户  */
const val HOME_TOP_ARTICLE_SHARE_USER = "shareUser"
/** 所属的文章领域类型 ID  */
const val HOME_TOP_ARTICLE_SUPER_CHAPTER_ID = "superChapterId"
/** 所属的文章领域类型 名称 (例如 跨平台)  */
const val HOME_TOP_ARTICLE_SUPER_CHAPTER_NAME = "superChapterName"
/** 文章标题  */
const val HOME_TOP_ARTICLE_TITLE = "title"
const val HOME_TOP_ARTICLE_TYPE = "type"
const val HOME_TOP_ARTICLE_USER_ID = "userId"
const val HOME_TOP_ARTICLE_VISIBLE = "visible"
const val HOME_TOP_ARTICLE_ZAN = "zan"

/**
 * 首页 置顶文章 标签 表名 字段名
 */
/** 表名 */
const val HOME_TOP_ARTICLE_TAG_TABLE_NAME = "home_top_article_tag"
/** 用于关联 [HOME_TOP_ARTICLE_ID] (值相同), 因为 Room Entity 不允许 嵌套 Entity */
const val HOME_TOP_ARTICLE_FOREIGN_ID = "home_top_article_foreign_id"
/** 标签名 */
const val HOME_TOP_ARTICLE_TAG_NAME = "name"
/** 标签 URL */
const val HOME_TOP_ARTICLE_TAG_URL = "url"