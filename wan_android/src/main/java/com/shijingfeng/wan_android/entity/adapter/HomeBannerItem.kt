package com.shijingfeng.wan_android.entity.adapter

import com.shijingfeng.wan_android.entity.network.HomeBannerEntity

/**
 * Function: 首页轮播图 适配器Item 实体类
 * Date: 2020/2/3 19:14
 * Description:
 * @author ShiJingFeng
 */
internal class HomeBannerItem(

    /** 轮播图数据 */
    var homeBannerList: List<HomeBannerEntity> = ArrayList()

) : HomeItem()