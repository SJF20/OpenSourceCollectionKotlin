package com.shijingfeng.wan_android.ui.fragment

import android.os.Bundle
import android.text.TextUtils
import android.util.SparseArray
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.ToastUtils
import com.kingja.loadsir.core.LoadSir
import com.shijingfeng.base.annotation.BindEventBus
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_WEB_VIEW
import com.shijingfeng.base.arouter.ARouterUtil
import com.shijingfeng.base.arouter.FRAGMENT_WAN_ANDROID_PERSONAL_COLLECTION_ARTICLE
import com.shijingfeng.base.base.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.base.widget.LinearDividerItemDecoration
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.adapter.PersonalCollectionArticleAdapter
import com.shijingfeng.wan_android.base.WanAndroidBaseFragment
import com.shijingfeng.wan_android.constant.ARTICLE_ITEM_UNCOLLECTED
import com.shijingfeng.wan_android.constant.VIEW_ARTICLE_DETAIL
import com.shijingfeng.wan_android.databinding.FragmentWanAndroidPersonalCollectionArticleBinding
import com.shijingfeng.wan_android.entity.event.ArticleCollectionEvent
import com.shijingfeng.wan_android.entity.network.PersonalCollectionArticleItem
import com.shijingfeng.wan_android.source.network.getPersonalCollectionArticleNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.getPersonalCollectionArticleRepositoryInstance
import com.shijingfeng.wan_android.view_model.PersonalCollectionArticleViewModel
import kotlinx.android.synthetic.main.fragment_wan_android_personal_collection_article.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * Function: 我的收藏 -> 收藏文章列表 Fragment
 * Date: 2020/3/24 22:53
 * Description:
 * @author ShiJingFeng
 */
@Route(path = FRAGMENT_WAN_ANDROID_PERSONAL_COLLECTION_ARTICLE)
@BindEventBus
internal class PersonalCollectionArticleFragment : WanAndroidBaseFragment<FragmentWanAndroidPersonalCollectionArticleBinding, PersonalCollectionArticleViewModel>() {

    /** 文章收藏列表 适配器 */
    private var mPersonalCollectionArticleAdapter: PersonalCollectionArticleAdapter? = null

    /**
     * 获取视图ID
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.fragment_wan_android_personal_collection_article

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel(): PersonalCollectionArticleViewModel? {
        val personalCollectionArticleRepository = getPersonalCollectionArticleRepositoryInstance(
            networkSource = getPersonalCollectionArticleNetworkSourceInstance()
        )
        val factory = createCommonViewModelFactory(
            repository = personalCollectionArticleRepository
        )

        return createViewModel(PersonalCollectionArticleViewModel::class.java, factory)
    }

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.personalCollectionArticleViewModel, mViewModel)
    }

    /**
     * 初始化数据
     */
    override fun initData() {
        super.initData()
        mSmartRefreshLayout = srl_refresh
        mSmartRefreshLayout?.setEnableLoadMoreWhenContentNotFull(false)
        mLoadService = LoadSir.getDefault().register(srl_refresh, mViewModel?.mReloadListener)
        if (mViewModel == null || !mViewModel!!.mHasInited) {
            showCallback(LOAD_SERVICE_LOADING)
        }

        activity?.let { activity ->
            mPersonalCollectionArticleAdapter = PersonalCollectionArticleAdapter(
                activity,
                R.layout.adapter_item_wan_android_personal_collection_article,
                mViewModel?.mArticleCollectedListItemList
            )
            rv_content.layoutManager = LinearLayoutManager(activity)
            rv_content.adapter = mPersonalCollectionArticleAdapter
            rv_content.addItemDecoration(LinearDividerItemDecoration())
        }
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
        mPersonalCollectionArticleAdapter?.setOnItemEventListener { _, data, _, flag ->
            when (flag) {
                // 查看文章详情
                VIEW_ARTICLE_DETAIL -> {
                    val personalCollectionArticleItem = data as PersonalCollectionArticleItem
                    val url = personalCollectionArticleItem.link
                    val title = personalCollectionArticleItem.title

                    if (activity == null) {
                        return@setOnItemEventListener
                    }
                    ARouterUtil.navigation(
                        activity = activity,
                        path = ACTIVITY_WAN_ANDROID_WEB_VIEW,
                        bundle = Bundle().apply {
                            putString(URL, url)
                            putString(TITLE, title)
                        }
                    )
                }
                // 文章取消收藏
                ARTICLE_ITEM_UNCOLLECTED -> mViewModel?.uncollectedInCollectedList(data as PersonalCollectionArticleItem)
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
                REFRESH -> mPersonalCollectionArticleAdapter?.notifyDataSetChanged()
                // 添加
                ADD -> {
                    if (articleCollectedListItem.isNullOrEmpty()) {
                        return@ObserverLabel
                    }

                    val oldSize = extraData as Int

                    if (oldSize <= 0) {
                        mPersonalCollectionArticleAdapter?.notifyDataSetChanged()
                    } else {
                        mPersonalCollectionArticleAdapter?.notifyItemRangeInserted(
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
                        mPersonalCollectionArticleAdapter?.notifyItemRemoved(position)
                    }
                    mPersonalCollectionArticleAdapter?.notifyItemRangeChanged(
                        minPosition,
                        oldSize2 - minPosition
                    )
                    ToastUtils.showShort(getStringById(R.string.取消收藏成功))
                }
                // 更新
                UPDATE -> {}
                else -> {}
            }
        })
    }

    /**
     * 是否开启懒加载 (用于ViewPager)
     * @return true 开启  false 关闭  默认关闭
     */
    override fun isEnableLazyLoad() = true

    /**
     * 滑动到顶部
     */
    override fun scrollToTop() {
        super.scrollToTop()
        mViewModel?.run {
            if (mArticleCollectedListItemList.isNotEmpty()) {
                rv_content.smoothScrollToPosition(0)
            }
        }
    }

    /**
     * 获取 收藏状态改变 Event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getArticleCollectionEvent(event: ArticleCollectionEvent) {
        if (PersonalCollectionArticleFragment::class.java.name == event.fromName) {
            return
        }
        if (TextUtils.isEmpty(event.id)) {
            return
        }

        //因为服务器返回字段设计问题，导致 收藏列表中被收藏的文章 的 id 和 收藏列表以外的文章的 id 不相等, 故采用全局刷新的方式
        mViewModel?.refresh()
    }

}