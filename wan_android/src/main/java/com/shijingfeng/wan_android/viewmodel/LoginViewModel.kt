package com.shijingfeng.wan_android.viewmodel

import android.app.Activity
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.TextUtils
import android.view.View.*
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import com.blankj.utilcode.util.ToastUtils
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_MAIN
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_REGISTER
import com.shijingfeng.base.common.constant.FINISH_PREVIOUS_ACTIVITY
import com.shijingfeng.base.util.getDrawableById
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
import com.shijingfeng.wan_android.constant.SKIP_TO_HOME
import com.shijingfeng.wan_android.entity.event.UserInfoEvent
import com.shijingfeng.wan_android.source.repository.LoginRepository
import com.shijingfeng.wan_android.utils.UserUtil
import org.greenrobot.eventbus.EventBus

/**
 * Function: 登录ViewModel
 * Date: 2020/2/4 18:55
 * Description:
 * @author ShiJingFeng
 */
class LoginViewModel(
    repository: LoginRepository? = null
) : WanAndroidBaseViewModel<LoginRepository>(repository) {

    /** 用户名  */
    val mUsername = ObservableField("")

    /** 用户名清除按钮 可见性  */
    val mUsernameClearVisibility = object : ObservableInt(mUsername) {
        override fun get() = if (TextUtils.isEmpty(mUsername.get())) GONE else VISIBLE
    }

    /** 密码  */
    val mPassword = ObservableField("")

    /** 密码清除按钮 可见性  */
    val mPasswordClearVisibility = object : ObservableInt(mPassword) {
        override fun get() = if (TextUtils.isEmpty(mPassword.get())) GONE else VISIBLE
    }

    /** 是否能登录  */
    val mIsLoginEnable = object : ObservableBoolean(mUsername, mPassword) {
        override fun get() =
            !TextUtils.isEmpty(mUsername.get()) && !TextUtils.isEmpty(mPassword.get())
    }

    /** 密码是否是明文  true 明文 false 密文  */
    val mIsCleartextPassword = ObservableBoolean(false)

    /** 设置密码保密性图标  */
    val mPasswordSecrecyIcon = object : ObservableField<Drawable>(mIsCleartextPassword) {
        override fun get() = if (mIsCleartextPassword.get()) getDrawableById(R.drawable.ic_invisible) else getDrawableById(R.drawable.ic_visible)
    }

    /** 返回  */
    val mBackClickListener = OnClickListener { finish() }

    /** 去注册 */
    val mTextOperateClickListener = OnClickListener {
        navigation(path = ACTIVITY_WAN_ANDROID_REGISTER, bundle = Bundle().apply {
            putBoolean(SKIP_TO_HOME, mBundle?.getBoolean(SKIP_TO_HOME, false) ?: false)
        })
    }

    /** 登录  */
    val mLoginClickListener = OnClickListener { login() }

    /** 找回密码  */
    val mRetrievePasswordClickListener = OnClickListener {}

    /** 清除用户名  */
    val mClearUsernameClickListener = OnClickListener { mUsername.set("") }

    /** 清除密码  */
    val mClearPasswordClickListener = OnClickListener { mPassword.set("") }

    /** 密码可见性切换 */
    val mPasswordVisibilityClickListener = OnClickListener {
        if (mIsCleartextPassword.get()) {
            //设置为密文
            mIsCleartextPassword.set(false)
        } else {
            //设置为明文
            mIsCleartextPassword.set(true)
        }
    }

    /**
     * 登录
     */
    private fun login() {
        showLoadingDialog("登录中...")

        val postMap = HashMap<String, Any>()

        postMap["username"] = mUsername.get() ?: ""
        postMap["password"] = mPassword.get() ?: ""

        mRepository?.login(postMap, onSuccess = onSuccessCompleted@{ userInfo ->
            //关闭加载中弹框
            hideLoadingDialog()
            if (userInfo != null) {
                //登录信息存储到本地
                UserUtil.login(userInfo)
                //通知其他页面更新用户数据
                EventBus.getDefault().post(UserInfoEvent(userInfo))

                val skipToHome = mBundle?.getBoolean(SKIP_TO_HOME, false) ?: false

                if (skipToHome) {
                    //跳到首页
                    navigation(path = ACTIVITY_WAN_ANDROID_MAIN, bundle = Bundle().apply {
                        putBoolean(FINISH_PREVIOUS_ACTIVITY, true)
                    })
                    return@onSuccessCompleted
                }
                setResult(Activity.RESULT_OK)
                finish()
            } else {
                ToastUtils.showShort("服务器出错，登录失败")
            }
        }, onFailure = {
            //关闭加载中弹框
            hideLoadingDialog()
        })
    }

}