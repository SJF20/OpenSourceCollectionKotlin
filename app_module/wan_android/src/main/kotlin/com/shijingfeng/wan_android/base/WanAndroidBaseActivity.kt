package com.shijingfeng.wan_android.base

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.databinding.ViewDataBinding
import com.shijingfeng.base.mvvm.activity.BaseMvvmActivity
import com.shijingfeng.base.util.d
import com.shijingfeng.base.util.getDrawableByColorId
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.base.widget.StatusBarView
import com.shijingfeng.skin_changer.constant.BACK_GROUND
import com.shijingfeng.skin_changer.entity.SkinAttribute
import com.shijingfeng.skin_changer.interfaces.ISkinChanger
import com.shijingfeng.skin_changer.util.setResource
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.common.global.skinChangerManager

/**
 * Function: wan_android 模块 Activity 基类
 * Date: 2020/2/3 14:22
 * Description:
 * @author ShiJingFeng
 */
internal abstract class WanAndroidBaseActivity<V : ViewDataBinding, VM : WanAndroidBaseViewModel<*>> : BaseMvvmActivity<V, VM>(), ISkinChanger {

    /**
     * 初始化
     */
    override fun init(savedInstanceState: Bundle?) {
        super.init(savedInstanceState)
        d("页面", "wan_android 模块: " + this.javaClass.simpleName)
    }

    /**
     * 初始化数据
     */
    override fun initData() {
        super.initData()
        //设置状态栏背景色和高度
        if (!isCustomStatusBar()) {
            val contentView = mContentView
            val statusBarView = StatusBarView(this).apply {
                id = R.id.status_bar_view
                setResource(this, listOf(
                    SkinAttribute(
                        name = BACK_GROUND,
                        data = getStringById(R.string.color_id_wan_android_theme_color)
                    )
                ))
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

        val flCommonTitleBar = if (isDataBindingInitialized()) {
            mDataBinding.root.findViewById<View>(R.id.include_title_bar)
        } else {
            null
        }

        // 设置标题栏背景颜色
        flCommonTitleBar?.run {
            setResource(this, listOf(
                SkinAttribute(
                    name = BACK_GROUND,
                    data = getStringById(R.string.color_id_wan_android_theme_color)
                )
            ))
        }

        // 注册皮肤更换框架
        skinChangerManager.register(this)
    }

    /**
     * 是否自定义设置状态栏
     * @return true 自定义设置  false 默认设置
     */
    protected open fun isCustomStatusBar() = false

    /**
     * 获取资源 (用于切换主题的资源)
     */
    override fun getResource(): Map<View, List<SkinAttribute>>? = null

    /**
     * Activity销毁回调
     */
    override fun onDestroy() {
        skinChangerManager.unregister(this)
        super.onDestroy()
    }
}