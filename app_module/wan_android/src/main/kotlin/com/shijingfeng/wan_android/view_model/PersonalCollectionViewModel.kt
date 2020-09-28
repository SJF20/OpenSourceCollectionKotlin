package com.shijingfeng.wan_android.view_model

import android.view.View.OnClickListener
import com.shijingfeng.base.mvvm.livedata.SingleLiveEvent
import com.shijingfeng.wan_android.base.WanAndroidBaseFragment
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
import com.shijingfeng.wan_android.source.repository.PersonalCollectionRepository
import com.shijingfeng.wan_android.ui.activity.PERSONAL_COLLECTION_ARTICLE
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

    /** 当前 ViewPager 下标  */
    var mCurPosition = PERSONAL_COLLECTION_ARTICLE

    /** 返回  */
    val mBackClickListener = OnClickListener {
        finish()
    }

}