package com.shijingfeng.todo.entity.adapter

import android.content.Context
import com.shijingfeng.base.base.adapter.BaseAdapter
import com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder
import com.shijingfeng.todo.R
import com.shijingfeng.todo.adapter.MainTodoGroupAdapter

/**
 * Function: 主页 -> 待办 适配器
 * Date: 2020/5/21 15:17
 * Description:
 * @author ShiJingFeng
 */
internal class MainTodoAdapter(
    context: Context,
    dataList: List<MainTodoItem>? = null
) : BaseAdapter<MainTodoItem>(
    mContext = context,
    mLayoutId = R.layout.adapter_item_todo_main_todo,
    mDataList = dataList
) {

    /**
     * 用户自定义处理数据 (单个Item内 全局刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     */
    override fun convert(holder: CommonViewHolder, data: MainTodoItem, position: Int) {
        val adapter = MainTodoGroupAdapter(mContext, data.todoItemList)

        // 设置日期
        holder.setText(R.id.tv_date, data.date)
        // 设置 分组下的 列表适配器
        holder.setLinearAdapter(
            viewId = R.id.rv_list,
            adapter = adapter
        )

        adapter.setOnItemEventListener { view, childData, childPosition, flag ->
            mOnItemEvent?.invoke(view, childData, childPosition, flag)
        }
    }

}