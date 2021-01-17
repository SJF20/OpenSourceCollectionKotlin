package com.shijingfeng.base.mvvm.viewmodel

import android.content.Intent
import android.os.Bundle
import android.util.SparseArray
import android.util.SparseIntArray
import androidx.lifecycle.*
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.blankj.utilcode.util.ToastUtils
import com.shijingfeng.base.R.string.再按一次退出应用
import com.shijingfeng.base.annotation.BindEventBus
import com.shijingfeng.base.annotation.define.LoadServiceStatus
import com.shijingfeng.base.annotation.define.RefreshLoadMoreStatus
import com.shijingfeng.base.base.fragment.BaseFragment
import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.common.global.runOnUiThread
import com.shijingfeng.base.mvvm.livedata.SingleLiveEvent
import com.shijingfeng.base.util.exitApp
import com.shijingfeng.base.util.getStringById
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.greenrobot.eventbus.EventBus

/**
 * Function: ViewModel基类
 * Date: 2020/1/17 19:15
 * Description:
 * Author: ShiJingFeng
 */
abstract class BaseViewModel<R : BaseRepository<*, *>>(
    savedStateHandle: SavedStateHandle? = null
) : ViewModel(), DefaultLifecycleObserver {

    /** Repository */
    protected val mRepository: R? by lazy { getRepository() }

    /** SavedStateHandle 参考: [https://zhuanlan.zhihu.com/p/143115298]*/
    protected val mSavedStateHandle = savedStateHandle

    /** Disposable容器  */
    private val mCompositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    /** 页面跳转携带的数据Bundle (注意: 和 Activity 或 Fragment 的 mDataBundle 做区分, mDataBundle随着 Activity重启 或 Fragment重启 会改变) */
    var mParamBundle: Bundle? = null

    /** LoadSir 状态 */
    @LoadServiceStatus var mLoadServiceStatus = LOAD_SERVICE_SUCCESS

    /** 下拉刷新 或 上拉加载 状态 */
    @RefreshLoadMoreStatus var mRefreshLoadMoreStatus = REFRESH_LOAD_MORE_NONE

    /** 连续双击退出应用  */
    private var mExitApp: Boolean = false

    /** 是否已经初始化  true 已经初始化  false 没有初始化  */
    var mHasInitialized: Boolean = false

    /** 常用的 LiveData Event 管理器  */
    val liveDataEventManager by lazy { LiveDataEventManager() }

    init {
        registerEventBus()
    }

    /**
     * 获取 Repository
     * @return Repository
     */
    protected abstract fun getRepository() : R?

    /**
     * 注册EventBus
     */
    private fun registerEventBus() {
        //绑定EventBus
        if (this.javaClass.isAnnotationPresent(BindEventBus::class.java) && !EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this)
        }
    }

    /**
     * 解注册EventBus
     */
    private fun unregisterEventBus() {
        if (this.javaClass.isAnnotationPresent(BindEventBus::class.java) && EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this)
        }
    }

    /**
     * LoadSir 切换状态
     * @param status 要切换到的状态  默认: [LOAD_SERVICE_SUCCESS]
     */
    fun showCallback(@LoadServiceStatus status: Int) {
        if (mLoadServiceStatus != status) {
            liveDataEventManager.loadServiceStatusEvent.value = status
        }
    }

    /**
     * 更新 下拉刷新，上拉加载 状态
     * @param status 下拉刷新 或 上拉加载 状态 {@link com.zjn.transport.constant.StatusConstant#REFRESH_SUCCESS}
     */
    fun updateRefreshLoadMoreStatus(@RefreshLoadMoreStatus status: Int) {
        liveDataEventManager.refreshLoadMoreStatusEvent.value = status
    }

    /**
     * 显示加载中Dialog
     * @param hint 提示文本  null: 默认提示 (提交中...)
     */
    fun showLoadingDialog(hint: String? = null) {
        liveDataEventManager.showLoadingDialogEvent.value = hint
    }

    /**
     * 隐藏加载中Dialog
     */
    fun hideLoadingDialog() {
        liveDataEventManager.hideLoadingDialogEvent.call()
    }

    /**
     * 显示 LoadingView
     *
     * @param hintText 提示文本
     */
    fun showLoadingView(
        hintText: String? = null
    ) {
        liveDataEventManager.showLoadingViewEvent.value = hintText
    }

    /**
     * 隐藏 LoadingView
     */
    fun hideLoadingView() {
        liveDataEventManager.hideLoadingViewEvent.call()
    }

    /**
     * 通过Class跳转界面
     * @param cls 要跳转到的页面的Class
     * @param bundle 携带的数据
     * @param requestCode 请求码
     */
    fun startActivity(
        cls: Class<*>,
        bundle: Bundle? = null,
        requestCode: Int = -1
    ) {
        liveDataEventManager.startActivityEvent.value = SparseArray<Any?>(3).apply {
            put(KEY_CLASS, cls)
            put(KEY_BUNDLE, bundle)
            put(KEY_REQUEST_CODE, requestCode)
        }
    }

    /**
     * 跳到指定路径页面
     * @param path 路径
     * @param bundle 携带的数据
     * @param requestCode 请求码
     * @param animSparseArray Activity切换动画, Key: KEY_ENTER_ANIM, KEY_EXIT_ANIM
     * @param callback 跳转回调
     */
    fun navigation(
        path: String,
        bundle: Bundle? = null,
        requestCode: Int = -1,
        animSparseArray: SparseIntArray? = null,
        callback: NavigationCallback? = null
    ) {
        liveDataEventManager.navigationEvent.value = SparseArray<Any?>(5).apply {
            put(KEY_PATH, path)
            put(KEY_BUNDLE, bundle)
            put(KEY_REQUEST_CODE, requestCode)
            put(KEY_ANIM_SPARSE_ARRAY, animSparseArray)
            put(KEY_NAVIGATION_CALLBACK, callback)
        }
    }

    /**
     * 销毁Activity (系统动画 或 全局动画(style中设置))
     * @param animSparseArray key: KEY_ENTER_ANIM(进入动画), KEY_EXIT_ANIM(退出动画)
     */
    fun finish(animSparseArray: SparseIntArray? = null) {
        liveDataEventManager.finishEvent.value = SparseArray<Any?>(1).apply {
            put(KEY_ANIM_SPARSE_ARRAY, animSparseArray)
        }
    }

    /**
     * 销毁Activity (没有动画)
     */
    fun finishNoAnim() {
        liveDataEventManager.finishEvent.value = SparseArray<Any?>(1).apply {
            put(KEY_ANIM_SPARSE_ARRAY, SparseIntArray(2).apply {
                put(KEY_ENTER_ANIM, 0)
                put(KEY_EXIT_ANIM, 0)
            })
        }
    }

    /**
     * 设置返回响应
     * @param resultCode 返回响应码
     * @param data 返回响应数据
     */
    fun setResult(resultCode: Int, data: Intent? = null) {
        liveDataEventManager.setResultEvent.value = SparseArray<Any?>().apply {
            put(KEY_RESULT_CODE, resultCode)
            put(KEY_RESULT_DATA, data)
        }
    }

    /**
     * 添加Disposable
     * @param disposable Disposable
     */
    fun addDisposable(disposable: Disposable) {
        mCompositeDisposable.add(disposable)
    }

    /**
     * 清空Disposable
     */
    private fun clearDisposable() {
        mCompositeDisposable.clear()
    }

    /**
     * 指定间隔时间内 按下两次返回键退出App
     */
    fun doubleDownExitApp() {
        if (mExitApp) {
            exitApp()
        } else {
            mExitApp = true
            ToastUtils.showShort(getStringById(再按一次退出应用))
            //超过两秒没有再次点击，则不退出App
            runOnUiThread(2000) {
                mExitApp = false
            }
        }
    }

    /**
     * ViewModel销毁回调
     */
    override fun onCleared() {
        super.onCleared()
        //解注册EventBus
        unregisterEventBus()
        //取消所有异步任务
        clearDisposable()
        //销毁 Model仓库
        mRepository?.onCleared()
    }

    /**
     * 初始化
     */
    open fun init() {
        mHasInitialized = true
    }

    /**
     * 会在 Activity 的 onCreate 方法完全执行完后执行
     */
    override fun onCreate(owner: LifecycleOwner) {
        if (owner !is BaseFragment && !mHasInitialized) {
            init()
        }
    }

    /**
     * 常用的 LiveData Event 管理器
     */
    class LiveDataEventManager {

        /** 跳转 Activity  */
        val startActivityEvent by lazy { SingleLiveEvent<SparseArray<Any?>>() }

        /** 页面跳转  */
        val navigationEvent by lazy { SingleLiveEvent<SparseArray<Any?>>() }

        /** 关闭 Activity  */
        val finishEvent by lazy { SingleLiveEvent<SparseArray<Any?>>() }

        /** Activity setResult设置返回响应  */
        val setResultEvent by lazy { SingleLiveEvent<SparseArray<Any?>>() }

        /** 显示加载中 Dialog  */
        val showLoadingDialogEvent by lazy { SingleLiveEvent<String?>() }

        /** 隐藏加载中 Dialog  */
        val hideLoadingDialogEvent by lazy { SingleLiveEvent<Any?>() }

        /** 显示 LoadingView */
        val showLoadingViewEvent by lazy { SingleLiveEvent<String?>() }

        /** 隐藏 LoadingView */
        val hideLoadingViewEvent by lazy { SingleLiveEvent<Any?>() }

        /** LoadService 状态 LiveData Event  */
        val loadServiceStatusEvent by lazy { MutableLiveData<Int>() }

        /** 刷新 或 上拉加载 状态 LiveData Event  */
        val refreshLoadMoreStatusEvent by lazy { MutableLiveData<Int>() }

    }

}