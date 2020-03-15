package com.shijingfeng.base.base.activity

import android.os.Bundle
import android.util.SparseArray
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.shijingfeng.base.base.view.BaseView
import com.shijingfeng.base.base.viewmodel.BaseViewModel

/**
 * Function: MVVM架构 Activity基类
 * Date: 2020/1/17 18:42
 * Description:
 * @author ShiJingFeng
 */
abstract class MvvmActivity<V : ViewDataBinding, VM : BaseViewModel<*>> : AppCompatActivity(),
    BaseView {

    /** DataBinding  */
    protected lateinit var mDataBinding: V
    /** ViewModel  */
    protected var mViewModel: VM? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initAAC()
    }

    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    protected abstract fun getLayoutId() : Int

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
        mDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
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
     * 创建ViewModel
     *
     * @param cls Activity Class
     * @return ViewModel子类
     */
    fun createViewModel(cls: Class<VM>): VM = ViewModelProvider(this).get(cls)

    /**
     * 工厂模式创建ViewModel
     *
     * @param cls Activity Class
     * @param factory 工厂
     * @return ViewModel子类
     */
    fun createViewModel(cls: Class<VM>, factory: ViewModelProvider.Factory): VM = ViewModelProvider(this, factory).get(cls)

    override fun onDestroy() {
        super.onDestroy()
        //销毁DataBinding
        mDataBinding.unbind()
    }

}