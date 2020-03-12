package com.shijingfeng.base.util

import android.text.TextUtils
import com.blankj.utilcode.util.EncryptUtils
import java.nio.charset.StandardCharsets

/**
 * Function: 安全 工具类
 * Date: 2020/2/2 21:28
 * Description:
 * @author ShiJingFeng
 */

/** 仅支持16位密码  */
private val KEY_BYTE_ARRAY = "w7kqxCbW13IN3LG9".toByteArray()
private const val TRANSFORMATION = "AES/CBC/PKCS5Padding"
/** 16位向量  */
private val IV_BYTE_ARRAY = "FEE7qJlMkRYiXzkB".toByteArray()

/**
 * 加密数据
 * @param str 要加密的数据
 */
fun encrypt(str: String): String {
    if (TextUtils.isEmpty(str)) {
        return str
    }
    val encryptByteArray: ByteArray = EncryptUtils.encryptAES2Base64(
        str.toByteArray(StandardCharsets.UTF_8),
        KEY_BYTE_ARRAY,
        TRANSFORMATION,
        IV_BYTE_ARRAY
    )

    return String(encryptByteArray, StandardCharsets.UTF_8)
}

/**
 * 解密数据
 * @param str 要解密的数据
 */
fun decrypt(str: String): String {
    if (TextUtils.isEmpty(str)) {
        return str
    }
    val decryptByteArray = EncryptUtils.decryptBase64AES(
        str.toByteArray(StandardCharsets.UTF_8),
        KEY_BYTE_ARRAY,
        TRANSFORMATION,
        IV_BYTE_ARRAY
    )
    return String(decryptByteArray, StandardCharsets.UTF_8)
}