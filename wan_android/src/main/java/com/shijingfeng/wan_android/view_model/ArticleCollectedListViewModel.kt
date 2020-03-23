package com.shijingfeng.wan_android.view_model

import android.text.TextUtils
import android.view.View.OnClickListener
import com.blankj.utilcode.util.ToastUtils
import com.kingja.loadsir.callback.Callback.OnReloadListener
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.entity.event.ListDataChangeEvent
import com.shijingfeng.base.livedata.SingleLiveEvent
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
import com.shijingfeng.wan_android.entity.event.CollectionEvent
import com.shijingfeng.wan_android.entity.network.ArticleCollectedListEntity
import com.shijingfeng.wan_android.entity.network.ArticleCollectedListItem
import com.shijingfeng.wan_android.source.repository.ArticleCollectedListRepository
import org.greenrobot.eventbus.EventBus
import java.util.*


/**
 * Function: 文章收藏列表 (入口: 首页侧边栏 我的收藏) ViewModel
 * Date: 2020/3/22 19:42
 * Description:
 * @author ShiJingFeng
 */
internal class ArticleCollectedListViewModel(
    repository: ArticleCollectedListRepository? = null
) : WanAndroidBaseViewModel<ArticleCollectedListRepository>(repository) {

    /** 第一页 页码  */
    private val FIRST_PAGE = 0

    /** 当前页码  */
    private var mPage = FIRST_PAGE
    /** 数据操作类型  */
    private var mDataOperateType = DATA_OPERATE_TYPE_LOAD
    /** 文章收藏列表 数据列表 */
    var mArticleCollectedListItemList = ArrayList<ArticleCollectedListItem>()

    /** 列表数据改变 LiveData Event  */
    var mListDataChangeEvent = SingleLiveEvent<ListDataChangeEvent<ArticleCollectedListItem>>()
    /** 置顶 LiveData Event  */
    var mScrollToTopEvent = SingleLiveEvent<Any?>()

    /** 返回  */
    val mBackClickListener = OnClickListener {
        finish()
    }
    /** 置顶  */
    val mScrollToTopListener = OnClickListener {
        mScrollToTopEvent.call()
    }
    /** LoadService 重新加载监听器  */
    val mReloadListener = OnReloadListener {
        if (mLoadServiceStatus == LOADING) {
            return@OnReloadListener
        }
        mDataOperateType = DATA_OPERATE_TYPE_LOAD
        getLoadServiceStatusEvent().value = LOADING
        getArticleCollectedList(FIRST_PAGE)
    }
    /** 下拉刷新  */
    val mOnRefreshListener = OnRefreshListener {
        mDataOperateType = DATA_OPERATE_TYPE_REFRESH
        getArticleCollectedList(FIRST_PAGE)
    }
    /** 上拉加载  */
    val mOnLoadMoreListener = OnLoadMoreListener {
        mDataOperateType = DATA_OPERATE_TYPE_LOAD_MORE
        getArticleCollectedList(mPage + 1)
    }

    /**
     * 初始化
     */
    override fun init() {
        super.init()
        mDataOperateType = DATA_OPERATE_TYPE_LOAD
        getArticleCollectedList(FIRST_PAGE)
    }

    /**
     * 获取 文章收藏列表
     * @param page 页码 (从 0 开始)
     */
    private fun getArticleCollectedList(page: Int) {
        mRepository?.getArticleCollectedList(page, onSuccess = onSuccessLabel@{ articleCollectedList ->
            val articleCollectedItemList = articleCollectedList?.articleCollectedItemList
            val event = ListDataChangeEvent<ArticleCollectedListItem>()

            when (mDataOperateType) {
                // 加载数据
                DATA_OPERATE_TYPE_LOAD -> {
                    mPage = FIRST_PAGE
                    mArticleCollectedListItemList.clear()
                    if (!articleCollectedItemList.isNullOrEmpty()) {
                        mArticleCollectedListItemList.addAll(articleCollectedItemList)
                    }

                    event.type = LOAD
                    event.dataList = articleCollectedItemList

                    mListDataChangeEvent.value = event
                    getLoadServiceStatusEvent().value = if (mArticleCollectedListItemList.isEmpty()) EMPTY else SUCCESS
                }
                // 下拉刷新
                DATA_OPERATE_TYPE_REFRESH -> {
                    mPage = FIRST_PAGE
                    mArticleCollectedListItemList.clear()
                    if (!articleCollectedItemList.isNullOrEmpty()) {
                        mArticleCollectedListItemList.addAll(articleCollectedItemList)
                    }

                    event.type = REFRESH
                    event.dataList = articleCollectedItemList

                    mListDataChangeEvent.value = event
                    getRefreshLoadMoreStatusEvent().value = REFRESH_SUCCESS
                    // 数据为空
                    if (mArticleCollectedListItemList.isEmpty()) {
                        getLoadServiceStatusEvent().value = EMPTY
                    }                }
                // 上拉加载
                DATA_OPERATE_TYPE_LOAD_MORE -> {
                    if (articleCollectedItemList.isNullOrEmpty()) {
                        getRefreshLoadMoreStatusEvent().value = LOAD_MORE_ALL
                        return@onSuccessLabel
                    }
                    ++mPage

                    event.type = ADD
                    event.dataList = articleCollectedItemList
                    event.extraData = mArticleCollectedListItemList.size

                    mArticleCollectedListItemList.addAll(articleCollectedItemList)
                    mListDataChangeEvent.value = event
                    getRefreshLoadMoreStatusEvent().value = LOAD_MORE_SUCCESS
                }
                else -> {}
            }
        }, onFailure = {
            when (mDataOperateType) {
                // 加载数据
                DATA_OPERATE_TYPE_LOAD -> getLoadServiceStatusEvent().value = LOAD_FAIL
                // 下拉刷新
                DATA_OPERATE_TYPE_REFRESH -> getRefreshLoadMoreStatusEvent().value = REFRESH_FAIL
                // 上拉加载
                DATA_OPERATE_TYPE_LOAD_MORE -> getRefreshLoadMoreStatusEvent().value = LOAD_MORE_FAIL
                else -> {}
            }
        })
    }

    /**
     * 取消收藏
     * @param articleCollectedListItem 文章收藏列表 Item 实体
     */
    fun uncollectedInCollectedList(articleCollectedListItem: ArticleCollectedListItem) {
        val articleId = articleCollectedListItem.identity
        val originalId = articleCollectedListItem.originId

        mRepository?.uncollectedInCollectedList(articleId, originalId, onSuccess = {
            val position = getPositionById(articleId)

            if (position != -1) {
                val event = ListDataChangeEvent<ArticleCollectedListItem>()
                val indexList = listOf(position)

                event.type = REMOVE
                event.indexList = indexList
                event.extraData = mArticleCollectedListItemList.size

                mArticleCollectedListItemList.removeAt(position)
                mListDataChangeEvent.value = event

                if (mArticleCollectedListItemList.size <= 0) {
                    //数据为空
                    getLoadServiceStatusEvent().value = EMPTY
                }

                EventBus.getDefault().post(CollectionEvent(articleId, false))
            } else {
                ToastUtils.showShort("已经取消收藏")
            }
        }, onFailure = {
            ToastUtils.showShort("取消收藏失败")
        })
    }

    /**
     * 通过 id 获取 position
     * @param id id
     * @return position
     */
    private fun getPositionById(id: String): Int {
        if (TextUtils.isEmpty(id)) {
            return -1
        }
        val size = mArticleCollectedListItemList.size

        for (i in 0 until size) {
            val articleCollectedListItem = mArticleCollectedListItemList[i]
            val currentId: String = articleCollectedListItem.getId()

            if (id == currentId) {
                return i
            }
        }
        return -1
    }

}