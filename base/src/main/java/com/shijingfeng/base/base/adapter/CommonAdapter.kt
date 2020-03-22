package com.shijingfeng.base.base.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder
import com.shijingfeng.base.base.adapter.viewholder.createCommonViewHolder
import com.shijingfeng.base.base.entity.BaseEntity
import com.shijingfeng.base.common.extension.onItemEvent

/**
 * Function: 通用 RecyclerView Adapter
 * Date: 2020/1/24 10:13
 * Description:
 * @author ShiJingFeng
 */
abstract class CommonAdapter<T : BaseEntity>(
    protected val mContext: Context,
    protected val mLayoutId: Int,
    protected var mDataList: List<T>? = null
) : RecyclerView.Adapter<CommonViewHolder>() {

    /** 当前操作的Item Position  */
    protected var mChoiceItemPosition = -1
    /** 回调监听器 */
    protected var mOnItemEvent: onItemEvent? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CommonViewHolder {
        return createCommonViewHolder(
            mContext,
            mLayoutId,
            parent
        )
    }

    override fun onBindViewHolder(
        holder: CommonViewHolder,
        position: Int
    ) {}

    override fun onBindViewHolder(
        holder: CommonViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isEmpty()) {
            convert(holder, mDataList!![position], position)
        } else {
            partialConvert(holder, mDataList!![position], position, payloads)
        }
    }

    /**
     * 用户自定义处理数据 (单个Item内 全局刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     */
    protected abstract fun convert(
        holder: CommonViewHolder,
        data: T,
        position: Int
    )

    /**
     * 用户自定义处理数据 (单个Item内 局部刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     * @param payloads 局部刷新标记 (注：为什么是List，而不是Object, 因为在Item中的View刷新之前，可能存在短时间刷新多次，所以就会有多个占位符存入List中)
     */
    protected open fun partialConvert(
        holder: CommonViewHolder,
        data: T,
        position: Int,
        payloads: List<Any>
    ) {}

    /**
     * 通过ID 获取当前Position位置
     * @param id 位置
     */
    open fun getPositionById(id: String): Int {
        val dataList = mDataList

        if (dataList.isNullOrEmpty()) {
            return -1
        }

        for (i in dataList.indices) {
            val data: BaseEntity = dataList[i]
            val currentId = data.getId()

            if (id === currentId) {
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

    override fun getItemCount(): Int = (mDataList?.size ?: 0)

    /**
     * 获取当前操作的 Item Position
     * @return 当前操作的 Item Position
     */
    fun getChoiceItemPosition() = mChoiceItemPosition

}