package com.shijingfeng.wan_android.ui.activity

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.res.ColorStateList
import android.text.TextUtils
import android.util.SparseArray
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.ClickUtils
import com.blankj.utilcode.util.ConvertUtils
import com.blankj.utilcode.util.StringUtils
import com.google.android.material.tabs.TabLayout
import com.shijingfeng.base.base.adapter.BaseFragmentPagerAdapter
import com.shijingfeng.base.annotation.BindEventBus
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_MAIN
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_SEARCH
import com.shijingfeng.base.arouter.navigation
import com.shijingfeng.base.base.adapter.OnFragmentCreate
import com.shijingfeng.base.mvvm.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.base.util.getColorById
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.skin_changer.constant.BACK_GROUND
import com.shijingfeng.skin_changer.constant.BACK_GROUND_TINT
import com.shijingfeng.skin_changer.entity.SkinAttribute
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseActivity
import com.shijingfeng.wan_android.base.WanAndroidBaseFragment
import com.shijingfeng.wan_android.common.constant.RESULT_ARTICLE_COLLECTED_LIST
import com.shijingfeng.wan_android.common.constant.RESULT_COIN_RECORD
import com.shijingfeng.wan_android.common.constant.TAB_LAYOUT_VISIBILITY
import com.shijingfeng.wan_android.common.global.setThemeTextColor
import com.shijingfeng.wan_android.common.global.setThemeTint
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidMainBinding
import com.shijingfeng.wan_android.entity.event.CoinInfoEvent
import com.shijingfeng.wan_android.entity.event.ThemeEvent
import com.shijingfeng.wan_android.entity.event.UserInfoEvent
import com.shijingfeng.wan_android.source.local.getMainLocalSourceInstance
import com.shijingfeng.wan_android.source.network.getMainNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.getMainRepositoryInstance
import com.shijingfeng.wan_android.ui.fragment.*
import com.shijingfeng.wan_android.ui.fragment.createClassifyFragment
import com.shijingfeng.wan_android.ui.fragment.createHomeFragment
import com.shijingfeng.wan_android.ui.fragment.createOfficialAccountFragment
import com.shijingfeng.wan_android.ui.fragment.createProjectFragment
import com.shijingfeng.wan_android.ui.fragment.createSquareFragment
import com.shijingfeng.wan_android.utils.CoinUtil
import com.shijingfeng.wan_android.utils.ThemeUtil
import com.shijingfeng.wan_android.utils.UserUtil
import com.shijingfeng.wan_android.view_model.MainViewModel
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/** 首页  */
internal const val MAIN_HOME = 0

/** 分类  */
internal const val MAIN_CLASSIFY = 1

/** 公众号  */
internal const val MAIN_OFFICIAL_ACCOUNT = 2

/** 广场  */
internal const val MAIN_SQUARE = 3

/** 项目  */
internal const val MAIN_PROJECT = 4

/** Fragment 数量 */
private const val FRAGMENT_COUNT = 5

/**
 * Function: 首页 Activity
 * Date: 2020/2/11 13:55
 * Description:
 * @author ShiJingFeng
 */
@BindEventBus
@Route(path = ACTIVITY_WAN_ANDROID_MAIN)
internal class MainActivity : WanAndroidBaseActivity<ActivityWanAndroidMainBinding, MainViewModel>() {

    /** 主页 ViewPager Fragment 适配器 */
    private var mMainFragmentPagerAdapter: MainFragmentPagerAdapter? = null

    /** 当前 TabLayout指示器 TextView */
    private lateinit var mCurIndicatorTextView: TextView
    /** 当前 TabLayout指示器 ImageView */
    private lateinit var mCurIndicatorImageView: ImageView

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
        val factory =
            createCommonViewModelFactory(
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
        mViewModel?.mCurPosition = MAIN_HOME

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
        mDataBinding.vpContent.offscreenPageLimit = 1
        mDataBinding.vpContent.adapter = mMainFragmentPagerAdapter

        mDataBinding.tlTabs.run {
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

            // TabLayout 和 ViewPager 协同
            setupWithViewPager(mDataBinding.vpContent)

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
        // 显示用户信息数据
        UserUtil.userInfo?.run {
            // 昵称 或 用户名
            mDataBinding.includeDrawer.tvName.text = if (TextUtils.isEmpty(nickname)) username else nickname
            // ID
            mDataBinding.includeDrawer.tvId.text = identity
        }
        // 显示积分信息数据
        CoinUtil.coinInfo?.run {
            // 等级
            mDataBinding.includeDrawer.tvLevel.text = level.toString()
            // 排名
            mDataBinding.includeDrawer.tvRank.text = rank.toString()
            // 积分数量
            mDataBinding.includeDrawer.tvCoinQuantity.text = coinCount.toString()
            // 显示注销登录
            mDataBinding.includeDrawer.llLogout.visibility = VISIBLE
        }

        registerLoadingView(
            hintText = getStringById(R.string.退出登录中)
        )
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
        // 打开DrawerLayout
        ClickUtils.applySingleDebouncing(mDataBinding.ivMenu) {
            mDataBinding.dwlDrawer.openDrawer(GravityCompat.START)
        }
        // 搜索
        ClickUtils.applySingleDebouncing(mDataBinding.ivSearch) {
            navigation(
                activity = this,
                path = ACTIVITY_WAN_ANDROID_SEARCH
            )
        }
        // 置顶
        ClickUtils.applySingleDebouncing(mDataBinding.fabToTop) {
            mViewModel?.mCurPosition?.let { position ->
                mMainFragmentPagerAdapter?.getFragmentByPosition(position)?.scrollToTop()
            }
        }
        // TabLayout Item 事件
        mDataBinding.tlTabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab) {
                val view = tab.customView ?: return

                when (tab.position) {
                    //首页
                    MAIN_HOME -> {
                        mCurIndicatorTextView = view.findViewById(R.id.tv_indicator_home)
                        mCurIndicatorImageView = view.findViewById(R.id.iv_indicator_home)
                    }
                    //分类
                    MAIN_CLASSIFY -> {
                        mCurIndicatorTextView = view.findViewById(R.id.tv_indicator_classify)
                        mCurIndicatorImageView = view.findViewById(R.id.iv_indicator_classify)
                    }
                    //公众号
                    MAIN_OFFICIAL_ACCOUNT -> {
                        mCurIndicatorTextView = view.findViewById(R.id.tv_indicator_official_account)
                        mCurIndicatorImageView = view.findViewById(R.id.iv_indicator_official_account)
                    }
                    //广场
                    MAIN_SQUARE -> {
                        mCurIndicatorTextView = view.findViewById(R.id.tv_indicator_square)
                        mCurIndicatorImageView = view.findViewById(R.id.iv_indicator_square)
                    }
                    //项目
                    MAIN_PROJECT -> {
                        mCurIndicatorTextView = view.findViewById(R.id.tv_indicator_project)
                        mCurIndicatorImageView = view.findViewById(R.id.iv_indicator_project)
                    }
                    else -> {}
                }
                setThemeTextColor(mCurIndicatorTextView)
                setThemeTint(mCurIndicatorImageView)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                val view = tab.customView ?: return

                when (tab.position) {
                    //首页
                    MAIN_HOME -> {
                        view.findViewById<TextView>(R.id.tv_indicator_home).setTextColor(getColorById(R.color.grey))
                        view.findViewById<ImageView>(R.id.iv_indicator_home).imageTintList = ColorStateList.valueOf(getColorById(R.color.grey))
                    }
                    //分类
                    MAIN_CLASSIFY -> {
                        view.findViewById<TextView>(R.id.tv_indicator_classify).setTextColor(getColorById(R.color.grey))
                        view.findViewById<ImageView>(R.id.iv_indicator_classify).imageTintList = ColorStateList.valueOf(getColorById(R.color.grey))
                    }
                    //公众号
                    MAIN_OFFICIAL_ACCOUNT -> {
                        view.findViewById<TextView>(R.id.tv_indicator_official_account).setTextColor(getColorById(R.color.grey))
                        view.findViewById<ImageView>(R.id.iv_indicator_official_account).imageTintList = ColorStateList.valueOf(getColorById(R.color.grey))
                    }
                    //广场
                    MAIN_SQUARE -> {
                        view.findViewById<TextView>(R.id.tv_indicator_square).setTextColor(getColorById(R.color.grey))
                        view.findViewById<ImageView>(R.id.iv_indicator_square).imageTintList = ColorStateList.valueOf(getColorById(R.color.grey))
                    }
                    //项目
                    MAIN_PROJECT -> {
                        view.findViewById<TextView>(R.id.tv_indicator_project).setTextColor(getColorById(R.color.grey))
                        view.findViewById<ImageView>(R.id.iv_indicator_project).imageTintList = ColorStateList.valueOf(getColorById(R.color.grey))
                    }
                    else -> {}
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab) {}

        })
        // ViewPager Item 事件
        mDataBinding.vpContent.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}

            override fun onPageSelected(position: Int) {
                mViewModel?.mCurPosition = position

                when (position) {
                    // 首页
                    MAIN_HOME -> mDataBinding.tvTitle.text = getStringById(R.string.首页)
                    // 分类
                    MAIN_CLASSIFY -> mDataBinding.tvTitle.text = getStringById(R.string.分类)
                    // 公众号
                    MAIN_OFFICIAL_ACCOUNT -> mDataBinding.tvTitle.text = getStringById(R.string.公众号)
                    // 广场
                    MAIN_SQUARE -> mDataBinding.tvTitle.text = getStringById(R.string.广场)
                    // 项目
                    MAIN_PROJECT -> mDataBinding.tvTitle.text = getStringById(R.string.项目)
                    else -> {}
                }
            }
        })
        // DrawerLayout 事件
        mDataBinding.dwlDrawer.addDrawerListener(object : DrawerLayout.SimpleDrawerListener() {

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                super.onDrawerSlide(drawerView, slideOffset)
                mDataBinding.ivMenu.rotation = slideOffset * 180
            }

        })
    }

    /**
     * 初始化 LiveData Observer
     */
    override fun initObserver() {
        super.initObserver()
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
                mDataBinding.fabToTop
                    .animate()
                    .setListener(object : AnimatorListenerAdapter() {

                        override fun onAnimationStart(animation: Animator) {
                            super.onAnimationStart(animation)
                            mDataBinding.fabToTop.isEnabled = false
                        }

                        override fun onAnimationEnd(animation: Animator) {
                            super.onAnimationEnd(animation)
                            mDataBinding.fabToTop.isEnabled = true
                        }

                    })
                    .setDuration(400)
                    .scaleX(1.0f)
                    .scaleY(1.0f)
            }
        } else if (visibility == GONE) {
            //设置为不可见
            if (mDataBinding.llTabs.tag as Int != GONE) {
                mDataBinding.llTabs.tag = GONE
                mDataBinding.llTabs
                    .animate()
                    .setDuration(400)
                    .translationY(ConvertUtils.dp2px(70f).toFloat())
                mDataBinding.fabToTop
                    .animate()
                    .setListener(object : AnimatorListenerAdapter() {

                        override fun onAnimationStart(animation: Animator) {
                            super.onAnimationStart(animation)
                            mDataBinding.fabToTop.isEnabled = false
                        }

                        override fun onAnimationEnd(animation: Animator) {
                            super.onAnimationEnd(animation)
                            mDataBinding.fabToTop.isEnabled = false
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
        //首页 (默认选中)
        MAIN_HOME -> {
            val mainHomeView = LayoutInflater.from(this).inflate(R.layout.layout_wan_android_indicator_main_home, null)

            mCurIndicatorTextView = mainHomeView.findViewById(R.id.tv_indicator_home)
            mCurIndicatorImageView = mainHomeView.findViewById(R.id.iv_indicator_home)

            setThemeTextColor(mCurIndicatorTextView)
            setThemeTint(mCurIndicatorImageView)
            mainHomeView
        }
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
                    mDataBinding.dwlDrawer.closeDrawer(GravityCompat.START)
                }
            }
            else -> {}
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
        val userInfo = UserUtil.userInfo
        val nickname = userInfo?.nickname
        val username = userInfo?.username
        val id = userInfo?.getId()

        // 是否隐藏注销登录, 已注销登录则隐藏注销登录Item, 否则显示
        mDataBinding.includeDrawer.llLogout.visibility = if (userInfo == null) GONE else VISIBLE

        // 用户名
        if (!StringUtils.isEmpty(nickname)) {
            if (mDataBinding.includeDrawer.tvName.text.toString() != nickname) {
                mDataBinding.includeDrawer.tvName.text = nickname
            }
        } else if (!StringUtils.isEmpty(username)) {
            if (mDataBinding.includeDrawer.tvName.text.toString() != username) {
                mDataBinding.includeDrawer.tvName.text = username
            }
        } else {
            mDataBinding.includeDrawer.tvName.text = getStringById(R.string.三杠占位符)
        }

        // 用户ID
        if (mDataBinding.includeDrawer.tvId.text.toString() != id) {
            mDataBinding.includeDrawer.tvId.text = if (!TextUtils.isEmpty(id)) id else getStringById(R.string.三杠占位符)
        }
    }

    /**
     * 接收 积分信息 数据更新 Event
     * @param event 积分信息 数据更新 Event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getCoinInfoEvent(event: CoinInfoEvent) {
        val coinInfo = CoinUtil.coinInfo
        val level = coinInfo?.level?.toString()
        val rank = coinInfo?.rank?.toString()
        val coinCount = coinInfo?.coinCount?.toString()

        // 等级
        if (mDataBinding.includeDrawer.tvLevel.text.toString() != level) {
            mDataBinding.includeDrawer.tvLevel.text = if (!TextUtils.isEmpty(level)) level else getStringById(R.string.三杠占位符)
        }

        // 排名
        if (mDataBinding.includeDrawer.tvRank.text.toString() != rank) {
            mDataBinding.includeDrawer.tvRank.text = if (!TextUtils.isEmpty(rank)) rank else getStringById(R.string.三杠占位符)
        }

        // 积分数量
        if (mDataBinding.includeDrawer.tvCoinQuantity.text.toString() != coinCount) {
            mDataBinding.includeDrawer.tvCoinQuantity.text = if (!TextUtils.isEmpty(coinCount)) coinCount else "0"
        }
    }

    /**
     * 切换主题 Event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getThemeEvent(event: ThemeEvent) {
        val curThemeColorStateList = ColorStateList.valueOf(ThemeUtil.curThemeColor)

        if (this::mCurIndicatorTextView.isInitialized) {
            mCurIndicatorImageView.imageTintList = curThemeColorStateList
        }
        if (this::mCurIndicatorImageView.isInitialized) {
            mCurIndicatorTextView.setTextColor(curThemeColorStateList)
        }
    }

    /**
     * 获取资源 (用于切换主题的资源)
     */
    override fun getResource() = mutableMapOf<View, List<SkinAttribute>>().apply {
        this[mDataBinding.sbvStatusBar] = listOf(
            SkinAttribute(
                name = BACK_GROUND,
                data = getStringById(R.string.color_id_wan_android_theme_color)
            )
        )
        this[mDataBinding.llTitleBar] = listOf(
            SkinAttribute(
                name = BACK_GROUND,
                data = getStringById(R.string.color_id_wan_android_theme_color)
            )
        )
        this[mDataBinding.includeDrawer.llHeader] = listOf(
            SkinAttribute(
                name = BACK_GROUND,
                data = getStringById(R.string.color_id_wan_android_theme_color)
            )
        )
        this[mDataBinding.includeDrawer.sbvStatusBar] = listOf(
            SkinAttribute(
                name = BACK_GROUND,
                data = getStringById(R.string.color_id_wan_android_theme_color)
            )
        )
        this[mDataBinding.fabToTop] = listOf(
            SkinAttribute(
                name = BACK_GROUND_TINT,
                data = getStringById(R.string.color_id_wan_android_theme_color)
            )
        )
    }

}

/**
 * 主页 ViewPager Fragment 适配器
 */
internal class MainFragmentPagerAdapter(
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
            // 首页
            MAIN_HOME -> createHomeFragment()
            // 分类
            MAIN_CLASSIFY -> createClassifyFragment()
            // 公众号
            MAIN_OFFICIAL_ACCOUNT -> createOfficialAccountFragment()
            // 广场
            MAIN_SQUARE -> createSquareFragment()
            // 项目
            MAIN_PROJECT -> createProjectFragment()
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