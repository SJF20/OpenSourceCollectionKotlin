package com.shijingfeng.base.base.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.github.chrisbanes.photoview.PhotoView
import com.shijingfeng.base.base.adapter.common.CommonPagerAdapter
import com.shijingfeng.base.common.constant.CLICK
import com.shijingfeng.base.common.constant.LONG_CLICK
import com.shijingfeng.base.entity.ViewOriginalImageItem
import com.shijingfeng.base.util.image_load.ImageLoader
import com.shijingfeng.base.util.image_load.getImageLoaderInstance

/**
 * Function: 查看原图 ViewPager 适配器
 * Date: 2020/1/27 14:20
 * Description:
 * @author ShiJingFeng
 */
class ViewOriginalImageAdapter(
    mContext: Context,
    mDataList: List<ViewOriginalImageItem>? = null
) : CommonPagerAdapter<ViewOriginalImageItem>(mContext, mDataList) {

    /**
     * 初始化 Item
     *
     * @param container 父容器
     * @param position  下标位置
     * @return 初始化生成的View对象
     */
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val data = mDataList!![position]
        val photoView = PhotoView(mContext)

        getImageLoaderInstance().displayImage(mContext, photoView, data.imagePath)
        photoView.setOnClickListener { v: View ->
            mOnItemEvent?.invoke(v, data, position,
                CLICK
            )
        }
        photoView.setOnLongClickListener { v: View ->
            mOnItemEvent?.invoke(v, data, position,
                LONG_CLICK
            )
            return@setOnLongClickListener true
        }

        container.addView(
            photoView,
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        return photoView
    }

}