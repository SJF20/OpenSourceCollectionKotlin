/** 生成的 Java 类名 */
@file:JvmName("AppUtil")
package com.shijingfeng.wan_android.utils

/**
 * Function: 应用相关 工具类
 * Date: 2020/5/25 12:28
 * Description:
 * @author ShiJingFeng
 */

/**
 * 本地退出登录
 */
fun localLogout() {
    // 本地退出登录
    UserUtil.logout()
    // 删除积分信息
    CoinUtil.coinInfo = null
}