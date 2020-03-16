package com.shijingfeng.wan_android.ui.activity

import android.util.SparseArray
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.kingja.loadsir.core.LoadSir
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_COIN_RANK
import com.shijingfeng.base.base.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.base.callback.LoadingCallback
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.adapter.CoinRankAdapter
import com.shijingfeng.wan_android.base.WanAndroidBaseActivity
import com.shijingfeng.wan_android.databinding.ActivityCoinRankBinding
import com.shijingfeng.wan_android.source.network.getCoinRankNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.getCoinRankRepositoryInstance
import com.shijingfeng.wan_android.view_model.CoinRankViewModel
import kotlinx.android.synthetic.main.activity_coin_rank.*
import kotlinx.android.synthetic.main.activity_login.include_title_bar
import kotlinx.android.synthetic.main.activity_main.view.tv_title

/**
 * Function: 积分排行榜 页面
 * Date: 2020/3/12 22:46
 * Description:
 * @author ShiJingFeng
 */
@Route(path = ACTIVITY_WAN_ANDROID_COIN_RANK)
class CoinRankActivity : WanAndroidBaseActivity<ActivityCoinRankBinding, CoinRankViewModel>() {

    private var mCoinRankAdapter: CoinRankAdapter? = null

    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.activity_coin_rank

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel(): CoinRankViewModel? {
        val coinRankRepository = getCoinRankRepositoryInstance(
            networkSource = getCoinRankNetworkSourceInstance()
        )
        val factory = createCommonViewModelFactory(
            repository = coinRankRepository
        )

        return createViewModel(CoinRankViewModel::class.java, factory)
    }

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.coinRankViewModel, mViewModel)
    }

    /**
     * 初始化数据
     */
    override fun initData() {
        super.initData()
        include_title_bar.tv_title.text = getString(R.string.积分排行榜)

        mLoadService = LoadSir.getDefault().register(srl_refresh, mViewModel?.mReloadListener)
        if (mViewModel == null || !mViewModel!!.mHasInited) {
            mLoadService?.showCallback(LoadingCallback::class.java)
        }

        mCoinRankAdapter = CoinRankAdapter(this, R.layout.adapter_item_coin_rank, mViewModel?.mCoinRankItemList)
        rv_list.layoutManager = LinearLayoutManager(this)
        rv_list.adapter = mCoinRankAdapter
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
        mCoinRankAdapter?.setOnItemEventListener { view, data, position, flag -> }
    }

    /**
     * 初始化 LiveData Observer
     */
    override fun initObserver() {
        super.initObserver()
        //上拉刷新，下拉加载 LiveData 监听器
        mViewModel?.getRefreshLoadMoreStatusEvent()?.observe(this, Observer { status: Int? ->
            when (status) {
                // 下拉刷新成功
                REFRESH_SUCCESS -> srl_refresh.finishRefresh(true)
                // 下拉刷新失败
                REFRESH_FAIL -> srl_refresh.finishRefresh(false)
                // 上拉加载成功
                LOAD_MORE_SUCCESS -> srl_refresh.finishLoadMore(true)
                // 上拉加载失败
                LOAD_MORE_FAIL -> srl_refresh.finishLoadMore(false)
                // 上拉加载 所有数据加载完毕
                LOAD_MORE_ALL -> srl_refresh.finishLoadMoreWithNoMoreData()
                else -> {
                }
            }
        })
        //RecyclerView 适配器和数据列表 LiveData 监听器
        mViewModel?.mListDataChangeEvent?.observe(this, Observer ObserverLabel@ { (type, _, _, extraData, coinRankItemList, _) ->
            when (type) {
                // 加载, 刷新
                LOAD, REFRESH -> mCoinRankAdapter?.notifyDataSetChanged()
                // 添加
                ADD -> {
                    if (coinRankItemList.isNullOrEmpty()) {
                        return@ObserverLabel
                    }

                    val oldSize = extraData as Int

                    if (oldSize <= 0) {
                        mCoinRankAdapter?.notifyDataSetChanged()
                    } else {
                        mCoinRankAdapter?.notifyItemRangeInserted(
                            oldSize,
                            coinRankItemList.size
                        )
                    }
                }
                // 插入
                INSERT -> {}
                // 删除
                REMOVE -> {}
                // 更新
                UPDATE -> {}
                else -> {}
            }
        })
    }
}