package com.shijingfeng.todo.ui.fragment

import android.util.SparseArray
import com.alibaba.android.arouter.facade.annotation.Route
import com.shijingfeng.base.annotation.BindEventBus
import com.shijingfeng.base.arouter.FRAGMENT_TODO_DONE
import com.shijingfeng.todo.BR
import com.shijingfeng.todo.R
import com.shijingfeng.todo.adapter.MainTodoGroupAdapter
import com.shijingfeng.todo.base.TodoBaseFragment
import com.shijingfeng.todo.databinding.FragmentTodoMainDoneBinding
import com.shijingfeng.todo.view_model.MainDoneViewModel

/**
 * 创建 MainDoneFragment 实例
 */
internal fun createMainDoneFragment() = MainDoneFragment()

/**
 * Function: 首页 -> 已完成 Fragment
 * Date: 2020/5/17 16:19
 * Description:
 * @author ShiJingFeng
 */
@Route(path = FRAGMENT_TODO_DONE)
@BindEventBus
internal class MainDoneFragment : TodoBaseFragment<FragmentTodoMainDoneBinding, MainDoneViewModel>() {

    /** 待办 分组 适配器 */
    private var mMainTodoGroupAdapter: MainTodoGroupAdapter? = null

    /**
     * 获取视图ID
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.fragment_todo_main_done

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel() = createViewModel(MainDoneViewModel::class.java)

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.mainDoneViewModel, mViewModel)
    }

    /**
     * 是否开启懒加载 (用于ViewPager)
     * @return true 开启  false 关闭  默认关闭
     */
    override fun isEnableLazyLoad() = true

}