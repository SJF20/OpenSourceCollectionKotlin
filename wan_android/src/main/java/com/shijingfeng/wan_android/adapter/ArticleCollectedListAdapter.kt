package com.shijingfeng.wan_android.adapter

import android.content.Context
import android.view.View
import com.blankj.utilcode.util.ClickUtils
import com.shijingfeng.base.base.adapter.common.CommonAdapter
import com.shijingfeng.base.base.adapter.common.viewholder.CommonViewHolder
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.constant.ARTICLE_ITEM_UNCOLLECTED
import com.shijingfeng.wan_android.constant.VIEW_ARTICLE_DETAIL
import com.shijingfeng.wan_android.entity.network.ArticleCollectedListItem

/**
 * Function: 文章收藏列表 适配器
 * Date: 2020/2/3 20:03
 * Description:
 * @author ShiJingFeng
 */
class ArticleCollectedListAdapter(
    mContext: Context,
    mLayoutId: Int,
    mDataList: List<ArticleCollectedListItem>? = null
) : CommonAdapter<ArticleCollectedListItem>(mContext, mLayoutId, mDataList) {

    /**
     * 用户自定义处理数据 (单个Item内 全局刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     */
    override fun convert(
        holder: CommonViewHolder,
        data: ArticleCollectedListItem,
        position: Int
    ) {
        val author = data.author
        val niceDate = data.niceDate
        val title = data.title
        val secondType = data.chapterName

        //查看文章详情
        ClickUtils.applySingleDebouncing(holder.itemView) { v ->
            mOnItemEventListener?.invoke(v, data, position, VIEW_ARTICLE_DETAIL)
        }
        //取消收藏
        ClickUtils.applySingleDebouncing(holder.getView<View>(R.id.ckb_collection)) { v ->
            mOnItemEventListener?.invoke(v, data, position, ARTICLE_ITEM_UNCOLLECTED)
        }

        holder.run {
            setText(R.id.tv_author, author)
            setText(R.id.tv_date_time, niceDate)
            setText(R.id.tv_title, title)
            setText(R.id.tv_second_type, secondType)
        }
    }
}