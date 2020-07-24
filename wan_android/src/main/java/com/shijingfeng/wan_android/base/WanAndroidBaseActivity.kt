package com.shijingfeng.wan_android.base

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.databinding.ViewDataBinding
import com.shijingfeng.base.base.activity.BaseMvvmActivity
import com.shijingfeng.base.util.d
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.base.widget.StatusBarView
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.common.global.skinChangerManager

/**
 * Function: wan_android 模块 Activity 基类
 * Date: 2020/2/3 14:22
 * Description:
 * @author ShiJingFeng
 */
internal abstract class WanAndroidBaseActivity<V : ViewDataBinding, VM : WanAndroidBaseViewModel<*>> : BaseMvvmActivity<V, VM>() {

    /**
     * 初始化
     */
    override fun init(savedInstanceState: Bundle?) {
        super.init(savedInstanceState)
        d("页面", "wan_android 模块: " + this.javaClass.simpleName)
        skinChangerManager.register(this)
    }

    /**
     * 初始化数据
     */
    override fun initData() {
        super.initData()
        //Activity默认背景为白色
        getContentView().setBackgroundResource(R.color.white)
        //设置状态栏背景色和高度
        if (!isSetCustomStatusBar()) {
            val contentView = getContentView()
            val statusBarView = StatusBarView(this).apply {
                id = R.id.status_bar_view
                tag = getStringById(R.string.wan_android_theme_color_background)
            }

            if (contentView.childCount > 0) {
                when (val userContentView = contentView.getChildAt(0)) {
                    is LinearLayout -> userContentView.addView(statusBarView, 0)
                    is FrameLayout -> {
                        userContentView.addView(statusBarView)
                        statusBarView.layoutParams = (statusBarView.layoutParams as FrameLayout.LayoutParams).apply {
                            gravity = Gravity.TOP
                        }
                    }
                    else -> {
                        contentView.removeAllViews()
                        LinearLayout(this).run {
                            orientation = LinearLayout.VERTICAL
                            addView(statusBarView)
                            addView(userContentView)
                            contentView.addView(this)
                            layoutParams = layoutParams.apply {
                                width = ViewGroup.LayoutParams.MATCH_PARENT
                                height = ViewGroup.LayoutParams.MATCH_PARENT
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 是否自定义设置状态栏
     * @return true 自定义设置  false 默认设置
     */
    protected open fun isSetCustomStatusBar() = false

    /**
     * Activity销毁回调
     */
    override fun onDestroy() {
        skinChangerManager.unregister(this)
        super.onDestroy()
    }
}