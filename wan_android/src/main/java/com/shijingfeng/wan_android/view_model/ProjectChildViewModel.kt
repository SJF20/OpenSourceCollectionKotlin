package com.shijingfeng.wan_android.view_model

import android.util.SparseArray
import com.blankj.utilcode.util.ToastUtils
import com.shijingfeng.base.annotation.define.PageOperateType
import com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent
import com.shijingfeng.base.livedata.SingleLiveEvent
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
import com.shijingfeng.wan_android.entity.network.ProjectChildItem
import com.shijingfeng.wan_android.source.repository.ProjectChildRepository
import com.kingja.loadsir.callback.Callback.OnReloadListener
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.constant.KEY_ARTICLE_ID
import com.shijingfeng.wan_android.constant.KEY_COLLECTED
import com.shijingfeng.wan_android.entity.event.ArticleCollectionEvent
import com.shijingfeng.wan_android.entity.network.ProjectIndexEntity
import com.shijingfeng.wan_android.ui.fragment.ProjectChildFragment
import org.greenrobot.eventbus.EventBus

/** 第一页 页码  */
const val PROJECT_CHILD_FIRST_PAGE = 1

/**
 * Function: 项目 二级数据 ViewModel
 * Date: 20-4-29 下午10:17
 * Description:
 * @author shijingfeng
 */
internal class ProjectChildViewModel(
    repository: ProjectChildRepository? = null
) : WanAndroidBaseViewModel<ProjectChildRepository>(repository) {

    /** 当前页码  */
    private var mPage = PROJECT_CHILD_FIRST_PAGE

    /** 页面操作类型  */
    @PageOperateType private var mPageOperateType = PAGE_OPERATE_TYPE_LOAD

    /** 项目 某个索引数据 */
    var mProjectIndex: ProjectIndexEntity? = null

    /** 项目 二级数据 列表  */
    var mProjectChildItemList = mutableListOf<ProjectChildItem>()

    /** 项目 二级数据 列表 改变 SingleLiveEvent  */
    val mProjectChildDataChangeEvent = SingleLiveEvent<ListDataChangeEvent<ProjectChildItem>>()
    /** 文章收藏状态 SingleLiveEvent  true 收藏  false 取消收藏  */
    val mCollectedStatusEvent = SingleLiveEvent<SparseArray<Any?>>()

    /** LoadService 重新加载监听器  */
    val mReloadListener = OnReloadListener {
        if (mLoadServiceStatus == LOAD_SERVICE_LOADING) {
            return@OnReloadListener
        }
        showCallback(LOAD_SERVICE_LOADING)
        load()
    }

    /** 下拉刷新  */
    val mOnRefreshListener = OnRefreshListener { refresh() }

    /** 上拉加载  */
    val mOnLoadMoreListener = OnLoadMoreListener { loadMore() }

    /**
     * 初始化
     */
    override fun init() {
        super.init()
        load()
    }

    /**
     * 加载数据
     */
    private fun load() {
        mPageOperateType = PAGE_OPERATE_TYPE_LOAD
        getProjectChild(PROJECT_CHILD_FIRST_PAGE)
    }

    /**
     * 下拉刷新
     */
    fun refresh() {
        mPageOperateType = PAGE_OPERATE_TYPE_REFRESH
        getProjectChild(PROJECT_CHILD_FIRST_PAGE)
    }

    /**
     * 上拉加载
     */
    private fun loadMore() {
        mPageOperateType = PAGE_OPERATE_TYPE_LOAD_MORE
        getProjectChild(mPage + 1)
    }

    /**
     * 项目 二级数据
     * @param page 页码 (从 [PROJECT_CHILD_FIRST_PAGE] 开始)
     */
    private fun getProjectChild(page: Int) {
        mRepository?.getProjectChild(
            page = page,
            id = mProjectIndex?.getId() ?: "",
            onSuccess = onSuccessLabel@{ projectChild ->
                val projectChildItemList = projectChild?.projectChildItemList
                val event = ListDataChangeEvent<ProjectChildItem>()

                when (mPageOperateType) {
                    // 加载数据 或 重新加载
                    PAGE_OPERATE_TYPE_LOAD -> {
                        mPage = PROJECT_CHILD_FIRST_PAGE
                        mProjectChildItemList.clear()
                        if (!projectChildItemList.isNullOrEmpty()) {
                            mProjectChildItemList.addAll(projectChildItemList)
                        }

                        event.type = LOAD
                        event.dataList = projectChildItemList

                        mProjectChildDataChangeEvent.value = event
                        showCallback(if (mProjectChildItemList.isEmpty()) LOAD_SERVICE_EMPTY else LOAD_SERVICE_SUCCESS)
                    }
                    // 下拉刷新
                    PAGE_OPERATE_TYPE_REFRESH -> {
                        mPage = PROJECT_CHILD_FIRST_PAGE
                        mProjectChildItemList.clear()
                        if (!projectChildItemList.isNullOrEmpty()) {
                            mProjectChildItemList.addAll(projectChildItemList)
                        }

                        event.type = REFRESH
                        event.dataList = projectChildItemList

                        mProjectChildDataChangeEvent.value = event
                        updateRefreshLoadMoreStatus(REFRESH_SUCCESS)
                        // 数据为空
                        if (mProjectChildItemList.isEmpty()) {
                            showCallback(LOAD_SERVICE_EMPTY)
                        }
                    }
                    // 上拉加载
                    PAGE_OPERATE_TYPE_LOAD_MORE -> {
                        if (projectChildItemList.isNullOrEmpty()) {
                            updateRefreshLoadMoreStatus(LOAD_MORE_ALL)
                            return@onSuccessLabel
                        }
                        ++mPage

                        event.type = ADD
                        event.dataList = projectChildItemList
                        event.extraData = mProjectChildItemList.size

                        //添加数据
                        mProjectChildItemList.addAll(projectChildItemList)
                        mProjectChildDataChangeEvent.value = event
                        updateRefreshLoadMoreStatus(LOAD_MORE_SUCCESS)
                    }
                    else -> {}
                }
            },
            onFailure = {
                when (mPageOperateType) {
                    // 加载数据
                    PAGE_OPERATE_TYPE_LOAD -> showCallback(LOAD_SERVICE_LOAD_FAIL)
                    // 下拉刷新
                    PAGE_OPERATE_TYPE_REFRESH -> updateRefreshLoadMoreStatus(REFRESH_FAIL)
                    // 上拉加载
                    PAGE_OPERATE_TYPE_LOAD_MORE -> updateRefreshLoadMoreStatus(LOAD_MORE_FAIL)
                    else -> {}
                }
            }
        )
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
            EventBus.getDefault().post(
                ArticleCollectionEvent(
                fromName = ProjectChildFragment::class.java.name,
                id = articleId,
                collected = true
            )
            )
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
            EventBus.getDefault().post(
                ArticleCollectionEvent(
                fromName = ProjectChildFragment::class.java.name,
                id = articleId,
                collected = false
            )
            )
        })
    }

}