package com.shijingfeng.base.common.constant;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"PENDING_CODE_CANCEL_APP_UPDATE", "", "PENDING_CODE_CHECK_FOR_UPDATE", "PENDING_CODE_TOKEN_EXPIRE", "PERMISSION_CAMERA", "PERMISSION_EXTERNAL_STORAGE", "RESULT_CAMERA", "RESULT_CLIP", "RESULT_PHOTO", "base_debug"})
public final class CodeConstant {
    
    /**
     * Request Code: 相册
     */
    public static final int RESULT_PHOTO = 1;
    
    /**
     * Request Code: 相机
     */
    public static final int RESULT_CAMERA = 2;
    
    /**
     * Request Code: 裁剪
     */
    public static final int RESULT_CLIP = 3;
    
    /**
     * Permission Code: 打开相机
     */
    public static final int PERMISSION_CAMERA = 1;
    
    /**
     * Permission Code: 读写外部存储权限
     */
    public static final int PERMISSION_EXTERNAL_STORAGE = 2;
    
    /**
     * PendingIntent 请求码: 检查更新
     */
    public static final int PENDING_CODE_CHECK_FOR_UPDATE = 1;
    
    /**
     * PendingIntent 请求码: 取消应用更新
     */
    public static final int PENDING_CODE_CANCEL_APP_UPDATE = 2;
    
    /**
     * PendingIntent 请求码: 玩Android Token 过期验证
     */
    public static final int PENDING_CODE_TOKEN_EXPIRE = 3;
}