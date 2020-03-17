package com.shijingfeng.base.base.fragment

import android.Manifest
import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.content.Intent
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
import android.view.KeyEvent
import android.view.View
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
import com.blankj.utilcode.util.ToastUtils
import com.kingja.loadsir.core.LoadService
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.shijingfeng.base.R
import com.shijingfeng.base.annotation.BindEventBus
import com.shijingfeng.base.annotation.NeedPermissions
import com.shijingfeng.base.base.activity.BaseActivity
import com.shijingfeng.base.base.viewmodel.BaseViewModel
import com.shijingfeng.base.callback.EmptyCallback
import com.shijingfeng.base.callback.LoadFailCallback
import com.shijingfeng.base.callback.LoadingCallback
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.common.extension.OnItemEvent
import com.shijingfeng.base.util.getDrawableById
import com.shijingfeng.base.util.getStatusBarHeight
import com.shijingfeng.base.util.setStatusBarColor
import com.shijingfeng.base.util.setStatusBarContentColor
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
 * Function: Fragment基类
 * Date: 2020/1/20 14:42
 * Description:
 * @author ShiJingFeng
 */
abstract class BaseFragment<V : ViewDataBinding, VM : BaseViewModel<*>> : MvvmFragment<V, VM>(), CoroutineScope by MainScope() {

    /** Disposable容器  */
    private val mCompositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    /** Activity Context  */
    protected var mActivity: BaseActivity<*, *>? = null
    /** LoadSir  */
    protected var mLoadService: LoadService<*>? = null
    /** SmartRefresh */
    protected var mSmartRefreshLayout: SmartRefreshLayout? = null

    /** 响应式权限请求框架  */
    protected var mRxPermissions: RxPermissions? = null

    /** 回调监听器  */
    protected var mOnItemEvent: OnItemEvent? = null

    /** 暂存数据  */
    /** 相机Uri  */
    protected var mCameraUri: Uri? = null
    /** 相机图片缓存文件地址  */
    protected var mCameraTempFilePath: String = ""
    /** 裁剪图片缓存文件地址  */
    protected var mClipTempFilePath: String = ""

    /** 是否创建完成   true 创建完成  false 没有创建过 或 没有创建完成  */
    protected var mHasCreated = false

    @TargetApi(23)
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity<*, *>) {
            mActivity = context
        } else {
            throw RuntimeException("BaseFragment: Context不能强转为BaseActivity")
        }
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        mActivity = activity as? BaseActivity<*, *>?
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!isEnableLazyLoad()) {
            init()
            mViewModel?.let {
                if (!it.mHasInited) {
                    it.init()
                }
            }
        }
    }

    /**
     * 当 Fragment可见时，才执行onResume方法，否则不执行onResume方法 (参考setMaxLifecycle方法)
     */
    override fun onResume() {
        super.onResume()
        if (isEnableLazyLoad() && !mHasCreated) {
            init()
            mViewModel?.let {
                if (!it.mHasInited) {
                    it.init()
                }
            }
        }
        //初始化状态栏
        initStatusBar()
    }

    /**
     * 初始化状态栏
     */
    private fun initStatusBar() {
        //设置默认状态栏背景颜色 为透明色
        mActivity?.run {
            setStatusBarColor(this, R.color.transparency)
            //设置默认状态栏字体颜色 为浅色
            setStatusBarContentColor(this, isSetStatusBarContentDark())
        }
    }

    /**
     * 因为有懒加载的缘故 子类初始化需要时重载init方法，禁止重载onViewCreated方法进行添加额外的初始化方法
     */
    override fun init() {
        super.init()
        initParam()
        initData()
        initAction()
        mViewModel?.let {
            initObserver()
        }
        mHasCreated = true
    }

    /**
     * 初始化参数
     */
    protected open fun initParam() {
        mViewModel?.let { viewModel ->
            viewModel.mBundle = arguments
        }
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
        if (!isSetCustomStatusBarHeight()) {
            val activity = if (mActivity == null) { return } else { mActivity as BaseActivity<*, *> }
            val contentView = mDataBinding.root
            val statusBarView = StatusBarView(activity)

            statusBarView.id = R.id.status_bar_view
            statusBarView.background = getStatusBarBackground()

            when (contentView) {
                is LinearLayout -> contentView.addView(statusBarView, 0)
                is FrameLayout -> {
                    contentView.addView(statusBarView)

                    statusBarView.layoutParams =
                        (statusBarView.layoutParams as FrameLayout.LayoutParams).apply {
                            gravity = TOP
                            width = MATCH_PARENT
                            height = getStatusBarHeight()
                        }
                }
                else -> {
                    val parent = contentView.parent as ViewGroup?

                    if (parent != null) {
                        parent.removeAllViews()
                        LinearLayout(activity).run {
                            orientation = VERTICAL
                            addView(statusBarView)
                            addView(contentView)
                            parent.addView(this)
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
        mViewModel?.getCommonEventManager()?.getShowLoadingDialogEvent()?.observe(viewLifecycleOwner, Observer<String> { hint ->
            LoadingDialog.getInstance()
                .setHintText(hint)
                .show(mActivity)
        })
        //隐藏加载中提示对话框
        mViewModel?.getCommonEventManager()?.getHideLoadingDialogEvent()?.observe(viewLifecycleOwner, Observer<Any?> {
            LoadingDialog.getInstance().hide()
        })
        //切换Activity
        mViewModel?.getCommonEventManager()?.getStartActivityEvent()?.observe(viewLifecycleOwner, Observer<SparseArray<Any?>>{ sparseArray ->
            sparseArray?.run {
                val cls = get(KEY_CLASS) as Class<*>
                val bundle = get(KEY_BUNDLE) as? Bundle?
                val requestCode = get(KEY_REQUEST_CODE) as Int

                startActivity(cls, bundle, requestCode)
            }
        })
        //通过 ARouter 切换 Activity
        mViewModel?.getCommonEventManager()?.getNavigationEvent()?.observe(viewLifecycleOwner, Observer<SparseArray<Any?>> { sparseArray ->
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
                    navigation(mActivity, requestCode, navigationCallback)
                }
            }
        })
        //关闭销毁Activity
        mViewModel?.getCommonEventManager()?.getFinishEvent()?.observe(viewLifecycleOwner, Observer<SparseArray<Any?>> { sparseArray ->
            mActivity?.finish()
            sparseArray?.get(KEY_ANIM_SPARSE_ARRAY)?.run {
                val animSparseArray: SparseIntArray = this as SparseIntArray
                val enterAnim = animSparseArray.get(KEY_ENTER_ANIM)
                val exitAnim = animSparseArray.get(KEY_EXIT_ANIM)

                mActivity?.overridePendingTransition(enterAnim, exitAnim)
            }
        })
        //Activity setResult设置返回响应
        mViewModel?.getCommonEventManager()?.getSetResultEvent()?.observe(viewLifecycleOwner, Observer<SparseArray<Any?>> { sparseArray ->
            sparseArray?.run {
                val resultCode = get(KEY_RESULT_CODE, Activity.RESULT_CANCELED) as Int
                val resultData = get(KEY_RESULT_DATA, null) as Intent?

                mActivity?.setResult(resultCode, resultData)
            }
        })
        //LoadService 状态 LiveData Event监听器
        if (mLoadService != null && mActivity != null) {
            mViewModel?.getLoadServiceStatusEvent()?.observe(mActivity!!, Observer { status ->
                when (status) {
                    SUCCESS -> mLoadService?.showSuccess()
                    LOADING -> mLoadService?.showCallback(LoadingCallback::class.java)
                    EMPTY -> mLoadService?.showCallback(EmptyCallback::class.java)
                    LOAD_FAIL -> mLoadService?.showCallback(LoadFailCallback::class.java)
                }
            })
        }
        //SmartRefreshLayout 状态 LiveData Event监听器
        if (mSmartRefreshLayout != null && mActivity != null) {
            mViewModel?.getRefreshLoadMoreStatusEvent()?.observe(mActivity!!, Observer { status ->
                when (status) {
                    // 下拉刷新成功
                    REFRESH_SUCCESS -> mSmartRefreshLayout?.finishRefresh(true)
                    // 下拉刷新失败
                    REFRESH_FAIL -> mSmartRefreshLayout?.finishRefresh(false)
                    // 上拉加载成功
                    LOAD_MORE_SUCCESS -> mSmartRefreshLayout?.finishLoadMore(true)
                    // 上拉加载失败
                    LOAD_MORE_FAIL -> mSmartRefreshLayout?.finishLoadMore(false)
                    // 上拉加载 所有数据加载完毕
                    LOAD_MORE_ALL -> mSmartRefreshLayout?.finishLoadMoreWithNoMoreData()
                    else -> {}
                }
            })
        }
    }

    /**
     * 是否开启懒加载 (用于ViewPager)
     * @return true 开启  false 关闭  默认关闭
     */
    protected open fun isEnableLazyLoad(): Boolean = false

    /**
     * 是否自定义设置状态栏高度
     * @return true 自定义设置  false 默认设置
     */
    protected open fun isSetCustomStatusBarHeight(): Boolean = true

    /**
     * 是否设置状态栏内容颜色为深色
     * @return true 深色  false 浅色
     */
    protected open fun isSetStatusBarContentDark(): Boolean = false

    /**
     * 获取状态栏背景
     * @return 背景 Drawable
     */
    protected open fun getStatusBarBackground(): Drawable? = getDrawableById(R.color.project_status_bar_default_color)

    /**
     * 跳转Activity页面
     * @param cls 要跳转到的页面反射Class
     * @param bundle 携带的数据
     * @param requestCode 请求码
     */
    fun startActivity(cls: Class<*>, bundle: Bundle? = null, requestCode: Int = -1) {
        mActivity?.let { activity ->
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
    fun openCamera() {
        mActivity?.let { activity ->
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
                startActivityForResult(intent,
                    RESULT_CAMERA
                )
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
                                        ToastUtils.showShort("相机权限授予失败")
                                    }
                                    else -> {
                                        AlertDialog.Builder(activity)
                                            .setMessage("需要您去设置页面，「权限管理」，开启「相机」权限")
                                            .setPositiveButton("去设置") {_, _ ->
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
    fun openPhoto() {
        mActivity?.let { activity ->
            if (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
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
                            .requestEach(Manifest.permission.READ_EXTERNAL_STORAGE)
                            .subscribe {
                                when {
                                    it.granted -> {
                                        openPhoto()
                                    }
                                    it.shouldShowRequestPermissionRationale -> {
                                        ToastUtils.showShort("外部存储权限授予失败")
                                    }
                                    else -> {
                                        AlertDialog.Builder(activity)
                                            .setMessage("需要您去设置页面，「权限管理」，开启「外部存储」权限")
                                            .setPositiveButton("去设置") {_, _ ->
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
    fun startImageClip(data: Uri?) {
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
     * 设置回调监听器
     * @param onItemEvent 回调监听器
     */
    fun setOnItemEventListener(onItemEvent: OnItemEvent?) {
        this.mOnItemEvent = onItemEvent
    }

    /**
     * 模拟 Activity key down 事件
     * @param keyCode key down code
     * @param event key down event
     * @return 是否消费 true 消费 false 不消费
     */
    open fun onKeyDown(keyCode: Int, event: KeyEvent) = false

    override fun onDestroyView() {
        super.onDestroyView()
        mHasCreated = false
        //销毁加载中Dialog
        LoadingDialog.getInstance().destroy()
    }

    override fun onDestroy() {
        super.onDestroy()
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
    }

    override fun onDetach() {
        super.onDetach()
        mActivity = null
    }

}