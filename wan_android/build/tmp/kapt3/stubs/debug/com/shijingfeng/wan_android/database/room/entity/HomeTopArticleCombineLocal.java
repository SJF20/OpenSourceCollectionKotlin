package com.shijingfeng.wan_android.database.room.entity;

import java.lang.System;

/**
 * 首页文章 和 首页文章中标签列表 组合 本地实体类
 * 原因: Room Entity 中 不允许 嵌套 Entity
 * 详解: 分为 [HOME_TOP_ARTICLE_TABLE_NAME]表 (1表), [HOME_TOP_ARTICLE_TAG_TABLE_NAME]表 (2表)
 * 所有的文章数据放在 1表 中，所有的文章标签放在 2表 中，因为 2表 中 有 [HOME_ARTICLE_FOREIGN_ID]，
 * 所以可以根据 文章ID 查询到 对应的文章标签列表，那么 文章 和 文章标签列表 就 一对多 对应起来了
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u00c6\u0003J\'\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/shijingfeng/wan_android/database/room/entity/HomeTopArticleCombineLocal;", "", "homeTopArticle", "Lcom/shijingfeng/wan_android/database/room/entity/HomeTopArticleLocal;", "homeTopArticleTagList", "", "Lcom/shijingfeng/wan_android/database/room/entity/HomeTopArticleTagLocal;", "(Lcom/shijingfeng/wan_android/database/room/entity/HomeTopArticleLocal;Ljava/util/List;)V", "getHomeTopArticle", "()Lcom/shijingfeng/wan_android/database/room/entity/HomeTopArticleLocal;", "setHomeTopArticle", "(Lcom/shijingfeng/wan_android/database/room/entity/HomeTopArticleLocal;)V", "getHomeTopArticleTagList", "()Ljava/util/List;", "setHomeTopArticleTagList", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "wan_android_debug"})
public final class HomeTopArticleCombineLocal {
    
    /**
     * 首页 文章
     */
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Embedded()
    private com.shijingfeng.wan_android.database.room.entity.HomeTopArticleLocal homeTopArticle;
    
    /**
     * 首页文章中的标签列表
     */
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Relation(parentColumn = "id", entityColumn = "home_top_article_foreign_id")
    private java.util.List<com.shijingfeng.wan_android.database.room.entity.HomeTopArticleTagLocal> homeTopArticleTagList;
    
    /**
     * 首页 文章
     */
    @org.jetbrains.annotations.Nullable()
    public final com.shijingfeng.wan_android.database.room.entity.HomeTopArticleLocal getHomeTopArticle() {
        return null;
    }
    
    /**
     * 首页 文章
     */
    public final void setHomeTopArticle(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.database.room.entity.HomeTopArticleLocal p0) {
    }
    
    /**
     * 首页文章中的标签列表
     */
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.shijingfeng.wan_android.database.room.entity.HomeTopArticleTagLocal> getHomeTopArticleTagList() {
        return null;
    }
    
    /**
     * 首页文章中的标签列表
     */
    public final void setHomeTopArticleTagList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.shijingfeng.wan_android.database.room.entity.HomeTopArticleTagLocal> p0) {
    }
    
    public HomeTopArticleCombineLocal(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.database.room.entity.HomeTopArticleLocal homeTopArticle, @org.jetbrains.annotations.Nullable()
    java.util.List<com.shijingfeng.wan_android.database.room.entity.HomeTopArticleTagLocal> homeTopArticleTagList) {
        super();
    }
    
    /**
     * 首页 文章
     */
    @org.jetbrains.annotations.Nullable()
    public final com.shijingfeng.wan_android.database.room.entity.HomeTopArticleLocal component1() {
        return null;
    }
    
    /**
     * 首页文章中的标签列表
     */
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.shijingfeng.wan_android.database.room.entity.HomeTopArticleTagLocal> component2() {
        return null;
    }
    
    /**
     * 首页文章 和 首页文章中标签列表 组合 本地实体类
     * 原因: Room Entity 中 不允许 嵌套 Entity
     * 详解: 分为 [HOME_TOP_ARTICLE_TABLE_NAME]表 (1表), [HOME_TOP_ARTICLE_TAG_TABLE_NAME]表 (2表)
     * 所有的文章数据放在 1表 中，所有的文章标签放在 2表 中，因为 2表 中 有 [HOME_ARTICLE_FOREIGN_ID]，
     * 所以可以根据 文章ID 查询到 对应的文章标签列表，那么 文章 和 文章标签列表 就 一对多 对应起来了
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.wan_android.database.room.entity.HomeTopArticleCombineLocal copy(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.database.room.entity.HomeTopArticleLocal homeTopArticle, @org.jetbrains.annotations.Nullable()
    java.util.List<com.shijingfeng.wan_android.database.room.entity.HomeTopArticleTagLocal> homeTopArticleTagList) {
        return null;
    }
    
    /**
     * 首页文章 和 首页文章中标签列表 组合 本地实体类
     * 原因: Room Entity 中 不允许 嵌套 Entity
     * 详解: 分为 [HOME_TOP_ARTICLE_TABLE_NAME]表 (1表), [HOME_TOP_ARTICLE_TAG_TABLE_NAME]表 (2表)
     * 所有的文章数据放在 1表 中，所有的文章标签放在 2表 中，因为 2表 中 有 [HOME_ARTICLE_FOREIGN_ID]，
     * 所以可以根据 文章ID 查询到 对应的文章标签列表，那么 文章 和 文章标签列表 就 一对多 对应起来了
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * 首页文章 和 首页文章中标签列表 组合 本地实体类
     * 原因: Room Entity 中 不允许 嵌套 Entity
     * 详解: 分为 [HOME_TOP_ARTICLE_TABLE_NAME]表 (1表), [HOME_TOP_ARTICLE_TAG_TABLE_NAME]表 (2表)
     * 所有的文章数据放在 1表 中，所有的文章标签放在 2表 中，因为 2表 中 有 [HOME_ARTICLE_FOREIGN_ID]，
     * 所以可以根据 文章ID 查询到 对应的文章标签列表，那么 文章 和 文章标签列表 就 一对多 对应起来了
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * 首页文章 和 首页文章中标签列表 组合 本地实体类
     * 原因: Room Entity 中 不允许 嵌套 Entity
     * 详解: 分为 [HOME_TOP_ARTICLE_TABLE_NAME]表 (1表), [HOME_TOP_ARTICLE_TAG_TABLE_NAME]表 (2表)
     * 所有的文章数据放在 1表 中，所有的文章标签放在 2表 中，因为 2表 中 有 [HOME_ARTICLE_FOREIGN_ID]，
     * 所以可以根据 文章ID 查询到 对应的文章标签列表，那么 文章 和 文章标签列表 就 一对多 对应起来了
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}