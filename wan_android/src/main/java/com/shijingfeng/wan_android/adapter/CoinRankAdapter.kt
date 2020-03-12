package com.shijingfeng.wan_android.adapter

import android.content.Context
import com.shijingfeng.base.base.adapter.common.CommonAdapter
import com.shijingfeng.base.base.adapter.common.viewholder.CommonViewHolder
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.entity.network.CoinRankItem

/**
 * Function: 积分排行榜 列表适配器
 * Date: 2020/2/3 21:27
 * Description:
 * @author ShiJingFeng
 */
class CoinRankAdapter(
    mContext: Context,
    mLayoutId: Int,
    mDataList: List<CoinRankItem>? = null
) : CommonAdapter<CoinRankItem>(mContext, mLayoutId, mDataList) {

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
            setText(R.id.tv_rank, (position + 1).toString())
            setText(R.id.tv_name, data.username)
            setText(R.id.tv_coin_count, data.coinCount.toString())
        }
    }

}