package com.shijingfeng.wan_android.view_model

import android.os.Bundle
import android.view.View.OnClickListener
import com.blankj.utilcode.util.NetworkUtils
import com.shijingfeng.base.arouter.*
import com.shijingfeng.base.common.constant.FINISH_FRONT_ALL_ACTIVITY
import com.shijingfeng.base.common.constant.NEED_LOGIN
import com.shijingfeng.base.livedata.SingleLiveEvent
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseFragment
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
import com.shijingfeng.wan_android.constant.*
import com.shijingfeng.wan_android.entity.network.CoinInfoEntity
import com.shijingfeng.wan_android.source.repository.MainRepository
import com.shijingfeng.wan_android.ui.fragment.*
import com.shijingfeng.wan_android.utils.CoinUtil

/**
 * Function: 主页 ViewModel
 * Date: 2020/2/10 16:19
 * Description:
 * @author ShiJingFeng
 */
internal class MainViewModel(
    repository: MainRepository? = null
) : WanAndroidBaseViewModel<MainRepository>(repository) {

    /** Fragment列表  */
    private var mFragmentList: List<WanAndroidBaseFragment<*, *>>? = null

    /** 当前Fragment  */
    var mCurrentFragment: WanAndroidBaseFragment<*, *>? = null

    /** 更新积分数据 LiveData Event  */
    val mUpdateCoinInfoEvent = SingleLiveEvent<CoinInfoEntity>()
    /** 显示 退出登录确认对话框 */
    val mShowLogoutDialogEvent = SingleLiveEvent<Any?>()

    /** 跳转到 积分排行榜页面 */
    val mRankClickListener = OnClickListener {
        navigation(
            path = ACTIVITY_WAN_ANDROID_COIN_RANK,
            bundle = Bundle().apply {
                putBoolean(NEED_LOGIN, true)
            }
        )
    }
    /** 跳转到 积分记录页面 */
    val mCoinRecordClickListener = OnClickListener {
        navigation(
            path = ACTIVITY_WAN_ANDROID_COIN_RECORD,
            bundle = Bundle().apply {
                putBoolean(NEED_LOGIN, true)
            },
            requestCode = RESULT_COIN_RECORD
        )
    }
    /** 跳转到 我的收藏页面 */
    val mCollectionClickListener = OnClickListener {
        navigation(
            path = ACTIVITY_WAN_ANDROID_PERSONAL_COLLECTION,
            bundle = Bundle().apply {
                putBoolean(NEED_LOGIN, true)
            },
            requestCode = RESULT_ARTICLE_COLLECTED_LIST
        )
    }
    /** 跳转到 待办事项页面  */
    val mTodoClickListener = OnClickListener {
        navigation(
            path = ACTIVITY_TODO_MAIN
        )
    }
    /** 跳转到 系统设置页面  */
    val mSettingClickListener = OnClickListener {}
    /** 跳转到 关于我们页面  */
    val mAboutClickListener = OnClickListener {}
    /** 注销登录  */
    val mLogoutClickListener = OnClickListener {
        mShowLogoutDialogEvent.call()
    }

    /** 置顶  */
    val mScrollToTopClickListener = OnClickListener {
        mCurrentFragment?.scrollToTop()
    }

    /**
     * 初始化
     */
    override fun init() {
        super.init()
        if (NetworkUtils.isConnected()) {
            getCoinInfo()
        } else {
            val coinInfo: CoinInfoEntity? = CoinUtil.getCoinInfo()

            mUpdateCoinInfoEvent.value = coinInfo
        }
    }

    /**
     * 获取积分信息
     */
    private fun getCoinInfo() {
        mRepository?.getCoinInfo(onSuccess = { coinInfo ->
            coinInfo?.run {
                CoinUtil.updateCoinInfo(coinInfo)
                mUpdateCoinInfoEvent.value = coinInfo
            }
        })
    }

    /**
     * 退出登录
     */
    fun logout() {
        showLoadingDialog(getStringById(R.string.退出登录中))
        mRepository?.logout(onSuccess = {
            hideLoadingDialog()
            navigation(
                path = ACTIVITY_WAN_ANDROID_LOGIN,
                bundle = Bundle().apply {
                    putBoolean(SKIP_TO_HOME, true)
                    putBoolean(FINISH_FRONT_ALL_ACTIVITY, true)
                    putBoolean(LOGIN_ACTIVITY_CAN_BACK, false)
                }
            )
        }, onFailure = {
            hideLoadingDialog()
        })
    }

    /**
     * 获取 Fragment列表
     * @return Fragment列表
     */
    fun getFragmentList(): List<WanAndroidBaseFragment<*, *>> {
        if (mFragmentList == null) {
            val homeFragment = HomeFragment()

            mCurrentFragment = homeFragment
            mFragmentList = mutableListOf(
                //首页 Fragment
                homeFragment,
                //分类 Fragment
                ClassifyFragment(),
                //公众号 Fragment
                OfficialAccountFragment(),
                //广场 Fragment
                SquareFragment(),
                //项目 Fragment
                ProjectFragment()
            )
        }
        return mFragmentList as List<WanAndroidBaseFragment<*, *>>
    }

}