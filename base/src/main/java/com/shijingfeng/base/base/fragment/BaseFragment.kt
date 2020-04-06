package com.shijingfeng.base.base.fragment

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.view.*
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.annotation.IntRange
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import com.blankj.utilcode.util.ToastUtils
import com.kingja.loadsir.callback.SuccessCallback
import com.kingja.loadsir.core.LoadService
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.shijingfeng.base.R
import com.shijingfeng.base.interfaces.BackPressMonitor
import com.shijingfeng.base.annotation.BindEventBus
import com.shijingfeng.base.annotation.NeedPermissions
import com.shijingfeng.base.callback.EmptyCallback
import com.shijingfeng.base.callback.LoadFailCallback
import com.shijingfeng.base.callback.LoadingCallback
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.common.extension.onItemEvent
import com.shijingfeng.base.interfaces.KeyDownMonitor
import com.shijingfeng.base.util.*
import com.shijingfeng.base.widget.StatusBarView
import com.shijingfeng.base.widget.dialog.LoadingDialog
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import org.greenrobot.eventbus.EventBus
import java.io.File

/**
 * Function: Fragment 基类
 * Date: 2020/3/21 13:25
 * Description:
 * @author ShiJingFeng
 */
abstract class BaseFragment : Fragment(), KeyDownMonitor, BackPressMonitor, CoroutineScope by MainScope() {

    /** Disposable容器  */
    private val mCompositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    /** Fragment Root View */
    protected var mRootView: View? = null
    /** LoadSir  */
    protected var mLoadService: LoadService<*>? = null
    /** SmartRefresh */
    protected var mSmartRefreshLayout: SmartRefreshLayout? = null

    /** 响应式权限请求框架  */
    protected var mRxPermissions: RxPermissions? = null

    /** 回调监听器  */
    protected var mOnItemEvent: onItemEvent? = null

    /** 跳转到 Fragment 携带的数据 或 Fragment重启保存的 Bundle 数据(未来会加上) */
    protected var mDataBundle: Bundle? = null

    /** 暂存数据  */
    /** 相机Uri  */
    protected var mCameraUri: Uri? = null
    /** 相机图片缓存文件地址  */
    protected var mCameraTempFilePath: String = ""
    /** 裁剪图片缓存文件地址  */
    protected var mClipTempFilePath: String = ""

    /** Fragment View是否已创建完成   true 已创建完成  false 没有创建过 或 没有创建完成  */
    protected var mHasCreated = false

    /**
     * 创建 Fragment Root View
     * @param inflater LayoutInflater
     * @param container 父View容器
     * @param savedInstanceState Fragment View 重建 保存的Bundle数据
     * @return View
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mRootView = inflater.inflate(getLayoutId(), container, false)

        return mRootView
    }

    /**
     * Fragment View创建完毕回调函数
     * 禁止重载onViewCreated方法进行添加额外的初始化方法
     * 初始化请重载 [init]
     * @param view View
     * @param savedInstanceState 保存的Bundle数据
     */
    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!isEnableLazyLoad()) {
            init(savedInstanceState)
        }
    }

    /**
     * 当 Fragment可见时，才执行onResume方法，否则不执行onResume方法 (参考setMaxLifecycle方法) (用于ViewPager懒加载)
     */
    override fun onResume() {
        super.onResume()
        if (isEnableLazyLoad() && !mHasCreated) {
            init()
        }
        //初始化状态栏
        initStatusBar()
    }

    /**
     * 因为有懒加载的缘故 子类初始化需要时重载init方法，禁止重载onViewCreated方法进行添加额外的初始化方法
     * @param savedInstanceState Fragment重启携带的 Bundle 数据
     */
    protected open fun init(savedInstanceState: Bundle? = null) {
        initParam()
        initData()
        initAction()
        mHasCreated = true
    }

    /**
     * 获取视图ID
     * @return 视图ID
     */
    protected abstract fun getLayoutId(): Int

    /**
     * 初始化参数
     */
    protected open fun initParam() {
        mDataBundle = arguments
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
        //设置状态栏高度
        if (!isSetCustomStatusBar() && activity != null && mRootView != null) {
            val contentView = mRootView!!
            val statusBarView = StatusBarView(activity!!)

            statusBarView.id = R.id.status_bar_view
            statusBarView.background = getStatusBarBackground()

            when (contentView) {
                is LinearLayout -> contentView.addView(statusBarView, 0)
                is FrameLayout -> {
                    contentView.addView(statusBarView)

                    statusBarView.layoutParams =
                        (statusBarView.layoutParams as FrameLayout.LayoutParams).apply {
                            gravity = Gravity.TOP
                            width = ViewGroup.LayoutParams.MATCH_PARENT
                            height = getStatusBarHeight()
                        }
                }
                else -> {
                    val parent = contentView.parent as ViewGroup?

                    if (parent != null) {
                        parent.removeAllViews()
                        LinearLayout(activity).run {
                            orientation = LinearLayout.VERTICAL
                            addView(statusBarView)
                            addView(contentView)
                            parent.addView(this)
                            layoutParams = layoutParams.apply {
                                width = ViewGroup.LayoutParams.MATCH_PARENT
                                height = ViewGroup.LayoutParams.MATCH_PARENT
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
     * 初始化状态栏
     */
    private fun initStatusBar() {
        //设置默认状态栏背景颜色 为透明色
        activity?.run {
            setStatusBarColor(this, R.color.transparency)
            //设置默认状态栏字体颜色 为浅色
            setStatusBarContentColor(this, isSetStatusBarContentDark())
        }
    }

    /**
     * 是否开启懒加载 (用于ViewPager)
     * @return true 开启  false 关闭  默认关闭
     */
    protected open fun isEnableLazyLoad() = false

    /**
     * 是否自定义设置状态栏
     * @return true 自定义设置  false 默认设置
     */
    protected open fun isSetCustomStatusBar() = true

    /**
     * 是否设置状态栏内容颜色为深色
     * @return true 深色  false 浅色
     */
    protected open fun isSetStatusBarContentDark() = false

    /**
     * 获取状态栏背景
     * @return 背景 Drawable
     */
    protected open fun getStatusBarBackground() = getDrawableById(R.color.project_status_bar_default_color)

    /**
     * LoadSir 切换状态
     * @param status 要切换到的状态  默认: [LOAD_SERVICE_SUCCESS]
     */
    protected fun showCallback(@IntRange(from = 0, to = 3) status: Int) {
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
    protected fun updateRefreshLoadMoreStatus(status: Int) {
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
     * 跳转Activity页面
     * @param cls 要跳转到的页面反射Class
     * @param bundle 携带的数据
     * @param requestCode 请求码
     */
    protected fun startActivity(cls: Class<*>, bundle: Bundle? = null, requestCode: Int = -1) {
        activity?.let { activity ->
            startActivityForResult(Intent().apply {
                setClass(activity, cls)
                if (bundle != null) {
                    putExtras(bundle)
                }
            }, requestCode)
        }
    }

    /**
     * 打开相机
     */
    protected fun openCamera() {
        activity?.let { activity ->
            if (ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                //权限已授予，执行打开相机操作
                val saveFile = File(PERSONAL_CACHE_DIR, "shoot_" + System.currentTimeMillis() + ".jpg")

                mCameraTempFilePath = saveFile.absolutePath

                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    mCameraUri = FileProvider.getUriForFile(activity, activity.applicationInfo.processName + ".FileProvider", saveFile)
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                    intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
                } else {
                    mCameraUri = Uri.fromFile(saveFile)
                }
                intent.putExtra(MediaStore.EXTRA_OUTPUT, mCameraUri)
                startActivityForResult(intent, RESULT_CAMERA)
            } else {
                //权限未授予，请求相机权限
                mRxPermissions?.run {
                    addDisposable(
                        this
                            .requestEach(Manifest.permission.CAMERA)
                            .subscribe { permission ->
                                when {
                                    permission.granted -> {
                                        openCamera()
                                    }
                                    permission.shouldShowRequestPermissionRationale -> {
                                        ToastUtils.showShort(getStringById(R.string.相机权限授予失败))
                                    }
                                    else -> {
                                        AlertDialog.Builder(activity)
                                            .setMessage(getStringById(R.string.设置页面开启相机权限))
                                            .setPositiveButton(getStringById(R.string.去设置)) { _, _ ->
                                                startActivity(Intent().apply {
                                                    action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                                                    data = Uri.fromParts("package", activity.packageName, null)
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
    }

    /**
     * 打开相册
     */
    protected fun openPhoto() {
        activity?.let { activity ->
            if (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
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
                                        AlertDialog.Builder(activity)
                                            .setMessage(getStringById(R.string.设置页面开启外部存储权限))
                                            .setPositiveButton(getStringById(R.string.去设置)) {_, _ ->
                                                startActivity(Intent().apply {
                                                    action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                                                    data = Uri.fromParts("package", activity.packageName, null)
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
    }

    /**
     * 对图片进行裁剪
     *
     * @param data 原始图片URI
     */
    protected fun startImageClip(data: Uri?) {
        val intent = Intent("com.android.camera.action.CROP")
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
     * 添加Disposable
     * @param disposable Disposable
     */
    protected fun addDisposable(disposable: Disposable) {
        mCompositeDisposable.add(disposable)
    }

    /**
     * 清空Disposable
     */
    private fun clearDisposable() {
        mCompositeDisposable.clear()
    }

    /**
     * 设置回调监听器
     * @param onItemEvent 回调监听器
     */
    fun setOnItemEventListener(onItemEvent: onItemEvent?) {
        this.mOnItemEvent = onItemEvent
    }

    /**
     * 返回键点击 回调方法
     * @return true Fragment消费处理  false 交由Activity处理
     */
    override fun onBackPressed() = false

    /**
     * 模拟按键 按下监听 回调方法
     * @param keyCode 模拟按键 代码
     * @param event 事件
     * @return  true Fragment消费处理   false 交由Activity处理
     */
    override fun onKeyDown(keyCode: Int, event: KeyEvent?) = false

    /**
     * Fragment View 销毁回调
     */
    override fun onDestroyView() {
        mHasCreated = false
        mRootView = null
        //销毁加载中Dialog
        LoadingDialog.getInstance().destroy()
        super.onDestroyView()
    }

    /**
     * Fragment 销毁回调
     */
    override fun onDestroy() {
        //解除对Activity的引用
        mOnItemEvent = null
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