package com.shijingfeng.todo.adapter

import android.content.Context
import android.view.View
import com.shijingfeng.base_adapter.BaseMultiItemAdapter
import com.shijingfeng.base_adapter.support.MultiItemTypeSupport
import com.shijingfeng.base_adapter.viewholder.CommonViewHolder
import com.shijingfeng.todo.R
import com.shijingfeng.todo.annotation.define.TodoChildType.ITEM_TYPE_IMAGE
import com.shijingfeng.todo.annotation.define.TodoChildType.ITEM_TYPE_TEXT
import com.shijingfeng.todo.constant.REMOVE_ITEM
import com.shijingfeng.todo.entity.Image
import com.shijingfeng.todo.entity.Image.Companion.IMAGE_TYPE_NONE
import com.shijingfeng.todo.entity.adapter.TodoChildImageItem
import com.shijingfeng.todo.entity.adapter.TodoChildItem
import com.shijingfeng.todo.entity.adapter.TodoChildTextItem

/**
 * Function: Item Child 适配器
 * Date: 2020/9/17 22:22
 * Description:
 * Author: ShiJingFeng
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
                val imageList = todoChildImageItem.imageList.apply {
                    add(Image())
                }
                val adapter = TodoGrandchildImageAdapter(
                    context = context,
                    dataList = imageList,
                    multiItemTypeSupport = object : MultiItemTypeSupport<Image> {

                        /** 图片 */
                        private val ITEM_TYPE_IMAGE = 0
                        /** 添加图片 */
                        private val ITEM_TYPE_ADD_IMAGE = 1

                        /**
                         * 根据 Item类型 获取 Layout Id
                         * @param itemType Item类型
                         * @return Layout Id
                         */
                        override fun getLayoutId(itemType: Int) = if (itemType == ITEM_TYPE_ADD_IMAGE) {
                            R.layout.adapter_item_todo_todo_grandchild_add
                        } else {
                            R.layout.adapter_item_todo_todo_grandchild_image
                        }

                        /**
                         * 获取 Item类型
                         * @param position 下标位置
                         * @param data 数据
                         * @return Item类型
                         */
                        override fun getItemViewType(position: Int, data: Image) = if ((position == imageList.size - 1) && (data.imageType == IMAGE_TYPE_NONE)) {
                            ITEM_TYPE_ADD_IMAGE
                        } else {
                            ITEM_TYPE_IMAGE
                        }

                    }
                )

                holder.setGridAdapter(
                    viewId = R.id.rv_child_list,
                    adapter = adapter,
                    spanCount = 5
                )
            }
            else -> {}
        }

        // 删除
        holder.setOnClickListener(
            viewId = R.id.iv_remove,
            listener = View.OnClickListener { view ->
                onItemEvent?.invoke(view, data, position, REMOVE_ITEM)
            }
        )
    }
}