/** 生成的 Java 类名 */
@file:JvmName("WebViewUtil")
package com.shijingfeng.base.util

import android.annotation.SuppressLint
import android.content.Context.MODE_PRIVATE
import android.os.Build
import android.webkit.WebSettings
import com.blankj.utilcode.util.NetworkUtils
import com.shijingfeng.base.base.application.BaseApplication
import com.shijingfeng.base.base.application.application

/**
 * Function: WebView工具类
 * Date: 2020/2/2 21:33
 * Description:
 * Author: ShiJingFeng
 */

/**
 * 设置默认 WebView设置
 * @param webSettings WebView设置
 */
@SuppressLint("SetJavaScriptEnabled")
fun setDefaultWebSettings(webSettings: WebSettings) {
    webSettings.run {
        //是否支持Js
        javaScriptEnabled = true
        //支持通过JS打开新窗口
        javaScriptCanOpenWindowsAutomatically = true
        //设置屏幕自适应 (第一种方法)
//        layoutAlgorithm = WebSettings.LayoutAlgorithm.NARROW_COLUMNS
        //设置屏幕自适应 (第二种方法 推荐)
        //设置此属性，可任意比例缩放
        useWideViewPort = true
        //设置WebView为全屏显示
        loadWithOverviewMode = true
        //自动加载图片
        loadsImagesAutomatically = true
        //网页在加载的时候暂时不加载图片，当所有的HTML标签加载完成时, 设置为 false 开始加载
        blockNetworkImage = true
        //支持缩放，适配到当前屏幕
        setSupportZoom(true)
        builtInZoomControls = true
        //不显示WebView缩放按钮
        displayZoomControls = false
        //是否支持WebView多窗口
        setSupportMultipleWindows(false)
        //是否设置插件
//        pluginState = WebSettings.PluginState.ON_DEMAND
        //是否允许文件存储
        allowFileAccess = true
        //是否开启DOM存储
        domStorageEnabled = true
        //是否开启应用缓存
        setAppCacheEnabled(true)
        //设置应用缓存大小
        setAppCacheMaxSize(Long.MAX_VALUE)
        //设置应用缓存本地存储目录
        setAppCachePath(application.getDir("app_cache", MODE_PRIVATE).path)
        //是否开启数据库缓存
//        databaseEnabled = true
        //设置数据库缓存本地存储目录
//        databasePath = BaseApplication.getInstance().getDir("databases", MODE_PRIVATE).path
        //是否开启位置支持
        setGeolocationEnabled(true)
        //设置位置数据本地存储目录
        setGeolocationDatabasePath(application.getDir("geo_location", MODE_PRIVATE).path)
        // WebView 从 5.0 开始默认不允许混合模式, https 中不能加载 http 资源,需要设置开启。
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }
//        setRenderPriority(WebSettings.RenderPriority.HIGH)
        cacheMode = if (NetworkUtils.isConnected()) {
            //网络可用时，先使用缓存，否则从网络中加载
            WebSettings.LOAD_CACHE_ELSE_NETWORK
        } else { //网络不可用时，只从缓存中加载
            WebSettings.LOAD_CACHE_ONLY
        }
    }
}
