package com.shijingfeng.base.widget

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import com.shijingfeng.base.R

/**
 * Function:
 * Date: 2020/8/22 10:24
 * Description:
 * @author ShiJingFeng
 */
class LoadingView(
    private val mAttr: Attr
) {

    companion object {
        /** 默认提示 */
        const val DEFAULT_HINT_TEXT = "提交中..."
    }

    /** LoadingView内容布局View */
    private val mContentView: View? = null
    /** 动画 */
    private var mAnimator: ObjectAnimator? = null

    /** 当前控件是否显示 true: 显示  false: 不显示 */
    private val mIsShowing = false

    /**
     * 开始旋转动画
     */
    private fun startAnimator() {
        val ivLoading: ImageView = mContentView?.findViewById(R.id.iv_loading) ?: return

        mAnimator = ObjectAnimator.ofFloat(
            ivLoading,
            "rotation",
            0f,
            360f
        ).apply {
            // 设置线性插值器
            interpolator = LinearInterpolator()
            // 旋转周期时间为1秒
            duration = 1000
            // 设置为无线循环
            repeatCount = ValueAnimator.INFINITE
            // 开始动画
            start()
        }
    }

    /**
     * 销毁旋转动画
     */
    private fun destroyAnimator() {
        mAnimator?.cancel()
        mAnimator = null
    }

    /**
     * 当前控件是否正在显示
     * @return true: 显示状态  false: 隐藏状态
     */
    fun isShowing() = mIsShowing

    /**
     * 显示
     */
    fun show() {

    }

    /**
     * 隐藏
     */
    fun hide() {

    }

    /**
     * 构建器
     */
    class Builder(
        activity: Activity
    ) {
        private val mAttr = Attr()

        init {
            mAttr.activity = activity
        }

        /**
         * 设置 父容器
         * @param parentViewGroup 父容器
         * @return Builder
         */
        fun setParentViewGroup(parentViewGroup: ViewGroup): Builder {
            mAttr.parentViewGroup = parentViewGroup
            return this
        }

        /**
         * 设置提示文本
         * @param hintText 提示文本
         * @return Builder
         */
        fun setHintText(hintText: String?): Builder {
            if (hintText.isNullOrEmpty()) {
                mAttr.hintText = DEFAULT_HINT_TEXT
            } else {
                mAttr.hintText = hintText
            }
            return this
        }

        /**
         * 开始构建
         * @return LoadingView
         */
        fun build(): LoadingView {
            return LoadingView(mAttr)
        }

        /**
         * 显示 LoadingView
         * @return LoadingView
         */
        fun show(): LoadingView {
            val loadingView = LoadingView(mAttr)
            loadingView.show()
            return loadingView
        }

    }

    /**
     * 属性数据
     */
    class Attr {

        /** Activity环境  */
        lateinit var activity: Activity
        /** 父容器  */
        var parentViewGroup: ViewGroup? = null
        /** 提示文本  */
        var hintText: String? = null

    }

}