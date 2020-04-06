package com.shijingfeng.wan_android.view_model

import com.blankj.utilcode.util.ToastUtils
import com.kingja.loadsir.callback.Callback.OnReloadListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent
import com.shijingfeng.base.livedata.SingleLiveEvent
import com.shijingfeng.base.util.getPositionById
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
import com.shijingfeng.wan_android.entity.event.WebsiteCollectionEvent
import com.shijingfeng.wan_android.entity.network.PersonalCollectionWebsiteEntity
import com.shijingfeng.wan_android.source.repository.PersonalCollectionWebsiteRepository
import com.shijingfeng.wan_android.ui.fragment.PersonalCollectionWebsiteFragment
import org.greenrobot.eventbus.EventBus
import java.util.ArrayList

/**
 * Function: 我的收藏 -> 网站收藏 ViewModel
 * Date: 2020/3/25 23:28
 * Description:
 * @author ShiJingFeng
 */
internal class PersonalCollectionWebsiteViewModel(
    repository: PersonalCollectionWebsiteRepository? = null
) : WanAndroidBaseViewModel<PersonalCollectionWebsiteRepository>(repository) {

    /** 数据操作类型  */
    private var mDataOperateType = DATA_OPERATE_TYPE_LOAD
    /** 网站收藏列表 数据列表 */
    val mWebsiteCollectedListItemList = ArrayList<PersonalCollectionWebsiteEntity>()

    /** 列表数据改变 LiveData Event  */
    val mListDataChangeEvent = SingleLiveEvent<ListDataChangeEvent<PersonalCollectionWebsiteEntity>>()

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
        mDataOperateType = DATA_OPERATE_TYPE_LOAD
        getWebsiteCollectedList()
    }

    /**
     * 下拉刷新
     */
    fun refresh() {
        mDataOperateType = DATA_OPERATE_TYPE_REFRESH
        getWebsiteCollectedList()
    }

    /**
     * 获取 网站收藏列表 数据
     */
    private fun getWebsiteCollectedList() {
        mRepository?.getWebsiteCollectedList(onSuccess = { personalCollectionWebsiteList ->
            val event =
                ListDataChangeEvent<PersonalCollectionWebsiteEntity>()

            when (mDataOperateType) {
                // 加载数据 或 重新加载
                DATA_OPERATE_TYPE_LOAD -> {
                    mWebsiteCollectedListItemList.clear()
                    if (!personalCollectionWebsiteList.isNullOrEmpty()) {
                        mWebsiteCollectedListItemList.addAll(personalCollectionWebsiteList)
                    }

                    event.type = LOAD
                    event.dataList = personalCollectionWebsiteList

                    mListDataChangeEvent.value = event
                    showCallback(if (mWebsiteCollectedListItemList.isEmpty()) LOAD_SERVICE_EMPTY else LOAD_SERVICE_SUCCESS)
                }
                // 下拉刷新
                DATA_OPERATE_TYPE_REFRESH -> {
                    mWebsiteCollectedListItemList.clear()
                    if (!personalCollectionWebsiteList.isNullOrEmpty()) {
                        mWebsiteCollectedListItemList.addAll(personalCollectionWebsiteList)
                    }

                    event.type = REFRESH
                    event.dataList = personalCollectionWebsiteList

                    mListDataChangeEvent.value = event
                    updateRefreshLoadMoreStatus(REFRESH_SUCCESS)
                    // 数据为空
                    if (mWebsiteCollectedListItemList.isEmpty()) {
                        showCallback(LOAD_SERVICE_EMPTY)
                    }
                }
                else -> {}
            }
        }, onFailure = {
            when (mDataOperateType) {
                // 加载数据 或 重新加载
                DATA_OPERATE_TYPE_LOAD -> showCallback(LOAD_SERVICE_LOAD_FAIL)
                // 下拉刷新
                DATA_OPERATE_TYPE_REFRESH -> updateRefreshLoadMoreStatus(REFRESH_FAIL)
                else -> {}
            }
        })
    }

    /**
     * 编辑
     * @param dataMap 请求携带的数据 (id, name, link)
     */
    fun updateWebsite(dataMap: Map<String, Any>) {
        showLoadingDialog(getStringById(R.string.提交中))
        mRepository?.updateWebsite(dataMap, onSuccess = {
            // TODO 编辑未完成
        })
    }

    /**
     * 取消收藏
     * @param websiteId 网站ID
     */
    fun uncollected(websiteId: String) {
        mRepository?.uncollectedWebsite(websiteId, onSuccess = {
            val position = getPositionById(websiteId, mWebsiteCollectedListItemList)

            if (position != -1) {
                val event =
                    ListDataChangeEvent<PersonalCollectionWebsiteEntity>()
                val indexList = listOf(position)

                event.type = REMOVE
                event.indexList = indexList
                event.extraData = mWebsiteCollectedListItemList.size

                mWebsiteCollectedListItemList.removeAt(position)
                mListDataChangeEvent.value = event

                if (mWebsiteCollectedListItemList.size <= 0) {
                    //数据为空
                    showCallback(LOAD_SERVICE_EMPTY)
                }
                // 取消某一网站收藏
                EventBus.getDefault().post(
                    WebsiteCollectionEvent(
                        fromName = PersonalCollectionWebsiteFragment::class.java.name,
                        type = REMOVE,
                        id = websiteId
                    )
                )
            } else {
                ToastUtils.showShort("已经取消收藏")
            }
        })
    }

}