package com.shijingfeng.weather.adapter

import android.content.Context
import com.shijingfeng.base.base.adapter.BaseAdapter
import com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder
import com.shijingfeng.weather.R
import com.shijingfeng.weather.constant.CHOOSE_CITY
import com.shijingfeng.weather.entity.CitySearchInfoEntity

/**
 * Function: 城市搜索列表 适配器
 * Date: 2020/10/26 16:41
 * Description:
 * @author ShiJingFeng
 */
internal class CitySearchListAdapter(
    context: Context,
    dataList: List<CitySearchInfoEntity>
) : BaseAdapter<CitySearchInfoEntity>(
    context,
    layoutId = R.layout.adapter_item_city_search_list,
    dataList
) {

    /**
     * 用户自定义处理数据 (单个Item内 全局刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     */
    override fun convert(holder: CommonViewHolder, data: CitySearchInfoEntity, position: Int) {
        holder.setText(R.id.tv_city_name, data.name)
        // TODO 需要添加代码: 判断该城市是否已添加
        holder.setOnClickListener(
            view = holder.itemView,
            listener = { view ->
                mOnItemEvent?.invoke(view, data, position, CHOOSE_CITY)
            }
        )
    }

}