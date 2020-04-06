/** 生成的 Java 类名 */
@file:JvmName("ShareUtil")
package com.shijingfeng.base.util

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.net.Uri
import com.shijingfeng.base.R
import com.shijingfeng.base.base.application.application
import java.io.File
import java.util.*

/**
 * Function: 分享相关 工具类
 * Date: 20-4-6 下午1:01
 * Description:
 * @author shijingfeng
 */

/** 分享标题 */
val SHARE_TITLE = getStringById(R.string.分享到)

/**
 * 分享纯文字
 * @param title    标题
 * @param content  文本内容
 */
fun shareText(
    context: Context,
    title: String?,
    content: String?
) {
    context.startActivity(Intent.createChooser(
        Intent().apply {
            type = "text/plain"
            action = Intent.ACTION_SEND
            addFlags(FLAG_ACTIVITY_NEW_TASK)
            putExtra(Intent.EXTRA_TITLE, title)
            putExtra(Intent.EXTRA_SUBJECT, title)
            putExtra(Intent.EXTRA_TEXT, content)
        },
        SHARE_TITLE
    ))
}

/**
 * 分享单张图片
 * @param imagePath  图片本地路径
 */
fun shareImage(
    title: String?,
    imagePath: String
) {
    val imageUri = Uri.fromFile(File(imagePath))

    application.startActivity(Intent.createChooser(
        Intent().apply {
            type = "image/*"
            action = Intent.ACTION_SEND
            addFlags(FLAG_ACTIVITY_NEW_TASK)
            putExtra(Intent.EXTRA_TITLE, title)
            putExtra(Intent.EXTRA_SUBJECT, title)
            putExtra(Intent.EXTRA_STREAM, imageUri)
        },
        SHARE_TITLE
    ))
}

/**
 * 分享功能
 * @param context       上下文
 * @param msgTitle      消息标题
 * @param msgText       消息内容
 * @param imgPath       图片路径，不分享图片则传null
 */
fun shareTextAndImage(
    context: Context,
    msgTitle: String?,
    msgText: String?,
    imgPath: String?
) {
    val intent = Intent(Intent.ACTION_SEND)
    if (imgPath == null || imgPath == "") {
        // 纯文本
        intent.type = "text/plain"
    } else {
        val f = File(imgPath)
        if (f.exists() && f.isFile) {
            intent.type = "image/jpg"
            val u = Uri.fromFile(f)
            intent.putExtra(Intent.EXTRA_STREAM, u)
        }
    }
    intent.putExtra(Intent.EXTRA_SUBJECT, msgTitle)
    intent.putExtra(Intent.EXTRA_TEXT, msgText)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
    context.startActivity(Intent.createChooser(intent, SHARE_TITLE))
}

/**
 * 分享多个文件
 */
fun shareFile(
    context: Context,
    imageUris: ArrayList<Uri?>?
) {
    /*ArrayList<Uri> imageUris = new ArrayList<>();
        Uri uri1 = Uri.parse(getResourcesUri(R.drawable.dog));
        Uri uri2 = Uri.parse(getResourcesUri(R.drawable.shu_1));
        imageUris.add(uri1);
        imageUris.add(uri2);*/
    val mulIntent = Intent(Intent.ACTION_SEND_MULTIPLE)

    mulIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris)
    mulIntent.type = "image/jpeg"

    context.startActivity(Intent.createChooser(mulIntent, "多文件分享"))
}