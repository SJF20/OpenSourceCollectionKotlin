package com.shijingfeng.wan_android.common.constant;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"LOAD_SERVICE_SEARCH_HISTORY_EMPTY", "", "LOAD_SERVICE_SEARCH_HISTORY_LOADING", "LOAD_SERVICE_SEARCH_HISTORY_LOAD_FAIL", "LOAD_SERVICE_SEARCH_HISTORY_SUCCESS", "LOAD_SERVICE_SEARCH_HOT_WORD_EMPTY", "LOAD_SERVICE_SEARCH_HOT_WORD_LOADING", "LOAD_SERVICE_SEARCH_HOT_WORD_LOAD_FAIL", "LOAD_SERVICE_SEARCH_HOT_WORD_SUCCESS", "wan_android_release"})
public final class StatusConstant {
    
    /**
     * 搜索热词 LoadService状态: 成功
     */
    public static final int LOAD_SERVICE_SEARCH_HOT_WORD_SUCCESS = 0;
    
    /**
     * 搜索热词 LoadService状态: 加载中
     */
    public static final int LOAD_SERVICE_SEARCH_HOT_WORD_LOADING = 1;
    
    /**
     * 搜索热词 LoadService状态: 暂无数据
     */
    public static final int LOAD_SERVICE_SEARCH_HOT_WORD_EMPTY = 2;
    
    /**
     * 搜索热词 LoadService状态: 加载失败
     */
    public static final int LOAD_SERVICE_SEARCH_HOT_WORD_LOAD_FAIL = 3;
    
    /**
     * 搜索历史 LoadService状态: 成功
     */
    public static final int LOAD_SERVICE_SEARCH_HISTORY_SUCCESS = 0;
    
    /**
     * 搜索历史 LoadService状态: 加载中
     */
    public static final int LOAD_SERVICE_SEARCH_HISTORY_LOADING = 1;
    
    /**
     * 搜索历史 LoadService状态: 暂无数据
     */
    public static final int LOAD_SERVICE_SEARCH_HISTORY_EMPTY = 2;
    
    /**
     * 搜索历史 LoadService状态: 加载失败
     */
    public static final int LOAD_SERVICE_SEARCH_HISTORY_LOAD_FAIL = 3;
}