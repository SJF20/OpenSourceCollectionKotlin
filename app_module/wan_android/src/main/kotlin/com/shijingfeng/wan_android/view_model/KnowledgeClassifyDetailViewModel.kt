package com.shijingfeng.wan_android.view_model

import android.view.View.OnClickListener
import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
import com.shijingfeng.wan_android.entity.KnowledgeClassifyEntity

/**
 * Function: 知识体系 详细数据 ViewModel
 * Date: 20-4-25 下午4:00
 * Description:
 * @author shijingfeng
 */
internal class KnowledgeClassifyDetailViewModel : WanAndroidBaseViewModel<BaseRepository<*, *>>() {

    /** 知识体系 一级 Item 数据 */
    var mKnowledgeClassify: KnowledgeClassifyEntity? = null

    /** 当前 Fragment Item Position */
    var mCurrentFragmentPosition = 0

    /** 返回  */
    var mBackListener = OnClickListener { finish() }

    /**
     * 获取 Repository
     * @return Repository
     */
    override fun getRepository(): Nothing? = null

}