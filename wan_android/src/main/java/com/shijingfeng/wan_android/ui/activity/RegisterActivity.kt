package com.shijingfeng.wan_android.ui.activity

import android.util.SparseArray
import com.alibaba.android.arouter.facade.annotation.Route
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_REGISTER
import com.shijingfeng.base.base.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseActivity
import com.shijingfeng.wan_android.databinding.ActivityRegisterBinding
import com.shijingfeng.wan_android.source.network.getRegisterNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.RegisterRepository
import com.shijingfeng.wan_android.source.repository.getRegisterRepositoryInstance
import com.shijingfeng.wan_android.viewmodel.RegisterViewModel

/**
 * Function: 注册 Activity
 * Date: 2020/2/5 16:23
 * Description:
 * @author ShiJingFeng
 */
@Route(path = ACTIVITY_WAN_ANDROID_REGISTER)
class RegisterActivity: WanAndroidBaseActivity<ActivityRegisterBinding, RegisterViewModel>() {

    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.activity_register

    /**
     * 获取ViewModel
     *
     * @return ViewModel
     */
    override fun getViewModel(): RegisterViewModel? {
        val registerRepository: RegisterRepository = getRegisterRepositoryInstance(
            networkSource = getRegisterNetworkSourceInstance()
        )
        val factory = createCommonViewModelFactory(
            repository = registerRepository
        )

        return createViewModel(RegisterViewModel::class.java, factory)
    }

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     */
    override fun getVariableSparseArray(): SparseArray<Any>? {
        return SparseArray<Any>().apply {
            put(BR.registerViewModel, mViewModel)
        }
    }

    /**
     * 初始化数据
     */
    override fun initData() {
        super.initData()
        mDataBinding.includeTitleBar.tvTitle.text = "注册"
    }

}