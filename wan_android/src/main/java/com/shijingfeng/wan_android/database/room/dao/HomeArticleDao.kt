package com.shijingfeng.wan_android.database.room.dao

import android.database.Cursor
import androidx.room.*
import com.shijingfeng.wan_android.constant.HOME_ARTICLE_FOREIGN_ID
import com.shijingfeng.wan_android.constant.HOME_ARTICLE_ID
import com.shijingfeng.wan_android.constant.HOME_ARTICLE_TABLE_NAME
import com.shijingfeng.wan_android.constant.HOME_ARTICLE_TAG_TABLE_NAME
import com.shijingfeng.wan_android.database.room.entity.HomeArticleCombineLocal
import com.shijingfeng.wan_android.database.room.entity.HomeArticleLocal
import com.shijingfeng.wan_android.database.room.entity.HomeArticleTagLocal

/**
 * Function: 首页 文章 Item DAO
 * Date: 2020/5/10 16:27
 * Description:
 * @author ShiJingFeng
 */
//@Dao
internal interface HomeArticleDao {

    /**
     * 获取表内所有数据
     * @return 表内所有数据
     */
    @Query("SELECT * FROM $HOME_ARTICLE_TABLE_NAME")
    fun getAll(): List<HomeArticleCombineLocal>?

    /**
     * 根据 ID 获取指定 Row
     * @param id ID
     */
    @Query("SELECT * FROM $HOME_ARTICLE_TABLE_NAME WHERE $HOME_ARTICLE_ID = :id")
    fun getById(id: Int): HomeArticleCombineLocal?

    /**
     * 插入文章
     * @param homeArticle
     */
    @Insert
    fun insertArticle(homeArticle: HomeArticleLocal)

    /**
     * 插入多条文章
     * @param homeArticleList
     */
    @Insert
    fun insertArticle(homeArticleList: List<HomeArticleLocal>)

    /**
     * 插入文章内的标签
     * @param homeArticleTag
     */
    fun insertTag(homeArticleTag: HomeArticleTagLocal)

    /**
     * 插入多条文章内的标签
     * @param homeArticleTagList
     */
    fun insertTag(homeArticleTagList: List<HomeArticleTagLocal>)

    /**
     * 更新 (通过文章主键查找更新)
     * @param homeArticle
     */
    @Update
    fun updateArticle(homeArticle: HomeArticleLocal)

    /**
     * 更新标签 (通过文章内的标签主键查找更新)
     */
    @Update
    fun updateTag(homeArticleTag: HomeArticleTagLocal)

    /**
     * 根据 ID 删除 指定的 文章
     * @param articleId [HOME_ARTICLE_ID]
     */
    @Query("DELETE FROM $HOME_ARTICLE_TABLE_NAME WHERE $HOME_ARTICLE_ID = :articleId")
    fun deleteArticleById(articleId: Int)

    /**
     * 根据 ID 删除 指定的 文章内标签
     * @param articleId [HOME_ARTICLE_FOREIGN_ID]
     */
    @Query("DELETE FROM $HOME_ARTICLE_TAG_TABLE_NAME WHERE $HOME_ARTICLE_FOREIGN_ID = :articleId")
    fun deleteTagById(articleId: Int)

    /**
     * 根据 ID 删除 指定的 文章 和 文章内标签
     */
    fun deleteById(id: Int) {
        deleteArticleById(id)
        deleteTagById(id)
    }

    /**
     * 清空 [HOME_ARTICLE_TABLE_NAME]表 中 所有文章
     */
    @Query("DELETE FROM $HOME_ARTICLE_TABLE_NAME")
    fun clearArticle()

    /**
     * 清空 [HOME_ARTICLE_TAG_TABLE_NAME]表 中 所有标签
     */
    @Query("DELETE FROM $HOME_ARTICLE_TAG_TABLE_NAME")
    fun clearTag()

    /**
     * 清空所有文章和标签
     */
    fun clear() {
        clearArticle()
        clearTag()
    }

}