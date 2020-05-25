package com.shijingfeng.todo.adapter

import android.content.Context
import android.view.View
import com.shijingfeng.base.base.adapter.BaseAdapter
import com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder
import com.shijingfeng.todo.R
import com.shijingfeng.todo.constant.VIEW_TODO_DETAIL
import com.shijingfeng.todo.entity.MainTodoGroupItem

/**
 * Function: 主页 -> 待办 分组后的 适配器
 * Date: 2020/5/19 21:08
 * Description:
 * @author ShiJingFeng
 */
internal class MainTodoGroupAdapter(
    context: Context,
    dataList: List<MainTodoGroupItem>? = null
) : BaseAdapter<MainTodoGroupItem>(
    mContext = context,
    mLayoutId = R.layout.adapter_item_todo_main_todo_group,
    mDataList = dataList
) {

    /**
     * 用户自定义处理数据 (单个Item内 全局刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     */
    override fun convert(holder: CommonViewHolder, data: MainTodoGroupItem, position: Int) {
        // 标题
        holder.setText(R.id.tv_title, data.title)
        // 内容
        holder.setText(R.id.tv_content, data.content)

        // 查看 待办 详情
        holder.setOnClickListener(
            view = holder.itemView,
            listener = View.OnClickListener { v ->
                mOnItemEvent?.invoke(v, data, position, VIEW_TODO_DETAIL)
            }
        )
    }
}