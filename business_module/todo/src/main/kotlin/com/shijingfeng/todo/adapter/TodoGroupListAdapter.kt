package com.shijingfeng.todo.adapter

import android.content.Context
import com.shijingfeng.base_adapter.BaseAdapter
import com.shijingfeng.base_adapter.viewholder.CommonViewHolder
import com.shijingfeng.base.widget.LinearDividerItemDecoration
import com.shijingfeng.base_adapter.support.MultiItemTypeSupport
import com.shijingfeng.todo.R
import com.shijingfeng.todo.constant.STATUS_DONE
import com.shijingfeng.todo.constant.STATUS_NEED_TO_DO
import com.shijingfeng.todo.entity.adapter.TodoGroupListItem
import com.shijingfeng.todo.entity.adapter.TodoListItem

/**
 * Function: 主页 -> 待办 适配器
 * Date: 2020/5/21 15:17
 * Description:
 * Author: ShiJingFeng
 */
internal class TodoGroupListAdapter(
    context: Context,
    dataList: List<TodoGroupListItem>? = null,
) : BaseAdapter<TodoGroupListItem>(
    context = context,
    layoutId = R.layout.adapter_item_todo_todo_group_list,
    dataList = dataList
) {

    /**
     * 用户自定义处理数据 (单个Item内 全局刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     */
    override fun convert(holder: CommonViewHolder, data: TodoGroupListItem, position: Int) {
        val adapter = TodoListAdapter(context, data.todoItemList, object : MultiItemTypeSupport<TodoListItem> {

            /**
             * 根据 Item类型 获取 Layout Id
             * @param itemType Item类型
             * @return Layout Id
             */
            override fun getLayoutId(itemType: Int) = when (itemType) {
                // 待办
                STATUS_NEED_TO_DO -> R.layout.adapter_item_todo_main_need_to_do
                // 已完成
                STATUS_DONE -> R.layout.adapter_item_todo_main_done
                // 未知
                else -> 0
            }

            /**
             * 获取 Item类型
             * @param position 下标位置
             * @param data 数据
             * @return Item类型
             */
            override fun getItemViewType(position: Int, data: TodoListItem) = data.getType()

        })

        // 设置日期
        holder.setText(R.id.tv_date, data.dateStr)
        // 设置 分组下的 列表适配器
        holder.setLinearAdapter(
            viewId = R.id.rv_list,
            adapter = adapter,
            itemDecorationList = listOf(LinearDividerItemDecoration())
        )

        adapter.onItemEvent = { view, childData, childPosition, flag ->
            onItemEvent?.invoke(view, childData, childPosition, flag)
        }
    }

}