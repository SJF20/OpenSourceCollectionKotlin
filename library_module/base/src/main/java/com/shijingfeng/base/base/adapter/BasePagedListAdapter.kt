package com.shijingfeng.base.base.adapter

import android.content.Context
import android.text.TextUtils
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder
import com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder.Companion.createCommonViewHolder
import com.shijingfeng.base.base.entity.BaseEntity
import com.shijingfeng.base.common.extension.onItemEvent

/**
 * Function: 通用 Paging分页加载 Adapter
 * Date: 2020/1/27 13:58
 * Description:
 * Author: ShiJingFeng
 */
abstract class BasePagedListAdapter<T : BaseEntity>: PagedListAdapter<T, CommonViewHolder> {

    private val mContext: Context
    private val mLayoutId: Int

    /** 当前操作的Item Position  */
    protected var mChoiceItemPosition = -1
    /** 回调监听器 */
    protected var mOnItemEvent: onItemEvent? = null

    constructor(
        context: Context,
        layoutId: Int,
        diffCallback: DiffUtil.ItemCallback<T>
    ) : super(diffCallback) {
        this.mContext = context
        this.mLayoutId = layoutId
    }

    constructor(
        context: Context,
        layoutId: Int,
        config: AsyncDifferConfig<T>
    ) : super(config) {
        this.mContext = context
        this.mLayoutId = layoutId
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CommonViewHolder =
        createCommonViewHolder(
            mContext,
            mLayoutId,
            parent
        )

    override fun onBindViewHolder(
        holder: CommonViewHolder,
        position: Int
    ) {}

    override fun onBindViewHolder(
        holder: CommonViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        convert(holder, getItem(position), position, payloads)
    }

    /**
     * 用户自定义处理数据
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     * @param payloads 局部更新数据标志
     */
    protected abstract fun convert(
        holder: CommonViewHolder,
        data: T?,
        position: Int,
        payloads: List<Any?>?
    )

    /**
     * 通过ID 获取当前Position位置
     * @param id 位置
     */
    fun getPositionById(id: String): Int {
        val itemCount = itemCount
        if (itemCount == 0) {
            return -1
        }
        for (i in 0 until itemCount) {
            val data: BaseEntity = getItem(i) as BaseEntity
            val currentId = data.getId()

            if (TextUtils.isEmpty(currentId)) {
                return -1
            } else if (id == currentId) {
                return i
            }
        }
        return -1
    }

    /**
     * 设置回调监听器
     * @param onItemEvent 回调监听器
     */
    fun setOnItemEventListener(onItemEvent: onItemEvent?) {
        this.mOnItemEvent = onItemEvent
    }

    /**
     * 获取当前操作的 Item Position
     * @return 当前操作的 Item Position
     */
    fun getChoiceItemPosition() = mChoiceItemPosition

}