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
import android.widget.*
import androidx.core.view.get
import androidx.core.widget.NestedScrollView
import com.shijingfeng.base.R
import com.shijingfeng.base.util.getStringById

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
        val DEFAULT_HINT_TEXT = getStringById(R.string.提交中)

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
     *
     * @param hintText 提示文本
     */
    @SuppressLint("InflateParams")
    fun show(
        hintText: String? = null
    ) {
        val hint = if (hintText.isNullOrEmpty()) {
            mAttr.hintText
        } else {
            hintText
        }

        if (isShowing()) {
            // 如果LoadingView正在显示, 则只更新提示文本
            mContentView.findViewById<TextView>(R.id.tv_text).text = hint
            return
        }

        if (mIsDestroyed) {
            mContentView = LayoutInflater.from(mAttr.context).inflate(
                R.layout.dialog_loading,
                null
            )
            mContentView.findViewById<TextView>(R.id.tv_text).text = hint
            startAnimator()
            mAttr.parent?.addView(mContentView, ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT))
            mIsDestroyed = false
        } else {
            mContentView.findViewById<TextView>(R.id.tv_text).text = hint
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
            this.mAttr.context = activity
            this.mAttr.parent = activity.findViewById(android.R.id.content)
        }

        constructor(view: View): this() {
            // 直接继承 Activity 的 Activity 构造出来的 View.getContext() 返回的是当前 Activity。
            // 但是当 View 的 Activity 是继承自 AppCompatActivity，并且在 5.0 以下版本的手机上，
            // View.getContext() 得到的并非是 Activity，而是 TintContextWrapper。
            this.mAttr.context = view.context
            if (view::class.java === FrameLayout::class.java) {
                this.mAttr.parent = view as ViewGroup
            } else {
                val parent = view.parent

                if (parent != null && parent is ViewGroup) {
                    if (parent::class.java === FrameLayout::class.java) {
                        this.mAttr.parent = parent
                    } else {
                        val frameLayout = FrameLayout(view.context)
                        val layoutParam = view.layoutParams
                        var childIndex = 0
                        val childCount = parent.childCount

                        for (i in 0 until childCount) {
                            if (parent.getChildAt(i) === view) {
                                childIndex = i
                                break
                            }
                        }
                        parent.removeView(view)
                        frameLayout.addView(view)
                        parent.addView(frameLayout, childIndex, layoutParam)
                        this.mAttr.parent = frameLayout
                    }
                }
            }
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

        /** Context */
        lateinit var context: Context
        /** 内容View 父View  */
        var parent: ViewGroup? = null
        /** 提示文本  */
        var hintText = DEFAULT_HINT_TEXT

    }

}