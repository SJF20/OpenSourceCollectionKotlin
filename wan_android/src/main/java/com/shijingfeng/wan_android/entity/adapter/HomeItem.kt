package com.shijingfeng.wan_android.entity.adapter

import com.shijingfeng.base.base.entity.BaseEntity
import com.shijingfeng.wan_android.constant.HOME_ARTICLE
import com.shijingfeng.wan_android.constant.HOME_BANNER
import com.shijingfeng.wan_android.constant.HOME_SET_TO_TOP
import com.shijingfeng.wan_android.constant.HOME_UNKNOWN
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
            is HomeBannerItem -> HOME_BANNER
            is HomeSetToTopItem -> HOME_SET_TO_TOP
            is HomeArticleItem -> HOME_ARTICLE
            else -> HOME_UNKNOWN
        }
    }
}