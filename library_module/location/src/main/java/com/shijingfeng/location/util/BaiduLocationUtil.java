package com.shijingfeng.location.util;

import android.text.TextUtils;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.SPUtils;
import com.shijingfeng.base.base.application.BaseApplicationKt;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.shijingfeng.base.common.constant.SPConstant.SP_PUBLIC_NAME;
import static com.shijingfeng.location.constant.Constant.CUR_LOCATION;
import static com.shijingfeng.location.constant.Constant.LATITUDE;
import static com.shijingfeng.location.constant.Constant.LONGITUDE;

/**
 * Function: 百度定位 工具类
 * Author: ShiJingFeng
 * Date: 2020/3/23 12:30
 * Description:
 * Author: ShiJingFeng
 */
public class BaiduLocationUtil {

    private volatile static BaiduLocationUtil sInstance;

    private LocationClient mLocationClient;
    private BDAbstractLocationListener mListener;

    private Map<String, BDAbstractLocationListener> mListenerMap = new HashMap<>();

    private BaiduLocationUtil() {}

    /**
     * DCL 双检 单例
     * @return BaiduLocationUtil实例
     */
    public static BaiduLocationUtil getInstance() {
        if (sInstance == null) {
            synchronized (BaiduLocationUtil.class) {
                if (sInstance == null) {
                    sInstance = new BaiduLocationUtil();
                }
            }
        }
        return sInstance;
    }

    /**
     * 检查百度定位是否可用 或 是否已初始化百度定位
     */
    private void checkAvailable() {
        if (mLocationClient == null) {
            throw new IllegalStateException("百度定位未初始化");
        }
    }

    /**
     * 注册位置监听器
     * @param listener
     */
    private void registerLocationListener(BDAbstractLocationListener listener) {
        if (listener == null) {
            return;
        }
        final String id = UUID.randomUUID().toString().replaceAll("-", "");

        mListenerMap.put(id, listener);
    }

    /**
     * 注册位置监听器
     *
     * @param id ID
     * @param listener BDAbstractLocationListener
     */
    private void registerLocationListener(String id, BDAbstractLocationListener listener) {
        if (TextUtils.isEmpty(id) || listener == null) {
            return;
        }
        mListenerMap.put(id, listener);
    }

    /**
     * 解注册位置监听器（注意一定要在合适的地方调用，否则会内存泄漏）
     * @param listener BDAbstractLocationListener
     */
    private void unregisterLocationListener(BDAbstractLocationListener listener) {
        if (listener == null) {
            return;
        }
        for (Map.Entry<String, BDAbstractLocationListener> entry : mListenerMap.entrySet()) {
            if (entry.getValue() == listener) {
                mListenerMap.remove(entry.getKey());
                break;
            }
        }
    }

    /**
     * 解注册位置监听器（注意一定要在合适的地方调用，否则会内存泄漏）
     * @param id String
     */
    private void unregisterLocationListener(String id) {
        if (TextUtils.isEmpty(id)) {
            return;
        }
        mListenerMap.remove(id);
    }

    /**
     * 默认初始化
     */
    public void init() {
        init(null);
    }

    /**
     * 自定义初始化
     * @param locationOption LocationClientOption
     */
    public void init(LocationClientOption locationOption) {
        //定位服务的客户端。宿主程序在客户端声明此类，并调用，目前只支持在主线程中启动
        mLocationClient = new LocationClient(BaseApplicationKt.getApplication());
        if (locationOption == null) {
            // 默认初始化
            locationOption = new LocationClientOption();
            //可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
            locationOption.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
            //可选，默认gcj02，设置返回的定位结果坐标系，如果配合百度地图使用，建议设置为bd09ll;
            locationOption.setCoorType("bd09ll");
            //可选，默认0，即仅定位一次，设置发起连续定位请求的间隔需要大于等于1000ms才是有效的
            locationOption.setScanSpan(1000);
            //可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
            locationOption.setLocationNotify(true);
            //可选，设置是否需要地址信息，默认不需要
            locationOption.setIsNeedAddress(true);
            //可选，设置是否需要地址描述
            locationOption.setIsNeedLocationDescribe(true);
            //可选，设置是否需要设备方向结果
            locationOption.setNeedDeviceDirect(false);
            //可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
            locationOption.setIgnoreKillProcess(true);
            //可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
            locationOption.setIsNeedLocationDescribe(true);
            //可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
            locationOption.setIsNeedLocationPoiList(true);
            //可选，默认false，设置是否收集CRASH信息，默认收集
            locationOption.SetIgnoreCacheException(false);
            //可选，默认false，设置是否开启Gps定位
            locationOption.setOpenGps(true);
            //可选，默认false，设置定位时是否需要海拔信息，默认不需要，除基础定位版本都可用
            locationOption.setIsNeedAltitude(false);
            //设置打开自动回调位置模式，该开关打开后，期间只要定位SDK检测到位置变化就会主动回调给开发者，该模式下开发者无需再关心定位间隔是多少，定位SDK本身发现位置变化就会及时回调给开发者
            locationOption.setOpenAutoNotifyMode();
            //设置打开自动回调位置模式，该开关打开后，期间只要定位SDK检测到位置变化就会主动回调给开发者
            locationOption.setOpenAutoNotifyMode(3000,1, LocationClientOption.LOC_SENSITIVITY_HIGHT);
        }
        //需将配置好的LocationClientOption对象，通过setLocOption方法传递给LocationClient对象使用
        mLocationClient.setLocOption(locationOption);
    }

    /**
     * 是否已经开始定位
     */
    public boolean isStarted() {
        checkAvailable();
        return mLocationClient.isStarted();
    }

    /**
     * 开启定位
     */
    public void start() {
        checkAvailable();
        if (!isStarted()) {
            mLocationClient.registerLocationListener(mListener = new BDAbstractLocationListener() {
                @Override
                public void onReceiveLocation(BDLocation bdLocation) {
                    final Map<String, Double> locationMap = new HashMap<>(2);

                    locationMap.put(LONGITUDE, bdLocation.getLongitude());
                    locationMap.put(LATITUDE, bdLocation.getLatitude());

                    SPUtils.getInstance(SP_PUBLIC_NAME).put(CUR_LOCATION, GsonUtils.toJson(locationMap));
                    for (Map.Entry<String, BDAbstractLocationListener> entry : mListenerMap.entrySet()) {
                        entry.getValue().onReceiveLocation(bdLocation);
                    }
                }

                @Override
                public void onConnectHotSpotMessage(String s, int i) {
                    super.onConnectHotSpotMessage(s, i);
                    for (Map.Entry<String, BDAbstractLocationListener> entry : mListenerMap.entrySet()) {
                        entry.getValue().onConnectHotSpotMessage(s, i);
                    }
                }

                @Override
                public void onLocDiagnosticMessage(int i, int i1, String s) {
                    super.onLocDiagnosticMessage(i, i1, s);
                    for (Map.Entry<String, BDAbstractLocationListener> entry : mListenerMap.entrySet()) {
                        entry.getValue().onLocDiagnosticMessage(i, i1, s);
                    }
                }
            });
            mLocationClient.start();
        }
    }

    /**
     * 注册 并 开始定位
     * @param listener BDAbstractLocationListener
     */
    public void start(BDAbstractLocationListener listener) {
        checkAvailable();
        registerLocationListener(listener);
        if (!isStarted()) {
            start();
        }
    }

    /**
     * 注册 并 开始定位
     * @param id ID
     * @param listener BDAbstractLocationListener
     */
    public void start(String id, BDAbstractLocationListener listener) {
        checkAvailable();
        registerLocationListener(id, listener);
        if (!isStarted()) {
            start();
        }
    }

    /**
     * 重启定位
     */
    public void restart() {
        checkAvailable();
        if (!isStarted()) {
            start();
        } else {
            mLocationClient.restart();
        }
    }

    /**
     * 停止定位（注意一定要在合适的地方调用，否则会内存泄漏）
     * 如果只有当前调用方这一个注册了，那么就解注册，并停止定位
     */
    public void stop(String id) {
        checkAvailable();
        if (TextUtils.isEmpty(id)) {
            return;
        }
        if (mListenerMap.size() <= 1 && mListenerMap.containsKey(id)) {
            // 只剩下当前调用方注册
            destroy();
        } else {
            // 解注册当前调用方
            unregisterLocationListener(id);
        }
    }

    /**
     * 停止定位（注意一定要在合适的地方调用，否则会内存泄漏）
     * 如果只有当前调用方这一个注册了，那么就解注册，并停止定位
     */
    public void stop(BDAbstractLocationListener listener) {
        checkAvailable();
        if (listener == null) {
            return;
        }
        if (mListenerMap.size() == 1 && mListenerMap.containsValue(listener)) {
            // 只剩下当前调用方注册
            destroy();
        } else {
            // 解注册当前调用方
            unregisterLocationListener(listener);
        }
    }

    /**
     * 销毁定位（注意一定要在合适的地方调用，否则会内存泄漏）
     * 会销毁所有注册, 并停止定位
     */
    public void destroy() {
        checkAvailable();
        if (isStarted()) {
            mListenerMap.clear();
            if (mListener != null) {
                mLocationClient.unRegisterLocationListener(mListener);
                mListener = null;
            }
            mLocationClient.stop();
        }
    }

}
