package com.shijingfeng.wan_android.view_model

import android.view.View.OnClickListener
import com.shijingfeng.base.livedata.SingleLiveEvent
import com.shijingfeng.wan_android.base.WanAndroidBaseFragment
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
import com.shijingfeng.wan_android.source.repository.PersonalCollectionRepository
import com.shijingfeng.wan_android.ui.fragment.*
import com.shijingfeng.wan_android.ui.fragment.HomeFragment


/**
 * Function: 我的收藏 ViewModel
 * Date: 2020/3/22 19:42
 * Description:
 * @author ShiJingFeng
 */
internal class PersonalCollectionViewModel(
    repository: PersonalCollectionRepository? = null
) : WanAndroidBaseViewModel<PersonalCollectionRepository>(repository) {

    /** Fragment列表  */
    private var mFragmentList: List<WanAndroidBaseFragment<*, *>>? = null
    /** 当前Fragment  */
    var mCurrentFragment: WanAndroidBaseFragment<*, *>? = null

    /** 返回  */
    val mBackClickListener = OnClickListener {
        finish()
    }
    /** 置顶  */
    val mScrollToTopListener = OnClickListener {
        mCurrentFragment?.scrollToTop()
    }

    /**
     * 获取 Fragment列表
     * @return Fragment列表
     */
    fun getFragmentList(): List<WanAndroidBaseFragment<*, *>> {
        if (mFragmentList == null) {
            val personalCollectionArticleFragment = PersonalCollectionArticleFragment()

            mCurrentFragment = personalCollectionArticleFragment
            mFragmentList = mutableListOf(
                // 文章收藏 Fragment
                personalCollectionArticleFragment,
                // 网站收藏 Fragment
                PersonalCollectionWebsiteFragment()
            )
        }
        return mFragmentList as List<WanAndroidBaseFragment<*, *>>
    }

}