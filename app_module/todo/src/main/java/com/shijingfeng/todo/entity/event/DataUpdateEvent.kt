package com.shijingfeng.todo.entity.event

import com.shijingfeng.todo.ui.activity.MAIN_NEED_TO_DO
import com.shijingfeng.todo.ui.activity.MAIN_DONE
import com.shijingfeng.todo.ui.activity.MAIN_NONE
import com.shijingfeng.todo.ui.activity.MAIN_ALL

/**
 * Function: 数据更新 Event
 * Date: 2020/9/13 16:37
 * Description:
 * @author ShiJingFeng
 */
internal data class DataUpdateEvent(

    /** 页面类型: 未知[MAIN_NONE] 待办[MAIN_NEED_TO_DO] 已完成[MAIN_DONE] 全部[MAIN_ALL] */
    var pageType: Int

)