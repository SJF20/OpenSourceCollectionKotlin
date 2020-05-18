package com.shijingfeng.todo.ui.activity

import android.annotation.SuppressLint
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.material.tabs.TabLayout
import com.shijingfeng.base.arouter.ACTIVITY_TODO_MAIN
import com.shijingfeng.base.base.adapter.BaseFragmentPagerAdapter
import com.shijingfeng.base.base.adapter.OnFragmentCreate
import com.shijingfeng.base.base.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.base.util.getColorById
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.todo.R
import com.shijingfeng.todo.BR
import com.shijingfeng.todo.base.TodoBaseActivity
import com.shijingfeng.todo.base.TodoBaseFragment
import com.shijingfeng.todo.databinding.ActivityTodoMainBinding
import com.shijingfeng.todo.source.local.getMainLocalSourceInstance
import com.shijingfeng.todo.source.network.getMainNetworkSourceInstance
import com.shijingfeng.todo.source.repository.getMainRepositoryInstance
import com.shijingfeng.todo.ui.fragment.createEmptyFragment
import com.shijingfeng.todo.view_model.MainViewModel

/** 主页 -> 待办 */
internal const val MAIN_TODO = 0

/** 主页 -> 已完成 */
internal const val MAIN_DONE = 1

/** Fragment 数量 */
private const val FRAGMENT_COUNT = 2

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
        mDataBinding.includeTitleBar.ivOperate.setImageResource(R.drawable.ic_switch)
        mDataBinding.includeTitleBar.ivOperate.visibility = VISIBLE
        mDataBinding.tlTabs.run {
            // 待办
            addTab(newTab(), true)
            // 已完成
            addTab(newTab())

            // TabLayout 和 ViewPager 协同
            setupWithViewPager(mDataBinding.vpContent)

            // 待办
            getTabAt(MAIN_TODO)?.customView = getTabView(MAIN_TODO)
            // 已完成
            getTabAt(MAIN_DONE)?.customView = getTabView(MAIN_DONE)

            addTab(newTab().setCustomView(getTabView(MAIN_TODO)), true)
            addTab(newTab().setCustomView(getTabView(MAIN_DONE)))
        }
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
        // 切换类型
        mDataBinding.includeTitleBar.ivOperate.setOnClickListener { v ->

        }
        // 切换状态
        mDataBinding.tlTabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab) {
                val view = tab.customView
                val ivImage = view?.findViewById<ImageView>(R.id.iv_image)
                val tvText = view?.findViewById<TextView>(R.id.tv_text)

                ivImage?.setColorFilter(getColorById(R.color.red))
                tvText?.setTextColor(getColorById(R.color.red))
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                val view = tab.customView
                val ivImage = view?.findViewById<ImageView>(R.id.iv_image)
                val tvText = view?.findViewById<TextView>(R.id.tv_text)

                ivImage?.setColorFilter(getColorById(R.color.grey))
                tvText?.setTextColor(getColorById(R.color.grey))
            }

            override fun onTabReselected(tab: TabLayout.Tab) {}

        })
    }

    /**
     * 是否自定义设置状态栏
     * @return true 自定义设置  false 默认设置
     */
    override fun isSetCustomStatusBar() = true

    @SuppressLint("InflateParams")
    private fun getTabView(position: Int): View {
        val view = LayoutInflater.from(this).inflate(R.layout.layout_todo_indicator_main, null)
        val ivImage = view.findViewById<ImageView>(R.id.iv_image)
        val tvText = view.findViewById<TextView>(R.id.tv_text)

        when (position) {
            // 待办
            MAIN_TODO -> {
                ivImage.setImageResource(R.drawable.ic_todo)
                ivImage.setColorFilter(getColorById(R.color.red))
                tvText.text = getStringById(R.string.待办)
                tvText.setTextColor(getColorById(R.color.red))
            }
            // 已完成
            MAIN_DONE -> {
                ivImage.setImageResource(R.drawable.ic_done)
                ivImage.setColorFilter(getColorById(R.color.grey))
                tvText.text = getStringById(R.string.已完成)
                tvText.setTextColor(getColorById(R.color.grey))
            }
            else -> {}
        }

        return view
    }

}

internal class MainAdapter(
    fragmentManager: FragmentManager,
    onFragmentCreate: OnFragmentCreate<TodoBaseFragment<*, *>>
) : BaseFragmentPagerAdapter<TodoBaseFragment<*, *>>(
    fragmentManager = fragmentManager,
    mBanDestroyed = true,
    mOnFragmentCreate = onFragmentCreate
) {

    /**
     * 创建 Fragment Item
     * @param position 下标
     * @return 创建好的 Fragment
     */
    override fun createItem(position: Int) = when (position) {
        MAIN_TODO -> null
        MAIN_DONE -> null
        else -> createEmptyFragment()
    }

    /**
     * 获取 Fragment List Count
     * @return Fragment List Count
     */
    override fun getCount() = FRAGMENT_COUNT

}