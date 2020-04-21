package com.shijingfeng.wan_android.entity.adapter

import com.shijingfeng.base.base.entity.BaseEntity
import com.shijingfeng.wan_android.constant.HOME_ARTICLE
import com.shijingfeng.wan_android.constant.HOME_BANNER
import com.shijingfeng.wan_android.constant.HOME_TOP_ARTICLE
import com.shijingfeng.base.common.constant.ADAPTER_TYPE_UNKNOWN
import com.shijingfeng.wan_android.entity.network.HomeArticleItem

/**
 * Function: 首页 适配器Item 实体抽象类
 * Date: 2020/2/3 19:12
 * Description:
 * @author ShiJingFeng
 */
internal abstract class HomeItem : BaseEntity() {

    /**
     * 获取类型
     * @return 类型
     */
    fun getType(): Int {
        return when(this) {
            // 轮播图
            is HomeBannerListItem -> HOME_BANNER
            // 置顶文章
            is HomeTopArticleItem -> HOME_TOP_ARTICLE
            // 文章
            is HomeArticleItem -> HOME_ARTICLE
            else -> ADAPTER_TYPE_UNKNOWN
        }
    }
}