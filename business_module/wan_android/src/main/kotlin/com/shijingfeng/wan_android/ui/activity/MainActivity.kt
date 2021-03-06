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
import com.shijingfeng.base.annotation.BindEventBus
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_MAIN
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_SEARCH
import com.shijingfeng.base.arouter.navigation
import com.shijingfeng.base.util.getColorById
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.base_adapter.BaseFragmentPagerAdapter
import com.shijingfeng.base_adapter.kotlin_extension.onFragmentCreate
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

/** ??????  */
internal const val MAIN_HOME = 0

/** ??????  */
internal const val MAIN_CLASSIFY = 1

/** ?????????  */
internal const val MAIN_OFFICIAL_ACCOUNT = 2

/** ??????  */
internal const val MAIN_SQUARE = 3

/** ??????  */
internal const val MAIN_PROJECT = 4

/** Fragment ?????? */
private const val FRAGMENT_COUNT = 5

/**
 * Function: ?????? Activity
 * Date: 2020/2/11 13:55
 * Description:
 * Author: ShiJingFeng
 */
@BindEventBus
@Route(path = ACTIVITY_WAN_ANDROID_MAIN)
internal class MainActivity : WanAndroidBaseActivity<ActivityWanAndroidMainBinding, MainViewModel>() {

    /** ?????? ViewPager Fragment ????????? */
    private var mMainFragmentPagerAdapter: MainFragmentPagerAdapter? = null

    /** ?????? TabLayout????????? TextView */
    private lateinit var mCurIndicatorTextView: TextView
    /** ?????? TabLayout????????? ImageView */
    private lateinit var mCurIndicatorImageView: ImageView

    /**
     * ????????????ID
     *
     * @return ??????ID
     */
    override fun getLayoutId() = R.layout.activity_wan_android_main

    /**
     * ??????ViewModel
     * @return ViewModel
     */
    override fun getViewModel() = createViewModel(MainViewModel::class.java)

    /**
     * ????????? DataBinding ??????ID ??? ??????????????? Map
     * @return DataBinding ??????SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.mainViewModel, mViewModel)
    }

    /**
     * ???????????????
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
                        //TabLayout ???????????????
                        TAB_LAYOUT_VISIBILITY -> setTabLayoutVisibility(visibility)
                        else -> {}
                    }
                }
            }
        )
        mDataBinding.vpContent.offscreenPageLimit = 1
        mDataBinding.vpContent.adapter = mMainFragmentPagerAdapter

        mDataBinding.tlTabs.run {
            //??????
            addTab(newTab(), true)
            //??????
            addTab(newTab())
            //?????????
            addTab(newTab())
            //??????
            addTab(newTab())
            //??????
            addTab(newTab())

            // TabLayout ??? ViewPager ??????
            setupWithViewPager(mDataBinding.vpContent)

            //??????
            getTabAt(MAIN_HOME)?.customView = getTabView(MAIN_HOME)
            //??????
            getTabAt(MAIN_CLASSIFY)?.customView = getTabView(MAIN_CLASSIFY)
            //?????????
            getTabAt(MAIN_OFFICIAL_ACCOUNT)?.customView = getTabView(MAIN_OFFICIAL_ACCOUNT)
            //??????
            getTabAt(MAIN_SQUARE)?.customView = getTabView(MAIN_SQUARE)
            //??????
            getTabAt(MAIN_PROJECT)?.customView = getTabView(MAIN_PROJECT)
        }
        // ????????????????????????
        UserUtil.userInfo?.run {
            // ?????? ??? ?????????
            mDataBinding.includeDrawer.tvName.text = if (TextUtils.isEmpty(nickname)) username else nickname
            // ID
            mDataBinding.includeDrawer.tvId.text = identity
        }
        // ????????????????????????
        CoinUtil.coinInfo?.run {
            // ??????
            mDataBinding.includeDrawer.tvLevel.text = level.toString()
            // ??????
            mDataBinding.includeDrawer.tvRank.text = rank.toString()
            // ????????????
            mDataBinding.includeDrawer.tvCoinQuantity.text = coinCount.toString()
            // ??????????????????
            mDataBinding.includeDrawer.llLogout.visibility = VISIBLE
        }

        registerLoadingView(
            hintText = getStringById(R.string.???????????????)
        )
    }

    /**
     * ???????????????
     */
    override fun initAction() {
        super.initAction()
        // ??????DrawerLayout
        ClickUtils.applySingleDebouncing(mDataBinding.ivMenu) {
            mDataBinding.dwlDrawer.openDrawer(GravityCompat.START)
        }
        // ??????
        ClickUtils.applySingleDebouncing(mDataBinding.ivSearch) {
            navigation(
                activity = this,
                path = ACTIVITY_WAN_ANDROID_SEARCH
            )
        }
        // ??????
        ClickUtils.applySingleDebouncing(mDataBinding.fabToTop) {
            mViewModel?.mCurPosition?.let { position ->
                mMainFragmentPagerAdapter?.getFragmentByPosition(position)?.scrollToTop()
            }
        }
        // TabLayout Item ??????
        mDataBinding.tlTabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab) {
                val view = tab.customView ?: return

                when (tab.position) {
                    //??????
                    MAIN_HOME -> {
                        mCurIndicatorTextView = view.findViewById(R.id.tv_indicator_home)
                        mCurIndicatorImageView = view.findViewById(R.id.iv_indicator_home)
                    }
                    //??????
                    MAIN_CLASSIFY -> {
                        mCurIndicatorTextView = view.findViewById(R.id.tv_indicator_classify)
                        mCurIndicatorImageView = view.findViewById(R.id.iv_indicator_classify)
                    }
                    //?????????
                    MAIN_OFFICIAL_ACCOUNT -> {
                        mCurIndicatorTextView = view.findViewById(R.id.tv_indicator_official_account)
                        mCurIndicatorImageView = view.findViewById(R.id.iv_indicator_official_account)
                    }
                    //??????
                    MAIN_SQUARE -> {
                        mCurIndicatorTextView = view.findViewById(R.id.tv_indicator_square)
                        mCurIndicatorImageView = view.findViewById(R.id.iv_indicator_square)
                    }
                    //??????
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
                    //??????
                    MAIN_HOME -> {
                        view.findViewById<TextView>(R.id.tv_indicator_home).setTextColor(getColorById(R.color.grey))
                        view.findViewById<ImageView>(R.id.iv_indicator_home).imageTintList = ColorStateList.valueOf(getColorById(R.color.grey))
                    }
                    //??????
                    MAIN_CLASSIFY -> {
                        view.findViewById<TextView>(R.id.tv_indicator_classify).setTextColor(getColorById(R.color.grey))
                        view.findViewById<ImageView>(R.id.iv_indicator_classify).imageTintList = ColorStateList.valueOf(getColorById(R.color.grey))
                    }
                    //?????????
                    MAIN_OFFICIAL_ACCOUNT -> {
                        view.findViewById<TextView>(R.id.tv_indicator_official_account).setTextColor(getColorById(R.color.grey))
                        view.findViewById<ImageView>(R.id.iv_indicator_official_account).imageTintList = ColorStateList.valueOf(getColorById(R.color.grey))
                    }
                    //??????
                    MAIN_SQUARE -> {
                        view.findViewById<TextView>(R.id.tv_indicator_square).setTextColor(getColorById(R.color.grey))
                        view.findViewById<ImageView>(R.id.iv_indicator_square).imageTintList = ColorStateList.valueOf(getColorById(R.color.grey))
                    }
                    //??????
                    MAIN_PROJECT -> {
                        view.findViewById<TextView>(R.id.tv_indicator_project).setTextColor(getColorById(R.color.grey))
                        view.findViewById<ImageView>(R.id.iv_indicator_project).imageTintList = ColorStateList.valueOf(getColorById(R.color.grey))
                    }
                    else -> {}
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab) {}

        })
        // ViewPager Item ??????
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
                    // ??????
                    MAIN_HOME -> mDataBinding.tvTitle.text = getStringById(R.string.??????)
                    // ??????
                    MAIN_CLASSIFY -> mDataBinding.tvTitle.text = getStringById(R.string.??????)
                    // ?????????
                    MAIN_OFFICIAL_ACCOUNT -> mDataBinding.tvTitle.text = getStringById(R.string.?????????)
                    // ??????
                    MAIN_SQUARE -> mDataBinding.tvTitle.text = getStringById(R.string.??????)
                    // ??????
                    MAIN_PROJECT -> mDataBinding.tvTitle.text = getStringById(R.string.??????)
                    else -> {}
                }
            }
        })
        // DrawerLayout ??????
        mDataBinding.dwlDrawer.addDrawerListener(object : DrawerLayout.SimpleDrawerListener() {

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                super.onDrawerSlide(drawerView, slideOffset)
                mDataBinding.ivMenu.rotation = slideOffset * 180
            }

        })
    }

    /**
     * ????????? LiveData Observer
     */
    override fun initObserver() {
        super.initObserver()
        // ?????? ???????????????????????????
        mViewModel?.mShowLogoutDialogEvent?.observe(this, Observer {
            showLogoutDialog()
        })
    }

    /**
     * ??????????????????????????????
     *
     * @return true ???????????????  false ????????????
     */
    override fun isCustomStatusBar() = true

    /**
     * ?????? TabLayout ??? ???????????? ????????????
     * @param visibility ?????????
     */
    private fun setTabLayoutVisibility(visibility: Int) {
        if (mDataBinding.llTabs.tag == null) {
            mDataBinding.llTabs.tag = VISIBLE
        }
        if (visibility == VISIBLE) {
            //???????????????
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
            //??????????????????
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
     * ?????????????????? Tab CustomView
     * @param position ??????
     * @return View ????????????View
     */
    @SuppressLint("InflateParams")
    private fun getTabView(position: Int) = when (position) {
        //?????? (????????????)
        MAIN_HOME -> {
            val mainHomeView = LayoutInflater.from(this).inflate(R.layout.layout_wan_android_indicator_main_home, null)

            mCurIndicatorTextView = mainHomeView.findViewById(R.id.tv_indicator_home)
            mCurIndicatorImageView = mainHomeView.findViewById(R.id.iv_indicator_home)

            setThemeTextColor(mCurIndicatorTextView)
            setThemeTint(mCurIndicatorImageView)
            mainHomeView
        }
        //??????
        MAIN_CLASSIFY -> LayoutInflater.from(this).inflate(R.layout.layout_wan_android_indicator_main_classify, null)
        //?????????
        MAIN_OFFICIAL_ACCOUNT -> LayoutInflater.from(this).inflate(R.layout.layout_wan_android_indicator_main_official_account, null)
        //??????
        MAIN_SQUARE -> LayoutInflater.from(this).inflate(R.layout.layout_wan_android_indicator_main_square, null)
        //??????
        MAIN_PROJECT -> LayoutInflater.from(this).inflate(R.layout.layout_wan_android_indicator_main_project, null)
        else -> { null }
    }

    /**
     * ?????? ???????????????????????????
     */
    private fun showLogoutDialog() {
        AlertDialog.Builder(this)
            .setMessage(getStringById(R.string.??????????????????))
            .setPositiveButton(getStringById(R.string.???)) { _, _ ->
                mViewModel?.logout()
            }
            .setNegativeButton(getStringById(R.string.???), null)
            .setCancelable(true)
            .show()
    }

    /**
     * Dispatch incoming result to the correct fragment.
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            //????????????, ??????????????????
            RESULT_COIN_RECORD, RESULT_ARTICLE_COLLECTED_LIST -> {
                if (resultCode == Activity.RESULT_OK) {
                    mDataBinding.dwlDrawer.closeDrawer(GravityCompat.START)
                }
            }
            else -> {}
        }
    }

    /**
     * ???????????? ????????????
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
     * ?????? ???????????? ???????????? Event
     * @param event ???????????? ???????????? Event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getUserInfoEvent(event: UserInfoEvent) {
        val userInfo = UserUtil.userInfo
        val nickname = userInfo?.nickname
        val username = userInfo?.username
        val id = userInfo?.getId()

        // ????????????????????????, ????????????????????????????????????Item, ????????????
        mDataBinding.includeDrawer.llLogout.visibility = if (userInfo == null) GONE else VISIBLE

        // ?????????
        if (!StringUtils.isEmpty(nickname)) {
            if (mDataBinding.includeDrawer.tvName.text.toString() != nickname) {
                mDataBinding.includeDrawer.tvName.text = nickname
            }
        } else if (!StringUtils.isEmpty(username)) {
            if (mDataBinding.includeDrawer.tvName.text.toString() != username) {
                mDataBinding.includeDrawer.tvName.text = username
            }
        } else {
            mDataBinding.includeDrawer.tvName.text = getStringById(R.string.???????????????)
        }

        // ??????ID
        if (mDataBinding.includeDrawer.tvId.text.toString() != id) {
            mDataBinding.includeDrawer.tvId.text = if (!TextUtils.isEmpty(id)) id else getStringById(R.string.???????????????)
        }
    }

    /**
     * ?????? ???????????? ???????????? Event
     * @param event ???????????? ???????????? Event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getCoinInfoEvent(event: CoinInfoEvent) {
        val coinInfo = CoinUtil.coinInfo
        val level = coinInfo?.level?.toString()
        val rank = coinInfo?.rank?.toString()
        val coinCount = coinInfo?.coinCount?.toString()

        // ??????
        if (mDataBinding.includeDrawer.tvLevel.text.toString() != level) {
            mDataBinding.includeDrawer.tvLevel.text = if (!TextUtils.isEmpty(level)) level else getStringById(R.string.???????????????)
        }

        // ??????
        if (mDataBinding.includeDrawer.tvRank.text.toString() != rank) {
            mDataBinding.includeDrawer.tvRank.text = if (!TextUtils.isEmpty(rank)) rank else getStringById(R.string.???????????????)
        }

        // ????????????
        if (mDataBinding.includeDrawer.tvCoinQuantity.text.toString() != coinCount) {
            mDataBinding.includeDrawer.tvCoinQuantity.text = if (!TextUtils.isEmpty(coinCount)) coinCount else "0"
        }
    }

    /**
     * ???????????? Event
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
     * ???????????? (???????????????????????????)
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
 * ?????? ViewPager Fragment ?????????
 */
internal class MainFragmentPagerAdapter(
    fragmentManager: FragmentManager,
    onFragmentCreate: onFragmentCreate<WanAndroidBaseFragment<*, *>>
) : BaseFragmentPagerAdapter<WanAndroidBaseFragment<*, *>>(
    fragmentManager = fragmentManager,
    banDestroyed = true,
    onFragmentCreate = onFragmentCreate
) {

    /**
     * ?????? Fragment Item
     * @param position ??????
     * @return ???????????? Fragment
     */
    override fun createItem(position: Int): WanAndroidBaseFragment<*, *> {
        return when (position) {
            // ??????
            MAIN_HOME -> createHomeFragment()
            // ??????
            MAIN_CLASSIFY -> createClassifyFragment()
            // ?????????
            MAIN_OFFICIAL_ACCOUNT -> createOfficialAccountFragment()
            // ??????
            MAIN_SQUARE -> createSquareFragment()
            // ??????
            MAIN_PROJECT -> createProjectFragment()
            // ??? Fragment
            else -> createEmptyFragment()
        }
    }

    /**
     * ?????? Fragment List Count
     * @return Fragment List Count
     */
    override fun getCount() = FRAGMENT_COUNT

}