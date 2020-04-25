package com.shijingfeng.wan_android.view_model

import com.kingja.loadsir.callback.Callback.OnReloadListener
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import com.shijingfeng.base.annotation.define.PageOperateType
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent
import com.shijingfeng.base.livedata.SingleLiveEvent
import com.shijingfeng.base.util.deserialize
import com.shijingfeng.base.util.e
import com.shijingfeng.base.util.serialize
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
import com.shijingfeng.wan_android.constant.KNOWLEDGE_CLASSIFY_CHILDREN_STR
import com.shijingfeng.wan_android.entity.network.KnowledgeClassifyChildItem
import com.shijingfeng.wan_android.entity.network.KnowledgeClassifyChildren
import com.shijingfeng.wan_android.source.repository.KnowledgeClassifyChildRepository

/** 第一页 页码  */
const val KNOWLEDGE_CLASSIFY_CHILD_FIRST_PAGE = 0

/**
 * Function: 知识体系 二级数据 ViewModel
 * Date: 2020/4/21 20:30
 * Description:
 * @author ShiJingFeng
 */
internal class KnowledgeClassifyChildViewModel(
    repository: KnowledgeClassifyChildRepository? = null
) : WanAndroidBaseViewModel<KnowledgeClassifyChildRepository>(repository) {

    /** 当前页码  */
    private var mPage = KNOWLEDGE_CLASSIFY_CHILD_FIRST_PAGE

    /** 页面操作类型  */
    @PageOperateType private var mPageOperateType = PAGE_OPERATE_TYPE_LOAD

    /** 知识体系 二级数据　列表  */
    var mKnowledgeClassifyChildItemList = mutableListOf<KnowledgeClassifyChildItem>()

    /** 知识体系　二级数据 列表 改变 SingleLiveEvent  */
    val mKnowledgeClassifyChildDataChangeEvent = SingleLiveEvent<ListDataChangeEvent<KnowledgeClassifyChildItem>>()

    /** 知识体系 二级数据 */
    var mKnowledgeClassifyChildren: KnowledgeClassifyChildren? = null

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
        getKnowledgeClassifyChildList(KNOWLEDGE_CLASSIFY_CHILD_FIRST_PAGE)
    }

    /**
     * 下拉刷新
     */
    private fun refresh() {
        mPageOperateType = PAGE_OPERATE_TYPE_REFRESH
        getKnowledgeClassifyChildList(KNOWLEDGE_CLASSIFY_CHILD_FIRST_PAGE)
    }

    /**
     * 上拉加载
     */
    private fun loadMore() {
        mPageOperateType = PAGE_OPERATE_TYPE_LOAD_MORE
        getKnowledgeClassifyChildList(mPage + 1)
    }

    /**
     * 获取 知识体系 二级数据
     * @param page 页码 (从 [KNOWLEDGE_CLASSIFY_CHILD_FIRST_PAGE] 开始)
     */
    private fun getKnowledgeClassifyChildList(page: Int) {
        mRepository?.getKnowledgeClassifyChild(
            page = page,
            id = mKnowledgeClassifyChildren?.getId() ?: "",
            onSuccess = onSuccessLabel@{ knowledgeClassifyChild ->
                val knowledgeClassifyChildItemList = knowledgeClassifyChild?.dataList
                val event = ListDataChangeEvent<KnowledgeClassifyChildItem>()

                when (mPageOperateType) {
                    // 加载数据 或 重新加载
                    PAGE_OPERATE_TYPE_LOAD -> {
                        mPage = KNOWLEDGE_CLASSIFY_CHILD_FIRST_PAGE
                        mKnowledgeClassifyChildItemList.clear()
                        if (!knowledgeClassifyChildItemList.isNullOrEmpty()) {
                            mKnowledgeClassifyChildItemList.addAll(knowledgeClassifyChildItemList)
                        }

                        event.type = LOAD
                        event.dataList = knowledgeClassifyChildItemList

                        mKnowledgeClassifyChildDataChangeEvent.value = event
                        showCallback(if (mKnowledgeClassifyChildItemList.isEmpty()) LOAD_SERVICE_EMPTY else LOAD_SERVICE_SUCCESS)
                    }
                    // 下拉刷新
                    PAGE_OPERATE_TYPE_REFRESH -> {
                        mPage = KNOWLEDGE_CLASSIFY_CHILD_FIRST_PAGE
                        mKnowledgeClassifyChildItemList.clear()
                        if (!knowledgeClassifyChildItemList.isNullOrEmpty()) {
                            mKnowledgeClassifyChildItemList.addAll(knowledgeClassifyChildItemList)
                        }

                        event.type = REFRESH
                        event.dataList = knowledgeClassifyChildItemList

                        mKnowledgeClassifyChildDataChangeEvent.value = event
                        updateRefreshLoadMoreStatus(REFRESH_SUCCESS)
                        // 数据为空
                        if (mKnowledgeClassifyChildItemList.isEmpty()) {
                            showCallback(LOAD_SERVICE_EMPTY)
                        }
                    }
                    // 上拉加载
                    PAGE_OPERATE_TYPE_LOAD_MORE -> {
                        if (knowledgeClassifyChildItemList.isNullOrEmpty()) {
                            updateRefreshLoadMoreStatus(LOAD_MORE_ALL)
                            return@onSuccessLabel
                        }
                        ++mPage

                        event.type = ADD
                        event.dataList = knowledgeClassifyChildItemList
                        event.extraData = mKnowledgeClassifyChildItemList.size

                        //添加数据
                        mKnowledgeClassifyChildItemList.addAll(knowledgeClassifyChildItemList)
                        mKnowledgeClassifyChildDataChangeEvent.value = event
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

}