package com.shijingfeng.todo.adapter

import android.content.Context
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import com.shijingfeng.base.base.adapter.BaseAdapter
import com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder
import com.shijingfeng.todo.R
import com.shijingfeng.todo.constant.*
import com.shijingfeng.todo.constant.PRIORITY_IMPORTANT_NOT_URGENCY
import com.shijingfeng.todo.constant.PRIORITY_IMPORTANT_URGENCY
import com.shijingfeng.todo.constant.PRIORITY_NOT_IMPORTANT_NOT_URGENCY
import com.shijingfeng.todo.constant.PRIORITY_NOT_IMPORTANT_URGENCY
import com.shijingfeng.todo.constant.VIEW_TODO_DETAIL
import com.shijingfeng.todo.entity.MainTodoItem

/**
 * Function: 主页 -> 待办 分组后的 适配器
 * Date: 2020/5/19 21:08
 * Description:
 * @author ShiJingFeng
 */
internal class MainTodoAdapter(
    context: Context,
    dataList: List<MainTodoItem>? = null
) : BaseAdapter<MainTodoItem>(
    context = context,
    layoutId = R.layout.adapter_item_todo_main_todo,
    dataList = dataList
) {

    /**
     * 用户自定义处理数据 (单个Item内 全局刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     */
    override fun convert(holder: CommonViewHolder, data: MainTodoItem, position: Int) {
        // 标题
        holder.setText(R.id.tv_title, data.title)
        // 内容
        holder.setText(R.id.tv_content, data.content)
        // 重要 和 紧急
        when (data.priority) {
            // 重要 紧急
            PRIORITY_IMPORTANT_URGENCY -> {
                holder.setVisibility(R.id.mv_important, VISIBLE)
                holder.setVisibility(R.id.mv_urgency, VISIBLE)
            }
            // 重要 不紧急
            PRIORITY_IMPORTANT_NOT_URGENCY -> {
                holder.setVisibility(R.id.mv_important, VISIBLE)
                holder.setVisibility(R.id.mv_urgency, GONE)
            }
            // 不重要 紧急
            PRIORITY_NOT_IMPORTANT_URGENCY -> {
                holder.setVisibility(R.id.mv_important, GONE)
                holder.setVisibility(R.id.mv_urgency, VISIBLE)
            }
            // 不重要 不紧急
            PRIORITY_NOT_IMPORTANT_NOT_URGENCY -> {
                holder.setVisibility(R.id.mv_important, GONE)
                holder.setVisibility(R.id.mv_urgency, GONE)
            }
            else -> {
                holder.setVisibility(R.id.mv_important, GONE)
                holder.setVisibility(R.id.mv_urgency, GONE)
            }
        }

        // 查看 待办 详情
        holder.setOnClickListener(
            view = holder.itemView,
            listener = View.OnClickListener { v ->
                mOnItemEvent?.invoke(v, data, position, VIEW_TODO_DETAIL)
            }
        )
    }
}