package com.shijingfeng.todo.ui.fragment

import android.os.Bundle
import android.util.SparseArray
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.kingja.loadsir.core.LoadSir
import com.shijingfeng.base.annotation.BindEventBus
import com.shijingfeng.base.arouter.FRAGMENT_TODO_LIST
import com.shijingfeng.base.base.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.todo.R
import com.shijingfeng.todo.BR
import com.shijingfeng.todo.base.TodoBaseFragment
import com.shijingfeng.todo.adapter.TodoGroupListAdapter
import com.shijingfeng.todo.constant.*
import com.shijingfeng.todo.constant.TAB_LAYOUT_VISIBILITY
import com.shijingfeng.todo.constant.TYPE
import com.shijingfeng.todo.constant.TYPE_NONE
import com.shijingfeng.todo.constant.VIEW_TODO_DETAIL
import com.shijingfeng.todo.databinding.FragmentTodoTodoListBinding
import com.shijingfeng.todo.entity.adapter.TodoListItem
import com.shijingfeng.todo.entity.event.DataUpdateEvent
import com.shijingfeng.todo.entity.event.FilterConditionEvent
import com.shijingfeng.todo.source.network.getTodoListNetworkSourceInstance
import com.shijingfeng.todo.source.repository.getTodoListRepositoryInstance
import com.shijingfeng.todo.ui.activity.MAIN_ALL
import com.shijingfeng.todo.ui.activity.MAIN_NONE
import com.shijingfeng.todo.view_model.TodoListViewModel
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * 创建 TodoListFragment 实例
 */
internal fun createTodoListFragment(
    bundle: Bundle? = null
): TodoListFragment {
    val fragment = TodoListFragment()

    if (bundle != null) {
        fragment.arguments = bundle
    }
    return fragment
}

/**
 * Function: 首页 -> 待办 Fragment
 * Date: 2020/5/17 16:17
 * Description:
 * @author ShiJingFeng
 */
@Route(path = FRAGMENT_TODO_LIST)
@BindEventBus
internal class TodoListFragment : TodoBaseFragment<FragmentTodoTodoListBinding, TodoListViewModel>() {

    /** 待办 分组 适配器 */
    private var mTodoGroupListAdapter: TodoGroupListAdapter? = null

    /**
     * 获取视图ID
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.fragment_todo_todo_list

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel(): TodoListViewModel? {
        val repository = getTodoListRepositoryInstance(
            networkSource = getTodoListNetworkSourceInstance()
        )

        val factory = createCommonViewModelFactory(
            repository = repository
        )
        return createViewModel(TodoListViewModel::class.java, factory)
    }

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.todoListViewModel, mViewModel)
    }

    /**
     * 初始化数据
     */
    override fun initData() {
        super.initData()
        mSmartRefreshLayout = mDataBinding.srlRefresh
        // 当内容不满一页是否可以上拉加载  true: 可以  false: 不可以
        mSmartRefreshLayout?.setEnableLoadMoreWhenContentNotFull(true)
        mLoadService = LoadSir.getDefault().register(mDataBinding.srlRefresh, mViewModel?.mReloadListener)
        if (mViewModel == null || !mViewModel!!.mHasInited) {
            showCallback(LOAD_SERVICE_LOADING)
        }
        registerLoadingView(
            view = mDataBinding.flContent,
            hintText = getStringById(R.string.加载中)
        )

        activity?.run {
            mTodoGroupListAdapter = TodoGroupListAdapter(this, mViewModel?.mTodoGroupItemList)
            mDataBinding.rvContent.adapter = mTodoGroupListAdapter
            mDataBinding.rvContent.layoutManager = LinearLayoutManager(this)
        }

        if (!mDataBinding.rvContent.canScrollVertically(1)) {
            mOnItemEvent?.invoke(mDataBinding.rvContent, null, View.VISIBLE, TAB_LAYOUT_VISIBILITY)
        }
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
        mDataBinding.rvContent.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
//                if (!recyclerView.canScrollVertically(1)) {
//                    //滑倒最底部，隐藏
//                    mOnItemEvent?.invoke(recyclerView, null, View.GONE,
//                        TAB_LAYOUT_VISIBILITY
//                    )
//                    return
//                }
                if (!recyclerView.canScrollVertically(-1)) {
                    //滑倒顶部，显示
                    mOnItemEvent?.invoke(recyclerView, null, View.VISIBLE,
                        TAB_LAYOUT_VISIBILITY
                    )
                    return
                }
                mOnItemEvent?.invoke(
                    recyclerView,
                    null,
                    if (dy > 0) View.GONE else View.VISIBLE,
                    TAB_LAYOUT_VISIBILITY
                )
            }
        })
        mTodoGroupListAdapter?.setOnItemEventListener { view, data, position, flag ->
            when (flag) {
                // 删除 Item
                REMOVE_ITEM -> {
                    val todoItem = data as TodoListItem

                    mViewModel?.remove(todoItem.getId())
                }
                // 标记完成
                TODO_COMPLETED,
                // 撤回
                TODO_RECALL -> {
                    val todoItem = data as TodoListItem

                    mViewModel?.updateStatus(todoItem.getId(), if (flag == TODO_COMPLETED) STATUS_DONE else STATUS_NEED_TO_DO)
                }
                // 查看 待办事项 详情
                VIEW_TODO_DETAIL -> {}
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
                LOAD, REFRESH -> mTodoGroupListAdapter?.notifyDataSetChanged()
                // 添加
                ADD -> {
                    val oldSize = extraData as Int

                    when {
                        oldSize <= 0 -> mTodoGroupListAdapter?.notifyDataSetChanged()
                        oldSize == mViewModel!!.mTodoGroupItemList.size -> mTodoGroupListAdapter?.notifyItemChanged(mViewModel!!.mTodoGroupItemList.size - 1)
                        else -> mTodoGroupListAdapter?.notifyItemRangeInserted(
                            oldSize,
                            mViewModel!!.mTodoGroupItemList.size - oldSize
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

    /**
     * 是否开启懒加载 (用于ViewPager)
     * @return true 开启  false 关闭  默认关闭
     */
    override fun isEnableLazyLoad() = true

    /**
     * 获取 筛选条件 Event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getFilterConditionEvent(event: FilterConditionEvent) {
        val pageType = event.pageType
        val type = event.type
        val priority = event.priority
        val orderBy = event.orderBy

        if (pageType == MAIN_NONE) {
            return
        }
        mViewModel?.run {
            if (pageType == mPageType) {
                if (type != TYPE_NONE) {
                    mRequestParamMap[TYPE] = type
                }
                if (priority != PRIORITY_NONE) {
                    mRequestParamMap[PRIORITY] = priority
                }
                if (orderBy != ORDER_BY_NONE) {
                    mRequestParamMap[ORDER_BY] = orderBy
                }

                reload()
            }
        }

    }

    /**
     * 获取 数据更新 Event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getDataUpdateEvent(event: DataUpdateEvent) {
        val pageType = event.pageType

        if (pageType == MAIN_NONE) {
            return
        }
        mViewModel?.run {
            if (pageType == MAIN_ALL || pageType == mPageType) {
                reload()
            }
        }
    }

}