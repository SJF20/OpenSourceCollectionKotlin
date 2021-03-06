package com.shijingfeng.wan_android.view_model

import android.view.View
import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel

/**
 * Function: 用户信息 ViewModel
 * Date: 2020/2/12 17:06
 * Description:
 * Author: ShiJingFeng
 */
internal class UserInfoViewModel : WanAndroidBaseViewModel<BaseRepository<*, *>>() {

    /** 返回  */
    val mBackClickListener = View.OnClickListener { finish() }

    /**
     * 获取 Repository
     * @return Repository
     */
    override fun getRepository(): Nothing? = null

}