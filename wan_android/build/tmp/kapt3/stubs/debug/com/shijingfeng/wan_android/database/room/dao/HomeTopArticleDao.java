package com.shijingfeng.wan_android.database.room.dao;

import java.lang.System;

/**
 * Function: 首页 置顶文章 Item DAO
 * Date: 2020/5/10 16:27
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\'J\b\u0010\u0005\u001a\u00020\u0003H\'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH\'J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH\'J\u0010\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\'J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\bH\'J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0016\u0010\u0010\u001a\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\rH&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\'J\u0016\u0010\u0014\u001a\u00020\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\rH\'J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\'J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0016H\'\u00a8\u0006\u001b"}, d2 = {"Lcom/shijingfeng/wan_android/database/room/dao/HomeTopArticleDao;", "", "clear", "", "clearTag", "clearTopArticle", "deleteById", "id", "", "deleteTagById", "articleId", "deleteTopArticleById", "getAll", "", "Lcom/shijingfeng/wan_android/database/room/entity/HomeTopArticleCombineLocal;", "getById", "insertTag", "homeTopArticleTag", "Lcom/shijingfeng/wan_android/database/room/entity/HomeTopArticleTagLocal;", "homeTopArticleTagList", "insertTopArticle", "homeTopArticleLocal", "Lcom/shijingfeng/wan_android/database/room/entity/HomeTopArticleLocal;", "homeTopArticleLocalList", "updateTag", "updateTopArticle", "homeTopArticle", "wan_android_debug"})
public abstract interface HomeTopArticleDao {
    
    /**
     * 获取表内所有数据
     * @return 表内所有数据
     */
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM home_top_article")
    public abstract java.util.List<com.shijingfeng.wan_android.database.room.entity.HomeTopArticleCombineLocal> getAll();
    
    /**
     * 根据 ID 获取指定 Row
     * @param id ID
     */
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM home_top_article WHERE id = :id")
    public abstract com.shijingfeng.wan_android.database.room.entity.HomeTopArticleCombineLocal getById(int id);
    
    /**
     * 插入文章
     * @param homeTopArticleLocal
     */
    @androidx.room.Insert()
    public abstract void insertTopArticle(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.wan_android.database.room.entity.HomeTopArticleLocal homeTopArticleLocal);
    
    /**
     * 插入多条文章
     * @param homeTopArticleLocalList
     */
    @androidx.room.Insert()
    public abstract void insertTopArticle(@org.jetbrains.annotations.NotNull()
    java.util.List<com.shijingfeng.wan_android.database.room.entity.HomeTopArticleLocal> homeTopArticleLocalList);
    
    /**
     * 插入文章内的标签
     * @param homeTopArticleTag
     */
    public abstract void insertTag(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.wan_android.database.room.entity.HomeTopArticleTagLocal homeTopArticleTag);
    
    /**
     * 插入多条文章内的标签
     * @param homeTopArticleTagList
     */
    public abstract void insertTag(@org.jetbrains.annotations.NotNull()
    java.util.List<com.shijingfeng.wan_android.database.room.entity.HomeTopArticleTagLocal> homeTopArticleTagList);
    
    /**
     * 更新 (通过文章主键查找更新)
     * @param homeTopArticle
     */
    @androidx.room.Update()
    public abstract void updateTopArticle(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.wan_android.database.room.entity.HomeTopArticleLocal homeTopArticle);
    
    /**
     * 更新标签 (通过文章内的标签主键查找更新)
     * @param homeTopArticleTag
     */
    @androidx.room.Update()
    public abstract void updateTag(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.wan_android.database.room.entity.HomeTopArticleTagLocal homeTopArticleTag);
    
    /**
     * 根据 ID 删除 指定的 文章
     * @param articleId [HOME_TOP_ARTICLE_ID]
     */
    @androidx.room.Query(value = "DELETE FROM home_top_article WHERE id = :articleId")
    public abstract void deleteTopArticleById(int articleId);
    
    /**
     * 根据 ID 删除 指定的 文章内标签
     * @param articleId [HOME_TOP_ARTICLE_FOREIGN_ID]
     */
    @androidx.room.Query(value = "DELETE FROM home_top_article_tag WHERE home_top_article_foreign_id = :articleId")
    public abstract void deleteTagById(int articleId);
    
    /**
     * 根据 ID 删除 指定的 文章 和 文章内标签
     */
    public abstract void deleteById(int id);
    
    /**
     * 清空 [HOME_TOP_ARTICLE_TABLE_NAME]表 中 所有文章
     */
    @androidx.room.Query(value = "DELETE FROM home_top_article")
    public abstract void clearTopArticle();
    
    /**
     * 清空 [HOME_TOP_ARTICLE_TAG_TABLE_NAME]表 中 所有标签
     */
    @androidx.room.Query(value = "DELETE FROM home_top_article_tag")
    public abstract void clearTag();
    
    /**
     * 清空所有文章和标签
     */
    public abstract void clear();
    
    /**
     * Function: 首页 置顶文章 Item DAO
     * Date: 2020/5/10 16:27
     * Description:
     * @author ShiJingFeng
     */
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        /**
         * 根据 ID 删除 指定的 文章 和 文章内标签
         */
        public static void deleteById(com.shijingfeng.wan_android.database.room.dao.HomeTopArticleDao $this, int id) {
        }
        
        /**
         * 清空所有文章和标签
         */
        public static void clear(com.shijingfeng.wan_android.database.room.dao.HomeTopArticleDao $this) {
        }
    }
}