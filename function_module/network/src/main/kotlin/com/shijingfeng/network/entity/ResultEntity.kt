package com.shijingfeng.network.entity

import com.google.gson.annotations.SerializedName

/**
 * Function: 请求服务器返回的结果
 * Date: 2020/2/4 16:08
 * Description:
 * @author ShiJingFeng
 */
data class ResultEntity<T>(

    /** 错误码 或 成功码  0: 成功 */
    @SerializedName("errorCode")
    val code: Int = 0,

    /** 错误信息 */
    @SerializedName("errorMsg")
    val msg: String = "",

    /** 数据 */
    @SerializedName("data")
    val data: T? = null

)