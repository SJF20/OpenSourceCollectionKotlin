/** 生成的 Java 类名 */
@file:JvmName("ActivityUtil")
package com.shijingfeng.base.util

import android.app.Activity
import com.blankj.utilcode.util.ActivityUtils
import com.shijingfeng.base.util.image_load.ImageLoader

/**
 * Function: Activity工具类 (作为 blankj 的 Utils 的补充)
 * Date: 2020/1/18 16:18
 * Description:
 * @author ShiJingFeng
 */

/**
 * 销毁 前一个 Activity
 * @param currentActivity 当前 Activity
 * @param isLoadAnim 是否加载 Activity切换动画
 */
fun finishPreviousActivity(currentActivity: Activity, isLoadAnim: Boolean = false) {
    //销毁前一个Activity
    val activityList = ActivityUtils.getActivityList()
    val size = activityList.size

    for (i in size - 1 downTo 0) {
        if (activityList[i] == currentActivity && i > 0) {
            activityList[i - 1]?.run {
                finish()
                if (!isLoadAnim) {
                    overridePendingTransition(0, 0)
                }
            }
            break
        }
    }
}
