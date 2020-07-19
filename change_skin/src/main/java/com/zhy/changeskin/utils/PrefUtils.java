package com.zhy.changeskin.utils;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.zhy.changeskin.constant.SkinConfig;


/**
 * Created by zhy on 15/9/22.
 */
public class PrefUtils {
    private Context mContext;
    private String mChannel = "";

    public PrefUtils(Context context) {
        this.mContext = context;
    }

    public PrefUtils(Context context, @NonNull String channel) {
        this.mContext = context;
        this.mChannel = channel;
    }

    public String getPluginPath() {
        SharedPreferences sp = mContext.getSharedPreferences(SkinConfig.PREF_NAME + mChannel, Context.MODE_PRIVATE);
        return sp.getString(SkinConfig.KEY_PLUGIN_PATH, "");
    }

    public String getSuffix() {
        SharedPreferences sp = mContext.getSharedPreferences(SkinConfig.PREF_NAME + mChannel, Context.MODE_PRIVATE);
        return sp.getString(SkinConfig.KEY_PLUGIN_SUFFIX, "");
    }

    public boolean clear() {
        SharedPreferences sp = mContext.getSharedPreferences(SkinConfig.PREF_NAME + mChannel, Context.MODE_PRIVATE);
        return sp.edit().clear().commit();
    }

    public void putPluginPath(String path) {
        SharedPreferences sp = mContext.getSharedPreferences(SkinConfig.PREF_NAME + mChannel, Context.MODE_PRIVATE);
        sp.edit().putString(SkinConfig.KEY_PLUGIN_PATH, path).apply();
    }

    public void putPluginPkg(String pkgName) {
        SharedPreferences sp = mContext.getSharedPreferences(SkinConfig.PREF_NAME + mChannel, Context.MODE_PRIVATE);
        sp.edit().putString(SkinConfig.KEY_PLUGIN_PKG, pkgName).apply();
    }

    public String getPluginPkgName() {
        SharedPreferences sp = mContext.getSharedPreferences(SkinConfig.PREF_NAME + mChannel, Context.MODE_PRIVATE);
        return sp.getString(SkinConfig.KEY_PLUGIN_PKG, "");
    }

    public void putPluginSuffix(String suffix) {
        SharedPreferences sp = mContext.getSharedPreferences(SkinConfig.PREF_NAME + mChannel, Context.MODE_PRIVATE);
        sp.edit().putString(SkinConfig.KEY_PLUGIN_SUFFIX, suffix).apply();
    }

}
