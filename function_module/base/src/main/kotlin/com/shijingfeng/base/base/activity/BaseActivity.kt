package com.shijingfeng.base.base.activity

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.shijingfeng.base.R
import com.shijingfeng.base.common.constant.FINISH_FRONT_ALL_ACTIVITY
import com.shijingfeng.base.common.constant.FINISH_PREVIOUS_ACTIVITY
import com.shijingfeng.base.common.kotlin_extension.finishPrevious
import com.shijingfeng.base.common.kotlin_extension.finishPreviousAll
import com.shijingfeng.base.util.getDrawableByColorId
import com.shijingfeng.base.util.setStatusBarColor
import com.shijingfeng.base.util.setStatusBarContentColor

/**
 * Function: Activity 基类
 * Date: 2020/3/21 12:51
 * Description:
 * Author: ShiJingFeng
 */
abstract class BaseActivity : AppCompatActivity() {

    /** 前一个 Activity 传过来的数据 或 Activity重启保存的 Bundle 数据(未来会加上) */
    protected var mDataBundle: Bundle? = null

    /** 前一个 Activity 是否销毁  */
    private var mIsPreActivityFinished = false

    /** 是否是第一次完成进入动画  true 是  false 否 */
    private var mIsFistEnterCompleted = true

    /** ContentView */
    val mContentView: ViewGroup by lazy { findViewById(android.R.id.content) }

    /**
     * 禁止子类覆盖，初始化操作请覆盖 [init]
     */
    final override fun onCreate(savedInstanceState: Bundle?) {
        onCreateBefore(savedInstanceState)
        super.onCreate(savedInstanceState)
        init(savedInstanceState)
    }

    /**
     * Activity处于前台且完全可见
     */
    override fun onStart() {
        super.onStart()
        initStatusBar()
    }

    /**
     * 初始化状态栏
     */
    open fun initStatusBar() {
        //设置默认状态栏背景颜色 为透明色
        setStatusBarColor(this, R.color.transparency)
        //设置默认状态栏字体颜色 为浅色
        setStatusBarContentColor(this, isStatusBarContentDark())
    }

    /**
     * Activity 进入动画 完成回调
     */
    override fun onEnterAnimationComplete() {
        super.onEnterAnimationComplete()
        if (mIsFistEnterCompleted) {
            mIsFistEnterCompleted = false
            mDataBundle?.run {
                val finishPrevious = getBoolean(FINISH_PREVIOUS_ACTIVITY, false)
                val finishFrontAll = getBoolean(FINISH_FRONT_ALL_ACTIVITY, false)

                //销毁前一个Activity
                if (finishPrevious && !mIsPreActivityFinished) {
                    this@BaseActivity.finishPrevious()
                    mIsPreActivityFinished = true
                }
                //销毁前面所有的Activity
                if (finishFrontAll) {
                    this@BaseActivity.finishPreviousAll()
                }
            }
        }
    }

    /**
     * 在 onCreate 方法执行前
     */
    protected open fun onCreateBefore(savedInstanceState: Bundle?) {}

    /**
     * 初始化
     */
    protected open fun init(savedInstanceState: Bundle?) {}

    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    @LayoutRes
    protected abstract fun getLayoutId(): Int

    /**
     * 初始化参数
     */
    protected open fun initParam() {
        mDataBundle = intent?.extras
    }

    /**
     * 初始化数据
     */
    protected open fun initData() {}

    /**
     * 初始化事件
     */
    protected open fun initAction() {}

    /**
     * 是否设置状态栏内容颜色为深色
     * @return true 深色  false 浅色
     */
    protected open fun isStatusBarContentDark() = false

    /**
     * 获取 Activity 背景
     */
    protected open fun getActivityBackground() = getDrawableByColorId(R.color.white)

    /**
     * 获取屏幕方向
     * @return 屏幕方向 (默认竖屏)
     */
    protected open fun getScreenOrientation() = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    /**
     * 跳转Activity页面
     * @param cls 要跳转到的页面反射Class
     * @param bundle 携带的数据
     * @param requestCode 请求码
     */
    fun startActivity(
        cls: Class<*>,
        bundle: Bundle? = null,
        requestCode: Int = -1
    ) = startActivityForResult(Intent().apply {
        setClass(this@BaseActivity, cls)
        if (bundle != null) {
            putExtras(bundle)
        }
    }, requestCode)

    /**
     * 关闭Activity (自定义 Activity 关闭动画)
     * @param enterAnim 前一个 Activity 进入动画
     * @param exitAnim 当前要销毁的 Activity 退出动画
     */
    fun finish(
        enterAnim: Int,
        exitAnim: Int
    ) {
        finish()
        overridePendingTransition(enterAnim, exitAnim)
    }

}