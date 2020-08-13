package com.shijingfeng.background_service.entity

import com.google.gson.annotations.SerializedName

/**
 * Function: 请求服务器返回的结果
 * Date: 2020/2/4 16:08
 * Description:
 * @author ShiJingFeng
 */
internal data class ResultEntity<T>(

    /** 错误码 或 成功码 */
    @SerializedName("code")
    val code: Int = 0,

    /** 错误信息 */
    @SerializedName("message")
    val msg: String = "",

    /** 数据 */
    @SerializedName("data")
    val data: T? = null

)