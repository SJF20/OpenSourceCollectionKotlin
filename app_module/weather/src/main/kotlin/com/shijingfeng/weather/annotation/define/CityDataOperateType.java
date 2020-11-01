package com.shijingfeng.weather.annotation.define;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.shijingfeng.weather.common.constant.FlagConstant.*;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Function: 城市数据 操作类型
 * Date: 2020/11/1 12:47
 * Description:
 *
 * @author ShiJingFeng
 */
@IntDef({
    // 城市数据操作: 无操作
    CITY_DATA_OPERATE_NONE,
    // 城市数据操作: 添加单个或多个 或 插入单个或多个
    CITY_DATA_OPERATE_ADD,
    // 城市数据操作: 删除单个 或 多个
    CITY_DATA_OPERATE_REMOVE,
    // 城市数据操作: 清空数据
    CITY_DATA_OPERATE_CLEAR,
    // 城市数据操作: 更新单个 或 多个
    CITY_DATA_OPERATE_UPDATE,
    // 城市数据操作: 移动单个 或 多个
    CITY_DATA_OPERATE_MOVE,
    // 城市数据操作: 交换单个 或 多个
    CITY_DATA_OPERATE_SWAP
})
@Target({
    // 类属性
    FIELD,
    // 函数参数
    PARAMETER,
    // 局部变量
    LOCAL_VARIABLE
})
@Retention(SOURCE)
public @interface CityDataOperateType {}
