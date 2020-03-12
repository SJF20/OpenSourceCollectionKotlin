package com.shijingfeng.wan_android.viewmodel

import android.app.Activity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.blankj.utilcode.util.ToastUtils
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_MAIN
import com.shijingfeng.base.common.constant.FINISH_PREVIOUS_ACTIVITY
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
import com.shijingfeng.wan_android.constant.SKIP_TO_HOME
import com.shijingfeng.wan_android.entity.event.UserInfoEvent
import com.shijingfeng.wan_android.source.repository.RegisterRepository
import com.shijingfeng.wan_android.utils.UserUtil
import org.greenrobot.eventbus.EventBus
import java.util.*

/**
 * Function: 注册页面 ViewModel
 * Date: 2020/2/5 15:52
 * Description:
 * @author ShiJingFeng
 */
class RegisterViewModel(
    repository: RegisterRepository? = null
) : WanAndroidBaseViewModel<RegisterRepository>(repository) {

    /** 用户名  */
    val username = ObservableField("")
    /** 密码  */
    val password = ObservableField("")
    /** 确认密码  */
    val confirmPassword = ObservableField("")
    /** 是否能注册  */
    val isRegisterEnable = object : ObservableBoolean(username, password, confirmPassword) {
        override fun get() = !(TextUtils.isEmpty(username.get()) || TextUtils.isEmpty(password.get()) || TextUtils.isEmpty(confirmPassword.get()))
    }

    /** 返回  */
    val backClickListener = View.OnClickListener { finish() }
    /** 清除用户名  */
    val clearUsernameClickListener = View.OnClickListener { username.set("") }
    /** 清除密码  */
    val clearPasswordClickListener = View.OnClickListener { password.set("") }
    /** 清除确认密码  */
    val clearConfirmPasswordClickListener = View.OnClickListener { confirmPassword.set("") }
    /** 注册  */
    val registerClickListener = View.OnClickListener { register() }

    /**
     * 注册
     */
    private fun register() {
        if (TextUtils.isEmpty(username.get())) {
            ToastUtils.showShort("用户名不能为空")
            return
        }
        if (TextUtils.isEmpty(password.get())) {
            ToastUtils.showShort("密码不能为空")
            return
        }
        if (TextUtils.isEmpty(confirmPassword.get())) {
            ToastUtils.showShort("确认密码不能为空")
            return
        }
        if (!TextUtils.equals(password.get(), confirmPassword.get())) {
            ToastUtils.showShort("两次输入密码不一致")
            return
        }

        showLoadingDialog("注册中...")

        val postMap = HashMap<String, Any>(3)

        postMap["username"] = username
        postMap["password"] = password
        postMap["repassword"] = confirmPassword

        mRepository?.register(postMap, onSuccess = onSuccessCompleted@ { userInfo ->
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
                ToastUtils.showShort("服务器出错，注册失败")
            }
        }, onFailure = {
            //关闭加载中弹框
            hideLoadingDialog()
        })
    }

}