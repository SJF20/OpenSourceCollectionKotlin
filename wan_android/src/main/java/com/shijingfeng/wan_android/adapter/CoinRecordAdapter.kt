package com.shijingfeng.wan_android.adapter

import android.content.Context
import com.shijingfeng.base.base.adapter.common.CommonAdapter
import com.shijingfeng.base.base.adapter.common.viewholder.CommonViewHolder
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.entity.network.CoinRecordItem

/**
 * Function: 积分记录 Adapter
 * Date: 2020/2/3 21:48
 * Description:
 * @author ShiJingFeng
 */
class CoinRecordAdapter(
    context: Context,
    layoutId: Int,
    dataList: List<CoinRecordItem>? = null
) : CommonAdapter<CoinRecordItem>(context, layoutId, dataList) {

    /**
     * 用户自定义处理数据 (单个Item内 全局刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     */
    override fun convert(
        holder: CommonViewHolder,
        data: CoinRecordItem,
        position: Int
    ) {
        val reason = data.reason
        val quantity = data.coinCount
        val desc = data.desc

        holder.run {
            setText(R.id.tv_reason, reason)
            setText(R.id.tv_desc, desc)
            setText(R.id.tv_quantity, quantity.toString())
        }
    }
}