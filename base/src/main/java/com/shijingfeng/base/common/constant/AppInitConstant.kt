@file:JvmName("AppInitConstant")
package com.shijingfeng.base.common.constant

/**
 * Function: 各个模块 应用初始化 (通过反射方式 (其实通过注解执行器更好，只不过很麻烦))
 * Date: 2020/5/25 21:52
 * Description:
 * @author ShiJingFeng
 */

/** 初始化的类名 */
private const val CLASS_SIMPLE_NAME = "ModuleAppInit"

/** app 模块 应用初始化类 全限定类名 */
const val APP_INIT_APP = "$PACKAGE_NAME_APP.$CLASS_SIMPLE_NAME"
/** wan_android 模块 应用初始化类 全限定类名 */
const val APP_INIT_WAN_ANDROID = "$PACKAGE_NAME_WAN_ANDROID.$CLASS_SIMPLE_NAME"
/** todo模块 应用初始化类 全限定类名 */
const val APP_INIT_TODO = "$PACKAGE_NAME_TODO.$CLASS_SIMPLE_NAME"
/** tencent_x5 模块 应用初始化类 全限定类名 */
const val APP_INIT_TENCENT_X5 = "$PACKAGE_NAME_TENCENT_X5.$CLASS_SIMPLE_NAME"
/** background_service 模块 应用初始化类 全限定类名 */
const val APP_INIT_BACKGROUND_SERVICE = "$PACKAGE_NAME_BACKGROUND_SERVICE.$CLASS_SIMPLE_NAME"
/** common 模块 应用初始化类 全限定类名 */
const val APP_INIT_COMMON = "$PACKAGE_NAME_COMMON.$CLASS_SIMPLE_NAME"