package com.shijingfeng.wan_android.ui.fragment

import android.os.Bundle
import android.util.SparseArray
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.kingja.loadsir.core.LoadSir
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_KNOWLEDGE_CLASSIFY_DETAIL
import com.shijingfeng.base.arouter.FRAGMENT_WAN_ANDROID_KNOWLEDGE_CLASSIFY
import com.shijingfeng.base.arouter.navigation
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.util.serialize
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.adapter.KnowledgeClassifyAdapter
import com.shijingfeng.wan_android.base.WanAndroidBaseFragment
import com.shijingfeng.wan_android.common.constant.KNOWLEDGE_CLASSIFY_STR
import com.shijingfeng.wan_android.common.constant.TAB_LAYOUT_VISIBILITY
import com.shijingfeng.wan_android.common.constant.VIEW_KNOWLEDGE_CLASSIFY_DETAIL
import com.shijingfeng.wan_android.databinding.FragmentWanAndroidKnowledgeClassifyBinding
import com.shijingfeng.wan_android.entity.KnowledgeClassifyEntity
import com.shijingfeng.wan_android.view_model.KnowledgeClassifyViewModel

/**
 * 创建 KnowledgeClassifyFragment 实例
 */
internal fun createKnowledgeClassifyFragment() = KnowledgeClassifyFragment()

/**
 * Function: 知识体系 Fragment
 * Date: 2020/4/21 20:28
 * Description:
 * Author: ShiJingFeng
 */
@Route(path = FRAGMENT_WAN_ANDROID_KNOWLEDGE_CLASSIFY)
internal class KnowledgeClassifyFragment : WanAndroidBaseFragment<FragmentWanAndroidKnowledgeClassifyBinding, KnowledgeClassifyViewModel>() {

    private var mKnowledgeClassifyAdapter: KnowledgeClassifyAdapter? = null

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel() = createViewModel(KnowledgeClassifyViewModel::class.java)

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.knowledgeClassifyViewModel, mViewModel)
    }

    /**
     * 获取视图ID
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.fragment_wan_android_knowledge_classify

    /**
     * 初始化数据
     */
    override fun initData() {
        super.initData()
        mSmartRefreshLayout = mDataBinding.srlRefresh
        // 当内容不满一页是否可以上拉加载  true: 可以  false: 不可以
        mSmartRefreshLayout?.setEnableLoadMoreWhenContentNotFull(true)
        mLoadService = LoadSir.getDefault().register(mDataBinding.srlRefresh, mViewModel?.mReloadListener)
        if (mViewModel == null || !mViewModel!!.mHasInitialized) {
            showCallback(LOAD_SERVICE_LOADING)
        }

        context?.run {
            mKnowledgeClassifyAdapter = KnowledgeClassifyAdapter(
                this,
                mViewModel?.mKnowledgeClassifyList
            )
            mDataBinding.rvContent.layoutManager = LinearLayoutManager(this)
            mDataBinding.rvContent.adapter = mKnowledgeClassifyAdapter
        }

        if (!mDataBinding.rvContent.canScrollVertically(1)) {
            mOnItemEvent?.invoke(mDataBinding.rvContent, null, View.VISIBLE, TAB_LAYOUT_VISIBILITY)
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
//                if (!recyclerView.canScrollVertically(1)) {
//                    //滑倒最底部，隐藏
//                    mOnItemEvent?.invoke(recyclerView, null, View.GONE,
//                        TAB_LAYOUT_VISIBILITY
//                    )
//                    return
//                }
                if (!recyclerView.canScrollVertically(-1)) {
                    //滑倒顶部，显示
                    mOnItemEvent?.invoke(recyclerView, null, View.VISIBLE,
                        TAB_LAYOUT_VISIBILITY
                    )
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
        mKnowledgeClassifyAdapter?.onItemEvent = { _, data, position, flag ->
            when (flag) {
                // 查看知识体系详情
                VIEW_KNOWLEDGE_CLASSIFY_DETAIL -> {
                    val knowledgeClassify = data as KnowledgeClassifyEntity

                    navigation(
                        activity = activity,
                        path = ACTIVITY_WAN_ANDROID_KNOWLEDGE_CLASSIFY_DETAIL,
                        bundle = Bundle().apply {
                            putString(KNOWLEDGE_CLASSIFY_STR, serialize(knowledgeClassify))
                            putInt(CURRENT_POSITION, position)
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
        mViewModel?.mKnowledgeClassifyDataChangeEvent?.observe(viewLifecycleOwner, Observer { event ->
            val (type, _, _, extraData, knowledgeClassifyList, _) = event

            when (type) {
                //加载
                LOAD,
                //刷新
                REFRESH -> mKnowledgeClassifyAdapter?.notifyDataSetChanged()
                //添加
                ADD -> {
                    if (knowledgeClassifyList.isNullOrEmpty()) {
                        return@Observer
                    }

                    val oldSize = extraData as Int

                    if (oldSize <= 0) {
                        mKnowledgeClassifyAdapter?.notifyDataSetChanged()
                    } else {
                        mKnowledgeClassifyAdapter?.notifyItemRangeInserted(oldSize, knowledgeClassifyList.size)
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
            if (mKnowledgeClassifyList.isNotEmpty()) {
                mDataBinding.rvContent.smoothScrollToPosition(0)
            }
        }
    }

}