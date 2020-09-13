package com.shijingfeng.wan_android.ui.activity

import android.annotation.SuppressLint
import android.util.SparseArray
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.material.tabs.TabLayout
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_PERSONAL_COLLECTION
import com.shijingfeng.base.base.adapter.BaseFragmentPagerAdapter
import com.shijingfeng.base.base.adapter.OnFragmentCreate
import com.shijingfeng.base.base.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.base.util.getColorById
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.skin_changer.constant.BACK_GROUND
import com.shijingfeng.skin_changer.entity.SkinAttribute
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseActivity
import com.shijingfeng.wan_android.base.WanAndroidBaseFragment
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidPersonalCollectionBinding
import com.shijingfeng.wan_android.source.network.getPersonalCollectionNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.getPersonalCollectionRepositoryInstance
import com.shijingfeng.wan_android.ui.fragment.*
import com.shijingfeng.wan_android.view_model.PersonalCollectionViewModel

/** 我的收藏 -> 文章 */
internal const val PERSONAL_COLLECTION_ARTICLE = 0
/** 我的收藏 -> 网站 */
internal const val PERSONAL_COLLECTION_WEBSITE = 1

/** Fragment 数量 */
private const val FRAGMENT_COUNT = 2

/**
 * Function: 我的收藏 Activity
 * Date: 2020/3/22 20:56
 * Description:
 * @author ShiJingFeng
 */
@Route(path = ACTIVITY_WAN_ANDROID_PERSONAL_COLLECTION)
internal class PersonalCollectionActivity : WanAndroidBaseActivity<ActivityWanAndroidPersonalCollectionBinding, PersonalCollectionViewModel>() {

    /** 我的收藏 ViewPager Fragment 适配器 */
    private var mPersonalCollectionFragmentPagerAdapter: PersonalCollectionFragmentPagerAdapter? = null

    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.activity_wan_android_personal_collection

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel(): PersonalCollectionViewModel? {
        val articleCollectedListRepository = getPersonalCollectionRepositoryInstance(
            networkSource = getPersonalCollectionNetworkSourceInstance()
        )
        val factory = createCommonViewModelFactory(
            repository = articleCollectedListRepository
        )

        return createViewModel(PersonalCollectionViewModel::class.java, factory)
    }

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.personalCollectionViewModel, mViewModel)
    }

    /**
     * 初始化数据
     */
    override fun initData() {
        super.initData()
        mViewModel?.mCurPosition = PERSONAL_COLLECTION_ARTICLE

        mPersonalCollectionFragmentPagerAdapter = PersonalCollectionFragmentPagerAdapter(
            fragmentManager = supportFragmentManager,
            onFragmentCreate = { _, _ -> }
        )
        mDataBinding.vpContent.run {
            canScroll = false
            offscreenPageLimit = 1
            adapter = mPersonalCollectionFragmentPagerAdapter
        }

        mDataBinding.tlTabs.run {
            // 文章
            addTab(newTab(), true)
            // 网站
            addTab(newTab())
            setupWithViewPager(mDataBinding.vpContent)
            // 文章
            getTabAt(PERSONAL_COLLECTION_ARTICLE)?.customView = getTabView(PERSONAL_COLLECTION_ARTICLE)
            // 网站
            getTabAt(PERSONAL_COLLECTION_WEBSITE)?.customView = getTabView(PERSONAL_COLLECTION_WEBSITE)
        }
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
        //TabLayout Item 事件
        mDataBinding.tlTabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab) {
                (tab.customView as? TextView)?.run {
                    setTextColor(getColorById(R.color.white))
                    setTextSize(TypedValue.COMPLEX_UNIT_SP, 18F)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                (tab.customView as TextView?)?.run {
                    setTextColor(getColorById(R.color.grey))
                    setTextSize(TypedValue.COMPLEX_UNIT_SP, 16F)
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab) {}

        })
        //ViewPager Item 事件
        mDataBinding.vpContent.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                mViewModel?.mCurPosition = position
            }

        })
    }

    /**
     * 获取要加载的 Tab CustomView
     * @param position 位置
     * @return View 要加载的View
     */
    @SuppressLint("InflateParams")
    private fun getTabView(position: Int): View? {
        val textView = LayoutInflater.from(this).inflate(R.layout.layout_wan_android_indicator_collection, null) as? TextView

        when (position) {
            // 文章
            PERSONAL_COLLECTION_ARTICLE -> {
                textView?.run {
                    text = getStringById(R.string.文章收藏)
                    setTextColor(getColorById(R.color.white))
                    setTextSize(TypedValue.COMPLEX_UNIT_SP, 18F)
                }
            }
            // 网站
            PERSONAL_COLLECTION_WEBSITE -> {
                textView?.run {
                    text = getStringById(R.string.网站收藏)
                    setTextColor(getColorById(R.color.grey))
                    setTextSize(TypedValue.COMPLEX_UNIT_SP, 16F)
                }
            }
            else -> {}
        }

        return textView
    }

    /**
     * 获取资源 (用于切换主题的资源)
     */
    override fun getResource() = mutableMapOf<View, List<SkinAttribute>>().apply {
        this[mDataBinding.flTitleBar] = listOf(
            SkinAttribute(
                name = BACK_GROUND,
                data = getStringById(R.string.color_id_wan_android_theme_color)
            )
        )
    }

}

/**
 * 我的收藏 ViewPager Fragment 适配器
 */
internal class PersonalCollectionFragmentPagerAdapter(
    fragmentManager: FragmentManager,
    onFragmentCreate: OnFragmentCreate<WanAndroidBaseFragment<*, *>>
) : BaseFragmentPagerAdapter<WanAndroidBaseFragment<*, *>>(
    fragmentManager = fragmentManager,
    mBanDestroyed = true,
    mOnFragmentCreate = onFragmentCreate
) {

    /**
     * 创建 Fragment Item
     * @param position 下标
     * @return 创建好的 Fragment
     */
    override fun createItem(position: Int): WanAndroidBaseFragment<*, *> {
        return when (position) {
            // 我的收藏 -> 收藏文章列表 Fragment
            PERSONAL_COLLECTION_ARTICLE -> createPersonalCollectionArticleFragment()
            // 我的收藏 -> 收藏网站列表 Fragment
            PERSONAL_COLLECTION_WEBSITE -> createPersonalCollectionWebsiteFragment()
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