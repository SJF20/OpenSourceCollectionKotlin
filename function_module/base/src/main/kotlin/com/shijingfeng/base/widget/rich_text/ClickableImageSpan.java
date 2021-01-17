package com.shijingfeng.base.widget.rich_text;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.style.ImageSpan;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Function: 自定义可点击的ImageSpan
 * Date: 2020/2/2 20:54
 * Description:
 * Author: ShiJingFeng
 */
public abstract class ClickableImageSpan extends ImageSpan {

    public ClickableImageSpan(@NonNull Context context, @NonNull Bitmap b) {
        super(context, b);
    }

    public ClickableImageSpan(@NonNull Context context, @NonNull Bitmap b, int verticalAlignment) {
        super(context, b, verticalAlignment);
    }

    public ClickableImageSpan(@NonNull Drawable d) {
        super(d);
    }

    public ClickableImageSpan(@NonNull Drawable d, int verticalAlignment) {
        super(d, verticalAlignment);
    }

    public ClickableImageSpan(@NonNull Drawable d, @NonNull String source) {
        super(d, source);
    }

    public ClickableImageSpan(@NonNull Drawable d, @NonNull String source, int verticalAlignment) {
        super(d, source, verticalAlignment);
    }

    public ClickableImageSpan(@NonNull Context context, @NonNull Uri uri) {
        super(context, uri);
    }

    public ClickableImageSpan(@NonNull Context context, @NonNull Uri uri, int verticalAlignment) {
        super(context, uri, verticalAlignment);
    }

    public ClickableImageSpan(@NonNull Context context, int resourceId) {
        super(context, resourceId);
    }

    public ClickableImageSpan(@NonNull Context context, int resourceId, int verticalAlignment) {
        super(context, resourceId, verticalAlignment);
    }

    @Nullable
    @Override
    public String getSource() {
        return super.getSource();
    }

    /**
     * 执行点击ImageSpan的点击事件
     * @param view 被点击的 View
     */
    public abstract void onClick(@NonNull View view);

}
