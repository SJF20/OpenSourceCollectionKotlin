package com.shijingfeng.base.arouter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b$\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"ACTIVITY_APP_MAIN", "", "ACTIVITY_APP_SPLASH", "ACTIVITY_COMMON_VIEW_ORIGINAL_IMAGE", "ACTIVITY_TODO_MAIN", "ACTIVITY_WAN_ANDROID_ABOUT_US", "ACTIVITY_WAN_ANDROID_COIN_RANK", "ACTIVITY_WAN_ANDROID_COIN_RECORD", "ACTIVITY_WAN_ANDROID_KNOWLEDGE_CLASSIFY_DETAIL", "ACTIVITY_WAN_ANDROID_LOGIN", "ACTIVITY_WAN_ANDROID_MAIN", "ACTIVITY_WAN_ANDROID_PERSONAL_COLLECTION", "ACTIVITY_WAN_ANDROID_REGISTER", "ACTIVITY_WAN_ANDROID_SEARCH", "ACTIVITY_WAN_ANDROID_SEARCH_LIST", "ACTIVITY_WAN_ANDROID_SETTING", "ACTIVITY_WAN_ANDROID_SPLASH", "ACTIVITY_WAN_ANDROID_USER_INFO", "ACTIVITY_WAN_ANDROID_WEB_VIEW", "FRAGMENT_TODO_DONE", "FRAGMENT_TODO_TODO", "FRAGMENT_WAN_ANDROID_CLASSIFY", "FRAGMENT_WAN_ANDROID_HOME", "FRAGMENT_WAN_ANDROID_KNOWLEDGE_CLASSIFY", "FRAGMENT_WAN_ANDROID_KNOWLEDGE_CLASSIFY_CHILD", "FRAGMENT_WAN_ANDROID_NAVIGATION_CLASSIFY", "FRAGMENT_WAN_ANDROID_OFFICIAL_ACCOUNT", "FRAGMENT_WAN_ANDROID_OFFICIAL_ACCOUNT_CHILD", "FRAGMENT_WAN_ANDROID_PERSONAL_COLLECTION_ARTICLE", "FRAGMENT_WAN_ANDROID_PERSONAL_COLLECTION_WEBSITE", "FRAGMENT_WAN_ANDROID_PROJECT", "FRAGMENT_WAN_ANDROID_PROJECT_CHILD", "FRAGMENT_WAN_ANDROID_SQUARE", "PROVIDER_BASE_COMMON_DEGRADE_SERVICE", "PROVIDER_BASE_COMMON_PATH_REPLACE_SERVICE", "PROVIDER_BASE_COMMON_PRETREATMENT_SERVICE", "PROVIDER_WAN_ANDROID_LOGIN_INTERCEPT", "base_release"})
public final class ARouterConstant {
    
    /**
     * 通用降级 Provider
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PROVIDER_BASE_COMMON_DEGRADE_SERVICE = "/base/provider/DegradeServiceImpl";
    
    /**
     * 通用路径替换 Provider
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PROVIDER_BASE_COMMON_PATH_REPLACE_SERVICE = "/base/provider/PathReplaceServiceImpl";
    
    /**
     * 通用跳转前预处理 Provider
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PROVIDER_BASE_COMMON_PRETREATMENT_SERVICE = "/base/provider/PretreatmentServiceImpl";
    
    /**
     * 查看大图 Activity
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTIVITY_COMMON_VIEW_ORIGINAL_IMAGE = "/common/activity/ViewOriginalImageActivity";
    
    /**
     * 启动页 Activity
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTIVITY_APP_SPLASH = "/app/activity/SplashActivity";
    
    /**
     * 主页 Activity
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTIVITY_APP_MAIN = "/app/activity/MainActivity";
    
    /**
     * 登录拦截 Provider
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PROVIDER_WAN_ANDROID_LOGIN_INTERCEPT = "/wan_android/activity/LoginInterceptProvider";
    
    /**
     * 启动页 Activity
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTIVITY_WAN_ANDROID_SPLASH = "/wan_android/activity/SplashActivity";
    
    /**
     * 登录 Activity
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTIVITY_WAN_ANDROID_LOGIN = "/wan_android/activity/LoginActivity";
    
    /**
     * 注册 Activity
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTIVITY_WAN_ANDROID_REGISTER = "/wan_android/activity/RegisterActivity";
    
    /**
     * 主页 Activity
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTIVITY_WAN_ANDROID_MAIN = "/wan_android/activity/MainActivity";
    
    /**
     * 用户信息 Activity
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTIVITY_WAN_ANDROID_USER_INFO = "/wan_android/activity/UserInfoActivity";
    
    /**
     * WebView Activity
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTIVITY_WAN_ANDROID_WEB_VIEW = "/wan_android/activity/WebViewActivity";
    
    /**
     * 积分排名 Activity
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTIVITY_WAN_ANDROID_COIN_RANK = "/wan_android/activity/CoinRankActivity";
    
    /**
     * 积分明细 Activity
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTIVITY_WAN_ANDROID_COIN_RECORD = "/wan_android/activity/CoinRecordActivity";
    
    /**
     * 我的收藏 Activity
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTIVITY_WAN_ANDROID_PERSONAL_COLLECTION = "/wan_android/activity/PersonalCollectionActivity";
    
    /**
     * 系统设置 Activity
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTIVITY_WAN_ANDROID_SETTING = "/wan_android/activity/SettingActivity";
    
    /**
     * 关于我们 Activity
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTIVITY_WAN_ANDROID_ABOUT_US = "/wan_android/activity/AboutUsActivity";
    
    /**
     * 知识体系详情 Activity
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTIVITY_WAN_ANDROID_KNOWLEDGE_CLASSIFY_DETAIL = "/wan_android/activity/KnowledgeClassifyDetailActivity";
    
    /**
     * 搜索 Activity
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTIVITY_WAN_ANDROID_SEARCH = "/wan_android/activity/SearchActivity";
    
    /**
     * 搜索列表 Activity
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTIVITY_WAN_ANDROID_SEARCH_LIST = "/wan_android/activity/SearchListActivity";
    
    /**
     * 首页 Fragment
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FRAGMENT_WAN_ANDROID_HOME = "/wan_android/fragment/HomeFragment";
    
    /**
     * 分类 Fragment
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FRAGMENT_WAN_ANDROID_CLASSIFY = "/wan_android/fragment/ClassifyFragment";
    
    /**
     * 公众号 Fragment
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FRAGMENT_WAN_ANDROID_OFFICIAL_ACCOUNT = "/wan_android/fragment/OfficialAccountFragment";
    
    /**
     * 公众号 二级数据 Fragment
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FRAGMENT_WAN_ANDROID_OFFICIAL_ACCOUNT_CHILD = "/wan_android/fragment/OfficialAccountChildFragment";
    
    /**
     * 广场 Fragment
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FRAGMENT_WAN_ANDROID_SQUARE = "/wan_android/fragment/SquareFragment";
    
    /**
     * 项目 Fragment
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FRAGMENT_WAN_ANDROID_PROJECT = "/wan_android/fragment/ProjectFragment";
    
    /**
     * 项目 二级数据 Fragment
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FRAGMENT_WAN_ANDROID_PROJECT_CHILD = "/wan_android/fragment/ProjectChildFragment";
    
    /**
     * 知识体系 Fragment
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FRAGMENT_WAN_ANDROID_KNOWLEDGE_CLASSIFY = "/wan_android/fragment/KnowledgeClassifyFragment";
    
    /**
     * 知识体系子页面 Fragment
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FRAGMENT_WAN_ANDROID_KNOWLEDGE_CLASSIFY_CHILD = "/wan_android/fragment/KnowledgeClassifyChildFragment";
    
    /**
     * 导航分类 Fragment
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FRAGMENT_WAN_ANDROID_NAVIGATION_CLASSIFY = "/wan_android/fragment/NavigationClassifyFragment";
    
    /**
     * 我的收藏 -> 收藏文章 Fragment
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FRAGMENT_WAN_ANDROID_PERSONAL_COLLECTION_ARTICLE = "/wan_android/fragment/PersonalCollectionArticleFragment";
    
    /**
     * 我的收藏 -> 收藏网站 Fragment
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FRAGMENT_WAN_ANDROID_PERSONAL_COLLECTION_WEBSITE = "/wan_android/fragment/PersonalCollectionWebsiteFragment";
    
    /**
     * 主页 Activity
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTIVITY_TODO_MAIN = "/todo/activity/MainActivity";
    
    /**
     * 主页 -> 待办 Fragment
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FRAGMENT_TODO_TODO = "/todo/fragment/TodoFragment";
    
    /**
     * 主页 -> 已完成 Fragment
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FRAGMENT_TODO_DONE = "/todo/fragment/DoneFragment";
}