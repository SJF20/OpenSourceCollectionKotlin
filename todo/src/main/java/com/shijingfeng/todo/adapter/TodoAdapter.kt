package com.shijingfeng.todo.adapter

import android.content.Context
import com.shijingfeng.base.base.adapter.BaseAdapter
import com.shijingfeng.base.base.adapter.BaseMultiItemAdapter
import com.shijingfeng.base.base.adapter.support.MultiItemTypeSupport
import com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder
import com.shijingfeng.todo.entity.adapter.TodoGroupItem

/**
 * Function: 主页 -> 待办 适配器
 * Date: 2020/5/19 21:08
 * Description:
 * @author ShiJingFeng
 */
internal class TodoAdapter(
    context: Context,
    dataList: List<TodoGroupItem>,
    multiItemTypeSupport: MultiItemTypeSupport<TodoGroupItem>
) : BaseMultiItemAdapter<TodoGroupItem>(context, dataList, multiItemTypeSupport) {

    /**
     * 用户自定义处理数据 (单个Item内 全局刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     */
    override fun convert(holder: CommonViewHolder, data: TodoGroupItem, position: Int) {
        TODO("Not yet implemented")
    }
}