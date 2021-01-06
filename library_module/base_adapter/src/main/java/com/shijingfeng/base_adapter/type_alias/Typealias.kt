/** 生成的 Java 类名 */
@file:JvmName("TypeAlias")
package com.shijingfeng.base_adapter.type_alias

import android.view.View

/**
 * Function: 类型别名
 * Date: 2021/1/6 14:55
 * Description:
 * @author ShiJingFeng
 */

/** 适配器事件监听回调 */
typealias onItemEvent = (view: View?, data: Any?, position: Int, flag: String) -> Unit

/** Fragment 创建 回调监听 */
typealias OnFragmentCreate<T> = (position: Int, fragment: T) -> Unit
/** Fragment 销毁 回调监听 */
typealias OnFragmentDestroy = (position: Int) -> Unit