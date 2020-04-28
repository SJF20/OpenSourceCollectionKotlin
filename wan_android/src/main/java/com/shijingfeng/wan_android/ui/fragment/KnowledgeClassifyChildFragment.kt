package com.shijingfeng.wan_android.ui.fragment

import android.os.Bundle
import android.util.SparseArray
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.kingja.loadsir.core.LoadSir
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_WEB_VIEW
import com.shijingfeng.base.arouter.navigation
import com.shijingfeng.base.base.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.util.deserialize
import com.shijingfeng.base.widget.LinearDividerItemDecoration
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.adapter.KnowledgeClassifyChildAdapter
import com.shijingfeng.wan_android.base.WanAndroidBaseFragment
import com.shijingfeng.wan_android.constant.KNOWLEDGE_CLASSIFY_CHILDREN_STR
import com.shijingfeng.wan_android.constant.VIEW_ARTICLE_DETAIL
import com.shijingfeng.wan_android.databinding.FragmentWanAndroidKnowledgeClassifyChildBinding
import com.shijingfeng.wan_android.entity.network.KnowledgeClassifyChildItem
import com.shijingfeng.wan_android.entity.network.KnowledgeClassifyChildren
import com.shijingfeng.wan_android.source.network.getKnowledgeClassifyChildNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.getKnowledgeClassifyChildRepositoryInstance
import com.shijingfeng.wan_android.view_model.KnowledgeClassifyChildViewModel

/**
 * 创建 KnowledgeClassifyChildFragment 实例
 */
internal fun createKnowledgeClassifyChildFragment(bundle: Bundle) = KnowledgeClassifyChildFragment().apply {
    arguments = bundle
}

/**
 * Function: 知识体系 二级数据 Fragment
 * Date: 20-4-25 下午9:41
 * Description:
 * @author shijingfeng
 */
internal class KnowledgeClassifyChildFragment : WanAndroidBaseFragment<FragmentWanAndroidKnowledgeClassifyChildBinding, KnowledgeClassifyChildViewModel>() {

    private var mKnowledgeClassifyChildAdapter: KnowledgeClassifyChildAdapter? = null

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel(): KnowledgeClassifyChildViewModel? {
        val knowledgeClassifyChildRepository = getKnowledgeClassifyChildRepositoryInstance(
            networkSource = getKnowledgeClassifyChildNetworkSourceInstance()
        )
        val factory = createCommonViewModelFactory(
            repository = knowledgeClassifyChildRepository
        )

        return createViewModel(KnowledgeClassifyChildViewModel::class.java, factory)
    }

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.knowledgeClassifyChildViewModel, mViewModel)
    }

    /**
     * 获取视图ID
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.fragment_wan_android_knowledge_classify_child

    /**
     * 初始化参数
     */
    override fun initParam() {
        super.initParam()
        mDataBundle?.run {
            val dataStr = getString(KNOWLEDGE_CLASSIFY_CHILDREN_STR, EMPTY_OBJECT)

            mViewModel?.mKnowledgeClassifyChildren = deserialize(dataStr, KnowledgeClassifyChildren::class.java)
        }
    }

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

        activity?.run {
            mKnowledgeClassifyChildAdapter = KnowledgeClassifyChildAdapter(
                this,
                R.layout.adapter_item_wan_android_knowledge_classify_child,
                mViewModel?.mKnowledgeClassifyChildItemList
            )
            // 注意此处不要使用 rv_content 或 findViewById  否则会导致 ViewPager中相同 Fragment 类,
            // 只会显示最先出现的第一个Fragment页面, 其他为空白, 具体原因应该和 kotlin 省略findViewById写法有关,
            // 如果ViewPager中没有相同 Fragment类 则不会出现此种情况
            mDataBinding.rvContent.layoutManager = LinearLayoutManager(this)
            mDataBinding.rvContent.adapter = mKnowledgeClassifyChildAdapter
            mDataBinding.rvContent.addItemDecoration(LinearDividerItemDecoration())
        }
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
        mKnowledgeClassifyChildAdapter?.setOnItemEventListener { _, data, _, flag ->
            when (flag) {
                // 查看二级数据文章详情
                VIEW_ARTICLE_DETAIL -> {
                    val knowledgeClassifyChildItem = data as KnowledgeClassifyChildItem

                    navigation(
                        activity = activity,
                        path = ACTIVITY_WAN_ANDROID_WEB_VIEW,
                        bundle = Bundle().apply {
                            putString(URL, knowledgeClassifyChildItem.apkLink)
                            putString(TITLE, knowledgeClassifyChildItem.title)
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
        //RecyclerView 适配器和数据列表 LiveData 监听器
        mViewModel?.mKnowledgeClassifyChildDataChangeEvent?.observe(this, Observer ObserverLabel@{ (type, _, _, extraData, knowledgeClassifyChildItemList, _) ->
            when (type) {
                // 加载, 刷新
                LOAD, REFRESH -> mKnowledgeClassifyChildAdapter?.notifyDataSetChanged()
                // 添加
                ADD -> {
                    if (knowledgeClassifyChildItemList.isNullOrEmpty()) {
                        return@ObserverLabel
                    }

                    val oldSize = extraData as Int

                    if (oldSize <= 0) {
                        mKnowledgeClassifyChildAdapter?.notifyDataSetChanged()
                    } else {
                        // oldSize - 1 是为了更新 oldSize下标位置 前面的Item下面的ItemDecoration
                        // 单独使用 notifyItemChanged 是为了避免 RecyclerView item更新动画 不美观
                        mKnowledgeClassifyChildAdapter?.notifyItemChanged(oldSize - 1)
                        mKnowledgeClassifyChildAdapter?.notifyItemRangeInserted(
                            oldSize,
                            knowledgeClassifyChildItemList.size
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
            if (mKnowledgeClassifyChildItemList.isNotEmpty()) {
                mDataBinding.rvContent.smoothScrollToPosition(0)
            }
        }
    }

}