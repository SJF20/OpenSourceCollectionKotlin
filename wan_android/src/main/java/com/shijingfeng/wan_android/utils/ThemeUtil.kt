package com.shijingfeng.wan_android.utils

import com.blankj.utilcode.util.SPUtils
import com.shijingfeng.wan_android.common.constant.SP_WAN_ANDROID_APP_NAME
import com.shijingfeng.wan_android.common.constant.THEME_COLOR
import com.shijingfeng.wan_android.common.constant.THEME_NAME
import com.shijingfeng.wan_android.common.global.themeColorList
import com.shijingfeng.wan_android.common.global.themeColorNameList

/**
 * Function: 主题 工具类
 * Date: 2020/5/31 16:37
 * Description:
 * @author ShiJingFeng
 */
internal object ThemeUtil {

    /** 当前主题颜色 */
    private var mCurThemeColor: String? = null

    var curThemeColor: String
    get() {
        if (mCurThemeColor == null) {
            mCurThemeColor = SPUtils.getInstance(SP_WAN_ANDROID_APP_NAME).getString(THEME_COLOR, themeColorList!![0])
        }
        return mCurThemeColor!!
    }
    set(curThemeColor) {
        mCurThemeColor = curThemeColor

        if (mCurThemeColor == null) {
            SPUtils.getInstance(SP_WAN_ANDROID_APP_NAME).remove(THEME_COLOR, true)
        } else {
            SPUtils.getInstance(SP_WAN_ANDROID_APP_NAME).put(THEME_COLOR, mCurThemeColor, true)
        }
    }

    /** 当前主题名称 */
    private var mCurThemeName: String? = null

    var curThemeName: String
    get() {
        if (mCurThemeName == null) {
            mCurThemeName = SPUtils.getInstance(SP_WAN_ANDROID_APP_NAME).getString(THEME_NAME, themeColorNameList!![0])
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