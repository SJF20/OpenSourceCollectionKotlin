package com.shijingfeng.base.base.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.shijingfeng.base.common.extension.onItemEvent

/**
 * Function: 通用 PagerAdapter
 * Date: 2020/1/27 14:15
 * Description:
 * Author: ShiJingFeng
 */
open class CommonPagerAdapter<T>(
    protected val mContext: Context,
    protected val mDataList: List<T>? = null
) : PagerAdapter() {

    protected var mOnItemEvent: onItemEvent? = null

    /**
     * 初始化 Item
     * @param container  父容器
     * @param position   下标位置
     * @return           初始化生成的View对象
     */
    override fun instantiateItem(container: ViewGroup, position: Int) = super.instantiateItem(container, position)

    /**
     * 销毁 Item
     * @param container 父容器
     * @param position  下标位置
     * @param any    View对象
     */
    override fun destroyItem(container: ViewGroup, position: Int, any: Any) {
        container.removeView(any as View)
    }

    /**
     * 判断 Item
     * @param view    View
     * @param any  对象
     * @return        是否是同一个Item
     */
    override fun isViewFromObject(view: View, any: Any) = (any == view)

    /**
     * 获取 Item 数量
     * @return 数量
     */
    override fun getCount() = (mDataList?.size ?: 0)

    /**
     * 设置 事件回调监听
     * @param onItemEvent 事件回调监听
     */
    fun setOnItemEventListener(onItemEvent: onItemEvent?) {
        this.mOnItemEvent = onItemEvent
    }

}