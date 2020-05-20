package com.shijingfeng.todo.ui.fragment

import android.util.SparseArray
import com.alibaba.android.arouter.facade.annotation.Route
import com.shijingfeng.base.arouter.FRAGMENT_TODO_TODO
import com.shijingfeng.base.base.adapter.support.MultiItemTypeSupport
import com.shijingfeng.todo.R
import com.shijingfeng.todo.BR
import com.shijingfeng.todo.adapter.MainTodoAdapter
import com.shijingfeng.todo.base.TodoBaseFragment
import com.shijingfeng.todo.constant.VIEW_TODO_DETAIL
import com.shijingfeng.todo.databinding.FragmentTodoMainTodoBinding
import com.shijingfeng.todo.entity.adapter.MAIN_TODO_GROUP_ITEM
import com.shijingfeng.todo.entity.adapter.MAIN_TODO_GROUP_TITLE_ITEM
import com.shijingfeng.todo.entity.adapter.TodoGroupItem
import com.shijingfeng.todo.view_model.MainTodoViewModel

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
internal class TodoFragment : TodoBaseFragment<FragmentTodoMainTodoBinding, MainTodoViewModel>() {

    /** 待办 分组 适配器 */
    private var mMainTodoAdapter: MainTodoAdapter? = null

    /**
     * 获取视图ID
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.fragment_todo_main_todo

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel() = createViewModel(MainTodoViewModel::class.java)

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.todoViewModel, mViewModel)
    }

    /**
     * 初始化数据
     */
    override fun initData() {
        super.initData()
        activity?.run {
            mMainTodoAdapter = MainTodoAdapter(this, mViewModel?.mTodoGroupItemList, object : MultiItemTypeSupport<TodoGroupItem> {

                /**
                 * 根据 Item类型 获取 Layout Id
                 * @param itemType Item类型
                 * @return Layout Id
                 */
                override fun getLayoutId(itemType: Int) = when (itemType) {
                    // 主页 -> 待办 分组后的 标题Item
                    MAIN_TODO_GROUP_TITLE_ITEM -> R.layout.adapter_item_todo_main_todo_title
                    // 主页 -> 待办 分组后的 普通Item
                    MAIN_TODO_GROUP_ITEM -> R.layout.adapter_item_todo_main_todo
                    else -> R.layout.adapter_item_null
                }

                /**
                 * 获取 Item类型
                 * @param position 下标位置
                 * @param data 数据
                 * @return Item类型
                 */
                override fun getItemViewType(position: Int, data: TodoGroupItem) = data.getType()

            })
        }
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
        mMainTodoAdapter?.setOnItemEventListener { view, data, position, flag ->
            when (flag) {
                // 查看 待办事项 详情
                VIEW_TODO_DETAIL -> {

                }
            }
        }
    }

    /**
     * 初始化 LiveData Observer
     */
    override fun initObserver() {
        super.initObserver()

    }
}