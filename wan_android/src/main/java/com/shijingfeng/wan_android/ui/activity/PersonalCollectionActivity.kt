package com.shijingfeng.wan_android.ui.activity

import android.annotation.SuppressLint
import android.util.SparseArray
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.material.tabs.TabLayout
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_PERSONAL_COLLECTION
import com.shijingfeng.base.base.adapter.CommonFragmentPagerAdapter
import com.shijingfeng.base.base.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.base.util.getColorById
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseActivity
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidPersonalCollectionBinding
import com.shijingfeng.wan_android.source.network.getPersonalCollectionNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.getPersonalCollectionRepositoryInstance
import com.shijingfeng.wan_android.view_model.PersonalCollectionViewModel
import kotlinx.android.synthetic.main.activity_wan_android_personal_collection.*
import kotlinx.android.synthetic.main.layout_wan_android_title_bar.view.*

/** 我的收藏 -> 文章 */
private const val PERSONAL_COLLECTION_ARTICLE = 0
/** 我的收藏 -> 网站 */
private const val PERSONAL_COLLECTION_WEBSITE = 1

/**
 * Function: 我的收藏 Activity
 * Date: 2020/3/22 20:56
 * Description:
 * @author ShiJingFeng
 */
@Route(path = ACTIVITY_WAN_ANDROID_PERSONAL_COLLECTION)
internal class PersonalCollectionActivity : WanAndroidBaseActivity<ActivityWanAndroidPersonalCollectionBinding, PersonalCollectionViewModel>() {

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
        vp_content.setCanScroll(false)
        vp_content.offscreenPageLimit = 1
        vp_content.adapter = CommonFragmentPagerAdapter(
            supportFragmentManager,
            mViewModel?.getFragmentList(),
            true
        )

        tl_tabs.run {
            // 文章
            addTab(newTab(), true)
            // 网站
            addTab(newTab())
            setupWithViewPager(vp_content)
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
        tl_tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

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
        vp_content.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                mViewModel?.mCurrentFragment = mViewModel?.getFragmentList()?.get(position)
            }

        })
        // 文章收藏列表 Fragment 回调
        mViewModel?.getFragmentList()?.get(PERSONAL_COLLECTION_ARTICLE)?.setOnItemEventListener { view, data, position, flag ->

        }
        // 网站收藏列表 Fragment 回调
        mViewModel?.getFragmentList()?.get(PERSONAL_COLLECTION_WEBSITE)?.setOnItemEventListener { view, data, position, flag ->

        }
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

}