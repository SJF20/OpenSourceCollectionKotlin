package com.shijingfeng.base.annotation.define;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.shijingfeng.base.common.constant.FlagConstant.NONE;
import static com.shijingfeng.base.common.constant.FlagConstant.PAGE_OPERATE_TYPE_LOAD;
import static com.shijingfeng.base.common.constant.FlagConstant.PAGE_OPERATE_TYPE_LOAD_MORE;
import static com.shijingfeng.base.common.constant.FlagConstant.PAGE_OPERATE_TYPE_REFRESH;
import static com.shijingfeng.base.common.constant.FlagConstant.PAGE_OPERATE_TYPE_RELOAD;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Function: 页面操作 限定 (注意: 不要改为 Kotlin 注解, 否则乱输入不会提示)
 * Date: 20-4-7 下午10:37
 * Description:
 *
 * Author: shijingfeng
 */
@IntDef({
    // 数据操作类型：无操作
    NONE,
    // 页面操作类型：加载数据
    PAGE_OPERATE_TYPE_LOAD,
    // 页面操作类型: 重新加载数据
    PAGE_OPERATE_TYPE_RELOAD,
    // 页面操作类型：下拉刷新
    PAGE_OPERATE_TYPE_REFRESH,
    // 页面操作类型：上拉加载更多
    PAGE_OPERATE_TYPE_LOAD_MORE,
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
public @interface PageOperateType {}
