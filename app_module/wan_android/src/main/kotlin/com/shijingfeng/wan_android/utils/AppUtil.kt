/** 生成的 Java 类名 */
@file:JvmName("AppUtil")
package com.shijingfeng.wan_android.utils

/**
 * Function: 应用相关 工具类
 * Date: 2020/5/25 12:28
 * Description:
 * Author: ShiJingFeng
 */

/**
 * 本地退出登录
 */
internal fun localLogout() {
    // 本地退出登录
    UserUtil.logout()
    // 删除积分信息
    CoinUtil.coinInfo = null
    // 停止 检查 玩Android Token 是否过期 定时器
    stopTokenExpireAlarm()
}