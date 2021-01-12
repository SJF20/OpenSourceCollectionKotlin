package com.shijingfeng.base.callback

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.view.View
import android.view.animation.LinearInterpolator
import com.kingja.loadsir.callback.Callback
import com.shijingfeng.base.R

/**
 * Function: 加载中 Callback
 * Date: 2020/1/18 18:10
 * Description:
 * Author: ShiJingFeng
 */
internal class LoadingCallback : Callback() {

    private var mAnimator: ObjectAnimator? = null

    override fun onCreateView() = R.layout.callback_loading

    override fun onViewCreate(context: Context?, view: View) {
        super.onViewCreate(context, view)
        startAnimator(view.findViewById<View>(R.id.iv_loading))
    }

    /**
     * 销毁Callback
     */
    override fun onDetach() {
        destroyAnimator()
        super.onDetach()
    }

    /**
     * 开始旋转动画
     */
    private fun startAnimator(view: View) {
        mAnimator = ObjectAnimator.ofFloat(view, "rotation", 0F, 360F)
        mAnimator?.run {
            interpolator = LinearInterpolator()
            duration = 1000
            repeatCount = ValueAnimator.INFINITE
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

}