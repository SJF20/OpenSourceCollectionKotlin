package com.shijingfeng.base.widget.rich_text;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * 自定义LinkMovementMethod使其可以响应ImageSpan的点击事件
 */
public class ClickableLinkMovementMethod extends LinkMovementMethod {

    /** ClickableLinkMovementMethod 实例 */
    private volatile static ClickableLinkMovementMethod sInstance;

    private ClickableLinkMovementMethod(){}

    /**
     * 获取 ClickableLinkMovementMethod 实例
     * @return ClickableLinkMovementMethod 实例
     */
    public static ClickableLinkMovementMethod getInstance() {
        if (sInstance == null) {
            synchronized (ClickableLinkMovementMethod.class) {
                if (sInstance == null) {
                    sInstance = new ClickableLinkMovementMethod();
                }
            }
        }
        return sInstance;
    }

    @Override
    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {

        int action = event.getAction();

        if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_DOWN) {
            int x = (int) event.getX();
            int y = (int) event.getY();

            x -= widget.getTotalPaddingLeft();
            y -= widget.getTotalPaddingTop();

            x += widget.getScrollX();
            y += widget.getScrollY();

            Layout layout = widget.getLayout();
            final int line = layout.getLineForVertical(y);
            int off = layout.getOffsetForHorizontal(line, x);

            // 解决图片点击错位问题
            float xLeft = layout.getPrimaryHorizontal(off);

            if(xLeft < x) {
                off += 1;
            }else{
                off -= 1;
            }

            final ClickableSpan[] links = buffer.getSpans(off, off, ClickableSpan.class);
            final ClickableImageSpan[] clickableImageSpans = buffer.getSpans(off, off, ClickableImageSpan.class);

            if (links.length != 0) {
                if (action == MotionEvent.ACTION_UP) {
                    links[0].onClick(widget);
                } else {
                    Selection.setSelection(buffer,
                            buffer.getSpanStart(links[0]),
                            buffer.getSpanEnd(links[0]));
                }
                return true;
            } else if (clickableImageSpans.length != 0) {
                if (action == MotionEvent.ACTION_UP) {
                    clickableImageSpans[0].onClick(widget);
                } else {
                    Selection.setSelection(
                            buffer,
                            buffer.getSpanStart(clickableImageSpans[0]),
                            buffer.getSpanEnd(clickableImageSpans[0])
                    );
                }
                return true;
            } else {
                Selection.removeSelection(buffer);
            }
        }

        return false;
    }
}
