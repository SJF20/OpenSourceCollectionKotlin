package com.shijingfeng.base.base.adapter

import android.content.Context
import android.view.ViewGroup
import com.shijingfeng.base.base.adapter.support.MultiItemTypeSupport
import com.shijingfeng.base.base.adapter.viewholder.createCommonViewHolder
import com.shijingfeng.base.base.entity.BaseEntity

/**
 * Function: 通用多类型Item RecyclerView 适配器
 * Date: 2020/1/27 10:55
 * Description:
 * @author ShiJingFeng
 */
abstract class CommonMultiItemAdapter<T : BaseEntity>(
    mContext: Context,
    mDataList: List<T>? = null,
    protected val mMultiItemTypeSupport: MultiItemTypeSupport<T>
) : CommonAdapter<T>(mContext, -1, mDataList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        createCommonViewHolder(
            mContext,
            mMultiItemTypeSupport.getLayoutId(viewType),
            parent
        )

    override fun getItemViewType(position: Int): Int = mMultiItemTypeSupport.getItemViewType(position, mDataList!![position])

}