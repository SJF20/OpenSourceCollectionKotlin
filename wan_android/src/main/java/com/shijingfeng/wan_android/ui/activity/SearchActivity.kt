package com.shijingfeng.wan_android.ui.activity

import android.util.SparseArray
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Route
import com.kingja.loadsir.callback.Callback
import com.kingja.loadsir.callback.SuccessCallback
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_SEARCH
import com.shijingfeng.base.base.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.annotation.define.SearchHistoryLoadServiceStatus
import com.shijingfeng.wan_android.annotation.define.SearchHotWordLoadServiceStatus
import com.shijingfeng.wan_android.base.WanAndroidBaseActivity
import com.shijingfeng.wan_android.callback.*
import com.shijingfeng.wan_android.callback.SearchHistoryEmptyCallback
import com.shijingfeng.wan_android.callback.SearchHistoryLoadingCallback
import com.shijingfeng.wan_android.callback.SearchHotWordEmptyCallback
import com.shijingfeng.wan_android.callback.SearchHotWordLoadFailCallback
import com.shijingfeng.wan_android.callback.SearchHotWordLoadingCallback
import com.shijingfeng.wan_android.constant.*
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidSearchBinding
import com.shijingfeng.wan_android.source.local.getSearchLocalSourceInstance
import com.shijingfeng.wan_android.source.network.getSearchNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.getSearchRepositoryInstance
import com.shijingfeng.wan_android.view_model.SearchViewModel
import kotlinx.android.synthetic.main.activity_wan_android_search.*

/**
 * Function: 搜索 Activity
 * Date: 20-5-4 下午5:40
 * Description:
 * @author shijingfeng
 */
@Route(path = ACTIVITY_WAN_ANDROID_SEARCH)
internal class SearchActivity : WanAndroidBaseActivity<ActivityWanAndroidSearchBinding, SearchViewModel>() {

    /** 热门搜索 LoadService */
    private var mSearchHotWordLoadService: LoadService<*>? = null
    /** 搜索历史 LoadService */
    private var mSearchHistoryLoadService: LoadService<*>? = null

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel(): SearchViewModel? {
        val repository = getSearchRepositoryInstance(
            localSource = getSearchLocalSourceInstance(),
            networkSource = getSearchNetworkSourceInstance()
        )
        val factory = createCommonViewModelFactory(
            repository = repository
        )

        return createViewModel(SearchViewModel::class.java, factory)
    }

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.searchViewModel, mViewModel)
    }

    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.activity_wan_android_search

    /**
     * 初始化数据
     */
    override fun initData() {
        super.initData()
        val loadSir = LoadSir.Builder()
            .addCallback(SearchHotWordLoadingCallback())
            .addCallback(SearchHotWordEmptyCallback())
            .addCallback(SearchHotWordLoadFailCallback())
            .addCallback(SearchHistoryLoadingCallback())
            .addCallback(SearchHistoryEmptyCallback())
            .addCallback(SearchHistoryLoadFailCallback())
            .build()

        mSearchHotWordLoadService = loadSir.register(rv_hot_word, mViewModel?.mOnSearchHotWordReloadListener)
        if (mViewModel == null || !mViewModel!!.mHasInited) {
            showSearchHotWordCallback(LOAD_SERVICE_SEARCH_HOT_WORD_LOADING)
        }
        mSearchHistoryLoadService = loadSir.register(rv_history, mViewModel?.mOnSearchHistoryReloadListener)
        if (mViewModel == null || !mViewModel!!.mHasInited) {
            showSearchHistoryCallback(LOAD_SERVICE_SEARCH_HISTORY_LOADING)
        }
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
    }

    /**
     * 初始化 LiveData Observer
     */
    override fun initObserver() {
        super.initObserver()
        // 热门搜索 LoadService 状态 Observer
        mSearchHotWordLoadService?.run {
            mViewModel?.mSearchHotWordLoadServiceStatusEvent?.observe(this@SearchActivity, Observer ObserverLabel@{ status ->
                showSearchHotWordCallback(status)
            })
        }
        // 搜索历史 LoadService 状态 Observer
        mSearchHistoryLoadService?.run {
            mViewModel?.mSearchHistoryLoadServiceStatusEvent?.observe(this@SearchActivity, Observer ObserverLabel@{ status ->
                showSearchHistoryCallback(status)
            })
        }
        // 热门搜索 列表 Observer
        mViewModel?.mSearchHotWordListEvent?.observe(this, Observer ObserverLabel@{ searchHotWordList ->
            if (!searchHotWordList.isNullOrEmpty()) {

            }
        })
        // 搜索历史 列表 Observer
//        mViewModel?.mSearchHistoryListEvent?.observe(this, Observer ObserverLabel@{ (type, _, _, extraData, searchHistoryItemList, _) ->
//            when (type) {
//                // 加载, 刷新
//                LOAD, REFRESH -> mCoinRankAdapter?.notifyDataSetChanged()
//                // 添加
//                ADD -> {
//                    if (searchHistoryItemList.isNullOrEmpty()) {
//                        return@ObserverLabel
//                    }
//
//                    val oldSize = extraData as Int
//
//                    if (oldSize <= 0) {
//                        mCoinRankAdapter?.notifyDataSetChanged()
//                    } else {
//                        mCoinRankAdapter?.notifyItemRangeInserted(
//                            oldSize,
//                            searchHistoryItemList.size
//                        )
//                    }
//                }
//                // 删除
//                REMOVE -> {}
//                // 清空
//                CLEAR -> {}
//                else -> {}
//            }
//        })
    }

    /**
     * 搜索热词 LoadSir 切换状态
     * @param status 要切换到的状态  默认: [LOAD_SERVICE_SEARCH_HOT_WORD_SUCCESS]
     */
    private fun showSearchHotWordCallback(@SearchHotWordLoadServiceStatus status: Int) {
        mViewModel?.mSearchHotWordLoadServiceStatus = status
        mSearchHotWordLoadService?.showCallback(when (status) {
            // 热门搜索 LoadSir 状态: 成功
            LOAD_SERVICE_SEARCH_HOT_WORD_SUCCESS -> SuccessCallback::class.java
            // 热门搜索 LoadSir 状态: 加载中
            LOAD_SERVICE_SEARCH_HOT_WORD_LOADING -> SearchHotWordLoadingCallback::class.java
            // 热门搜索 LoadSir 状态: 暂无数据
            LOAD_SERVICE_SEARCH_HOT_WORD_EMPTY -> SearchHotWordEmptyCallback::class.java
            // 热门搜索 LoadSir 状态: 加载失败
            LOAD_SERVICE_SEARCH_HOT_WORD_LOAD_FAIL -> SearchHotWordLoadFailCallback::class.java
            // 热门搜索 默认 LoadSir 状态 成功
            else -> SuccessCallback::class.java
        })
    }

    /**
     * 搜索历史 LoadSir 切换状态
     * @param status 要切换到的状态  默认: [LOAD_SERVICE_SEARCH_HISTORY_SUCCESS]
     */
    private fun showSearchHistoryCallback(@SearchHistoryLoadServiceStatus status: Int) {
        mViewModel?.mSearchHistoryLoadServiceStatus = status
        mSearchHistoryLoadService?.showCallback(when (status) {
            // 热门搜索 LoadSir 状态: 成功
            LOAD_SERVICE_SEARCH_HISTORY_SUCCESS -> SuccessCallback::class.java
            // 热门搜索 LoadSir 状态: 加载中
            LOAD_SERVICE_SEARCH_HISTORY_LOADING -> SearchHistoryLoadingCallback::class.java
            // 热门搜索 LoadSir 状态: 暂无数据
            LOAD_SERVICE_SEARCH_HISTORY_EMPTY -> SearchHistoryEmptyCallback::class.java
            // 热门搜索 LoadSir 状态: 加载失败
            LOAD_SERVICE_SEARCH_HISTORY_LOAD_FAIL -> SearchHistoryLoadFailCallback::class.java
            // 热门搜索 默认 LoadSir 状态 成功
            else -> SuccessCallback::class.java
        })
    }

}