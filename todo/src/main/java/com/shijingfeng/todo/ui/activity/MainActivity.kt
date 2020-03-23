package com.shijingfeng.todo.ui.activity

import com.alibaba.android.arouter.facade.annotation.Route
import com.shijingfeng.base.arouter.ACTIVITY_TODO_MAIN
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_MAIN
import com.shijingfeng.base.arouter.ARouterUtil.navigation
import com.shijingfeng.todo.R
import com.shijingfeng.todo.base.TodoBaseActivity
import com.shijingfeng.todo.databinding.ActivityTodoMainBinding
import com.shijingfeng.todo.view_model.MainViewModel
import kotlinx.android.synthetic.main.activity_todo_main.*

/**
 * Function: 主页
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
    override fun getViewModel() = createViewModel(MainViewModel::class.java)

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray(): Nothing? = null

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
        // 跳转到 wan_android 模块 主页
        btn_skip_to_wan_android_main.setOnClickListener {
            navigation(
                path = ACTIVITY_WAN_ANDROID_MAIN
            )
        }
    }

    /**
     * 是否自定义设置状态栏
     * @return true 自定义设置  false 默认设置
     */
    override fun isSetCustomStatusBar() = true

}