package com.shijingfeng.todo.ui.fragment

import android.util.SparseArray
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.shijingfeng.base.arouter.FRAGMENT_TODO_TODO
import com.shijingfeng.base.base.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.todo.R
import com.shijingfeng.todo.BR
import com.shijingfeng.todo.base.TodoBaseFragment
import com.shijingfeng.todo.constant.VIEW_TODO_DETAIL
import com.shijingfeng.todo.databinding.FragmentTodoMainTodoBinding
import com.shijingfeng.todo.adapter.MainTodoGroupAdapter
import com.shijingfeng.todo.source.network.getMainTodoNetworkSourceInstance
import com.shijingfeng.todo.source.repository.getMainTodoRepositoryInstance
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
    private var mMainTodoGroupAdapter: MainTodoGroupAdapter? = null

    /**
     * 获取视图ID
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.fragment_todo_main_todo

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel(): MainTodoViewModel? {
        val repository = getMainTodoRepositoryInstance(
            networkSource = getMainTodoNetworkSourceInstance()
        )

        val factory = createCommonViewModelFactory(
            repository = repository
        )
        return createViewModel(MainTodoViewModel::class.java, factory)
    }

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
            mMainTodoGroupAdapter = MainTodoGroupAdapter(this, mViewModel?.mMainTodoItemList)
            mDataBinding.rvContent.adapter = mMainTodoGroupAdapter
            mDataBinding.rvContent.layoutManager = LinearLayoutManager(this)
        }
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
        mMainTodoGroupAdapter?.setOnItemEventListener { view, data, position, flag ->
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
        //RecyclerView 适配器和数据列表 LiveData 监听器
        mViewModel?.mListDataChangeEvent?.observe(this, Observer ObserverLabel@ { (type, _, _, extraData, todoGroupItemList, _) ->
            when (type) {
                // 加载, 刷新
                LOAD, REFRESH -> mMainTodoGroupAdapter?.notifyDataSetChanged()
                // 添加
                ADD -> {
                    val oldSize = extraData as Int

                    when {
                        oldSize <= 0 -> mMainTodoGroupAdapter?.notifyDataSetChanged()
                        oldSize == mViewModel!!.mMainTodoItemList.size -> mMainTodoGroupAdapter?.notifyItemChanged(mViewModel!!.mMainTodoItemList.size - 1)
                        else -> mMainTodoGroupAdapter?.notifyItemRangeInserted(
                            oldSize,
                            mViewModel!!.mMainTodoItemList.size - oldSize
                        )
                    }
                }
                // 插入
                INSERT -> {}
                // 删除
                REMOVE -> {}
                // 更新
                UPDATE -> {}
                else -> {}
            }
        })
    }
}