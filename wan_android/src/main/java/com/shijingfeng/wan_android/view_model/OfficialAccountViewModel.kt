package com.shijingfeng.wan_android.view_model

import com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent
import com.shijingfeng.base.livedata.SingleLiveEvent
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
import com.shijingfeng.wan_android.entity.network.OfficialAccountIndexEntity
import com.shijingfeng.wan_android.source.repository.OfficialAccountRepository
import com.kingja.loadsir.callback.Callback.OnReloadListener
import com.shijingfeng.base.common.constant.*

/**
 * Function: 公众号 ViewModel
 * Date: 2020/2/12 17:00
 * Description:
 * @author ShiJingFeng
 */
internal class OfficialAccountViewModel(
    repository: OfficialAccountRepository? = null
) : WanAndroidBaseViewModel<OfficialAccountRepository>(repository) {

    /** 当前 Fragment Item Position */
    var mCurrentFragmentPosition = 0
    /** 公众号 索引数据 列表  */
    val mOfficialAccountIndexList = mutableListOf<OfficialAccountIndexEntity>()

    /** 公众号 索引数据 列表 改变 SingleLiveEvent */
    val mOfficialAccountIndexDataChangeEvent = SingleLiveEvent<ListDataChangeEvent<OfficialAccountIndexEntity>>()

    /** LoadService 重新加载监听器  */
    val mReloadListener = OnReloadListener {
        if (mLoadServiceStatus == LOAD_SERVICE_LOADING) {
            return@OnReloadListener
        }
        showCallback(LOAD_SERVICE_LOADING)
        getOfficialAccountIndex()
    }

    /**
     * 初始化
     */
    override fun init() {
        super.init()
        getOfficialAccountIndex()
    }

    /**
     * 获取　公众号 索引数据
     */
    private fun getOfficialAccountIndex() {
        mRepository?.getOfficialAccountIndex(onSuccess = { officialAccountIndexList ->
            mOfficialAccountIndexList.clear()
            if (!officialAccountIndexList.isNullOrEmpty()) {
                mOfficialAccountIndexList.addAll(officialAccountIndexList)
            }
            mOfficialAccountIndexDataChangeEvent.value = ListDataChangeEvent<OfficialAccountIndexEntity>().apply {
                type = LOAD
                dataList = officialAccountIndexList
            }
            showCallback(if (mOfficialAccountIndexList.isEmpty()) LOAD_SERVICE_EMPTY else LOAD_SERVICE_SUCCESS)
        }, onFailure = {
            showCallback(LOAD_SERVICE_LOAD_FAIL)
        })
    }

}