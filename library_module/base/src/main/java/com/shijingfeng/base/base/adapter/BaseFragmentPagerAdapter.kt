package com.shijingfeng.base.base.adapter

import android.util.SparseArray
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.shijingfeng.base.base.fragment.BaseFragment
import com.shijingfeng.base.util.cast

/** Fragment 创建 回调监听 */
typealias OnFragmentCreate<T> = (position: Int, fragment: T) -> Unit

/** Fragment 销毁 回调监听 */
typealias OnFragmentDestroy = (position: Int) -> Unit

/**
 * Function: 通用 ViewPager FragmentPagerAdapter
 * Date: 2020/1/27 10:43
 * Description: FragmentPagerAdapter(mFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) 会调用setMaxLifecycle (Fragment fragment, Lifecycle.State state)，而不会调用setUserVisibleHint
 * @author ShiJingFeng
 */
abstract class BaseFragmentPagerAdapter<T : BaseFragment>(

    fragmentManager: FragmentManager,

    /** 是否禁止销毁   true 禁止销毁  false 系统默认销毁机制 */
    private val mBanDestroyed: Boolean = false,

    /** Fragment 创建 监听器
     *  因为 ViewPager 可以设置预先加载Fragment数量 (setOffscreenPageLimit())
     *  所以 Fragment 可能不会全部创建完, 按需添加回调监听 Fragment 创建
     */
    private var mOnFragmentCreate: OnFragmentCreate<T>? = null,

    /** Fragment 销毁 监听器 */
    private var mOnFragmentDestroy: OnFragmentDestroy? = null

) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    /** Fragment 容器 */
    private val mRegisteredFragmentSparseArray = SparseArray<T?>()

    /**
     * 为了防止 Fragment 重建导致 手动创建的 Fragment 引用 (在 Activity 或 ViewModel 中创建的 Fragment 列表)
     * 和 缓存的Fragment 不是一个Fragment
     */
    override fun getItem(position: Int): T {
        val fragment = createItem(position)

        mOnFragmentCreate?.invoke(position, fragment)
        return fragment
    }

    /**
     * 初始化 Fragment Item
     * 如果 FragmentManager 中没有此 Fragment 则会调用 getItem(Int) 创建 Fragment
     * 否则会调用 FragmentManager attach(Fragment) 显示 Fragment
     */
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val fragment = super.instantiateItem(container, position)

        mRegisteredFragmentSparseArray.put(position, cast(fragment))
        return fragment
    }

    /**
     * 销毁 Fragment Item
     */
    override fun destroyItem(
        container: ViewGroup,
        position: Int,
        any: Any
    ) {
        if (!mBanDestroyed) {
            mRegisteredFragmentSparseArray.remove(position)
            super.destroyItem(container, position, any)
            mOnFragmentDestroy?.invoke(position)
        }
    }

    /**
     * 创建 Fragment Item
     * @param position 下标
     * @return 创建好的 Fragment
     */
    abstract fun createItem(position: Int): T

    /**
     * 设置 Fragment 创建 回调监听
     * 因为 ViewPager 可以设置预先加载Fragment数量 (setOffscreenPageLimit())
     * 所以 Fragment 可能不会全部创建完, 按需添加回调监听 Fragment 创建
     */
    fun setOnFragmentCreateListener(onFragmentCreate: OnFragmentCreate<T>) {
        this.mOnFragmentCreate = onFragmentCreate
    }

    /**
     * 设置 Fragment 销毁 回调监听
     */
    fun setOnFragmentDestroyListener(onFragmentDestroy: OnFragmentDestroy) {
        this.mOnFragmentDestroy = onFragmentDestroy
    }

    /**
     * 通过 下标 获取 Fragment
     * @param position 下标
     * @return Fragment
     */
    fun getFragmentByPosition(position: Int) = mRegisteredFragmentSparseArray[position]

}