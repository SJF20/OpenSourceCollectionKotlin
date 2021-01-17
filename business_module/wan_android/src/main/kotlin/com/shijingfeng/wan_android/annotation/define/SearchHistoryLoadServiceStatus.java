package com.shijingfeng.wan_android.annotation.define;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.shijingfeng.wan_android.common.constant.StatusConstant.LOAD_SERVICE_SEARCH_HISTORY_EMPTY;
import static com.shijingfeng.wan_android.common.constant.StatusConstant.LOAD_SERVICE_SEARCH_HISTORY_LOADING;
import static com.shijingfeng.wan_android.common.constant.StatusConstant.LOAD_SERVICE_SEARCH_HISTORY_LOAD_FAIL;
import static com.shijingfeng.wan_android.common.constant.StatusConstant.LOAD_SERVICE_SEARCH_HISTORY_SUCCESS;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Function: 搜索历史 LoadService 状态 限定 (注意: 不要改为 Kotlin 注解, 否则乱输入不会提示)
 * Date: 20-5-4 下午2:37
 * Description:
 *
 * Author: shijingfeng
 */
@IntDef({
    // 搜索历史 LoadService状态: 成功
    LOAD_SERVICE_SEARCH_HISTORY_SUCCESS,
    // 搜索历史 LoadService状态: 加载中
    LOAD_SERVICE_SEARCH_HISTORY_LOADING,
    // 搜索历史 LoadService状态: 暂无数据
    LOAD_SERVICE_SEARCH_HISTORY_EMPTY,
    // 搜索历史 LoadService状态: 加载失败
    LOAD_SERVICE_SEARCH_HISTORY_LOAD_FAIL
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
public @interface SearchHistoryLoadServiceStatus {}
