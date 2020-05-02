/** 生成的 Java 类名 */
@file:JvmName("ARouterConstant")
package com.shijingfeng.base.arouter

/**
 * Function: ARouter 路由表
 * Date: 2020/1/27 16:07
 * Description:
 * @author ShiJingFeng
 */

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// base 模块 IProvider
/** 通用降级 Provider  */
const val PROVIDER_BASE_COMMON_DEGRADE_SERVICE = "/base/provider/DegradeServiceImpl"
/** 通用路径替换 Provider  */
const val PROVIDER_BASE_COMMON_PATH_REPLACE_SERVICE = "/base/provider/PathReplaceServiceImpl"
/** 通用跳转前预处理 Provider  */
const val PROVIDER_BASE_COMMON_PRETREATMENT_SERVICE = "/base/provider/PretreatmentServiceImpl"

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// common 模块 Activity
/** 查看大图 Activity  */
const val ACTIVITY_COMMON_VIEW_ORIGINAL_IMAGE = "/common/activity/ViewOriginalImageActivity"

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// app 模块 Activity
/** 启动页 Activity */
const val ACTIVITY_APP_SPLASH = "/app/activity/SplashActivity"
/** 主页 Activity */
const val ACTIVITY_APP_MAIN = "/app/activity/MainActivity"

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// wan_android 模块 Provider
/** 登录拦截 Provider  */
const val PROVIDER_WAN_ANDROID_LOGIN_INTERCEPT = "/wan_android/activity/LoginInterceptProvider"

// wan_android 模块 Activity
/** 启动页 Activity  */
const val ACTIVITY_WAN_ANDROID_SPLASH = "/wan_android/activity/SplashActivity"
/** 登录 Activity  */
const val ACTIVITY_WAN_ANDROID_LOGIN = "/wan_android/activity/LoginActivity"
/** 注册 Activity  */
const val ACTIVITY_WAN_ANDROID_REGISTER = "/wan_android/activity/RegisterActivity"
/** 主页 Activity  */
const val ACTIVITY_WAN_ANDROID_MAIN = "/wan_android/activity/MainActivity"
/** 用户信息 Activity */
const val ACTIVITY_WAN_ANDROID_USER_INFO = "/wan_android/activity/UserInfoActivity"
/** WebView Activity  */
const val ACTIVITY_WAN_ANDROID_WEB_VIEW = "/wan_android/activity/WebViewActivity"
/** 积分排名 Activity  */
const val ACTIVITY_WAN_ANDROID_COIN_RANK = "/wan_android/activity/CoinRankActivity"
/** 积分明细 Activity  */
const val ACTIVITY_WAN_ANDROID_COIN_RECORD = "/wan_android/activity/CoinRecordActivity"
/** 我的收藏 Activity  */
const val ACTIVITY_WAN_ANDROID_PERSONAL_COLLECTION = "/wan_android/activity/PersonalCollectionActivity"
/** 关于我们 Activity */
const val ACTIVITY_WAN_ANDROID_ABOUT_US = "/wan_android/activity/AboutUsActivity"
/** 知识体系详情 Activity  */
const val ACTIVITY_WAN_ANDROID_KNOWLEDGE_CLASSIFY_DETAIL = "/wan_android/activity/KnowledgeClassifyDetailActivity"

// wan_android 模块 Fragment
/** 首页 Fragment  */
const val FRAGMENT_WAN_ANDROID_HOME = "/wan_android/fragment/HomeFragment"
/** 分类 Fragment  */
const val FRAGMENT_WAN_ANDROID_CLASSIFY = "/wan_android/fragment/ClassifyFragment"
/** 公众号 Fragment  */
const val FRAGMENT_WAN_ANDROID_OFFICIAL_ACCOUNT = "/wan_android/fragment/OfficialAccountFragment"
/** 公众号 二级数据 Fragment */
const val FRAGMENT_WAN_ANDROID_OFFICIAL_ACCOUNT_CHILD = "/wan_android/fragment/OfficialAccountChildFragment"
/** 广场 Fragment  */
const val FRAGMENT_WAN_ANDROID_SQUARE = "/wan_android/fragment/SquareFragment"
/** 项目 Fragment  */
const val FRAGMENT_WAN_ANDROID_PROJECT = "/wan_android/fragment/ProjectFragment"
/** 项目 二级数据 Fragment */
const val FRAGMENT_WAN_ANDROID_PROJECT_CHILD = "/wan_android/fragment/ProjectChildFragment"
/** 知识体系 Fragment  */
const val FRAGMENT_WAN_ANDROID_KNOWLEDGE_CLASSIFY = "/wan_android/fragment/KnowledgeClassifyFragment"
/** 知识体系子页面 Fragment  */
const val FRAGMENT_WAN_ANDROID_KNOWLEDGE_CLASSIFY_CHILD = "/wan_android/fragment/KnowledgeClassifyChildFragment"
/** 导航分类 Fragment  */
const val FRAGMENT_WAN_ANDROID_NAVIGATION_CLASSIFY = "/wan_android/fragment/NavigationClassifyFragment"
/** 我的收藏 -> 收藏文章 Fragment */
const val FRAGMENT_WAN_ANDROID_PERSONAL_COLLECTION_ARTICLE = "/wan_android/fragment/PersonalCollectionArticleFragment"
/** 我的收藏 -> 收藏网站 Fragment */
const val FRAGMENT_WAN_ANDROID_PERSONAL_COLLECTION_WEBSITE = "/wan_android/fragment/PersonalCollectionWebsiteFragment"

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// todo模块 Activity
/** 主页 Activity */
const val ACTIVITY_TODO_MAIN = "/todo/activity/TodoMainActivity"

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////