package com.shijingfeng.wan_android.ui.fragment

import android.os.Bundle
import android.util.SparseArray
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.material.tabs.TabLayout
import com.kingja.loadsir.core.LoadSir
import com.shijingfeng.base.arouter.FRAGMENT_WAN_ANDROID_OFFICIAL_ACCOUNT
import com.shijingfeng.base.base.adapter.BaseFragmentPagerAdapter
import com.shijingfeng.base.base.adapter.OnFragmentCreate
import com.shijingfeng.base.mvvm.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.base.common.constant.LOAD
import com.shijingfeng.base.common.constant.LOAD_SERVICE_LOADING
import com.shijingfeng.base.common.global.runOnUiThread
import com.shijingfeng.base.util.getColorById
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.base.util.serialize
import com.shijingfeng.skin_changer.constant.BACK_GROUND
import com.shijingfeng.skin_changer.entity.SkinAttribute
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseFragment
import com.shijingfeng.wan_android.common.constant.OFFICIAL_ACCOUNT_INDEX_STR
import com.shijingfeng.wan_android.databinding.FragmentWanAndroidOfficialAccountBinding
import com.shijingfeng.wan_android.entity.OfficialAccountIndexEntity
import com.shijingfeng.wan_android.source.network.getOfficialAccountNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.getOfficialAccountRepositoryInstance
import com.shijingfeng.wan_android.view_model.OfficialAccountViewModel

/**
 * 创建 OfficialAccountFragment 实例
 */
internal fun createOfficialAccountFragment() = OfficialAccountFragment()

/**
 * Function: 公众号 Fragment
 * Date: 2020/2/12 17:02
 * Description:
 * @author ShiJingFeng
 */
@Route(path = FRAGMENT_WAN_ANDROID_OFFICIAL_ACCOUNT)
internal class OfficialAccountFragment : WanAndroidBaseFragment<FragmentWanAndroidOfficialAccountBinding, OfficialAccountViewModel>() {

    /** 公众号 ViewPager Fragment 适配器 */
    private var mOfficialAccountFragmentPagerAdapter: OfficialAccountFragmentPagerAdapter? = null

    /**
     * 获取视图ID
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.fragment_wan_android_official_account

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel(): OfficialAccountViewModel? {
        val repository = getOfficialAccountRepositoryInstance(
            networkSource = getOfficialAccountNetworkSourceInstance()
        )
        val factory =
            createCommonViewModelFactory(
                repository = repository
            )

        return createViewModel(OfficialAccountViewModel::class.java, factory)
    }

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.officialAccountViewModel, mViewModel)
    }

    /**
     * 初始化数据
     */
    override fun initData() {
        super.initData()
        mLoadService = LoadSir.getDefault().register(mDataBinding.llContent, mViewModel?.mReloadListener)
        if (mViewModel == null || !mViewModel!!.mHasInitialized) {
            showCallback(LOAD_SERVICE_LOADING)
        }
    }

    /**
     * 初始化 LiveData Observer
     */
    override fun initObserver() {
        super.initObserver()
        mViewModel?.mOfficialAccountIndexDataChangeEvent?.observe(viewLifecycleOwner, Observer ObserverLabel@{ (type, _, _, _, _, _) ->
            when (type) {
                // 加载
                LOAD -> startLazyInit()
            }
        })
    }

    /**
     * 开始 懒初始化数据 (目的: TabLayout中的 Tab是可变的，所以需要从服务器获得Tab列表后，再进行初始化)
     */
    private fun startLazyInit() {
        lazyInitData()
        lazyInitAction()
    }

    /**
     * 等获取完 索引数据 后初始化数据
     */
    private fun lazyInitData() {
        mOfficialAccountFragmentPagerAdapter = OfficialAccountFragmentPagerAdapter(
            fragmentManager = childFragmentManager,
            mOfficialAccountIndexList = mViewModel?.mOfficialAccountIndexList ?: mutableListOf(),
            onFragmentCreate = { _, fragment ->
                fragment.setOnItemEventListener { view, data, visibility, flag ->
                    mOnItemEvent?.invoke(view, data, visibility, flag)
                }
            }
        )
        mDataBinding.vpContent.offscreenPageLimit = 1
        mDataBinding.vpContent.adapter = mOfficialAccountFragmentPagerAdapter

        mViewModel?.mOfficialAccountIndexList?.forEachIndexed { index, _ ->
            if (index == 0) {
                mDataBinding.tlTabs.addTab(mDataBinding.tlTabs.newTab(), true)
            } else {
                mDataBinding.tlTabs.addTab(mDataBinding.tlTabs.newTab())
            }
        }

        mDataBinding.tlTabs.setupWithViewPager(mDataBinding.vpContent)

        mViewModel?.mOfficialAccountIndexList?.forEachIndexed { index, officialAccountIndex ->
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
        // Fragment事件
        // 延迟 500 毫秒, 防止 getFragmentByPosition() 获取 Fragment 为 null
        runOnUiThread(500) {
            val size = mViewModel?.mOfficialAccountIndexList?.size ?: 0

            for (index in 0 until size) {
                mOfficialAccountFragmentPagerAdapter?.getFragmentByPosition(index)?.setOnItemEventListener { view, data, visibility, flag ->
                    mOnItemEvent?.invoke(view, data, visibility, flag)
                }
            }
        }
    }

    /**
     * 获取要加载的 Tab CustomView
     * @param officialAccountIndex 公众号 索引数据 Item
     * @param position 位置
     * @return View 要加载的View
     */
    private fun getTabView(position: Int, officialAccountIndex: OfficialAccountIndexEntity) = TextView(activity).apply {
        gravity = Gravity.CENTER
        text = officialAccountIndex.name

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
     *
     * @return true 开启  false 关闭  默认关闭
     */
    override fun isEnableLazyLoad() = true

    /**
     * 滑动到顶部
     */
    override fun scrollToTop() {
        super.scrollToTop()
        val fragment = mOfficialAccountFragmentPagerAdapter?.getFragmentByPosition(mViewModel?.mCurrentFragmentPosition ?: 0)

        fragment?.scrollToTop()
    }

    /**
     * 获取资源 (用于切换主题的资源)
     */
    override fun getResource() = mutableMapOf<View, List<SkinAttribute>>().apply {
        this[mDataBinding.tlTabs] = listOf(
            SkinAttribute(
                name = BACK_GROUND,
                data = getStringById(R.string.color_id_wan_android_theme_color)
            )
        )
    }
}

/**
 * 公众号 ViewPager Fragment 适配器
 */
internal class OfficialAccountFragmentPagerAdapter(
    fragmentManager: FragmentManager,
    /** Fragment 创建回调 */
    onFragmentCreate: OnFragmentCreate<WanAndroidBaseFragment<*, *>>,
    /** 知识体系　一级 Item 实体类　*/
    private val mOfficialAccountIndexList: List<OfficialAccountIndexEntity>
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
    override fun createItem(position: Int) = createOfficialAccountChildFragment(Bundle().apply {
        putString(OFFICIAL_ACCOUNT_INDEX_STR, serialize(mOfficialAccountIndexList[position]))
    })

    /**
     * 获取 Fragment List Count
     * @return Fragment List Count
     */
    override fun getCount() = mOfficialAccountIndexList.size
}