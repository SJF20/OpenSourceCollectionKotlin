package com.shijingfeng.wan_android.ui.fragment

import android.os.Bundle
import android.util.SparseArray
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.kingja.loadsir.core.LoadSir
import com.shijingfeng.base.arouter.FRAGMENT_WAN_ANDROID_KNOWLEDGE_CLASSIFY
import com.shijingfeng.base.base.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseFragment
import com.shijingfeng.wan_android.constant.TAB_LAYOUT_VISIBILITY
import androidx.lifecycle.Observer
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_WEB_VIEW
import com.shijingfeng.base.arouter.navigation
import com.shijingfeng.wan_android.adapter.NavigationClassifyAdapter
import com.shijingfeng.wan_android.constant.VIEW_NAVIGATION_CLASSIFY_DETAIL
import com.shijingfeng.wan_android.databinding.FragmentWanAndroidNavigationClassifyBinding
import com.shijingfeng.wan_android.entity.network.NavigationClassifyArticle
import com.shijingfeng.wan_android.source.network.getNavigationClassifyNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.getNavigationClassifyRepositoryInstance
import com.shijingfeng.wan_android.view_model.NavigationClassifyViewModel

/**
 * 创建 NavigationClassifyFragment 实例
 */
internal fun createNavigationClassifyFragment() = NavigationClassifyFragment()

/**
 * Function: 导航分类 Fragment
 * Date: 2020/4/21 20:28
 * Description:
 * @author ShiJingFeng
 */
@Route(path = FRAGMENT_WAN_ANDROID_KNOWLEDGE_CLASSIFY)
internal class NavigationClassifyFragment : WanAndroidBaseFragment<FragmentWanAndroidNavigationClassifyBinding, NavigationClassifyViewModel>() {

    private var mNavigationClassifyAdapter: NavigationClassifyAdapter? = null

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel(): NavigationClassifyViewModel? {
        val navigationClassifyRepository = getNavigationClassifyRepositoryInstance(
            networkSource = getNavigationClassifyNetworkSourceInstance()
        )
        val factory = createCommonViewModelFactory(
            repository = navigationClassifyRepository
        )

        return createViewModel(NavigationClassifyViewModel::class.java, factory)
    }

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.navigationClassifyViewModel, mViewModel)
    }

    /**
     * 获取视图ID
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.fragment_wan_android_navigation_classify

    /**
     * 初始化数据
     */
    override fun initData() {
        super.initData()
        mSmartRefreshLayout = mDataBinding.srlRefresh
        // 当内容不满一页是否可以上拉加载  true: 可以  false: 不可以
        mSmartRefreshLayout?.setEnableLoadMoreWhenContentNotFull(true)
        mLoadService = LoadSir.getDefault().register(mDataBinding.srlRefresh, mViewModel?.mReloadListener)
        if (mViewModel == null || !mViewModel!!.mHasInited) {
            showCallback(LOAD_SERVICE_LOADING)
        }

        context?.run {
            mNavigationClassifyAdapter = NavigationClassifyAdapter(
                this,
                mViewModel?.mNavigationClassifyList
            )
            mDataBinding.rvContent.layoutManager = LinearLayoutManager(this)
            mDataBinding.rvContent.adapter = mNavigationClassifyAdapter
        }
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
        mDataBinding.rvContent.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1)) {
                    //滑倒最底部，隐藏
                    mOnItemEvent?.invoke(recyclerView, null, View.GONE, TAB_LAYOUT_VISIBILITY)
                    return
                }
                if (!recyclerView.canScrollVertically(-1)) {
                    //滑倒顶部，显示
                    mOnItemEvent?.invoke(recyclerView, null, View.VISIBLE, TAB_LAYOUT_VISIBILITY)
                    return
                }
                mOnItemEvent?.invoke(
                    recyclerView,
                    null,
                    if (dy > 0) View.GONE else View.VISIBLE,
                    TAB_LAYOUT_VISIBILITY
                )
            }

        })
        mNavigationClassifyAdapter?.setOnItemEventListener { _, data, _, flag ->
            when (flag) {
                // 查看导航分类详情
                VIEW_NAVIGATION_CLASSIFY_DETAIL -> {
                    val navigationArticle = data as NavigationClassifyArticle

                    navigation(
                        activity = activity,
                        path = ACTIVITY_WAN_ANDROID_WEB_VIEW,
                        bundle = Bundle().apply {
                            putString(URL, navigationArticle.link)
                            putString(TITLE, navigationArticle.title)
                        }
                    )
                }
            }
        }
    }

    /**
     * 初始化 LiveData Observer
     */
    override fun initObserver() {
        super.initObserver()
        //首页数据改变监听
        mViewModel?.mNavigationClassifyDataChangeEvent?.observe(viewLifecycleOwner, Observer { event ->
            val (type, _, _, extraData, navigationClassifyList, _) = event

            when (type) {
                //加载
                LOAD,
                    //刷新
                REFRESH -> mNavigationClassifyAdapter?.notifyDataSetChanged()
                //添加
                ADD -> {
                    if (navigationClassifyList.isNullOrEmpty()) {
                        return@Observer
                    }

                    val oldSize = extraData as Int

                    if (oldSize <= 0) {
                        mNavigationClassifyAdapter?.notifyDataSetChanged()
                    } else {
                        mNavigationClassifyAdapter?.notifyItemRangeInserted(oldSize, navigationClassifyList.size)
                    }
                }
                //插入
                INSERT -> {}
                //删除
                REMOVE -> {}
                //更新
                UPDATE -> {}
                else -> {}
            }
        })
    }

    /**
     * 是否开启懒加载 (用于ViewPager)
     *
     * @return true 开启  false 关闭  默认关闭
     */
    override fun isEnableLazyLoad() = true

    /**
     * 滑动到顶部
     */
    override fun scrollToTop() {
        super.scrollToTop()
        mViewModel?.run {
            if (mNavigationClassifyList.isNotEmpty()) {
                mDataBinding.rvContent.smoothScrollToPosition(0)
            }
        }
    }

}