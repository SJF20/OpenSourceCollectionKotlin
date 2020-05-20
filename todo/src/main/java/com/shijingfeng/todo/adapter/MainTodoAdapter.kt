package com.shijingfeng.todo.adapter

import android.content.Context
import android.view.View
import com.shijingfeng.base.base.adapter.BaseAdapter
import com.shijingfeng.base.base.adapter.BaseMultiItemAdapter
import com.shijingfeng.base.base.adapter.support.MultiItemTypeSupport
import com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder
import com.shijingfeng.todo.R
import com.shijingfeng.todo.constant.VIEW_TODO_DETAIL
import com.shijingfeng.todo.entity.TodoItem
import com.shijingfeng.todo.entity.adapter.MAIN_TODO_GROUP_ITEM
import com.shijingfeng.todo.entity.adapter.MAIN_TODO_GROUP_TITLE_ITEM
import com.shijingfeng.todo.entity.adapter.TodoGroupItem
import com.shijingfeng.todo.entity.adapter.TodoGroupTitleItem
import kotlinx.android.synthetic.main.adapter_item_todo_main_todo_title.view.*

/**
 * Function: 主页 -> 待办 适配器
 * Date: 2020/5/19 21:08
 * Description:
 * @author ShiJingFeng
 */
internal class MainTodoAdapter(
    context: Context,
    dataList: List<TodoGroupItem>?,
    multiItemTypeSupport: MultiItemTypeSupport<TodoGroupItem>
) : BaseMultiItemAdapter<TodoGroupItem>(context, dataList, multiItemTypeSupport) {

    /**
     * 用户自定义处理数据 (单个Item内 全局刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     */
    override fun convert(holder: CommonViewHolder, data: TodoGroupItem, position: Int) {
        when (data.getType()) {
            // 主页 -> 待办 分组后的 标题Item
            MAIN_TODO_GROUP_TITLE_ITEM -> {
                val item = data.get<TodoItem>()

                holder.setText(R.id.tv_title, item.title)
                holder.setText(R.id.tv_content, item.content)
                holder.setOnClickListener(
                    view = holder.itemView,
                    listener = View.OnClickListener { v ->
                        mOnItemEvent?.invoke(v, item, position, VIEW_TODO_DETAIL)
                    }
                )
            }
            // 主页 -> 待办 分组后的 普通Item
            MAIN_TODO_GROUP_ITEM -> {
                val titleItem = data.get<TodoGroupTitleItem>()

                holder.setText(R.id.tv_date_time, titleItem.dateTime)
                holder.setOnClickListener(
                    view = holder.itemView,
                    listener = null
                )
            }
            else -> {}
        }
    }
}