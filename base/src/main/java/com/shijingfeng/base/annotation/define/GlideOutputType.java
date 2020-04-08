package com.shijingfeng.base.annotation.define;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.shijingfeng.base.util.image_load.GlideImageLoaderKt.AS_BITMAP;
import static com.shijingfeng.base.util.image_load.GlideImageLoaderKt.AS_DRAWABLE;
import static com.shijingfeng.base.util.image_load.GlideImageLoaderKt.AS_FILE;
import static com.shijingfeng.base.util.image_load.GlideImageLoaderKt.AS_GIF;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Function: Glide 输出类型 限定 (注意: 不要改为 Kotlin 注解, 否则乱输入不会提示)
 * Date: 20-4-7 下午10:11
 * Description:
 *
 * @author shijingfeng
 */
@IntDef({
    // Glide输出源: Drawable
    AS_DRAWABLE,
    // Glide输出源: Bitmap
    AS_BITMAP,
    // Glide输出源: Gif
    AS_GIF,
    // Glide输出源: File
    AS_FILE
})
@Target({
    // 函数参数
    PARAMETER,
})
@Retention(SOURCE)
public @interface GlideOutputType {}
