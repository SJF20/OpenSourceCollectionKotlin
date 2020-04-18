package com.shijingfeng.wan_android.ui.fragment

import android.os.Bundle
import android.text.TextUtils
import android.util.SparseArray
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.kingja.loadsir.core.LoadSir
import com.shijingfeng.base.annotation.BindEventBus
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_WEB_VIEW
import com.shijingfeng.base.arouter.ARouterUtil.navigation
import com.shijingfeng.base.arouter.FRAGMENT_WAN_ANDROID_HOME
import com.shijingfeng.base.base.adapter.support.MultiItemTypeSupport
import com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder
import com.shijingfeng.base.base.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.util.getPositionById
import com.shijingfeng.base.widget.LinearDividerItemDecoration
import com.shijingfeng.sjf_banner.library.banner.view.BannerView
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.adapter.HomeAdapter
import com.shijingfeng.wan_android.base.WanAndroidBaseFragment
import com.shijingfeng.wan_android.constant.*
import com.shijingfeng.wan_android.databinding.FragmentWanAndroidHomeBinding
import com.shijingfeng.wan_android.entity.adapter.HomeItem
import com.shijingfeng.wan_android.entity.adapter.HomeSetToTopItem
import com.shijingfeng.wan_android.entity.event.ArticleCollectionEvent
import com.shijingfeng.wan_android.entity.network.HomeArticleItem
import com.shijingfeng.wan_android.entity.network.HomeBannerEntity
import com.shijingfeng.wan_android.source.network.getHomeNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.getHomeRepositoryInstance
import com.shijingfeng.wan_android.view_model.HomeViewModel
import kotlinx.android.synthetic.main.fragment_wan_android_home.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * 创建 HomeFragment 实例
 */
internal fun createHomeFragment() = HomeFragment()

/**
 * Function: 首页 Fragment
 * Date: 2020/2/12 14:05
 * Description:
 * @author ShiJingFeng
 */
@Route(path = FRAGMENT_WAN_ANDROID_HOME)
@BindEventBus
internal class HomeFragment : WanAndroidBaseFragment<FragmentWanAndroidHomeBinding, HomeViewModel>() {

    /** 首页数据适配器  */
    private var mHomeAdapter: HomeAdapter? = null

    /**
     * 获取视图ID
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.fragment_wan_android_home

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel(): HomeViewModel? {
        val homeRepository = getHomeRepositoryInstance(
            networkSource = getHomeNetworkSourceInstance()
        )
        val factory = createCommonViewModelFactory(
            repository = homeRepository
        )

        return createViewModel(HomeViewModel::class.java, factory)
    }

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.homeViewModel, mViewModel)
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
            mHomeAdapter = HomeAdapter(
                activity,
                mViewModel?.mHomeItemDataList,
                object : MultiItemTypeSupport<HomeItem> {

                    /**
                     * 根据 Item类型 获取 Layout Id
                     * @param itemType Item类型
                     * @return Layout Id
                     */
                    override fun getLayoutId(itemType: Int): Int = when (itemType) {
                        // 轮播图
                        HOME_BANNER -> R.layout.adapter_item_wan_android_home_banner
                        // 置顶文章
                        HOME_SET_TO_TOP -> R.layout.adapter_item_wan_android_home_set_to_top
                        // 文章
                        HOME_ARTICLE -> R.layout.adapter_item_wan_android_home_article
                        // 未知类型
                        ADAPTER_TYPE_UNKNOWN -> R.layout.adapter_item_null
                        else -> 0
                    }

                    /**
                     * 获取 Item类型
                     * @param position 下标位置
                     * @param data 数据
                     * @return Item类型
                     */
                    override fun getItemViewType(position: Int, data: HomeItem) = data.getType()

            })
            rv_content.adapter = mHomeAdapter
            rv_content.layoutManager = LinearLayoutManager(activity)
            rv_content.addItemDecoration(LinearDividerItemDecoration())
        }
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
        rv_content.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1)) {
                    //滑倒最底部，隐藏
                    mOnItemEvent?.invoke(recyclerView, null, GONE, TAB_LAYOUT_VISIBILITY)
                    return
                }
                if (!recyclerView.canScrollVertically(-1)) { //滑倒顶部，显示
                    mOnItemEvent?.invoke(recyclerView, null, VISIBLE, TAB_LAYOUT_VISIBILITY)
                    return
                }
                mOnItemEvent?.invoke(
                    recyclerView,
                    null,
                    if (dy > 0) GONE else VISIBLE,
                    TAB_LAYOUT_VISIBILITY
                )
            }

        })
        mHomeAdapter?.setOnItemEventListener { _, data, position, flag ->
            if (data == null) {
                return@setOnItemEventListener
            }

            when (flag) {
                //查看轮播图详情
                VIEW_BANNER_DETAIL -> {
                    val (identity, _, _, _, _, title, _, url) = data as HomeBannerEntity

                    navigation(
                        activity = activity,
                        path = ACTIVITY_WAN_ANDROID_WEB_VIEW,
                        bundle = Bundle().apply {
                            putString(URL, url)
                            putString(TITLE, title)
                        }
                    )
                }
                //查看文章详情
                VIEW_ARTICLE_DETAIL -> {
                    val homeItem = data as HomeItem

                    when (homeItem.getType()) {
                        //置顶文章
                        HOME_SET_TO_TOP -> {
                            val homeSetToTopItem = homeItem as HomeSetToTopItem
                            val identity = homeSetToTopItem.getId()
                            val url = homeSetToTopItem.link
                            val title = homeSetToTopItem.title
                            val collected = homeSetToTopItem.collected

                            navigation(
                                activity = activity,
                                path = ACTIVITY_WAN_ANDROID_WEB_VIEW,
                                bundle = Bundle().apply {
                                    putString(URL, url)
                                    putString(TITLE, title)
                                }
                            )
                        }
                        //文章
                        HOME_ARTICLE -> {
                            val homeArticleItem = homeItem as HomeArticleItem
                            val identity = homeArticleItem.getId()
                            val url = homeArticleItem.link
                            val title = homeArticleItem.title
                            val collected = homeArticleItem.collected

                            navigation(
                                activity = activity,
                                path = ACTIVITY_WAN_ANDROID_WEB_VIEW,
                                bundle = Bundle().apply {
                                    putString(URL, url)
                                    putString(TITLE, title)
                                }
                            )
                        }
                        else -> {
                        }
                    }
                }
                //文章 收藏 或 取消收藏
                ARTICLE_ITEM_COLLECTION -> {
                    mViewModel?.run {
                        val homeItem = mHomeItemDataList[position]
                        val collected = data as Boolean

                        if (collected) {
                            //收藏
                            collected(homeItem.getId())
                        } else {
                            //取消收藏
                            uncollected(homeItem.getId())
                        }
                    }
                }
                else -> {
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
        mViewModel?.mHomeDataChangeEvent?.observe(viewLifecycleOwner, Observer { event ->
            val (type, _, _, extraData, homeItemList, _) = event

            when (type) {
                //加载
                LOAD,
                //刷新
                REFRESH -> mHomeAdapter?.notifyDataChanged()
                //添加
                ADD -> {
                    if (homeItemList.isNullOrEmpty()) {
                        return@Observer
                    }

                    val oldSize = extraData as Int

                    if (oldSize <= 0) {
                        mHomeAdapter?.notifyDataSetChanged()
                    } else {
                        mHomeAdapter?.notifyItemRangeInserted(oldSize, homeItemList.size)
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
        //收藏状态改变监听器
        mViewModel?.mCollectedStatusEvent?.observe(viewLifecycleOwner, Observer { sparseArray ->
            //收藏还是取消收藏  true:收藏  false:取消收藏
            val collected = sparseArray[KEY_COLLECTED] as Boolean
            val articleId = sparseArray[KEY_ARTICLE_ID] as String
            val position = getPositionById(articleId, mViewModel?.mHomeItemDataList!!)

            if (position != -1) {
                val homeItem = mViewModel!!.mHomeItemDataList[position]
                val payloadMap = mutableMapOf<String, Any>()

                payloadMap[PART_UPDATE_FLAG] = PART_UPDATE_COLLECTION_STATUS

                when (homeItem) {
                    is HomeSetToTopItem -> homeItem.collected = collected
                    is HomeArticleItem -> homeItem.collected = collected
                    else -> {}
                }
                mHomeAdapter?.notifyItemChanged(position, payloadMap)
            }
        })
    }

    override fun onPause() {
        val viewHolder = rv_content.findViewHolderForAdapterPosition(0)

        if (viewHolder != null) {
            val commonViewHolder = viewHolder as CommonViewHolder
            val bannerView = commonViewHolder.getView<BannerView>(R.id.bv_banner)

            // 暂停轮播图自动轮播
            bannerView?.pause()
        }
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        val viewHolder = rv_content.findViewHolderForAdapterPosition(0)

        if (viewHolder != null) {
            val commonViewHolder = viewHolder as CommonViewHolder
            val bannerView = commonViewHolder.getView<BannerView>(R.id.bv_banner)

            // 恢复轮播图自动轮播
            bannerView?.resume()
        }
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
            if (mHomeItemDataList.isNotEmpty()) {
                rv_content.smoothScrollToPosition(0)
            }
        }
    }

    /**
     * 更新 首页收藏
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getCollectionEvent(event: ArticleCollectionEvent) {
        if (HomeFragment::class.java.name == event.fromName) {
            return
        }
        if (TextUtils.isEmpty(event.id)) {
            return
        }

        //因为服务器返回字段设计问题，导致 收藏列表中被收藏的文章 的 id 和 收藏列表以外的文章的 id 不相等, 故采用全局刷新的方式
        mViewModel?.refresh()

//        val id = event.id
//        val collected = event.collected
//
//        val homeItemList: List<HomeItem> = mViewModel!!.mHomeItemDataList
//
//        if (TextUtils.isEmpty(id)) {
//            return
//        }
//        for (i in homeItemList.indices) {
//            val homeItem = homeItemList[i]
//            var currentId: String? = null
//            if (homeItem.getType() == HOME_SET_TO_TOP) { //置顶文章
//                val homeSetToTopItem = homeItem as HomeSetToTopItem
//                currentId = homeSetToTopItem.getId()
//            } else if (homeItem.getType() == HOME_ARTICLE) { //文章
//                val homeArticleItem: HomeArticleEntity.Item = homeItem as HomeArticleEntity.Item
//                currentId = homeArticleItem.getId()
//            }
//            if (id == currentId) {
//                val sparseArray = SparseArray<Any?>()
//                sparseArray.put(KEY_COLLECTED, collected)
//                sparseArray.put(KEY_ARTICLE_ID, id)
//                mViewModel!!.mCollectedStatusEvent.setValue(sparseArray)
//                return
//            }
//        }
    }

}