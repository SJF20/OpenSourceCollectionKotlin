package com.shijingfeng.base.base.adapter.support

import androidx.annotation.LayoutRes
import com.shijingfeng.base.base.entity.BaseEntity

/**
 * Function: 多种Item类型支持
 * Date: 2020/1/23 20:58
 * Description:
 * Author: ShiJingFeng
 */
interface MultiItemTypeSupport<T : BaseEntity> {

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