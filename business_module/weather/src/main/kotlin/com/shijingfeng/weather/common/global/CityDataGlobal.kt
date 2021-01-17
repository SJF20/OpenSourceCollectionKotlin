/** 生成的 Java 类名 */
@file:JvmName("CityDataGlobal")
package com.shijingfeng.weather.common.global

import com.shijingfeng.weather.data_structure.CityDataManager

/**
 * Function: 城市数据 Global
 * Date: 2020/10/29 13:34
 * Description:
 * Author: ShiJingFeng
 */

/** 城市数据列表包装类, 可以用于做适配器列表, 数据更新操作时该包装类会通过EventBus通知页面更新视图 */
internal var cityDataManager: CityDataManager? = null

