package com.shijingfeng.base.callback;

import java.lang.System;

/**
 * Function: 加载中 Callback
 * Date: 2020/1/18 18:10
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\u0006H\u0016J\u001a\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/shijingfeng/base/callback/LoadingCallback;", "Lcom/kingja/loadsir/callback/Callback;", "()V", "mAnimator", "Landroid/animation/ObjectAnimator;", "destroyAnimator", "", "onCreateView", "", "onDetach", "onViewCreate", "context", "Landroid/content/Context;", "view", "Landroid/view/View;", "startAnimator", "base_release"})
public final class LoadingCallback extends com.kingja.loadsir.callback.Callback {
    private android.animation.ObjectAnimator mAnimator;
    
    @java.lang.Override()
    protected int onCreateView() {
        return 0;
    }
    
    @java.lang.Override()
    protected void onViewCreate(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    /**
     * 销毁Callback
     */
    @java.lang.Override()
    public void onDetach() {
    }
    
    /**
     * 开始旋转动画
     */
    private final void startAnimator(android.view.View view) {
    }
    
    /**
     * 销毁旋转动画
     */
    private final void destroyAnimator() {
    }
    
    public LoadingCallback() {
        super();
    }
}