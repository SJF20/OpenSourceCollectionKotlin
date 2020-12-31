package com.shijingfeng.base.annotation.define;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.shijingfeng.base.common.constant.StatusConstant.LOAD_MORE_ALL;
import static com.shijingfeng.base.common.constant.StatusConstant.LOAD_MORE_FAIL;
import static com.shijingfeng.base.common.constant.StatusConstant.LOAD_MORE_SUCCESS;
import static com.shijingfeng.base.common.constant.StatusConstant.REFRESH_FAIL;
import static com.shijingfeng.base.common.constant.StatusConstant.REFRESH_LOAD_MORE_NONE;
import static com.shijingfeng.base.common.constant.StatusConstant.REFRESH_SUCCESS;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Function: 下拉刷新 上拉加载 状态 限定 (注意: 不要改为 Kotlin 注解, 否则乱输入不会提示)
 * Date: 20-4-7 下午11:20
 * Description:
 *
 * @author ShiJingFeng
 * @author shijingfeng
 */
@IntDef({
    /** 下拉刷新 和 上拉加载 无操作 */
    REFRESH_LOAD_MORE_NONE,
    // 下拉刷新成功
    REFRESH_SUCCESS,
    // 下拉刷新失败
    REFRESH_FAIL,
    // 上拉加载成功
    LOAD_MORE_SUCCESS,
    // 上拉加载失败
    LOAD_MORE_FAIL,
    // 上拉加载已全部完成
    LOAD_MORE_ALL,
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
public @interface RefreshLoadMoreStatus {}
