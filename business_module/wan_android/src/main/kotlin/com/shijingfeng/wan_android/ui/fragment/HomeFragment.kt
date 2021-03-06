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
 * ?????? HomeFragment ??????
 */
internal fun createHomeFragment() = HomeFragment()

/**
 * Function: ?????? Fragment
 * Date: 2020/2/12 14:05
 * Description:
 * Author: ShiJingFeng
 */
@Route(path = FRAGMENT_WAN_ANDROID_HOME)
@BindEventBus
internal class HomeFragment : WanAndroidBaseFragment<FragmentWanAndroidHomeBinding, HomeViewModel>() {

    /** ?????????????????????  */
    private var mHomeAdapter: HomeAdapter? = null

    /**
     * ????????????ID
     * @return ??????ID
     */
    override fun getLayoutId() = R.layout.fragment_wan_android_home

    /**
     * ??????ViewModel
     * @return ViewModel
     */
    override fun getViewModel() = createViewModel(HomeViewModel::class.java)

    /**
     * ????????? DataBinding ??????ID ??? ??????????????? Map
     * @return DataBinding ??????SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.homeViewModel, mViewModel)
    }

    /**
     * ???????????????
     */
    override fun initData() {
        super.initData()
        mSmartRefreshLayout = mDataBinding.srlRefresh
        // ?????????????????????????????????????????????  true: ??????  false: ?????????
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
                     * ?????? Item?????? ?????? Layout Id
                     * @param itemType Item??????
                     * @return Layout Id
                     */
                    override fun getLayoutId(itemType: Int): Int = when (itemType) {
                        // ?????????
                        HOME_BANNER -> R.layout.adapter_item_wan_android_home_banner
                        // ????????????
                        HOME_TOP_ARTICLE -> R.layout.adapter_item_wan_android_home_top_article
                        // ??????
                        HOME_ARTICLE -> R.layout.adapter_item_wan_android_home_article
                        // ????????????
                        ADAPTER_TYPE_UNKNOWN -> R.layout.adapter_item_null
                        else -> 0
                    }

                    /**
                     * ?????? Item??????
                     * @param position ????????????
                     * @param data ??????
                     * @return Item??????
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
     * ???????????????
     */
    override fun initAction() {
        super.initAction()
        mDataBinding.rvContent.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
//                if (!recyclerView.canScrollVertically(1)) {
//                    //????????????????????????
//                    mOnItemEvent?.invoke(recyclerView, null, GONE,
//                        TAB_LAYOUT_VISIBILITY
//                    )
//                    return
//                }
                if (!recyclerView.canScrollVertically(-1)) {
                    //?????????????????????
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
                //?????????????????????
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
                //??????????????????
                VIEW_ARTICLE_DETAIL -> {
                    val homeItem = data as HomeItem

                    when (homeItem.getType()) {
                        //????????????
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
                        //??????
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
                //?????? ?????? ??? ????????????
                ARTICLE_ITEM_COLLECTION -> {
                    mViewModel?.run {
                        val homeItem = mHomeItemDataList[position]
                        val collected = data as Boolean

                        if (collected) {
                            //??????
                            collected(homeItem.getId())
                        } else {
                            //????????????
                            uncollected(homeItem.getId())
                        }
                    }
                }
                else -> {}
            }
        }
    }

    /**
     * ????????? LiveData Observer
     */
    override fun initObserver() {
        super.initObserver()
        //????????????????????????
        mViewModel?.mHomeDataChangeEvent?.observe(viewLifecycleOwner, Observer { (type, _, _, extraData, homeItemList, _) ->
            when (type) {
                //??????
                LOAD,
                //??????
                REFRESH -> mHomeAdapter?.notifyDataChanged()
                //??????
                ADD -> {
                    if (homeItemList.isNullOrEmpty()) {
                        return@Observer
                    }

                    val oldSize = extraData as Int

                    if (oldSize <= 0) {
                        mHomeAdapter?.notifyDataSetChanged()
                    } else {
                        // oldSize - 1 ??????????????? oldSize???????????? ?????????Item?????????ItemDecoration
                        // ???????????? notifyItemChanged ??????????????? RecyclerView item???????????? ?????????
                        mHomeAdapter?.notifyItemChanged(oldSize - 1)
                        mHomeAdapter?.notifyItemRangeInserted(oldSize, homeItemList.size)
                    }
                }
                //??????
                INSERT -> {}
                //??????
                REMOVE -> {}
                //??????
                UPDATE -> {}
                else -> {}
            }
        })
        //???????????????????????????
        mViewModel?.mCollectedStatusEvent?.observe(viewLifecycleOwner, Observer { sparseArray ->
            //????????????????????????  true:??????  false:????????????
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

            // ???????????????????????????
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

            // ???????????????????????????
            bannerView?.resume()
        }

        if (mViewModel?.mNeedUpdateTheme == true) {
            val size = mViewModel!!.mHomeItemDataList.size

            mViewModel?.mNeedUpdateTheme = false
            if (size > 0) {
                // ????????? RecyclerView ??????????????????????????? notifyItemRangeChanged ????????????
                mHomeAdapter?.notifyItemRangeChanged(0, size, mutableMapOf<String, Any>().apply {
                    put(PART_UPDATE_FLAG, PART_UPDATE_THEME)
                })
            }
        }
    }

    /**
     * ????????????????????? (??????ViewPager)
     *
     * @return true ??????  false ??????  ????????????
     */
    override fun isEnableLazyLoad() = true

    /**
     * ???????????????
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
     * ?????? ???????????? ?????? Event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getUserInfoEvent(event: UserInfoEvent) {
        // ????????????
        mDataBinding.srlRefresh.autoRefresh()
    }

    /**
     * ?????? ?????????????????? Event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getCollectionEvent(event: ArticleCollectionEvent) {
        if (HomeFragment::class.java.name == event.fromName) {
            return
        }
//        if (TextUtils.isEmpty(event.id)) {
//            return
//        }

        //???????????????????????????????????????????????? ????????????????????????????????? ??? id ??? ?????????????????????????????? id ?????????, ??????????????????????????????
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
//            if (homeItem.getType() == HOME_SET_TO_TOP) { //????????????
//                val homeSetToTopItem = homeItem as HomeSetToTopItem
//                currentId = homeSetToTopItem.getId()
//            } else if (homeItem.getType() == HOME_ARTICLE) { //??????
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
     * ?????? ???????????? Event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getThemeEvent(event: ThemeEvent) {
        val size = mViewModel!!.mHomeItemDataList.size

        if (size > 0) {
            if (mIsVisible) {
                // ????????? RecyclerView ??????????????????????????? notifyItemRangeChanged ????????????
                mHomeAdapter?.notifyItemRangeChanged(0, size, mutableMapOf<String, Any>().apply {
                    put(PART_UPDATE_FLAG, PART_UPDATE_THEME)
                })
            } else {
                mViewModel?.mNeedUpdateTheme = true
            }
        }
    }

}