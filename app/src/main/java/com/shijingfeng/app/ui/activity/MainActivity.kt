package com.shijingfeng.app.ui.activity

import android.util.SparseArray
import android.view.KeyEvent
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.ActivityUtils
import com.shijingfeng.app.BR
import com.shijingfeng.app.R
import com.shijingfeng.app.base.AppBaseActivity
import com.shijingfeng.app.databinding.ActivityAppMainBinding
import com.shijingfeng.app.view_model.MainViewModel
import com.shijingfeng.base.arouter.ACTIVITY_APP_MAIN

/**
 * Function: 主页
 * Date: 2020/3/16 13:28
 * Description:
 * @author ShiJingFeng
 */
@Route(path = ACTIVITY_APP_MAIN)
internal class MainActivity : AppBaseActivity<ActivityAppMainBinding, MainViewModel>() {

    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.activity_app_main

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel() = createViewModel(MainViewModel::class.java)

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.mainViewModel, mViewModel)
    }

    /**
     * 是否自定义设置状态栏
     * @return true 自定义设置  false 默认设置
     */
    override fun isSetCustomStatusBar() = true

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_BACK -> {
                val size = ActivityUtils.getActivityList().size

                if (size <= 1) {
                    mViewModel?.doubleDownExitApp()
                } else {
                    finish()
                }
                return true
            }
            else -> {}
        }
        return super.onKeyDown(keyCode, event)
    }

}
