package com.shijingfeng.wan_android.view_model

import android.os.Bundle
import android.view.View.OnClickListener
import com.shijingfeng.base.arouter.*
import com.shijingfeng.base.common.constant.NEED_LOGIN
import com.shijingfeng.base.mvvm.livedata.SingleLiveEvent
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
import com.shijingfeng.wan_android.common.constant.RESULT_ARTICLE_COLLECTED_LIST
import com.shijingfeng.wan_android.common.constant.RESULT_COIN_RECORD
import com.shijingfeng.wan_android.source.local.getMainLocalSourceInstance
import com.shijingfeng.wan_android.source.network.getMainNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.MainRepository
import com.shijingfeng.wan_android.source.repository.getMainRepositoryInstance
import com.shijingfeng.wan_android.ui.activity.MAIN_HOME
import com.shijingfeng.wan_android.utils.localLogout

/**
 * Function: 主页 ViewModel
 * Date: 2020/2/10 16:19
 * Description:
 * Author: ShiJingFeng
 */
internal class MainViewModel : WanAndroidBaseViewModel<MainRepository>() {

    /** 当前 TabLayout 和 ViewPager 下标  */
    var mCurPosition = MAIN_HOME

    /** 显示 退出登录确认对话框 Event */
    val mShowLogoutDialogEvent = SingleLiveEvent<Any?>()

    /** 侧边栏 Header 点击事件 */
    val mHeaderClickListener = OnClickListener {
        // 跳转到用户信息页面
        navigation(
            path = ACTIVITY_WAN_ANDROID_USER_INFO,
            bundle = Bundle().apply {
                putBoolean(NEED_LOGIN, true)
            }
        )
    }
    /** 跳转到 积分排行榜页面 */
    val mRankClickListener = OnClickListener {
        navigation(
            path = ACTIVITY_WAN_ANDROID_COIN_RANK
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
    val mSettingClickListener = OnClickListener {
        navigation(
            path = ACTIVITY_WAN_ANDROID_SETTING
        )
    }
    /** 跳转到 关于我们页面  */
    val mAboutClickListener = OnClickListener {
        navigation(
            path = ACTIVITY_WAN_ANDROID_ABOUT_US
        )
    }
    /** 注销登录  */
    val mLogoutClickListener = OnClickListener {
        mShowLogoutDialogEvent.call()
    }

    /**
     * 获取 Repository
     * @return Repository
     */
    override fun getRepository() = getMainRepositoryInstance(
        localSource = getMainLocalSourceInstance(),
        networkSource = getMainNetworkSourceInstance()
    )

    /**
     * 退出登录
     */
    fun logout() {
        showLoadingView()
        mRepository?.logout(onSuccess = {
            // 本地退出登录
            localLogout()
            // 关闭加载中弹框
            hideLoadingView()
        }, onFailure = {
            // 关闭加载中弹框
            hideLoadingView()
        })
    }

}