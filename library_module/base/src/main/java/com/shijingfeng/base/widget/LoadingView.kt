package com.shijingfeng.base.widget

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.animation.LinearInterpolator
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.shijingfeng.base.R

/**
 * Function: Loading View
 * Date: 2020/8/22 10:24
 * Description:
 * @author ShiJingFeng
 */
class LoadingView private constructor(
    private val mAttr: Attr
) {

    companion object {
        /** 默认提示 */
        const val DEFAULT_HINT_TEXT = "提交中..."
    }

    /** LoadingView内容布局View */
    private lateinit var mContentView: View
    /** 动画 */
    private var mAnimator: ObjectAnimator? = null

    /** LoadingView是否正在显示  true: 显示  false: 不显示 */
    private var mIsShowing = false
    /** LoadingView是否已销毁  true: 已销毁  false: 未销毁 */
    private var mIsDestroyed = true

    /**
     * 开始旋转动画
     */
    private fun startAnimator() {
        val ivLoading = mContentView.findViewById<ImageView>(R.id.iv_loading)

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
     * LoadingView 是否正在显示
     * @return true: 显示状态  false: 隐藏状态
     */
    fun isShowing() = mIsShowing

    /**
     * LoadingView 是否已经销毁
     * @return true: 已销毁  false: 未销毁
     */
    fun isDestroyed() = mIsDestroyed

    /**
     * 显示
     */
    @SuppressLint("InflateParams")
    fun show() {
        if (isShowing()) {
            // 如果LoadingView正在显示, 则只更新提示文本
            mContentView.findViewById<TextView>(R.id.tv_text).text = mAttr.hintText
            return
        }

        if (mIsDestroyed) {
            mContentView = LayoutInflater.from(mAttr.activity).inflate(R.layout.dialog_loading, null)
            mContentView.findViewById<TextView>(R.id.tv_text).text = mAttr.hintText
            startAnimator()
            mAttr.parent?.addView(mContentView, ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT))
            mIsDestroyed = false
        } else {
            mContentView.findViewById<TextView>(R.id.tv_text).text = mAttr.hintText
            startAnimator()
            mContentView.visibility = View.VISIBLE
        }
        mIsShowing = true
    }

    /**
     * 隐藏
     */
    fun hide() {
        if (!isShowing()) {
            // 如果已经隐藏, 则无效操作
            return
        }
        mContentView.visibility = View.GONE
        destroyAnimator()
        mIsShowing = false
    }

    /**
     * 销毁
     */
    fun destroy() {
        hide()
        if (this::mContentView.isInitialized) {
            mAttr.parent?.removeView(mContentView)
        }
        mIsDestroyed = true
    }

    /**
     * 构建器
     */
    class Builder private constructor() {
        private val mAttr = Attr()

        constructor(activity: Activity) : this() {
            this.mAttr.parent = activity.findViewById(android.R.id.content)
        }

        constructor(view: View): this() {
            val parent = view.parent

            if (parent is FrameLayout) {
                this.mAttr.parent = parent
            } else if (parent is ViewGroup) {

            }
        }

        init {
            mAttr.activity = activity
            mAttr.parent = parentViewGroup
        }

        /**
         * 设置提示文本
         * @param hintText 提示文本
         * @return Builder
         */
        fun setHintText(hintText: String?): Builder {
            if (!hintText.isNullOrEmpty()) {
                mAttr.hintText = hintText
            }
            return this
        }

        /**
         * 开始构建
         * @return LoadingView
         */
        fun build() = LoadingView(mAttr)

        /**
         * 显示 LoadingView
         * @return LoadingView
         */
        fun show() = LoadingView(mAttr).apply { show() }

    }

    /**
     * 属性数据
     */
    class Attr {

        lateinit var context: TargetContext

        /** 提示文本  */
        var hintText = DEFAULT_HINT_TEXT
    }

    class TargetContext {

        /** Context 环境 */
        lateinit var context: Context
        /** 内容View 父View  */
        lateinit var parent: ViewGroup
        /** 内容View */
        var content: View? = null
        /** 内容View 在 父View 中 所处的位置 */
        var childIndex: Int = 0

    }

}