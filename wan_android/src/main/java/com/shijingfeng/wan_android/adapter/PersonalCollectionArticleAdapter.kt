package com.shijingfeng.wan_android.adapter

import android.content.Context
import android.text.TextUtils
import android.view.View.OnClickListener
import com.shijingfeng.base.base.adapter.BaseAdapter
import com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.library.SwipeRemoveLayout
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.constant.ARTICLE_ITEM_UNCOLLECTED
import com.shijingfeng.wan_android.constant.VIEW_ARTICLE_DETAIL
import com.shijingfeng.wan_android.entity.network.PersonalCollectionArticleItem

/**
 * Function: 我的收藏 -> 收藏文章列表 适配器
 * Date: 2020/2/3 20:03
 * Description:
 * @author ShiJingFeng
 */
internal class PersonalCollectionArticleAdapter(
    context: Context,
    layoutId: Int,
    dataList: List<PersonalCollectionArticleItem>? = null
) : BaseAdapter<PersonalCollectionArticleItem>(context, layoutId, dataList) {

    /**
     * 用户自定义处理数据 (单个Item内 全局刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     */
    override fun convert(
        holder: CommonViewHolder,
        data: PersonalCollectionArticleItem,
        position: Int
    ) {
        val author = data.author
        val niceDate = data.niceDate
        val title = data.title
        val secondType = data.chapterName

        holder.run {
            val swipeRemoveLayout = getView<SwipeRemoveLayout>(R.id.swipe_remove_layout)

            // 作者
            setText(R.id.tv_author, if (TextUtils.isEmpty(author)) getStringById(R.string.未知作者) else author)
            // 发布时间
            setText(R.id.tv_date_time, niceDate)
            // 标题
            setText(R.id.tv_title, title)
            // 文章领域的类型 名称 (例如 Flutter)
            setText(R.id.tv_second_type, secondType)

            //查看文章详情
            setOnClickListener(
                viewId = R.id.ll_content,
                listener = OnClickListener { v ->
                    mOnItemEvent?.invoke(v, data, position, VIEW_ARTICLE_DETAIL)
                }
            )
            // 取消收藏
            setOnClickListener(
                viewId = R.id.btn_uncollected,
                listener = OnClickListener{ v ->
                    swipeRemoveLayout?.close()
                    mOnItemEvent?.invoke(v, data, position, ARTICLE_ITEM_UNCOLLECTED)
                }
            )
        }
    }
}