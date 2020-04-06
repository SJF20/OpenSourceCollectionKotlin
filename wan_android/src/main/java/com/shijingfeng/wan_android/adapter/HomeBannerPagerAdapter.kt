package com.shijingfeng.wan_android.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.blankj.utilcode.util.ClickUtils
import com.blankj.utilcode.util.ConvertUtils
import com.shijingfeng.base.listener.Target
import com.shijingfeng.base.util.image_load.getImageLoaderInstance
import com.shijingfeng.sjf_banner.library.banner.adapter.BaseBannerPagerAdapter
import com.shijingfeng.wan_android.constant.VIEW_BANNER_DETAIL
import com.shijingfeng.wan_android.entity.network.HomeBannerEntity

/**
 * Function: 首页轮播图ViewPager适配器
 * Date: 2020/2/3 22:19
 * Description:
 * @author ShiJingFeng
 */
internal class HomeBannerPagerAdapter(
    context: Context,
    dataList: List<HomeBannerEntity>? = null
) : BaseBannerPagerAdapter<HomeBannerEntity>(context, dataList) {

    /**
     * 初始化 Item
     * @param container 容器 ViewGroup
     * @param position 当前 Item 索引
     */
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageView = ImageView(mContext)
        val realPosition = getRealPositionByPosition(position)
        val homeBanner = mDataList[realPosition]

        getImageLoaderInstance().displayImage(mContext, imageView, homeBanner.imagePath)
        container.addView(
            imageView,
            ViewGroup.LayoutParams.MATCH_PARENT,
            ConvertUtils.dp2px(200F)
        )

        // 查看详情
        ClickUtils.applySingleDebouncing(imageView) { v ->
            mOnItemEventListener?.onItemEvent(v, homeBanner, realPosition, VIEW_BANNER_DETAIL)
        }

        return imageView
    }

}