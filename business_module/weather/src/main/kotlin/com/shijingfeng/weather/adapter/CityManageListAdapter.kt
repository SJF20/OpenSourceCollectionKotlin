package com.shijingfeng.weather.adapter

import android.content.Context
import com.shijingfeng.base_adapter.BaseAdapter
import com.shijingfeng.base_adapter.viewholder.CommonViewHolder
import com.shijingfeng.weather.R
import com.shijingfeng.weather.common.global.cityDataManager
import com.shijingfeng.weather.entity.CityDataItem

/**
 * Function: 城市管理 列表适配器
 * Date: 2020/10/31 16:48
 * Description:
 * Author: ShiJingFeng
 */
internal class CityManageListAdapter(
    context: Context
) : BaseAdapter<CityDataItem>(
    context = context,
    layoutId = R.layout.adapter_item_city_manage_list,
    dataList = cityDataManager?.dataList
) {

    /**
     * 用户自定义处理数据 (单个Item内 全局刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     */
    override fun convert(holder: CommonViewHolder, data: CityDataItem, position: Int) {
        TODO("Not yet implemented")
    }
}