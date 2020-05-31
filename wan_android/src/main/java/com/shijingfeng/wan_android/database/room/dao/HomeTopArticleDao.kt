package com.shijingfeng.wan_android.database.room.dao

import android.database.Cursor
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.shijingfeng.wan_android.common.constant.HOME_TOP_ARTICLE_FOREIGN_ID
import com.shijingfeng.wan_android.common.constant.HOME_TOP_ARTICLE_ID
import com.shijingfeng.wan_android.common.constant.HOME_TOP_ARTICLE_TABLE_NAME
import com.shijingfeng.wan_android.common.constant.HOME_TOP_ARTICLE_TAG_TABLE_NAME
import com.shijingfeng.wan_android.database.room.entity.HomeTopArticleCombineLocal
import com.shijingfeng.wan_android.database.room.entity.HomeTopArticleLocal
import com.shijingfeng.wan_android.database.room.entity.HomeTopArticleTagLocal

/**
 * Function: 首页 置顶文章 Item DAO
 * Date: 2020/5/10 16:27
 * Description:
 * @author ShiJingFeng
 */
//@Dao
internal interface HomeTopArticleDao {

    /**
     * 获取表内所有数据
     * @return 表内所有数据
     */
    @Query("SELECT * FROM $HOME_TOP_ARTICLE_TABLE_NAME")
    fun getAll(): List<HomeTopArticleCombineLocal>?

    /**
     * 根据 ID 获取指定 Row
     * @param id ID
     */
    @Query("SELECT * FROM $HOME_TOP_ARTICLE_TABLE_NAME WHERE $HOME_TOP_ARTICLE_ID = :id")
    fun getById(id: Int): HomeTopArticleCombineLocal?

    /**
     * 插入文章
     * @param homeTopArticleLocal
     */
    @Insert
    fun insertTopArticle(homeTopArticleLocal: HomeTopArticleLocal)

    /**
     * 插入多条文章
     * @param homeTopArticleLocalList
     */
    @Insert
    fun insertTopArticle(homeTopArticleLocalList: List<HomeTopArticleLocal>)

    /**
     * 插入文章内的标签
     * @param homeTopArticleTag
     */
    fun insertTag(homeTopArticleTag: HomeTopArticleTagLocal)

    /**
     * 插入多条文章内的标签
     * @param homeTopArticleTagList
     */
    fun insertTag(homeTopArticleTagList: List<HomeTopArticleTagLocal>)

    /**
     * 更新 (通过文章主键查找更新)
     * @param homeTopArticle
     */
    @Update
    fun updateTopArticle(homeTopArticle: HomeTopArticleLocal)

    /**
     * 更新标签 (通过文章内的标签主键查找更新)
     * @param homeTopArticleTag
     */
    @Update
    fun updateTag(homeTopArticleTag: HomeTopArticleTagLocal)

    /**
     * 根据 ID 删除 指定的 文章
     * @param articleId [HOME_TOP_ARTICLE_ID]
     */
    @Query("DELETE FROM $HOME_TOP_ARTICLE_TABLE_NAME WHERE $HOME_TOP_ARTICLE_ID = :articleId")
    fun deleteTopArticleById(articleId: Int)

    /**
     * 根据 ID 删除 指定的 文章内标签
     * @param articleId [HOME_TOP_ARTICLE_FOREIGN_ID]
     */
    @Query("DELETE FROM $HOME_TOP_ARTICLE_TAG_TABLE_NAME WHERE $HOME_TOP_ARTICLE_FOREIGN_ID = :articleId")
    fun deleteTagById(articleId: Int)

    /**
     * 根据 ID 删除 指定的 文章 和 文章内标签
     */
    fun deleteById(id: Int) {
        deleteTopArticleById(id)
        deleteTagById(id)
    }

    /**
     * 清空 [HOME_TOP_ARTICLE_TABLE_NAME]表 中 所有文章
     */
    @Query("DELETE FROM $HOME_TOP_ARTICLE_TABLE_NAME")
    fun clearTopArticle()

    /**
     * 清空 [HOME_TOP_ARTICLE_TAG_TABLE_NAME]表 中 所有标签
     */
    @Query("DELETE FROM $HOME_TOP_ARTICLE_TAG_TABLE_NAME")
    fun clearTag()

    /**
     * 清空所有文章和标签
     */
    fun clear() {
        clearTopArticle()
        clearTag()
    }

}