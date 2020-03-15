package com.shijingfeng.base.widget

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup

import com.shijingfeng.base.util.*

/**
 * Function: 自定义动态状态栏布局
 *
 * @author shijingfeng
 * @date 19-1-22
 */
class StatusBarView @JvmOverloads constructor(
    /** Context环境  */
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : ViewGroup(context, attrs, defStyleAttr, defStyleRes) {

    /** 背景颜色资源ID  */
    private val mColorRes: Int = 0

    init {
        init(attrs)
    }

    /**
     * 初始化
     */
    private fun init(attrs: AttributeSet?) {
        //        if (attrs != null) {
        //            final TypedArray ta = mContext.obtainStyledAttributes(attrs, R.styleable.StatusBarView);
        //
        //            this.mColorRes = ta.getInt(R.styleable.StatusBarView_customBackgroundResource, R.color.white);
        //
        //            Log.e("测试", "资源ID: " + mColorRes);
        //
        //            //一定要回收，否则会内存泄漏
        //            ta.recycle();
        //        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val measureWidthSize = MeasureSpec.getSize(widthMeasureSpec)
        val measureHeightMode = MeasureSpec.getMode(heightMeasureSpec)
        val measureHeightSize = MeasureSpec.getSize(heightMeasureSpec)

        setMeasuredDimension(measureWidthSize, if (measureHeightMode == MeasureSpec.EXACTLY) measureHeightSize else getStatusBarHeight())
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {}

    //    @Override
    //    protected void dispatchDraw(Canvas canvas) {
    //        super.dispatchDraw(canvas);
    //        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
    //            if (mColorRes != 0) {
    //                //自定义状态栏颜色
    //                canvas.drawColor(getColorById(mColorRes));
    //            } else {
    //                //6.0及以上版本，背景默认设为白色（因为状态栏字体默认改为黑色）
    //                canvas.drawColor(Color.WHITE);
    //            }
    //        } else {
    //            //6.0以下版本，背景默认设为黑色
    //            canvas.drawColor(Color.BLACK);
    //        }
    //    }

    //    /**
    //     * 设置自定义背景颜色
    //     * @param colorRes 颜色资源值
    //     */
    //    public void setCustomBackgroundResource(@ColorRes int colorRes) {
    //        this.mColorRes = colorRes;
    //    }
}
