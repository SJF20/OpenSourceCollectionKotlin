package com.shijingfeng.wan_android.ui.activity

import android.util.SparseArray
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.ClickUtils
import com.blankj.utilcode.util.ConvertUtils
import com.blankj.utilcode.util.ScreenUtils
import com.kingja.loadsir.callback.SuccessCallback
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_SEARCH
import com.shijingfeng.base.base.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.util.layout
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.adapter.SearchHistoryAdapter
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
import com.shijingfeng.wan_android.entity.adapter.SearchHistoryItem
import com.shijingfeng.wan_android.source.local.getSearchLocalSourceInstance
import com.shijingfeng.wan_android.source.network.getSearchNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.getSearchRepositoryInstance
import com.shijingfeng.wan_android.view_model.SearchViewModel

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

    /** 搜索历史 适配器 */
    private var mSearchHistoryAdapter: SearchHistoryAdapter? = null

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

        mSearchHotWordLoadService = loadSir.register(mDataBinding.llHotWord, mViewModel?.mOnSearchHotWordReloadListener)
        if (mViewModel == null || !mViewModel!!.mHasInited) {
            showSearchHotWordCallback(LOAD_SERVICE_SEARCH_HOT_WORD_LOADING)
        }
        mSearchHistoryLoadService = loadSir.register(mDataBinding.rvHistory, mViewModel?.mOnSearchHistoryReloadListener)
        if (mViewModel == null || !mViewModel!!.mHasInited) {
            showSearchHistoryCallback(LOAD_SERVICE_SEARCH_HISTORY_LOADING)
        }

        mSearchHistoryAdapter = SearchHistoryAdapter(this, mViewModel?.mSearchHistoryList)
        mDataBinding.rvHistory.layoutManager = LinearLayoutManager(this)
        mDataBinding.rvHistory.adapter = mSearchHistoryAdapter
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
        mSearchHistoryAdapter?.setOnItemEventListener { _, data, _, flag ->
            when (flag) {
                // 搜索
                SEARCH -> mViewModel?.search(data as String)
                // 删除 某条 搜索历史
                REMOVE_SEARCH_HISTORY_ITEM -> mViewModel?.removeSearchHistoryItem(data as SearchHistoryItem)
            }
        }
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
                // 可容纳的最大宽度
                val totalWidth = ScreenUtils.getScreenWidth() - ConvertUtils.dp2px(25F + 15F)
                // 普通标签 View 列表
                val viewList = ArrayList<View>()

                searchHotWordList.forEachIndexed { _, searchHotWord ->
                    viewList.add(TextView(this).apply {
                        text = searchHotWord.name
                        setPadding(ConvertUtils.dp2px(15F), ConvertUtils.dp2px(7F), ConvertUtils.dp2px(15F), ConvertUtils.dp2px(7F))
                        setBackgroundResource(R.drawable.shape_search_hot_word_bg)
                        // 搜索
                        ClickUtils.applySingleDebouncing(this) {
                            mViewModel?.search(searchHotWord.name)
                        }
                    })
                }
                // 对 知识标签控件 进行整体布局 (按控件宽度逐行排列，没有固定列数)
                layout(mDataBinding.llHotWord, viewList, totalWidth, ConvertUtils.dp2px(10F), Gravity.START)
            }
        })
        // 搜索历史 列表 Observer
        mViewModel?.mSearchHistoryListEvent?.observe(this, Observer ObserverLabel@{ (type, _, _, extraData, searchHistoryItemList, indexList) ->
            when (type) {
                // 加载, 刷新
                LOAD, REFRESH -> mSearchHistoryAdapter?.notifyDataSetChanged()
                // 删除
                REMOVE -> {
                    if (indexList.isNullOrEmpty()) {
                        return@ObserverLabel
                    }

                    val oldSize2 = extraData as Int
                    var minPosition = indexList[0]

                    indexList.forEach { position ->
                        if (position < minPosition) {
                            minPosition = position
                        }
                        mSearchHistoryAdapter?.notifyItemRemoved(position)
                    }
                    mSearchHistoryAdapter?.notifyItemRangeChanged(
                        minPosition,
                        oldSize2 - minPosition
                    )
                }
                // 清空
                CLEAR -> mSearchHistoryAdapter?.notifyDataSetChanged()
                else -> {}
            }
        })
    }

    /**
     * 搜索热词 LoadSir 切换状态
     * @param status 要切换到的状态  默认: [LOAD_SERVICE_SEARCH_HOT_WORD_SUCCESS]
     */
    private fun showSearchHotWordCallback(@SearchHotWordLoadServiceStatus status: Int) {
        if (mViewModel!!.mSearchHotWordLoadServiceStatus != status) {
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
    }

    /**
     * 搜索历史 LoadSir 切换状态
     * @param status 要切换到的状态  默认: [LOAD_SERVICE_SEARCH_HISTORY_SUCCESS]
     */
    private fun showSearchHistoryCallback(@SearchHistoryLoadServiceStatus status: Int) {
        if (mViewModel!!.mSearchHistoryLoadServiceStatus != status) {
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

}