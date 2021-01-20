package com.shijingfeng.realm.entity;

import java.lang.System;

/**
 * Function: 城市数据 Realm实体类 (包括 行政数据 和 天气数据)
 * Date: 2020/10/29 13:47
 * Description:
 * Author: ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b&\b\u0017\u0018\u00002\u00020\u0001B}\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0011R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001e\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR\u001e\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001b\"\u0004\b\'\u0010\u001dR\u001e\u0010\u000f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0013\"\u0004\b)\u0010\u0015R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0013\"\u0004\b+\u0010\u0015R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/\u00a8\u00060"}, d2 = {"Lcom/shijingfeng/realm/entity/CityDataRealm;", "Lio/realm/RealmModel;", "cityCode", "", "longitude", "", "latitude", "cityName", "cityFullName", "weatherType", "", "weatherDesc", "curTemp", "lowestTemp", "highestTemp", "weatherData", "orderNumber", "(Ljava/lang/String;DDLjava/lang/String;Ljava/lang/String;ILjava/lang/String;DDDLjava/lang/String;D)V", "getCityCode", "()Ljava/lang/String;", "setCityCode", "(Ljava/lang/String;)V", "getCityFullName", "setCityFullName", "getCityName", "setCityName", "getCurTemp", "()D", "setCurTemp", "(D)V", "getHighestTemp", "setHighestTemp", "getLatitude", "setLatitude", "getLongitude", "setLongitude", "getLowestTemp", "setLowestTemp", "getOrderNumber", "setOrderNumber", "getWeatherData", "setWeatherData", "getWeatherDesc", "setWeatherDesc", "getWeatherType", "()I", "setWeatherType", "(I)V", "realm_release"})
@io.realm.annotations.RealmClass(name = "city_data")
public class CityDataRealm implements io.realm.RealmModel {
    
    /**
     * 主键, 城市代码, 对应高德中的adCode
     */
    @org.jetbrains.annotations.NotNull()
    @io.realm.annotations.RealmField(name = "city_code")
    @io.realm.annotations.Required()
    @io.realm.annotations.PrimaryKey()
    private java.lang.String cityCode;
    
    /**
     * 经度
     */
    @io.realm.annotations.RealmField(name = "longitude")
    private double longitude;
    
    /**
     * 纬度
     */
    @io.realm.annotations.RealmField(name = "latitude")
    private double latitude;
    
    /**
     * 城市名称
     */
    @org.jetbrains.annotations.NotNull()
    @io.realm.annotations.RealmField(name = "city_name")
    @io.realm.annotations.Required()
    private java.lang.String cityName;
    
    /**
     * 包括上几级行政区的城市名称
     */
    @org.jetbrains.annotations.NotNull()
    @io.realm.annotations.RealmField(name = "city_full_name")
    private java.lang.String cityFullName;
    
    /**
     * 天气状况
     */
    @io.realm.annotations.RealmField(name = "weather_type")
    private int weatherType;
    
    /**
     * 天气类型 文字描述 例如: 晴, 阴, 多云, 小雨
     */
    @org.jetbrains.annotations.NotNull()
    @io.realm.annotations.RealmField(name = "weather_desc")
    @io.realm.annotations.Required()
    private java.lang.String weatherDesc;
    
    /**
     * 当前温度
     */
    @io.realm.annotations.RealmField(name = "cur_temp")
    private double curTemp;
    
    /**
     * 当日最低温度
     */
    @io.realm.annotations.RealmField(name = "lowest_temp")
    private double lowestTemp;
    
    /**
     * 当日最高温度
     */
    @io.realm.annotations.RealmField(name = "highest_temp")
    private double highestTemp;
    
    /**
     * 天气数据, 用作缓存, Json字符串
     */
    @org.jetbrains.annotations.NotNull()
    @io.realm.annotations.RealmField(name = "weather_data")
    private java.lang.String weatherData;
    
    /**
     * 当插入或删除时, 用于维护顺序 思路来源: [http://www.voidcn.com/article/p-wvwueflp-bvm.html], 如果失效查看此地址 [https://m.jb51.cc/mysql/434178.html]
     * 注意: 但是有一个问题,如果你继续在同一区域插入数字,可能会导致 order_number 精度太接近,足够接近以至于不能彼此区分.
     * 为避免这种情况,您的插入程序必须检查两个相邻的 order_number 是否过于接近.在这种情况下,它可以重新分配其他附近行的 order_number, “拉伸”上方和下方的订单号以“创建空间”以获得新值.
     * 您还可以定期运行“清理”过程,并在表的整个或大部分中进行“拉伸”.
     */
    @io.realm.annotations.RealmField(name = "order_number")
    private double orderNumber;
    
    /**
     * 主键, 城市代码, 对应高德中的adCode
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCityCode() {
        return null;
    }
    
    /**
     * 主键, 城市代码, 对应高德中的adCode
     */
    public final void setCityCode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 经度
     */
    public final double getLongitude() {
        return 0.0;
    }
    
    /**
     * 经度
     */
    public final void setLongitude(double p0) {
    }
    
    /**
     * 纬度
     */
    public final double getLatitude() {
        return 0.0;
    }
    
    /**
     * 纬度
     */
    public final void setLatitude(double p0) {
    }
    
    /**
     * 城市名称
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCityName() {
        return null;
    }
    
    /**
     * 城市名称
     */
    public final void setCityName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 包括上几级行政区的城市名称
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCityFullName() {
        return null;
    }
    
    /**
     * 包括上几级行政区的城市名称
     */
    public final void setCityFullName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 天气状况
     */
    public final int getWeatherType() {
        return 0;
    }
    
    /**
     * 天气状况
     */
    public final void setWeatherType(int p0) {
    }
    
    /**
     * 天气类型 文字描述 例如: 晴, 阴, 多云, 小雨
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getWeatherDesc() {
        return null;
    }
    
    /**
     * 天气类型 文字描述 例如: 晴, 阴, 多云, 小雨
     */
    public final void setWeatherDesc(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 当前温度
     */
    public final double getCurTemp() {
        return 0.0;
    }
    
    /**
     * 当前温度
     */
    public final void setCurTemp(double p0) {
    }
    
    /**
     * 当日最低温度
     */
    public final double getLowestTemp() {
        return 0.0;
    }
    
    /**
     * 当日最低温度
     */
    public final void setLowestTemp(double p0) {
    }
    
    /**
     * 当日最高温度
     */
    public final double getHighestTemp() {
        return 0.0;
    }
    
    /**
     * 当日最高温度
     */
    public final void setHighestTemp(double p0) {
    }
    
    /**
     * 天气数据, 用作缓存, Json字符串
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getWeatherData() {
        return null;
    }
    
    /**
     * 天气数据, 用作缓存, Json字符串
     */
    public final void setWeatherData(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 当插入或删除时, 用于维护顺序 思路来源: [http://www.voidcn.com/article/p-wvwueflp-bvm.html], 如果失效查看此地址 [https://m.jb51.cc/mysql/434178.html]
     * 注意: 但是有一个问题,如果你继续在同一区域插入数字,可能会导致 order_number 精度太接近,足够接近以至于不能彼此区分.
     * 为避免这种情况,您的插入程序必须检查两个相邻的 order_number 是否过于接近.在这种情况下,它可以重新分配其他附近行的 order_number, “拉伸”上方和下方的订单号以“创建空间”以获得新值.
     * 您还可以定期运行“清理”过程,并在表的整个或大部分中进行“拉伸”.
     */
    public final double getOrderNumber() {
        return 0.0;
    }
    
    /**
     * 当插入或删除时, 用于维护顺序 思路来源: [http://www.voidcn.com/article/p-wvwueflp-bvm.html], 如果失效查看此地址 [https://m.jb51.cc/mysql/434178.html]
     * 注意: 但是有一个问题,如果你继续在同一区域插入数字,可能会导致 order_number 精度太接近,足够接近以至于不能彼此区分.
     * 为避免这种情况,您的插入程序必须检查两个相邻的 order_number 是否过于接近.在这种情况下,它可以重新分配其他附近行的 order_number, “拉伸”上方和下方的订单号以“创建空间”以获得新值.
     * 您还可以定期运行“清理”过程,并在表的整个或大部分中进行“拉伸”.
     */
    public final void setOrderNumber(double p0) {
    }
    
    public CityDataRealm(@org.jetbrains.annotations.NotNull()
    java.lang.String cityCode, double longitude, double latitude, @org.jetbrains.annotations.NotNull()
    java.lang.String cityName, @org.jetbrains.annotations.NotNull()
    java.lang.String cityFullName, int weatherType, @org.jetbrains.annotations.NotNull()
    java.lang.String weatherDesc, double curTemp, double lowestTemp, double highestTemp, @org.jetbrains.annotations.NotNull()
    java.lang.String weatherData, double orderNumber) {
        super();
    }
    
    public CityDataRealm() {
        super();
    }
}