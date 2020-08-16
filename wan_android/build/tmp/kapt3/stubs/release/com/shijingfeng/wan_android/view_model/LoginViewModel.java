package com.shijingfeng.wan_android.view_model;

import java.lang.System;

/**
 * Function: 登录ViewModel
 * Date: 2020/2/4 18:55
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0002\u0010\u0004J\b\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020-H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u001f\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00170\u00170\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0011\u0010\"\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\bR\u0011\u0010$\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\bR\u0011\u0010&\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\bR\u001f\u0010(\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00170\u00170\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0011\u0010*\u001a\u00020\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001e\u00a8\u0006/"}, d2 = {"Lcom/shijingfeng/wan_android/view_model/LoginViewModel;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseViewModel;", "Lcom/shijingfeng/wan_android/source/repository/LoginRepository;", "repository", "(Lcom/shijingfeng/wan_android/source/repository/LoginRepository;)V", "mBackClickListener", "Landroid/view/View$OnClickListener;", "getMBackClickListener", "()Landroid/view/View$OnClickListener;", "mClearPasswordClickListener", "getMClearPasswordClickListener", "mClearUsernameClickListener", "getMClearUsernameClickListener", "mIsCleartextPassword", "Landroidx/databinding/ObservableBoolean;", "getMIsCleartextPassword", "()Landroidx/databinding/ObservableBoolean;", "mIsLoginEnable", "getMIsLoginEnable", "mLoginClickListener", "getMLoginClickListener", "mPassword", "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "getMPassword", "()Landroidx/databinding/ObservableField;", "mPasswordClearVisibility", "Landroidx/databinding/ObservableInt;", "getMPasswordClearVisibility", "()Landroidx/databinding/ObservableInt;", "mPasswordSecrecyIcon", "Landroid/graphics/drawable/Drawable;", "getMPasswordSecrecyIcon", "mPasswordVisibilityClickListener", "getMPasswordVisibilityClickListener", "mRetrievePasswordClickListener", "getMRetrievePasswordClickListener", "mTextOperateClickListener", "getMTextOperateClickListener", "mUsername", "getMUsername", "mUsernameClearVisibility", "getMUsernameClearVisibility", "getCoinInfo", "", "login", "wan_android_release"})
public final class LoginViewModel extends com.shijingfeng.wan_android.base.WanAndroidBaseViewModel<com.shijingfeng.wan_android.source.repository.LoginRepository> {
    
    /**
     * 用户名
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.databinding.ObservableField<java.lang.String> mUsername = null;
    
    /**
     * 用户名清除按钮 可见性
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.databinding.ObservableInt mUsernameClearVisibility = null;
    
    /**
     * 密码
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.databinding.ObservableField<java.lang.String> mPassword = null;
    
    /**
     * 密码清除按钮 可见性
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.databinding.ObservableInt mPasswordClearVisibility = null;
    
    /**
     * 是否能登录
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.databinding.ObservableBoolean mIsLoginEnable = null;
    
    /**
     * 密码是否是明文  true 明文 false 密文
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.databinding.ObservableBoolean mIsCleartextPassword = null;
    
    /**
     * 设置密码保密性图标
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.databinding.ObservableField<android.graphics.drawable.Drawable> mPasswordSecrecyIcon = null;
    
    /**
     * 返回
     */
    @org.jetbrains.annotations.NotNull()
    private final android.view.View.OnClickListener mBackClickListener = null;
    
    /**
     * 去注册
     */
    @org.jetbrains.annotations.NotNull()
    private final android.view.View.OnClickListener mTextOperateClickListener = null;
    
    /**
     * 登录
     */
    @org.jetbrains.annotations.NotNull()
    private final android.view.View.OnClickListener mLoginClickListener = null;
    
    /**
     * 找回密码
     */
    @org.jetbrains.annotations.NotNull()
    private final android.view.View.OnClickListener mRetrievePasswordClickListener = null;
    
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
     * 密码可见性切换
     */
    @org.jetbrains.annotations.NotNull()
    private final android.view.View.OnClickListener mPasswordVisibilityClickListener = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableField<java.lang.String> getMUsername() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableInt getMUsernameClearVisibility() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableField<java.lang.String> getMPassword() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableInt getMPasswordClearVisibility() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableBoolean getMIsLoginEnable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableBoolean getMIsCleartextPassword() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableField<android.graphics.drawable.Drawable> getMPasswordSecrecyIcon() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnClickListener getMBackClickListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnClickListener getMTextOperateClickListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnClickListener getMLoginClickListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnClickListener getMRetrievePasswordClickListener() {
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
    public final android.view.View.OnClickListener getMPasswordVisibilityClickListener() {
        return null;
    }
    
    /**
     * 登录
     */
    private final void login() {
    }
    
    /**
     * 获取积分信息
     */
    private final void getCoinInfo() {
    }
    
    public LoginViewModel(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.source.repository.LoginRepository repository) {
        super(null);
    }
    
    public LoginViewModel() {
        super(null);
    }
}