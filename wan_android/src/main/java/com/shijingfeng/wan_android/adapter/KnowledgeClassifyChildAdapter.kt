package com.shijingfeng.wan_android.adapter

import android.content.Context
import android.text.TextUtils
import android.view.View
import android.widget.CompoundButton
import com.shijingfeng.base.base.adapter.BaseAdapter
import com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.constant.ARTICLE_ITEM_COLLECTION
import com.shijingfeng.wan_android.constant.VIEW_ARTICLE_DETAIL
import com.shijingfeng.wan_android.entity.network.KnowledgeClassifyChildItem

/**
 * Function: 知识体系 二级数据 RecyclerView 适配器
 * Date: 2020/2/4 13:53
 * Description:
 * @author ShiJingFeng
 */
internal class KnowledgeClassifyChildAdapter(
    context: Context,
    layoutId: Int,
    dataList: List<KnowledgeClassifyChildItem>? = null
) : BaseAdapter<KnowledgeClassifyChildItem>(context, layoutId, dataList) {

    /**
     * 用户自定义处理数据 (单个Item内 全局刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     */
    override fun convert(holder: CommonViewHolder, data: KnowledgeClassifyChildItem, position: Int) {
        val author = data.author
        val shareUser = data.shareUser
        val niceDate = data.niceDate
        val title = data.title
        val firstType = data.superChapterName
        val secondType = data.chapterName
        val isCollected = data.collected

        holder.run {
            // 原作者 或 转载者
            setText(R.id.tv_author, if (TextUtils.isEmpty(author)) shareUser else author)
            // 文章时间 或 转载时间
            setText(R.id.tv_date_time, niceDate)
            // 文章标题
            setText(R.id.tv_title, title)
            // 领域名称 (例如: 跨平台)
            setText(R.id.tv_first_type, firstType)
            // 方向名称 (例如: Flutter)
            setText(R.id.tv_second_type, if (TextUtils.isEmpty(secondType)) "" else " / $secondType")
            // 是否已收藏
            setChecked(R.id.ckb_collection, isCollected)

            //查看文章详情
            setOnClickListener(
                viewId = R.id.ll_content,
                listener = View.OnClickListener { v ->
                    mOnItemEvent?.invoke(v, data, position, VIEW_ARTICLE_DETAIL)
                }
            )
            //收藏或取消收藏
            setOnCheckedListener(
                R.id.ckb_collection,
                CompoundButton.OnCheckedChangeListener { buttonView, _ ->
                    //如果checkbox不是手动按下就不处理。
                    if (!buttonView.isPressed) {
                        return@OnCheckedChangeListener
                    }

                    mOnItemEvent?.invoke(buttonView, data, position, ARTICLE_ITEM_COLLECTION)
                }
            )
        }
    }
}