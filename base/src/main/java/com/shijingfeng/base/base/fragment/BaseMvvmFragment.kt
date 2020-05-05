package com.shijingfeng.base.base.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.SparseArray
import android.util.SparseIntArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.shijingfeng.base.base.viewmodel.BaseViewModel
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.widget.dialog.LoadingDialog

/**
 * Function: MVVM架构 Fragment 基类
 * Date: 2020/3/21 21:15
 * Description:
 * @author ShiJingFeng
 */
abstract class BaseMvvmFragment<V : ViewDataBinding, VM : BaseViewModel<*>> : BaseFragment() {

    /** DataBinding  */
    protected lateinit var mDataBinding: V
    /** ViewModel  */
    protected var mViewModel: VM? = null

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
        mDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        mRootView = mDataBinding.root

        return mRootView
    }

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    protected abstract fun getViewModel(): VM?

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    protected abstract fun getVariableSparseArray(): SparseArray<Any>?

    /**
     * 因为有懒加载的缘故 子类初始化需要时重载init方法，禁止重载onViewCreated方法进行添加额外的初始化方法
     */
    override fun init(savedInstanceState: Bundle?) {
        initAAC()
        initParam()
        initData()
        initAction()
        initObserver()
        mViewModel?.let { viewModel ->
            if (!viewModel.mHasInited) {
                viewModel.init()
            }
        }
        mHasCreated = true
    }

    /**
     * 初始化参数
     */
    override fun initParam() {
        super.initParam()
        mViewModel?.mParamBundle = arguments
    }

    /**
     * 初始化AAC组件
     */
    protected fun initAAC() {
        mViewModel = getViewModel()
        getVariableSparseArray()?.run {
            for (i in 0 until size()) {
                mDataBinding.setVariable(keyAt(i), valueAt(i))
            }
        }
        //让ViewModel拥有View的生命周期感应
        mViewModel?.run { lifecycle.addObserver(this) }
    }

    /**
     * 初始化 LiveData Observer
     */
    protected open fun initObserver() {
        //显示加载中提示对话框
        mViewModel?.getCommonEventManager()?.getShowLoadingDialogEvent()?.observe(viewLifecycleOwner, Observer<String?> { hint ->
            LoadingDialog.getInstance()
                .setHintText(hint)
                .show(activity)
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
                    navigation(activity, requestCode, navigationCallback)
                }
            }
        })
        //关闭销毁Activity
        mViewModel?.getCommonEventManager()?.getFinishEvent()?.observe(viewLifecycleOwner, Observer<SparseArray<Any?>> { sparseArray ->
            activity?.finish()
            sparseArray?.get(KEY_ANIM_SPARSE_ARRAY)?.run {
                val animSparseArray: SparseIntArray = this as SparseIntArray
                val enterAnim = animSparseArray.get(KEY_ENTER_ANIM)
                val exitAnim = animSparseArray.get(KEY_EXIT_ANIM)

                activity?.overridePendingTransition(enterAnim, exitAnim)
            }
        })
        //Activity setResult设置返回响应
        mViewModel?.getCommonEventManager()?.getSetResultEvent()?.observe(viewLifecycleOwner, Observer<SparseArray<Any?>> { sparseArray ->
            sparseArray?.run {
                val resultCode = get(KEY_RESULT_CODE, Activity.RESULT_CANCELED) as Int
                val resultData = get(KEY_RESULT_DATA, null) as Intent?

                activity?.setResult(resultCode, resultData)
            }
        })
        //LoadService 状态 LiveData Event监听器
        if (mLoadService != null && activity != null) {
            mViewModel?.getLoadServiceStatusEvent()?.observe(activity!!, Observer { status ->
                showCallback(status)
            })
        }
        //SmartRefreshLayout 状态 LiveData Event监听器
        if (mSmartRefreshLayout != null && activity != null) {
            mViewModel?.getRefreshLoadMoreStatusEvent()?.observe(activity!!, Observer { status ->
                updateRefreshLoadMoreStatus(status)
            })
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
        if (mViewModel != null && mViewModel!!.mRefreshLoadMoreStatus == status) {
            return
        }
        mViewModel?.mRefreshLoadMoreStatus = status
        super.updateRefreshLoadMoreStatus(status)
    }

    /**
     * 创建ViewModel
     *
     * @param cls Activity Class
     * @param <T> 泛型
     * @return ViewModel子类
     */
    fun <T : ViewModel> createViewModel(cls: Class<T>): T = ViewModelProvider(this).get(cls)

    /**
     * 工厂模式创建ViewModel
     *
     * @param cls Activity Class
     * @param factory 工厂
     * @return ViewModel子类
     */
    fun createViewModel(cls: Class<VM>, factory: ViewModelProvider.Factory): VM = ViewModelProvider(this, factory).get(cls)

    /**
     * Fragment View 销毁回调
     */
    override fun onDestroyView() {
        //销毁DataBinding
        mDataBinding.unbind()
        super.onDestroyView()
    }

}