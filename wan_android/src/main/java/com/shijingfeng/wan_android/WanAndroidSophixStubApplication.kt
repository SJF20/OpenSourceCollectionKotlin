package com.shijingfeng.wan_android

import android.content.Context
import android.text.TextUtils
import android.util.Log
import androidx.annotation.Keep
import androidx.multidex.MultiDex
import com.shijingfeng.base.common.global.sophixHasInitialized
import com.taobao.sophix.PatchStatus
import com.taobao.sophix.SophixApplication
import com.taobao.sophix.SophixEntry
import com.taobao.sophix.SophixManager

/**
 * Sophix入口类，专门用于初始化Sophix，不应包含任何业务逻辑。
 * 此类必须继承自SophixApplication，onCreate方法不需要实现。
 * 此类不应与项目中的其他类有任何互相调用的逻辑，必须完全做到隔离。
 * AndroidManifest中设置Application为此类，而SophixEntry中设为原先Application类。
 * 注意原先Application里不需要再重复初始化Sophix，并且需要避免混淆原先Application类。
 * 如有其它自定义改造，请咨询官方后妥善处理。
 * <p>
 * 初始化接入改造4个步骤
 * 1. 把此SophixStubApplication入口类添加进项目中，所有Sophix相关初始化放在此类中。并且不应包含开发者的任何业务逻辑代码。 若使用了MultiDex，也应在SophixStubApplication的initSophix之前添加，并且需要记得在原来的Application里面去除MultiDex，避免重复调用导致问题。
 * 2. 把RealApplicationStub的SophixEntry注解的内容改为自己原先真正的MyRealApplication类。
 * 3. 混淆文件中确保某些内容不被混淆。
 * 4. AndroidManifest里面的application改为新增的SophixStubApplication入口类。
 * <p>
 * Date: 2020/7/17 12:18
 * Description:
 *
 * @author ShiJingFeng
 */
internal class WanAndroidSophixStubApplication : SophixApplication() {

    /** 阿里Sophix热修复日志标签 */
    private val TAG = "Sophix"

    /**
     * 此处SophixEntry应指定真正的Application，并且保证RealApplicationStub类名不被混淆。
     */
    @Keep
    @SophixEntry(WanAndroidApplication::class)
    internal class RealApplicationStub

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        // 如果需要使用MultiDex，需要在此处调用。
        MultiDex.install(this)
        // 初始化 Sophix (在 MultiDex.install(this); 之后调用)
        initSophix()
    }

    /**
     * 初始化 Sophix
     */
    private fun initSophix() {
        val appKey = "30529890"
        val appSecret = "3a04464ede348dde54c33ba9fe29725c"
        val rsa = "MIIEwAIBADANBgkqhkiG9w0BAQEFAASCBKowggSmAgEAAoIBAQCsICTMl5sJIEJvorvXASu/X/ewI1TcJphJGA8qDg9vu4N0D5IcC7J61i5d/Saky9+hdozHs5sUs/jtrwTj16QNGh/dHxyhzQO+w1+laUP6mdXjcdBCCk49v/zE8cEZ14UN6SjMK96LB4klsMoLzCc5ISoNatJ5rSB+zeryFlVQgb7azWbXSnIyPvBqhldKVe9hIC7c8SgLyxzeQ67sREFJxidQOTxZIkaqRHlctj1ai78S2BRF7QLDKoc16M7Gydslp9OGnGF7RDRZAAAQ0lsB6U58NyxZgMNNe2CgHQFwnJ35KfGlWtdk9zMyWpCxeotxb3AR2J8EbtBx7sKUH1pJAgMBAAECggEBAJEEF9zjUfRTYIXLdjSDwQbgZL7aVZGRVrYmdgg5hlndgrfSsoe8dye0saXwNZGcTpIrXhqWQG8l3fDqhtUrBgUf4H6cyrOrFZ+v3TJwSJym5SRV7F7nbdnqmZyYDdem02vP59Z0k29Q7wR5ORDNdLJWNabOO/vVl84d0PcbR8+lzIxGNWOIRyrggZnDl2W2rYelVL9KMdubTFrTADIR97PmLjDiwpYTu3JIrOr9dr9bMAZlZIc8Ek2hmYVi+sgH4tiaXiXZDnGXLmO/D0L4RluN2a8HVctwJu93sss2D629Cg2WqAzmHFR4GqeoWF2JX4EVo7fG2ceJO1P7biZtdIECgYEA6ei+q7OPKfd0aIVdbReG7kX5VRtTYyrqGkbofZvM7km5ueSdOVXYEa0f/Jv66BOCrqWzlva00uipleAM9Rhj9cFBhQ6LhTte4ygeITSq8VmmleCBRuJhudl73jFgnUmmEeaRpRxA65tscvddJPYVPRYzeWv9aeAX75smz+9H6bkCgYEAvGGl5zEAp1cptIA7uos+TOyIfxfFQbvJbyEZF1FMxt6e2F5NmTJR/AaTu5Bi0zZ5cwIC7nHKXbynpGhvQona9P3RXNYWPxvnrCv5kme+rdiNeRlfEib2X7ALy3h0WwwVGPYXb5pVhpvNO2JYB8HlrwrNCbq9n+hc0XMgflvF/RECgYEA4UEJnUAltjxfFeiYt93YSs2H9rWB8BX7q6Jtccj/6NmGycWmwvgwQ5V9ID71uVhQmO9pqw+ZwyHbbkF9OOpsGNYqyn/fTEaIcijIGyIlHJdBHUQ+Ooz3n4oZBzh12gJ6svJff6ldu4bJQU2FnXp9qX4fw+aC+9qaMlwvXD8J+cECgYEAhnUIDjjap5Y+DTiN6Trjr9IQJu6Xe7CGOQydtRfxPey94d+FcXgKLmGfZnvLHcg+7UidQQX1E+zIlz93Uj3FC6JyodmorUjElg4ZJ1dnMPxlFe92/STUKz4jXQpPuoCoOlXEKoM00kw4M0+hV4Ac6VBDQtOH7y/RuCl9ItNsQJECgYEAqo5KsmpHV5YI6qmR3PvmXd7ypDBAEPIrJqNvDwWltqa8m5uXE+NirR2eIDylyT+YkE/qcMM42XSUOwrue11wR0YcGCS0/MFRwY5kvgOsIFRH9Ov6DoQoTCIMl2wug29LLoe0SEkyFLaiZZ4BvvCkl1u5MVM9sIpGkCubPnOxv/8="
        var appVersionName = "0.0.0"

        try {
            appVersionName = this.packageManager
                .getPackageInfo(this.packageName, 0)
                .versionName
        } catch (e: Exception) {
            e.printStackTrace()
        }
        SophixManager.getInstance()
            // <必选> 传入入口Application即可
            .setContext(this)
            // <必选> 应用的版本号，拉取补丁时对应控制台创建的版本。举例：setAppVersion传1.0.0，控制台创建1.0.0的版本号然后发布补丁，这样拉取对应版本号下的补丁。另，setAppVersion传1.0.0加载了对应的补丁，升级安装新的apk后传1.0.1，那会自动清理1.0.0的补丁。
            .setAppVersion(appVersionName)
            // <可选，推荐使用> 三个Secret分别对应AndroidManifest里面的三个，可以不在AndroidManifest设置而是用此函数来设置Secret。放到代码里面进行设置可以自定义混淆代码，更加安全，此函数的设置会覆盖AndroidManifest里面的设置，如果对应的值设为null，默认会在使用AndroidManifest里面的。
            .setSecretMetaData(
                appKey,
                appSecret,
                rsa
            )
            // <可选> isEnabled默认为false, 是否调试模式, 调试模式下会输出日志以及不进行补丁签名校验. 线下调试此参数可以设置为true, 查看日志过滤TAG:Sophix, 同时强制不对补丁进行签名校验, 所有就算补丁未签名或者签名失败也发现可以加载成功. 但是正式发布该参数必须为false, false会对补丁做签名校验, 否则就可能存在安全漏洞风险
            .setEnableDebug(true)
            .setEnableFullLog()
            // <可选> 用户自定义aes秘钥, 会对补丁包采用对称加密。这个参数值必须是16位数字或字母的组合，是和补丁工具设置里面AES Key保持完全一致, 补丁才能正确被解密进而加载。此时平台无感知这个秘钥, 所以不用担心阿里云移动平台会利用你们的补丁做一些非法的事情。
//            .setAesKey()
            //  <可选> 设置patch加载状态监听器, 该方法参数需要实现
            .setPatchLoadStatusStub {
                // 无实际意义, 为了兼容老版本, 默认始终为0
                mode: Int,
                // 补丁加载状态码, 详情查看PatchStatus类说明
                code: Int,
                // 补丁加载详细说明
                info: String,
                // 当前处理的补丁版本号, 0:无 -1:本地补丁 其它:后台补丁
                handlePatchVersion: Int ->

                if (code == PatchStatus.CODE_LOAD_SUCCESS) {
                    Log.e(TAG, "Sophix加载补丁成功")
                } else if (code == PatchStatus.CODE_LOAD_RELAUNCH) {
                    // 如果需要在后台重启，建议此处用SharePreference保存状态。
                    Log.e(TAG, "Sophix预加载补丁成功，重启应用会生效")
                    // 可以在PatchLoadStatusListener监听到CODE_LOAD_RELAUNCH后在合适的时机，调用此方法杀死进程。注意，不可以直接Process.killProcess(Process.myPid())来杀进程，这样会扰乱Sophix的内部状态。因此如果需要杀死进程，建议使用这个方法，它在内部做一些适当处理后才杀死本进程。
//                    SophixManager.getInstance().killProcessSafely();
                }
                if (!TextUtils.isEmpty(info)) {
                    Log.e(TAG, "补丁加载详细说明: $info")
                }
                if (handlePatchVersion != 0) {
                    if (handlePatchVersion == -1) {
                        Log.e(TAG, "补丁类型: 本地补丁")
                    } else {
                        Log.e(TAG, "补丁类型: 后台补丁($handlePatchVersion)")
                    }
                }
            }
            // <可选> 把不支持的设备加入黑名单，加入后不会进行热修复。modelName为该机型上Build.MODEL的值，这个值也可以通过adb shell getprop | grep ro.product.model取得。sdkVersionInt就是该机型的Android版本，也就是Build.VERSION.SDK_INT，若设为0，则对应该机型所有安卓版本。目前控制台也可以直接设置机型黑名单，更加灵活
//            .setUnsupportedModel(Build.MODEL, Build.VERSION.SDK_INT)
            // <必选> 该方法主要做些必要的初始化工作以及如果本地有补丁的话会加载补丁, 但不会自动请求补丁。因此需要自行调用queryAndLoadNewPatch方法拉取补丁。这个方法调用需要尽可能的早, 必须在Application的attachBaseContext方法的最前面调用（在super.attachBaseContext之后，如果有Multidex，也需要在Multidex.install之后）, initialize()方法调用之前你需要先调用如下几个方法进行一些必要的参数设置, 方法调用方式如上
            .initialize()
        sophixHasInitialized = true
    }

}

/**
 * 常见状态码说明如下: 一个补丁的加载一般分为三个阶段: 查询/预加载/加载
 * <p>
 * //兼容老版本的code说明
 * int CODE_LOAD_SUCCESS = 1;//加载阶段, 成功
 * int CODE_ERR_INBLACKLIST = 4;//加载阶段, 失败设备不支持
 * int CODE_REQ_NOUPDATE = 6;//查询阶段, 没有发布新补丁
 * int CODE_REQ_NOTNEWEST = 7;//查询阶段, 补丁不是最新的
 * int CODE_DOWNLOAD_SUCCESS = 9;//查询阶段, 补丁下载成功
 * int CODE_DOWNLOAD_BROKEN = 10;//查询阶段, 补丁文件损坏下载失败
 * int CODE_UNZIP_FAIL = 11;//查询阶段, 补丁解密失败
 * int CODE_LOAD_RELAUNCH = 12;//预加载阶段, 需要重启
 * int CODE_REQ_APPIDERR = 15;//查询阶段, appid异常
 * int CODE_REQ_SIGNERR = 16;//查询阶段, 签名异常
 * int CODE_REQ_UNAVAIABLE = 17;//查询阶段, 系统无效
 * int CODE_REQ_SYSTEMERR = 22;//查询阶段, 系统异常
 * int CODE_REQ_CLEARPATCH = 18;//查询阶段, 一键清除补丁
 * int CODE_PATCH_INVAILD = 20;//加载阶段, 补丁格式非法
 * <p>
 * //查询阶段的code说明
 * int CODE_QUERY_UNDEFINED = 31;//未定义异常
 * int CODE_QUERY_CONNECT = 32;//连接异常
 * int CODE_QUERY_STREAM = 33;//流异常
 * int CODE_QUERY_EMPTY = 34;//请求空异常
 * int CODE_QUERY_BROKEN = 35;//请求完整性校验失败异常
 * int CODE_QUERY_PARSE = 36;//请求解析异常
 * int CODE_QUERY_LACK = 37;//请求缺少必要参数异常
 * <p>
 * //预加载阶段的code说明
 * int CODE_PRELOAD_SUCCESS = 100;//预加载成功
 * int CODE_PRELOAD_UNDEFINED = 101;//未定义异常
 * int CODE_PRELOAD_HANDLE_DEX = 102;//dex加载异常
 * int CODE_PRELOAD_NOT_ZIP_FORMAT = 103;//基线dex非zip格式异常
 * int CODE_PRELOAD_REMOVE_BASEDEX = 105;//基线dex处理异常
 * <p>
 * //加载阶段的code说明 分三部分dex加载, resource加载, lib加载, dex加载
 * int CODE_LOAD_UNDEFINED = 71;//未定义异常
 * int CODE_LOAD_AES_DECRYPT = 72;//aes对称解密异常
 * int CODE_LOAD_MFITEM = 73;//补丁SOPHIX.MF文件解析异常
 * int CODE_LOAD_COPY_FILE = 74;//补丁拷贝异常
 * int CODE_LOAD_SIGNATURE = 75;//补丁签名校验异常
 * int CODE_LOAD_SOPHIX_VERSION = 76;//补丁和补丁工具版本不一致异常
 * int CODE_LOAD_NOT_ZIP_FORMAT = 77;//补丁zip解析异常
 * int CODE_LOAD_DELETE_OPT = 80;//删除无效odex文件异常
 * int CODE_LOAD_HANDLE_DEX = 81;//加载dex异常
 * <p>
 * // 反射调用异常
 * int CODE_LOAD_FIND_CLASS = 82;
 * int CODE_LOAD_FIND_CONSTRUCTOR = 83;
 * int CODE_LOAD_FIND_METHOD = 84;
 * int CODE_LOAD_FIND_FIELD = 85;
 * int CODE_LOAD_ILLEGAL_ACCESS = 86;
 * <p>
 * //resource加载
 * public static final int CODE_LOAD_RES_ADDASSERTPATH = 123;//新增资源补丁包异常
 * <p>
 * //lib加载
 * int CODE_LOAD_LIB_UNDEFINED = 131;//未定义异常
 * int CODE_LOAD_LIB_CPUABIS = 132;//获取primaryCpuAbis异常
 * int CODE_LOAD_LIB_JSON = 133;//json格式异常
 * int CODE_LOAD_LIB_LOST = 134;//lib库不完整异常
 * int CODE_LOAD_LIB_UNZIP = 135;//解压异常
 * int CODE_LOAD_LIB_INJECT = 136;//注入异常
 */
