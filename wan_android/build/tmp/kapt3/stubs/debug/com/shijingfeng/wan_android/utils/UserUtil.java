package com.shijingfeng.wan_android.utils;

import java.lang.System;

/**
 * Function: 用户工具类
 * Date: 2020/2/3 15:19
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006J\u0006\u0010\u0012\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0013"}, d2 = {"Lcom/shijingfeng/wan_android/utils/UserUtil;", "", "()V", "mLogin", "", "mUserInfo", "Lcom/shijingfeng/wan_android/entity/UserInfoEntity;", "userInfo", "getUserInfo", "()Lcom/shijingfeng/wan_android/entity/UserInfoEntity;", "setUserInfo", "(Lcom/shijingfeng/wan_android/entity/UserInfoEntity;)V", "getId", "", "isLogin", "login", "", "userInfoEntity", "logout", "wan_android_debug"})
public final class UserUtil {
    
    /**
     * 是否已登录  true: 已登录  false: 未登录
     */
    private static boolean mLogin = false;
    
    /**
     * 登录数据
     */
    private static com.shijingfeng.wan_android.entity.UserInfoEntity mUserInfo;
    public static final com.shijingfeng.wan_android.utils.UserUtil INSTANCE = null;
    
    @org.jetbrains.annotations.Nullable()
    public final com.shijingfeng.wan_android.entity.UserInfoEntity getUserInfo() {
        return null;
    }
    
    public final void setUserInfo(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.entity.UserInfoEntity userInfo) {
    }
    
    /**
     * 是否已登录
     * @return true: 已登录  false: 未登录
     */
    public final boolean isLogin() {
        return false;
    }
    
    /**
     * 获取用户ID
     * @return 用户ID
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    /**
     * 登录
     * @param userInfoEntity 登录信息
     */
    public final void login(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.wan_android.entity.UserInfoEntity userInfoEntity) {
    }
    
    /**
     * 退出登录
     */
    public final void logout() {
    }
    
    private UserUtil() {
        super();
    }
}