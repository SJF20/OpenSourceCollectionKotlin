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
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.base.util.layout
import com.shijingfeng.skin_changer.constant.BACK_GROUND
import com.shijingfeng.skin_changer.entity.SkinAttribute
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
import com.shijingfeng.wan_android.common.constant.*
import com.shijingfeng.wan_android.common.constant.REMOVE_SEARCH_HISTORY_ITEM
import com.shijingfeng.wan_android.common.constant.SEARCH
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidSearchBinding
import com.shijingfeng.wan_android.entity.adapter.SearchHistoryItem
import com.shijingfeng.wan_android.view_model.SearchViewModel

/**
 * Function: ?????? Activity
 * Date: 20-5-4 ??????5:40
 * Description:
 * Author: shijingfeng
 */
@Route(path = ACTIVITY_WAN_ANDROID_SEARCH)
internal class SearchActivity : WanAndroidBaseActivity<ActivityWanAndroidSearchBinding, SearchViewModel>() {

    /** ???????????? LoadService */
    private var mSearchHotWordLoadService: LoadService<*>? = null
    /** ???????????? LoadService */
    private var mSearchHistoryLoadService: LoadService<*>? = null

    /** ???????????? ????????? */
    private var mSearchHistoryAdapter: SearchHistoryAdapter? = null

    /**
     * ??????ViewModel
     * @return ViewModel
     */
    override fun getViewModel() = createViewModel(SearchViewModel::class.java)

    /**
     * ????????? DataBinding ??????ID ??? ??????????????? Map
     * @return DataBinding ??????SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.searchViewModel, mViewModel)
    }

    /**
     * ????????????ID
     *
     * @return ??????ID
     */
    override fun getLayoutId() = R.layout.activity_wan_android_search

    /**
     * ???????????????
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
        if (mViewModel == null || !mViewModel!!.mHasInitialized) {
            showSearchHotWordCallback(LOAD_SERVICE_SEARCH_HOT_WORD_LOADING)
        }
        mSearchHistoryLoadService = loadSir.register(mDataBinding.rvHistory, mViewModel?.mOnSearchHistoryReloadListener)
        if (mViewModel == null || !mViewModel!!.mHasInitialized) {
            showSearchHistoryCallback(LOAD_SERVICE_SEARCH_HISTORY_LOADING)
        }

        mSearchHistoryAdapter = SearchHistoryAdapter(this, mViewModel?.mSearchHistoryList)
        mDataBinding.rvHistory.layoutManager = LinearLayoutManager(this)
        mDataBinding.rvHistory.adapter = mSearchHistoryAdapter

        registerLoadingView(
            view = mDataBinding.nsvContent
        )
    }

    /**
     * ???????????????
     */
    override fun initAction() {
        super.initAction()
        mSearchHistoryAdapter?.onItemEvent = { _, data, _, flag ->
            when (flag) {
                // ??????
                SEARCH -> {
                    mDataBinding.ivSearch.isEnabled = false
                    mViewModel!!.search(data as String, onSuccess = {
                        mDataBinding.ivSearch.isEnabled = true
                    }, onFailure = {
                        mDataBinding.ivSearch.isEnabled = true
                    })
                }
                // ?????? ?????? ????????????
                REMOVE_SEARCH_HISTORY_ITEM -> mViewModel?.removeSearchHistoryItem(data as SearchHistoryItem)
            }
        }
    }

    /**
     * ????????? LiveData Observer
     */
    override fun initObserver() {
        super.initObserver()
        // ???????????? LoadService ?????? Observer
        mSearchHotWordLoadService?.run {
            mViewModel?.mSearchHotWordLoadServiceStatusEvent?.observe(this@SearchActivity, Observer ObserverLabel@{ status ->
                showSearchHotWordCallback(status)
            })
        }
        // ???????????? LoadService ?????? Observer
        mSearchHistoryLoadService?.run {
            mViewModel?.mSearchHistoryLoadServiceStatusEvent?.observe(this@SearchActivity, Observer ObserverLabel@{ status ->
                showSearchHistoryCallback(status)
            })
        }
        // ???????????? ?????? Observer
        mViewModel?.mSearchHotWordListEvent?.observe(this, Observer ObserverLabel@{ searchHotWordList ->
            if (!searchHotWordList.isNullOrEmpty()) {
                // ????????????????????????
                val totalWidth = ScreenUtils.getScreenWidth() - ConvertUtils.dp2px(25F + 15F)
                // ???????????? View ??????
                val viewList = ArrayList<View>()

                searchHotWordList.forEachIndexed { _, searchHotWord ->
                    viewList.add(TextView(this).apply {
                        text = searchHotWord.name
                        setPadding(ConvertUtils.dp2px(15F), ConvertUtils.dp2px(7F), ConvertUtils.dp2px(15F), ConvertUtils.dp2px(7F))
                        setBackgroundResource(R.drawable.shape_search_hot_word_bg)
                        // ??????
                        ClickUtils.applySingleDebouncing(this) {
                            mDataBinding.ivSearch.isEnabled = false
                            mViewModel?.search(searchHotWord.name, onSuccess = {
                                mDataBinding.ivSearch.isEnabled = true
                            }, onFailure = {
                                mDataBinding.ivSearch.isEnabled = true
                            })
                        }
                    })
                }
                // ??? ?????????????????? ?????????????????? (????????????????????????????????????????????????)
                layout(mDataBinding.llHotWord, viewList, totalWidth, ConvertUtils.dp2px(10F), Gravity.START)
            }
        })
        // ???????????? ?????? Observer
        mViewModel?.mSearchHistoryListEvent?.observe(this, Observer ObserverLabel@{ (type, _, _, extraData, searchHistoryItemList, indexList) ->
            when (type) {
                // ??????, ??????
                LOAD, REFRESH -> mSearchHistoryAdapter?.notifyDataSetChanged()
                // ??????
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
                // ??????
                CLEAR -> mSearchHistoryAdapter?.notifyDataSetChanged()
                else -> {}
            }
        })
    }

    /**
     * ???????????? LoadSir ????????????
     * @param status ?????????????????????  ??????: [LOAD_SERVICE_SEARCH_HOT_WORD_SUCCESS]
     */
    private fun showSearchHotWordCallback(@SearchHotWordLoadServiceStatus status: Int) {
        if (mViewModel!!.mSearchHotWordLoadServiceStatus != status) {
            mViewModel?.mSearchHotWordLoadServiceStatus = status
            mSearchHotWordLoadService?.showCallback(when (status) {
                // ???????????? LoadSir ??????: ??????
                LOAD_SERVICE_SEARCH_HOT_WORD_SUCCESS -> SuccessCallback::class.java
                // ???????????? LoadSir ??????: ?????????
                LOAD_SERVICE_SEARCH_HOT_WORD_LOADING -> SearchHotWordLoadingCallback::class.java
                // ???????????? LoadSir ??????: ????????????
                LOAD_SERVICE_SEARCH_HOT_WORD_EMPTY -> SearchHotWordEmptyCallback::class.java
                // ???????????? LoadSir ??????: ????????????
                LOAD_SERVICE_SEARCH_HOT_WORD_LOAD_FAIL -> SearchHotWordLoadFailCallback::class.java
                // ???????????? ?????? LoadSir ?????? ??????
                else -> SuccessCallback::class.java
            })
        }
    }

    /**
     * ???????????? LoadSir ????????????
     * @param status ?????????????????????  ??????: [LOAD_SERVICE_SEARCH_HISTORY_SUCCESS]
     */
    private fun showSearchHistoryCallback(@SearchHistoryLoadServiceStatus status: Int) {
        if (mViewModel!!.mSearchHistoryLoadServiceStatus != status) {
            mViewModel?.mSearchHistoryLoadServiceStatus = status
            mSearchHistoryLoadService?.showCallback(when (status) {
                // ???????????? LoadSir ??????: ??????
                LOAD_SERVICE_SEARCH_HISTORY_SUCCESS -> SuccessCallback::class.java
                // ???????????? LoadSir ??????: ?????????
                LOAD_SERVICE_SEARCH_HISTORY_LOADING -> SearchHistoryLoadingCallback::class.java
                // ???????????? LoadSir ??????: ????????????
                LOAD_SERVICE_SEARCH_HISTORY_EMPTY -> SearchHistoryEmptyCallback::class.java
                // ???????????? LoadSir ??????: ????????????
                LOAD_SERVICE_SEARCH_HISTORY_LOAD_FAIL -> SearchHistoryLoadFailCallback::class.java
                // ???????????? ?????? LoadSir ?????? ??????
                else -> SuccessCallback::class.java
            })
        }
    }

    /**
     * ???????????? (???????????????????????????)
     */
    override fun getResource() = mutableMapOf<View, List<SkinAttribute>>().apply {
        this[mDataBinding.llTitleBar] = listOf(
            SkinAttribute(
                name = BACK_GROUND,
                data = getStringById(R.string.color_id_wan_android_theme_color)
            )
        )
    }

}