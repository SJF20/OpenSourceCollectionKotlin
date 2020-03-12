package com.shijingfeng.wan_android.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.ViewGroup
import android.widget.ImageView
import com.blankj.utilcode.util.ConvertUtils
import com.shijingfeng.base.listener.Target
import com.shijingfeng.base.util.image_load.ImageLoader
import com.shijingfeng.base.util.image_load.getImageLoaderInstance
import com.shijingfeng.library.banner.adapter.BaseBannerPagerAdapter
import com.shijingfeng.wan_android.constant.VIEW_BANNER_DETAIL
import com.shijingfeng.wan_android.entity.network.HomeBannerEntity

/**
 * Function: 首页轮播图ViewPager适配器
 * Date: 2020/2/3 22:19
 * Description:
 * @author ShiJingFeng
 */
class HomeBannerPagerAdapter(
    mContext: Context,
    mDataList: List<HomeBannerEntity>? = null
) : BaseBannerPagerAdapter<HomeBannerEntity>(mContext, mDataList) {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageView = ImageView(mContext)
        val realPosition = getRealPositionByPosition(position)
        val homeBanner = mDataList[realPosition]

        getImageLoaderInstance().displayImage(
            mContext,
            homeBanner.imagePath,
            object : Target<Drawable?> {

                /**
                 * 加载完成
                 *
                 * @param resource 资源
                 */
                override fun onLoadFinished(resource: Drawable?) {
                    imageView.setImageDrawable(resource)
                }

            }
        )
        imageView.setOnClickListener { v ->
            mOnItemEventListener?.onItemEvent(v, homeBanner, realPosition, VIEW_BANNER_DETAIL)
        }
        container.addView(
            imageView,
            ViewGroup.LayoutParams.MATCH_PARENT,
            ConvertUtils.dp2px(200f)
        )

        return imageView
    }

}