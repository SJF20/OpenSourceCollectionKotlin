package com.shijingfeng.base.widget.dialog;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.shijingfeng.base.R;
import com.shijingfeng.base.util.ResourceUtil;

import java.sql.ResultSet;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

/**
 * Function: Loading Dialog
 * Author: ShiJingFeng
 * Date: 2019/11/11 14:54
 * Description:
 * @author ShiJingFeng
 */
public class LoadingDialog {

    /** 默认提示文本 */
    private static final String DEFAULT_HINT_TEXT = ResourceUtil.getStringById(R.string.提交中);

    private static LoadingDialog sInstance;

    private CommonDialog mDialog;
    private ObjectAnimator mAnimator;
    private String mHintText = DEFAULT_HINT_TEXT;

    private LoadingDialog() {}

    public static LoadingDialog getInstance() {
        if (sInstance == null) {
            sInstance = new LoadingDialog();
        }
        return sInstance;
    }

    /**
     * 开始旋转动画
     */
    private void startAnimator() {
        final View view = mDialog.getContentView();

        if (view == null) {
            return;
        }

        mAnimator = ObjectAnimator.ofFloat(view.findViewById(R.id.iv_loading), "rotation", 0, 360);
        mAnimator.setInterpolator(new LinearInterpolator());
        mAnimator.setDuration(1000);
        mAnimator.setRepeatCount(ValueAnimator.INFINITE);
        mAnimator.start();
    }

    /**
     * 销毁旋转动画
     */
    private void destroyAnimator() {
        if (mAnimator != null) {
            mAnimator.cancel();
            mAnimator = null;
        }
    }

    /**
     * 设置提示文本
     * @param hintText 提示文本
     */
    public LoadingDialog setHintText(String hintText) {
        if (TextUtils.isEmpty(hintText)) {
            this.mHintText = DEFAULT_HINT_TEXT;
        } else {
            this.mHintText = hintText;
        }
        return this;
    }

    /**
     * 显示加载中Dialog
     * @param activity Activity
     */
    public void show(Activity activity) {
        if (mDialog != null) {
            if (!mDialog.isShowing()) {
                final TextView tvText = mDialog.getContentView().findViewById(R.id.tv_text);
                final String oldText = tvText.getText().toString();

                if (!oldText.equals(mHintText)) {
                    tvText.setText(mHintText);
                }
                startAnimator();
                mDialog.show();
            }
            return;
        }

        final View vGetVerifyCode = LayoutInflater.from(activity).inflate(R.layout.dialog_loading, null);

        ((TextView) vGetVerifyCode.findViewById(R.id.tv_text)).setText(mHintText);

        mDialog = new CommonDialog.Builder(activity)
                .setContentView(vGetVerifyCode)
                .setWindowWidth(MATCH_PARENT)
                .setWindowHeight(MATCH_PARENT)
                .setOnDismissListener(this::hide)
                .show();
        startAnimator();
    }

    /**
     * 隐藏加载中Dialog
     */
    public void hide() {
        if (mDialog != null) {
            mDialog.hide();
        }
        destroyAnimator();
    }

    /**
     * 关闭加载中Dialog (注意一定要调用，否则会导致内存泄漏)
     */
    public void destroy() {
        hide();
        mDialog = null;
    }
}
