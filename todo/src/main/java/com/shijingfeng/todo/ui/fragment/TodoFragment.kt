package com.shijingfeng.todo.ui.fragment

import android.util.SparseArray
import com.alibaba.android.arouter.facade.annotation.Route
import com.shijingfeng.base.arouter.FRAGMENT_TODO_TODO
import com.shijingfeng.todo.R
import com.shijingfeng.todo.BR
import com.shijingfeng.todo.base.TodoBaseFragment
import com.shijingfeng.todo.databinding.FragmentTodoTodoBinding
import com.shijingfeng.todo.view_model.TodoViewModel

/**
 * 创建 TodoFragment 实例
 */
internal fun createTodoFragment() = TodoFragment()

/**
 * Function: 首页 -> 待办 Fragment
 * Date: 2020/5/17 16:17
 * Description:
 * @author ShiJingFeng
 */
@Route(path = FRAGMENT_TODO_TODO)
internal class TodoFragment : TodoBaseFragment<FragmentTodoTodoBinding, TodoViewModel>() {

    /**
     * 获取视图ID
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.fragment_todo_todo

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel() = createViewModel(TodoViewModel::class.java)

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.todoViewModel, mViewModel)
    }


}