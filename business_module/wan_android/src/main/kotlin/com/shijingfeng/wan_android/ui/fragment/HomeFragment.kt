package com.shijingfeng.wan_android.ui.fragment

import android.os.Bundle
import android.util.SparseArray
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.kingja.loadsir.core.LoadSir
import com.shijingfeng.base.annotation.BindEventBus
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_WEB_VIEW
import com.shijingfeng.base.arouter.FRAGMENT_WAN_ANDROID_HOME
import com.shijingfeng.base.arouter.navigation
import com.shijingfeng.base_adapter.viewholder.CommonViewHolder
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.util.getPositionById
import com.shijingfeng.base.widget.LinearDividerItemDecoration
import com.shijingfeng.base_adapter.support.MultiItemTypeSupport
import com.shijingfeng.sjf_banner.banner.view.BannerView
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.adapter.HomeAdapter
import com.shijingfeng.wan_android.base.WanAndroidBaseFragment
import com.shijingfeng.wan_android.common.constant.*
import com.shijingfeng.wan_android.common.constant.ARTICLE_ITEM_COLLECTION
import com.shijingfeng.wan_android.common.constant.HOME_ARTICLE
import com.shijingfeng.wan_android.common.constant.HOME_BANNER
import com.shijingfeng.wan_android.common.constant.HOME_TOP_ARTICLE
import com.shijingfeng.wan_android.common.constant.KEY_ARTICLE_ID
import com.shijingfeng.wan_android.common.constant.KEY_COLLECTED
import com.shijingfeng.wan_android.common.constant.PART_UPDATE_COLLECTION_STATUS
import com.shijingfeng.wan_android.common.constant.PART_UPDATE_FLAG
import com.shijingfeng.wan_android.common.constant.TAB_LAYOUT_VISIBILITY
import com.shijingfeng.wan_android.common.constant.VIEW_ARTICLE_DETAIL
import com.shijingfeng.wan_android.databinding.FragmentWanAndroidHomeBinding
import com.shijingfeng.wan_android.entity.adapter.HomeItem
import com.shijingfeng.wan_android.entity.adapter.HomeTopArticleItem
import com.shijingfeng.wan_android.entity.event.ArticleCollectionEvent
import com.shijingfeng.wan_android.entity.HomeArticleItem
import com.shijingfeng.wan_android.entity.adapter.HomeBannerItem
import com.shijingfeng.wan_android.entity.event.ThemeEvent
import com.shijingfeng.wan_android.entity.event.UserInfoEvent
import com.shijingfeng.wan_android.view_model.HomeViewModel
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
 * Author: ShiJingFeng
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
    override fun getViewModel() = createViewModel(HomeViewModel::class.java)

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
        mSmartRefreshLayout = mDataBinding.srlRefresh
        // 当内容不满一页是否可以上拉加载  true: 可以  false: 不可以
        mSmartRefreshLayout?.setEnableLoadMoreWhenContentNotFull(true)
        mLoadService = LoadSir.getDefault().register(mDataBinding.srlRefresh, mViewModel?.mReloadListener)
        if (mViewModel == null || !mViewModel!!.mHasInitialized) {
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
                        HOME_TOP_ARTICLE -> R.layout.adapter_item_wan_android_home_top_article
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
            mDataBinding.rvContent.adapter = mHomeAdapter
            mDataBinding.rvContent.layoutManager = LinearLayoutManager(activity)
            mDataBinding.rvContent.addItemDecoration(LinearDividerItemDecoration())
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
//                    mOnItemEvent?.invoke(recyclerView, null, GONE,
//                        TAB_LAYOUT_VISIBILITY
//                    )
//                    return
//                }
                if (!recyclerView.canScrollVertically(-1)) {
                    //滑倒顶部，显示
                    mOnItemEvent?.invoke(recyclerView, null, VISIBLE,
                        TAB_LAYOUT_VISIBILITY
                    )
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
        mHomeAdapter?.onItemEvent = onItemEvent@{ _, data, position, flag ->
            if (data == null) {
                return@onItemEvent
            }

            when (flag) {
                //查看轮播图详情
                VIEW_BANNER_DETAIL -> {
                    val (_, _, _, _, _, title, _, url) = data as HomeBannerItem

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
                        HOME_TOP_ARTICLE -> {
                            val homeTopArticleItem = homeItem as HomeTopArticleItem
                            val identity = homeTopArticleItem.getId()
                            val url = homeTopArticleItem.link
                            val title = homeTopArticleItem.title
                            val collected = homeTopArticleItem.collected

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
                else -> {}
            }
        }
    }

    /**
     * 初始化 LiveData Observer
     */
    override fun initObserver() {
        super.initObserver()
        //首页数据改变监听
        mViewModel?.mHomeDataChangeEvent?.observe(viewLifecycleOwner, Observer { (type, _, _, extraData, homeItemList, _) ->
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
                        // oldSize - 1 是为了更新 oldSize下标位置 前面的Item下面的ItemDecoration
                        // 单独使用 notifyItemChanged 是为了避免 RecyclerView item更新动画 不美观
                        mHomeAdapter?.notifyItemChanged(oldSize - 1)
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
                    is HomeTopArticleItem -> homeItem.collected = collected
                    is HomeArticleItem -> homeItem.collected = collected
                    else -> {}
                }
                mHomeAdapter?.notifyItemChanged(position, payloadMap)
            }
        })
    }

    override fun onPause() {
        val viewHolder = mDataBinding.rvContent.findViewHolderForAdapterPosition(0)

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
        val viewHolder = mDataBinding.rvContent.findViewHolderForAdapterPosition(0)

        if (viewHolder != null) {
            val commonViewHolder = viewHolder as CommonViewHolder
            val bannerView = commonViewHolder.getView<BannerView>(R.id.bv_banner)

            // 恢复轮播图自动轮播
            bannerView?.resume()
        }

        if (mViewModel?.mNeedUpdateTheme == true) {
            val size = mViewModel!!.mHomeItemDataList.size

            mViewModel?.mNeedUpdateTheme = false
            if (size > 0) {
                // 考虑到 RecyclerView 的缓存问题，故使用 notifyItemRangeChanged 全局刷新
                mHomeAdapter?.notifyItemRangeChanged(0, size, mutableMapOf<String, Any>().apply {
                    put(PART_UPDATE_FLAG, PART_UPDATE_THEME)
                })
            }
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
                mDataBinding.rvContent.smoothScrollToPosition(0)
            }
        }
    }

    /**
     * 获取 用户信息 改变 Event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getUserInfoEvent(event: UserInfoEvent) {
        // 自动刷新
        mDataBinding.srlRefresh.autoRefresh()
    }

    /**
     * 获取 首页收藏更新 Event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getCollectionEvent(event: ArticleCollectionEvent) {
        if (HomeFragment::class.java.name == event.fromName) {
            return
        }
//        if (TextUtils.isEmpty(event.id)) {
//            return
//        }

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

    /**
     * 获取 主题更新 Event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getThemeEvent(event: ThemeEvent) {
        val size = mViewModel!!.mHomeItemDataList.size

        if (size > 0) {
            if (mIsVisible) {
                // 考虑到 RecyclerView 的缓存问题，故使用 notifyItemRangeChanged 全局刷新
                mHomeAdapter?.notifyItemRangeChanged(0, size, mutableMapOf<String, Any>().apply {
                    put(PART_UPDATE_FLAG, PART_UPDATE_THEME)
                })
            } else {
                mViewModel?.mNeedUpdateTheme = true
            }
        }
    }

}