package com.shijingfeng.todo.view_model

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.todo.base.TodoBaseViewModel

/**
 * Function: 主页 -> 已完成 ViewModel
 * Date: 2020/5/19 9:42
 * Description:
 * @author ShiJingFeng
 */
internal class DoneViewModel : TodoBaseViewModel<BaseRepository<*, *>>()