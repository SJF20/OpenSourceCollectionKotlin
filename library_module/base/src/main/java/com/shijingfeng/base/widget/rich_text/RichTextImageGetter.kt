package com.shijingfeng.base.widget.rich_text

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.text.Html
import android.widget.TextView
import androidx.core.graphics.drawable.toBitmap
import com.blankj.utilcode.util.ScreenUtils
import com.blankj.utilcode.util.SizeUtils
import com.shijingfeng.base.R
import com.shijingfeng.base.listener.Target
import com.shijingfeng.base.util.e
import com.shijingfeng.base.util.getDrawableById
import com.shijingfeng.base.util.image_load.AS_BITMAP
import com.shijingfeng.base.util.image_load.getImageLoaderInstance

/**
 * Function: TextView 富文本 图片获取器
 * Date: 20-4-7 上午10:51
 * Description:
 * Author: shijingfeng
 */
class RichTextImageGetter(
    private val mContext: Context,
    private val mTextView: TextView
) : Html.ImageGetter {

    /** 图片加载中 占位图 */
    var placeholderBitmap = getDrawableById(R.drawable.ic_image)?.toBitmap(SizeUtils.dp2px(48F), SizeUtils.dp2px(48F))
    /** 图片加载失败 占位图 */
    var errorBitmap = getDrawableById(R.drawable.ic_image)?.toBitmap(SizeUtils.dp2px(48F), SizeUtils.dp2px(48F))

    /**
     * 从 路径 获取 Drawable
     * @param source 路径 (本地路径 或 网络路径)
     */
    override fun getDrawable(source: String?): Drawable {
        val urlDrawable = RichTextDrawable(mContext, placeholderBitmap)

        urlDrawable.setBounds(0, 0, placeholderBitmap?.width ?: 0, placeholderBitmap?.height ?: 0)

        getImageLoaderInstance().displayImage(
            context = mContext,
            imagePath = source ?: "",
            outputType = AS_BITMAP,
            target = object : Target<Bitmap> {
                /**
                 * 加载完成
                 * @param resource 资源
                 */
                override fun onLoadFinished(resource: Bitmap?) {
                    super.onLoadFinished(resource)
                    resource?.run {
                        var bitmap = this
                        val screenWidth = ScreenUtils.getScreenWidth()
                        var newWidth = width
                        var newHeight = height

                        if (width > screenWidth) {
                            // 宽度大于屏幕, 进行缩放显示
                            val widthRatioHeight = width.toFloat() / height.toFloat()
                            val scale = screenWidth.toFloat() / width.toFloat()

                            newWidth = screenWidth
                            newHeight = (screenWidth.toFloat() / widthRatioHeight).toInt()

                            bitmap = Bitmap.createBitmap(resource, 0, 0, width, height, Matrix().apply {
                                postScale(scale, scale)
                            }, true)
                        }

                        urlDrawable.richTextBitmap = bitmap
                        urlDrawable.setBounds(0, 0, newWidth, newHeight)

                        mTextView.invalidate()
                        // 不加这句显示不出来图片，原因不详
                        mTextView.text = mTextView.text
                    }
                }

                /**
                 * 加载失败
                 * @param errorDrawable 加载错误 占位符
                 */
                override fun onLoadFailed(errorDrawable: Drawable?) {
                    super.onLoadFailed(errorDrawable)
                    urlDrawable.richTextBitmap = errorBitmap
                    urlDrawable.setBounds(0, 0, errorBitmap?.width ?: 0, errorBitmap?.height ?: 0)

                    mTextView.invalidate()
                    // 不加这句显示不出来图片，原因不详
                    mTextView.text = mTextView.text
                }
            }
        )

        return urlDrawable
    }

}

/**
 * 富文本 Drawable
 */
private class RichTextDrawable(
    context: Context,
    bitmap: Bitmap?
) : BitmapDrawable(context.resources, bitmap) {

    var richTextBitmap = bitmap

    override fun draw(canvas: Canvas) {
        richTextBitmap?.run {
            canvas.drawBitmap(this, 0f, 0f, paint)
        }
    }

}