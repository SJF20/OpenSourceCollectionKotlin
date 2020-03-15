package com.shijingfeng.wan_android.adapter

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.blankj.utilcode.util.ConvertUtils
import com.blankj.utilcode.util.ScreenUtils
import com.shijingfeng.base.base.adapter.CommonAdapter
import com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder
import com.shijingfeng.base.util.layout
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.constant.VIEW_KNOWLEDGE_CLASSIFY_DETAIL
import com.shijingfeng.wan_android.entity.network.KnowledgeClassifyEntity
import java.util.*

/**
 * Function: 知识体系 RecyclerView适配器
 * Date: 2020/2/4 11:42
 * Description:
 * @author ShiJingFeng
 */
class KnowledgeClassifyAdapter(
    context: Context,
    layoutId: Int,
    dataList: List<KnowledgeClassifyEntity>? = null
) : CommonAdapter<KnowledgeClassifyEntity>(context, layoutId, dataList) {

    /**
     * 用户自定义处理数据 (单个Item内 全局刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     */
    override fun convert(holder: CommonViewHolder, data: KnowledgeClassifyEntity, position: Int) {
        val llChild = holder.getView<LinearLayout>(R.id.ll_child)

        holder.setText(R.id.tv_name, data.name)
        if (data.childrenList.isEmpty()) {
            llChild?.visibility = View.GONE
        } else {
            val totalWidth = ScreenUtils.getScreenWidth() - 2 * ConvertUtils.dp2px(15f)
            val viewList = ArrayList<View>()

            for (i in data.childrenList.indices) {
                val children = data.childrenList[i]
                val name = children.name

                viewList.add(TextView(mContext).apply {
                    text = name
                    setPadding(ConvertUtils.dp2px(15F), ConvertUtils.dp2px(7F), ConvertUtils.dp2px(15F), ConvertUtils.dp2px(7F))
                    setBackgroundResource(R.drawable.shape_classify_child_bg)
                    setOnClickListener { v ->
                        mOnItemEvent?.invoke(v, data, i, VIEW_KNOWLEDGE_CLASSIFY_DETAIL)
                    }
                })
            }

            if (llChild != null) {
                layout(
                    llChild,
                    viewList,
                    totalWidth,
                    ConvertUtils.dp2px(10F),
                    Gravity.START
                )
                llChild.visibility = View.VISIBLE
            }
        }
        holder.itemView.setOnClickListener { v ->
            mOnItemEvent?.invoke(v, data, 0, VIEW_KNOWLEDGE_CLASSIFY_DETAIL)
        }
    }
}