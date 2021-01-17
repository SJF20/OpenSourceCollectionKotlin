package com.shijingfeng.skin_changer.manager

import android.app.Activity
import com.shijingfeng.skin_changer.global.addIfNotExist

/**
 * Function: Activity 管理器
 * Date: 2020/7/22 16:24
 * Description:
 * Author: ShiJingFeng
 */
internal class ActivityManager {

    private val mActivityList = mutableListOf<Activity>()

    /**
     * 添加Activity
     */
    fun add(activity: Activity) = mActivityList.add(activity)

    /**
     * 如果Activity列表中没有，则添加 Activity
     */
    fun addIfNotExist(activity: Activity) = mActivityList.addIfNotExist(activity)

    /**
     * Activity列表中是否包含此Activity
     */
    fun contain(activity: Activity) = mActivityList.contains(activity)

    /**
     * 删除Activity
     */
    fun remove(activity: Activity) = mActivityList.remove(activity)

    /**
     * 清空Activity列表
     */
    fun clear() = mActivityList.clear()

    /**
     * 获取Activity列表
     */
    fun getActivityList() = mActivityList

}