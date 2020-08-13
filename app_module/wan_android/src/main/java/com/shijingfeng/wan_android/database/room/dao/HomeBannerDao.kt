package com.shijingfeng.wan_android.database.room.dao

import android.database.Cursor
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.shijingfeng.wan_android.common.constant.HOME_BANNER_ID
import com.shijingfeng.wan_android.common.constant.HOME_BANNER_TABLE_NAME
import com.shijingfeng.wan_android.database.room.entity.HomeBannerLocal

/**
 * Function: 首页 轮播图 Item DAO
 * Date: 2020/5/10 16:26
 * Description:
 * @author ShiJingFeng
 */
//@Dao
internal interface HomeBannerDao {

    /**
     * 获取表内所有数据
     * @return 表内所有数据
     */
    @Query("SELECT * FROM $HOME_BANNER_TABLE_NAME")
    fun getAll(): List<HomeBannerLocal>?

    /**
     * 插入轮播图
     * @param homeBannerLocal
     */
    @Insert
    fun insert(homeBannerLocal: HomeBannerLocal)

    /**
     * 插入轮播图列表
     * @param homeBannerLocalList
     */
    @Insert
    fun insert(homeBannerLocalList: List<HomeBannerLocal>)

    /**
     * 更新 (通过轮播图主键查找更新)
     * @param homeBannerLocal
     */
    @Update
    fun update(homeBannerLocal: HomeBannerLocal)

    /**
     * 根据 ID 删除 指定的 轮播图
     * @param id 轮播图 ID
     */
    @Query("DELETE FROM $HOME_BANNER_TABLE_NAME WHERE $HOME_BANNER_ID = :id")
    fun deleteTagById(id: Int)

    /**
     * 清空
     */
    @Query("DELETE FROM $HOME_BANNER_TABLE_NAME")
    fun clear()

}