package com.shijingfeng.wan_android.view_model

import com.kingja.loadsir.callback.Callback.OnReloadListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import com.shijingfeng.base.annotation.define.PageOperateType
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent
import com.shijingfeng.base.mvvm.livedata.SingleLiveEvent
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
import com.shijingfeng.wan_android.entity.NavigationClassifyEntity
import com.shijingfeng.wan_android.source.network.getNavigationClassifyNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.NavigationClassifyRepository
import com.shijingfeng.wan_android.source.repository.getNavigationClassifyRepositoryInstance

/**
 * Function: 导航分类 ViewModel
 * Date: 2020/4/21 20:30
 * Description:
 * @author ShiJingFeng
 */
internal class NavigationClassifyViewModel : WanAndroidBaseViewModel<NavigationClassifyRepository>() {

    /** 页面操作类型  */
    @PageOperateType
    private var mPageOperateType = PAGE_OPERATE_TYPE_LOAD

    /** 导航分类数据列表  */
    var mNavigationClassifyList = mutableListOf<NavigationClassifyEntity>()

    /** 导航分类数据改变 SingleLiveEvent  */
    val mNavigationClassifyDataChangeEvent =
        SingleLiveEvent<ListDataChangeEvent<NavigationClassifyEntity>>()

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
    override fun getRepository() = getNavigationClassifyRepositoryInstance(
        networkSource = getNavigationClassifyNetworkSourceInstance()
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
        getNavigationClassifyList()
    }

    /**
     * 下拉刷新
     */
    fun refresh() {
        mPageOperateType = PAGE_OPERATE_TYPE_REFRESH
        getNavigationClassifyList()
    }

    /**
     * 获取导航分类数据
     */
    private fun getNavigationClassifyList() {
        mRepository?.getNavigationClassifyList(onSuccess = onSuccessLabel@{ navigationClassifyList ->
            val event = ListDataChangeEvent<NavigationClassifyEntity>()

            when (mPageOperateType) {
                // 加载数据 或 重新加载
                PAGE_OPERATE_TYPE_LOAD -> {
                    mNavigationClassifyList.clear()
                    if (!navigationClassifyList.isNullOrEmpty()) {
                        mNavigationClassifyList.addAll(navigationClassifyList)
                    }

                    event.type = LOAD
                    event.dataList = navigationClassifyList

                    mNavigationClassifyDataChangeEvent.value = event
                    showCallback(if (mNavigationClassifyList.isEmpty()) LOAD_SERVICE_EMPTY else LOAD_SERVICE_SUCCESS)
                }
                // 下拉刷新
                PAGE_OPERATE_TYPE_REFRESH -> {
                    mNavigationClassifyList.clear()
                    if (!navigationClassifyList.isNullOrEmpty()) {
                        mNavigationClassifyList.addAll(navigationClassifyList)
                    }

                    event.type = REFRESH
                    event.dataList = navigationClassifyList

                    mNavigationClassifyDataChangeEvent.value = event
                    updateRefreshLoadMoreStatus(REFRESH_SUCCESS)
                    // 数据为空
                    if (mNavigationClassifyList.isEmpty()) {
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