package com.shijingfeng.wan_android.ui.fragment

import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseFragment
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
import com.shijingfeng.wan_android.databinding.FragmentNullBinding

/**
 * 创建 EmptyFragment 实例
 */
internal fun createEmptyFragment() = EmptyFragment()

/**
 * Function: 空 Fragment (用于 条件都不满足的情况下的 占位 Fragment, 为了保证不崩溃)
 * Date: 2020/4/17 17:21
 * Description:
 * @author ShiJingFeng
 */
internal class EmptyFragment : WanAndroidBaseFragment<FragmentNullBinding, WanAndroidBaseViewModel<*>>() {

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel(): Nothing? = null

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray(): Nothing? = null

    /**
     * 获取视图ID
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.fragment_null

}