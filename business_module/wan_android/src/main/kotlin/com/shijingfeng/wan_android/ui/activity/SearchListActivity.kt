package com.shijingfeng.wan_android.ui.activity

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.util.SparseArray
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.ClickUtils
import com.google.gson.reflect.TypeToken
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_SEARCH_LIST
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_WEB_VIEW
import com.shijingfeng.base.arouter.navigation
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.util.deserialize
import com.shijingfeng.base.util.getPositionById
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.base.widget.LinearDividerItemDecoration
import com.shijingfeng.skin_changer.constant.BACK_GROUND_TINT
import com.shijingfeng.skin_changer.entity.SkinAttribute
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.adapter.SearchListAdapter
import com.shijingfeng.wan_android.base.WanAndroidBaseActivity
import com.shijingfeng.wan_android.common.constant.*
import com.shijingfeng.wan_android.common.constant.ARTICLE_ITEM_COLLECTION
import com.shijingfeng.wan_android.common.constant.KEY_ARTICLE_ID
import com.shijingfeng.wan_android.common.constant.KEY_COLLECTED
import com.shijingfeng.wan_android.common.constant.PART_UPDATE_COLLECTION_STATUS
import com.shijingfeng.wan_android.common.constant.PART_UPDATE_FLAG
import com.shijingfeng.wan_android.common.constant.SEARCH_HOT_WORD
import com.shijingfeng.wan_android.common.constant.SEARCH_LIST_STR
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidSearchListBinding
import com.shijingfeng.wan_android.entity.SearchListItem
import com.shijingfeng.wan_android.view_model.SearchListViewModel

/**
 * Function: ???????????? Activity
 * Date: 2020/5/5 21:59
 * Description:
 * Author: ShiJingFeng
 */
@Route(path = ACTIVITY_WAN_ANDROID_SEARCH_LIST)
internal class SearchListActivity : WanAndroidBaseActivity<ActivityWanAndroidSearchListBinding, SearchListViewModel>() {

    /** ???????????? Adapter */
    private var mSearchListAdapter: SearchListAdapter? = null

    /**
     * ??????ViewModel
     * @return ViewModel
     */
    override fun getViewModel() = createViewModel(SearchListViewModel::class.java)

    /**
     * ????????? DataBinding ??????ID ??? ??????????????? Map
     * @return DataBinding ??????SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.searchListViewModel, mViewModel)
    }

    /**
     * ????????????ID
     *
     * @return ??????ID
     */
    override fun getLayoutId() = R.layout.activity_wan_android_search_list

    /**
     * ???????????????
     */
    override fun initParam() {
        super.initParam()
        mDataBundle?.run {
            val searchHotWord = getString(SEARCH_HOT_WORD, "")
            val searchListStr = getString(SEARCH_LIST_STR, EMPTY_OBJECT)

            mViewModel?.mSearchHotWord = searchHotWord
            mViewModel?.mSearchList = deserialize(searchListStr, object : TypeToken<List<SearchListItem>>() {}.type)
        }
    }

    /**
     * ???????????????
     */
    override fun initData() {
        super.initData()
        mDataBinding.includeTitleBar.tvTitle.text = mViewModel?.mSearchHotWord ?: ""

        mSmartRefreshLayout = mDataBinding.srlRefresh
        // ?????????????????????????????????????????????  true: ??????  false: ?????????
        mSmartRefreshLayout?.setEnableLoadMoreWhenContentNotFull(true)

        mSearchListAdapter = SearchListAdapter(this, mViewModel?.mSearchList)
        mDataBinding.rvContent.layoutManager = LinearLayoutManager(this)
        mDataBinding.rvContent.adapter = mSearchListAdapter
        mDataBinding.rvContent.addItemDecoration(LinearDividerItemDecoration())
    }

    /**
     * ???????????????
     */
    override fun initAction() {
        super.initAction()
        // RecyclerView????????????
        mDataBinding.rvContent.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1)) {
                    //????????????????????????
                    setToTopButtonVisibility(GONE)
                    return
                }
                if (!recyclerView.canScrollVertically(-1)) {
                    //?????????????????????
                    setToTopButtonVisibility(VISIBLE)
                    return
                }
                setToTopButtonVisibility(if (dy > 0) GONE else VISIBLE)
            }

        })
        // ??????
        ClickUtils.applySingleDebouncing(mDataBinding.fabToTop) {
            scrollToTop()
        }
        mSearchListAdapter?.onItemEvent = { _, data, position, flag ->
            when (flag) {
                // ??????????????????
                VIEW_SEARCH_DETAIL -> {
                    val searchListItem = data as SearchListItem

                    navigation(
                        activity = this,
                        path = ACTIVITY_WAN_ANDROID_WEB_VIEW,
                        bundle = Bundle().apply {
                            putString(TITLE, searchListItem.title)
                            putString(URL, searchListItem.link)
                        }
                    )
                }
                // ?????? ?????? ??? ????????????
                ARTICLE_ITEM_COLLECTION -> {
                    mViewModel?.run {
                        val searchListItem = mSearchList[position]
                        val collected = data as Boolean

                        if (collected) {
                            //??????
                            collected(searchListItem.getId())
                        } else {
                            //????????????
                            uncollected(searchListItem.getId())
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
        //??????????????????????????????
        mViewModel?.mSearchListDataChangeEvent?.observe(this, Observer Observer@{ (type, _, _, extraData, searchItemList, _) ->
            when (type) {
                //??????
                ADD -> {
                    if (searchItemList.isNullOrEmpty()) {
                        return@Observer
                    }

                    val oldSize = extraData as Int

                    if (oldSize <= 0) {
                        mSearchListAdapter?.notifyDataSetChanged()
                    } else {
                        // oldSize - 1 ??????????????? oldSize???????????? ?????????Item?????????ItemDecoration
                        // ???????????? notifyItemChanged ??????????????? RecyclerView item???????????? ?????????
                        mSearchListAdapter?.notifyItemChanged(oldSize - 1)
                        mSearchListAdapter?.notifyItemRangeInserted(oldSize, searchItemList.size)
                    }
                }
                else -> {}
            }
        })
        //???????????????????????????
        mViewModel?.mCollectedStatusEvent?.observe(this, Observer Observer@{ sparseArray ->
            //????????????????????????  true:??????  false:????????????
            val collected = sparseArray[KEY_COLLECTED] as Boolean
            val articleId = sparseArray[KEY_ARTICLE_ID] as String
            val position = getPositionById(articleId, mViewModel?.mSearchList!!)

            if (position != -1) {
                val searchItem = mViewModel!!.mSearchList[position]

                searchItem.collected = collected
                mSearchListAdapter?.notifyItemChanged(position, mutableMapOf<String, Any>().apply {
                    put(
                        PART_UPDATE_FLAG,
                        PART_UPDATE_COLLECTION_STATUS
                    )
                })
            }
        })
    }

    /**
     * ?????? ???????????? ????????????
     * @param visibility ?????????
     */
    private fun setToTopButtonVisibility(visibility: Int) {
        if (mDataBinding.fabToTop.tag == null) {
            mDataBinding.fabToTop.tag = VISIBLE
        }
        if (visibility == VISIBLE) {
            //???????????????
            if (mDataBinding.fabToTop.tag as Int != VISIBLE) {
                mDataBinding.fabToTop.tag = VISIBLE
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
        } else if (visibility == GONE) {
            //??????????????????
            if (mDataBinding.fabToTop.tag as Int != GONE) {
                mDataBinding.fabToTop.tag = GONE
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
     * ???????????????
     */
    private fun scrollToTop() {
        mViewModel?.run {
            if (mSearchList.isNotEmpty()) {
                mDataBinding.rvContent.smoothScrollToPosition(0)
            }
        }
    }

    /**
     * ???????????? (???????????????????????????)
     */
    override fun getResource() = mutableMapOf<View, List<SkinAttribute>>().apply {
        this[mDataBinding.fabToTop] = listOf(
            SkinAttribute(
                name = BACK_GROUND_TINT,
                data = getStringById(R.string.color_id_wan_android_theme_color)
            )
        )
    }

}