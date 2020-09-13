package com.shijingfeng.todo.entity.event

import com.shijingfeng.todo.annotation.define.TodoOrderBy
import com.shijingfeng.todo.annotation.define.TodoPriority
import com.shijingfeng.todo.annotation.define.TodoType
import com.shijingfeng.todo.constant.ORDER_BY_NONE
import com.shijingfeng.todo.constant.PRIORITY_NONE
import com.shijingfeng.todo.constant.TYPE_NONE

import com.shijingfeng.todo.ui.activity.MAIN_NEED_TO_DO
import com.shijingfeng.todo.ui.activity.MAIN_DONE
import com.shijingfeng.todo.ui.activity.MAIN_NONE

/**
 * Function: 筛选条件 Event
 * Date: 2020/9/11 13:41
 * Description:
 * @author ShiJingFeng
 */
internal data class FilterConditionEvent(

    /** 状态类型: 未知[MAIN_NONE] 待办[MAIN_NEED_TO_DO], 已完成[MAIN_DONE]*/
    var pageType: Int = MAIN_NONE,

    /** 待办事项类型 */
    @TodoType
    var type: Int = TYPE_NONE,

    /** 优先级 */
    @TodoPriority
    var priority: Int = PRIORITY_NONE,

    /** 排序 */
    @TodoOrderBy
    var orderBy: Int = ORDER_BY_NONE

)