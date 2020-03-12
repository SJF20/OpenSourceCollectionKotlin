package com.shijingfeng.wan_android.ui.fragment

import android.util.SparseArray
import com.alibaba.android.arouter.facade.annotation.Route
import com.shijingfeng.base.arouter.FRAGMENT_WAN_ANDROID_CLASSIFY
import com.shijingfeng.base.base.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseFragment
import com.shijingfeng.wan_android.databinding.FragmentClassifyBinding
import com.shijingfeng.wan_android.viewmodel.ClassifyViewModel

/** 知识体系  */
private const val CLASSIFY_KNOWLEDGE = 0
/** 分类导航  */
private const val CLASSIFY_NAVIGATION = 1

/**
 * Function: 知识体系 Fragment
 * Date: 2020/2/12 16:52
 * Description:
 * @author ShiJingFeng
 */
@Route(path = FRAGMENT_WAN_ANDROID_CLASSIFY)
class ClassifyFragment : WanAndroidBaseFragment<FragmentClassifyBinding, ClassifyViewModel>() {

    /**
     * 获取视图ID
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.fragment_classify

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel() = createViewModel(ClassifyViewModel::class.java, createCommonViewModelFactory())

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.classifyViewModel, mViewModel)
    }

    /**
     * 初始化数据
     */
    override fun initData() {
        super.initData()
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
    }

    /**
     * 初始化 LiveData Observer
     */
    override fun initObserver() {
        super.initObserver()
    }

    /**
     * 是否开启懒加载 (用于ViewPager)
     *
     * @return true 开启  false 关闭  默认关闭
     */
    override fun isEnableLazyLoad() = true

}