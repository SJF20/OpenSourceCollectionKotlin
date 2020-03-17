package com.shijingfeng.wan_android.view_model

import android.os.Bundle
import android.view.View
import com.kingja.loadsir.callback.Callback.OnReloadListener
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_WEB_VIEW
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.entity.event.ListDataChangeEvent
import com.shijingfeng.base.livedata.SingleLiveEvent
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
import com.shijingfeng.wan_android.entity.network.CoinRecordItem
import com.shijingfeng.wan_android.source.repository.CoinRecordRepository

/**
 * Function: 积分记录 ViewModel
 * Date: 2020/3/16 21:51
 * Description:
 * @author ShiJingFeng
 */
class CoinRecordViewModel(
    repository: CoinRecordRepository? = null
) : WanAndroidBaseViewModel<CoinRecordRepository>(
    repository = repository
) {
    /** 当前页码  */
    private var mPage = 1

    /** 数据操作类型  */
    private var mDataOperateType: Int = DATA_OPERATE_TYPE_LOAD

    /** 积分记录 数据列表  */
    var mCoinRecordItemList = arrayListOf<CoinRecordItem>()

    /** 列表数据改变 LiveData Event  */
    var mListDataChangeEvent = SingleLiveEvent<ListDataChangeEvent<CoinRecordItem>>()

    /** 返回 */
    val mBackClickListener = View.OnClickListener { finish() }

    /** 查看规则 */
    val mTextOperateClickListener = View.OnClickListener {
        val url = BASE_URL_VALUE_WAN_ANDROID.toString() + "blog/show/2653"
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
    var mReloadListener = OnReloadListener {
        mDataOperateType = DATA_OPERATE_TYPE_LOAD
        getLoadServiceStatusEvent().value = LOADING
        getCoinRecordList(1)
    }

    /** 下拉刷新  */
    var mOnRefreshListener = OnRefreshListener {
        mDataOperateType = DATA_OPERATE_TYPE_REFRESH
        //下拉刷新 期间禁止 上拉加载
        getCoinRecordList(1)
    }

    /** 上拉加载  */
    var mOnLoadMoreListener = OnLoadMoreListener {
        mDataOperateType = DATA_OPERATE_TYPE_LOAD_MORE
        getCoinRecordList(mPage + 1)
    }

    /**
     * 初始化
     */
    override fun init() {
        super.init()
        mDataOperateType = DATA_OPERATE_TYPE_LOAD
        getCoinRecordList(1)
    }

    /**
     * 获取积分记录列表
     * @param page 页码 (从1开始)
     */
    private fun getCoinRecordList(page: Int) {
        mRepository?.getCoinRecordList(page, onSuccess = onSuccessLabel@{ coinRecord ->
            val coinRecordItemList = coinRecord?.coinRecordItemList
            val event = ListDataChangeEvent<CoinRecordItem>()

            when (mDataOperateType) {
                // 加载数据 或 重新加载
                DATA_OPERATE_TYPE_LOAD -> {
                    mPage = 1
                    mCoinRecordItemList.clear()
                    if (!coinRecordItemList.isNullOrEmpty()) {
                        mCoinRecordItemList.addAll(coinRecordItemList)
                    }

                    event.type = LOAD
                    event.dataList = coinRecordItemList

                    mListDataChangeEvent.value = event
                    getLoadServiceStatusEvent().value = if (mCoinRecordItemList.isEmpty()) EMPTY else SUCCESS
                }
                // 下拉刷新
                DATA_OPERATE_TYPE_REFRESH -> {
                    mPage = 1
                    mCoinRecordItemList.clear()
                    if (!coinRecordItemList.isNullOrEmpty()) {
                        mCoinRecordItemList.addAll(coinRecordItemList)
                    }

                    event.type = REFRESH
                    event.dataList = coinRecordItemList

                    mListDataChangeEvent.value = event
                    getRefreshLoadMoreStatusEvent().value = REFRESH_SUCCESS
                    // 数据为空
                    if (mCoinRecordItemList.isEmpty()) {
                        getLoadServiceStatusEvent().value = EMPTY
                    }
                }
                // 上拉加载
                DATA_OPERATE_TYPE_LOAD_MORE -> {
                    if (coinRecordItemList.isNullOrEmpty()) {
                        getRefreshLoadMoreStatusEvent().value = LOAD_MORE_ALL
                        return@onSuccessLabel
                    }
                    ++mPage

                    event.type = ADD
                    event.dataList = coinRecordItemList
                    event.extraData = mCoinRecordItemList.size

                    //添加数据
                    mCoinRecordItemList.addAll(coinRecordItemList)
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

}