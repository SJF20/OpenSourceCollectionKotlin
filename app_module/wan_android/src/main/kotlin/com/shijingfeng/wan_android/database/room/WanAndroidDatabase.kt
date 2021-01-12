package com.shijingfeng.wan_android.database.room

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shijingfeng.base.base.application.application
import com.shijingfeng.wan_android.database.room.dao.HomeArticleDao
import com.shijingfeng.wan_android.database.room.dao.HomeBannerDao
import com.shijingfeng.wan_android.database.room.dao.HomeTopArticleDao
import com.shijingfeng.wan_android.database.room.entity.HomeArticleCombineLocal
import com.shijingfeng.wan_android.database.room.entity.HomeTopArticleLocal
import com.shijingfeng.wan_android.database.room.entity.HomeBannerLocal

/** 单例实例 */
@Volatile
private var sInstance: WanAndroidDatabase? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getWanAndroidDataBase(): WanAndroidDatabase {
    if (sInstance == null) {
        synchronized(WanAndroidDatabase::class.java) {
            if (sInstance == null) {
                sInstance =
                    init()
            }
        }
    }
    return sInstance!!
}

private fun init(): WanAndroidDatabase {
    return Room
        .databaseBuilder(
            application,
            WanAndroidDatabase::class.java,
            "wan_android.db"
        )
        .build()
}

/**
 * Function: wan_android 模块 数据库
 * Date: 2020/5/10 14:37
 * Description:
 * Author: ShiJingFeng
 */
//@Database(
//    entities = [
//        // 首页 轮播图
//        HomeBannerLocal::class,
//        // 首页 置顶文章
//        HomeTopArticleLocal::class,
//        // 首页 文章
//        HomeArticleCombineLocal::class
//    ],
//    version = 1
//)
internal abstract class WanAndroidDatabase : RoomDatabase() {

    /**
     * 获取 首页 轮播图 DAO
     */
    abstract fun getHomeBannerDao(): HomeBannerDao

    /**
     * 获取 首页 置顶文章 DAO
     */
    abstract fun getHomeTopArticleDao(): HomeTopArticleDao

    /**
     * 获取 首页 文章 DAO
     */
    abstract fun getHomeArticleDao(): HomeArticleDao

}