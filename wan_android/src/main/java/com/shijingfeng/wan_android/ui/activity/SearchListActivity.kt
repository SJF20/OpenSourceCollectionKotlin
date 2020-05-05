package com.shijingfeng.wan_android.ui.activity

import android.util.SparseArray
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.gson.reflect.TypeToken
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_SEARCH
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_SEARCH_LIST
import com.shijingfeng.base.base.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.base.common.constant.CURRENT_POSITION
import com.shijingfeng.base.common.constant.EMPTY_OBJECT
import com.shijingfeng.base.util.deserialize
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseActivity
import com.shijingfeng.wan_android.constant.KNOWLEDGE_CLASSIFY_STR
import com.shijingfeng.wan_android.constant.SEARCH_HOT_WORD
import com.shijingfeng.wan_android.constant.SEARCH_LIST_STR
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidSearchListBinding
import com.shijingfeng.wan_android.entity.network.KnowledgeClassifyEntity
import com.shijingfeng.wan_android.entity.network.SearchListItem
import com.shijingfeng.wan_android.source.network.getSearchListNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.getSearchListRepositoryInstance
import com.shijingfeng.wan_android.view_model.SearchListViewModel
import kotlinx.android.synthetic.main.activity_wan_android_search_list.*
import kotlinx.android.synthetic.main.layout_wan_android_title_bar.view.*

/**
 * Function: 搜索列表 Activity
 * Date: 2020/5/5 21:59
 * Description:
 * @author ShiJingFeng
 */
@Route(path = ACTIVITY_WAN_ANDROID_SEARCH_LIST)
internal class SearchListActivity : WanAndroidBaseActivity<ActivityWanAndroidSearchListBinding, SearchListViewModel>() {

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel(): SearchListViewModel? {
        val repository = getSearchListRepositoryInstance(
            networkSource = getSearchListNetworkSourceInstance()
        )
        val factory = createCommonViewModelFactory(
            repository = repository
        )

        return createViewModel(SearchListViewModel::class.java, factory)
    }

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.searchListViewModel, mViewModel)
    }

    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.activity_wan_android_search_list

    /**
     * 初始化参数
     */
    override fun initParam() {
        super.initParam()
        mDataBundle?.run {
            val searchHotWord = getString(SEARCH_HOT_WORD, "")
            val searchListStr = getString(SEARCH_LIST_STR, EMPTY_OBJECT)

            mViewModel?.mSearchHotWord = searchHotWord
            mViewModel?.mSearchList = deserialize(searchListStr, object : TypeToken<List<SearchListItem>>() {}.type)
        }
    }

    /**
     * 初始化数据
     */
    override fun initData() {
        super.initData()
        include_title_bar.tv_title.text = mViewModel?.mSearchHotWord ?: ""
    }
}