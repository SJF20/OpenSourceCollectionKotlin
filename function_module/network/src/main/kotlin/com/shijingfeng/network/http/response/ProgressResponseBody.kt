package com.shijingfeng.network.http.response

import com.shijingfeng.network.entity.event.DownloadEvent
import okhttp3.ResponseBody
import okio.*
import org.greenrobot.eventbus.EventBus
import java.io.IOException

/**
 * Function: 下载进度 ResponseBody
 * Date: 2020/1/23 16:11
 * Description:
 * @author ShiJingFeng
 */
internal class ProgressResponseBody(
    private val mResponseBody: ResponseBody,
    private val mTag: String? = null
) : ResponseBody() {

    override fun source(): BufferedSource {
        return readSource(mResponseBody.source()).buffer()
    }

    /**
     * 读取，回调进度接口
     * @param source Source
     * @return Source
     */
    private fun readSource(source: Source): Source {
        return object : ForwardingSource(source) {

            //当前写入字节数
            var currentLength = 0L
            //总字节长度，避免多次调用contentLength()方法
            var totalLength = 0L

            @Throws(IOException::class)
            override fun read(sink: Buffer, byteCount: Long): Long {
                val bytesRead = super.read(sink, byteCount)

                if (totalLength == 0L) {
                    //获得contentLength的值，后续不再调用
                    totalLength = contentLength()
                }
                //增加当前读取的字节数，如果读取完成了bytesRead会返回-1
                currentLength += if (bytesRead == -1L) 0 else bytesRead
                //使用EventBus的方式，实时发送当前已读取的字节数据, 注: 如果contentLength()不知道长度，会返回-1
                EventBus.getDefault().post(DownloadEvent(
                    currentLength,
                    totalLength,
                    bytesRead == -1L,
                    mTag
                ))
                return bytesRead
            }
        }
    }

    override fun contentType() = mResponseBody.contentType()

    override fun contentLength() = mResponseBody.contentLength()

}