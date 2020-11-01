@file:JvmName("FlagConstant")
package com.shijingfeng.base.common.constant

/**
 * Function: 标志 静态常量
 * Author: ShiJingFeng
 * Date: 2019/12/27 16:51
 * Description:
 * @author ShiJingFeng
 */

/** SparseArray Key(int) Value(Integer) Activity setResult中的resultCode  */
const val KEY_RESULT_CODE = 1
/** SparseArray Key(int) Value(Intent) Activity setResult中的data  */
const val KEY_RESULT_DATA = 2
/** SparseArray Key(int) Value(Class) 要跳转到的 Class 对象  */
const val KEY_CLASS = 1
/** SparseArray Key(int) Value(Bundle) 跳转携带的数据  */
const val KEY_BUNDLE = 2
/** SparseArray Key(int) Value(Integer) 跳转请求码  */
const val KEY_REQUEST_CODE = 3
/** SparseArray Key(int) Value(String) 要跳转到的页面路径  */
const val KEY_PATH = 5
/** SparseArray Key(int) Value([com.alibaba.android.arouter.facade.callback.NavigationCallback]) 跳转页面回调接口  */
const val KEY_NAVIGATION_CALLBACK = 6
/** SparseArray Key(int) Value(int) overridePendingTransition() 中 enterAnim 方法参数  */
const val KEY_ENTER_ANIM = 7
/** SparseArray Key(int) Value(int) overridePendingTransition() 中 exitAnim 方法参数  */
const val KEY_EXIT_ANIM = 8
/** SparseArray Key(int) Value(SparseIntArray) SparseIntArray中携带 enterAnim 和 exitAnim  */
const val KEY_ANIM_SPARSE_ARRAY = 9
/** SparseArray Key(int) Value(int) LoadingView 资源ID  */
const val KEY_LOADING_VIEW_VIEW_ID = 10
/** SparseArray Key(int) Value(String) LoadingView 提示文本  */
const val KEY_LOADING_VIEW_HINT_TEXT = 11

/** Bundle Key(String) Value(String)  Activity跳转 上一个页面的 Activity Name  */
const val FROM_ACTIVITY_NAME = "fromActivityName"
/** Bundle Key(String) Value(String)  加载的URL链接  */
const val URL = "url"
/** Bundle Key(String) Value(String)  标题名称  */
const val TITLE = "title"
/** Bundle Key(String) Value(boolean)  是否需要登录  */
const val NEED_LOGIN = "need_login"
/** Bundle Key(String) Value(String)  数据  */
const val DATA = "data"
/** Bundle Key(String) Value(int)  当前位置  */
const val CURRENT_POSITION = "current_position"
/** Bundle Key(String) Value(boolean)  是否销毁 当前 Activity 前面的 Activity   */
const val FINISH_PREVIOUS_ACTIVITY = "finish_previous_activity"
/** Bundle Key(String) Value(boolean)  是否销毁 当前 Activity 前面的所有 Activity   */
const val FINISH_FRONT_ALL_ACTIVITY = "finish_front_all_activity"

/** OnItemEventListener 单击  */
const val CLICK = "click"
/** OnItemEventListener 长按  */
const val LONG_CLICK = "long_click"

/** 单选 选择 */
const val SELECTED = "selected"
/** 多选 选择 */
const val CHECKED = "checked"

/** HTTP协议前缀  */
const val PROTOCOL_HTTP = "http://"
/** HTTPS协议前缀  */
const val PROTOCOL_HTTPS = "https://"

/** 插入顺序：正序  */
const val ORDER_PLAIN = 0
/** 插入顺序：倒序  */
const val ORDER_REVERSED = 1

/** 数据操作类型：无操作 */
const val NONE = 0

/** 数据操作:  加载数据  */
const val LOAD = 1
/** 数据操作: 刷新数据  */
const val REFRESH = 2
/** 数据操作: 添加数据  */
const val ADD = 3
/** 数据操作: 插入数据  */
const val INSERT = 4
/** 数据操作: 删除数据  */
const val REMOVE = 5
/** 数据操作: 更新数据  */
const val UPDATE = 6
/** 数据操作: 清空 */
const val CLEAR = 7
/** 数据操作: 移动 */
const val MOVE = 8
/** 数据操作: 交换 */
const val SWAP = 9

/** 页面操作类型：加载数据  */
const val PAGE_OPERATE_TYPE_LOAD = 1
/** 页面操作类型: 重新加载数据 */
const val PAGE_OPERATE_TYPE_RELOAD = 4
/** 页面操作类型：下拉刷新  */
const val PAGE_OPERATE_TYPE_REFRESH = 2
/** 页面操作类型：上拉加载更多  */
const val PAGE_OPERATE_TYPE_LOAD_MORE = 3

/** 数据来源: 网络 */
const val DATA_SOURCE_NETWORK = 1
/** 数据来源: 本地 */
const val DATA_SOURCE_LOCAL = 2

/** Adapter Item 未知类型 */
const val ADAPTER_TYPE_UNKNOWN = 0
/** 没有布局 (用于Activity) */
const val NO_LAYOUT = 0