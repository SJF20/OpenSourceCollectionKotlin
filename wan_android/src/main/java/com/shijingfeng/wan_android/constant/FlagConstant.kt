/** 生成的 Java 类名 */
@file:JvmName("FlagConstant")
package com.shijingfeng.wan_android.constant

/**
 * Function: 标志 静态常量
 * Date: 2020/2/3 15:52
 * Description:
 * @author ShiJingFeng
 */

/** Bundle Key(String) Value(String)  知识体系 一级数据 实体类 序列化后的字符串 */
internal const val KNOWLEDGE_CLASSIFY_STR = "knowledge_classify"
/** Bundle Key(String) Value(String)  知识体系 二级数据 实体类 序列化后的字符串 */
internal const val KNOWLEDGE_CLASSIFY_CHILDREN_STR = "knowledge_classify_children_str"
/** Bundle Key(String) Value(String) 公众号 某个索引 实体类 序列化后的字符串 */
internal const val OFFICIAL_ACCOUNT_INDEX_STR = "official_account_index_str"
/** Bundle Key(String) Value(String) 项目 某个索引数据 实体类 序列化后的字符串 */
internal const val PROJECT_INDEX_STR = "project_index_str"
/** Bundle Key(String) Value(String) 搜索关键词 */
internal const val SEARCH_HOT_WORD = "search_hot_word"
/** Bundle Key(String) Value(String) 搜索列表(第一页) 序列化后的字符串 */
internal const val SEARCH_LIST_STR = "search_list_str"
/** Bundle Key(String) Value(String)  文章ID  */
internal const val ARTICLE_ID = "article_id"
/** Bundle Key(String) Value(boolean)  文章是否已被收藏 (true: 已被收藏, false: 未被收藏) */
internal const val ARTICLE_COLLECTED = "article_collected"

/** Map Key(String) Value(String)  RecyclerView适配器局部更新标记  */
internal const val PART_UPDATE_FLAG = "part_update_flag"
/** RecyclerView适配器局部更新: 更新收藏状态  */
internal const val PART_UPDATE_COLLECTION_STATUS = "part_update_collection_status"

/** SparseArray Key(int) Value(Boolean) 收藏或取消收藏  true: 收藏  false: 取消收藏  */
internal const val KEY_COLLECTED = 1
/** SparseArray Key(int) Value(String) 文章ID  */
internal const val KEY_ARTICLE_ID = 2

/** 视图向下滚动, 手指向上滑动  */
internal const val SCROLL_TO_DOWN = 1
/** 视图向上滚动, 手指向下滑动  */
internal const val SCROLL_TO_UP = 2

/** TabLayout可见性  */
internal const val TAB_LAYOUT_VISIBILITY = "tab_layout_visibility"

/** 类型: 首页轮播图  */
internal const val HOME_BANNER = 1
/** 类型: 置顶  */
internal const val HOME_TOP_ARTICLE = 2
/** 类型: 首页文章  */
internal const val HOME_ARTICLE = 3

/** 首页查看轮播图详情  */
internal const val VIEW_BANNER_DETAIL = "home_view_banner_detail"
/** 查看文章详情  */
internal const val VIEW_ARTICLE_DETAIL = "view_article_detail"
/** 文章Item 收藏 或 取消收藏  */
internal const val ARTICLE_ITEM_COLLECTION = "article_item_collection"
/** 文章Item 取消收藏  */
internal const val ARTICLE_ITEM_UNCOLLECTED = "article_item_uncollected"
/** 网站Item 取消收藏 */
internal const val WEBSITE_ITEM_UNCOLLECTED = "website_item_uncollected"
/** 网站Item 编辑 */
internal const val WEBSITE_ITEM_EDIT = "website_item_edit"
/** 查看网站详情 */
internal const val VIEW_WEBSITE_DETAIL = "view_website_detail"

/** 查看知识体系 一级数据 详情 (一级数据内的二级数据列表)  */
internal const val VIEW_KNOWLEDGE_CLASSIFY_DETAIL = "view_knowledge_classify_detail"
/** 查看导航分类详情  */
internal const val VIEW_NAVIGATION_CLASSIFY_DETAIL = "view_navigation_classify_detail"

/** 搜索 */
internal const val SEARCH = "search"
/** 删除 某条 搜索历史 */
internal const val REMOVE_SEARCH_HISTORY_ITEM = "remove_search_history_item"