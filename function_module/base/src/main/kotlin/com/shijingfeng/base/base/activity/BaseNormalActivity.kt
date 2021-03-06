package com.shijingfeng.base.base.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.blankj.utilcode.util.KeyboardUtils
import com.blankj.utilcode.util.ToastUtils
import com.kingja.loadsir.core.LoadService
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.shijingfeng.base.R
import com.shijingfeng.base.annotation.BindEventBus
import com.shijingfeng.base.annotation.NeedPermissions
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.widget.dialog.LoadingDialog
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import org.greenrobot.eventbus.EventBus
import java.io.File
import com.kingja.loadsir.callback.SuccessCallback
import com.shijingfeng.base.annotation.define.LoadServiceStatus
import com.shijingfeng.base.annotation.define.RefreshLoadMoreStatus
import com.shijingfeng.base.callback.EmptyCallback
import com.shijingfeng.base.callback.LoadFailCallback
import com.shijingfeng.base.callback.LoadingCallback
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.base.widget.LoadingView
import kotlinx.coroutines.launch

/**
 * Function: 通用的 Activity 基类
 * Date: 2020/3/21 10:48
 * Description:
 * Author: ShiJingFeng
 */
abstract class BaseNormalActivity : BaseActivity(), CoroutineScope by MainScope() {

    /** Disposable容器  */
    private val mCompositeDisposable by lazy { CompositeDisposable() }

    /** LoadSir  */
    protected var mLoadService: LoadService<*>? = null
    /** SmartRefresh */
    protected var mSmartRefreshLayout: SmartRefreshLayout? = null
    /** LoadingView */
    protected var mLoadingView: LoadingView? = null

    /** RxPermission (响应式权限申请框架)  */
    protected var mRxPermissions: RxPermissions? = null

    /** 暂存数据 */
    /** 相机Uri  */
    protected var mCameraUri: Uri? = null
    /** 相机图片缓存文件地址  */
    protected var mCameraTempFilePath = ""
    /** 裁剪图片缓存文件地址  */
    protected var mClipTempFilePath = ""

    /**
     * 初始化
     * @param savedInstanceState Activity重启 携带的Bundle数据
     */
    override fun init(savedInstanceState: Bundle?) {
        super.init(savedInstanceState)
        val layoutId = getLayoutId()

        if (layoutId != NO_LAYOUT) {
            setContentView(layoutId)
        }
        initParam()
        initData()
        initAction()
    }

    /**
     * 初始化数据
     */
    override fun initData() {
        super.initData()
        //创建RxPermission对象
        if (this.javaClass.isAnnotationPresent(NeedPermissions::class.java) && mRxPermissions == null) {
            mRxPermissions = RxPermissions(this)
        }
        //注册EventBus
        if (this.javaClass.isAnnotationPresent(BindEventBus::class.java) && !EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this)
        }
        //Activity默认背景为白色
        mContentView.background = getActivityBackground()
        //设置屏幕方向
        requestedOrientation = getScreenOrientation()
    }

    /**
     * LoadSir 切换状态
     * @param status 要切换到的状态  默认: [LOAD_SERVICE_SUCCESS]
     */
    protected open fun showCallback(@LoadServiceStatus status: Int) {
        mLoadService?.showCallback(when (status) {
            // LoadSir 状态: 成功
            LOAD_SERVICE_SUCCESS -> SuccessCallback::class.java
            // LoadSir 状态: 加载中
            LOAD_SERVICE_LOADING -> LoadingCallback::class.java
            // LoadSir 状态: 暂无数据
            LOAD_SERVICE_EMPTY -> EmptyCallback::class.java
            // LoadSir 状态: 加载失败
            LOAD_SERVICE_LOAD_FAIL -> LoadFailCallback::class.java
            // 默认 LoadSir 状态 成功
            else -> SuccessCallback::class.java
        })
    }

    /**
     * 更新 下拉刷新，上拉加载 状态
     * @param status 下拉刷新 或 上拉加载 状态  默认: [REFRESH_SUCCESS]
     */
    protected open fun updateRefreshLoadMoreStatus(@RefreshLoadMoreStatus status: Int) {
        mSmartRefreshLayout?.run {
            when (status) {
                // 下拉刷新成功
                REFRESH_SUCCESS -> finishRefresh(true)
                // 下拉刷新失败
                REFRESH_FAIL -> finishRefresh(false)
                // 上拉加载成功
                LOAD_MORE_SUCCESS -> finishLoadMore(true)
                // 上拉加载失败
                LOAD_MORE_FAIL -> finishLoadMore(false)
                // 上拉加载 所有数据加载完毕
                LOAD_MORE_ALL -> finishLoadMoreWithNoMoreData()
                else -> {}
            }
        }
    }

    /**
     * 注册 LoadingView
     *
     * @param view View
     * @param hintText 文本提示
     */
    protected fun registerLoadingView(
        view: View? = null,
        hintText: String? = null
    ) {
        mLoadingView = if (view == null) {
            LoadingView.Builder(this)
                .setHintText(hintText)
                .build()
        } else {
            LoadingView.Builder(view)
                .setHintText(hintText)
                .build()
        }
    }

    /**
     * 显示 LoadingView
     *
     * @param hintText 文本提示
     */
    protected fun showLoadingView(
        hintText: String? = null
    ) {
        KeyboardUtils.hideSoftInput(this)
        mLoadingView?.show(hintText) ?: throw RuntimeException("LoadingView 未注册")
    }

    /**
     * 隐藏 LoadingView
     */
    protected fun hideLoadingView() {
        mLoadingView?.hide() ?: throw RuntimeException("LoadingView 未注册")
    }

    /**
     * 打开相机
     */
    protected fun openCamera() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            //权限已授予，执行打开相机操作
            val saveFile = File(PERSONAL_EXTERNAL_CACHE_DIR, "shoot_" + System.currentTimeMillis() + ".jpg")

            mCameraTempFilePath = saveFile.absolutePath

            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                mCameraUri = FileProvider.getUriForFile(
                    this,
                    applicationInfo.processName + ".FileProvider",
                    saveFile
                )
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
            } else {
                mCameraUri = Uri.fromFile(saveFile)
            }
            intent.putExtra(MediaStore.EXTRA_OUTPUT, mCameraUri)
            startActivityForResult(intent,
                RESULT_CAMERA
            )
        } else {
            //权限未授予，请求相机权限
            mRxPermissions?.run {
                addDisposable(
                    this
                        .requestEach(Manifest.permission.CAMERA)
                        .subscribe {
                            when {
                                it.granted -> {
                                    openCamera()
                                }
                                it.shouldShowRequestPermissionRationale -> {
                                    ToastUtils.showShort(getStringById(R.string.相机权限授予失败))
                                }
                                else -> {
                                    AlertDialog.Builder(this@BaseNormalActivity)
                                        .setMessage(getStringById(R.string.设置页面开启相机权限))
                                        .setPositiveButton(getStringById(R.string.去设置)) { _, _ ->
                                            startActivity(Intent().apply {
                                                action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                                                data = Uri.fromParts("package", packageName, null)
                                                flags = Intent.FLAG_ACTIVITY_NEW_TASK
                                            })
                                        }
                                        .setOnDismissListener(null)
                                        .setCancelable(false)
                                        .show()
                                }
                            }
                        }
                )
            }
        }
    }

    /**
     * 打开相册
     */
    protected fun openPhoto() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            //权限已授予，打开相册
            startActivityForResult(Intent.createChooser(Intent().apply {
                action = Intent.ACTION_PICK
                setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*")
            }, getStringById(R.string.选择图片)), RESULT_PHOTO)
        } else {
            //权限未授予，请求相机权限
            mRxPermissions?.run {
                addDisposable(
                    this
                        .requestEach(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .subscribe {
                            when {
                                it.granted -> {
                                    openPhoto()
                                }
                                it.shouldShowRequestPermissionRationale -> {
                                    ToastUtils.showShort(getStringById(R.string.外部存储权限授予失败))
                                }
                                else -> {
                                    AlertDialog.Builder(this@BaseNormalActivity)
                                        .setMessage(getStringById(R.string.设置页面开启外部存储权限))
                                        .setPositiveButton(getStringById(R.string.去设置)) { _, _ ->
                                            startActivity(Intent().apply {
                                                action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                                                data = Uri.fromParts("package", packageName, null)
                                                flags = Intent.FLAG_ACTIVITY_NEW_TASK
                                            })
                                        }
                                        .setOnDismissListener(null)
                                        .setCancelable(false)
                                        .show()
                                }
                            }
                        }
                )
            }
        }
    }

    /**
     * 对图片进行裁剪
     *
     * @param data 原始图片URI
     */
    protected fun startImageClip(data: Uri?) {
        val saveClipImageFile = File(PERSONAL_EXTERNAL_CACHE_DIR, "clip_" + System.currentTimeMillis() + ".jpg")

        mClipTempFilePath = saveClipImageFile.absolutePath
        startActivityForResult(Intent().apply {
            action = "com.android.camera.action.CROP"
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }
            setDataAndType(data, "image/*")
            putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(saveClipImageFile))
            //        intent.putExtra("aspectX", 1);  // 裁剪框 X轴比例
//        intent.putExtra("aspectY", 1);  //裁剪框 Y轴比例
//        intent.putExtra("outputX", 200);  // 输出图片 X轴大小
//        intent.putExtra("outputY", 200);  //输出图片 Y轴大小
//        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());  //设置图片格式
            putExtra("crop", "true") //是否剪切
            putExtra("scale", true) //设置可缩放
            putExtra("scaleUpIfNeeded", true) // c去黑边
            putExtra("return-data", false) //禁止startActivityOnResult返回Bitmap
        }, RESULT_CLIP)
    }

    /**
     * 添加Disposable
     * @param disposable Disposable
     */
    protected fun addDisposable(disposable: Disposable) = mCompositeDisposable.add(disposable)

    /**
     * 清空Disposable
     */
    protected fun clearDisposable() = mCompositeDisposable.clear()

    /**
     * Activity销毁回调
     */
    override fun onDestroy() {
        // 销毁加载中Dialog
        LoadingDialog.getInstance().destroy()
        // 销毁 LoadingView
        mLoadingView?.destroy()
        //销毁权限申请框架
        mRxPermissions = null
        //清空Disposable
        clearDisposable()
        //关闭 协程任务
        cancel()
        //解注册EventBus
        if (this.javaClass.isAnnotationPresent(BindEventBus::class.java) && EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this)
        }
        super.onDestroy()
    }

}