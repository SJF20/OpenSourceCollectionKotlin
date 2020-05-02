package com.shijingfeng.wan_android.adapter

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.blankj.utilcode.util.ClickUtils
import com.blankj.utilcode.util.ConvertUtils
import com.blankj.utilcode.util.ScreenUtils
import com.shijingfeng.base.base.adapter.BaseAdapter
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
internal class KnowledgeClassifyAdapter(
    context: Context,
    dataList: List<KnowledgeClassifyEntity>? = null
) : BaseAdapter<KnowledgeClassifyEntity>(context, R.layout.adapter_item_wan_android_knowledge_classify, dataList) {

    /**
     * 用户自定义处理数据 (单个Item内 全局刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     */
    override fun convert(holder: CommonViewHolder, data: KnowledgeClassifyEntity, position: Int) {
        // 知识标签 View列表 容器
        val llChild = holder.getView<LinearLayout>(R.id.ll_child)

        holder.run {
            // 知识体系名称
            setText(R.id.tv_name, data.name)
            // 查看 知识体系 详情
            setOnClickListener(
                viewId = R.id.ll_content,
                listener = View.OnClickListener { v ->
                    mOnItemEvent?.invoke(v, data, 0, VIEW_KNOWLEDGE_CLASSIFY_DETAIL)
                }
            )
        }
        if (data.childrenList.isEmpty()) {
            llChild?.visibility = View.GONE
        } else {
            // 可容纳的最大宽度
            val totalWidth = ScreenUtils.getScreenWidth() - 2 * ConvertUtils.dp2px(15f)
            // 知识标签 View列表
            val viewList = ArrayList<View>()

            for (i in data.childrenList.indices) {
                val children = data.childrenList[i]
                val name = children.name

                viewList.add(TextView(mContext).apply {
                    text = name
                    setPadding(ConvertUtils.dp2px(15F), ConvertUtils.dp2px(7F), ConvertUtils.dp2px(15F), ConvertUtils.dp2px(7F))
                    setBackgroundResource(R.drawable.shape_classify_child_bg)
                    // 查看 知识标签 详情
                    ClickUtils.applySingleDebouncing(this) {
                        mOnItemEvent?.invoke(this, data, i, VIEW_KNOWLEDGE_CLASSIFY_DETAIL)
                    }
                })
            }

            if (llChild != null) {
                // 对 知识标签控件 进行整体布局 (按控件宽度逐行排列，没有固定列数)
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
    }
}