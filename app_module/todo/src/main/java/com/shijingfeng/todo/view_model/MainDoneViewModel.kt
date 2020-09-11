package com.shijingfeng.todo.view_model

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.todo.base.TodoBaseViewModel

/** 第一页 页码  */
internal const val MAIN_DONE_FIRST_PAGE = 1

/**
 * Function: 主页 -> 已完成 ViewModel
 * Date: 2020/5/19 9:42
 * Description:
 * @author ShiJingFeng
 */
internal class DoneViewModel : TodoBaseViewModel<BaseRepository<*, *>>()