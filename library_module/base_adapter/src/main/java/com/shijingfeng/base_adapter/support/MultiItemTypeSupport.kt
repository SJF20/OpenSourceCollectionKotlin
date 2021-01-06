package com.shijingfeng.base_adapter.support

import androidx.annotation.LayoutRes

/**
 * Function: 多种Item类型支持
 * Date: 2020/1/23 20:58
 * Description:
 * @author ShiJingFeng
 */
interface MultiItemTypeSupport<T> {

    /**
     * 根据 Item类型 获取 Layout Id
     * @param itemType Item类型
     * @return Layout Id
     */
    @LayoutRes fun getLayoutId(itemType: Int): Int

    /**
     * 获取 Item类型
     * @param position 下标位置
     * @param data 数据
     * @return Item类型
     */
    fun getItemViewType(position: Int, data: T): Int

}