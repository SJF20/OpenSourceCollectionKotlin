package com.shijingfeng.weather.entity.event

import com.shijingfeng.weather.annotation.define.CityDataOperateType
import com.shijingfeng.weather.common.constant.*

/**
 * Function: 城市数据 Event (数据已改变, 只用于通知适配器更新视图)
 * Date: 2020/10/30 21:20
 * Description:
 * Author: ShiJingFeng
 */
internal data class CityDataChangeEvent(

    /** 操作类型  */
    @CityDataOperateType
    val type: Int,

    /** 额外携带的数据  */
    val extraData: Any? = null,

    /**
     * 索引下标列表
     *
     * [type] = [CITY_DATA_OPERATE_NONE]: 该索引下标列表无效
     * [type] = [CITY_DATA_OPERATE_ADD]: 要添加 或 要插入 的索引下标列表 (从大到小)
     * [type] = [CITY_DATA_OPERATE_REMOVE]: 要删除的索引下标列表 (从大到小)
     * [type] = [CITY_DATA_OPERATE_CLEAR]: 清空数据, 该索引下标列表无效
     * [type] = [CITY_DATA_OPERATE_UPDATE]: 要更新的索引下标列表 (原来的顺序)
     * [type] = [CITY_DATA_OPERATE_MOVE]: 要移动的索引下标列表, 成对存在, 格式例子: { 原来的下标, 目标下标, 原来的下标, 目标下标, ... }
     * [type] = [CITY_DATA_OPERATE_SWAP]: 要交换的索引下标列表, 成对存在, 格式例子: { 开始下标, 结束下标, 开始下标, 结束下标, ... }
     */
    val indexList: List<Int> = listOf()

)