package com.shijingfeng.base.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.Context.MODE_MULTI_PROCESS
import android.content.Context.MODE_PRIVATE
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.os.Build
import java.io.File
import java.io.IOException
import java.util.*
import java.util.concurrent.CountDownLatch
import java.util.regex.Pattern
import java.util.regex.Pattern.compile

/**
 * Function: 类相关工具类 (参考 ARouter 的 ClassUtils 工具类)
 * Date: 2020/12/6 16:42
 * Description:
 * @author ShiJingFeng
 */

private const val EXTRACTED_NAME_EXT = ".classes"
private const val EXTRACTED_SUFFIX = ".zip"

private val SECONDARY_FOLDER_NAME = "code_cache" + File.separator + "secondary-dexes"

private const val PREFS_FILE = "multidex.version"
private const val KEY_DEX_NUMBER = "dex.number"

private const val VM_WITH_MULTIDEX_VERSION_MAJOR = 2
private const val VM_WITH_MULTIDEX_VERSION_MINOR = 1

fun getFileNameByPackageName(
    context: Context,
    packageName: String
): Set<String> {
    val classNameSet = mutableSetOf<String>()
    val sourcePathList = getSourcePathList(context)

    if (sourcePathList.isEmpty()) {
        return classNameSet
    }

    val synchronizer = CountDownLatch(sourcePathList.size)

    sourcePathList.forEach { path ->

    }
}

//    public static Set<String> getFileNameByPackageName(Context context, final String packageName) throws PackageManager.NameNotFoundException, IOException, InterruptedException {
//        final Set<String> classNames = new HashSet<>();
//
//        List<String> paths = getSourcePaths(context);
//        final CountDownLatch parserCtl = new CountDownLatch(paths.size());
//
//        for (final String path : paths) {
//            DefaultPoolExecutor.getInstance().execute(new Runnable() {
//                @Override
//                public void run() {
//                    DexFile dexfile = null;
//
//                    try {
//                        if (path.endsWith(EXTRACTED_SUFFIX)) {
//                            //NOT use new DexFile(path), because it will throw "permission error in /data/dalvik-cache"
//                            dexfile = DexFile.loadDex(path, path + ".tmp", 0);
//                        } else {
//                            dexfile = new DexFile(path);
//                        }
//
//                        Enumeration<String> dexEntries = dexfile.entries();
//                        while (dexEntries.hasMoreElements()) {
//                            String className = dexEntries.nextElement();
//                            if (className.startsWith(packageName)) {
//                                classNames.add(className);
//                            }
//                        }
//                    } catch (Throwable ignore) {
//                        Log.e("ARouter", "Scan map file in dex files made error.", ignore);
//                    } finally {
//                        if (null != dexfile) {
//                            try {
//                                dexfile.close();
//                            } catch (Throwable ignore) {
//                            }
//                        }
//
//                        parserCtl.countDown();
//                    }
//                }
//            });
//        }
//
//        parserCtl.await();
//
//        Log.d(Consts.TAG, "Filter " + classNames.size() + " classes by packageName <" + packageName + ">");
//        return classNames;
//    }

/**
 * 获取apk路径列表(分包后会有多个文件)
 */
fun getSourcePathList(context: Context): List<String> {
    val sourcePathList = mutableListOf<String>()
    val appInfo: ApplicationInfo

    try {
        appInfo = context.packageManager.getApplicationInfo(context.packageName, 0)
    } catch (e: PackageManager.NameNotFoundException) {
        return sourcePathList
    }
    val sourceApk = File(appInfo.sourceDir)
    // 其他的文件前缀名称(dex分包后其他额外的包) 例如: base.apk.classes
    val extraFilePrefix = sourceApk.name + EXTRACTED_NAME_EXT

    // 添加默认apk路径
    sourcePathList.add(appInfo.sourceDir)
    // 注意: 通过是否存在sp中的multidex.version是不准确的，因为从低版本升级上来的用户，是包含这个sp配置的
    if (!isVMMultidexCapable) {
        // VM不支持dex分包(Api21以下), 使用Multidex框架不影响
        val totalDexNumber = getMultiDexPreferences(context).getInt(KEY_DEX_NUMBER, 1)
        val dexDir = File(appInfo.dataDir, SECONDARY_FOLDER_NAME)

        for (secondaryNumber in 2..totalDexNumber) {
            val extraFileName = extraFilePrefix + secondaryNumber + EXTRACTED_SUFFIX
            val extraFile = File(dexDir, extraFileName)

            if (extraFile.isFile) {
                sourcePathList.add(extraFile.absolutePath)
            } else {
                throw IOException("Missing extracted secondary dex file '" + extraFile.absolutePath + "'")
            }
        }
    }
    return sourcePathList
}

/**
 * VM是否可以有dex分包(multidex)能力, 注: Android5.0(API 21)以上 VM 有此能力，以下需要使用 Multidex 框架
 *
 * @return true: VM有dex分包能力
 */
private val isVMMultidexCapable: Boolean
        get() = try {
            if (isAliYunOS()) {
                val sdkVersion = System.getProperty("ro.build.version.sdk")?.toInt() ?: Build.VERSION_CODES.BASE

                sdkVersion >= Build.VERSION_CODES.LOLLIPOP
            } else {
                val vmVersion = System.getProperty("java.vm.version")

                if (!vmVersion.isNullOrEmpty()) {
                    val matcher = compile("(\\\\d+)\\\\.(\\\\d+)(\\\\.\\\\d+)?").matcher(vmVersion)

                    if (matcher.matches()) {
                        try {
                            val major = matcher.group(1)?.toInt() ?: 0
                            val minor = matcher.group(2)?.toInt() ?: 0

                            (major > VM_WITH_MULTIDEX_VERSION_MAJOR) || ((major == VM_WITH_MULTIDEX_VERSION_MAJOR) && (minor >= VM_WITH_MULTIDEX_VERSION_MINOR))
                        } catch (e: Exception) {
                            false
                        }
                    } else {
                        false
                    }
                } else {
                    false
                }
            }
        } catch (e: Exception) { false }

/**
 * 判断是不是阿里云操作系统 (基于Android, 车辆网和物联网上可能有用到的)
 *
 * @return true: 是 阿里云OS
 */
private fun isAliYunOS() = try {
    val version = System.getProperty("ro.yunos.version")
    val vmName = System.getProperty("java.vm.name")

    (vmName != null && vmName.toLowerCase(Locale.getDefault()).contains("lemur")) || (version != null && version.trim().isNotEmpty())
} catch (e: Exception) {
    false
}

/**
 * 获取 MultiDex 存储在本地的 SharedPreferences
 */
@SuppressLint("ObsoleteSdkInt")
private fun getMultiDexPreferences(
    context: Context
) = context.getSharedPreferences(PREFS_FILE, if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) MODE_PRIVATE else (MODE_PRIVATE or MODE_MULTI_PROCESS))