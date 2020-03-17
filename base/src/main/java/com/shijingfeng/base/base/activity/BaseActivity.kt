package com.shijingfeng.base.base.activity

import android.Manifest.permission.CAMERA
import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.util.SparseArray
import android.util.SparseIntArray
import android.view.Gravity.TOP
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.LinearLayout.VERTICAL
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.ResourceUtils
import com.blankj.utilcode.util.ToastUtils
import com.kingja.loadsir.core.LoadService
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.shijingfeng.base.R
import com.shijingfeng.base.annotation.BindEventBus
import com.shijingfeng.base.annotation.NeedPermissions
import com.shijingfeng.base.base.viewmodel.BaseViewModel
import com.shijingfeng.base.callback.EmptyCallback
import com.shijingfeng.base.callback.LoadFailCallback
import com.shijingfeng.base.callback.LoadingCallback
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.util.finishPreviousActivity
import com.shijingfeng.base.util.getDrawableById
import com.shijingfeng.base.util.setStatusBarColor
import com.shijingfeng.base.util.setStatusBarContentColor
import com.shijingfeng.base.widget.StatusBarView
import com.shijingfeng.base.widget.dialog.LoadingDialog
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import org.greenrobot.eventbus.EventBus
import java.io.File

/**
 * Function: 用于MVVM或AAC模式的 Activity基类
 * Date: 2020/1/18 15:07
 * Description:
 * @author ShiJingFeng
 */
abstract class BaseActivity<V : ViewDataBinding, VM : BaseViewModel<*>> : MvvmActivity<V, VM>(), CoroutineScope by MainScope() {

    /** Disposable容器  */
    private val mCompositeDisposable by lazy { CompositeDisposable() }

    /** LoadSir  */
    protected var mLoadService: LoadService<*>? = null
    /** SmartRefresh */
    protected var mSmartRefreshLayout: SmartRefreshLayout? = null

    /** RxPermission (响应式权限申请框架)  */
    protected var mRxPermissions: RxPermissions? = null

    /** 暂存数据 */
    /** 相机Uri  */
    protected var mCameraUri: Uri? = null
    /** 相机图片缓存文件地址  */
    protected var mCameraTempFilePath = ""
    /** 裁剪图片缓存文件地址  */
    protected var mClipTempFilePath = ""

    /** 前一个 Activity 是否销毁  */
    private var mIsPreActivityFinished = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initParam()
        initData()
        initAction()
        if (mViewModel != null) {
            initObserver()
        }
    }

    override fun onStart() {
        super.onStart()
        initStatusBar()
    }

    /**
     * Activity 进入动画 完成回调
     */
    override fun onEnterAnimationComplete() {
        super.onEnterAnimationComplete()
        mViewModel?.mBundle?.run {
            val finishPrevious = getBoolean(FINISH_PREVIOUS_ACTIVITY, false)
            val finishFrontAll = getBoolean(FINISH_FRONT_ALL_ACTIVITY, false)

            //销毁前一个Activity
            if (finishPrevious && !mIsPreActivityFinished) {
                finishPreviousActivity(this@BaseActivity, false)
                mIsPreActivityFinished = true
            }
            //销毁前面所有的Activity
            if (finishFrontAll) {
                ActivityUtils.finishAllActivitiesExceptNewest(false)
            }
        }
    }

    /**
     * 初始化状态栏
     */
    private fun initStatusBar() {
        //设置默认状态栏背景颜色 为透明色
        setStatusBarColor(this, R.color.transparency)
        //设置默认状态栏字体颜色 为浅色
        setStatusBarContentColor(this, isSetStatusBarContentDark())
    }

    /**
     * 初始化参数
     */
    protected open fun initParam() {
        mViewModel?.mBundle = intent?.extras
    }

    /**
     * 初始化数据
     */
    protected open fun initData() {
        //创建RxPermission对象
        if (this.javaClass.isAnnotationPresent(NeedPermissions::class.java) && mRxPermissions == null) {
            mRxPermissions = RxPermissions(this)
        }
        //注册EventBus
        if (this.javaClass.isAnnotationPresent(BindEventBus::class.java) && !EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this)
        }
        //设置屏幕方向
        requestedOrientation = getScreenOrientation()
        //设置状态栏高度
        if (!isSetCustomStatusBarHeight()) {
            val contentView = getContentView()
            val statusBarView = StatusBarView(this)

            statusBarView.id = R.id.status_bar_view
            statusBarView.background = getStatusBarBackground()

            if (contentView.childCount > 0) {

                when (val userContentView = contentView.getChildAt(0)) {
                    is LinearLayout -> userContentView.addView(statusBarView, 0)
                    is FrameLayout -> {
                        userContentView.addView(statusBarView)
                        statusBarView.layoutParams = (statusBarView.layoutParams as FrameLayout.LayoutParams).apply {
                            gravity = TOP
                        }
                    }
                    else -> {
                        contentView.removeAllViews()
                        LinearLayout(this@BaseActivity).run {
                            orientation = VERTICAL
                            addView(statusBarView)
                            addView(userContentView)
                            contentView.addView(this)
                            layoutParams = layoutParams.apply {
                                width = MATCH_PARENT
                                height = MATCH_PARENT
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 初始化事件
     */
    protected open fun initAction() {}

    /**
     * 初始化 LiveData Observer
     */
    protected open fun initObserver() {
        //显示加载中提示对话框
        mViewModel?.getCommonEventManager()?.getShowLoadingDialogEvent()?.observe(this, Observer<String> { hint ->
            LoadingDialog.getInstance()
                .setHintText(hint)
                .show(this)
        })
        //隐藏加载中提示对话框
        mViewModel?.getCommonEventManager()?.getHideLoadingDialogEvent()?.observe(this, Observer<Any?> {
            LoadingDialog.getInstance().hide()
        })
        //切换Activity
        mViewModel?.getCommonEventManager()?.getStartActivityEvent()?.observe(this, Observer<SparseArray<Any?>>{ sparseArray ->
            sparseArray?.run {
                val cls = get(KEY_CLASS) as Class<*>
                val bundle = get(KEY_BUNDLE) as? Bundle?
                val requestCode = get(KEY_REQUEST_CODE) as Int

                startActivity(cls, bundle, requestCode)
            }
        })
        //通过 ARouter 切换 Activity
        mViewModel?.getCommonEventManager()?.getNavigationEvent()?.observe(this, Observer<SparseArray<Any?>> { sparseArray ->
            sparseArray?.run {
                val path = get(KEY_PATH) as String
                val bundle = get(KEY_BUNDLE) as? Bundle?
                //注意 当 requestCode > 0 时，才会回调 onActivityResult, 所不同的是 startActivityForResult 当 requestCode > -1 时才会回调 onActivityResult
                val requestCode = get(KEY_REQUEST_CODE) as Int
                val navigationCallback = get(KEY_NAVIGATION_CALLBACK) as? NavigationCallback?
                val animSparseArray = get(KEY_ANIM_SPARSE_ARRAY) as? SparseIntArray?

                with(ARouter.getInstance().build(path)) {
                    with(bundle)
                    animSparseArray?.run {
                        val enterAnim = get(KEY_ENTER_ANIM)
                        val exitAnim = get(KEY_EXIT_ANIM)

                        withTransition(enterAnim, exitAnim)
                    }
                    navigation(this@BaseActivity, requestCode, navigationCallback)
                }
            }
        })
        //关闭销毁Activity
        mViewModel?.getCommonEventManager()?.getFinishEvent()?.observe(this, Observer<SparseArray<Any?>> { sparseArray ->
            finish()
            sparseArray?.get(KEY_ANIM_SPARSE_ARRAY)?.run {
                val animSparseArray: SparseIntArray = this as SparseIntArray
                val enterAnim = animSparseArray.get(KEY_ENTER_ANIM)
                val exitAnim = animSparseArray.get(KEY_EXIT_ANIM)

                overridePendingTransition(enterAnim, exitAnim)
            }
        })
        //Activity setResult设置返回响应
        mViewModel?.getCommonEventManager()?.getSetResultEvent()?.observe(this, Observer<SparseArray<Any?>> { sparseArray ->
            sparseArray?.run {
                val resultCode = get(KEY_RESULT_CODE, RESULT_CANCELED) as Int
                val resultData = get(KEY_RESULT_DATA, null) as? Intent?

                setResult(resultCode, resultData)
            }
        })
        //LoadService 状态 LiveData Event监听器
        mLoadService?.run {
            mViewModel?.getLoadServiceStatusEvent()?.observe(this@BaseActivity, Observer { status ->
                when (status) {
                    SUCCESS -> showSuccess()
                    LOADING -> showCallback(LoadingCallback::class.java)
                    EMPTY -> showCallback(EmptyCallback::class.java)
                    LOAD_FAIL -> showCallback(LoadFailCallback::class.java)
                }
            })
        }
        //SmartRefreshLayout 状态 LiveData Event监听器
        mSmartRefreshLayout?.run {
            mViewModel?.getRefreshLoadMoreStatusEvent()?.observe(this@BaseActivity, Observer { status ->
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
            })
        }
    }

    /**
     * 是否自定义设置状态栏高度
     * @return true 自定义设置  false 默认设置
     */
    protected open fun isSetCustomStatusBarHeight(): Boolean = false

    /**
     * 是否设置状态栏内容颜色为深色
     * @return true 深色  false 浅色
     */
    protected open fun isSetStatusBarContentDark(): Boolean = false

    /**
     * 获取状态栏背景
     * @return 背景 Drawable
     */
    protected open fun getStatusBarBackground() = getDrawableById(R.color.project_status_bar_default_color)

    /**
     * 获取屏幕方向
     * @return 屏幕方向 (默认竖屏)
     */
    protected open fun getScreenOrientation(): Int = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    /**
     * 跳转Activity页面
     * @param cls 要跳转到的页面反射Class
     * @param bundle 携带的数据
     * @param requestCode 请求码
     */
    fun startActivity(cls: Class<*>, bundle: Bundle? = null, requestCode: Int = -1) {
        startActivityForResult(Intent().apply {
            setClass(this@BaseActivity, cls)
            if (bundle != null) {
                putExtras(bundle)
            }
        }, requestCode)
    }

    /**
     * 打开相机
     */
    fun openCamera() {
        if (ContextCompat.checkSelfPermission(this, CAMERA) == PackageManager.PERMISSION_GRANTED) {
            //权限已授予，执行打开相机操作
            val saveFile = File(PERSONAL_CACHE_DIR, "shoot_" + System.currentTimeMillis() + ".jpg")

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
                        .requestEach(CAMERA)
                        .subscribe {
                            when {
                                it.granted -> {
                                    openCamera()
                                }
                                it.shouldShowRequestPermissionRationale -> {
                                    ToastUtils.showShort("相机权限授予失败")
                                }
                                else -> {
                                    AlertDialog.Builder(this@BaseActivity)
                                        .setMessage("需要您去设置页面，「权限管理」，开启「相机」权限")
                                        .setPositiveButton("去设置") {_, _ ->
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
    fun openPhoto() {
        if (ContextCompat.checkSelfPermission(this, READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            //权限已授予，打开相册
            startActivityForResult(Intent.createChooser(Intent().apply {
                action = Intent.ACTION_PICK
                setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*")
            }, "选择图片"), RESULT_PHOTO)
        } else {
            //权限未授予，请求相机权限
            mRxPermissions?.run {
                addDisposable(
                    this
                        .requestEach(READ_EXTERNAL_STORAGE)
                        .subscribe {
                            when {
                                it.granted -> {
                                    openPhoto()
                                }
                                it.shouldShowRequestPermissionRationale -> {
                                    ToastUtils.showShort("外部存储权限授予失败")
                                }
                                else -> {
                                    AlertDialog.Builder(this@BaseActivity)
                                        .setMessage("需要您去设置页面，「权限管理」，开启「外部存储」权限")
                                        .setPositiveButton("去设置") {_, _ ->
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
    fun startImageClip(data: Uri?) {
        val saveClipImageFile = File(PERSONAL_CACHE_DIR, "clip_" + System.currentTimeMillis() + ".jpg")

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
     * 获取 ContentView
     *
     * @return ContentView
     */
    fun getContentView(): ViewGroup = findViewById(android.R.id.content)

    /**
     * 添加Disposable
     * @param disposable Disposable
     */
    fun addDisposable(disposable: Disposable) {
        if (mViewModel == null) {
            mCompositeDisposable.add(disposable)
        } else {
            mViewModel?.mCompositeDisposable?.add(disposable)
        }
    }

    /**
     * 清空Disposable
     */
    private fun clearDisposable() {
        if (mViewModel == null) {
            mCompositeDisposable.clear()
        } else {
            mViewModel?.mCompositeDisposable?.clear()
        }
    }

    /**
     * 关闭Activity (自定义 Activity 关闭动画)
     * @param enterAnim 前一个 Activity 进入动画
     * @param exitAnim 当前要销毁的 Activity 退出动画
     */
    fun finish(enterAnim: Int, exitAnim: Int) {
        finish()
        overridePendingTransition(enterAnim, exitAnim)
    }

    override fun onDestroy() {
        super.onDestroy()
        //销毁加载中Dialog
        LoadingDialog.getInstance().destroy()
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
    }

}