package com.shijingfeng.base.annotation.define;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.shijingfeng.base.common.constant.FlagConstant.ADD;
import static com.shijingfeng.base.common.constant.FlagConstant.CLEAR;
import static com.shijingfeng.base.common.constant.FlagConstant.INSERT;
import static com.shijingfeng.base.common.constant.FlagConstant.LOAD;
import static com.shijingfeng.base.common.constant.FlagConstant.MOVE;
import static com.shijingfeng.base.common.constant.FlagConstant.NONE;
import static com.shijingfeng.base.common.constant.FlagConstant.REFRESH;
import static com.shijingfeng.base.common.constant.FlagConstant.REMOVE;
import static com.shijingfeng.base.common.constant.FlagConstant.SWAP;
import static com.shijingfeng.base.common.constant.FlagConstant.UPDATE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Function: 数据操作 限定 (注意: 不要改为 Kotlin 注解, 否则乱输入不会提示)
 * Date: 20-4-7 下午10:27
 * Description:
 *
 * @author shijingfeng
 */
@IntDef({
    // 数据操作：无操作
    NONE,
    // 数据操作: 加载数据
    LOAD,
    // 数据操作: 刷新数据
    REFRESH,
    // 数据操作: 添加数据
    ADD,
    // 数据操作: 插入数据
    INSERT,
    // 数据操作: 删除数据
    REMOVE,
    // 数据操作: 更新数据
    UPDATE,
    // 数据操作: 清空
    CLEAR,
    // 数据操作: 移动
    MOVE,
    // 数据操作: 交换
    SWAP
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
public @interface DataOperateType {}
