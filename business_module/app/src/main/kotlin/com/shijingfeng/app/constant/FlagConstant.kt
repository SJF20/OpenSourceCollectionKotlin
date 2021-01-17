@file:JvmName("FlagConstant")
package com.shijingfeng.app.constant

/**
 * Function: 标志 相关 静态字符串
 * Date: 2020/5/24 16:51
 * Description:
 * Author: ShiJingFeng
 */

/** Bundle Key(String) Value(String)  获取最新版本信息 实体类 序列化字符串 */
internal const val NEWEST_APP_INFO_STR = "newest_app_info_str"

/** Broadcast Receiver 操作标志 */
internal const val RECEIVER_FLAG = "receiver_flag"

/** [RECEIVER_FLAG] 显示应用更新提示对话框 */
internal const val SHOW_APP_UPDATE_HINT_DIALOG = "show_app_update_hint_dialog"
/** [RECEIVER_FLAG] 取消应用下载 */
internal const val CANCEL_APP_DOWNLOAD = "cancel_app_download"