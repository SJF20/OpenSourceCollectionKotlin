package com.shijingfeng.wan_android.utils

import androidx.annotation.ColorInt
import com.blankj.utilcode.util.SPUtils
import com.shijingfeng.base.util.getColorById
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.common.constant.SP_WAN_ANDROID_APP_NAME
import com.shijingfeng.wan_android.common.constant.THEME_COLOR
import com.shijingfeng.wan_android.common.constant.THEME_NAME

/**
 * Function: 主题 工具类
 * Date: 2020/5/31 16:37
 * Description:
 * Author: ShiJingFeng
 */
internal object ThemeUtil {

    /** 当前主题颜色 */
    @ColorInt private var mCurThemeColor: Int? = null

    var curThemeColor: Int
    get() {
        if (mCurThemeColor == null) {
            mCurThemeColor = SPUtils.getInstance(SP_WAN_ANDROID_APP_NAME).getInt(THEME_COLOR, getColorById(R.color.wan_android_theme_color))
        }
        return mCurThemeColor!!
    }
    set(curThemeColor) {
        mCurThemeColor = curThemeColor
        SPUtils.getInstance(SP_WAN_ANDROID_APP_NAME).put(THEME_COLOR, curThemeColor, true)
    }

    /** 当前主题名称 */
    private var mCurThemeName: String? = null

    var curThemeName: String
    get() {
        if (mCurThemeName == null) {
            mCurThemeName = SPUtils.getInstance(SP_WAN_ANDROID_APP_NAME).getString(THEME_NAME, "")
        }
        return mCurThemeName!!
    }
    set(curThemeName) {
        mCurThemeName = curThemeName
        if (mCurThemeName == null) {
            SPUtils.getInstance(SP_WAN_ANDROID_APP_NAME).remove(THEME_NAME, true)
        } else {
            SPUtils.getInstance(SP_WAN_ANDROID_APP_NAME).put(THEME_NAME, mCurThemeName, true)
        }
    }

}