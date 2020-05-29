@file:JvmName("CodeConstant")
package com.shijingfeng.base.common.constant

/**
 * Function: Activity请求Code 和 权限请求Code 静态常量字符串
 * Date: 2020/1/18 19:01
 * Description:
 * @author ShiJingFeng
 */

/** Request Code: 相册  */
const val RESULT_PHOTO = 1
/** Request Code: 相机  */
const val RESULT_CAMERA = 2
/** Request Code: 裁剪  */
const val RESULT_CLIP = 3

/** Permission Code: 打开相机  */
const val PERMISSION_CAMERA = 1
/** Permission Code: 读写外部存储权限  */
const val PERMISSION_EXTERNAL_STORAGE = 2

/** PendingIntent 请求码: 检查更新 */
const val PENDING_CODE_CHECK_FOR_UPDATE = 1
/** PendingIntent 请求码: 取消应用更新 */
const val PENDING_CODE_CANCEL_APP_UPDATE = 2
/** PendingIntent 请求码: 玩Android Token 过期验证 */
const val PENDING_CODE_TOKEN_EXPIRE = 3