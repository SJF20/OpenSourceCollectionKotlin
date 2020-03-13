package com.shijingfeng.wan_android.viewmodel

import android.view.View
import com.kingja.loadsir.callback.Callback.OnReloadListener
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.entity.event.ListDataChangeEvent
import com.shijingfeng.base.livedata.SingleLiveEvent
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
import com.shijingfeng.wan_android.entity.network.CoinRankItem
import com.shijingfeng.wan_android.source.repository.CoinRankRepository
import java.util.*

/**
 * Function: 积分排行榜 ViewModel
 * Date: 2020/3/12 22:43
 * Description:
 * @author ShiJingFeng
 */
class CoinRankViewModel(
    repository: CoinRankRepository? = null
) : WanAndroidBaseViewModel<CoinRankRepository>(
    repository
) {

    /** 当前页码  */
    private var mPage = 1
    /** 数据操作类型  */
    private var mDataOperateType = DATA_OPERATE_TYPE_LOAD
    /** 积分排行榜 数据列表  */
    var mCoinRankItemList = ArrayList<CoinRankItem>()

    /** 列表数据改变 LiveData Event  */
    var mListDataChangeEvent = SingleLiveEvent<ListDataChangeEvent<CoinRankItem>>()

    /** 返回  */
    val mBackClickListener = View.OnClickListener { finish() }
    /** LoadService 重新加载监听器  */
    val mReloadListener = OnReloadListener {
        mDataOperateType = DATA_OPERATE_TYPE_LOAD
        getLoadServiceStatusEvent().setValue(LOADING)
        getCoinRankList(1)
    }
    /** 下拉刷新 */
    val mOnRefreshListener = OnRefreshListener {
        mDataOperateType = DATA_OPERATE_TYPE_REFRESH
        getCoinRankList(1)
    }
    /** 上拉加载 */
    val mOnLoadMoreListener = OnLoadMoreListener {
        mDataOperateType = DATA_OPERATE_TYPE_LOAD_MORE
        getCoinRankList(mPage + 1)
    }

    /**
     * 初始化
     */
    override fun init() {
        super.init()
        mDataOperateType = DATA_OPERATE_TYPE_LOAD
        getCoinRankList(1)
    }

    /**
     * 获取 积分排行榜 列表
     */
    private fun getCoinRankList(page: Int) {
        mRepository?.getCoinRankList(page, onSuccess = onSuccessLabel@ { coinRank ->
            val coinRankItemList = coinRank?.coinRankItemList
            val event = ListDataChangeEvent<CoinRankItem>()

            when (mDataOperateType) {
                // 加载数据
                DATA_OPERATE_TYPE_LOAD -> {
                    mPage = 1
                    mCoinRankItemList.clear()
                    if (!coinRankItemList.isNullOrEmpty()) {
                        mCoinRankItemList.addAll(coinRankItemList)
                    }

                    event.type = LOAD
                    event.dataList = coinRankItemList

                    mListDataChangeEvent.value = event
                    getLoadServiceStatusEvent().value = if (mCoinRankItemList.isEmpty()) EMPTY else SUCCESS
                }
                // 下拉刷新
                DATA_OPERATE_TYPE_REFRESH -> {
                    mPage = 1
                    mCoinRankItemList.clear()
                    if (!coinRankItemList.isNullOrEmpty()) {
                        mCoinRankItemList.addAll(coinRankItemList)
                    }

                    event.type = REFRESH
                    event.dataList = coinRankItemList

                    mListDataChangeEvent.value = event
                    getRefreshLoadMoreStatusEvent().value = REFRESH_SUCCESS
                    if (mCoinRankItemList.isEmpty()) {
                        getLoadServiceStatusEvent().value = EMPTY
                    }                }
                // 上拉加载
                DATA_OPERATE_TYPE_LOAD_MORE -> {
                    if (coinRankItemList.isNullOrEmpty()) {
                        getRefreshLoadMoreStatusEvent().value = LOAD_MORE_ALL
                        return@onSuccessLabel
                    }
                    ++mPage

                    event.type = ADD
                    event.dataList = coinRankItemList
                    event.extraData = mCoinRankItemList.size

                    mCoinRankItemList.addAll(coinRankItemList)
                    mListDataChangeEvent.value = event
                    getRefreshLoadMoreStatusEvent().value = LOAD_MORE_SUCCESS
                }
                else -> {}
            }
        }, onFailure = {
            when (mDataOperateType) {
                // 加载数据
                DATA_OPERATE_TYPE_LOAD -> getLoadServiceStatusEvent().setValue(LOAD_FAIL)
                // 下拉刷新
                DATA_OPERATE_TYPE_REFRESH -> getRefreshLoadMoreStatusEvent().setValue(REFRESH_FAIL)
                // 上拉加载
                DATA_OPERATE_TYPE_LOAD_MORE -> getRefreshLoadMoreStatusEvent().setValue(LOAD_MORE_FAIL)
                else -> {}
            }
        })
    }

}