package com.shijingfeng.wan_android.constant

/**
 * Function: 标志 静态常量
 * Date: 2020/2/3 15:52
 * Description:
 * @author ShiJingFeng
 */

/** Bundle Key(String) Value(boolean)  跳转到首页  */
const val SKIP_TO_HOME = "skip_to_home"
/** Bundle Key(String) Value(String)  知识体系实体类  */
const val KNOWLEDGE_CLASSIFY_ENTITY = "knowledge_classify_entity"
/** Bundle Key(String) Value(boolean)  登录页面是否能返回 (App是否只剩下登录页面了)  */
const val LOGIN_ACTIVITY_CAN_BACK = "login_activity_can_back"

/** Map Key(String) Value(String)  RecyclerView适配器局部更新标记  */
const val PART_UPDATE_FLAG = "part_update_flag"
/** RecyclerView适配器局部更新: 更新收藏状态  */
const val PART_UPDATE_COLLECTION_STATUS = "part_update_collection_status"

/** SparseArray Key(int) Value(Boolean) 收藏或取消收藏  true: 收藏  false: 取消收藏  */
const val KEY_COLLECTED = 1
/** SparseArray Key(int) Value(String) 文章ID  */
const val KEY_ARTICLE_ID = 2

/** 视图向下滚动, 手指向上滑动  */
const val SCROLL_TO_DOWN = 1
/** 视图向上滚动, 手指向下滑动  */
const val SCROLL_TO_UP = 2

/** TabLayout可见性  */
const val TAB_LAYOUT_VISIBILITY = "tab_layout_visibility"

/** 类型: 未知 */
const val HOME_UNKNOWN = 0
/** 类型: 首页轮播图  */
const val HOME_BANNER = 1
/** 类型: 置顶  */
const val HOME_SET_TO_TOP = 2
/** 类型: 首页文章  */
const val HOME_ARTICLE = 3

/** 首页查看轮播图详情  */
const val VIEW_BANNER_DETAIL = "home_view_banner_detail"
/** 查看文章详情  */
const val VIEW_ARTICLE_DETAIL = "view_article_detail"
/** 文章Item 收藏 或 取消收藏  */
const val ARTICLE_ITEM_COLLECTION = "article_item_collection"
/** 文章Item 取消收藏  */
const val ARTICLE_ITEM_UNCOLLECTED = "article_item_uncollected"

/** 查看知识体系详情  */
const val VIEW_KNOWLEDGE_CLASSIFY_DETAIL = "view_knowledge_classify_detail"
/** 查看导航分类详情  */
const val VIEW_NAVIGATION_CLASSIFY_DETAIL = "view_navigation_classify_detail"