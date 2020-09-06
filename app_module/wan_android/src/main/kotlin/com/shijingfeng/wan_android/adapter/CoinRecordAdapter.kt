package com.shijingfeng.wan_android.adapter

import android.content.Context
import com.shijingfeng.base.base.adapter.BaseAdapter
import com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.entity.CoinRecordItem

/**
 * Function: 积分记录 Adapter
 * Date: 2020/2/3 21:48
 * Description:
 * @author ShiJingFeng
 */
internal class CoinRecordAdapter(
    context: Context,
    dataList: List<CoinRecordItem>? = null
) : BaseAdapter<CoinRecordItem>(context, R.layout.adapter_item_wan_android_coin_record, dataList) {

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
            // 何种方式获得的积分
            setText(R.id.tv_reason, reason)
            // 积分记录描述
            setText(R.id.tv_desc, desc)
            // 积分数量
            setText(R.id.tv_quantity, quantity.toString())
        }
    }
}