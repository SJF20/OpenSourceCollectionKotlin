package com.shijingfeng.wan_android.view_model

import android.view.View
import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
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
    var mCurThemeColor = ThemeUtil.curThemeColor
    /** 当前选择的 主题名称 位置 */
    var mCurThemeColorNamePosition = 0

    /** 返回  */
    val mBackClickListener = View.OnClickListener { finish() }

}