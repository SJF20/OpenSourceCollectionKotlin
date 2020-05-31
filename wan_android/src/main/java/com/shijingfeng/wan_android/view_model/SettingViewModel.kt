package com.shijingfeng.wan_android.view_model

import android.graphics.Color
import android.view.View
import com.blankj.utilcode.util.SPUtils
import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.util.getColorById
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
import com.shijingfeng.wan_android.common.constant.LOGIN
import com.shijingfeng.wan_android.common.constant.SP_WAN_ANDROID_APP_NAME
import com.shijingfeng.wan_android.common.constant.THEME_COLOR
import com.shijingfeng.wan_android.common.global.themeColorList
import com.shijingfeng.wan_android.utils.ThemeUtil

/**
 * Function: 系统设置 ViewModel
 * Date: 2020/5/30 22:57
 * Description:
 * @author ShiJingFeng
 */
internal class SettingViewModel(
    repository: BaseRepository<*, *>? = null
) : WanAndroidBaseViewModel<BaseRepository<*, *>>(repository = repository) {

    /** 当前选择的主题(临时存储) RGB颜色字符串 */
    var mCurThemeRGBColorStr = ThemeUtil.curThemeColor
    /** 当前选择的 主题名称 位置 */
    var mCurThemeColorNamePosition = 0

    /** 返回  */
    val mBackClickListener = View.OnClickListener { finish() }

}