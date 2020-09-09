/** 生成的 Java 类名 */
@file:JvmName("ActivityUtil")
package com.shijingfeng.base.util

import android.app.Activity
import com.blankj.utilcode.util.ActivityUtils
import com.shijingfeng.base.base.activity.BaseActivity

/**
 * Function: Activity工具类 (作为 blankj 的 Utils 的补充)
 * Date: 2020/1/18 16:18
 * Description:
 * @author ShiJingFeng
 */

/** Activity 列表 */
private val activityList = mutableListOf<BaseActivity>()

/**
 * 获取 Activity 列表
 */
fun getActivityList(): List<BaseActivity> = activityList

/**
 * 获取栈顶Activity, 即当前正在顶部显示的Activity
 */
fun getTopActivity(): BaseActivity? {
    if (activityList.isEmpty()) {
        return null
    }
    return activityList[activityList.size - 1]
}

/**
 * 销毁 指定Activity 前一个 Activity
 * @param curActivity 当前 Activity
 * @param isLoadAnim 是否加载 Activity切换动画
 */
fun finishPreviousActivity(
    curActivity: Activity,
    isLoadAnim: Boolean = false
) {
    val activityList = ActivityUtils.getActivityList()
    val size = activityList.size

    for (i in size - 1 downTo 0) {
        if (activityList[i] === curActivity && i > 0) {
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

/**
 * 销毁 指定Activity 前面所有的 Activity
 * @param curActivity 当前 Activity
 * @param isLoadAnim 是否加载 Activity切换动画
 */
fun finishPreviousAllActivity(
    curActivity: Activity,
    isLoadAnim: Boolean = false
) {
    val activityList = ActivityUtils.getActivityList()
    val size = activityList.size
    var curIndex = -1

    for (i in size - 1 downTo 0) {
        if (activityList[i] === curActivity) {
            curIndex = i - 1
            break
        }
    }
    if (curIndex >= 0) {
        if (curIndex == 0) {
            activityList.forEach {  }
            return
        }
        for (i in 0..curIndex) {

        }
        activityList.forEach { activity ->
            activity?.run {
                finish()
                if (!isLoadAnim) {
                    overridePendingTransition(0, 0)
                }
            }
        }
    }
}
