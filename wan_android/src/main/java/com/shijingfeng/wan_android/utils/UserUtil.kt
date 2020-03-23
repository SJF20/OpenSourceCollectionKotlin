package com.shijingfeng.wan_android.utils

import com.blankj.utilcode.util.SPUtils
import com.shijingfeng.base.util.decrypt
import com.shijingfeng.base.util.deserialize
import com.shijingfeng.base.util.encrypt
import com.shijingfeng.base.util.serialize
import com.shijingfeng.wan_android.constant.LOGIN
import com.shijingfeng.wan_android.constant.SP_APP_NAME
import com.shijingfeng.wan_android.constant.USER_INFO
import com.shijingfeng.wan_android.entity.network.UserInfoEntity

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
    private var mUserInfoEntity: UserInfoEntity? = null

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
        return getUserInfo()?.getId() ?: ""
    }

    /**
     * 获取用户数据
     * @return 登录数据
     */
    fun getUserInfo(): UserInfoEntity? {
        if (mUserInfoEntity == null) {
            val encryptLoginDataStr = SPUtils.getInstance(SP_APP_NAME).getString(USER_INFO, "")
            val loginDataStr: String = decrypt(encryptLoginDataStr)

            mUserInfoEntity = deserialize(loginDataStr, UserInfoEntity::class.java)
        }

        return mUserInfoEntity
    }

    /**
     * 更新用户数据
     * @param userInfoEntity 新的登录数据
     */
    fun updateUserInfo(userInfoEntity: UserInfoEntity?) {
        mUserInfoEntity = userInfoEntity

        if (userInfoEntity == null) {
            SPUtils.getInstance(SP_APP_NAME).remove(USER_INFO)
        } else {
            SPUtils.getInstance(SP_APP_NAME).put(USER_INFO, encrypt(serialize(userInfoEntity)), false)
        }
    }

    /**
     * 登录
     * @param userInfoEntity 登录信息
     */
    fun login(userInfoEntity: UserInfoEntity) {
        mLogin = true
        mUserInfoEntity = userInfoEntity

        SPUtils.getInstance(SP_APP_NAME).put(LOGIN, true)
        SPUtils.getInstance(SP_APP_NAME).put(USER_INFO, encrypt(serialize(userInfoEntity)))
    }

    /**
     * 退出登录
     */
    fun logout() {
        mLogin = false
        mUserInfoEntity = null

        SPUtils.getInstance(SP_APP_NAME).remove(LOGIN, false)
        SPUtils.getInstance(SP_APP_NAME).remove(USER_INFO, false)
    }

}