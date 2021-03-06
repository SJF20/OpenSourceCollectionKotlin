package com.shijingfeng.view_original_image.base

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.mvvm.viewmodel.BaseViewModel

/**
 * Function: common 模块 ViewModel 基类
 * Date: 2020/2/2 22:31
 * Description:
 * Author: ShiJingFeng
 */
internal abstract class CommonBaseViewModel<R : BaseRepository<*, *>> : BaseViewModel<R>()