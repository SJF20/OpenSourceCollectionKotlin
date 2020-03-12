package com.shijingfeng.base.arouter

import android.content.Context
import android.net.Uri
import android.text.TextUtils
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.service.PathReplaceService
import java.util.*

/**
 * Function: 全局路径替换 Service (项目中只允许有一个 PathReplaceService 子类, 否则执行最新加载的那一个)
 * Date: 2020/1/13 11:56
 * Description:
 *
 * @author ShiJingFeng
 */
@Route(path = PROVIDER_BASE_COMMON_PATH_REPLACE_SERVICE)
class PathReplaceServiceImpl : PathReplaceService {

    /** Key(String): 替换前的路径  Value(String): 替换后的路径  */
    private val mPathMap: MutableMap<String, String> = mutableMapOf()
    /** Key(String): 替换前的 URI 路径  Value(String): 替换后的 URI 路径  */
    private val mUriPathMap: MutableMap<Uri, Uri> = mutableMapOf()

    /**
     * 只初始化一次, 在 PathReplaceServiceImpl 加载时初始化
     * @param context Context (navigation(Context) 中的 Context )
     */
    override fun init(context: Context) {}

    override fun forString(path: String): String {
        val newPath = mPathMap[path]

        return if (TextUtils.isEmpty(newPath)) path else newPath!!
    }

    override fun forUri(uri: Uri): Uri {
        val newUriPath = mUriPathMap[uri]

        return newUriPath ?: uri
    }

    /**
     * 替换路径
     * @param oldPath 旧路径
     * @param newPath 新路径
     */
    fun replacePath(oldPath: String, newPath: String) {
        mPathMap[oldPath] = newPath
    }

    /**
     * 替换 URI 路径
     * @param oldUri 旧的 URI 路径
     * @param newUri 新的 URI 路径
     */
    fun replaceUriPath(oldUri: Uri, newUri: Uri) {
        mUriPathMap[oldUri] = newUri
    }

    /**
     * 获取路径 Map
     * @return 路径 Map
     */
    val pathMap: Map<String, String>
        get() = Collections.unmodifiableMap(mPathMap)

    /**
     * 获取 URI 路径 Map
     * @return URI 路径 Map
     */
    val uriPathMap: Map<Uri, Uri>
        get() = Collections.unmodifiableMap(mUriPathMap)
}