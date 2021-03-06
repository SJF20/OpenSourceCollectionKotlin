package com.shijingfeng.wan_android.adapter

import android.content.Context
import com.shijingfeng.base_adapter.BaseAdapter
import com.shijingfeng.base_adapter.viewholder.CommonViewHolder
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.entity.CoinRankItem

/**
 * Function: 积分排行榜 列表适配器
 * Date: 2020/2/3 21:27
 * Description:
 * Author: ShiJingFeng
 */
internal class CoinRankAdapter(
    context: Context,
    dataList: List<CoinRankItem>? = null
) : BaseAdapter<CoinRankItem>(context, R.layout.adapter_item_wan_android_coin_rank, dataList) {

    /**
     * 用户自定义处理数据 (单个Item内 全局刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     */
    override fun convert(
        holder: CommonViewHolder,
        data: CoinRankItem,
        position: Int
    ) {
        holder.run {
            // 排名
            setText(R.id.tv_rank, (position + 1).toString())
            // 用户名
            setText(R.id.tv_name, data.username)
            // 积分数量
            setText(R.id.tv_coin_count, data.coinCount.toString())
        }
    }

}