package com.shijingfeng.wan_android.ui.activity

import android.util.SparseArray
import com.alibaba.android.arouter.facade.annotation.Route
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_USER_INFO
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseActivity
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidUserInfoBinding
import com.shijingfeng.wan_android.view_model.UserInfoViewModel

/**
 * Function: 用户信息 Activity
 * Date: 20-4-6 下午11:00
 * Description:
 * @author shijingfeng
 */
@Route(path = ACTIVITY_WAN_ANDROID_USER_INFO)
internal class UserInfoActivity : WanAndroidBaseActivity<ActivityWanAndroidUserInfoBinding, UserInfoViewModel>() {

    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.activity_wan_android_user_info

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel() = createViewModel(UserInfoViewModel::class.java)

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.userInfoViewModel, mViewModel)
    }

    /**
     * 初始化数据
     */
    override fun initData() {
        super.initData()
        mDataBinding.includeTitleBar.tvTitle.text = getStringById(R.string.用户信息)
    }

}