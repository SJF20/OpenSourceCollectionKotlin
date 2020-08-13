package com.shijingfeng.skin_changer.entity

/**
 * Function: 对应 xml 中的 属性
 * Date: 2020/7/22 13:28
 * Description:
 * @author ShiJingFeng
 */
data class SkinAttribute(
    /** 属性名 */
    val name: String,
    /** 数据 (例如资源名字符串，自定义构造的资源数据结构) */
    val data: Any
)