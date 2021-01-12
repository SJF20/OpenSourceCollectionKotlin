package com.shijingfeng.wan_android.adapter

import android.content.Context
import android.view.View.OnClickListener
import com.shijingfeng.base.base.adapter.BaseAdapter
import com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.common.constant.VIEW_WEBSITE_DETAIL
import com.shijingfeng.wan_android.common.constant.WEBSITE_ITEM_EDIT
import com.shijingfeng.wan_android.common.constant.WEBSITE_ITEM_UNCOLLECTED
import com.shijingfeng.wan_android.entity.PersonalCollectionWebsiteEntity

/**
 * Function: 我的收藏 -> 收藏网站列表 适配器
 * Date: 2020/2/3 20:03
 * Description:
 * Author: ShiJingFeng
 */
internal class PersonalCollectionWebsiteAdapter(
    context: Context,
    dataList: List<PersonalCollectionWebsiteEntity>? = null
) : BaseAdapter<PersonalCollectionWebsiteEntity>(context, R.layout.adapter_item_wan_android_personal_collection_website, dataList) {

    /**
     * 用户自定义处理数据 (单个Item内 全局刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     */
    override fun convert(
        holder: CommonViewHolder,
        data: PersonalCollectionWebsiteEntity,
        position: Int
    ) {
        holder.run {
            // 网站名称
            setText(R.id.tv_name, data.name)
            // 网站链接
            setText(R.id.tv_link, data.link)

            // 查看网站详情
            setOnClickListener(
                viewId = R.id.ll_content,
                listener = OnClickListener { v ->
                    mOnItemEvent?.invoke(v, data, position,
                        VIEW_WEBSITE_DETAIL
                    )
                }
            )
            // 编辑
            setOnClickListener(
                viewId = R.id.btn_edit,
                listener = OnClickListener { v ->
                    mOnItemEvent?.invoke(v, data, position,
                        WEBSITE_ITEM_EDIT
                    )
                }
            )
            // 取消收藏
            setOnClickListener(
                viewId = R.id.btn_uncollected,
                listener = OnClickListener { v ->
                    mOnItemEvent?.invoke(v, data.getId(), position,
                        WEBSITE_ITEM_UNCOLLECTED
                    )
                }
            )
        }
    }
}