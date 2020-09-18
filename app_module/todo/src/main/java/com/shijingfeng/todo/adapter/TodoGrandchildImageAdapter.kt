package com.shijingfeng.todo.adapter

import android.content.Context
import android.graphics.BitmapFactory
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.shijingfeng.base.base.adapter.BaseAdapter
import com.shijingfeng.base.base.adapter.BaseMultiItemAdapter
import com.shijingfeng.base.base.adapter.support.MultiItemTypeSupport
import com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder
import com.shijingfeng.base.util.image_load.GlideImageLoader
import com.shijingfeng.base.util.image_load.ImageLoader
import com.shijingfeng.base.util.image_load.getImageLoaderInstance
import com.shijingfeng.todo.R
import com.shijingfeng.todo.constant.VIEW_ORIGINAL_IMAGE
import com.shijingfeng.todo.entity.Image
import com.shijingfeng.todo.entity.Image.Companion.IMAGE_TYPE_DISK
import com.shijingfeng.todo.entity.Image.Companion.IMAGE_TYPE_MEMORY
import com.shijingfeng.todo.entity.Image.Companion.IMAGE_TYPE_NETWORK

/**
 * Function: Item Grandchild 适配器
 * Date: 2020/9/17 22:31
 * Description:
 * @author ShiJingFeng
 */
internal class TodoGrandchildImageAdapter(
    context: Context,
    dataList: List<Image>? = null,
    multiItemTypeSupport: MultiItemTypeSupport<Image>
) : BaseMultiItemAdapter<Image>(
    context,
    dataList,
    multiItemTypeSupport
) {

    /**
     * 用户自定义处理数据 (单个Item内 全局刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     */
    override fun convert(holder: CommonViewHolder, data: Image, position: Int) {
        when (data.imageType) {
            /** 内存中的图片Bitmap */
            IMAGE_TYPE_MEMORY -> getImageLoaderInstance().displayImage(
                context = mContext,
                imageView = holder.getView(R.id.iv_image)!!,
                bitmap = data.imageBitmap
            )
            /** 磁盘图片文件路径 */
            IMAGE_TYPE_DISK,
                /** 网络图片URL地址 */
            IMAGE_TYPE_NETWORK -> getImageLoaderInstance().displayImage(
                context = mContext,
                imageView = holder.getView(R.id.iv_image)!!,
                imagePath = if (data.imageType == IMAGE_TYPE_DISK) data.imageFilePath else data.imageUrl
            )
        }
        holder.setOnClickListener(
            viewId = R.id.iv_image,
            listener = View.OnClickListener { view ->
                mOnItemEvent?.invoke(view, data, position, VIEW_ORIGINAL_IMAGE)
            }
        )
    }

}