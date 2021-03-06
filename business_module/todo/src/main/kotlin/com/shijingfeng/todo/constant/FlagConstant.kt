/** 生成的 Java 类名 */
@file:JvmName("FlagConstant")
package com.shijingfeng.todo.constant

/**
 * Function: Todo模块 全局静态常量
 * Date: 2020/5/19 21:00
 * Description:
 * Author: ShiJingFeng
 */

/** OnItemEventListener Flag: TabLayout可见性  */
internal const val TAB_LAYOUT_VISIBILITY = "tab_layout_visibility"
/** OnItemEventListener Flag: 查看 待办事项 详情 */
internal const val VIEW_TODO_DETAIL = "view_todo_detail"
/** OnItemEventListener Flag: 查看原图 */
internal const val VIEW_ORIGINAL_IMAGE = "view_original_image"
/** OnItemEventListener Flag: 删除 Item */
internal const val REMOVE_ITEM = "remove_item"
/** OnItemEventListener Flag: 标记完成 */
internal const val TODO_COMPLETED = "todo_completed"
/** OnItemEventListener Flag: 撤回 */
internal const val TODO_RECALL = "todo_recall"

/** Bundle Key(String) Value(int) 页面类型 */
internal const val PAGE_TYPE = "page_type"
/** Bundle Key(String) Value(String) TodoChild列表序列化后的字符串 */
internal const val TODO_CHILD_LIST_STR = ""

/** Map Key(String) Value(int) 状态 */
internal const val STATUS = "status"
/** Map Key(String) Value(int) 类型 */
internal const val TYPE = "type"
/** Map Key(String) Value(int) 优先级 */
internal const val PRIORITY = "priority"
/** Map Key(String) Value(int) 排序 */
internal const val ORDER_BY = "orderby"
/** Map Key(String) Value(int) 日期 */
internal const val DATE = "date"

/** 状态: 待办 */
internal const val STATUS_NEED_TO_DO = 0
/** 状态: 已完成 */
internal const val STATUS_DONE = 1

/** 待办事项类型: 默认不操作，为原来的 (用于EventBus Event) */
internal const val TYPE_NONE = -1
/** 待办事项类型: 无分类 全部 */
internal const val TYPE_ALL = 0
/** 待办事项类型: 学习 */
internal const val TYPE_STUDY = 1
/** 待办事项类型: 生活 */
internal const val TYPE_LIFE = 2
/** 待办事项类型: 工作 */
internal const val TYPE_WORK = 3

/** 优先级: 默认不操作，为原来的 (用于EventBus Event) */
internal const val PRIORITY_NONE = -1
/** 优先级: 所有 */
internal const val PRIORITY_ALL = 0
/** 优先级: 重要 紧急 */
internal const val PRIORITY_IMPORTANT_URGENCY = 1
/** 优先级: 重要 不紧急 */
internal const val PRIORITY_IMPORTANT_NOT_URGENCY = 2
/** 优先级: 不重要 紧急 */
internal const val PRIORITY_NOT_IMPORTANT_URGENCY = 3
/** 优先级: 不重要 不紧急 */
internal const val PRIORITY_NOT_IMPORTANT_NOT_URGENCY = 4

/** 排序: 默认不操作，为原来的 (用于EventBus Event) */
internal const val ORDER_BY_NONE = 0
/** 排序: 完成日期顺序 (升序) */
internal const val ORDER_BY_COMPLETE_DATE_ASC = 1
/** 排序: 完成日期逆序 (降序) */
internal const val ORDER_BY_COMPLETE_DATE_DESC = 2
/** 排序: 创建日期顺序 (升序) */
internal const val ORDER_BY_CREATE_DATE_ASC = 3
/** 排序: 创建日期逆序 (降序) */
internal const val ORDER_BY_CREATE_DATE_DESC = 4

/** 添加待办事项 */
internal const val TODO_ADD = 0
/** 更新待办事项 */
internal const val TODO_UPDATE = 1

/** Json字段名: type */
internal const val JSON_FIELD_TYPE = "type"
/** Json字段名: data */
internal const val JSON_FIELD_DATA = "data"