package com.shijingfeng.wan_android.view_model

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import com.blankj.utilcode.util.ToastUtils
import com.kingja.loadsir.callback.Callback
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_SEARCH_LIST
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.network.extension.onFailure
import com.shijingfeng.network.extension.onSuccess
import com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent
import com.shijingfeng.base.mvvm.livedata.SingleLiveEvent
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.base.util.serialize
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.annotation.define.SearchHistoryLoadServiceStatus
import com.shijingfeng.wan_android.annotation.define.SearchHotWordLoadServiceStatus
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
import com.shijingfeng.wan_android.common.constant.*
import com.shijingfeng.wan_android.common.constant.SEARCH_HOT_WORD
import com.shijingfeng.wan_android.common.constant.SEARCH_LIST_STR
import com.shijingfeng.wan_android.entity.adapter.SearchHistoryItem
import com.shijingfeng.wan_android.entity.SearchHotWordEntity
import com.shijingfeng.wan_android.entity.SearchListEntity
import com.shijingfeng.wan_android.source.local.getSearchLocalSourceInstance
import com.shijingfeng.wan_android.source.network.getSearchNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.SearchRepository
import com.shijingfeng.wan_android.source.repository.getSearchRepositoryInstance
import okhttp3.internal.immutableListOf
import java.util.*

/** 搜索列表 第一页 页码  */
const val SEARCH_LIST_FIRST_PAGE = 0

/**
 * Function: 搜索列表 ViewModel
 * Date: 20-5-3 下午9:26
 * Description:
 * Author: shijingfeng
 */
internal class SearchViewModel : WanAndroidBaseViewModel<SearchRepository>() {

    /** 搜索热词 数据列表  */
    val mSearchHotWordList = mutableListOf<SearchHotWordEntity>()
    /** 搜索历史 数据列表 */
    val mSearchHistoryList = LinkedList<SearchHistoryItem>()

    /** 搜索热词 LoadService 状态 */
    var mSearchHotWordLoadServiceStatus = LOAD_SERVICE_SEARCH_HOT_WORD_SUCCESS
    /** 搜索历史 LoadService 状态 */
    var mSearchHistoryLoadServiceStatus = LOAD_SERVICE_SEARCH_HISTORY_SUCCESS

    /** 搜索热词 LoadService LiveData Event */
    val mSearchHotWordLoadServiceStatusEvent = SingleLiveEvent<Int>()
    /** 搜索历史 LoadService LiveData Event */
    val mSearchHistoryLoadServiceStatusEvent = SingleLiveEvent<Int>()
    /** 搜索热词 列表数据改变 LiveData Event */
    val mSearchHotWordListEvent = SingleLiveEvent<List<SearchHotWordEntity>>()
    /** 搜索历史 列表数据改变 LiveData Event */
    val mSearchHistoryListEvent = SingleLiveEvent<ListDataChangeEvent<SearchHistoryItem>>()

    /** 搜索输入框 */
    val mSearchInput = ObservableField("")

    /** 搜索输入框 清除按钮 可见性  */
    val mSearchInputClearVisibility = object : ObservableInt(mSearchInput) {
        override fun get() = if (TextUtils.isEmpty(mSearchInput.get())) View.GONE else View.VISIBLE
    }

    /** 返回  */
    val mBackClickListener = View.OnClickListener { finish() }

    /** 搜索输入框 清除文本 */
    val mSearchInputClearClickListener = View.OnClickListener {
        mSearchInput.set("")
    }

    /** 搜索 */
    val mSearchClickListener = View.OnClickListener { view ->
        val searchText = mSearchInput.get()

        if (searchText.isNullOrEmpty()) {
            ToastUtils.showShort(getStringById(R.string.搜索文本不能为空))
            return@OnClickListener
        }
        view.isEnabled = false
        search(searchText, onSuccess = {
            view.isEnabled = true
        }, onFailure = {
            view.isEnabled = true
        })
    }

    /** 清空 搜索历史 */
    val mClearHistoryClickListener = View.OnClickListener {
        if (mSearchHistoryList.isNotEmpty()) {
            clearSearchHistoryList()
        }
    }

    /** 热门搜索 重新加载 */
    val mOnSearchHotWordReloadListener = Callback.OnReloadListener {
        if (mSearchHotWordLoadServiceStatus == LOAD_SERVICE_SEARCH_HOT_WORD_LOADING) {
            return@OnReloadListener
        }
        showSearchHotWordCallback(LOAD_SERVICE_SEARCH_HOT_WORD_LOADING)
        getSearchHotWordList()
    }

    /** 搜索历史 重新加载 */
    val mOnSearchHistoryReloadListener = Callback.OnReloadListener {
        if (mSearchHistoryLoadServiceStatus == LOAD_SERVICE_SEARCH_HISTORY_LOADING) {
            return@OnReloadListener
        }
        showSearchHistoryCallback(LOAD_SERVICE_SEARCH_HISTORY_LOADING)
        getSearchHistoryList()
    }

    /**
     * 获取 Repository
     * @return Repository
     */
    override fun getRepository() = getSearchRepositoryInstance(
        localSource = getSearchLocalSourceInstance(),
        networkSource = getSearchNetworkSourceInstance()
    )

    /**
     * 初始化
     */
    override fun init() {
        super.init()
        getSearchHotWordList()
        getSearchHistoryList()
    }

    /**
     * 搜索
     * @param keyword 搜索关键词
     * @param onSuccess 成功回调
     * @param onFailure 失败回调
     */
    fun search(
        keyword: String,
        onSuccess: onSuccess<SearchListEntity?>? = null,
        onFailure: onFailure? = null
    ) {
        showLoadingView(getStringById(R.string.搜索中))
        mRepository?.search(keyword, onSuccess = { searchList ->
            val searchItemList = searchList?.searchItemList

            if (!searchItemList.isNullOrEmpty()) {
                addSearchHistoryItem(
                    searchHistoryItem = SearchHistoryItem(keyword),
                    onSuccess = {
                        hideLoadingView()
                        navigation(
                            path = ACTIVITY_WAN_ANDROID_SEARCH_LIST,
                            bundle = Bundle().apply {
                                putString(SEARCH_HOT_WORD, keyword)
                                putString(SEARCH_LIST_STR, serialize(searchItemList))
                            }
                        )
                    },
                    onFailure = {
                        hideLoadingView()
                        navigation(
                            path = ACTIVITY_WAN_ANDROID_SEARCH_LIST,
                            bundle = Bundle().apply {
                                putString(SEARCH_HOT_WORD, keyword)
                                putString(SEARCH_LIST_STR, serialize(searchItemList))
                            }
                        )
                    }
                )
            } else {
                ToastUtils.showShort(getStringById(R.string.暂无数据))
            }
            onSuccess?.invoke(searchList)
        }, onFailure = { e ->
            hideLoadingView()
            ToastUtils.showShort(getStringById(R.string.搜索失败))
            onFailure?.invoke(e)
        })
    }

    /**
     * 获取 搜索热词列表 数据
     */
    private fun getSearchHotWordList() {
        mRepository?.getSearchHotWordList(onSuccess = { searchHotWordList ->
            mSearchHotWordList.clear()
            if (!searchHotWordList.isNullOrEmpty()) {
                mSearchHotWordList.addAll(searchHotWordList)
            }
            mSearchHotWordListEvent.value = mSearchHotWordList
            if (mSearchHotWordList.isEmpty()) {
                showSearchHotWordCallback(LOAD_SERVICE_SEARCH_HOT_WORD_EMPTY)
            } else {
                showSearchHotWordCallback(LOAD_SERVICE_SEARCH_HOT_WORD_SUCCESS)
            }
        }, onFailure = {
            showSearchHotWordCallback(LOAD_SERVICE_SEARCH_HOT_WORD_LOAD_FAIL)
        })
    }

    /**
     * 获取 搜索历史列表 数据
     */
    private fun getSearchHistoryList() {
        mRepository?.getSearchHistoryList(onSuccess = { searchHistoryList ->
            mSearchHistoryList.clear()
            if (!searchHistoryList.isNullOrEmpty()) {
                mSearchHistoryList.addAll(searchHistoryList)
            }
            mSearchHistoryListEvent.value = ListDataChangeEvent<SearchHistoryItem>().apply {
                type = LOAD
                dataList = mSearchHistoryList
            }
            if (mSearchHistoryList.isEmpty()) {
                showSearchHistoryCallback(LOAD_SERVICE_SEARCH_HISTORY_EMPTY)
            } else {
                showSearchHistoryCallback(LOAD_SERVICE_SEARCH_HISTORY_SUCCESS)
            }
        }, onFailure = {
            showSearchHistoryCallback(LOAD_SERVICE_SEARCH_HISTORY_LOAD_FAIL)
        })
    }

    /**
     * 添加 某条搜索历史 Item
     * @param searchHistoryItem 搜索历史 Item 实体类
     */
    private fun addSearchHistoryItem(
        searchHistoryItem: SearchHistoryItem,
        onSuccess: onSuccess<Any?>? = null,
        onFailure: onFailure? = null
    ) {
        val oldSearchHistoryList = mutableListOf<SearchHistoryItem>()
        val index = mSearchHistoryList.indexOf(searchHistoryItem)

        oldSearchHistoryList.addAll(mSearchHistoryList)
        if (index != -1) {
            // 列表中包含此关键词
            if (mSearchHistoryList[0].name != searchHistoryItem.name) {
                mSearchHistoryList.removeAt(index)
            } else {
                // 因为是第一个Item, 所以不需要变动
                onSuccess?.invoke(null)
                return
            }
        }
        mSearchHistoryList.add(0, searchHistoryItem)
        mRepository?.updateSearchHistory(mSearchHistoryList, onSuccess = OnSuccess@{
            mSearchHistoryListEvent.value = ListDataChangeEvent<SearchHistoryItem>().apply {
                type = REFRESH
            }
            showSearchHistoryCallback(LOAD_SERVICE_SEARCH_HISTORY_SUCCESS)
            onSuccess?.invoke(null)
        }, onFailure = { httpException ->
            mSearchHistoryList.clear()
            mSearchHistoryList.addAll(oldSearchHistoryList)
            onFailure?.invoke(httpException)
        })
    }

    /**
     * 删除 某条搜索历史 Item
     * @param searchHistoryItem 搜索历史 Item 实体类
     */
    fun removeSearchHistoryItem(searchHistoryItem: SearchHistoryItem) {
        showLoadingView(getStringById(R.string.删除中))

        val index = getIndexByItem(searchHistoryItem)
        val oldSize = mSearchHistoryList.size

        mSearchHistoryList.removeAt(index)
        mRepository?.updateSearchHistory(
            searchHistoryList = mSearchHistoryList,
            onSuccess = {
                if (mSearchHistoryList.size <= 0) {
                    showSearchHistoryCallback(LOAD_SERVICE_SEARCH_HISTORY_EMPTY)
                }
                mSearchHistoryListEvent.value = ListDataChangeEvent<SearchHistoryItem>().apply {
                    type = REMOVE
                    indexList = immutableListOf(index)
                    extraData = oldSize
                }
                hideLoadingView()
            },
            onFailure = {
                mSearchHistoryList.add(index, searchHistoryItem)
                ToastUtils.showShort(getStringById(R.string.删除失败))
                hideLoadingView()
            }
        )
    }

    /**
     * 清空 搜索历史列表 数据
     */
    private fun clearSearchHistoryList() {
        showLoadingView(getStringById(R.string.清空中))
        mRepository?.updateSearchHistory(
            searchHistoryList = null,
            onSuccess = {
                mSearchHistoryList.clear()
                showSearchHistoryCallback(LOAD_SERVICE_SEARCH_HISTORY_EMPTY)
                mSearchHistoryListEvent.value = ListDataChangeEvent<SearchHistoryItem>().apply {
                    type = CLEAR
                }
                hideLoadingView()
            },
            onFailure = {
                ToastUtils.showShort(getStringById(R.string.清空失败))
                hideLoadingView()
            }
        )
    }

    /**
     * 搜索热词 LoadSir 切换状态
     * @param status 要切换到的状态  默认: [LOAD_SERVICE_SEARCH_HOT_WORD_SUCCESS]
     */
    private fun showSearchHotWordCallback(@SearchHotWordLoadServiceStatus status: Int) {
        if (mSearchHotWordLoadServiceStatus != status) {
            mSearchHotWordLoadServiceStatusEvent.value = status
        }
    }

    /**
     * 搜索历史 LoadSir 切换状态
     * @param status 要切换到的状态  默认: [LOAD_SERVICE_SEARCH_HISTORY_SUCCESS]
     */
    private fun showSearchHistoryCallback(@SearchHistoryLoadServiceStatus status: Int) {
        if (mSearchHistoryLoadServiceStatus != status) {
            mSearchHistoryLoadServiceStatusEvent.value = status
        }
    }

    /**
     * 通过 搜索关键词名称 获取 下标
     * @param searchHistoryItem 搜索历史 Item 实体类
     * @return 下标
     */
    private fun getIndexByItem(searchHistoryItem: SearchHistoryItem): Int {
        if (mSearchHistoryList.isEmpty()) {
            return -1
        }
        mSearchHistoryList.forEachIndexed { index, curSearchHistoryItem ->
            if (curSearchHistoryItem.name == searchHistoryItem.name) {
                return index
            }
        }
        return -1
    }

}