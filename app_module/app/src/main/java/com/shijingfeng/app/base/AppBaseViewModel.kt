package com.shijingfeng.app.base

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.base.viewmodel.BaseViewModel

/**
 * Function: app 模块 ViewModel 基类
 * Date: 2020/2/2 22:31
 * Description:
 * @author ShiJingFeng
 */
internal abstract class AppBaseViewModel<R : BaseRepository<*, *>>(
    repository: R? = null
) : BaseViewModel<R>(repository)