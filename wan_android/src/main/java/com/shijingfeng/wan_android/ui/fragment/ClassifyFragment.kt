package com.shijingfeng.wan_android.ui.fragment

import android.os.Handler
import android.util.SparseArray
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.shijingfeng.base.arouter.FRAGMENT_WAN_ANDROID_CLASSIFY
import com.shijingfeng.base.base.adapter.BaseFragmentPagerAdapter
import com.shijingfeng.base.base.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.base.util.getColorById
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseFragment
import com.shijingfeng.wan_android.databinding.FragmentWanAndroidClassifyBinding
import com.shijingfeng.wan_android.view_model.ClassifyViewModel
import kotlinx.android.synthetic.main.activity_wan_android_main.*

/**
 * 创建 ClassifyFragment 实例
 */
internal fun createClassifyFragment() = ClassifyFragment()

/** 知识体系  */
private const val CLASSIFY_KNOWLEDGE = 0
/** 分类导航  */
private const val CLASSIFY_NAVIGATION = 1

/** Fragment 数量 */
private const val FRAGMENT_COUNT = 2

/**
 * Function: 分类 Fragment
 * Date: 2020/2/12 16:52
 * Description:
 * @author ShiJingFeng
 */
@Route(path = FRAGMENT_WAN_ANDROID_CLASSIFY)
internal class ClassifyFragment : WanAndroidBaseFragment<FragmentWanAndroidClassifyBinding, ClassifyViewModel>() {

    /** 分类 ViewPager Fragment 适配器 */
    private var mClassifyFragmentPagerAdapter: ClassifyFragmentPagerAdapter? = null

    /** 当前 ViewPager 下标  */
    var mCurPosition = CLASSIFY_KNOWLEDGE

    /**
     * 获取视图ID
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.fragment_wan_android_classify

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel() = createViewModel(ClassifyViewModel::class.java, createCommonViewModelFactory())

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.classifyViewModel, mViewModel)
    }

    /**
     * 初始化数据
     */
    override fun initData() {
        super.initData()
        mCurPosition = CLASSIFY_KNOWLEDGE
        mClassifyFragmentPagerAdapter = ClassifyFragmentPagerAdapter(childFragmentManager)
        vp_content.offscreenPageLimit = 1
        vp_content.adapter = mClassifyFragmentPagerAdapter

        tl_tabs.run {
            //知识体系
            addTab(newTab(), true)
            //导航分类
            addTab(newTab())

            /// TabLayout 和 ViewPager 协同
            setupWithViewPager(vp_content)

            //知识体系
            getTabAt(CLASSIFY_KNOWLEDGE)?.customView = getTabView(CLASSIFY_KNOWLEDGE)
            //导航分类
            getTabAt(CLASSIFY_NAVIGATION)?.customView = getTabView(CLASSIFY_NAVIGATION)
        }
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
        //TabLayout Item 事件
        tl_tabs.addOnTabSelectedListener(object : OnTabSelectedListener {

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

            override fun onTabReselected(tab: TabLayout.Tab?) {}

        })
        // ViewPager Item 事件
        vp_content.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}

            override fun onPageSelected(position: Int) {
                mCurPosition = position
            }
        })
        // Fragment事件
        // 延迟 500 毫秒, 防止 getFragmentByPosition() 获取 Fragment 为 null
        Handler().postDelayed({
            //知识体系 Fragment 事件
            mClassifyFragmentPagerAdapter?.getFragmentByPosition(CLASSIFY_KNOWLEDGE)?.setOnItemEventListener { view, data, position, flag ->
                when (flag) {
                    else -> mOnItemEvent?.invoke(view, data, position, flag)
                }
            }
            //导航分类 Fragment 事件
            mClassifyFragmentPagerAdapter?.getFragmentByPosition(CLASSIFY_NAVIGATION)?.setOnItemEventListener { view, data, position, flag ->
                when (flag) {
                    else -> mOnItemEvent?.invoke(view, data, position, flag)
                }
            }
        }, 500)
    }

    /**
     * 获取要加载的 Tab CustomView
     * @param position 位置
     * @return View 要加载的View
     */
    private fun getTabView(position: Int): View? {
        if (activity == null) {
            return null
        }
        return when (position) {
            // 知识体系
            CLASSIFY_KNOWLEDGE -> LayoutInflater.from(activity).inflate(R.layout.layout_indicator_classify_knowledge, null)
            // 导航分类
            CLASSIFY_NAVIGATION -> LayoutInflater.from(activity).inflate(R.layout.layout_indicator_classify_navigation, null)
            else -> null
        }
    }

    /**
     * 是否开启懒加载 (用于ViewPager)
     *
     * @return true 开启  false 关闭  默认关闭
     */
    override fun isEnableLazyLoad() = true

    /**
     * 滑动到顶部
     */
    override fun scrollToTop() {
        super.scrollToTop()
        mClassifyFragmentPagerAdapter?.getFragmentByPosition(mCurPosition)?.scrollToTop()
    }
}

/**
 * 知识体系 ViewPager Fragment 适配器
 */
internal class ClassifyFragmentPagerAdapter(
    fragmentManager: FragmentManager
) : BaseFragmentPagerAdapter<WanAndroidBaseFragment<*, *>>(
    fragmentManager = fragmentManager,
    mBanDestroyed = true
) {

    /**
     * 创建 Fragment Item
     * @param position 下标
     * @return 创建好的 Fragment
     */
    override fun createItem(position: Int): WanAndroidBaseFragment<*, *> {
        return when (position) {
            // 知识体系
            CLASSIFY_KNOWLEDGE -> createKnowledgeClassifyFragment()
            // 导航分类
            CLASSIFY_NAVIGATION -> createNavigationClassifyFragment()
            // 空 Fragment
            else -> createEmptyFragment()
        }
    }

    /**
     * 获取 Fragment List Count
     * @return Fragment List Count
     */
    override fun getCount() = FRAGMENT_COUNT

}