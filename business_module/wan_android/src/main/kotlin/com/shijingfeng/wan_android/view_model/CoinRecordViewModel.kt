package com.shijingfeng.wan_android.view_model

import android.os.Bundle
import android.view.View
import com.kingja.loadsir.callback.Callback.OnReloadListener
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import com.shijingfeng.base.annotation.define.PageOperateType
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_WEB_VIEW
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent
import com.shijingfeng.base.mvvm.livedata.SingleLiveEvent
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.network.constant.BASE_URL_VALUE_WAN_ANDROID
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
import com.shijingfeng.wan_android.entity.CoinRecordItem
import com.shijingfeng.wan_android.source.network.getCoinRecordNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.CoinRecordRepository
import com.shijingfeng.wan_android.source.repository.getCoinRecordRepositoryInstance

/** 第一页 页码  */
const val COIN_RECORD_FIRST_PAGE = 1

/**
 * Function: 积分记录 ViewModel
 * Date: 2020/3/16 21:51
 * Description:
 * Author: ShiJingFeng
 */
internal class CoinRecordViewModel : WanAndroidBaseViewModel<CoinRecordRepository>() {

    /** 当前页码  */
    private var mPage = COIN_RECORD_FIRST_PAGE

    /** 页面操作类型  */
    @PageOperateType
    private var mPageOperateType = PAGE_OPERATE_TYPE_LOAD

    /** 积分记录 数据列表  */
    var mCoinRecordItemList = mutableListOf<CoinRecordItem>()

    /** 列表数据改变 LiveData Event  */
    var mListDataChangeEvent = SingleLiveEvent<ListDataChangeEvent<CoinRecordItem>>()

    /** 返回 */
    val mBackClickListener = View.OnClickListener { finish() }

    /** 查看规则 */
    val mTextOperateClickListener = View.OnClickListener {
        val url = BASE_URL_VALUE_WAN_ANDROID + "blog/show/2653"
        val title = getStringById(R.string.积分规则)

        navigation(
            path = ACTIVITY_WAN_ANDROID_WEB_VIEW,
            bundle = Bundle().apply {
                putString(URL, url)
                putString(TITLE, title)
            }
        )
    }

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
     * 获取 Repository
     * @return Repository
     */
    override fun getRepository() = getCoinRecordRepositoryInstance(
        networkSource = getCoinRecordNetworkSourceInstance()
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
        getCoinRecordList(COIN_RECORD_FIRST_PAGE)
    }

    /**
     * 下拉刷新
     */
    private fun refresh() {
        mPageOperateType = PAGE_OPERATE_TYPE_REFRESH
        //下拉刷新 期间禁止 上拉加载
        getCoinRecordList(COIN_RECORD_FIRST_PAGE)
    }

    /**
     * 上拉加载
     */
    private fun loadMore() {
        mPageOperateType = PAGE_OPERATE_TYPE_LOAD_MORE
        getCoinRecordList(mPage + 1)
    }

    /**
     * 获取积分记录列表
     * @param page 页码 (从 [COIN_RECORD_FIRST_PAGE] 开始)
     */
    private fun getCoinRecordList(page: Int) {
        mRepository?.getCoinRecordList(page, onSuccess = onSuccessLabel@{ coinRecord ->
            val coinRecordItemList = coinRecord?.coinRecordItemList
            val event = ListDataChangeEvent<CoinRecordItem>()

            when (mPageOperateType) {
                // 加载数据 或 重新加载
                PAGE_OPERATE_TYPE_LOAD -> {
                    mPage = COIN_RECORD_FIRST_PAGE
                    mCoinRecordItemList.clear()
                    if (!coinRecordItemList.isNullOrEmpty()) {
                        mCoinRecordItemList.addAll(coinRecordItemList)
                    }

                    event.type = LOAD
                    event.dataList = coinRecordItemList

                    mListDataChangeEvent.value = event
                    showCallback(if (mCoinRecordItemList.isEmpty()) LOAD_SERVICE_EMPTY else LOAD_SERVICE_SUCCESS)
                }
                // 下拉刷新
                PAGE_OPERATE_TYPE_REFRESH -> {
                    mPage = COIN_RECORD_FIRST_PAGE
                    mCoinRecordItemList.clear()
                    if (!coinRecordItemList.isNullOrEmpty()) {
                        mCoinRecordItemList.addAll(coinRecordItemList)
                    }

                    event.type = REFRESH
                    event.dataList = coinRecordItemList

                    mListDataChangeEvent.value = event
                    updateRefreshLoadMoreStatus(REFRESH_SUCCESS)
                    // 数据为空
                    if (mCoinRecordItemList.isEmpty()) {
                        showCallback(LOAD_SERVICE_EMPTY)
                    }
                }
                // 上拉加载
                PAGE_OPERATE_TYPE_LOAD_MORE -> {
                    if (coinRecordItemList.isNullOrEmpty()) {
                        updateRefreshLoadMoreStatus(LOAD_MORE_ALL)
                        return@onSuccessLabel
                    }
                    ++mPage

                    event.type = ADD
                    event.dataList = coinRecordItemList
                    event.extraData = mCoinRecordItemList.size

                    //添加数据
                    mCoinRecordItemList.addAll(coinRecordItemList)
                    mListDataChangeEvent.value = event
                    updateRefreshLoadMoreStatus(LOAD_MORE_SUCCESS)
                }
                else -> {}
            }
        }, onFailure = {
            when (mPageOperateType) {
                // 加载数据
                PAGE_OPERATE_TYPE_LOAD -> showCallback(LOAD_SERVICE_LOAD_FAIL)
                // 下拉刷新
                PAGE_OPERATE_TYPE_REFRESH -> updateRefreshLoadMoreStatus(REFRESH_FAIL)
                // 上拉加载
                PAGE_OPERATE_TYPE_LOAD_MORE -> updateRefreshLoadMoreStatus(LOAD_MORE_FAIL)
                else -> {}
            }
        })
    }

}