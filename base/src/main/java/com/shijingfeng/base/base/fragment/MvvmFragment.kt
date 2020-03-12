package com.shijingfeng.base.base.fragment

import android.os.Bundle
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.base.viewmodel.BaseViewModel

/**
 * Function: MVVM架构 Fragment基类
 * Date: 2020/1/18 14:51
 * Description:
 * @author ShiJingFeng
 */
abstract class MvvmFragment<V : ViewDataBinding, VM : BaseViewModel<*>> : Fragment() {

    /** DataBinding  */
    protected lateinit var mDataBinding: V
    /** ViewModel  */
    protected var mViewModel: VM? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return mDataBinding.root
    }

    /**
     * 获取视图ID
     * @return 视图ID
     */
    protected abstract fun getLayoutId(): Int

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
     * 初始化
     */
    protected open fun init() = initAAC()

    /**
     * 初始化AAC组件
     */
    private fun initAAC() {
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

    override fun onDestroyView() {
        super.onDestroyView()
        //销毁DataBinding
        mDataBinding.unbind()
    }

}