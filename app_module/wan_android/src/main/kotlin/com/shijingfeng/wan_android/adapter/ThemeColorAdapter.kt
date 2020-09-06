package com.shijingfeng.wan_android.adapter

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.view.View
import com.blankj.utilcode.util.SizeUtils
import com.shijingfeng.base.base.adapter.BaseAdapter
import com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder
import com.shijingfeng.base.common.constant.SELECTED
import com.shijingfeng.base.util.getDrawableById
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.common.global.themeColorList
import com.shijingfeng.wan_android.entity.adapter.ThemeColorItem
import com.shijingfeng.wan_android.utils.ThemeUtil

/**
 * Function: 主题颜色 适配器
 * Date: 2020/5/31 11:19
 * Description:
 * @author ShiJingFeng
 */
internal class ThemeColorAdapter(
    context: Context
) : BaseAdapter<ThemeColorItem>(
    context = context,
    layoutId = R.layout.adapter_item_theme_color
) {

    /** 前一个选中的 Position */
    private var mPreChoosePosition = -1

    init {
        mDataList = themeColorList.mapIndexed { index, color ->
            var isSelected = false

            if (!isSelected) {
                if (ThemeUtil.curThemeColor == color) {
                    isSelected = true
                    mPreChoosePosition = index
                }
            }
            ThemeColorItem(
                color = color,
                isSelected = isSelected
            )
        }
    }

    /**
     * 用户自定义处理数据 (单个Item内 全局刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     */
    override fun convert(holder: CommonViewHolder, data: ThemeColorItem, position: Int) {
        val color = data.color
        val interval = SizeUtils.dp2px(3F)
        val unselectedDrawable = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            setColor(color)
            cornerRadius = SizeUtils.dp2px(23F).toFloat()
        }
        val selectedDrawable = LayerDrawable(arrayOf(unselectedDrawable, getDrawableById(R.drawable.shape_theme_color_ring))).apply {
            setLayerInset(1, interval, interval, interval, interval)
        }

        holder.setBackground(
            viewId = R.id.iv_theme_color,
            drawable = if (data.isSelected) selectedDrawable else unselectedDrawable
        )

        holder.setOnClickListener(
            viewId = R.id.iv_theme_color,
            listener = View.OnClickListener { v ->
                if (position == mPreChoosePosition) {
                    return@OnClickListener
                }
                // 更新前一个位置
                if (mPreChoosePosition != -1) {
                    mDataList!![mPreChoosePosition].isSelected = false
                    notifyItemChanged(mPreChoosePosition)
                }
                mPreChoosePosition = position
                // 更新当前位置
                data.isSelected = true
                notifyItemChanged(position)
                mOnItemEvent?.invoke(v, data, position, SELECTED)
            }
        )
    }

}