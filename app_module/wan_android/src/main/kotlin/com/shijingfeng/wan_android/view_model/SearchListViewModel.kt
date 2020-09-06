package com.shijingfeng.wan_android.view_model

import android.util.SparseArray
import android.view.View
import com.blankj.utilcode.util.ToastUtils
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent
import com.shijingfeng.base.livedata.SingleLiveEvent
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
import com.shijingfeng.wan_android.common.constant.KEY_ARTICLE_ID
import com.shijingfeng.wan_android.common.constant.KEY_COLLECTED
import com.shijingfeng.wan_android.entity.event.ArticleCollectionEvent
import com.shijingfeng.wan_android.entity.SearchListItem
import com.shijingfeng.wan_android.source.repository.SearchListRepository
import com.shijingfeng.wan_android.ui.activity.SearchListActivity
import org.greenrobot.eventbus.EventBus

/**
 * Function: 搜索列表 ViewModel
 * Date: 20-5-3 下午9:26
 * Description:
 * @author shijingfeng
 */
internal class SearchListViewModel(
    repository: SearchListRepository? = null
) : WanAndroidBaseViewModel<SearchListRepository>(repository) {

    /** 当前页码  */
    private var mPage = SEARCH_LIST_FIRST_PAGE + 1

    /** 搜索关键词 */
    var mSearchHotWord = ""
    /** 搜索列表 */
    var mSearchList = mutableListOf<SearchListItem>()

    /** 搜索列表 数据改变 SingleLiveEvent  */
    val mSearchListDataChangeEvent = SingleLiveEvent<ListDataChangeEvent<SearchListItem>>()
    /** 文章收藏状态 SingleLiveEvent  true 收藏  false 取消收藏  */
    val mCollectedStatusEvent = SingleLiveEvent<SparseArray<Any?>>()

    /** 返回 */
    val mBackClickListener = View.OnClickListener { finish() }

    /** 上拉加载  */
    val mOnLoadMoreListener = OnLoadMoreListener { getSearchData(mPage + 1) }

    /**
     * 获取搜索数据
     */
    private fun getSearchData(page: Int) {
        mRepository?.getSearchList(page, mSearchHotWord, onSuccess = { searchListEntity ->
            val searchItemList = searchListEntity?.searchItemList

            if (searchItemList.isNullOrEmpty()) {
                updateRefreshLoadMoreStatus(LOAD_MORE_ALL)
                return@getSearchList
            }

            ++mPage

            val oldSize = mSearchList.size

            mSearchList.addAll(searchItemList)
            mSearchListDataChangeEvent.value = ListDataChangeEvent<SearchListItem>().apply {
                type = ADD
                dataList = searchItemList
                extraData = oldSize
            }
            updateRefreshLoadMoreStatus(LOAD_MORE_SUCCESS)
        }, onFailure = {
            updateRefreshLoadMoreStatus(LOAD_MORE_FAIL)
        })
    }

    /**
     * 收藏
     * @param articleId 文章ID
     */
    fun collected(articleId: String) {
        mRepository?.collected(articleId, onSuccess = {
            ToastUtils.showShort(getStringById(R.string.收藏成功))
            mCollectedStatusEvent.value = SparseArray<Any?>().apply {
                put(KEY_COLLECTED, true)
                put(KEY_ARTICLE_ID, articleId)
            }
            // 收藏该文章 广播出去
            EventBus.getDefault().post(ArticleCollectionEvent(
                fromName = SearchListActivity::class.java.name,
                id = articleId,
                collected = true
            ))
        })
    }

    /**
     * 取消收藏
     * @param articleId 文章ID
     */
    fun uncollected(articleId: String) {
        mRepository?.uncollected(articleId, onSuccess = {
            ToastUtils.showShort(getStringById(R.string.取消收藏成功))
            mCollectedStatusEvent.value = SparseArray<Any?>().apply {
                put(KEY_COLLECTED, false)
                put(KEY_ARTICLE_ID, articleId)
            }
            // 取消收藏该文章 广播出去
            EventBus.getDefault().post(ArticleCollectionEvent(
                fromName = SearchListActivity::class.java.name,
                id = articleId,
                collected = false
            ))
        })
    }

}