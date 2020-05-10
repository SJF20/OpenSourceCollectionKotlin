package com.shijingfeng.wan_android.utils

import com.blankj.utilcode.util.SPUtils
import com.shijingfeng.base.util.decrypt
import com.shijingfeng.base.util.deserialize
import com.shijingfeng.base.util.encrypt
import com.shijingfeng.base.util.serialize
import com.shijingfeng.wan_android.constant.LOGIN
import com.shijingfeng.wan_android.constant.SP_APP_NAME
import com.shijingfeng.wan_android.constant.USER_INFO
import com.shijingfeng.wan_android.entity.event.UserInfoEvent
import com.shijingfeng.wan_android.entity.UserInfoEntity
import org.greenrobot.eventbus.EventBus

/**
 * Function: 用户工具类
 * Date: 2020/2/3 15:19
 * Description:
 * @author ShiJingFeng
 */
internal object UserUtil {

    /** 是否已登录  true: 已登录  false: 未登录  */
    private var mLogin = false
    /** 登录数据  */
    private var mUserInfo: UserInfoEntity? = null

    var userInfo: UserInfoEntity?
    get() {
        if (mUserInfo == null) {
            val encryptLoginDataStr = SPUtils.getInstance(SP_APP_NAME).getString(USER_INFO, "")
            val loginDataStr: String = decrypt(encryptLoginDataStr)

            mUserInfo = deserialize(loginDataStr, UserInfoEntity::class.java)
        }

        return mUserInfo
    }
    set(userInfo) {
        mUserInfo = userInfo

        if (userInfo == null) {
            SPUtils.getInstance(SP_APP_NAME).remove(USER_INFO, true)
        } else {
            SPUtils.getInstance(SP_APP_NAME).put(USER_INFO, encrypt(serialize(userInfo)), true)
        }

        //通知其他页面更新用户数据
        EventBus.getDefault().post(UserInfoEvent())
    }

    /**
     * 是否已登录
     * @return true: 已登录  false: 未登录
     */
    fun isLogin(): Boolean {
        if (!mLogin) {
            mLogin = SPUtils.getInstance(SP_APP_NAME).getBoolean(LOGIN, false)
        }
        return mLogin
    }

    /**
     * 获取用户ID
     * @return 用户ID
     */
    fun getId(): String {
        return userInfo?.getId() ?: ""
    }

    /**
     * 登录
     * @param userInfoEntity 登录信息
     */
    fun login(userInfoEntity: UserInfoEntity) {
        mLogin = true
        mUserInfo = userInfoEntity

        SPUtils.getInstance(SP_APP_NAME).put(LOGIN, true, true)
        SPUtils.getInstance(SP_APP_NAME).put(USER_INFO, encrypt(serialize(userInfoEntity)), true)

        //通知其他页面更新用户数据
        EventBus.getDefault().post(UserInfoEvent())
    }

    /**
     * 退出登录
     */
    fun logout() {
        mLogin = false
        mUserInfo = null

        SPUtils.getInstance(SP_APP_NAME).remove(LOGIN, true)
        SPUtils.getInstance(SP_APP_NAME).remove(USER_INFO, true)

        //通知其他页面更新用户数据
        EventBus.getDefault().post(UserInfoEvent())
    }

}