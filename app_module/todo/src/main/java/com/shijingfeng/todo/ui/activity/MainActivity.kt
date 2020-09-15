package com.shijingfeng.todo.ui.activity

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.SparseArray
import android.util.SparseIntArray
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.ClickUtils
import com.blankj.utilcode.util.ConvertUtils
import com.google.android.material.tabs.TabLayout
import com.shijingfeng.base.arouter.ACTIVITY_TODO_MAIN
import com.shijingfeng.base.base.adapter.BaseFragmentPagerAdapter
import com.shijingfeng.base.base.adapter.OnFragmentCreate
import com.shijingfeng.base.base.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.base.util.getColorById
import com.shijingfeng.base.util.getDimensionById
import com.shijingfeng.base.util.getStatusBarHeight
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.base.widget.dialog.CommonDialog
import com.shijingfeng.todo.R
import com.shijingfeng.todo.BR
import com.shijingfeng.todo.base.TodoBaseActivity
import com.shijingfeng.todo.base.TodoBaseFragment
import com.shijingfeng.todo.constant.*
import com.shijingfeng.todo.constant.PAGE_TYPE
import com.shijingfeng.todo.constant.TAB_LAYOUT_VISIBILITY
import com.shijingfeng.todo.constant.TYPE_ALL
import com.shijingfeng.todo.constant.TYPE_LIFE
import com.shijingfeng.todo.constant.TYPE_STUDY
import com.shijingfeng.todo.constant.TYPE_WORK
import com.shijingfeng.todo.databinding.ActivityTodoMainBinding
import com.shijingfeng.todo.entity.event.FilterConditionEvent
import com.shijingfeng.todo.source.local.getMainLocalSourceInstance
import com.shijingfeng.todo.source.network.getMainNetworkSourceInstance
import com.shijingfeng.todo.source.repository.getMainRepositoryInstance
import com.shijingfeng.todo.ui.fragment.createEmptyFragment
import com.shijingfeng.todo.ui.fragment.createTodoListFragment
import com.shijingfeng.todo.view_model.MainViewModel
import org.greenrobot.eventbus.EventBus

/** Fragment 数量 */
private const val FRAGMENT_COUNT = 2

/** 主页 -> 未知 */
internal const val MAIN_NONE = -2
/** 主页 -> 所有 */
internal const val MAIN_ALL = -1
/** 主页 -> 待办 */
internal const val MAIN_NEED_TO_DO = 0
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

    /** 主页 ViewPager Fragment 适配器 */
    private var mMainFragmentPagerAdapter: MainFragmentPagerAdapter? = null

    /** 类型切换 Dialog */
    private var mTypeSwitchDialog: CommonDialog? = null

    /** 类型 SparseArray  Key: 页面类型  Value: 当前页面的类型 */
    private val mTypeSparseArray = SparseIntArray().apply {
        put(MAIN_NEED_TO_DO, TYPE_ALL)
        put(MAIN_DONE, TYPE_ALL)
    }

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
        mDataBinding.includeTitleBar.tvTitle.text = getStringById(R.string.全部)
        mDataBinding.includeTitleBar.ivOperate.setImageResource(R.drawable.ic_switch)
        mDataBinding.includeTitleBar.ivOperate.visibility = VISIBLE

        mViewModel?.mCurPosition = MAIN_NEED_TO_DO

        mMainFragmentPagerAdapter = MainFragmentPagerAdapter(
            fragmentManager = supportFragmentManager,
            onFragmentCreate = { _, fragment ->
                fragment.setOnItemEventListener { _, _, visibility, flag ->
                    when (flag) {
                        //TabLayout 设置可见性
                        TAB_LAYOUT_VISIBILITY -> setTabLayoutVisibility(visibility)
                        else -> {}
                    }
                }
            }
        )
        mDataBinding.vpContent.run {
            canScroll = false
            offscreenPageLimit = 1
            adapter = mMainFragmentPagerAdapter
        }

        mDataBinding.tlTabs.run {
            // 待办
            addTab(newTab(), true)
            // 已完成
            addTab(newTab())

            // TabLayout 和 ViewPager 协同
            setupWithViewPager(mDataBinding.vpContent)

            // 待办
            getTabAt(MAIN_NEED_TO_DO)?.customView = getTabView(MAIN_NEED_TO_DO)
            // 已完成
            getTabAt(MAIN_DONE)?.customView = getTabView(MAIN_DONE)
        }
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
        // 切换类型
        ClickUtils.applySingleDebouncing(
            mDataBinding.includeTitleBar.ivOperate
        ) {
            showTypeSwitchDialog()
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
        mDataBinding.vpContent.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                mViewModel?.mCurPosition = position

                when (mTypeSparseArray[position]) {
                    // 全部
                    TYPE_ALL -> mDataBinding.includeTitleBar.tvTitle.text = getStringById(R.string.全部)
                    // 学习
                    TYPE_STUDY -> mDataBinding.includeTitleBar.tvTitle.text = getStringById(R.string.学习)
                    // 工作
                    TYPE_WORK -> mDataBinding.includeTitleBar.tvTitle.text = getStringById(R.string.工作)
                    // 生活
                    TYPE_LIFE -> mDataBinding.includeTitleBar.tvTitle.text = getStringById(R.string.生活)
                }
            }

        })
    }

    /**
     * 设置 TabLayout 和 置顶按钮 的可见性
     * @param visibility 可见性
     */
    private fun setTabLayoutVisibility(visibility: Int) {
        if (mDataBinding.llTabs.tag == null) {
            mDataBinding.llTabs.tag = VISIBLE
        }
        if (visibility == VISIBLE) {
            //设置为可见
            if (mDataBinding.llTabs.tag as Int != VISIBLE) {
                mDataBinding.llTabs.tag = VISIBLE
                mDataBinding.llTabs
                    .animate()
                    .setDuration(400)
                    .translationY(0f)
                mDataBinding.fabAdd
                    .animate()
                    .setListener(object : AnimatorListenerAdapter() {

                        override fun onAnimationStart(animation: Animator) {
                            super.onAnimationStart(animation)
                            mDataBinding.fabAdd.isEnabled = false
                        }

                        override fun onAnimationEnd(animation: Animator) {
                            super.onAnimationEnd(animation)
                            mDataBinding.fabAdd.isEnabled = true
                        }

                    })
                    .setDuration(400)
                    .scaleX(1.0f)
                    .scaleY(1.0f)
            }
        } else if (visibility == View.GONE) {
            //设置为不可见
            if (mDataBinding.llTabs.tag as Int != View.GONE) {
                mDataBinding.llTabs.tag = View.GONE
                mDataBinding.llTabs
                    .animate()
                    .setDuration(400)
                    .translationY(ConvertUtils.dp2px(70f).toFloat())
                mDataBinding.fabAdd
                    .animate()
                    .setListener(object : AnimatorListenerAdapter() {

                        override fun onAnimationStart(animation: Animator) {
                            super.onAnimationStart(animation)
                            mDataBinding.fabAdd.isEnabled = false
                        }

                        override fun onAnimationEnd(animation: Animator) {
                            super.onAnimationEnd(animation)
                            mDataBinding.fabAdd.isEnabled = false
                        }

                    })
                    .setDuration(400)
                    .scaleX(0f)
                    .scaleY(0f)
            }
        }
    }

    /**
     * 根据 下标 生成 TabLayout Tab View
     * @param position
     */
    @SuppressLint("InflateParams")
    private fun getTabView(position: Int): View {
        val view = LayoutInflater.from(this).inflate(R.layout.layout_todo_indicator_main, null)
        val ivImage = view.findViewById<ImageView>(R.id.iv_image)
        val tvText = view.findViewById<TextView>(R.id.tv_text)

        when (position) {
            // 待办
            MAIN_NEED_TO_DO -> {
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

    /**
     * 显示 类型切换 Dialog
     */
    @SuppressLint("InflateParams")
    private fun showTypeSwitchDialog() {
        mTypeSwitchDialog?.run {
            if (!isShowing) {
                show()
            }
            return
        }

        val view = LayoutInflater.from(this).inflate(R.layout.dialog_todo_type_option, null)

        mTypeSwitchDialog = CommonDialog.Builder(this)
            .setContentView(view)
            .setGravity(
                Gravity.TOP or Gravity.END,
                0,
                getStatusBarHeight() + getDimensionById(R.dimen.title_bar_height).toInt()
            )
            .setCancelable(true)
            .show()

        // 全部
        ClickUtils.applySingleDebouncing(
            view.findViewById<View>(R.id.tv_all)
        ) {
            mTypeSwitchDialog?.hide()
            mTypeSparseArray.put(mViewModel!!.mCurPosition, TYPE_ALL)
            mDataBinding.includeTitleBar.tvTitle.text = getStringById(R.string.全部)
            EventBus.getDefault().post(FilterConditionEvent(
                pageType = mViewModel!!.mCurPosition,
                type = TYPE_ALL
            ))
        }

        // 工作
        ClickUtils.applySingleDebouncing(
            view.findViewById<View>(R.id.tv_work)
        ) {
            mTypeSwitchDialog?.hide()
            mTypeSparseArray.put(mViewModel!!.mCurPosition, TYPE_WORK)
            mDataBinding.includeTitleBar.tvTitle.text = getStringById(R.string.工作)
            EventBus.getDefault().post(FilterConditionEvent(
                pageType = mViewModel!!.mCurPosition,
                type = TYPE_WORK
            ))
        }

        // 学习
        ClickUtils.applySingleDebouncing(
            view.findViewById<View>(R.id.tv_study)
        ) {
            mTypeSwitchDialog?.hide()
            mTypeSparseArray.put(mViewModel!!.mCurPosition, TYPE_STUDY)
            mDataBinding.includeTitleBar.tvTitle.text = getStringById(R.string.学习)
            EventBus.getDefault().post(FilterConditionEvent(
                pageType = mViewModel!!.mCurPosition,
                type = TYPE_STUDY
            ))
        }

        // 生活
        ClickUtils.applySingleDebouncing(
            view.findViewById<View>(R.id.tv_life)
        ) {
            mTypeSwitchDialog?.hide()
            mTypeSparseArray.put(mViewModel!!.mCurPosition, TYPE_LIFE)
            mDataBinding.includeTitleBar.tvTitle.text = getStringById(R.string.生活)
            EventBus.getDefault().post(FilterConditionEvent(
                pageType = mViewModel!!.mCurPosition,
                type = TYPE_LIFE
            ))
        }
    }

}

/**
 * 主页 ViewPager Fragment 适配器
 */
internal class MainFragmentPagerAdapter(
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
    override fun createItem(position: Int): TodoBaseFragment<*, *> {
        val bundle = Bundle().apply {
            putInt(TYPE, TYPE_ALL)
            putInt(PRIORITY, PRIORITY_ALL)
            putInt(ORDER_BY, ORDER_BY_COMPLETE_DATE_ASC)
        }

        return when (position) {
            // 待办
            MAIN_NEED_TO_DO -> createTodoListFragment(bundle.apply {
                putInt(PAGE_TYPE, MAIN_NEED_TO_DO)
            })
            // 已完成
            MAIN_DONE -> createTodoListFragment(bundle.apply {
                putInt(PAGE_TYPE, MAIN_DONE)
            })
            else -> createEmptyFragment()
        }
    }

    /**
     * 获取 Fragment List Count
     * @return Fragment List Count
     */
    override fun getCount() = FRAGMENT_COUNT

}