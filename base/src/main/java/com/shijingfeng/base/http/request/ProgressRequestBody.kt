package com.shijingfeng.base.http.request

import com.shijingfeng.base.entity.event.UploadEvent
import okhttp3.RequestBody
import okio.*
import org.greenrobot.eventbus.EventBus
import java.io.IOException

/**
 * Function: 上传进度 请求体
 * Date: 2020/1/23 15:53
 * Description:
 * @author ShiJingFeng
 */
internal class ProgressRequestBody(
    private val mRequestBody: RequestBody,
    private val mTag: String? = null
) : RequestBody() {

    override fun writeTo(sink: BufferedSink) {
        val bufferedSink = readSink(sink).buffer()

        //写入
        mRequestBody.writeTo(bufferedSink)
        //必须调用flush，否则最后一部分数据可能不会被写入
        bufferedSink.flush()
    }

    /**
     * 写入，回调进度接口
     * @param sink Sink
     * @return Sink
     */
    private fun readSink(sink: BufferedSink): Sink {
        return object : ForwardingSink(sink) {

            //当前写入字节数
            var currentLength = 0L
            //总字节长度，避免多次调用contentLength()方法
            var totalLength = 0L

            @Throws(IOException::class)
            override fun write(source: Buffer, byteCount: Long) {
                super.write(source, byteCount)
                if (totalLength == 0L) {
                    //获得contentLength的值，后续不再调用
                    totalLength = contentLength()
                }
                //增加当前写入的字节数
                currentLength += byteCount
                //使用EventBus的方式，实时发送当前已上传的字节数据
                EventBus.getDefault().post(UploadEvent(currentLength, totalLength, currentLength == totalLength, mTag))
            }
        }
    }

    override fun contentLength() = mRequestBody.contentLength()

    override fun contentType() = mRequestBody.contentType()

}