package com.shijingfeng.base.annotation.define;

import androidx.annotation.IntDef;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static com.shijingfeng.base.common.constant.StatusConstant.LOAD_SERVICE_EMPTY;
import static com.shijingfeng.base.common.constant.StatusConstant.LOAD_SERVICE_LOADING;
import static com.shijingfeng.base.common.constant.StatusConstant.LOAD_SERVICE_LOAD_FAIL;
import static com.shijingfeng.base.common.constant.StatusConstant.LOAD_SERVICE_SUCCESS;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Function: LoadService 状态 限定 (注意: 不要改为 Kotlin 注解, 否则乱输入不会提示)
 * Date: 20-4-7 下午9:58
 * Description:
 *
 * @author shijingfeng
 */
@IntDef({
    // LoadService状态: 成功
    LOAD_SERVICE_SUCCESS,
    // LoadService状态: 加载中
    LOAD_SERVICE_LOADING,
    // LoadService状态: 暂无数据
    LOAD_SERVICE_EMPTY,
    // LoadService状态: 加载失败
    LOAD_SERVICE_LOAD_FAIL
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
public @interface LoadServiceStatus {}
