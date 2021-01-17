package com.shijingfeng.wan_android.base

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.databinding.ViewDataBinding
import com.shijingfeng.base.mvvm.fragment.BaseMvvmFragment
import com.shijingfeng.base.util.d
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.base.widget.StatusBarView
import com.shijingfeng.skin_changer.constant.BACK_GROUND
import com.shijingfeng.skin_changer.entity.SkinAttribute
import com.shijingfeng.skin_changer.interfaces.ISkinChanger
import com.shijingfeng.skin_changer.util.setResource
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.common.global.skinChangerManager

/**
 * Function: wan_android 模块 Fragment 基类
 * Date: 2020/2/3 14:22
 * Description:
 * Author: ShiJingFeng
 */
internal abstract class WanAndroidBaseFragment<V : ViewDataBinding, VM : WanAndroidBaseViewModel<*>> : BaseMvvmFragment<V, VM>(), ISkinChanger {

    /**
     * 因为有懒加载的缘故 子类初始化需要时重载init方法，禁止重载onViewCreated方法进行添加额外的初始化方法
     */
    override fun init(savedInstanceState: Bundle?) {
        d("页面", "wan_android 模块: " + this.javaClass.simpleName)
        super.init(savedInstanceState)
    }

    override fun initData() {
        super.initData()
        //设置状态栏高度
        if (!isSetCustomStatusBar() && activity != null && mRootView != null) {
            val contentView = mRootView!!
            val statusBarView = StatusBarView(requireActivity()).apply {
                id = R.id.status_bar_view
                setResource(this, listOf(
                    SkinAttribute(
                        name = BACK_GROUND,
                        data = getStringById(R.string.color_id_wan_android_theme_color)
                    )
                ))
            }

            when (contentView) {
                is LinearLayout -> contentView.addView(statusBarView, 0)
                is FrameLayout -> {
                    contentView.addView(statusBarView)
                    statusBarView.layoutParams = (statusBarView.layoutParams as FrameLayout.LayoutParams).apply {
                        gravity = Gravity.TOP
                    }
                }
                else -> {
                    val parent = contentView.parent as ViewGroup?

                    if (parent != null) {
                        parent.removeAllViews()
                        LinearLayout(activity).run {
                            orientation = LinearLayout.VERTICAL
                            addView(statusBarView)
                            addView(contentView)
                            parent.addView(this)
                            layoutParams = layoutParams.apply {
                                width = ViewGroup.LayoutParams.MATCH_PARENT
                                height = ViewGroup.LayoutParams.MATCH_PARENT
                            }
                        }
                    }
                }
            }
        }

        val flCommonTitleBar = mRootView?.findViewById<View>(R.id.fl_common_title_bar)

        // 设置标题栏背景颜色
        flCommonTitleBar?.run {
            setResource(this, listOf(
                SkinAttribute(
                    name = BACK_GROUND,
                    data = getStringById(R.string.color_id_wan_android_theme_color)
                )
            ))
        }

        // 更新皮肤
        skinChangerManager.update(this)
    }

    /**
     * 滑动到顶部
     */
    open fun scrollToTop() {}

    /**
     * 获取资源 (用于切换主题的资源)
     */
    override fun getResource(): Map<View, List<SkinAttribute>>? = null

}