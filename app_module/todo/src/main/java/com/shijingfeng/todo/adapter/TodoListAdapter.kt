package com.shijingfeng.todo.adapter

import android.content.Context
import android.view.View.GONE
import android.view.View.VISIBLE
import com.shijingfeng.base.base.adapter.BaseMultiItemAdapter
import com.shijingfeng.base.base.adapter.support.MultiItemTypeSupport
import com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder
import com.shijingfeng.todo.R
import com.shijingfeng.todo.constant.*
import com.shijingfeng.todo.constant.PRIORITY_IMPORTANT_NOT_URGENCY
import com.shijingfeng.todo.constant.PRIORITY_IMPORTANT_URGENCY
import com.shijingfeng.todo.constant.PRIORITY_NOT_IMPORTANT_NOT_URGENCY
import com.shijingfeng.todo.constant.PRIORITY_NOT_IMPORTANT_URGENCY
import com.shijingfeng.todo.constant.STATUS_NEED_TO_DO
import com.shijingfeng.todo.constant.VIEW_TODO_DETAIL
import com.shijingfeng.todo.entity.adapter.TodoListItem

/**
 * Function: 主页 -> 待办 分组后的 适配器
 * Date: 2020/5/19 21:08
 * Description:
 * @author ShiJingFeng
 */
internal class TodoListAdapter(
    context: Context,
    dataList: List<TodoListItem>? = null,
    multiItemTypeSupport: MultiItemTypeSupport<TodoListItem>
) : BaseMultiItemAdapter<TodoListItem>(
    context = context,
    dataList = dataList,
    multiItemTypeSupport = multiItemTypeSupport
) {

    /**
     * 用户自定义处理数据 (单个Item内 全局刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     */
    override fun convert(holder: CommonViewHolder, data: TodoListItem, position: Int) {
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

        // 删除
        holder.setOnClickListener(
            viewId = R.id.btn_delete,
            listener = { view ->
                mOnItemEvent?.invoke(view, data, position, REMOVE_ITEM)
            }
        )
        when(data.getType()) {
            STATUS_NEED_TO_DO -> {
                // 标记完成
                holder.setOnClickListener(
                    viewId = R.id.btn_complete,
                    listener = { view ->
                        mOnItemEvent?.invoke(view, data, position, TODO_COMPLETED)
                    }
                )
                // 查看 待办 详情
                holder.setOnClickListener(
                    viewId = R.id.fl_content,
                    listener = { v ->
                        mOnItemEvent?.invoke(v, data, position, VIEW_TODO_DETAIL)
                    }
                )
            }
            STATUS_DONE -> {
                // 撤回
                holder.setOnClickListener(
                    viewId = R.id.btn_recall,
                    listener = { view ->
                        mOnItemEvent?.invoke(view, data, position, TODO_RECALL)
                    }
                )
                // 查看 完成 详情
                holder.setOnClickListener(
                    viewId = R.id.fl_content,
                    listener = { v ->
                        mOnItemEvent?.invoke(v, data, position, VIEW_TODO_DETAIL)
                    }
                )
            }
            else -> {}
        }
    }

}