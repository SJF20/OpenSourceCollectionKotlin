package com.shijingfeng.todo.ui.fragment

import com.shijingfeng.todo.R
import com.shijingfeng.todo.base.TodoBaseFragment
import com.shijingfeng.todo.base.TodoBaseViewModel
import com.shijingfeng.todo.databinding.FragmentTodoNullBinding

/**
 * 创建 EmptyFragment 实例
 */
internal fun createEmptyFragment() = EmptyFragment()

/**
 * Function: 空 Fragment (用于 条件都不满足的情况下的 占位 Fragment, 为了保证不崩溃)
 * Date: 2020/4/17 17:21
 * Description:
 * Author: ShiJingFeng
 */
internal class EmptyFragment : TodoBaseFragment<FragmentTodoNullBinding, TodoBaseViewModel<*>>() {

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
    override fun getLayoutId() = R.layout.fragment_todo_null

}