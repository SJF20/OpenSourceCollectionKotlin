package com.shijingfeng.wan_android.view_model

import android.view.View
import com.kingja.loadsir.callback.Callback.OnReloadListener
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent
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
internal class CoinRankViewModel(
    repository: CoinRankRepository? = null
) : WanAndroidBaseViewModel<CoinRankRepository>(
    repository
) {

    /** 第一页 页码  */
    private val FIRST_PAGE = 1

    /** 当前页码  */
    private var mPage = FIRST_PAGE
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
        if (mLoadServiceStatus == LOAD_SERVICE_LOADING) {
            return@OnReloadListener
        }
        showCallback(LOAD_SERVICE_LOADING)
        load()
    }
    /** 下拉刷新 */
    val mOnRefreshListener = OnRefreshListener { refresh() }
    /** 上拉加载 */
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
        mDataOperateType = DATA_OPERATE_TYPE_LOAD
        getCoinRankList(FIRST_PAGE)
    }

    /**
     * 下拉刷新
     */
    private fun refresh() {
        mDataOperateType = DATA_OPERATE_TYPE_REFRESH
        getCoinRankList(FIRST_PAGE)
    }

    /**
     * 上拉加载
     */
    private fun loadMore() {
        mDataOperateType = DATA_OPERATE_TYPE_LOAD_MORE
        getCoinRankList(mPage + 1)
    }

    /**
     * 获取 积分排行榜 列表
     * @param page 页码 (从 [FIRST_PAGE] 开始)
     */
    private fun getCoinRankList(page: Int) {
        mRepository?.getCoinRankList(page, onSuccess = onSuccessLabel@{ coinRank ->
            val coinRankItemList = coinRank?.coinRankItemList
            val event =
                ListDataChangeEvent<CoinRankItem>()

            when (mDataOperateType) {
                // 加载数据
                DATA_OPERATE_TYPE_LOAD -> {
                    mPage = FIRST_PAGE
                    mCoinRankItemList.clear()
                    if (!coinRankItemList.isNullOrEmpty()) {
                        mCoinRankItemList.addAll(coinRankItemList)
                    }

                    event.type = LOAD
                    event.dataList = coinRankItemList

                    mListDataChangeEvent.value = event
                    showCallback(if (mCoinRankItemList.isEmpty()) LOAD_SERVICE_EMPTY else LOAD_SERVICE_SUCCESS)
                }
                // 下拉刷新
                DATA_OPERATE_TYPE_REFRESH -> {
                    mPage = FIRST_PAGE
                    mCoinRankItemList.clear()
                    if (!coinRankItemList.isNullOrEmpty()) {
                        mCoinRankItemList.addAll(coinRankItemList)
                    }

                    event.type = REFRESH
                    event.dataList = coinRankItemList

                    mListDataChangeEvent.value = event
                    updateRefreshLoadMoreStatus(REFRESH_SUCCESS)
                    // 数据为空
                    if (mCoinRankItemList.isEmpty()) {
                        showCallback(LOAD_SERVICE_EMPTY)
                    }
                }
                // 上拉加载
                DATA_OPERATE_TYPE_LOAD_MORE -> {
                    if (coinRankItemList.isNullOrEmpty()) {
                        updateRefreshLoadMoreStatus(LOAD_MORE_ALL)
                        return@onSuccessLabel
                    }
                    ++mPage

                    event.type = ADD
                    event.dataList = coinRankItemList
                    event.extraData = mCoinRankItemList.size

                    mCoinRankItemList.addAll(coinRankItemList)
                    mListDataChangeEvent.value = event
                    updateRefreshLoadMoreStatus(LOAD_MORE_SUCCESS)
                }
                else -> {}
            }
        }, onFailure = {
            when (mDataOperateType) {
                // 加载数据
                DATA_OPERATE_TYPE_LOAD -> showCallback(LOAD_SERVICE_LOAD_FAIL)
                // 下拉刷新
                DATA_OPERATE_TYPE_REFRESH -> updateRefreshLoadMoreStatus(REFRESH_FAIL)
                // 上拉加载
                DATA_OPERATE_TYPE_LOAD_MORE -> updateRefreshLoadMoreStatus(LOAD_MORE_FAIL)
                else -> {}
            }
        })
    }

}