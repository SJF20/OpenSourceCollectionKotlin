package com.shijingfeng.wan_android.view_model

import com.kingja.loadsir.callback.Callback.OnReloadListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import com.shijingfeng.base.annotation.define.PageOperateType
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent
import com.shijingfeng.base.mvvm.livedata.SingleLiveEvent
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
import com.shijingfeng.wan_android.entity.KnowledgeClassifyEntity
import com.shijingfeng.wan_android.source.network.getKnowledgeClassifyNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.KnowledgeClassifyRepository
import com.shijingfeng.wan_android.source.repository.getKnowledgeClassifyRepositoryInstance

/**
 * Function: 知识体系 ViewModel
 * Date: 2020/4/21 20:30
 * Description:
 * @author ShiJingFeng
 */
internal class KnowledgeClassifyViewModel : WanAndroidBaseViewModel<KnowledgeClassifyRepository>() {

    /** 页面操作类型  */
    @PageOperateType
    private var mPageOperateType = PAGE_OPERATE_TYPE_LOAD

    /** 知识体系数据列表  */
    var mKnowledgeClassifyList = mutableListOf<KnowledgeClassifyEntity>()

    /** 知识体系数据改变 SingleLiveEvent  */
    val mKnowledgeClassifyDataChangeEvent =
        SingleLiveEvent<ListDataChangeEvent<KnowledgeClassifyEntity>>()

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

    /**
     * 获取 Repository
     * @return Repository
     */
    override fun getRepository() = getKnowledgeClassifyRepositoryInstance(
        networkSource = getKnowledgeClassifyNetworkSourceInstance()
    )

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
        getKnowledgeClassifyList()
    }

    /**
     * 下拉刷新
     */
    fun refresh() {
        mPageOperateType = PAGE_OPERATE_TYPE_REFRESH
        getKnowledgeClassifyList()
    }

    /**
     * 获取知识体系数据
     */
    private fun getKnowledgeClassifyList() {
        mRepository?.getKnowledgeClassifyList(onSuccess = onSuccessLabel@{ knowledgeClassifyList ->
            val event = ListDataChangeEvent<KnowledgeClassifyEntity>()

            when (mPageOperateType) {
                // 加载数据 或 重新加载
                PAGE_OPERATE_TYPE_LOAD -> {
                    mKnowledgeClassifyList.clear()
                    if (!knowledgeClassifyList.isNullOrEmpty()) {
                        mKnowledgeClassifyList.addAll(knowledgeClassifyList)
                    }

                    event.type = LOAD
                    event.dataList = knowledgeClassifyList

                    mKnowledgeClassifyDataChangeEvent.value = event
                    showCallback(if (mKnowledgeClassifyList.isEmpty()) LOAD_SERVICE_EMPTY else LOAD_SERVICE_SUCCESS)
                }
                // 下拉刷新
                PAGE_OPERATE_TYPE_REFRESH -> {
                    mKnowledgeClassifyList.clear()
                    if (!knowledgeClassifyList.isNullOrEmpty()) {
                        mKnowledgeClassifyList.addAll(knowledgeClassifyList)
                    }

                    event.type = REFRESH
                    event.dataList = knowledgeClassifyList

                    mKnowledgeClassifyDataChangeEvent.value = event
                    updateRefreshLoadMoreStatus(REFRESH_SUCCESS)
                    // 数据为空
                    if (mKnowledgeClassifyList.isEmpty()) {
                        showCallback(LOAD_SERVICE_EMPTY)
                    }
                }
                else -> {}
            }
        }, onFailure = {
            when (mPageOperateType) {
                // 加载数据
                PAGE_OPERATE_TYPE_LOAD -> showCallback(LOAD_SERVICE_LOAD_FAIL)
                // 下拉刷新
                PAGE_OPERATE_TYPE_REFRESH -> updateRefreshLoadMoreStatus(REFRESH_FAIL)
                else -> {}
            }
        })
    }

}