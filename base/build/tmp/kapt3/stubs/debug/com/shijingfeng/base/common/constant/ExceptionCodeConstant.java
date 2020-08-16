package com.shijingfeng.base.common.constant;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"HTTP_EXCEPTION", "", "NETWORK_EXCEPTION", "PARSE_EXCEPTION", "SERVER_EXCEPTION", "UNKNOWN_EXCEPTION", "base_debug"})
public final class ExceptionCodeConstant {
    
    /**
     * 未知异常
     */
    public static final int UNKNOWN_EXCEPTION = 1000;
    
    /**
     * 解析异常
     */
    public static final int PARSE_EXCEPTION = 1001;
    
    /**
     * 网络异常
     */
    public static final int NETWORK_EXCEPTION = 1002;
    
    /**
     * 协议异常
     */
    public static final int HTTP_EXCEPTION = 1003;
    
    /**
     * 服务器异常
     */
    public static final int SERVER_EXCEPTION = 1004;
}