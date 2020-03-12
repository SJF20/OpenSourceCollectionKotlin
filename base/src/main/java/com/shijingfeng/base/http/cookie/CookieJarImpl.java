package com.shijingfeng.base.http.cookie;

import androidx.annotation.NonNull;

import com.shijingfeng.base.http.cookie.store.CookieStore;
import com.shijingfeng.base.util.LogUtil;

import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * Function: CookieJar实现类
 * Author: ShiJingFeng
 * Date: 2019/10/12 13:33
 * Description:
 * @author ShiJingFeng
 */
public class CookieJarImpl implements CookieJar {

    /** Cookie存储器 */
    private CookieStore cookieStore;

    public CookieJarImpl(CookieStore cookieStore) {
        if (cookieStore == null) {
            throw new IllegalArgumentException("cookieStore can not be null!");
        }
        this.cookieStore = cookieStore;
    }

    /**
     * 从响应中保存Cookie
     * @param url HttpUrl
     * @param cookies Cookie列表
     */
    @Override
    public synchronized void saveFromResponse(@NonNull HttpUrl url, @NonNull List<Cookie> cookies) {
        LogUtil.d("cookie", "saveFromResponse");

        for (Cookie cookie : cookies) {
            LogUtil.d("cookie", "saveFromResponse" + "  name: " + cookie.name() + "  value" + cookie.value());
        }
        cookieStore.saveCookieList(url, cookies);
    }

    /**
     * 从请求中加载Cookie
     * @param url HttpUrl
     * @return Cookie列表
     */
    @Override
    @NonNull
    public synchronized List<Cookie> loadForRequest(@NonNull HttpUrl url) {
        final List<Cookie> cookieList = cookieStore.loadCookie(url);

        LogUtil.d("cookie", "loadForRequest");

        for (Cookie cookie : cookieList) {
            LogUtil.d("cookie", "loadForRequest" + "  name: " + cookie.name() + "  value" + cookie.value());
        }
        return cookieList;
    }

    /**
     * 获取 Cookie存储器
     * @return Cookie存储器
     */
    public CookieStore getCookieStore() {
        return cookieStore;
    }
}