package com.shijingfeng.wan_android.base

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.base.viewmodel.BaseViewModel

/**
 * Function: wan_android 模块 ViewModel 基类
 * Date: 2020/2/3 14:21
 * Description:
 * @author ShiJingFeng
 */
internal abstract class WanAndroidBaseViewModel<R : BaseRepository<*, *>>(
    repository: R? = null
) : BaseViewModel<R>(repository)