package com.shijingfeng.base.common.constant;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\n\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"LOAD_MORE_ALL", "", "LOAD_MORE_FAIL", "LOAD_MORE_SUCCESS", "LOAD_SERVICE_EMPTY", "LOAD_SERVICE_LOADING", "LOAD_SERVICE_LOAD_FAIL", "LOAD_SERVICE_SUCCESS", "REFRESH_FAIL", "REFRESH_LOAD_MORE_NONE", "REFRESH_SUCCESS", "base_release"})
public final class StatusConstant {
    
    /**
     * LoadService状态: 成功
     */
    public static final int LOAD_SERVICE_SUCCESS = 0;
    
    /**
     * LoadService状态: 加载中
     */
    public static final int LOAD_SERVICE_LOADING = 1;
    
    /**
     * LoadService状态: 暂无数据
     */
    public static final int LOAD_SERVICE_EMPTY = 2;
    
    /**
     * LoadService状态: 加载失败
     */
    public static final int LOAD_SERVICE_LOAD_FAIL = 3;
    
    /**
     * 下拉刷新 和 上拉加载 无操作
     */
    public static final int REFRESH_LOAD_MORE_NONE = 0;
    
    /**
     * 下拉刷新成功
     */
    public static final int REFRESH_SUCCESS = 1;
    
    /**
     * 下拉刷新失败
     */
    public static final int REFRESH_FAIL = 2;
    
    /**
     * 上拉加载成功
     */
    public static final int LOAD_MORE_SUCCESS = 3;
    
    /**
     * 上拉加载失败
     */
    public static final int LOAD_MORE_FAIL = 4;
    
    /**
     * 上拉加载已全部完成
     */
    public static final int LOAD_MORE_ALL = 5;
}