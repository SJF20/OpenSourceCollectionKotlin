package com.shijingfeng.wan_android.ui.activity

import android.util.SparseArray
import android.view.KeyEvent
import android.view.View.VISIBLE
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.ActivityUtils
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_LOGIN
import com.shijingfeng.base.base.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseActivity
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidLoginBinding
import com.shijingfeng.wan_android.source.repository.LoginRepository
import com.shijingfeng.wan_android.view_model.LoginViewModel
import com.shijingfeng.wan_android.source.network.getLoginNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.getLoginRepositoryInstance
import kotlinx.android.synthetic.main.activity_wan_android_login.*
import kotlinx.android.synthetic.main.activity_wan_android_login.view.*
import kotlinx.android.synthetic.main.layout_wan_android_title_bar.view.*

/**
 * Function: 登录 Activity
 * Date: 2020/2/4 20:55
 * Description:
 * @author ShiJingFeng
 */
@Route(path = ACTIVITY_WAN_ANDROID_LOGIN)
internal class LoginActivity : WanAndroidBaseActivity<ActivityWanAndroidLoginBinding, LoginViewModel>() {

    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.activity_wan_android_login

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel(): LoginViewModel? {
        val loginRepository: LoginRepository = getLoginRepositoryInstance(
            networkSource = getLoginNetworkSourceInstance()
        )
        val factory = createCommonViewModelFactory(
            repository = loginRepository
        )

        return createViewModel(LoginViewModel::class.java, factory)
    }

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.loginViewModel, mViewModel)
    }

    /**
     * 初始化数据
     */
    override fun initData() {
        super.initData()
        include_title_bar.tv_title.text = getStringById(R.string.登录)
        include_title_bar.tv_operate.text = getStringById(R.string.注册)
        include_title_bar.include_title_bar.tv_operate.visibility = VISIBLE
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        when(keyCode) {
            KeyEvent.KEYCODE_BACK -> {
                val size = ActivityUtils.getActivityList().size

                if (size <= 1) {
                    mViewModel?.doubleDownExitApp()
                } else {
                    finish()
                }
                return true
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}