package com.shijingfeng.todo.base

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.mvvm.viewmodel.BaseViewModel

/**
 * Function: todo模块 ViewModel 基类
 * Date: 2020/3/18 22:57
 * Description:
 * @author ShiJingFeng
 */
internal abstract class TodoBaseViewModel<R : BaseRepository<*, *>> : BaseViewModel<R>()