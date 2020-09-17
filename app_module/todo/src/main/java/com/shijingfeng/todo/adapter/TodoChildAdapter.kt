package com.shijingfeng.todo.adapter

import android.content.Context
import com.shijingfeng.base.base.adapter.BaseMultiItemAdapter
import com.shijingfeng.base.base.adapter.support.MultiItemTypeSupport
import com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder
import com.shijingfeng.todo.R
import com.shijingfeng.todo.entity.adapter.TodoChildImageItem
import com.shijingfeng.todo.entity.adapter.TodoChildItem
import com.shijingfeng.todo.entity.adapter.TodoChildItem.Companion.ITEM_TYPE_IMAGE
import com.shijingfeng.todo.entity.adapter.TodoChildItem.Companion.ITEM_TYPE_TEXT
import com.shijingfeng.todo.entity.adapter.TodoChildTextItem

/**
 * Function: Item Child 适配器
 * Date: 2020/9/17 22:22
 * Description:
 * @author ShiJingFeng
 */
internal class TodoChildAdapter(
    context: Context,
    dataList: List<TodoChildItem>? = null,
    multiItemTypeSupport: MultiItemTypeSupport<TodoChildItem>
) : BaseMultiItemAdapter<TodoChildItem>(
    context,
    dataList,
    multiItemTypeSupport
) {

    /**
     * 用户自定义处理数据 (单个Item内 全局刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     */
    override fun convert(holder: CommonViewHolder, data: TodoChildItem, position: Int) {
        when (data.getType()) {
            ITEM_TYPE_TEXT -> {
                val todoChildTextItem = data.get<TodoChildTextItem>()

                holder.setText(R.id.tv_text, todoChildTextItem.text)
            }
            ITEM_TYPE_IMAGE -> {
                val todoChildImageItem = data.get<TodoChildImageItem>()


            }
            else -> {}
        }
    }
}