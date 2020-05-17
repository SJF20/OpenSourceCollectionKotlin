package com.shijingfeng.todo.ui.activity

import android.util.SparseArray
import android.view.LayoutInflater
import com.alibaba.android.arouter.facade.annotation.Route
import com.shijingfeng.base.arouter.ACTIVITY_TODO_MAIN
import com.shijingfeng.base.base.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.todo.R
import com.shijingfeng.todo.BR
import com.shijingfeng.todo.base.TodoBaseActivity
import com.shijingfeng.todo.databinding.ActivityTodoMainBinding
import com.shijingfeng.todo.source.local.getMainLocalSourceInstance
import com.shijingfeng.todo.source.network.getMainNetworkSourceInstance
import com.shijingfeng.todo.source.repository.getMainRepositoryInstance
import com.shijingfeng.todo.view_model.MainViewModel

/** 主页 -> 待办 */
internal const val MAIN_TODO = 0
/** 主页 -> 已完成 */
internal const val MAIN_DONE = 1

/**
 * Function: 主页 Activity
 * Date: 2020/3/18 23:00
 * Description:
 * @author ShiJingFeng
 */
@Route(path = ACTIVITY_TODO_MAIN)
internal class MainActivity : TodoBaseActivity<ActivityTodoMainBinding, MainViewModel>() {

    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.activity_todo_main

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel(): MainViewModel? {
        val repository = getMainRepositoryInstance(
            localSource = getMainLocalSourceInstance(),
            networkSource = getMainNetworkSourceInstance()
        )
        val factory = createCommonViewModelFactory(
            repository = repository
        )

        return createViewModel(MainViewModel::class.java, factory)
    }

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.mainViewModel, mViewModel)
    }

    /**
     * 初始化数据
     */
    override fun initData() {
        super.initData()
        mDataBinding.includeTitleBar.tvTitle.text = getStringById(R.string.无分类)
        mDataBinding.tlTabs.run {
            newTab().customView =
            addTab(newTab(), true)
            addTab(newTab())
        }
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
        // 跳转到 wan_android 模块 主页
    }

    /**
     * 是否自定义设置状态栏
     * @return true 自定义设置  false 默认设置
     */
    override fun isSetCustomStatusBar() = true

    fun getTabView(position: Int) = when (position) {
        // 待办
        MAIN_TODO -> LayoutInflater.from(this).inflate()
        // 已完成
        MAIN_DONE -> {}
        else -> {}
    }

}