package com.shijingfeng.base.base.activity;

import java.lang.System;

/**
 * Function: Activity 基类
 * Date: 2020/3/21 12:51
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u000fH%J\b\u0010\u0014\u001a\u00020\u000fH\u0014J\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\u0017\u001a\u00020\rH\u0014J\b\u0010\u0018\u001a\u00020\rH\u0014J\b\u0010\u0019\u001a\u00020\rH\u0014J\b\u0010\u001a\u001a\u00020\rH\u0004J\b\u0010\u001b\u001a\u00020\nH\u0014J\u0012\u0010\u001c\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0004J\b\u0010\u001d\u001a\u00020\rH\u0016J(\u0010\u001e\u001a\u00020\r2\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\"\u001a\u00020\u000fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/shijingfeng/base/base/activity/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "mDataBundle", "Landroid/os/Bundle;", "getMDataBundle", "()Landroid/os/Bundle;", "setMDataBundle", "(Landroid/os/Bundle;)V", "mIsFistEnterCompleted", "", "mIsPreActivityFinished", "finish", "", "enterAnim", "", "exitAnim", "getContentView", "Landroid/view/ViewGroup;", "getLayoutId", "getScreenOrientation", "init", "savedInstanceState", "initAction", "initData", "initParam", "initStatusBar", "isSetStatusBarContentDark", "onCreate", "onEnterAnimationComplete", "startActivity", "cls", "Ljava/lang/Class;", "bundle", "requestCode", "base_release"})
public abstract class BaseActivity extends androidx.appcompat.app.AppCompatActivity {
    
    /**
     * 前一个 Activity 传过来的数据 或 Activity重启保存的 Bundle 数据(未来会加上)
     */
    @org.jetbrains.annotations.Nullable()
    private android.os.Bundle mDataBundle;
    
    /**
     * 前一个 Activity 是否销毁
     */
    private boolean mIsPreActivityFinished = false;
    
    /**
     * 是否是第一次完成进入动画  true 是  false 否
     */
    private boolean mIsFistEnterCompleted = true;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    protected final android.os.Bundle getMDataBundle() {
        return null;
    }
    
    protected final void setMDataBundle(@org.jetbrains.annotations.Nullable()
    android.os.Bundle p0) {
    }
    
    /**
     * 禁止子类覆盖，初始化操作请覆盖 [init]
     */
    @java.lang.Override()
    protected final void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * Activity 进入动画 完成回调
     */
    @java.lang.Override()
    public void onEnterAnimationComplete() {
    }
    
    /**
     * 初始化
     */
    protected void init(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    @androidx.annotation.LayoutRes()
    protected abstract int getLayoutId();
    
    /**
     * 初始化状态栏
     */
    protected final void initStatusBar() {
    }
    
    /**
     * 初始化参数
     */
    protected void initParam() {
    }
    
    /**
     * 初始化数据
     */
    protected void initData() {
    }
    
    /**
     * 初始化事件
     */
    protected void initAction() {
    }
    
    /**
     * 是否设置状态栏内容颜色为深色
     * @return true 深色  false 浅色
     */
    protected boolean isSetStatusBarContentDark() {
        return false;
    }
    
    /**
     * 获取屏幕方向
     * @return 屏幕方向 (默认竖屏)
     */
    protected int getScreenOrientation() {
        return 0;
    }
    
    /**
     * 获取 ContentView
     *
     * @return ContentView
     */
    @org.jetbrains.annotations.NotNull()
    public final android.view.ViewGroup getContentView() {
        return null;
    }
    
    /**
     * 跳转Activity页面
     * @param cls 要跳转到的页面反射Class
     * @param bundle 携带的数据
     * @param requestCode 请求码
     */
    public final void startActivity(@org.jetbrains.annotations.NotNull()
    java.lang.Class<?> cls, @org.jetbrains.annotations.Nullable()
    android.os.Bundle bundle, int requestCode) {
    }
    
    /**
     * 关闭Activity (自定义 Activity 关闭动画)
     * @param enterAnim 前一个 Activity 进入动画
     * @param exitAnim 当前要销毁的 Activity 退出动画
     */
    public final void finish(int enterAnim, int exitAnim) {
    }
    
    public BaseActivity() {
        super();
    }
}