package com.shijingfeng.base.http.cookie.store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import okhttp3.Cookie;
import okhttp3.HttpUrl;

/**
 * Function: Cookie 内存 存储器
 * Author: ShiJingFeng
 * Date: 2019/10/12 13:33
 * Description:
 * @author ShiJingFeng
 */
public class MemoryCookieStore implements CookieStore {

    /** 内存中存储的 Url地址字符串和Cookie列表 键值对 */
    private final Map<String, List<Cookie>> mMemoryCookiesMap = new HashMap<>();

    /**
     * 保存url对应所有cookie
     * @param url HttpUrl
     * @param cookies Cookie列表
     */
    @Override
    public synchronized void saveCookieList(HttpUrl url, List<Cookie> cookies) {
        List<Cookie> oldCookies = mMemoryCookiesMap.get(url.host());

        if (oldCookies != null && oldCookies.size() > 0) {
            //如果以前存储名字相同的Cookie，则覆盖之
            final List<Cookie> needReplace = new ArrayList<>();

            for (Cookie newCookie : cookies) {
                for (Cookie oldCookie : oldCookies) {
                    if (newCookie.name().equals(oldCookie.name())) {
                        needReplace.add(oldCookie);
                    }
                }
            }
            oldCookies.removeAll(needReplace);
        }

        if (oldCookies == null) {
            oldCookies = new ArrayList<>(cookies);
            mMemoryCookiesMap.put(url.host(), oldCookies);
        } else {
            oldCookies.addAll(cookies);
        }
    }

    /**
     * 保存url对应所有cookie
     * @param url HttpUrl
     * @param cookie Cookie
     */
    @Override
    public synchronized void saveCookie(HttpUrl url, Cookie cookie) {
        List<Cookie> oldCookieList = mMemoryCookiesMap.get(url.host());

        if (oldCookieList != null && oldCookieList.size() > 0) {
            //如果以前存储名字相同的Cookie，则覆盖之
            final List<Cookie> needReplace = new ArrayList<>();

            for (Cookie oldCookie : oldCookieList) {
                if (cookie.name().equals(oldCookie.name())) {
                    needReplace.add(oldCookie);
                }
            }

            oldCookieList.removeAll(needReplace);
        }

        if (oldCookieList == null) {
            oldCookieList = new ArrayList<>();
            oldCookieList.add(cookie);
            mMemoryCookiesMap.put(url.host(), oldCookieList);
        } else {
            oldCookieList.add(cookie);
        }
    }

    /**
     * 加载url所有的cookie
     * @param url HttpUrl
     * @return Cookie列表
     */
    @Override
    public synchronized List<Cookie> loadCookie(HttpUrl url) {
        List<Cookie> cookies = mMemoryCookiesMap.get(url.host());

        if (cookies == null) {
            cookies = new ArrayList<>();
            mMemoryCookiesMap.put(url.host(), cookies);
        }

        return cookies;
    }

    /**
     * 获取当前所有保存的cookie
     * @return Cookie列表
     */
    @Override
    public synchronized List<Cookie> getAllCookie() {
        final List<Cookie> allCookieList = new ArrayList<>();
        final Set<String> httpUrls = mMemoryCookiesMap.keySet();

        for (String url : httpUrls) {
            final List<Cookie> cookieList = mMemoryCookiesMap.get(url);

            if (cookieList != null && cookieList.size() > 0) {
                allCookieList.addAll(cookieList);
            }
        }

        return allCookieList;
    }

    /**
     * 获取当前url对应的所有的cookie
     * @param url HttpUrl
     * @return Cookie列表
     */
    @Override
    public List<Cookie> getCookieList(HttpUrl url) {
        final List<Cookie> cookieList = mMemoryCookiesMap.get(url.host());

        return cookieList == null ? new ArrayList<>() : cookieList;
    }

    /**
     * 根据url和cookie移除对应的cookie
     * @param url HttpUrl
     * @param cookie Cookie
     * @return 是否删除成功
     */
    @Override
    public synchronized boolean removeCookie(HttpUrl url, Cookie cookie) {
        if (url == null || cookie == null) {
            return false;
        }

        final List<Cookie> cookieList = mMemoryCookiesMap.get(url.host());

        if (cookieList == null) {
            return true;
        }
        return cookieList.remove(cookie);
    }

    /**
     * 根据url移除所有的cookie
     * @param url HttpUrl
     * @return 是否删除成功
     */
    @Override
    public synchronized boolean removeCookieList(HttpUrl url) {
        if (url == null) {
            return false;
        }

        return mMemoryCookiesMap.remove(url.host()) != null;
    }

    /**
     * 移除所有的cookie
     * @return 是否移除成功
     */
    @Override
    public synchronized boolean removeAllCookie() {
        mMemoryCookiesMap.clear();
        return true;
    }
}
