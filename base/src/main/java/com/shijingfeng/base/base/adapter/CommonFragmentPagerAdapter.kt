package com.shijingfeng.base.base.adapter

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.shijingfeng.base.base.fragment.BaseFragment

/**
 * Function: 通用 ViewPager FragmentPagerAdapter
 * Date: 2020/1/27 10:43
 * Description: FragmentPagerAdapter(mFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) 会调用setMaxLifecycle (Fragment fragment, Lifecycle.State state)，而不会调用setUserVisibleHint
 * @author ShiJingFeng
 */
class CommonFragmentPagerAdapter<T : BaseFragment>(
    fragmentManager: FragmentManager,
    private var mChildFragmentList: List<T>? = null,
    /** 是否禁止销毁   true 禁止销毁  false 系统默认销毁机制 */
    private val mBanDestroyed: Boolean = false
) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment = mChildFragmentList!![position]

    override fun getCount(): Int = (mChildFragmentList?.size ?: 0)

    override fun destroyItem(
        container: ViewGroup,
        position: Int,
        any: Any
    ) {
        if (mBanDestroyed) {
            return
        }
        super.destroyItem(container, position, any)
    }
}