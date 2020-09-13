package com.shijingfeng.todo.view_model

import android.view.View
import com.shijingfeng.todo.base.TodoBaseViewModel
import com.shijingfeng.todo.source.repository.MainRepository
import com.shijingfeng.todo.ui.activity.MAIN_NEED_TO_DO

/**
 * Function: 主页 ViewModel
 * Date: 2020/3/18 23:01
 * Description:
 * @author ShiJingFeng
 */
internal class MainViewModel(
    repository: MainRepository? = null
) : TodoBaseViewModel<MainRepository>() {

    /** 当前 ViewPager 下标  */
    var mCurPosition = MAIN_NEED_TO_DO

    /** 返回  */
    val mBackClickListener = View.OnClickListener { finish() }

}