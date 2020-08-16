package com.shijingfeng.wan_android.entity;

import java.lang.System;

/**
 * Function: 用户信息实体类
 * Date: 2020/2/3 15:20
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b5\b\u0080\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u00a2\u0006\u0002\u0010\u0013J\t\u00104\u001a\u00020\u0003H\u00c6\u0003J\t\u00105\u001a\u00020\u000eH\u00c6\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u00c6\u0003J\u000f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u00c6\u0003J\t\u00108\u001a\u00020\u0003H\u00c6\u0003J\t\u00109\u001a\u00020\u0003H\u00c6\u0003J\t\u0010:\u001a\u00020\u0003H\u00c6\u0003J\t\u0010;\u001a\u00020\u0003H\u00c6\u0003J\t\u0010<\u001a\u00020\u0003H\u00c6\u0003J\t\u0010=\u001a\u00020\u0003H\u00c6\u0003J\t\u0010>\u001a\u00020\u0003H\u00c6\u0003J\t\u0010?\u001a\u00020\fH\u00c6\u0003J\u008d\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u00c6\u0001J\u0013\u0010A\u001a\u00020\f2\b\u0010B\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\b\u0010C\u001a\u00020\u0003H\u0016J\t\u0010D\u001a\u00020\u000eH\u00d6\u0001J\t\u0010E\u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001f\"\u0004\b\'\u0010!R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001f\"\u0004\b)\u0010!R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001f\"\u0004\b+\u0010!R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001f\"\u0004\b-\u0010!R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001f\"\u0004\b3\u0010!\u00a8\u0006F"}, d2 = {"Lcom/shijingfeng/wan_android/entity/UserInfoEntity;", "Lcom/shijingfeng/base/base/entity/BaseEntity;", "identity", "", "token", "portrait", "username", "nickname", "publicName", "password", "email", "admin", "", "type", "", "chapterTopList", "", "", "collectIdList", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/util/List;Ljava/util/List;)V", "getAdmin", "()Z", "setAdmin", "(Z)V", "getChapterTopList", "()Ljava/util/List;", "setChapterTopList", "(Ljava/util/List;)V", "getCollectIdList", "setCollectIdList", "getEmail", "()Ljava/lang/String;", "setEmail", "(Ljava/lang/String;)V", "getIdentity", "setIdentity", "getNickname", "setNickname", "getPassword", "setPassword", "getPortrait", "setPortrait", "getPublicName", "setPublicName", "getToken", "setToken", "getType", "()I", "setType", "(I)V", "getUsername", "setUsername", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "getId", "hashCode", "toString", "wan_android_release"})
public final class UserInfoEntity extends com.shijingfeng.base.base.entity.BaseEntity {
    
    /**
     * ID
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "id")
    private java.lang.String identity;
    
    /**
     * Token令牌
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "token")
    private java.lang.String token;
    
    /**
     * 头像
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "icon")
    private java.lang.String portrait;
    
    /**
     * 用户名
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "username")
    private java.lang.String username;
    
    /**
     * 昵称
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "nickname")
    private java.lang.String nickname;
    
    /**
     * 公共名称
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "publicName")
    private java.lang.String publicName;
    
    /**
     * 密码
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "password")
    private java.lang.String password;
    
    /**
     * 邮箱
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "email")
    private java.lang.String email;
    
    /**
     */
    @com.google.gson.annotations.SerializedName(value = "admin")
    private boolean admin;
    
    /**
     */
    @com.google.gson.annotations.SerializedName(value = "type")
    private int type;
    
    /**
     * 置顶列表
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "chapterTops")
    private java.util.List<? extends java.lang.Object> chapterTopList;
    
    /**
     * 收藏列表
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "collectIds")
    private java.util.List<? extends java.lang.Object> collectIdList;
    
    /**
     * 获取ID
     * @return ID
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getId() {
        return null;
    }
    
    /**
     * ID
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getIdentity() {
        return null;
    }
    
    /**
     * ID
     */
    public final void setIdentity(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * Token令牌
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getToken() {
        return null;
    }
    
    /**
     * Token令牌
     */
    public final void setToken(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 头像
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPortrait() {
        return null;
    }
    
    /**
     * 头像
     */
    public final void setPortrait(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 用户名
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUsername() {
        return null;
    }
    
    /**
     * 用户名
     */
    public final void setUsername(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 昵称
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNickname() {
        return null;
    }
    
    /**
     * 昵称
     */
    public final void setNickname(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 公共名称
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPublicName() {
        return null;
    }
    
    /**
     * 公共名称
     */
    public final void setPublicName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 密码
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPassword() {
        return null;
    }
    
    /**
     * 密码
     */
    public final void setPassword(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 邮箱
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEmail() {
        return null;
    }
    
    /**
     * 邮箱
     */
    public final void setEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     */
    public final boolean getAdmin() {
        return false;
    }
    
    /**
     */
    public final void setAdmin(boolean p0) {
    }
    
    /**
     */
    public final int getType() {
        return 0;
    }
    
    /**
     */
    public final void setType(int p0) {
    }
    
    /**
     * 置顶列表
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Object> getChapterTopList() {
        return null;
    }
    
    /**
     * 置顶列表
     */
    public final void setChapterTopList(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.lang.Object> p0) {
    }
    
    /**
     * 收藏列表
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Object> getCollectIdList() {
        return null;
    }
    
    /**
     * 收藏列表
     */
    public final void setCollectIdList(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.lang.Object> p0) {
    }
    
    public UserInfoEntity(@org.jetbrains.annotations.NotNull()
    java.lang.String identity, @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String portrait, @org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String nickname, @org.jetbrains.annotations.NotNull()
    java.lang.String publicName, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    java.lang.String email, boolean admin, int type, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.lang.Object> chapterTopList, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.lang.Object> collectIdList) {
        super();
    }
    
    public UserInfoEntity() {
        super();
    }
    
    /**
     * ID
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    /**
     * Token令牌
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    /**
     * 头像
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    /**
     * 用户名
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    /**
     * 昵称
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    /**
     * 公共名称
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    /**
     * 密码
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    /**
     * 邮箱
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    /**
     */
    public final boolean component9() {
        return false;
    }
    
    /**
     */
    public final int component10() {
        return 0;
    }
    
    /**
     * 置顶列表
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Object> component11() {
        return null;
    }
    
    /**
     * 收藏列表
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Object> component12() {
        return null;
    }
    
    /**
     * Function: 用户信息实体类
     * Date: 2020/2/3 15:20
     * Description:
     * @author ShiJingFeng
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.wan_android.entity.UserInfoEntity copy(@org.jetbrains.annotations.NotNull()
    java.lang.String identity, @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String portrait, @org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String nickname, @org.jetbrains.annotations.NotNull()
    java.lang.String publicName, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    java.lang.String email, boolean admin, int type, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.lang.Object> chapterTopList, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.lang.Object> collectIdList) {
        return null;
    }
    
    /**
     * Function: 用户信息实体类
     * Date: 2020/2/3 15:20
     * Description:
     * @author ShiJingFeng
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * Function: 用户信息实体类
     * Date: 2020/2/3 15:20
     * Description:
     * @author ShiJingFeng
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Function: 用户信息实体类
     * Date: 2020/2/3 15:20
     * Description:
     * @author ShiJingFeng
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}