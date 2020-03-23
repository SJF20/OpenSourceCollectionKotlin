package com.shijingfeng.wan_android.ui.activity

import android.os.Bundle
import android.util.SparseArray
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.ToastUtils
import com.kingja.loadsir.core.LoadSir
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_ARTICLE_COLLECTED_LIST
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_WEB_VIEW
import com.shijingfeng.base.arouter.ARouterUtil.navigation
import com.shijingfeng.base.base.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.base.widget.LinearDividerItemDecoration
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.adapter.ArticleCollectedListAdapter
import com.shijingfeng.wan_android.base.WanAndroidBaseActivity
import com.shijingfeng.wan_android.constant.ARTICLE_ITEM_UNCOLLECTED
import com.shijingfeng.wan_android.constant.VIEW_ARTICLE_DETAIL
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidArticleCollectedListBinding
import com.shijingfeng.wan_android.entity.network.ArticleCollectedListItem
import com.shijingfeng.wan_android.source.network.getArticleCollectedListNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.getArticleCollectedListRepositoryInstance
import com.shijingfeng.wan_android.view_model.ArticleCollectedListViewModel
import kotlinx.android.synthetic.main.activity_wan_android_article_collected_list.*
import kotlinx.android.synthetic.main.layout_wan_android_title_bar.view.*

/**
 * Function: 文章收藏列表 (入口: 首页侧边栏 我的收藏) Activity
 * Date: 2020/3/22 20:56
 * Description:
 * @author ShiJingFeng
 */
@Route(path = ACTIVITY_WAN_ANDROID_ARTICLE_COLLECTED_LIST)
internal class ArticleCollectedListActivity : WanAndroidBaseActivity<ActivityWanAndroidArticleCollectedListBinding, ArticleCollectedListViewModel>() {

    private var mArticleCollectedListAdapter: ArticleCollectedListAdapter? = null

    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.activity_wan_android_article_collected_list

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel(): ArticleCollectedListViewModel? {
        val articleCollectedListRepository = getArticleCollectedListRepositoryInstance(
            networkSource = getArticleCollectedListNetworkSourceInstance()
        )
        val factory = createCommonViewModelFactory(
            repository = articleCollectedListRepository
        )

        return createViewModel(ArticleCollectedListViewModel::class.java, factory)
    }

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.articleCollectedListViewModel, mViewModel)
    }

    /**
     * 初始化数据
     */
    override fun initData() {
        super.initData()
        include_title_bar.tv_title.text = getStringById(R.string.我的收藏文章)

        mSmartRefreshLayout = srl_refresh
        mSmartRefreshLayout?.setEnableLoadMoreWhenContentNotFull(false)
        mLoadService = LoadSir.getDefault().register(srl_refresh, mViewModel?.mReloadListener)
        if (mViewModel == null || !mViewModel!!.mHasInited) {
            showCallback(LOADING)
        }

        mArticleCollectedListAdapter = ArticleCollectedListAdapter(
            this,
            R.layout.adapter_item_wan_android_article_collected_list,
            mViewModel?.mArticleCollectedListItemList
        )
        rv_content.layoutManager = LinearLayoutManager(this)
        rv_content.adapter = mArticleCollectedListAdapter
        rv_content.addItemDecoration(LinearDividerItemDecoration())
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
        mArticleCollectedListAdapter?.setOnItemEventListener { _, data, _, flag ->
            when (flag) {
                // 查看文章详情
                VIEW_ARTICLE_DETAIL -> {
                    val articleCollectedListItem = data as ArticleCollectedListItem
                    val url: String = articleCollectedListItem.link
                    val title: String = articleCollectedListItem.title

                    navigation(
                        activity = this,
                        path = ACTIVITY_WAN_ANDROID_WEB_VIEW,
                        bundle = Bundle().apply {
                            putString(URL, url)
                            putString(TITLE, title)
                        }
                    )
                }
                // 文章取消收藏
                ARTICLE_ITEM_UNCOLLECTED -> mViewModel?.uncollectedInCollectedList(data as ArticleCollectedListItem)
                else -> {}
            }
        }
    }

    /**
     * 初始化 LiveData Observer
     */
    override fun initObserver() {
        super.initObserver()
        //RecyclerView 适配器和数据列表 LiveData 监听器
        mViewModel?.mListDataChangeEvent?.observe(this, Observer ObserverLabel@{ (type, _, _, extraData, articleCollectedListItem, indexList) ->
            when (type) {
                // 加载
                LOAD,
                // 刷新
                REFRESH -> mArticleCollectedListAdapter!!.notifyDataSetChanged()
                // 添加
                ADD -> {
                    if (articleCollectedListItem.isNullOrEmpty()) {
                        return@ObserverLabel
                    }

                    val oldSize = extraData as Int

                    if (oldSize <= 0) {
                        mArticleCollectedListAdapter?.notifyDataSetChanged()
                    } else {
                        mArticleCollectedListAdapter?.notifyItemRangeInserted(
                            oldSize,
                            articleCollectedListItem.size
                        )
                    }
                }
                // 插入
                INSERT -> {}
                // 删除
                REMOVE -> {
                    if (indexList.isNullOrEmpty()) {
                        return@ObserverLabel
                    }

                    val oldSize2 = extraData as Int
                    var minPosition = indexList[0]

                    indexList.forEach { position ->
                        if (position < minPosition) {
                            minPosition = position
                        }
                        mArticleCollectedListAdapter?.notifyItemRemoved(position)
                    }
                    mArticleCollectedListAdapter?.notifyItemRangeChanged(
                        minPosition,
                        oldSize2 - minPosition
                    )
                    ToastUtils.showShort("取消收藏成功")
                }
                // 更新
                UPDATE -> {}
                else -> {}
            }
        })
        //置顶 LiveData 监听器
        mViewModel?.let { viewModel ->
            viewModel.mScrollToTopEvent.observe(this, Observer {
                if (viewModel.mArticleCollectedListItemList.size > 0) {
                    rv_content.smoothScrollToPosition(0)
                }
            })
        }
    }
}