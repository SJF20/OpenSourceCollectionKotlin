@file:JvmName("ARouterUtil")
package com.shijingfeng.base.arouter

import android.app.Activity
import android.os.Bundle
import android.util.SparseIntArray
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.shijingfeng.base.base.application.BaseApplication
import com.shijingfeng.base.base.application.application
import com.shijingfeng.base.base.fragment.BaseFragment
import com.shijingfeng.base.common.constant.KEY_ENTER_ANIM
import com.shijingfeng.base.common.constant.KEY_EXIT_ANIM
import com.shijingfeng.base.util.cast

/**
 * 跳到指定路径页面
 * @param path 路径
 * @param bundle 携带的数据
 * @param requestCode 请求码
 * @param animSparseArray Activity切换动画, Key: KEY_ENTER_ANIM, KEY_EXIT_ANIM
 * @param callback 跳转回调
 */
fun navigation(
    activity: Activity? = null,
    path: String,
    bundle: Bundle? = null,
    //注意 当 requestCode > 0 时，才会回调 onActivityResult, 所不同的是 startActivityForResult 当 requestCode > -1 时才会回调 onActivityResult
    requestCode: Int = -1,
    animSparseArray: SparseIntArray? = null,
    callback : NavigationCallback? = null
): Any? {
    ARouter.getInstance()
        .build(path)
        .with(bundle)
        .run {
            animSparseArray?.run {
                val enterAnim = get(KEY_ENTER_ANIM)
                val exitAnim = get(KEY_EXIT_ANIM)

                withTransition(enterAnim, exitAnim)
            }
            return ARouter.getInstance().navigation(activity ?: application, this, requestCode, callback)
        }
}

/**
 * 通过 ARouter 获取 Fragment
 */
fun <T : BaseFragment?> getFragment(
    path: String
): T {
    val fragment = ARouter.getInstance()
        .build(path)
        .navigation()

    return cast(fragment)
}