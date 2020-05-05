@file:JvmName("StatusConstant")
package com.shijingfeng.base.common.constant

/**
 * Function: 状态 静态常量
 * Author: ShiJingFeng
 * Date: 2019/12/7 14:12
 * Description:
 * @author ShiJingFeng
 */

/** LoadService状态: 成功  */
const val LOAD_SERVICE_SUCCESS = 0
/** LoadService状态: 加载中  */
const val LOAD_SERVICE_LOADING = 1
/** LoadService状态: 暂无数据  */
const val LOAD_SERVICE_EMPTY = 2
/** LoadService状态: 加载失败  */
const val LOAD_SERVICE_LOAD_FAIL = 3

/** 下拉刷新 和 上拉加载 无操作 */
const val REFRESH_LOAD_MORE_NONE = 0
/** 下拉刷新成功  */
const val REFRESH_SUCCESS = 1
/** 下拉刷新失败  */
const val REFRESH_FAIL = 2
/** 上拉加载成功  */
const val LOAD_MORE_SUCCESS = 3
/** 上拉加载失败  */
const val LOAD_MORE_FAIL = 4
/** 上拉加载已全部完成  */
const val LOAD_MORE_ALL = 5
