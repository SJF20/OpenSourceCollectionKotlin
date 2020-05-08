package com.shijingfeng.wan_android.ui.fragment

import android.os.Bundle
import android.util.SparseArray
import android.util.TypedValue
import android.view.Gravity
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.material.tabs.TabLayout
import com.kingja.loadsir.core.LoadSir
import com.shijingfeng.base.arouter.FRAGMENT_WAN_ANDROID_PROJECT
import com.shijingfeng.base.base.adapter.BaseFragmentPagerAdapter
import com.shijingfeng.base.base.adapter.OnFragmentCreate
import com.shijingfeng.base.base.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.base.common.constant.LOAD
import com.shijingfeng.base.common.constant.LOAD_SERVICE_LOADING
import com.shijingfeng.base.util.getColorById
import com.shijingfeng.base.util.serialize
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseFragment
import com.shijingfeng.wan_android.constant.PROJECT_INDEX_STR
import com.shijingfeng.wan_android.databinding.FragmentWanAndroidProjectBinding
import com.shijingfeng.wan_android.entity.network.ProjectIndexEntity
import com.shijingfeng.wan_android.source.network.getProjectNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.getProjectRepositoryInstance
import com.shijingfeng.wan_android.view_model.ProjectViewModel

/**
 * 创建 ProjectFragment 实例
 */
internal fun createProjectFragment() = ProjectFragment()

/**
 * Function: 项目 Fragment
 * Date: 2020/2/12 17:11
 * Description:
 * @author ShiJingFeng
 */
@Route(path = FRAGMENT_WAN_ANDROID_PROJECT)
internal class ProjectFragment : WanAndroidBaseFragment<FragmentWanAndroidProjectBinding, ProjectViewModel>() {

    /** 项目 ViewPager Fragment 适配器 */
    private var mProjectFragmentPagerAdapter: ProjectFragmentPagerAdapter? = null

    /**
     * 获取视图ID
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.fragment_wan_android_project

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel(): ProjectViewModel? {
        val repository = getProjectRepositoryInstance(
            networkSource = getProjectNetworkSourceInstance()
        )
        val factory = createCommonViewModelFactory(
            repository = repository
        )

        return createViewModel(ProjectViewModel::class.java, factory)
    }

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.projectViewModel, mViewModel)
    }

    /**
     * 初始化数据
     */
    override fun initData() {
        super.initData()
        mLoadService = LoadSir.getDefault().register(mDataBinding.llContent, mViewModel?.mReloadListener)
        if (mViewModel == null || !mViewModel!!.mHasInited) {
            showCallback(LOAD_SERVICE_LOADING)
        }
    }

    /**
     * 初始化 LiveData Observer
     */
    override fun initObserver() {
        super.initObserver()
        mViewModel?.mProjectIndexDataChangeEvent?.observe(viewLifecycleOwner, Observer ObserverLabel@{ (type, _, _, _, _, _) ->
            when (type) {
                // 加载
                LOAD -> startLazyInit()
            }
        })
    }

    /**
     * 开始 懒初始化数据
     */
    private fun startLazyInit() {
        lazyInitData()
        lazyInitAction()
    }

    /**
     * 等获取完 索引数据 后初始化数据
     */
    private fun lazyInitData() {
        mProjectFragmentPagerAdapter = ProjectFragmentPagerAdapter(
            fragmentManager = childFragmentManager,
            mProjectIndexList = mViewModel?.mProjectIndexList ?: mutableListOf(),
            onFragmentCreate = { _, fragment ->
                fragment.setOnItemEventListener { view, data, visibility, flag ->
                    mOnItemEvent?.invoke(view, data, visibility, flag)
                }
            }
        )
        mDataBinding.vpContent.offscreenPageLimit = 1
        mDataBinding.vpContent.adapter = mProjectFragmentPagerAdapter

        mViewModel?.mProjectIndexList?.forEachIndexed { index, _ ->
            if (index == 0) {
                mDataBinding.tlTabs.addTab(mDataBinding.tlTabs.newTab(), true)
            } else {
                mDataBinding.tlTabs.addTab(mDataBinding.tlTabs.newTab())
            }
        }

        mDataBinding.tlTabs.setupWithViewPager(mDataBinding.vpContent)

        mViewModel?.mProjectIndexList?.forEachIndexed { index, officialAccountIndex ->
            mDataBinding.tlTabs.getTabAt(index)?.customView = getTabView(index, officialAccountIndex)
        }
    }

    /**
     * 等获取完 索引数据 后初始化事件
     */
    private fun lazyInitAction() {
        mDataBinding.tlTabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                (tab?.customView as TextView?)?.run {
                    setTextColor(getColorById(R.color.white))
                    setTextSize(TypedValue.COMPLEX_UNIT_SP, 18F)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                (tab?.customView as TextView?)?.run {
                    setTextColor(getColorById(R.color.grey))
                    setTextSize(TypedValue.COMPLEX_UNIT_SP, 16F)
                }
            }

            override fun onTabReselected(p0: TabLayout.Tab?) {}

        })
        //ViewPager Item 事件
        mDataBinding.vpContent.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}

            override fun onPageSelected(position: Int) {
                mViewModel?.mCurrentFragmentPosition = position
            }
        })
    }

    /**
     * 获取要加载的 Tab CustomView
     * @param projectIndex 公众号 索引数据 Item
     * @param position 位置
     * @return View 要加载的View
     */
    private fun getTabView(position: Int, projectIndex: ProjectIndexEntity) = TextView(activity).apply {
        gravity = Gravity.CENTER
        text = projectIndex.name

        if (position == 0) {
            setTextColor(getColorById(R.color.white))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 18F)
        } else {
            setTextColor(getColorById(R.color.grey))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 16F)
        }
    }

    /**
     * 是否开启懒加载 (用于ViewPager)
     * @return true 开启  false 关闭  默认关闭
     */
    override fun isEnableLazyLoad() = true

    /**
     * 滑动到顶部
     */
    override fun scrollToTop() {
        super.scrollToTop()
        mProjectFragmentPagerAdapter?.getFragmentByPosition(mViewModel?.mCurrentFragmentPosition ?: 0)?.scrollToTop()
    }
}

/**
 * 项目 ViewPager Fragment 适配器
 */
internal class ProjectFragmentPagerAdapter(
    fragmentManager: FragmentManager,
    /** Fragment 创建回调 */
    onFragmentCreate: OnFragmentCreate<WanAndroidBaseFragment<*, *>>,
    /** 知识体系　一级 Item 实体类　*/
    private val mProjectIndexList: List<ProjectIndexEntity>
) : BaseFragmentPagerAdapter<WanAndroidBaseFragment<*, *>>(
    fragmentManager = fragmentManager,
    mBanDestroyed = false,
    mOnFragmentCreate = onFragmentCreate
) {

    /**
     * 创建 Fragment Item
     * @param position 下标
     * @return 创建好的 Fragment
     */
    override fun createItem(position: Int) = createProjectChildFragment(Bundle().apply {
        putString(PROJECT_INDEX_STR, serialize(mProjectIndexList[position]))
    })

    /**
     * Return the number of views available.
     */
    override fun getCount() = mProjectIndexList.size
}