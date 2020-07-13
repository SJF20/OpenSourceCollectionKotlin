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
import com.shijingfeng.base.base.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.util.getPositionById
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.base.widget.LinearDividerItemDecoration
import com.shijingfeng.base.widget.dialog.CommonDialog
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.adapter.PersonalCollectionWebsiteAdapter
import com.shijingfeng.wan_android.base.WanAndroidBaseFragment
import com.shijingfeng.wan_android.common.constant.VIEW_WEBSITE_DETAIL
import com.shijingfeng.wan_android.common.constant.WEBSITE_ITEM_EDIT
import com.shijingfeng.wan_android.common.constant.WEBSITE_ITEM_UNCOLLECTED
import com.shijingfeng.wan_android.common.global.setThemeBackgroundTintList
import com.shijingfeng.wan_android.databinding.FragmentWanAndroidPersonalCollectionWebsiteBinding
import com.shijingfeng.wan_android.entity.event.WebsiteCollectionEvent import com.shijingfeng.wan_android.entity.PersonalCollectionWebsiteEntity
import com.shijingfeng.wan_android.source.network.getPersonalCollectionWebsiteNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.getPersonalCollectionWebsiteRepositoryInstance
import com.shijingfeng.wan_android.view_model.PersonalCollectionWebsiteViewModel
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * 创建 PersonalCollectionWebsiteFragment 实例
 */
internal fun createPersonalCollectionWebsiteFragment() = PersonalCollectionWebsiteFragment()

/**
 * Function: 我的收藏 -> 收藏网站列表 Fragment
 * Date: 2020/3/26 20:57
 * Description:
 * @author ShiJingFeng
 */
@Route(path = FRAGMENT_WAN_ANDROID_PERSONAL_COLLECTION_WEBSITE)
@BindEventBus
internal class PersonalCollectionWebsiteFragment : WanAndroidBaseFragment<FragmentWanAndroidPersonalCollectionWebsiteBinding, PersonalCollectionWebsiteViewModel>() {

    /** 网站收藏列表 适配器 */
    private var mPersonalCollectionWebsiteAdapter: PersonalCollectionWebsiteAdapter? = null

    /** 网站编辑 Dialog */
    private var mEditDialog: CommonDialog? = null
    /** 网站编辑 ContentView */
    private lateinit var mEditContentView: View
    /** 当前 网站编辑 实体类 */
    private lateinit var mPersonalCollectionWebsite: PersonalCollectionWebsiteEntity
    /** 当前操作的 position */
    private var mCurrentPosition = -1

    /**
     * 获取视图ID
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.fragment_wan_android_personal_collection_website

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel(): PersonalCollectionWebsiteViewModel? {
        val personalCollectionWebsiteRepository = getPersonalCollectionWebsiteRepositoryInstance(
            networkSource = getPersonalCollectionWebsiteNetworkSourceInstance()
        )
        val factory = createCommonViewModelFactory(
            repository = personalCollectionWebsiteRepository
        )

        return createViewModel(PersonalCollectionWebsiteViewModel::class.java, factory)
    }

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.personalCollectionWebsiteViewModel, mViewModel)
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

        activity?.let { activity ->
            mPersonalCollectionWebsiteAdapter = PersonalCollectionWebsiteAdapter(
                activity,
                mViewModel?.mWebsiteCollectedListItemList
            )
            mDataBinding.rvContent.layoutManager = LinearLayoutManager(activity)
            mDataBinding.rvContent.adapter = mPersonalCollectionWebsiteAdapter
            mDataBinding.rvContent.addItemDecoration(LinearDividerItemDecoration())
        }

        setThemeBackgroundTintList(
            mDataBinding.fabToTop
        )
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
        // RecyclerView滑动监听
        mDataBinding.rvContent.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1)) {
                    //滑倒最底部，隐藏
                    setToTopButtonVisibility(View.GONE)
                    return
                }
                if (!recyclerView.canScrollVertically(-1)) {
                    //滑倒顶部，显示
                    setToTopButtonVisibility(View.VISIBLE)
                    return
                }
                setToTopButtonVisibility(if (dy > 0) View.GONE else View.VISIBLE)
            }

        })
        // 置顶
        ClickUtils.applySingleDebouncing(mDataBinding.fabToTop) {
            scrollToTop()
        }
        mPersonalCollectionWebsiteAdapter?.setOnItemEventListener { _, data, position, flag ->
            mCurrentPosition = position
            when (flag) {
                // 查看网站详情
                VIEW_WEBSITE_DETAIL -> {
                    val personalCollectionWebsite = data as PersonalCollectionWebsiteEntity
                    val url = personalCollectionWebsite.link
                    val title = personalCollectionWebsite.name

                    if (activity == null) {
                        return@setOnItemEventListener
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
                // 网站编辑
                WEBSITE_ITEM_EDIT -> {
                    mPersonalCollectionWebsite = mViewModel?.mWebsiteCollectedListItemList?.get(mCurrentPosition) ?: return@setOnItemEventListener
                    showEditDialog()
                }
                // 网站取消收藏
                WEBSITE_ITEM_UNCOLLECTED -> mViewModel?.uncollected(data as String)
                else -> {}
            }
        }
    }

    /**
     * 初始化 LiveData Observer
     */
    override fun initObserver() {
        super.initObserver()
        mViewModel?.mListDataChangeEvent?.observe(viewLifecycleOwner, Observer ObserverLabel@{ (type, _, _, extraData, _, indexList) ->
            when (type) {
                // 加载
                LOAD,
                // 刷新
                REFRESH -> mPersonalCollectionWebsiteAdapter?.notifyDataSetChanged()
                // 删除
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
                    ToastUtils.showShort(getStringById(R.string.取消收藏成功))
                }
                // 更新
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
     * 设置 置顶按钮 的可见性
     * @param visibility 可见性
     */
    private fun setToTopButtonVisibility(visibility: Int) {
        if (mDataBinding.fabToTop.tag == null) {
            mDataBinding.fabToTop.tag = View.VISIBLE
        }
        if (visibility == View.VISIBLE) {
            //设置为可见
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
            //设置为不可见
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
     * 显示 网站编辑 Dialog
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

        mEditDialog = CommonDialog.Builder(activity!!)
            .setContentView(mEditContentView)
            .setWindowWidth(SizeUtils.dp2px(350F))
            .setGravity(Gravity.TOP, 0, SizeUtils.dp2px(45F))
            .setBackgroundDrawable(R.drawable.shape_website_edit_bg)
            .setWindowOutsideAlpha(0.7F)
            .setAnimStyle(R.style.top_dialog_anim)
            .setCancelable(true)
            .show()

        // 取消
        mEditContentView.findViewById<TextView>(R.id.tv_cancel).setOnClickListener {
            mEditDialog?.hide()
        }
        // 确认
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
            if (mWebsiteCollectedListItemList.isNotEmpty()) {
                mDataBinding.rvContent.smoothScrollToPosition(0)
            }
        }
    }

    /**
     * 滑动到底部
     */
    private fun scrollToBottom() {
        mViewModel?.run {
            if (mWebsiteCollectedListItemList.isNotEmpty()) {
                mDataBinding.rvContent.smoothScrollToPosition(mWebsiteCollectedListItemList.size - 1)
            }
        }
    }

    /**
     * 获取 收藏状态改变 Event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getWebsiteCollectionEvent(event: WebsiteCollectionEvent) {
        if (PersonalCollectionWebsiteFragment::class.java.name == event.fromName) {
            return
        }
        when (event.type) {
            // 添加收藏
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
            // 更新收藏
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
            // 取消收藏
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
     * Fragment 销毁回调
     */
    override fun onDestroy() {
        super.onDestroy()
        mEditDialog?.hide()
        mEditDialog = null
    }
}