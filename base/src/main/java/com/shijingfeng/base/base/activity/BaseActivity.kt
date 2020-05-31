package com.shijingfeng.base.base.activity

import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.SkinAppCompatDelegateImpl
import com.blankj.utilcode.util.ActivityUtils
import com.shijingfeng.base.R
import com.shijingfeng.base.common.constant.FINISH_FRONT_ALL_ACTIVITY
import com.shijingfeng.base.common.constant.FINISH_PREVIOUS_ACTIVITY
import com.shijingfeng.base.util.finishPreviousActivity
import com.shijingfeng.base.util.getDrawableById
import com.shijingfeng.base.util.setStatusBarColor
import com.shijingfeng.base.util.setStatusBarContentColor
import skin.support.content.res.SkinCompatUserThemeManager


/**
 * Function: Activity 基类
 * Date: 2020/3/21 12:51
 * Description:
 * @author ShiJingFeng
 */
abstract class BaseActivity : AppCompatActivity() {

    /** 前一个 Activity 传过来的数据 或 Activity重启保存的 Bundle 数据(未来会加上) */
    protected var mDataBundle: Bundle? = null

    /** 前一个 Activity 是否销毁  */
    private var mIsPreActivityFinished = false

    /** 是否是第一次完成进入动画  true 是  false 否 */
    private var mIsFistEnterCompleted = true

    /**
     * 禁止子类覆盖，初始化操作请覆盖 [init]
     */
    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init(savedInstanceState)
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
                    finishPreviousActivity(this@BaseActivity)
                    mIsPreActivityFinished = true
                }
                //销毁前面所有的Activity
                if (finishFrontAll) {
                    // FIXME 万能工具类升级为 1.27.1 此处会有bug (for循环条件有问题，具体查看源码)
                    ActivityUtils.finishAllActivitiesExceptNewest(false)
                }
            }
        }
    }

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
     * 初始化状态栏
     */
    protected fun initStatusBar() {
        //设置默认状态栏背景颜色 为透明色
        setStatusBarColor(this, R.color.transparency)
        //设置默认状态栏字体颜色 为浅色
        setStatusBarContentColor(this, isSetStatusBarContentDark())
    }

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
    protected open fun isSetStatusBarContentDark() = false

    /**
     * 获取 状态栏 背景Drawable (不支持换肤)
     * @return 背景 Drawable
     */
    protected open fun getStatusBarBackgroundDrawable(): Drawable? = null

    /**
     * 获取 状态栏 背景资源 (支持换肤)
     */
    @DrawableRes
    protected open fun getStatusBarBackgroundResource(): Int = R.color.project_status_bar_default_color

    /**
     * 获取屏幕方向
     * @return 屏幕方向 (默认竖屏)
     */
    protected open fun getScreenOrientation() = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    /**
     * 获取 ContentView
     *
     * @return ContentView
     */
    fun getContentView(): ViewGroup = findViewById(android.R.id.content)

    /**
     * 跳转Activity页面
     * @param cls 要跳转到的页面反射Class
     * @param bundle 携带的数据
     * @param requestCode 请求码
     */
    fun startActivity(cls: Class<*>, bundle: Bundle? = null, requestCode: Int = -1) {
        startActivityForResult(Intent().apply {
            setClass(this@BaseActivity, cls)
            if (bundle != null) {
                putExtras(bundle)
            }
        }, requestCode)
    }

    /**
     * 关闭Activity (自定义 Activity 关闭动画)
     * @param enterAnim 前一个 Activity 进入动画
     * @param exitAnim 当前要销毁的 Activity 退出动画
     */
    fun finish(enterAnim: Int, exitAnim: Int) {
        finish()
        overridePendingTransition(enterAnim, exitAnim)
    }

    /**
     * 设置 皮肤切换框架 委托器
     */
    override fun getDelegate(): AppCompatDelegate {
        return SkinAppCompatDelegateImpl.get(this, this)
    }
}