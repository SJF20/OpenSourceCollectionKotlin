package com.shijingfeng.wan_android.view_model

import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.view.View.*
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.viewModelScope
import com.blankj.utilcode.util.ToastUtils
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_REGISTER
import com.shijingfeng.base.base.application.application
import com.shijingfeng.base.util.*
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
import com.shijingfeng.wan_android.source.network.getLoginNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.LoginRepository
import com.shijingfeng.wan_android.source.repository.getLoginRepositoryInstance
import com.shijingfeng.wan_android.utils.CoinUtil
import com.shijingfeng.wan_android.utils.UserUtil
import com.shijingfeng.wan_android.utils.startTokenExpireAlarm
import kotlinx.coroutines.*
import kotlin.coroutines.Continuation
import kotlin.coroutines.ContinuationInterceptor

/**
 * Function: 登录ViewModel
 * Date: 2020/2/4 18:55
 * Description:
 * Author: ShiJingFeng
 */
internal class LoginViewModel : WanAndroidBaseViewModel<LoginRepository>() {

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
        override fun get() = !TextUtils.isEmpty(mUsername.get()) && !TextUtils.isEmpty(mPassword.get())
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
        navigation(
            path = ACTIVITY_WAN_ANDROID_REGISTER
        )
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
     * 获取 Repository
     * @return Repository
     */
    override fun getRepository() = getLoginRepositoryInstance(
        networkSource = getLoginNetworkSourceInstance()
    )

    /**
     * 登录
     */
    private fun login() {
        showLoadingView()

        val coroutineContext = Dispatchers.Main + CoroutineName("登录接口请求") + LoginContinuationInterceptor()

        viewModelScope.launch(context = coroutineContext) {
            try {
                val userInfo = mRepository?.login(HashMap<String, Any>(2).apply {
                    put("username", mUsername.get() ?: "")
                    put("password", mPassword.get() ?: "")
                })

                if (userInfo != null) {
                    // 登录信息存储到本地
                    UserUtil.login(userInfo)
                    // 开启 检查 玩Android Token 是否过期 定时器
                    startTokenExpireAlarm()
                    // 登录完成后 获取 积分信息
                    getCoinInfo()
                } else {
                    //关闭加载中弹框
                    hideLoadingView()
                    ToastUtils.showShort(getStringById(R.string.服务器出错登录失败))
                }
            } catch (e: Exception) {
                //关闭加载中弹框
                hideLoadingView()
                ToastUtils.showShort(getStringById(R.string.服务器出错登录失败))
            }
        }
    }

    /**
     * 获取积分信息
     */
    private fun getCoinInfo() {
        mRepository?.getCoinInfo(onSuccess = { coinInfo ->
            //积分信息存储到本地
            CoinUtil.coinInfo = coinInfo
            //关闭加载中弹框
            hideLoadingView()
            // 关闭登录页面
            finish()
        }, onFailure = {
            //关闭加载中弹框
            hideLoadingView()
            // 关闭登录页面
            finish()
        })
    }

}

/**
 * 登录接口请求拦截器
 */
internal class LoginContinuationInterceptor : ContinuationInterceptor {

    override val key = ContinuationInterceptor

    override fun <T> interceptContinuation(continuation: Continuation<T>) = LoginContinuation(continuation)

}

/**
 * 登录接口请求拦截器执行者
 */
internal class LoginContinuation<T>(
    continuation: Continuation<T>
) : Continuation<T> {

    private val mContinuation = continuation

    override val context = mContinuation.context

    override fun resumeWith(result: Result<T>) {
        mContinuation.resumeWith(result)
    }

}