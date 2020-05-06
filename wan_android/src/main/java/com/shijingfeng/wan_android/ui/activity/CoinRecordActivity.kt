package com.shijingfeng.wan_android.ui.activity

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.util.SparseArray
import android.view.View
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.ClickUtils
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
import com.shijingfeng.wan_android.utils.CoinUtil
import com.shijingfeng.wan_android.view_model.CoinRecordViewModel
import kotlinx.android.synthetic.main.activity_wan_android_coin_record.*
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
        // 当内容不满一页是否可以上拉加载  true: 可以  false: 不可以
        mSmartRefreshLayout?.setEnableLoadMoreWhenContentNotFull(true)
        mLoadService = LoadSir.getDefault().register(srl_refresh, mViewModel?.mReloadListener)
        if (mViewModel == null || !mViewModel!!.mHasInited) {
            showCallback(LOAD_SERVICE_LOADING)
        }

        // 设置个人积分数量
        CoinUtil.coinInfo?.let { coinInfo ->
            tv_coin_quantity.text = coinInfo.coinCount.toString()
        }

        mCoinRecordAdapter = CoinRecordAdapter(
            this,
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
        // RecyclerView滑动监听
        rv_content.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1)) {
                    //滑倒最底部，隐藏
                    setToTopButtonVisibility(View.GONE)
                    return
                }
                if (!recyclerView.canScrollVertically(-1)) {
                    //滑倒顶部，显示
                    setToTopButtonVisibility(View.VISIBLE)
                    return
                }
                setToTopButtonVisibility(if (dy > 0) View.GONE else View.VISIBLE)
            }

        })
        // 置顶
        ClickUtils.applySingleDebouncing(fab_to_top) {
            scrollToTop()
        }
        mCoinRecordAdapter?.setOnItemEventListener { _: View?, _: Any?, _: Int, _: String? -> }
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

    /**
     * 设置 置顶按钮 的可见性
     * @param visibility 可见性
     */
    private fun setToTopButtonVisibility(visibility: Int) {
        if (fab_to_top.tag == null) {
            fab_to_top.tag = View.VISIBLE
        }
        if (visibility == View.VISIBLE) {
            //设置为可见
            if (fab_to_top.tag as Int != View.VISIBLE) {
                fab_to_top.tag = View.VISIBLE
                fab_to_top
                    .animate()
                    .setListener(object : AnimatorListenerAdapter() {

                        override fun onAnimationStart(animation: Animator) {
                            super.onAnimationStart(animation)
                            fab_to_top.isEnabled = false
                        }

                        override fun onAnimationEnd(animation: Animator) {
                            super.onAnimationEnd(animation)
                            fab_to_top.isEnabled = true
                        }

                    })
                    .setDuration(400)
                    .scaleX(1.0f)
                    .scaleY(1.0f)
            }
        } else if (visibility == View.GONE) {
            //设置为不可见
            if (fab_to_top.tag as Int != View.GONE) {
                fab_to_top.tag = View.GONE
                fab_to_top
                    .animate()
                    .setListener(object : AnimatorListenerAdapter() {

                        override fun onAnimationStart(animation: Animator) {
                            super.onAnimationStart(animation)
                            fab_to_top.isEnabled = false
                        }

                        override fun onAnimationEnd(animation: Animator) {
                            super.onAnimationEnd(animation)
                            fab_to_top.isEnabled = false
                        }

                    })
                    .setDuration(400)
                    .scaleX(0f)
                    .scaleY(0f)
            }
        }
    }

    /**
     * 滑动到顶部
     */
    private fun scrollToTop() {
        mViewModel?.run {
            if (mCoinRecordItemList.isNotEmpty()) {
                rv_content.smoothScrollToPosition(0)
            }
        }
    }

}