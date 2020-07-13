package com.zhy.changeskin.utils;

import android.util.Log;

import com.zhy.changeskin.BuildConfig;

/**
 * Created by zhy on 15/9/23.
 */
public class L {
    private static final String TAG = "Skin";
    private static boolean debug = true;

    public static void e(String msg) {
        if (BuildConfig.DEBUG) {
            Log.e(TAG, msg);
        }
    }

}
