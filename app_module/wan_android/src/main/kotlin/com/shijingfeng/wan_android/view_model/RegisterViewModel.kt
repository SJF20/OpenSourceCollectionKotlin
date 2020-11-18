package com.shijingfeng.wan_android.view_model

import android.text.TextUtils
import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.ToastUtils
import com.shijingfeng.base.common.extension.finishPrevious
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
import com.shijingfeng.wan_android.source.network.getRegisterNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.RegisterRepository
import com.shijingfeng.wan_android.source.repository.getRegisterRepositoryInstance
import com.shijingfeng.wan_android.utils.CoinUtil
import com.shijingfeng.wan_android.utils.UserUtil
import java.util.*

/**
 * Function: 注册页面 ViewModel
 * Date: 2020/2/5 15:52
 * Description:
 * @author ShiJingFeng
 */
internal class RegisterViewModel : WanAndroidBaseViewModel<RegisterRepository>() {

    /** 用户名  */
    val mUsername = ObservableField("")
    /** 密码  */
    val mPassword = ObservableField("")
    /** 确认密码  */
    val mConfirmPassword = ObservableField("")
    /** 是否能注册  */
    val mIsRegisterEnable = object : ObservableBoolean(mUsername, mPassword, mConfirmPassword) {
        override fun get() = !TextUtils.isEmpty(mUsername.get()) && !TextUtils.isEmpty(mPassword.get()) && !TextUtils.isEmpty(mConfirmPassword.get())
    }

    /** 返回  */
    val mBackClickListener = View.OnClickListener { finish() }
    /** 清除用户名  */
    val mClearUsernameClickListener = View.OnClickListener { mUsername.set("") }
    /** 清除密码  */
    val mClearPasswordClickListener = View.OnClickListener { mPassword.set("") }
    /** 清除确认密码  */
    val mClearConfirmPasswordClickListener = View.OnClickListener { mConfirmPassword.set("") }
    /** 注册  */
    val mRegisterClickListener = View.OnClickListener { register() }

    /**
     * 获取 Repository
     * @return Repository
     */
    override fun getRepository() = getRegisterRepositoryInstance(
        networkSource = getRegisterNetworkSourceInstance()
    )

    /**
     * 注册
     */
    private fun register() {
        if (!TextUtils.equals(mPassword.get(), mConfirmPassword.get())) {
            ToastUtils.showShort(getStringById(R.string.两次输入密码不一致))
            return
        }
        showLoadingView()
        mRepository?.register(HashMap<String, Any>(3).apply {
            put("username", mUsername.get() ?: "")
            put("password", mPassword.get() ?: "")
            put("repassword", mConfirmPassword.get() ?: "")
        }, onSuccess = onSuccessCompleted@ { userInfo ->
            if (userInfo != null) {
                //登录信息存储到本地
                UserUtil.login(userInfo)
                // 登录完成后 获取 积分信息
                getCoinInfo()
            } else {
                //关闭加载中LoadingView
                hideLoadingView()
                ToastUtils.showShort(getStringById(R.string.服务器出错注册失败))
            }
        }, onFailure = {
            //关闭加载中LoadingView
            hideLoadingView()
        })
    }

    /**
     * 获取积分信息
     */
    private fun getCoinInfo() {
        mRepository?.getCoinInfo(onSuccess = { coinInfo ->
            //积分信息存储到本地
            CoinUtil.coinInfo = coinInfo
            //关闭加载中LoadingView
            hideLoadingView()
            finishLoginActivity()
            finish()
        }, onFailure = {
            //关闭加载中LoadingView
            hideLoadingView()
            finishLoginActivity()
            finish()
        })
    }

    /**
     * 关闭登录页面
     */
    private fun finishLoginActivity() {
        val curActivity = ActivityUtils.getTopActivity()

        curActivity.finishPrevious()
    }

}