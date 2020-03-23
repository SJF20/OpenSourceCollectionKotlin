package com.shijingfeng.wan_android.ui.activity

import android.util.SparseArray
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.kingja.loadsir.core.LoadSir
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_COIN_RECORD
import com.shijingfeng.base.base.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.adapter.CoinRecordAdapter
import com.shijingfeng.wan_android.base.WanAndroidBaseActivity
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidCoinRecordBinding
import com.shijingfeng.wan_android.source.network.getCoinRecordNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.getCoinRecordRepositoryInstance
import com.shijingfeng.wan_android.utils.CoinUtil.getCoinInfo
import com.shijingfeng.wan_android.view_model.CoinRecordViewModel
import kotlinx.android.synthetic.main.activity_wan_android_coin_record.*
import kotlinx.android.synthetic.main.activity_wan_android_coin_record.srl_refresh
import kotlinx.android.synthetic.main.activity_wan_android_web_view.include_title_bar
import kotlinx.android.synthetic.main.layout_wan_android_title_bar.view.*

/**
 * Function: 积分记录 Activity
 * Date: 2020/3/16 21:54
 * Description:
 * @author ShiJingFeng
 */
@Route(path = ACTIVITY_WAN_ANDROID_COIN_RECORD)
internal class CoinRecordActivity : WanAndroidBaseActivity<ActivityWanAndroidCoinRecordBinding, CoinRecordViewModel>() {

    /** 积分记录列表适配器  */
    private var mCoinRecordAdapter: CoinRecordAdapter? = null

    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.activity_wan_android_coin_record

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel(): CoinRecordViewModel? {
        val coinRecordRepository = getCoinRecordRepositoryInstance(
            networkSource = getCoinRecordNetworkSourceInstance()
        )
        val factory = createCommonViewModelFactory(
            repository = coinRecordRepository
        )

        return createViewModel(CoinRecordViewModel::class.java, factory)
    }

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.coinRecordViewModel, mViewModel)
    }

    /**
     * 初始化数据
     */
    override fun initData() {
        super.initData()
        include_title_bar.tv_title.text = getStringById(R.string.积分记录)
        include_title_bar.iv_operate.setImageResource(R.drawable.ic_question)
        include_title_bar.iv_operate.visibility = VISIBLE

        mSmartRefreshLayout = srl_refresh
        mSmartRefreshLayout?.setEnableLoadMoreWhenContentNotFull(false)
        mLoadService = LoadSir.getDefault().register(srl_refresh, mViewModel?.mReloadListener)
        if (mViewModel == null || !mViewModel!!.mHasInited) {
            showCallback(LOADING)
        }

        // 设置个人积分数量
        getCoinInfo()?.let { coinInfo ->
            tv_coin_quantity.text = coinInfo.coinCount.toString()
        }

        mCoinRecordAdapter = CoinRecordAdapter(
            this,
            R.layout.adapter_wan_android_item_coin_record,
            mViewModel?.mCoinRecordItemList
        )
        rv_content.layoutManager = LinearLayoutManager(this)
        rv_content.adapter = mCoinRecordAdapter
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
//        mCoinRecordAdapter!!.setOnItemEventListener { view: View?, data: Any?, position: Int, flag: String? -> }
    }

    /**
     * 初始化 LiveData Observer
     */
    override fun initObserver() {
        super.initObserver()
        //RecyclerView 适配器和数据列表 LiveData 监听器
        mViewModel?.mListDataChangeEvent?.observe(this, Observer ObserverLabel@ { (type, _, _, extraData, coinRecordItemList, _) ->
            when (type) {
                // 加载, 刷新
                LOAD, REFRESH -> mCoinRecordAdapter?.notifyDataSetChanged()
                // 添加
                ADD -> {
                    if (coinRecordItemList.isNullOrEmpty()) {
                        return@ObserverLabel
                    }

                    val oldSize = extraData as Int

                    if (oldSize <= 0) {
                        mCoinRecordAdapter?.notifyDataSetChanged()
                    } else {
                        mCoinRecordAdapter?.notifyItemRangeInserted(
                            oldSize,
                            coinRecordItemList.size
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