package com.shijingfeng.base.mvvm.activity

import android.content.Intent
import android.os.Bundle
import android.util.SparseArray
import android.util.SparseIntArray
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.shijingfeng.base.base.activity.BaseNormalActivity
import com.shijingfeng.base.mvvm.viewmodel.BaseViewModel
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.widget.dialog.LoadingDialog

/**
 * Function: MVVM架构 Activity 基类
 * Date: 2020/3/21 10:56
 * Description:
 * Author: ShiJingFeng
 */
abstract class BaseMvvmActivity<V : ViewDataBinding, VM : BaseViewModel<*>> : BaseNormalActivity() {

    /** DataBinding  */
    protected lateinit var mDataBinding: V
    /** ViewModel  */
    protected var mViewModel: VM? = null

    /**
     * 初始化
     */
    override fun init(savedInstanceState: Bundle?) {
        initAAC()
        initParam()
        initData()
        initAction()
        initObserver()
    }

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    protected abstract fun getViewModel() : VM?

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    protected abstract fun getVariableSparseArray(): SparseArray<Any>?

    /**
     * 初始化AAC组件
     */
    private fun initAAC() {
        val layoutId = getLayoutId()

        if (layoutId != NO_LAYOUT) {
            mDataBinding = DataBindingUtil.setContentView(this, layoutId)
            mViewModel = getViewModel()
            getVariableSparseArray()?.run {
                for (i in 0 until size()) {
                    mDataBinding.setVariable(keyAt(i), valueAt(i))
                }
            }
        } else {
            mViewModel = getViewModel()
        }
        //让 ViewModel 拥有 Activity 的生命周期感应
        mViewModel?.run {
            lifecycle.addObserver(this)
        }
    }

    /**
     * 初始化参数
     */
    override fun initParam() {
        super.initParam()
        mViewModel?.mParamBundle = intent?.extras
    }

    /**
     * 初始化 LiveData Observer
     */
    protected open fun initObserver() {
        //切换Activity
        mViewModel?.liveDataEventManager?.startActivityEvent?.observe(this) { sparseArray ->
            sparseArray?.run {
                val cls = get(KEY_CLASS) as Class<*>
                val bundle = get(KEY_BUNDLE) as? Bundle?
                val requestCode = get(KEY_REQUEST_CODE) as Int

                startActivity(cls, bundle, requestCode)
            }
        }
        //通过 ARouter 切换 Activity
        mViewModel?.liveDataEventManager?.navigationEvent?.observe(this) { sparseArray ->
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
                    navigation(this@BaseMvvmActivity, requestCode, navigationCallback)
                }
            }
        }
        //关闭销毁Activity
        mViewModel?.liveDataEventManager?.finishEvent?.observe(this) { sparseArray ->
            finish()
            sparseArray?.get(KEY_ANIM_SPARSE_ARRAY)?.run {
                val animSparseArray: SparseIntArray = this as SparseIntArray
                val enterAnim = animSparseArray.get(KEY_ENTER_ANIM)
                val exitAnim = animSparseArray.get(KEY_EXIT_ANIM)

                overridePendingTransition(enterAnim, exitAnim)
            }
        }
        //Activity setResult设置返回响应
        mViewModel?.liveDataEventManager?.setResultEvent?.observe(this) { sparseArray ->
            sparseArray?.run {
                val resultCode = get(KEY_RESULT_CODE, RESULT_CANCELED) as Int
                val resultData = get(KEY_RESULT_DATA, null) as? Intent?

                setResult(resultCode, resultData)
            }
        }

        //显示加载中提示对话框
        mViewModel?.liveDataEventManager?.showLoadingDialogEvent?.observe(this) { hint ->
            LoadingDialog.getInstance()
                .setHintText(hint)
                .show(this)
        }
        //隐藏加载中提示对话框
        mViewModel?.liveDataEventManager?.hideLoadingDialogEvent?.observe(this) {
            LoadingDialog.getInstance().hide()
        }
        // 显示 LoadingView
        mViewModel?.liveDataEventManager?.showLoadingViewEvent?.observe(this@BaseMvvmActivity) { hintText ->
            showLoadingView(hintText)
        }
        // 隐藏 LoadingView
        mViewModel?.liveDataEventManager?.hideLoadingViewEvent?.observe(this@BaseMvvmActivity) {
            hideLoadingView()
        }

        //LoadService 状态 LiveData Event监听器
        mLoadService?.run {
            mViewModel?.liveDataEventManager?.loadServiceStatusEvent?.observe(this@BaseMvvmActivity) { status ->
                showCallback(status)
            }
        }
        //SmartRefreshLayout 状态 LiveData Event监听器
        mSmartRefreshLayout?.run {
            mViewModel?.liveDataEventManager?.refreshLoadMoreStatusEvent?.observe(this@BaseMvvmActivity) { status ->
                updateRefreshLoadMoreStatus(status)
            }
        }
    }

    /**
     * LoadSir 切换状态
     * @param status 要切换到的状态  默认: [LOAD_SERVICE_SUCCESS]
     */
    override fun showCallback(status: Int) {
        if (mViewModel != null && mViewModel!!.mLoadServiceStatus == status) {
            return
        }
        mViewModel?.mLoadServiceStatus = status
        super.showCallback(status)
    }

    /**
     * 更新 下拉刷新，上拉加载 状态
     * @param status 下拉刷新 或 上拉加载 状态  默认: [REFRESH_SUCCESS]
     */
    override fun updateRefreshLoadMoreStatus(status: Int) {
        mViewModel?.mRefreshLoadMoreStatus = status
        super.updateRefreshLoadMoreStatus(status)
    }

    /**
     * DataBinding是否初始化完毕
     */
    protected fun isDataBindingInitialized() = ::mDataBinding.isInitialized

    /**
     * 工厂模式创建ViewModel
     *
     * @param cls Activity Class
     * @param factory 工厂
     * @return ViewModel子类
     */
    fun createViewModel(
        cls: Class<VM>,
        factory: ViewModelProvider.Factory? = null
    ): VM = if (factory == null) {
        ViewModelProvider(this).get(cls)
    } else {
        ViewModelProvider(this, factory).get(cls)
    }

    /**
     * 创建 SavedStateViewModel (用于当程序在后台被杀死时，ViewModel还能保存数据)
     */
    fun createSavedStateViewModel(cls: Class<VM>): VM = ViewModelProvider(this, SavedStateViewModelFactory(application, this)).get(cls)

    /**
     * Activity 销毁回调
     */
    override fun onDestroy() {
        super.onDestroy()
        //销毁DataBinding
        if (this::mDataBinding.isInitialized) {
            mDataBinding.unbind()
        }
        //销毁Lifecycle
        mViewModel?.run {
            lifecycle.removeObserver(this)
        }
    }

}