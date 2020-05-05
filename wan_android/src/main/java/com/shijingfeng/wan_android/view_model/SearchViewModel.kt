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
import com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent
import com.shijingfeng.base.livedata.SingleLiveEvent
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.base.util.serialize
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.annotation.define.SearchHistoryLoadServiceStatus
import com.shijingfeng.wan_android.annotation.define.SearchHotWordLoadServiceStatus
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
import com.shijingfeng.wan_android.constant.*
import com.shijingfeng.wan_android.entity.network.SearchHotWordEntity
import com.shijingfeng.wan_android.source.repository.SearchRepository
import okhttp3.internal.immutableListOf

/** 搜索列表 第一页 页码  */
const val SEARCH_LIST_FIRST_PAGE = 0

/**
 * Function: 搜索列表 ViewModel
 * Date: 20-5-3 下午9:26
 * Description:
 * @author shijingfeng
 */
internal class SearchViewModel(
    repository: SearchRepository? = null
) : WanAndroidBaseViewModel<SearchRepository>(repository) {

    /** 搜索热词 数据列表  */
    val mSearchHotWordList = mutableListOf<SearchHotWordEntity>()
    /** 搜索历史 数据列表 */
    val mSearchHistoryList = mutableListOf<String>()

    /** 搜索热词 LoadService 状态 */
    var mSearchHotWordLoadServiceStatus = LOAD_SERVICE_SEARCH_HOT_WORD_SUCCESS
    /** 搜索历史 LoadService 状态 */
    var mSearchHistoryLoadServiceStatus = LOAD_SERVICE_SEARCH_HISTORY_SUCCESS

    /** 搜索热词 列表数据改变 LiveData Event */
    val mSearchHotWordListEvent = SingleLiveEvent<List<SearchHotWordEntity>>()
    /** 搜索热词 LoadService LiveData Event */
    val mSearchHotWordLoadServiceStatusEvent = SingleLiveEvent<Int>()
    /** 搜索历史 列表数据改变 LiveData Event */
    val mSearchHistoryListEvent = SingleLiveEvent<ListDataChangeEvent<String>>()
    /** 搜索历史 LoadService LiveData Event */
    val mSearchHistoryLoadServiceStatusEvent = SingleLiveEvent<Int>()

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
    val mSearchClickListener = View.OnClickListener {

    }

    /** 清空 搜索历史 */
    val mClearHistoryClickListener = View.OnClickListener {

    }

    /** 热门搜索 重新加载 */
    val mOnSearchHotWordReloadListener = Callback.OnReloadListener {

    }

    /** 搜索历史 重新加载 */
    val mOnSearchHistoryReloadListener = Callback.OnReloadListener {

    }

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
     */
    private fun search(keyword: String) {
        showLoadingDialog(getStringById(R.string.搜索中))
        mRepository?.search(keyword, onSuccess = { searchList ->
            hideLoadingDialog()
            val searchItemList = searchList?.searchItemList

            if (!searchItemList.isNullOrEmpty()) {
                addSearchHistoryItem(keyword)
                navigation(
                    path = ACTIVITY_WAN_ANDROID_SEARCH_LIST,
                    bundle = Bundle().apply {
                        putBoolean(FINISH_PREVIOUS_ACTIVITY, true)
                        putString(SEARCH_LIST_STR, serialize(searchItemList))
                    }
                )
            } else {
                ToastUtils.showShort(getStringById(R.string.暂无数据))
            }
        }, onFailure = {
            hideLoadingDialog()
            ToastUtils.showShort(getStringById(R.string.搜索失败))
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
            mSearchHistoryListEvent.value = ListDataChangeEvent<String>().apply {
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
     * @param name 搜索关键词
     */
    private fun addSearchHistoryItem(name: String) {
        mRepository?.addSearchHistoryItem(name, onSuccess = {
//            mSearchHistoryList.add(name)
//            showSearchHistoryCallback(LOAD_SERVICE_SEARCH_HISTORY_SUCCESS)
        }, onFailure = {})
    }

    /**
     * 清空 搜索历史列表 数据
     */
    fun clearSearchHistoryList() {
        mRepository?.clearSearchHistoryList(onSuccess = {
            mSearchHistoryList.clear()
            showSearchHistoryCallback(LOAD_SERVICE_SEARCH_HISTORY_EMPTY)
            mSearchHistoryListEvent.value = ListDataChangeEvent<String>().apply {
                type = CLEAR
            }
        }, onFailure = {
            ToastUtils.showShort(getStringById(R.string.清空失败))
        })
    }

    /**
     * 删除 某条搜索历史 Item
     * @param name 搜索关键词
     */
    fun removeSearchHistoryItem(name: String) {
        mRepository?.removeSearchHistoryItem(name, onSuccess = {
            val index = getIndexByName(name)
            val oldSize = mSearchHistoryList.size

            mSearchHistoryList.removeAt(index)
            if (mSearchHistoryList.size <= 0) {
                showSearchHistoryCallback(LOAD_SERVICE_SEARCH_HISTORY_EMPTY)
            }
            mSearchHistoryListEvent.value = ListDataChangeEvent<String>().apply {
                type = REMOVE
                indexList = immutableListOf(index)
                extraData = oldSize
            }
        }, onFailure = {
            ToastUtils.showShort(getStringById(R.string.删除失败))
        })
    }

    /**
     * 搜索热词 LoadSir 切换状态
     * @param status 要切换到的状态  默认: [LOAD_SERVICE_SEARCH_HOT_WORD_SUCCESS]
     */
    private fun showSearchHotWordCallback(@SearchHotWordLoadServiceStatus status: Int) {
        mSearchHotWordLoadServiceStatus = status
        mSearchHotWordLoadServiceStatusEvent.value = status
    }

    /**
     * 搜索历史 LoadSir 切换状态
     * @param status 要切换到的状态  默认: [LOAD_SERVICE_SEARCH_HISTORY_SUCCESS]
     */
    private fun showSearchHistoryCallback(@SearchHistoryLoadServiceStatus status: Int) {
        mSearchHistoryLoadServiceStatus = status
        mSearchHistoryLoadServiceStatusEvent.value = status
    }

    /**
     * 通过 搜索关键词名称 获取 下标
     * @param name 搜索关键词名称
     * @return 下标
     */
    private fun getIndexByName(name: String): Int {
        if (mSearchHistoryList.isEmpty()) {
            return -1
        }
        mSearchHistoryList.forEachIndexed { index, curName ->
            if (curName == name) {
                return index
            }
        }
        return -1
    }

}