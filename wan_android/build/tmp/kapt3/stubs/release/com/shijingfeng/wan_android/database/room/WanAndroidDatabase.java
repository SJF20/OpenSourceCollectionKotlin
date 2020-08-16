package com.shijingfeng.wan_android.database.room;

import java.lang.System;

/**
 * Function: wan_android 模块 数据库
 * Date: 2020/5/10 14:37
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b \u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/shijingfeng/wan_android/database/room/WanAndroidDatabase;", "Landroidx/room/RoomDatabase;", "()V", "getHomeArticleDao", "Lcom/shijingfeng/wan_android/database/room/dao/HomeArticleDao;", "getHomeBannerDao", "Lcom/shijingfeng/wan_android/database/room/dao/HomeBannerDao;", "getHomeTopArticleDao", "Lcom/shijingfeng/wan_android/database/room/dao/HomeTopArticleDao;", "wan_android_release"})
public abstract class WanAndroidDatabase extends androidx.room.RoomDatabase {
    
    /**
     * 获取 首页 轮播图 DAO
     */
    @org.jetbrains.annotations.NotNull()
    public abstract com.shijingfeng.wan_android.database.room.dao.HomeBannerDao getHomeBannerDao();
    
    /**
     * 获取 首页 置顶文章 DAO
     */
    @org.jetbrains.annotations.NotNull()
    public abstract com.shijingfeng.wan_android.database.room.dao.HomeTopArticleDao getHomeTopArticleDao();
    
    /**
     * 获取 首页 文章 DAO
     */
    @org.jetbrains.annotations.NotNull()
    public abstract com.shijingfeng.wan_android.database.room.dao.HomeArticleDao getHomeArticleDao();
    
    public WanAndroidDatabase() {
        super();
    }
}