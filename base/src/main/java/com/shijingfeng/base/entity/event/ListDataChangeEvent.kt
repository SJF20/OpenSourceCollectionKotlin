package com.shijingfeng.base.entity.event

import androidx.annotation.IntRange
import com.shijingfeng.base.common.constant.DATA_OPERATE_TYPE_NONE
import com.shijingfeng.base.common.constant.ORDER_PLAIN
import com.shijingfeng.base.common.constant.ORDER_REVERSED

/**
 * Function: 列表数据改变 Event
 * Author: ShiJingFeng
 * Date: 2019/12/7 14:59
 * Description: @JvmOverloads注解用于生成多个重载函数的java文件
 * @author ShiJingFeng
 */
data class ListDataChangeEvent<T> @JvmOverloads constructor(

    /** 操作类型  */
    var type: Int = DATA_OPERATE_TYPE_NONE,
    /** 插入的下标 (用于插入)  */
    var insertIndex: Int = -1,
    /** 插入顺序 默认倒序  */
    @IntRange(from = ORDER_PLAIN.toLong(), to = ORDER_REVERSED.toLong())
    var insertOrder: Int = ORDER_REVERSED,
    /** 额外携带的数据  */
    var extraData: Any? = null,
    /** 数据列表 (用于 刷新，添加 或 插入)  */
    var dataList: List<T>? = null,
    /** 下标列表 (用于 删除 或 修改)  */
    var indexList: List<Int>? = null

)
