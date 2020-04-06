package com.shijingfeng.wan_android.adapter

import android.content.Context
import android.view.View.OnClickListener
import com.shijingfeng.base.base.adapter.CommonAdapter
import com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.constant.VIEW_WEBSITE_DETAIL
import com.shijingfeng.wan_android.constant.WEBSITE_ITEM_EDIT
import com.shijingfeng.wan_android.constant.WEBSITE_ITEM_UNCOLLECTED
import com.shijingfeng.wan_android.entity.network.PersonalCollectionWebsiteEntity

/**
 * Function: 我的收藏 -> 收藏网站列表 适配器
 * Date: 2020/2/3 20:03
 * Description:
 * @author ShiJingFeng
 */
internal class PersonalCollectionWebsiteAdapter(
    context: Context,
    layoutId: Int,
    dataList: List<PersonalCollectionWebsiteEntity>? = null
) : CommonAdapter<PersonalCollectionWebsiteEntity>(context, layoutId, dataList) {

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
                    mOnItemEvent?.invoke(v, data, position, VIEW_WEBSITE_DETAIL)
                }
            )
            // 编辑
            setOnClickListener(
                viewId = R.id.btn_edit,
                listener = OnClickListener { v ->
                    mOnItemEvent?.invoke(v, data, position, WEBSITE_ITEM_EDIT)
                }
            )
            // 取消收藏
            setOnClickListener(
                viewId = R.id.btn_uncollected,
                listener = OnClickListener { v ->
                    mOnItemEvent?.invoke(v, data.identity, position, WEBSITE_ITEM_UNCOLLECTED)
                }
            )
        }
    }
}