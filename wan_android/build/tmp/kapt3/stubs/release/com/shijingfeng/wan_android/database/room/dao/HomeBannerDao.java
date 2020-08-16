package com.shijingfeng.wan_android.database.room.dao;

import java.lang.System;

/**
 * Function: 首页 轮播图 Item DAO
 * Date: 2020/5/10 16:26
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\'J\u0016\u0010\n\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bH\'J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\'\u00a8\u0006\u000e"}, d2 = {"Lcom/shijingfeng/wan_android/database/room/dao/HomeBannerDao;", "", "clear", "", "deleteTagById", "id", "", "getAll", "", "Lcom/shijingfeng/wan_android/database/room/entity/HomeBannerLocal;", "insert", "homeBannerLocal", "homeBannerLocalList", "update", "wan_android_release"})
public abstract interface HomeBannerDao {
    
    /**
     * 获取表内所有数据
     * @return 表内所有数据
     */
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM home_banner")
    public abstract java.util.List<com.shijingfeng.wan_android.database.room.entity.HomeBannerLocal> getAll();
    
    /**
     * 插入轮播图
     * @param homeBannerLocal
     */
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.wan_android.database.room.entity.HomeBannerLocal homeBannerLocal);
    
    /**
     * 插入轮播图列表
     * @param homeBannerLocalList
     */
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    java.util.List<com.shijingfeng.wan_android.database.room.entity.HomeBannerLocal> homeBannerLocalList);
    
    /**
     * 更新 (通过轮播图主键查找更新)
     * @param homeBannerLocal
     */
    @androidx.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.wan_android.database.room.entity.HomeBannerLocal homeBannerLocal);
    
    /**
     * 根据 ID 删除 指定的 轮播图
     * @param id 轮播图 ID
     */
    @androidx.room.Query(value = "DELETE FROM home_banner WHERE id = :id")
    public abstract void deleteTagById(int id);
    
    /**
     * 清空
     */
    @androidx.room.Query(value = "DELETE FROM home_banner")
    public abstract void clear();
}