package com.shijingfeng.view_original_image.adapter

import android.content.Context
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import com.blankj.utilcode.util.ClickUtils
import com.github.chrisbanes.photoview.PhotoView
import com.shijingfeng.base.common.constant.CLICK
import com.shijingfeng.base.common.constant.LONG_CLICK
import com.shijingfeng.base.util.image_load.AS_DRAWABLE
import com.shijingfeng.base.util.image_load.AS_GIF
import com.shijingfeng.view_original_image.entity.ViewOriginalImageItem
import com.shijingfeng.base.util.image_load.getImageLoaderInstance
import com.shijingfeng.base_adapter.CommonPagerAdapter

/**
 * Function: 查看原图 ViewPager 适配器
 * Date: 2020/1/27 14:20
 * Description:
 * Author: ShiJingFeng
 */
internal class ViewOriginalImageAdapter(
    context: Context,
    dataList: List<ViewOriginalImageItem>? = null
) : CommonPagerAdapter<ViewOriginalImageItem>(context, dataList) {

    /**
     * 初始化 Item
     *
     * @param container 父容器
     * @param position  下标位置
     * @return 初始化生成的View对象
     */
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val data = dataList!![position]
        val photoView = PhotoView(context)
        val imagePath = data.imagePath
        val outputType = if (imagePath.endsWith(".gif", true)) AS_GIF else AS_DRAWABLE

        getImageLoaderInstance().displayImage(
            context = context,
            imageView = photoView,
            imagePath = data.imagePath,
            outputType = outputType
        )
        // 点击
        ClickUtils.applySingleDebouncing(photoView) { v ->
            onItemEvent?.invoke(v, data, position, CLICK)
        }
        // 长按
        photoView.setOnLongClickListener onLongClickLabel@{ v ->
            onItemEvent?.invoke(v, data, position, LONG_CLICK)
            return@onLongClickLabel true
        }

        container.addView(photoView, MATCH_PARENT, MATCH_PARENT)
        return photoView
    }

}