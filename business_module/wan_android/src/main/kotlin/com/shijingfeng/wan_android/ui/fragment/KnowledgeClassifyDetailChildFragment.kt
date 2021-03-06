package com.shijingfeng.wan_android.ui.fragment

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
import com.kingja.loadsir.core.LoadSir
import com.shijingfeng.base.annotation.BindEventBus
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_WEB_VIEW
import com.shijingfeng.base.arouter.FRAGMENT_WAN_ANDROID_KNOWLEDGE_CLASSIFY_DETAIL_CHILD
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
import com.shijingfeng.wan_android.adapter.KnowledgeClassifyChildAdapter
import com.shijingfeng.wan_android.base.WanAndroidBaseFragment
import com.shijingfeng.wan_android.common.constant.ARTICLE_ITEM_COLLECTION
import com.shijingfeng.wan_android.common.constant.KEY_ARTICLE_ID
import com.shijingfeng.wan_android.common.constant.KEY_COLLECTED
import com.shijingfeng.wan_android.common.constant.KNOWLEDGE_CLASSIFY_CHILDREN_STR
import com.shijingfeng.wan_android.common.constant.PART_UPDATE_COLLECTION_STATUS
import com.shijingfeng.wan_android.common.constant.PART_UPDATE_FLAG
import com.shijingfeng.wan_android.common.constant.PART_UPDATE_THEME
import com.shijingfeng.wan_android.common.constant.VIEW_ARTICLE_DETAIL
import com.shijingfeng.wan_android.databinding.FragmentWanAndroidKnowledgeClassifyDetailChildBinding
import com.shijingfeng.wan_android.entity.event.ArticleCollectionEvent
import com.shijingfeng.wan_android.entity.event.UserInfoEvent
import com.shijingfeng.wan_android.entity.KnowledgeClassifyDetailChildItem
import com.shijingfeng.wan_android.entity.KnowledgeClassifyChildren
import com.shijingfeng.wan_android.entity.event.ThemeEvent
import com.shijingfeng.wan_android.view_model.KnowledgeClassifyDetailChildViewModel
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * ?????? KnowledgeClassifyChildFragment ??????
 */
internal fun createKnowledgeClassifyDetailChildFragment(bundle: Bundle) = KnowledgeClassifyDetailChildFragment().apply {
    arguments = bundle
}

/**
 * Function: ???????????? ???????????? Fragment
 * Date: 20-4-25 ??????9:41
 * Description:
 * Author: shijingfeng
 */
@BindEventBus
@Route(path = FRAGMENT_WAN_ANDROID_KNOWLEDGE_CLASSIFY_DETAIL_CHILD)
internal class KnowledgeClassifyDetailChildFragment : WanAndroidBaseFragment<FragmentWanAndroidKnowledgeClassifyDetailChildBinding, KnowledgeClassifyDetailChildViewModel>() {

    private var mKnowledgeClassifyChildAdapter: KnowledgeClassifyChildAdapter? = null

    /**
     * ??????ViewModel
     * @return ViewModel
     */
    override fun getViewModel() = createViewModel(KnowledgeClassifyDetailChildViewModel::class.java)

    /**
     * ????????? DataBinding ??????ID ??? ??????????????? Map
     * @return DataBinding ??????SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.knowledgeClassifyChildViewModel, mViewModel)
    }

    /**
     * ????????????ID
     * @return ??????ID
     */
    override fun getLayoutId() = R.layout.fragment_wan_android_knowledge_classify_detail_child

    /**
     * ???????????????
     */
    override fun initParam() {
        super.initParam()
        mDataBundle?.run {
            val dataStr = getString(KNOWLEDGE_CLASSIFY_CHILDREN_STR, EMPTY_OBJECT)

            mViewModel?.mKnowledgeClassifyChildren = deserialize(dataStr, KnowledgeClassifyChildren::class.java)
        }
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

        activity?.run {
            mKnowledgeClassifyChildAdapter = KnowledgeClassifyChildAdapter(
                this,
                mViewModel?.mKnowledgeClassifyChildItemList
            )
            // ???????????????????????? rv_content ??? findViewById  ??????????????? ViewPager????????? Fragment ???,
            // ????????????????????????????????????Fragment??????, ???????????????, ????????????????????? kotlin ??????findViewById????????????,
            // ??????ViewPager??????????????? Fragment??? ???????????????????????????
            mDataBinding.rvContent.layoutManager = LinearLayoutManager(this)
            mDataBinding.rvContent.adapter = mKnowledgeClassifyChildAdapter
            mDataBinding.rvContent.addItemDecoration(LinearDividerItemDecoration())
        }
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
        mKnowledgeClassifyChildAdapter?.onItemEvent = { _, data, position, flag ->
            when (flag) {
                // ??????????????????????????????
                VIEW_ARTICLE_DETAIL -> {
                    val knowledgeClassifyChildItem = data as KnowledgeClassifyDetailChildItem

                    // ????????? WebViewActivity
                    navigation(
                        activity = activity,
                        path = ACTIVITY_WAN_ANDROID_WEB_VIEW,
                        bundle = Bundle().apply {
                            putString(URL, knowledgeClassifyChildItem.link)
                            putString(TITLE, knowledgeClassifyChildItem.title)
                        }
                    )
                }
                //?????? ?????? ??? ????????????
                ARTICLE_ITEM_COLLECTION -> {
                    mViewModel?.run {
                        val knowledgeClassifyChildItem = mKnowledgeClassifyChildItemList[position]
                        val collected = data as Boolean

                        if (collected) {
                            //??????
                            collected(knowledgeClassifyChildItem.getId())
                        } else {
                            //????????????
                            uncollected(knowledgeClassifyChildItem.getId())
                        }
                    }
                }
            }
        }
    }

    /**
     * ????????? LiveData Observer
     */
    override fun initObserver() {
        super.initObserver()
        //RecyclerView ???????????????????????? LiveData ?????????
        mViewModel?.mKnowledgeClassifyChildDataChangeEvent?.observe(viewLifecycleOwner, Observer ObserverLabel@{ (type, _, _, extraData, knowledgeClassifyChildItemList, _) ->
            when (type) {
                // ??????, ??????
                LOAD, REFRESH -> mKnowledgeClassifyChildAdapter?.notifyDataSetChanged()
                // ??????
                ADD -> {
                    if (knowledgeClassifyChildItemList.isNullOrEmpty()) {
                        return@ObserverLabel
                    }

                    val oldSize = extraData as Int

                    if (oldSize <= 0) {
                        mKnowledgeClassifyChildAdapter?.notifyDataSetChanged()
                    } else {
                        // oldSize - 1 ??????????????? oldSize???????????? ?????????Item?????????ItemDecoration
                        // ???????????? notifyItemChanged ??????????????? RecyclerView item???????????? ?????????
                        mKnowledgeClassifyChildAdapter?.notifyItemChanged(oldSize - 1)
                        mKnowledgeClassifyChildAdapter?.notifyItemRangeInserted(
                            oldSize,
                            knowledgeClassifyChildItemList.size
                        )
                    }
                }
                // ??????
                INSERT -> {}
                // ??????
                REMOVE -> {}
                // ??????
                UPDATE -> {}
                else -> {}
            }
        })
        //???????????????????????????
        mViewModel?.mCollectedStatusEvent?.observe(viewLifecycleOwner, Observer { sparseArray ->
            //????????????????????????  true:??????  false:????????????
            val collected = sparseArray[KEY_COLLECTED] as Boolean
            val articleId = sparseArray[KEY_ARTICLE_ID] as String
            val position = getPositionById(articleId, mViewModel?.mKnowledgeClassifyChildItemList!!)

            if (position != -1) {
                val knowledgeClassifyChildItem = mViewModel!!.mKnowledgeClassifyChildItemList[position]

                knowledgeClassifyChildItem.collected = collected
                mKnowledgeClassifyChildAdapter?.notifyItemChanged(position, mutableMapOf<String, Any>().apply {
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
            if (mKnowledgeClassifyChildItemList.isNotEmpty()) {
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

    /**
     * ?????? ???????????? ?????? Event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getUserInfoEvent(event: UserInfoEvent) {
        // ????????????
        mDataBinding.srlRefresh.autoRefresh()
    }

    /**
     * ?????? ??????
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getCollectionEvent(event: ArticleCollectionEvent) {
        if (KnowledgeClassifyDetailChildFragment::class.java.name == event.fromName) {
            return
        }
//        if (TextUtils.isEmpty(event.id)) {
//            return
//        }

        //???????????????????????????????????????????????? ????????????????????????????????? ??? id ??? ?????????????????????????????? id ?????????, ??????????????????????????????
        mViewModel?.refresh()
    }

    /**
     * ?????? ???????????? Event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getThemeEvent(event: ThemeEvent) {
        val size = mViewModel!!.mKnowledgeClassifyChildItemList.size

        if (size > 0) {
            // ????????? RecyclerView ??????????????????????????? notifyItemRangeChanged ????????????
            mKnowledgeClassifyChildAdapter?.notifyItemRangeChanged(0, size, mutableMapOf<String, Any>().apply {
                put(PART_UPDATE_FLAG, PART_UPDATE_THEME)
            })
        }
    }

}