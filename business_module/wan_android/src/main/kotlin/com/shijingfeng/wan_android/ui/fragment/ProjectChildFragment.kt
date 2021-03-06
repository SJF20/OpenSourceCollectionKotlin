package com.shijingfeng.wan_android.ui.fragment

import android.os.Bundle
import android.util.SparseArray
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.kingja.loadsir.core.LoadSir
import com.shijingfeng.base.annotation.BindEventBus
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_WEB_VIEW
import com.shijingfeng.base.arouter.FRAGMENT_WAN_ANDROID_PROJECT_CHILD
import com.shijingfeng.base.arouter.navigation
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.util.deserialize
import com.shijingfeng.base.util.getPositionById
import com.shijingfeng.base.widget.LinearDividerItemDecoration
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.adapter.ProjectChildAdapter
import com.shijingfeng.wan_android.base.WanAndroidBaseFragment
import com.shijingfeng.wan_android.common.constant.ARTICLE_ITEM_COLLECTION
import com.shijingfeng.wan_android.common.constant.KEY_ARTICLE_ID
import com.shijingfeng.wan_android.common.constant.KEY_COLLECTED
import com.shijingfeng.wan_android.common.constant.PART_UPDATE_COLLECTION_STATUS
import com.shijingfeng.wan_android.common.constant.PART_UPDATE_FLAG
import com.shijingfeng.wan_android.common.constant.PART_UPDATE_THEME
import com.shijingfeng.wan_android.common.constant.PROJECT_INDEX_STR
import com.shijingfeng.wan_android.common.constant.TAB_LAYOUT_VISIBILITY
import com.shijingfeng.wan_android.common.constant.VIEW_ARTICLE_DETAIL
import com.shijingfeng.wan_android.databinding.FragmentWanAndroidProjectChildBinding
import com.shijingfeng.wan_android.entity.event.ArticleCollectionEvent
import com.shijingfeng.wan_android.entity.event.UserInfoEvent
import com.shijingfeng.wan_android.entity.ProjectChildItem
import com.shijingfeng.wan_android.entity.ProjectIndexEntity
import com.shijingfeng.wan_android.entity.event.ThemeEvent
import com.shijingfeng.wan_android.view_model.ProjectChildViewModel
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * ?????? ProjectChildFragment ??????
 */
internal fun createProjectChildFragment(bundle: Bundle) = ProjectChildFragment().apply {
    arguments = bundle
}

/**
 * Function: ?????? ???????????? Fragment
 * Date: 20-4-29 ??????10:29
 * Description:
 * Author: shijingfeng
 */
@BindEventBus
@Route(path = FRAGMENT_WAN_ANDROID_PROJECT_CHILD)
internal class ProjectChildFragment : WanAndroidBaseFragment<FragmentWanAndroidProjectChildBinding, ProjectChildViewModel>() {

    /** ?????? ???????????? ??????????????? */
    private var mProjectChildAdapter: ProjectChildAdapter? = null

    /**
     * ??????ViewModel
     * @return ViewModel
     */
    override fun getViewModel() = createViewModel(ProjectChildViewModel::class.java)

    /**
     * ????????? DataBinding ??????ID ??? ??????????????? Map
     * @return DataBinding ??????SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.projectChildViewModel, mViewModel)
    }

    /**
     * ????????????ID
     * @return ??????ID
     */
    override fun getLayoutId() = R.layout.fragment_wan_android_project_child

    /**
     * ???????????????
     */
    override fun initParam() {
        super.initParam()
        mDataBundle?.run {
            val dataStr = getString(PROJECT_INDEX_STR, EMPTY_OBJECT)

            mViewModel?.mProjectIndex = deserialize(dataStr, ProjectIndexEntity::class.java)
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
            mProjectChildAdapter = ProjectChildAdapter(
                this,
                mViewModel?.mProjectChildItemList
            )
            // ???????????????????????? rv_content ??? findViewById  ??????????????? ViewPager????????? Fragment ???,
            // ????????????????????????????????????Fragment??????, ???????????????, ????????????????????? kotlin ??????findViewById????????????,
            // ??????ViewPager??????????????? Fragment??? ???????????????????????????
            mDataBinding.rvContent.layoutManager = LinearLayoutManager(this)
            mDataBinding.rvContent.adapter = mProjectChildAdapter
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
//                    mOnItemEvent?.invoke(recyclerView, null, View.GONE,
//                        TAB_LAYOUT_VISIBILITY
//                    )
//                    return
//                }
                if (!recyclerView.canScrollVertically(-1)) {
                    //?????????????????????
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
        mProjectChildAdapter?.onItemEvent = { _, data, position, flag ->
            when (flag) {
                // ??????????????????
                VIEW_ARTICLE_DETAIL -> {
                    val projectChildItem = data as ProjectChildItem

                    navigation(
                        activity = activity,
                        path = ACTIVITY_WAN_ANDROID_WEB_VIEW,
                        bundle = Bundle().apply {
                            putString(TITLE, projectChildItem.title)
                            putString(URL, projectChildItem.link)
                        }
                    )
                }
                //?????????????????????
                ARTICLE_ITEM_COLLECTION -> {
                    mViewModel?.run {
                        val projectChildItem = mViewModel!!.mProjectChildItemList[position]
                        val collected = data as Boolean

                        if (collected) {
                            //??????
                            collected(projectChildItem.getId())
                        } else {
                            //????????????
                            uncollected(projectChildItem.getId())
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
        mViewModel?.mProjectChildDataChangeEvent?.observe(viewLifecycleOwner, Observer ObserverLabel@{ (type, _, _, extraData, knowledgeClassifyChildItemList, _) ->
            when (type) {
                // ??????, ??????
                LOAD, REFRESH -> mProjectChildAdapter?.notifyDataSetChanged()
                // ??????
                ADD -> {
                    if (knowledgeClassifyChildItemList.isNullOrEmpty()) {
                        return@ObserverLabel
                    }

                    val oldSize = extraData as Int

                    if (oldSize <= 0) {
                        mProjectChildAdapter?.notifyDataSetChanged()
                    } else {
                        // oldSize - 1 ??????????????? oldSize???????????? ?????????Item?????????ItemDecoration
                        // ???????????? notifyItemChanged ??????????????? RecyclerView item???????????? ?????????
                        mProjectChildAdapter?.notifyItemChanged(oldSize - 1)
                        mProjectChildAdapter?.notifyItemRangeInserted(
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
            val position = getPositionById(articleId, mViewModel?.mProjectChildItemList!!)

            if (position != -1) {
                val knowledgeClassifyChildItem = mViewModel!!.mProjectChildItemList[position]

                knowledgeClassifyChildItem.collected = collected
                mProjectChildAdapter?.notifyItemChanged(position, mutableMapOf<String, Any>().apply {
                    put(
                        PART_UPDATE_FLAG,
                        PART_UPDATE_COLLECTION_STATUS
                    )
                })
            }
        })
    }

    /**
     * ????????????
     */
    override fun onResume() {
        super.onResume()
        if (mViewModel?.mNeedUpdateTheme == true) {
            val size = mViewModel!!.mProjectChildItemList.size

            mViewModel?.mNeedUpdateTheme = false
            if (size > 0) {
                // ????????? RecyclerView ??????????????????????????? notifyItemRangeChanged ????????????
                mProjectChildAdapter?.notifyItemRangeChanged(0, size, mutableMapOf<String, Any>().apply {
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
            if (mProjectChildItemList.isNotEmpty()) {
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
     * ?????? ??????
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getCollectionEvent(event: ArticleCollectionEvent) {
        if (ProjectChildFragment::class.java.name == event.fromName) {
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
        val size = mViewModel!!.mProjectChildItemList.size

        if (size > 0) {
            if (mIsVisible) {
                // ????????? RecyclerView ??????????????????????????? notifyItemRangeChanged ????????????
                mProjectChildAdapter?.notifyItemRangeChanged(0, size, mutableMapOf<String, Any>().apply {
                    put(PART_UPDATE_FLAG, PART_UPDATE_THEME)
                })
            } else {
                mViewModel?.mNeedUpdateTheme = true
            }
        }
    }

}