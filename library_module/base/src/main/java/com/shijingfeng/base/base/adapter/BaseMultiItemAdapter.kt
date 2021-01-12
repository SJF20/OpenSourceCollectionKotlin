package com.shijingfeng.base.base.adapter

import android.content.Context
import android.view.ViewGroup
import com.shijingfeng.base.base.adapter.support.MultiItemTypeSupport
import com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder.Companion.createCommonViewHolder
import com.shijingfeng.base.base.entity.BaseEntity

/**
 * Function: 通用多类型Item RecyclerView 适配器
 * Date: 2020/1/27 10:55
 * Description:
 * Author: ShiJingFeng
 */
abstract class BaseMultiItemAdapter<T : BaseEntity>(
    context: Context,
    dataList: List<T>? = null,
    multiItemTypeSupport: MultiItemTypeSupport<T>
) : BaseAdapter<T>(context, -1, dataList) {

    /** 多布局支持适配器 */
    private val mMultiItemTypeSupport = multiItemTypeSupport

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        createCommonViewHolder(
            mContext,
            mMultiItemTypeSupport.getLayoutId(viewType),
            parent
        )

    override fun getItemViewType(position: Int): Int = mMultiItemTypeSupport.getItemViewType(position, mDataList!![position])

}