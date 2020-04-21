package com.shijingfeng.wan_android.entity.network

import com.shijingfeng.base.base.entity.BaseEntity
import com.shijingfeng.wan_android.entity.adapter.HomeBannerListItem
import com.shijingfeng.wan_android.entity.adapter.HomeTopArticleItem
import okhttp3.internal.immutableListOf

/**
 * Function: 首页数据 聚合
 * Date: 2020/2/4 16:04
 * Description:
 * @author ShiJingFeng
 */
internal data class HomeDataEntity(

    /** 首页 轮播图数据 */
    var homeBannerListItem: HomeBannerListItem = HomeBannerListItem(),
    /** 首页 置顶文章数据 */
    var homeTopArticleItemList: List<HomeTopArticleItem> = immutableListOf(),
    /** 首页 文章数据 */
    var homeArticle: HomeArticleEntity = HomeArticleEntity()

) : BaseEntity()