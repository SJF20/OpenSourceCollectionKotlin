package com.zhy.changeskin;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;

import androidx.annotation.ArrayRes;
import androidx.annotation.DrawableRes;

import com.zhy.changeskin.utils.L;

/**
 *
 * @author zhy
 * @date 15/9/22
 */
public class ResourceManager {

    private static final String DEFTYPE_DRAWABLE = "drawable";
    private static final String DEFTYPE_MIPMAP = "mipmap";
    private static final String DEFTYPE_COLOR = "color";
    private static final String DEFTYPE_ARRAY = "array";
    private Resources mResources;
    private String mPluginPackageName;
    private String mSuffix;

    public ResourceManager(Resources res, String pluginPackageName, String suffix) {
        mResources = res;
        mPluginPackageName = pluginPackageName;

        if (suffix == null) {
            suffix = "";
        }
        mSuffix = suffix;

    }

    private String appendSuffix(String name) {
        if (!TextUtils.isEmpty(mSuffix)){
            return name + ("_" + mSuffix);
        }
        return name;
    }

    public Drawable getDrawableByName(String name) {
        name = appendSuffix(name);

        L.e("name = " + name + " , " + mPluginPackageName);

        int drawableId = getDrawableIdByName(name, DEFTYPE_DRAWABLE);

        if (drawableId != 0) {
            return mResources.getDrawable(drawableId);
        } else {
            drawableId = getDrawableIdByName(name, DEFTYPE_MIPMAP);

            if (drawableId != 0) {
                return mResources.getDrawable(drawableId);
            }
        }
        return null;
    }

    @DrawableRes
    private int getDrawableIdByName(String drawableResName, String drawableType) {
        try {
            return mResources.getIdentifier(drawableResName, drawableType, mPluginPackageName);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getColor(String name) throws Resources.NotFoundException {
        try {
            name = appendSuffix(name);
            L.e("name = " + name);
            return mResources.getColor(mResources.getIdentifier(name, DEFTYPE_COLOR, mPluginPackageName));
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ColorStateList getColorStateList(String name) {
        try {
            name = appendSuffix(name);
            L.e("name = " + name);
            return mResources.getColorStateList(mResources.getIdentifier(name, DEFTYPE_COLOR, mPluginPackageName));

        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }

    public String[] getStringArrayByName(String arrayResName) {
        try {
            @ArrayRes int arrayId = mResources.getIdentifier(arrayResName, DEFTYPE_ARRAY, mPluginPackageName);

            return mResources.getStringArray(arrayId);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
