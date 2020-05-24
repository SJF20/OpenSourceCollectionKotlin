package com.shijingfeng.wan_android.ui.activity

import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseActivity
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidBmobTestBinding

/**
 * Function: Bmob测试 Activity
 * Date: 2020/5/23 14:33
 * Description:
 * @author ShiJingFeng
 */
internal class BmobTestActivity : WanAndroidBaseActivity<ActivityWanAndroidBmobTestBinding, WanAndroidBaseViewModel<*>>() {

    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.activity_wan_android_bmob_test

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel() = null

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = null

    /**
     * 初始化数据
     */
    override fun initData() {
        super.initData()
        mDataBinding
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
    }

}