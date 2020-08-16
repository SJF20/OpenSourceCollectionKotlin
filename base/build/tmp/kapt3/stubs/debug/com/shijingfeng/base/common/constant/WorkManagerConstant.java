package com.shijingfeng.base.common.constant;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0004"}, d2 = {"WORKER_NAME_APP_UPDATE", "", "WORKER_NAME_CHECK_FOR_HOTFIX_PATCH", "WORKER_NAME_CHECK_FOR_UPDATE", "base_debug"})
public final class WorkManagerConstant {
    
    /**
     * 应用检查更新 Worker
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String WORKER_NAME_CHECK_FOR_UPDATE = "check_for_update_worker";
    
    /**
     * 应用更新 Worker
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String WORKER_NAME_APP_UPDATE = "app_update_worker";
    
    /**
     * 应用检查更新热修复补丁
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String WORKER_NAME_CHECK_FOR_HOTFIX_PATCH = "check_for_hotfix_patch";
}