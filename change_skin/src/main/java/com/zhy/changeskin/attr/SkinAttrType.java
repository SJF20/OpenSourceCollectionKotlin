package com.zhy.changeskin.attr;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.zhy.changeskin.ResourceManager;
import com.zhy.changeskin.SkinManager;

/**
 * Created by zhy on 15/9/28.
 */
public enum SkinAttrType {

    // android:background
    BACKGROUND("background") {
        @Override
        public void apply(View view, String resName) {
            final Drawable drawable = getResourceManager().getDrawableByName(resName);

            if (drawable != null) {
                view.setBackground(drawable);
            } else {
                final int color = getResourceManager().getColor(resName);

                if (color != 0) {
                    view.setBackgroundColor(color);
                }
            }
        }
    },

    // android:backgroundTint
    BACKGROUND_TINT("backgroundTint") {
        @Override
        public void apply(View view, String resName) {
            ColorStateList colorStateList = getResourceManager().getColorStateList(resName);

            if (colorStateList == null) {
                return;
            }
            if (view instanceof FloatingActionButton) {
                ((FloatingActionButton) view).setBackgroundTintList(colorStateList);
            } else {
                view.setBackgroundTintList(colorStateList);
            }
        }
    },

    // android:textColor
    TEXT_COLOR("textColor") {
        @Override
        public void apply(View view, String resName) {
            ColorStateList colorList = getResourceManager().getColorStateList(resName);
            if (colorList == null) {
                return;
            }
            ((TextView) view).setTextColor(colorList);
        }
    },

    // android:src
    SRC("src") {
        @Override
        public void apply(View view, String resName) {
            if (view instanceof ImageView) {
                Drawable drawable = getResourceManager().getDrawableByName(resName);
                if (drawable == null) {
                    return;
                }
                ((ImageView) view).setImageDrawable(drawable);
            }

        }
    },

    // android:tint
    TINT("tint") {
        @Override
        public void apply(View view, String resName) {
            if (view instanceof ImageView) {
                final ColorStateList colorStateList = getResourceManager().getColorStateList(resName);

                if (colorStateList == null) {
                    return;
                }
                ((ImageView) view).setImageTintList(colorStateList);
            }
        }
    },

    BUTTON_DRAWABLE("buttonDrawable") {
        @Override
        public void apply(View view, String resName) {
            if (view instanceof CompoundButton) {
                final Drawable drawable = getResourceManager().getDrawableByName(resName);

                if (drawable == null) {
                    return;
                }
                ((CompoundButton) view).setButtonDrawable(drawable);
            }
        }
    };

    String attrType;

    SkinAttrType(String attrType) {
        this.attrType = attrType;
    }

    public String getAttrType() {
        return attrType;
    }


    public abstract void apply(View view, String resName);

    public ResourceManager getResourceManager() {
        return SkinManager.getInstance().getResourceManager();
    }

}
