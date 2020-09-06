package com.shijingfeng.wan_android.adapter

import android.content.Context
import android.view.View
import com.shijingfeng.base.base.adapter.BaseAdapter
import com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.common.constant.REMOVE_SEARCH_HISTORY_ITEM
import com.shijingfeng.wan_android.common.constant.SEARCH
import com.shijingfeng.wan_android.entity.adapter.SearchHistoryItem

/**
 * Function: 搜索页面 -> 搜索历史 适配器
 * Date: 2020/5/5 17:25
 * Description:
 * @author ShiJingFeng
 */
internal class SearchHistoryAdapter(
    context: Context,
    dataList: List<SearchHistoryItem>? = null
) : BaseAdapter<SearchHistoryItem>(
    context = context,
    layoutId = R.layout.adapter_item_wan_android_search_history,
    dataList = dataList
) {

    /**
     * 用户自定义处理数据 (单个Item内 全局刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     */
    override fun convert(holder: CommonViewHolder, data: SearchHistoryItem, position: Int) {
        holder.run {
            // 设置 搜索历史 关键词名称
            setText(R.id.tv_name, data.name)

            // 搜索
            setOnClickListener(
                view = itemView,
                listener = View.OnClickListener { v ->
                    mOnItemEvent?.invoke(v, data.name, position,
                        SEARCH
                    )
                }
            )
            // 删除 某条 搜索历史
            setOnClickListener(
                viewId = R.id.iv_remove,
                listener = View.OnClickListener { v ->
                    mOnItemEvent?.invoke(v, data, position,
                        REMOVE_SEARCH_HISTORY_ITEM
                    )
                }
            )
        }
    }

}