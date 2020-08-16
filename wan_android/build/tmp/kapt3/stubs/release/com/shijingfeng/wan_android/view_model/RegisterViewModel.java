package com.shijingfeng.wan_android.view_model;

import java.lang.System;

/**
 * Function: 注册页面 ViewModel
 * Date: 2020/2/5 15:52
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020 H\u0002J\b\u0010\"\u001a\u00020 H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u001f\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\u001b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\bR\u001f\u0010\u001d\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014\u00a8\u0006#"}, d2 = {"Lcom/shijingfeng/wan_android/view_model/RegisterViewModel;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseViewModel;", "Lcom/shijingfeng/wan_android/source/repository/RegisterRepository;", "repository", "(Lcom/shijingfeng/wan_android/source/repository/RegisterRepository;)V", "mBackClickListener", "Landroid/view/View$OnClickListener;", "getMBackClickListener", "()Landroid/view/View$OnClickListener;", "mClearConfirmPasswordClickListener", "getMClearConfirmPasswordClickListener", "mClearPasswordClickListener", "getMClearPasswordClickListener", "mClearUsernameClickListener", "getMClearUsernameClickListener", "mConfirmPassword", "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "getMConfirmPassword", "()Landroidx/databinding/ObservableField;", "mIsRegisterEnable", "Landroidx/databinding/ObservableBoolean;", "getMIsRegisterEnable", "()Landroidx/databinding/ObservableBoolean;", "mPassword", "getMPassword", "mRegisterClickListener", "getMRegisterClickListener", "mUsername", "getMUsername", "finishLoginActivity", "", "getCoinInfo", "register", "wan_android_release"})
public final class RegisterViewModel extends com.shijingfeng.wan_android.base.WanAndroidBaseViewModel<com.shijingfeng.wan_android.source.repository.RegisterRepository> {
    
    /**
     * 用户名
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.databinding.ObservableField<java.lang.String> mUsername = null;
    
    /**
     * 密码
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.databinding.ObservableField<java.lang.String> mPassword = null;
    
    /**
     * 确认密码
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.databinding.ObservableField<java.lang.String> mConfirmPassword = null;
    
    /**
     * 是否能注册
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.databinding.ObservableBoolean mIsRegisterEnable = null;
    
    /**
     * 返回
     */
    @org.jetbrains.annotations.NotNull()
    private final android.view.View.OnClickListener mBackClickListener = null;
    
    /**
     * 清除用户名
     */
    @org.jetbrains.annotations.NotNull()
    private final android.view.View.OnClickListener mClearUsernameClickListener = null;
    
    /**
     * 清除密码
     */
    @org.jetbrains.annotations.NotNull()
    private final android.view.View.OnClickListener mClearPasswordClickListener = null;
    
    /**
     * 清除确认密码
     */
    @org.jetbrains.annotations.NotNull()
    private final android.view.View.OnClickListener mClearConfirmPasswordClickListener = null;
    
    /**
     * 注册
     */
    @org.jetbrains.annotations.NotNull()
    private final android.view.View.OnClickListener mRegisterClickListener = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableField<java.lang.String> getMUsername() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableField<java.lang.String> getMPassword() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableField<java.lang.String> getMConfirmPassword() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableBoolean getMIsRegisterEnable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnClickListener getMBackClickListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnClickListener getMClearUsernameClickListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnClickListener getMClearPasswordClickListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnClickListener getMClearConfirmPasswordClickListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnClickListener getMRegisterClickListener() {
        return null;
    }
    
    /**
     * 注册
     */
    private final void register() {
    }
    
    /**
     * 获取积分信息
     */
    private final void getCoinInfo() {
    }
    
    /**
     * 关闭登录页面
     */
    private final void finishLoginActivity() {
    }
    
    public RegisterViewModel(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.source.repository.RegisterRepository repository) {
        super(null);
    }
    
    public RegisterViewModel() {
        super(null);
    }
}