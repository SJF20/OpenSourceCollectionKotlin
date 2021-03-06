package com.shijingfeng.wan_android.ui.fragment

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.SparseArray
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.ClickUtils
import com.blankj.utilcode.util.SizeUtils
import com.blankj.utilcode.util.ToastUtils
import com.kingja.loadsir.core.LoadSir
import com.shijingfeng.base.annotation.BindEventBus
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_WEB_VIEW
import com.shijingfeng.base.arouter.FRAGMENT_WAN_ANDROID_PERSONAL_COLLECTION_WEBSITE
import com.shijingfeng.base.arouter.navigation
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.util.getPositionById
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.base.widget.LinearDividerItemDecoration
import com.shijingfeng.base.widget.dialog.CommonDialog
import com.shijingfeng.skin_changer.constant.BACK_GROUND_TINT
import com.shijingfeng.skin_changer.entity.SkinAttribute
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.adapter.PersonalCollectionWebsiteAdapter
import com.shijingfeng.wan_android.base.WanAndroidBaseFragment
import com.shijingfeng.wan_android.common.constant.VIEW_WEBSITE_DETAIL
import com.shijingfeng.wan_android.common.constant.WEBSITE_ITEM_EDIT
import com.shijingfeng.wan_android.common.constant.WEBSITE_ITEM_UNCOLLECTED
import com.shijingfeng.wan_android.databinding.FragmentWanAndroidPersonalCollectionWebsiteBinding
import com.shijingfeng.wan_android.entity.event.WebsiteCollectionEvent import com.shijingfeng.wan_android.entity.PersonalCollectionWebsiteEntity
import com.shijingfeng.wan_android.view_model.PersonalCollectionWebsiteViewModel
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * ?????? PersonalCollectionWebsiteFragment ??????
 */
internal fun createPersonalCollectionWebsiteFragment() = PersonalCollectionWebsiteFragment()

/**
 * Function: ???????????? -> ?????????????????? Fragment
 * Date: 2020/3/26 20:57
 * Description:
 * Author: ShiJingFeng
 */
@Route(path = FRAGMENT_WAN_ANDROID_PERSONAL_COLLECTION_WEBSITE)
@BindEventBus
internal class PersonalCollectionWebsiteFragment : WanAndroidBaseFragment<FragmentWanAndroidPersonalCollectionWebsiteBinding, PersonalCollectionWebsiteViewModel>() {

    /** ?????????????????? ????????? */
    private var mPersonalCollectionWebsiteAdapter: PersonalCollectionWebsiteAdapter? = null

    /** ???????????? Dialog */
    private var mEditDialog: CommonDialog? = null
    /** ???????????? ContentView */
    private lateinit var mEditContentView: View
    /** ?????? ???????????? ????????? */
    private lateinit var mPersonalCollectionWebsite: PersonalCollectionWebsiteEntity
    /** ??????????????? position */
    private var mCurrentPosition = -1

    /**
     * ????????????ID
     * @return ??????ID
     */
    override fun getLayoutId() = R.layout.fragment_wan_android_personal_collection_website

    /**
     * ??????ViewModel
     * @return ViewModel
     */
    override fun getViewModel() = createViewModel(PersonalCollectionWebsiteViewModel::class.java)

    /**
     * ????????? DataBinding ??????ID ??? ??????????????? Map
     * @return DataBinding ??????SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.personalCollectionWebsiteViewModel, mViewModel)
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
            mPersonalCollectionWebsiteAdapter = PersonalCollectionWebsiteAdapter(
                activity,
                mViewModel?.mWebsiteCollectedListItemList
            )
            mDataBinding.rvContent.layoutManager = LinearLayoutManager(activity)
            mDataBinding.rvContent.adapter = mPersonalCollectionWebsiteAdapter
            mDataBinding.rvContent.addItemDecoration(LinearDividerItemDecoration())
        }

        registerLoadingView(
            view = mDataBinding.flContent,
        )
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
                    setToTopButtonVisibility(View.GONE)
                    return
                }
                if (!recyclerView.canScrollVertically(-1)) {
                    //?????????????????????
                    setToTopButtonVisibility(View.VISIBLE)
                    return
                }
                setToTopButtonVisibility(if (dy > 0) View.GONE else View.VISIBLE)
            }

        })
        // ??????
        ClickUtils.applySingleDebouncing(mDataBinding.fabToTop) {
            scrollToTop()
        }
        mPersonalCollectionWebsiteAdapter?.onItemEvent = onItemEvent@{ _, data, position, flag ->
            mCurrentPosition = position
            when (flag) {
                // ??????????????????
                VIEW_WEBSITE_DETAIL -> {
                    val personalCollectionWebsite = data as PersonalCollectionWebsiteEntity
                    val url = personalCollectionWebsite.link
                    val title = personalCollectionWebsite.name

                    if (activity == null) {
                        return@onItemEvent
                    }
                    navigation(
                        activity = activity,
                        path = ACTIVITY_WAN_ANDROID_WEB_VIEW,
                        bundle = Bundle().apply {
                            putString(URL, url)
                            putString(TITLE, title)
                        }
                    )
                }
                // ????????????
                WEBSITE_ITEM_EDIT -> {
                    mPersonalCollectionWebsite = mViewModel?.mWebsiteCollectedListItemList?.get(mCurrentPosition) ?: return@onItemEvent
                    showEditDialog()
                }
                // ??????????????????
                WEBSITE_ITEM_UNCOLLECTED -> mViewModel?.uncollected(data as String)
                else -> {}
            }
        }
    }

    /**
     * ????????? LiveData Observer
     */
    override fun initObserver() {
        super.initObserver()
        mViewModel?.mListDataChangeEvent?.observe(viewLifecycleOwner, Observer ObserverLabel@{ (type, _, _, extraData, _, indexList) ->
            when (type) {
                // ??????
                LOAD,
                // ??????
                REFRESH -> mPersonalCollectionWebsiteAdapter?.notifyDataSetChanged()
                // ??????
                REMOVE -> {
                    if (indexList.isNullOrEmpty()) {
                        return@ObserverLabel
                    }

                    val oldSize = extraData as Int
                    var minPosition = indexList[0]

                    indexList.forEach { position ->
                        if (position < minPosition) {
                            minPosition = position
                        }
                        mPersonalCollectionWebsiteAdapter?.notifyItemRemoved(position)
                    }
                    mPersonalCollectionWebsiteAdapter?.notifyItemRangeChanged(
                        minPosition,
                        oldSize - minPosition
                    )
                    ToastUtils.showShort(getStringById(R.string.??????????????????))
                }
                // ??????
                UPDATE -> {
                    if (indexList.isNullOrEmpty()) {
                        return@ObserverLabel
                    }

                    indexList.forEach { position ->
                        mPersonalCollectionWebsiteAdapter?.notifyItemChanged(position)
                    }
                }
            }
        })
    }


    /**
     * ?????? ???????????? ????????????
     * @param visibility ?????????
     */
    private fun setToTopButtonVisibility(visibility: Int) {
        if (mDataBinding.fabToTop.tag == null) {
            mDataBinding.fabToTop.tag = View.VISIBLE
        }
        if (visibility == View.VISIBLE) {
            //???????????????
            if (mDataBinding.fabToTop.tag as Int != View.VISIBLE) {
                mDataBinding.fabToTop.tag = View.VISIBLE
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
        } else if (visibility == View.GONE) {
            //??????????????????
            if (mDataBinding.fabToTop.tag as Int != View.GONE) {
                mDataBinding.fabToTop.tag = View.GONE
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
     * ?????? ???????????? Dialog
     */
    @SuppressLint("InflateParams")
    private fun showEditDialog() {
        if (activity == null || mCurrentPosition == -1) {
            return
        }

        mEditDialog?.run {
            if (!isShowing) {
                mEditContentView.findViewById<TextView>(R.id.et_website_title).text = mPersonalCollectionWebsite.name
                mEditContentView.findViewById<TextView>(R.id.et_website_link).text = mPersonalCollectionWebsite.link
                show()
            }
            return
        }

        mEditContentView = LayoutInflater.from(activity).inflate(R.layout.dialog_wan_android_personal_collection_website_edit, null)

        mEditContentView.findViewById<TextView>(R.id.et_website_title).text = mPersonalCollectionWebsite.name
        mEditContentView.findViewById<TextView>(R.id.et_website_link).text = mPersonalCollectionWebsite.link

        mEditDialog = CommonDialog.Builder(requireActivity())
            .setContentView(mEditContentView)
            .setWindowWidth(SizeUtils.dp2px(350F))
            .setGravity(Gravity.TOP, 0, SizeUtils.dp2px(45F))
            .setBackgroundDrawable(R.drawable.shape_website_edit_bg)
            .setWindowOutsideAlpha(0.7F)
            .setAnimStyle(R.style.top_dialog_anim)
            .setCancelable(true)
            .show()

        // ??????
        mEditContentView.findViewById<TextView>(R.id.tv_cancel).setOnClickListener {
            mEditDialog?.hide()
        }
        // ??????
        mEditContentView.findViewById<TextView>(R.id.tv_ensure).setOnClickListener {
            mEditDialog?.hide()
            mViewModel?.updateWebsite(HashMap<String, Any>().apply {
                put("id", mPersonalCollectionWebsite.getId())
                put("name", mEditContentView.findViewById<TextView>(R.id.et_website_title).text.toString().trim())
                put("link", mEditContentView.findViewById<TextView>(R.id.et_website_link).text.toString().trim())
            })
        }
    }

    /**
     * ????????????????????? (??????ViewPager)
     * @return true ??????  false ??????  ????????????
     */
    override fun isEnableLazyLoad() = true

    /**
     * ???????????????
     */
    override fun scrollToTop() {
        super.scrollToTop()
        mViewModel?.run {
            if (mWebsiteCollectedListItemList.isNotEmpty()) {
                mDataBinding.rvContent.smoothScrollToPosition(0)
            }
        }
    }

    /**
     * ???????????????
     */
    private fun scrollToBottom() {
        mViewModel?.run {
            if (mWebsiteCollectedListItemList.isNotEmpty()) {
                mDataBinding.rvContent.smoothScrollToPosition(mWebsiteCollectedListItemList.size - 1)
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
     * ?????? ?????????????????? Event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getWebsiteCollectionEvent(event: WebsiteCollectionEvent) {
        if (PersonalCollectionWebsiteFragment::class.java.name == event.fromName) {
            return
        }
        when (event.type) {
            // ????????????
            ADD -> {
                val personalCollectionWebsite = event.personalCollectionWebsite ?: return

                mViewModel?.run {
                    scrollToBottom()
                    mWebsiteCollectedListItemList.add(personalCollectionWebsite)
                    mPersonalCollectionWebsiteAdapter?.notifyItemRangeInserted(
                        mWebsiteCollectedListItemList.size - 1,
                        1
                    )
                }
            }
            // ????????????
            UPDATE -> {
                val personalCollectionWebsite = event.personalCollectionWebsite ?: return

                mViewModel?.run {
                    val position = getPositionById(personalCollectionWebsite.getId(), mWebsiteCollectedListItemList)

                    if (position != -1) {
                        mWebsiteCollectedListItemList[position] = personalCollectionWebsite
                        mPersonalCollectionWebsiteAdapter?.notifyItemChanged(position)
                    }
                }
            }
            // ????????????
            REMOVE -> {
                val websiteId = event.id ?: return

                mViewModel?.run {
                    val position = getPositionById(websiteId, mWebsiteCollectedListItemList)
                    val beforeRemoveSize = mWebsiteCollectedListItemList.size

                    if (position != -1) {
                        mWebsiteCollectedListItemList.removeAt(position)
                        mPersonalCollectionWebsiteAdapter?.notifyItemRangeChanged(position, beforeRemoveSize - position)
                    }
                }
            }
        }
    }

    /**
     * Fragment ????????????
     */
    override fun onDestroy() {
        super.onDestroy()
        mEditDialog?.hide()
        mEditDialog = null
    }
}