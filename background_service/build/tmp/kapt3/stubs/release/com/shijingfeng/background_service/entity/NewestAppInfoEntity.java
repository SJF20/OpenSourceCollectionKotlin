package com.shijingfeng.background_service.entity;

import java.lang.System;

/**
 * Function: 最新 App 版本信息 实体类
 * Date: 2020/5/24 10:55
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\nH\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010!H\u00d6\u0003J\t\u0010\"\u001a\u00020\u0005H\u00d6\u0001J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012\u00a8\u0006$"}, d2 = {"Lcom/shijingfeng/background_service/entity/NewestAppInfoEntity;", "Lcom/shijingfeng/base/base/entity/BaseEntity;", "buildVersion", "", "buildVersionNo", "", "buildBuildVersion", "buildUpdateDescription", "buildShortcutUrl", "buildHaveNewVersion", "", "downloadURL", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getBuildBuildVersion", "()I", "getBuildHaveNewVersion", "()Z", "getBuildShortcutUrl", "()Ljava/lang/String;", "getBuildUpdateDescription", "getBuildVersion", "getBuildVersionNo", "getDownloadURL", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "toString", "background_service_release"})
public final class NewestAppInfoEntity extends com.shijingfeng.base.base.entity.BaseEntity {
    
    /**
     * 版本号, 默认为1.0 (是应用向用户宣传时候用到的标识，例如：1.1、8.2.1等。)
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "buildVersion")
    private final java.lang.String buildVersion = null;
    
    /**
     * 上传包的版本编号，默认为1 (即编译的版本号，一般来说，编译一次会变动一次这个版本号, 在 Android 上叫 Version Code。对于 iOS 来说，是字符串类型；对于 Android 来说是一个整数。例如：1001，28等。)
     */
    @com.google.gson.annotations.SerializedName(value = "buildVersionNo")
    private final int buildVersionNo = 0;
    
    /**
     * 蒲公英生成的用于区分历史版本的build号
     */
    @com.google.gson.annotations.SerializedName(value = "buildBuildVersion")
    private final int buildBuildVersion = 0;
    
    /**
     * 应用更新说明
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "buildUpdateDescription")
    private final java.lang.String buildUpdateDescription = null;
    
    /**
     * 应用短链接
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "buildShortcutUrl")
    private final java.lang.String buildShortcutUrl = null;
    
    /**
     * 是否有新版本
     */
    @com.google.gson.annotations.SerializedName(value = "buildHaveNewVersion")
    private final boolean buildHaveNewVersion = false;
    
    /**
     * 应用安装地址
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "downloadURL")
    private final java.lang.String downloadURL = null;
    
    /**
     * 版本号, 默认为1.0 (是应用向用户宣传时候用到的标识，例如：1.1、8.2.1等。)
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBuildVersion() {
        return null;
    }
    
    /**
     * 上传包的版本编号，默认为1 (即编译的版本号，一般来说，编译一次会变动一次这个版本号, 在 Android 上叫 Version Code。对于 iOS 来说，是字符串类型；对于 Android 来说是一个整数。例如：1001，28等。)
     */
    public final int getBuildVersionNo() {
        return 0;
    }
    
    /**
     * 蒲公英生成的用于区分历史版本的build号
     */
    public final int getBuildBuildVersion() {
        return 0;
    }
    
    /**
     * 应用更新说明
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBuildUpdateDescription() {
        return null;
    }
    
    /**
     * 应用短链接
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBuildShortcutUrl() {
        return null;
    }
    
    /**
     * 是否有新版本
     */
    public final boolean getBuildHaveNewVersion() {
        return false;
    }
    
    /**
     * 应用安装地址
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDownloadURL() {
        return null;
    }
    
    public NewestAppInfoEntity(@org.jetbrains.annotations.NotNull()
    java.lang.String buildVersion, int buildVersionNo, int buildBuildVersion, @org.jetbrains.annotations.NotNull()
    java.lang.String buildUpdateDescription, @org.jetbrains.annotations.NotNull()
    java.lang.String buildShortcutUrl, boolean buildHaveNewVersion, @org.jetbrains.annotations.NotNull()
    java.lang.String downloadURL) {
        super();
    }
    
    public NewestAppInfoEntity() {
        super();
    }
    
    /**
     * 版本号, 默认为1.0 (是应用向用户宣传时候用到的标识，例如：1.1、8.2.1等。)
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    /**
     * 上传包的版本编号，默认为1 (即编译的版本号，一般来说，编译一次会变动一次这个版本号, 在 Android 上叫 Version Code。对于 iOS 来说，是字符串类型；对于 Android 来说是一个整数。例如：1001，28等。)
     */
    public final int component2() {
        return 0;
    }
    
    /**
     * 蒲公英生成的用于区分历史版本的build号
     */
    public final int component3() {
        return 0;
    }
    
    /**
     * 应用更新说明
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    /**
     * 应用短链接
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    /**
     * 是否有新版本
     */
    public final boolean component6() {
        return false;
    }
    
    /**
     * 应用安装地址
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    /**
     * Function: 最新 App 版本信息 实体类
     * Date: 2020/5/24 10:55
     * Description:
     * @author ShiJingFeng
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.background_service.entity.NewestAppInfoEntity copy(@org.jetbrains.annotations.NotNull()
    java.lang.String buildVersion, int buildVersionNo, int buildBuildVersion, @org.jetbrains.annotations.NotNull()
    java.lang.String buildUpdateDescription, @org.jetbrains.annotations.NotNull()
    java.lang.String buildShortcutUrl, boolean buildHaveNewVersion, @org.jetbrains.annotations.NotNull()
    java.lang.String downloadURL) {
        return null;
    }
    
    /**
     * Function: 最新 App 版本信息 实体类
     * Date: 2020/5/24 10:55
     * Description:
     * @author ShiJingFeng
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * Function: 最新 App 版本信息 实体类
     * Date: 2020/5/24 10:55
     * Description:
     * @author ShiJingFeng
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Function: 最新 App 版本信息 实体类
     * Date: 2020/5/24 10:55
     * Description:
     * @author ShiJingFeng
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}