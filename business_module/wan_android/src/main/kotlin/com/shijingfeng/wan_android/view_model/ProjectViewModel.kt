package com.shijingfeng.wan_android.view_model

import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent
import com.shijingfeng.base.mvvm.livedata.SingleLiveEvent
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
import com.shijingfeng.wan_android.source.repository.ProjectRepository
import com.kingja.loadsir.callback.Callback.OnReloadListener
import com.shijingfeng.wan_android.entity.ProjectIndexEntity
import com.shijingfeng.wan_android.source.network.getProjectNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.getProjectRepositoryInstance

/**
 * Function: 项目 ViewModel
 * Date: 2020/2/12 17:10
 * Description:
 * Author: ShiJingFeng
 */
internal class ProjectViewModel : WanAndroidBaseViewModel<ProjectRepository>() {

    /** 当前 Fragment Item Position */
    var mCurrentFragmentPosition = 0
    /** 项目 索引数据 列表  */
    val mProjectIndexList = mutableListOf<ProjectIndexEntity>()

    /** 项目 索引数据 列表 改变 SingleLiveEvent */
    val mProjectIndexDataChangeEvent =
        SingleLiveEvent<ListDataChangeEvent<ProjectIndexEntity>>()

    /** LoadService 重新加载监听器  */
    val mReloadListener = OnReloadListener {
        if (mLoadServiceStatus == LOAD_SERVICE_LOADING) {
            return@OnReloadListener
        }
        showCallback(LOAD_SERVICE_LOADING)
        getProjectIndex()
    }

    /**
     * 获取 Repository
     * @return Repository
     */
    override fun getRepository() = getProjectRepositoryInstance(
        networkSource = getProjectNetworkSourceInstance()
    )

    /**
     * 初始化
     */
    override fun init() {
        super.init()
        getProjectIndex()
    }

    /**
     * 获取 项目 索引数据
     */
    private fun getProjectIndex() {
        mRepository?.getProjectIndex(onSuccess = { projectIndexList ->
            mProjectIndexList.clear()
            if (!projectIndexList.isNullOrEmpty()) {
                mProjectIndexList.addAll(projectIndexList)
            }
            mProjectIndexDataChangeEvent.value = ListDataChangeEvent<ProjectIndexEntity>().apply {
                type = LOAD
                dataList = projectIndexList
            }
            showCallback(if (mProjectIndexList.isEmpty()) LOAD_SERVICE_EMPTY else LOAD_SERVICE_SUCCESS)
        }, onFailure = {
            showCallback(LOAD_SERVICE_LOAD_FAIL)
        })
    }

}