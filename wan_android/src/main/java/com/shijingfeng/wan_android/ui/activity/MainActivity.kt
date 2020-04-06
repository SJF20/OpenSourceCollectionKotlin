package com.shijingfeng.wan_android.ui.activity

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.text.TextUtils
import android.util.SparseArray
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.ClickUtils
import com.blankj.utilcode.util.ConvertUtils
import com.blankj.utilcode.util.StringUtils
import com.google.android.material.tabs.TabLayout
import com.shijingfeng.base.base.adapter.CommonFragmentPagerAdapter
import com.shijingfeng.base.annotation.BindEventBus
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_MAIN
import com.shijingfeng.base.base.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.base.util.getColorById
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseActivity
import com.shijingfeng.wan_android.constant.RESULT_ARTICLE_COLLECTED_LIST
import com.shijingfeng.wan_android.constant.RESULT_COIN_RECORD
import com.shijingfeng.wan_android.constant.TAB_LAYOUT_VISIBILITY
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidMainBinding
import com.shijingfeng.wan_android.entity.event.CoinInfoEvent
import com.shijingfeng.wan_android.entity.event.UserInfoEvent
import com.shijingfeng.wan_android.entity.network.CoinInfoEntity
import com.shijingfeng.wan_android.source.local.getMainLocalSourceInstance
import com.shijingfeng.wan_android.source.network.getMainNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.getMainRepositoryInstance
import com.shijingfeng.wan_android.utils.UserUtil
import com.shijingfeng.wan_android.view_model.MainViewModel
import kotlinx.android.synthetic.main.activity_wan_android_main.*
import kotlinx.android.synthetic.main.layout_wan_android_indicator_main_classify.*
import kotlinx.android.synthetic.main.layout_wan_android_indicator_main_home.*
import kotlinx.android.synthetic.main.layout_wan_android_indicator_main_official_account.*
import kotlinx.android.synthetic.main.layout_wan_android_indicator_main_project.*
import kotlinx.android.synthetic.main.layout_wan_android_indicator_main_square.*
import kotlinx.android.synthetic.main.layout_wan_android_main_activity_drawer.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/** 首页  */
private const val MAIN_HOME = 0

/** 分类  */
private const val MAIN_CLASSIFY = 1

/** 公众号  */
private const val MAIN_OFFICIAL_ACCOUNT = 2

/** 广场  */
private const val MAIN_SQUARE = 3

/** 项目  */
private const val MAIN_PROJECT = 4

/**
 * Function: 首页 Activity
 * Date: 2020/2/11 13:55
 * Description:
 * @author ShiJingFeng
 */
@BindEventBus
@Route(path = ACTIVITY_WAN_ANDROID_MAIN)
internal class MainActivity : WanAndroidBaseActivity<ActivityWanAndroidMainBinding, MainViewModel>() {

    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.activity_wan_android_main

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel(): MainViewModel? {
        val mainRepository = getMainRepositoryInstance(
            localSource = getMainLocalSourceInstance(),
            networkSource = getMainNetworkSourceInstance()
        )
        val factory = createCommonViewModelFactory(
            repository = mainRepository
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
    @SuppressLint("SetTextI18n")
    override fun initData() {
        super.initData()
        vp_content.offscreenPageLimit = 1
        vp_content.adapter = CommonFragmentPagerAdapter(
            supportFragmentManager,
            mViewModel?.getFragmentList(),
            true
        )
        tl_tabs.run {
            //首页
            addTab(newTab(), true)
            //分类
            addTab(newTab())
            //公众号
            addTab(newTab())
            //广场
            addTab(newTab())
            //项目
            addTab(newTab())
            setupWithViewPager(vp_content)
            //首页
            getTabAt(MAIN_HOME)?.customView = getTabView(MAIN_HOME)
            //分类
            getTabAt(MAIN_CLASSIFY)?.customView = getTabView(MAIN_CLASSIFY)
            //公众号
            getTabAt(MAIN_OFFICIAL_ACCOUNT)?.customView = getTabView(MAIN_OFFICIAL_ACCOUNT)
            //广场
            getTabAt(MAIN_SQUARE)?.customView = getTabView(MAIN_SQUARE)
            //项目
            getTabAt(MAIN_PROJECT)?.customView = getTabView(MAIN_PROJECT)
        }
        UserUtil.getUserInfo()?.run {
            //如果登录则设置数据
            tv_name.text = if (TextUtils.isEmpty(nickname)) username else nickname
            tv_id.text = identity
        }
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
        //打开DrawerLayout
        ClickUtils.applySingleDebouncing(iv_menu) {
            dwl_drawer.openDrawer(GravityCompat.START)
        }
        //TabLayout Item 事件
        tl_tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    //首页
                    MAIN_HOME -> {
                        tv_indicator_home.setTextColor(getColorById(R.color.red))
                        iv_indicator_home.setColorFilter(getColorById(R.color.red))
                    }
                    //分类
                    MAIN_CLASSIFY -> {
                        tv_indicator_classify.setTextColor(getColorById(R.color.red))
                        iv_indicator_classify.setColorFilter(getColorById(R.color.red))
                    }
                    //公众号
                    MAIN_OFFICIAL_ACCOUNT -> {
                        tv_indicator_official_account.setTextColor(getColorById(R.color.red))
                        iv_indicator_official_account.setColorFilter(getColorById(R.color.red))
                    }
                    //广场
                    MAIN_SQUARE -> {
                        tv_indicator_square.setTextColor(getColorById(R.color.red))
                        iv_indicator_square.setColorFilter(getColorById(R.color.red))
                    }
                    //项目
                    MAIN_PROJECT -> {
                        tv_indicator_project.setTextColor(getColorById(R.color.red))
                        iv_indicator_project.setColorFilter(getColorById(R.color.red))
                    }
                    else -> {}
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                when (tab.position) {
                    //首页
                    MAIN_HOME -> {
                        tv_indicator_home.setTextColor(getColorById(R.color.grey))
                        iv_indicator_home.setColorFilter(getColorById(R.color.grey))
                    }
                    //分类
                    MAIN_CLASSIFY -> {
                        tv_indicator_classify.setTextColor(getColorById(R.color.grey))
                        iv_indicator_classify.setColorFilter(getColorById(R.color.grey))
                    }
                    //公众号
                    MAIN_OFFICIAL_ACCOUNT -> {
                        tv_indicator_official_account.setTextColor(getColorById(R.color.grey))
                        iv_indicator_official_account.setColorFilter(getColorById(R.color.grey))
                    }
                    //广场
                    MAIN_SQUARE -> {
                        tv_indicator_square.setTextColor(getColorById(R.color.grey))
                        iv_indicator_square.setColorFilter(getColorById(R.color.grey))
                    }
                    //项目
                    MAIN_PROJECT -> {
                        tv_indicator_project.setTextColor(getColorById(R.color.grey))
                        iv_indicator_project.setColorFilter(getColorById(R.color.grey))
                    }
                    else -> {}
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab) {}

        })
        //ViewPager Item 事件
        vp_content.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                mViewModel?.mCurrentFragment = mViewModel?.getFragmentList()?.get(position)

                when (position) {
                    // 首页
                    MAIN_HOME -> tv_title.text = getStringById(R.string.首页)
                    // 分类
                    MAIN_CLASSIFY -> tv_title.text = getStringById(R.string.分类)
                    // 公众号
                    MAIN_OFFICIAL_ACCOUNT -> tv_title.text = getStringById(R.string.公众号)
                    // 广场
                    MAIN_SQUARE -> tv_title.text = getStringById(R.string.广场)
                    // 项目
                    MAIN_PROJECT -> tv_title.text = getStringById(R.string.项目)
                    else -> {}
                }
            }
        })
        //DrawerLayout 事件
        dwl_drawer.addDrawerListener(object : DrawerLayout.SimpleDrawerListener() {

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                super.onDrawerSlide(drawerView, slideOffset)
                iv_menu.rotation = slideOffset * 180
            }

        })
        mViewModel?.getFragmentList()?.forEach { fragment ->
            fragment.setOnItemEventListener { _, _, visibility, flag ->
                when (flag) {
                    //TabLayout 设置可见性
                    TAB_LAYOUT_VISIBILITY -> setTabLayoutVisibility(visibility)
                }
            }
        }
    }

    /**
     * 初始化 LiveData Observer
     */
    override fun initObserver() {
        super.initObserver()
        //设置积分数据
        mViewModel?.mUpdateCoinInfoEvent?.observe(this, Observer<CoinInfoEntity?> { coinInfo ->
            if (coinInfo != null) {
                tv_level.text = coinInfo.level.toString()
                tv_rank.text = coinInfo.rank.toString()
                tv_coin_quantity.text = coinInfo.coinCount.toString()
            }
        })
        // 显示 退出登录确认对话框
        mViewModel?.mShowLogoutDialogEvent?.observe(this, Observer {
            showLogoutDialog()
        })
    }

    /**
     * 是否自定义设置状态栏
     *
     * @return true 自定义设置  false 默认设置
     */
    override fun isSetCustomStatusBar() = true

    /**
     * 设置 TabLayout 和 置顶按钮 的可见性
     * @param visibility 可见性
     */
    private fun setTabLayoutVisibility(visibility: Int) {
        if (ll_tabs.tag == null) {
            ll_tabs.tag = View.VISIBLE
        }
        if (visibility == View.VISIBLE) {
            //设置为可见
            if (ll_tabs.tag as Int != View.VISIBLE) {
                ll_tabs.tag = View.VISIBLE
                ll_tabs
                    .animate()
                    .setDuration(400)
                    .translationY(0f)
                fab_to_top
                    .animate()
                    .setListener(object : AnimatorListenerAdapter() {

                        override fun onAnimationStart(animation: Animator) {
                            super.onAnimationStart(animation)
                            fab_to_top.isEnabled = false
                        }

                        override fun onAnimationEnd(animation: Animator) {
                            super.onAnimationEnd(animation)
                            fab_to_top.isEnabled = true
                        }

                    })
                    .setDuration(400)
                    .scaleX(1.0f)
                    .scaleY(1.0f)
            }
        } else if (visibility == View.GONE) {
            //设置为不可见
            if (ll_tabs.tag as Int != View.GONE) {
                ll_tabs.tag = View.GONE
                ll_tabs
                    .animate()
                    .setDuration(400)
                    .translationY(ConvertUtils.dp2px(70f).toFloat())
                fab_to_top
                    .animate()
                    .setListener(object : AnimatorListenerAdapter() {

                        override fun onAnimationStart(animation: Animator) {
                            super.onAnimationStart(animation)
                            fab_to_top.isEnabled = false
                        }

                        override fun onAnimationEnd(animation: Animator) {
                            super.onAnimationEnd(animation)
                            fab_to_top.isEnabled = false
                        }

                    })
                    .setDuration(400)
                    .scaleX(0f)
                    .scaleY(0f)
            }
        }
    }

    /**
     * 获取要加载的 Tab CustomView
     * @param position 位置
     * @return View 要加载的View
     */
    @SuppressLint("InflateParams")
    private fun getTabView(position: Int) = when (position) {
        //首页
        MAIN_HOME -> LayoutInflater.from(this).inflate(R.layout.layout_wan_android_indicator_main_home, null)
        //分类
        MAIN_CLASSIFY -> LayoutInflater.from(this).inflate(R.layout.layout_wan_android_indicator_main_classify, null)
        //公众号
        MAIN_OFFICIAL_ACCOUNT -> LayoutInflater.from(this).inflate(R.layout.layout_wan_android_indicator_main_official_account, null)
        //广场
        MAIN_SQUARE -> LayoutInflater.from(this).inflate(R.layout.layout_wan_android_indicator_main_square, null)
        //项目
        MAIN_PROJECT -> LayoutInflater.from(this).inflate(R.layout.layout_wan_android_indicator_main_project, null)
        else -> { null }
    }

    /**
     * 显示 退出登录确认对话框
     */
    private fun showLogoutDialog() {
        AlertDialog.Builder(this)
            .setMessage(getStringById(R.string.是否退出登录))
            .setPositiveButton(getStringById(R.string.是)) { _, _ ->
                mViewModel?.logout()
            }
            .setNegativeButton(getStringById(R.string.否), null)
            .setCancelable(true)
            .show()
    }

    /**
     * Dispatch incoming result to the correct fragment.
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            //积分记录, 文章收藏列表
            RESULT_COIN_RECORD, RESULT_ARTICLE_COLLECTED_LIST -> {
                if (resultCode == Activity.RESULT_OK) {
                    dwl_drawer.closeDrawer(GravityCompat.START)
                }
            }
            else -> {
            }
        }
    }

    /**
     * 模拟按键 按下监听
     */
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_BACK -> {
                val size = ActivityUtils.getActivityList().size

                if (size <= 1) {
                    mViewModel?.doubleDownExitApp()
                } else {
                    finish()
                }
                return true
            }
            else -> {
            }
        }
        return super.onKeyDown(keyCode, event)
    }

    /**
     * 接收 用户信息 数据更新 Event
     * @param event 用户信息 数据更新 Event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getUserInfoEvent(event: UserInfoEvent) {
        val newUserInfoEntity = event.newUserInfoEntity
        val newNickname = newUserInfoEntity.nickname
        val newUsername = newUserInfoEntity.username
        val newId: String = newUserInfoEntity.identity

        if (!StringUtils.isEmpty(newNickname)) {
            if (tv_name.text.toString() !== newNickname) {
                tv_name.text = newNickname
            }
        } else {
            if (tv_name.text.toString() !== newUsername) {
                tv_name.text = newUsername
            }
        }
        if (tv_id.text.toString() !== newId) {
            tv_id.text = newId
        }
    }

    /**
     * 接收 积分信息 数据更新 Event
     * @param event 积分信息 数据更新 Event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getCoinInfoEvent(event: CoinInfoEvent) {
        val newCoinInfoEntity = event.newCoinInfoEntity
        val newLevel = newCoinInfoEntity.level.toString()
        val newRank = newCoinInfoEntity.rank.toString()
        val newCoinCount = newCoinInfoEntity.coinCount.toString()

        if (tv_level.text.toString() !== newLevel) {
            tv_level.text = newLevel
        }
        if (tv_rank.text.toString() !== newRank) {
            tv_rank.text = newRank
        }
        if (tv_coin_quantity.text.toString() !== newCoinCount) {
            tv_coin_quantity.text = newCoinCount
        }
    }

}