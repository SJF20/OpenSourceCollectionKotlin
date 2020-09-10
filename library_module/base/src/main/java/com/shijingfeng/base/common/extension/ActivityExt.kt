/** 生成的 Java 类名 */
@file:JvmName("ActivityExt")
package com.shijingfeng.base.common.extension

import android.app.Activity
import com.blankj.utilcode.util.ActivityUtils
import com.shijingfeng.base.util.e

/**
 * Function: Activity 相关 扩展函数
 * Date: 2020/9/10 13:26
 * Description:
 * @author ShiJingFeng
 */

/**
 * Activity 是否存活着
 * true: 存活着   false: 已死亡
 */
fun Activity?.isAlive(): Boolean {
    if (this != null && !this.isFinishing && !this.isDestroyed) {
        return true
    }
    return false
}

/**
 * 当前Activity的前一个Activity
 */
fun Activity?.previous(): Activity? {
    if (this === null) return null

    /** 和 Activity栈的顺序正好相反, 即 顶部Activity 位于 0索引 处*/
    val activityList = ActivityUtils.getActivityList()
    val size = activityList.size

    // Activity列表为空 或 当前Activity前面没有Activity
    if (activityList.isEmpty() || this === activityList[size - 1]) return null

    for (index in 0..(size - 2)) {
        val activity = activityList[index]

        if (this === activity) {
            return activityList[index + 1]
        }
    }
    return null
}

/**
 * 当前Activity的前面所有的Activity
 */
fun Activity?.previousAll(): List<Activity> {
    val resultActivityList = mutableListOf<Activity>()

    if (this === null) return resultActivityList

    /** 和 Activity栈的顺序正好相反, 即 顶部Activity 位于 0索引 处*/
    val activityList = ActivityUtils.getActivityList()
    val size = activityList.size

    // Activity列表为空 或 当前Activity前面没有Activity
    if (activityList.isEmpty() || this === activityList[size - 1]) return resultActivityList

    var tempIndex = -1

    for (index in 0..(size - 2)) {
        val activity = activityList[index]

        if (this === activity) {
            tempIndex = index + 1
            break
        }
    }
    if (tempIndex != -1 && tempIndex <= size - 2) {
        for (index in tempIndex..(size - 2)) {
            resultActivityList.add(activityList[index])
        }
    }
    return resultActivityList
}

/**
 * 当前Activity的前一个存活的Activity
 */
fun Activity?.previousAlive(): Activity? {
    if (this === null) return null

    /** 和 Activity栈的顺序正好相反, 即 顶部Activity 位于 0索引 处*/
    val activityList = ActivityUtils.getActivityList()
    val size = activityList.size

    // Activity列表为空 或 当前Activity前面没有Activity
    if (activityList.isEmpty() || this === activityList[size - 1]) return null

    var tempIndex = -1

    for (index in 0..(size - 2)) {
        val activity = activityList[index]

        if (this === activity) {
            val preActivity = activityList[index + 1]

            if (preActivity.isAlive()) {
                return preActivity
            } else {
                tempIndex = index + 2
                break
            }
        }
    }
    if (tempIndex != -1 && tempIndex <= size - 2) {
        for (index in tempIndex..(size - 2)) {
            val activity = activityList[index]

            if (activity.isAlive()) {
                return activity
            }
        }
    }
    return null
}

/**
 * 当前Activity的前一个存活的Activity
 */
fun Activity?.previousAliveAll(): List<Activity> {
    val resultActivityList = mutableListOf<Activity>()

    if (this === null) return resultActivityList

    /** 和 Activity栈的顺序正好相反, 即 顶部Activity 位于 0索引 处*/
    val activityList = ActivityUtils.getActivityList()
    val size = activityList.size

    // Activity列表为空 或 当前Activity前面没有Activity
    if (activityList.isEmpty() || this === activityList[size - 1]) return resultActivityList

    var tempIndex = -1

    for (index in 0..(size - 2)) {
        val activity = activityList[index]

        if (this === activity) {
            tempIndex = index + 1
        }
    }
    if (tempIndex != -1 && tempIndex <= size - 2) {
        for (index in tempIndex..(size - 2)) {
            val activity = activityList[index]

            if (activity.isAlive()) {
                resultActivityList.add(activity)
            }
        }
    }
    return resultActivityList
}

/**
 * 当前Activity的后一个Activity
 */
fun Activity?.next(): Activity? {
    if (this === null) return null

    /** 和 Activity栈的顺序正好相反, 即 顶部Activity 位于 0索引 处*/
    val activityList = ActivityUtils.getActivityList()
    val size = activityList.size

    // Activity列表为空 或 当前Activity后面没有Activity
    if (activityList.isEmpty() || this === activityList[0]) return null

    for (index in 1 until size) {
        val activity = activityList[index]

        if (this === activity) {
            return activityList[index - 1]
        }
    }
    return null
}

/**
 * 当前Activity的后一个存活的Activity
 */
fun Activity?.nextAlive(): Activity? {
    if (this === null) return null

    /** 和 Activity栈的顺序正好相反, 即 顶部Activity 位于 0索引 处*/
    val activityList = ActivityUtils.getActivityList()
    val size = activityList.size

    // Activity列表为空 或 当前Activity后面没有Activity
    if (activityList.isEmpty() || this === activityList[0]) return null

    var tempIndex = -1

    for (index in 1 until size) {
        val activity = activityList[index]

        if (this === activity) {
            val nextActivity = activityList[index - 1]

            if (nextActivity.isAlive()) {
                return nextActivity
            } else {
                tempIndex = index - 2
            }
        }
    }
    if (tempIndex != -1 && tempIndex >= 1) {
        for (index in 1..tempIndex) {
            val activity = activityList[index]

            if (activity.isAlive()) {
                return activity
            }
        }
    }
    return null
}

/**
 * 关闭Activity
 *
 * @param enterAnim 当前关闭的页面的前一个页面 进入动画 (0: 没有动画)
 * @param exitAnim 当前关闭的页面 退出动画 (0: 没有动画)
 */
fun Activity?.finish(
    enterAnim: Int = 0,
    exitAnim: Int = 0
) {
    if (this == null) return

    this.finish()
    this.overridePendingTransition(enterAnim, exitAnim)
}

/**
 * 杀死前一个Activity
 *
 * @param enterAnim 当前关闭的页面的前一个页面 进入动画 (0: 没有动画)
 * @param exitAnim 当前关闭的页面 退出动画 (0: 没有动画)
 */
fun Activity?.finishPrevious(
    enterAnim: Int = 0,
    exitAnim: Int = 0
) {
    this?.previous()?.run {
        if (isAlive()) {
            finish()
            overridePendingTransition(enterAnim, exitAnim)
        }
    }
}

/**
 * 杀死前面所有的Activity
 *
 * @param enterAnim 当前关闭的页面的前一个页面 进入动画 (0: 没有动画)
 * @param exitAnim 当前关闭的页面 退出动画 (0: 没有动画)
 */
fun Activity?.finishPreviousAll(
    enterAnim: Int = 0,
    exitAnim: Int = 0
) {
    this?.previousAliveAll()?.forEach { activity ->
        activity.run {
            finish()
            overridePendingTransition(enterAnim, exitAnim)
        }
    }
}

/**
 * 杀死后一个Activity
 *
 * @param enterAnim 当前关闭的页面的前一个页面 进入动画 (0: 没有动画)
 * @param exitAnim 当前关闭的页面 退出动画 (0: 没有动画)
 */
fun Activity?.finishNext(
    enterAnim: Int = 0,
    exitAnim: Int = 0
) {
    this?.next()?.run {
        if (isAlive()) {
            finish()
            overridePendingTransition(enterAnim, exitAnim)
        }
    }
}