package com.shijingfeng.todo.annotation.define;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.shijingfeng.todo.annotation.define.TodoChildType.ITEM_TYPE_IMAGE;
import static com.shijingfeng.todo.annotation.define.TodoChildType.ITEM_TYPE_TEXT;
import static com.shijingfeng.todo.annotation.define.TodoChildType.ITEM_TYPE_UNKNOWN;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Function:
 * Date: 2020/9/18 16:53
 * Description:
 *
 * @author ShiJingFeng
 */
@IntDef({
    // 默认不操作，为原来的 (用于EventBus Event)
    ITEM_TYPE_UNKNOWN,
    // 完成日期顺序 (升序)
    ITEM_TYPE_TEXT,
    // 完成日期逆序 (降序)
    ITEM_TYPE_IMAGE,
})
@Target({
    // 类属性
    FIELD,
    // 函数参数
    PARAMETER,
    // 局部变量
    LOCAL_VARIABLE,
    // 方法
    METHOD
})
@Retention(SOURCE)
public @interface TodoChildType {

    /** Item类型: 未知 */
    int ITEM_TYPE_UNKNOWN = 0;

    /** Item类型: 文本 */
    int ITEM_TYPE_TEXT = 1;

    /** Item类型: 图片 */
    int ITEM_TYPE_IMAGE = 2;

}
