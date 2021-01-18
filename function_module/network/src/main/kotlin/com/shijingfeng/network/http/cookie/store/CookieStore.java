package com.shijingfeng.network.http.cookie.store;

import java.util.List;

import okhttp3.Cookie;
import okhttp3.HttpUrl;

/**
 * Function: Cookie存储器
 * Author: ShiJingFeng
 * Date: 2019/10/12 13:33
 * Description:
 * @author ShiJingFeng
 */
public interface CookieStore {

    /**
     * 保存url对应所有cookie
     * @param url HttpUrl
     * @param cookies Cookie列表s
     */
    void saveCookieList(HttpUrl url, List<Cookie> cookies);

    /**
     * 保存url对应所有cookie
     * @param url HttpUrl
     * @param cookie Cookie
     */
    void saveCookie(HttpUrl url, Cookie cookie);

    /**
     * 加载url所有的cookie
     * @param url HttpUrl
     * @return Cookie列表
     */
    List<Cookie> loadCookie(HttpUrl url);

    /**
     * 获取当前所有保存的cookie
     * @return Cookie列表
     */
    List<Cookie> getAllCookie();

    /**
     * 获取当前url对应的所有的cookie
     * @param url HttpUrl
     * @return Cookie列表
     */
    List<Cookie> getCookieList(HttpUrl url);

    /**
     * 根据url和cookie移除对应的cookie
     * @param url HttpUrl
     * @param cookie Cookie
     * @return 是否删除成功
     */
    boolean removeCookie(HttpUrl url, Cookie cookie);

    /**
     * 根据url移除所有的cookie
     * @param url HttpUrl
     * @return 是否删除成功
     */
    boolean removeCookieList(HttpUrl url);

    /**
     * 移除所有的cookie
     * @return 是否移除成功
     */
    boolean removeAllCookie();
}
