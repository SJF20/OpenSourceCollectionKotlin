package com.shijingfeng.wan_android.ui.activity

import android.os.Bundle
import android.util.SparseArray
import android.util.TypedValue
import android.view.Gravity
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.material.tabs.TabLayout
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_KNOWLEDGE_CLASSIFY_DETAIL
import com.shijingfeng.base.base.adapter.BaseFragmentPagerAdapter
import com.shijingfeng.base.common.constant.CURRENT_POSITION
import com.shijingfeng.base.common.constant.EMPTY_OBJECT
import com.shijingfeng.base.util.deserialize
import com.shijingfeng.base.util.getColorById
import com.shijingfeng.base.util.serialize
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseActivity
import com.shijingfeng.wan_android.base.WanAndroidBaseFragment
import com.shijingfeng.wan_android.constant.KNOWLEDGE_CLASSIFY_CHILDREN_STR
import com.shijingfeng.wan_android.constant.KNOWLEDGE_CLASSIFY_STR
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidKnowledgeClassifyDetailBinding
import com.shijingfeng.wan_android.entity.network.KnowledgeClassifyChildren
import com.shijingfeng.wan_android.entity.network.KnowledgeClassifyEntity
import com.shijingfeng.wan_android.ui.fragment.createKnowledgeClassifyChildFragment
import com.shijingfeng.wan_android.view_model.KnowledgeClassifyDetailViewModel
import kotlinx.android.synthetic.main.activity_wan_android_knowledge_classify_detail.*
import kotlinx.android.synthetic.main.layout_wan_android_title_bar.*

/**
 * Function: 知识体系 详细数据 Activity
 * Date: 20-4-25 下午4:05
 * Description:
 * @author shijingfeng
 */
@Route(path = ACTIVITY_WAN_ANDROID_KNOWLEDGE_CLASSIFY_DETAIL)
internal class KnowledgeClassifyDetailActivity : WanAndroidBaseActivity<ActivityWanAndroidKnowledgeClassifyDetailBinding, KnowledgeClassifyDetailViewModel>() {

    /** 知识体系 ViewPager Fragment 适配器 */
    private var mKnowledgeClassifyDetailFragmentPagerAdapter: KnowledgeClassifyDetailFragmentPagerAdapter? = null

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel() = createViewModel(KnowledgeClassifyDetailViewModel::class.java)

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.knowledgeClassifyDetailViewModel, mViewModel)
    }

    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.activity_wan_android_knowledge_classify_detail

    /**
     * 初始化参数
     */
    override fun initParam() {
        super.initParam()
        mDataBundle?.run {
            val knowledgeClassifyStr = getString(KNOWLEDGE_CLASSIFY_STR, EMPTY_OBJECT)

            mViewModel?.mKnowledgeClassify = deserialize(knowledgeClassifyStr, KnowledgeClassifyEntity::class.java)
            mViewModel?.mCurrentFragmentPosition = getInt(CURRENT_POSITION, 0)
        }
    }

    /**
     * 初始化数据
     */
    override fun initData() {
        super.initData()
        tv_title.text = mViewModel?.mKnowledgeClassify?.name ?: ""
        mKnowledgeClassifyDetailFragmentPagerAdapter = KnowledgeClassifyDetailFragmentPagerAdapter(
            supportFragmentManager,
            mViewModel?.mKnowledgeClassify ?: KnowledgeClassifyEntity()
        )
        vp_content.offscreenPageLimit = 1
        vp_content.adapter = mKnowledgeClassifyDetailFragmentPagerAdapter

        mViewModel?.mKnowledgeClassify?.childrenList?.forEachIndexed { index, _ ->
            if (index == mViewModel?.mCurrentFragmentPosition) {
                tl_tabs.addTab(tl_tabs.newTab(), true)
            } else {
                tl_tabs.addTab(tl_tabs.newTab())
            }
        }
        tl_tabs.setupWithViewPager(vp_content)
        mViewModel?.mKnowledgeClassify?.childrenList?.forEachIndexed { index, knowledgeClassifyChildren ->
            tl_tabs.getTabAt(index)?.customView = getTabView(index, knowledgeClassifyChildren)
        }
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
        //TabLayout Item 事件
        tl_tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

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
        vp_content.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

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
        vp_content.currentItem = mViewModel?.mCurrentFragmentPosition ?: 0
    }

    /**
     * 获取要加载的 Tab CustomView
     * @param children 知识体系 二级 Item
     * @param position 位置
     * @return View 要加载的View
     */
    private fun getTabView(position: Int, children: KnowledgeClassifyChildren) = TextView(this).apply {
        gravity = Gravity.CENTER
        text = children.name

        if (position == mViewModel?.mCurrentFragmentPosition) {
            setTextColor(getColorById(R.color.white))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 18F)
        } else {
            setTextColor(getColorById(R.color.grey))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 16F)
        }
    }

}

/**
 * 知识体系 ViewPager Fragment 适配器
 */
internal class KnowledgeClassifyDetailFragmentPagerAdapter(
    fragmentManager: FragmentManager,
    /** 知识体系　一级 Item 实体类　*/
    private val mKnowledgeClassify: KnowledgeClassifyEntity
) : BaseFragmentPagerAdapter<WanAndroidBaseFragment<*, *>>(
    fragmentManager = fragmentManager,
    mBanDestroyed = false
) {

    /**
     * 创建 Fragment Item
     * @param position 下标
     * @return 创建好的 Fragment
     */
    override fun createItem(position: Int) = createKnowledgeClassifyChildFragment(Bundle().apply {
        putString(KNOWLEDGE_CLASSIFY_CHILDREN_STR, serialize(mKnowledgeClassify.childrenList[position]))
    })

    /**
     * 获取 Fragment List Count
     * @return Fragment List Count
     */
    override fun getCount() = mKnowledgeClassify.childrenList.size

}