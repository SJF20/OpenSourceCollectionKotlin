package com.shijingfeng.wan_android.ui.activity

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.SparseArray
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.ClickUtils
import com.kingja.loadsir.core.LoadSir
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_COIN_RANK
import com.shijingfeng.base.base.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.adapter.CoinRankAdapter
import com.shijingfeng.wan_android.base.WanAndroidBaseActivity
import com.shijingfeng.wan_android.common.global.setThemeBackgroundTintList
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidCoinRankBinding
import com.shijingfeng.wan_android.source.local.getCoinRankLocalSourceInstance
import com.shijingfeng.wan_android.source.network.getCoinRankNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.getCoinRankRepositoryInstance
import com.shijingfeng.wan_android.utils.ThemeUtil
import com.shijingfeng.wan_android.view_model.CoinRankViewModel

/**
 * Function: 积分排行榜 页面
 * Date: 2020/3/12 22:46
 * Description:
 * @author ShiJingFeng
 */
@Route(path = ACTIVITY_WAN_ANDROID_COIN_RANK)
internal class CoinRankActivity : WanAndroidBaseActivity<ActivityWanAndroidCoinRankBinding, CoinRankViewModel>() {

    private var mCoinRankAdapter: CoinRankAdapter? = null

    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.activity_wan_android_coin_rank

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel(): CoinRankViewModel? {
        val coinRankRepository = getCoinRankRepositoryInstance(
            localSource = getCoinRankLocalSourceInstance(),
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
        mDataBinding.includeTitleBar.tvTitle.text = getStringById(R.string.积分排行榜)

        mSmartRefreshLayout = mDataBinding.srlRefresh
        // 当内容不满一页是否可以上拉加载  true: 可以  false: 不可以
        mSmartRefreshLayout?.setEnableLoadMoreWhenContentNotFull(true)
        mLoadService = LoadSir.getDefault().register(mDataBinding.srlRefresh, mViewModel?.mReloadListener)
        if (mViewModel == null || !mViewModel!!.mHasInited) {
            showCallback(LOAD_SERVICE_LOADING)
        }

        mCoinRankAdapter = CoinRankAdapter(this, mViewModel?.mCoinRankItemList)
        mDataBinding.rvList.layoutManager = LinearLayoutManager(this)
        mDataBinding.rvList.adapter = mCoinRankAdapter

        setThemeBackgroundTintList(mDataBinding.fabToTop)
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
        // RecyclerView滑动监听
        mDataBinding.rvList.addOnScrollListener(object : RecyclerView.OnScrollListener() {

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
        ClickUtils.applySingleDebouncing(mDataBinding.fabToTop) {
            scrollToTop()
        }
        mCoinRankAdapter?.setOnItemEventListener { _, _, _, _ -> }
    }

    /**
     * 初始化 LiveData Observer
     */
    override fun initObserver() {
        super.initObserver()
        //RecyclerView 适配器和数据列表 LiveData 监听器
        mViewModel?.mListDataChangeEvent?.observe(this, Observer ObserverLabel@{ (type, _, _, extraData, coinRankItemList, _) ->
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

    /**
     * 设置 置顶按钮 的可见性
     * @param visibility 可见性
     */
    private fun setToTopButtonVisibility(visibility: Int) {
        if (mDataBinding.fabToTop.tag == null) {
            mDataBinding.fabToTop.tag = View.VISIBLE
        }
        if (visibility == View.VISIBLE) {
            //设置为可见
            if (mDataBinding.fabToTop.tag as Int != View.VISIBLE) {
                mDataBinding.fabToTop.tag = View.VISIBLE
                mDataBinding.fabToTop
                    .animate()
                    .setListener(object : AnimatorListenerAdapter() {

                        override fun onAnimationStart(animation: Animator) {
                            super.onAnimationStart(animation)
                            mDataBinding.fabToTop.isEnabled = false
                        }

                        override fun onAnimationEnd(animation: Animator) {
                            super.onAnimationEnd(animation)
                            mDataBinding.fabToTop.isEnabled = true
                        }

                    })
                    .setDuration(400)
                    .scaleX(1.0f)
                    .scaleY(1.0f)
            }
        } else if (visibility == View.GONE) {
            //设置为不可见
            if (mDataBinding.fabToTop.tag as Int != View.GONE) {
                mDataBinding.fabToTop.tag = View.GONE
                mDataBinding.fabToTop
                    .animate()
                    .setListener(object : AnimatorListenerAdapter() {

                        override fun onAnimationStart(animation: Animator) {
                            super.onAnimationStart(animation)
                            mDataBinding.fabToTop.isEnabled = false
                        }

                        override fun onAnimationEnd(animation: Animator) {
                            super.onAnimationEnd(animation)
                            mDataBinding.fabToTop.isEnabled = false
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
            if (mCoinRankItemList.isNotEmpty()) {
                mDataBinding.rvList.smoothScrollToPosition(0)
            }
        }
    }

}