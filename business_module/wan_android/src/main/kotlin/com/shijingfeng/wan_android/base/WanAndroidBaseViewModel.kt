package com.shijingfeng.wan_android.base

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.mvvm.viewmodel.BaseViewModel

/**
 * Function: wan_android 模块 ViewModel 基类
 * Date: 2020/2/3 14:21
 * Description:
 * Author: ShiJingFeng
 */
internal abstract class WanAndroidBaseViewModel<R : BaseRepository<*, *>> : BaseViewModel<R>()