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
import com.shijingfeng.base.arouter.FRAGMENT_WAN_ANDROID_OFFICIAL_ACCOUNT_CHILD
import com.shijingfeng.base.arouter.navigation
import com.shijingfeng.base.mvvm.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.util.deserialize
import com.shijingfeng.base.util.getPositionById
import com.shijingfeng.base.widget.LinearDividerItemDecoration
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.adapter.OfficialAccountChildAdapter
import com.shijingfeng.wan_android.base.WanAndroidBaseFragment
import com.shijingfeng.wan_android.common.constant.ARTICLE_ITEM_COLLECTION
import com.shijingfeng.wan_android.common.constant.KEY_ARTICLE_ID
import com.shijingfeng.wan_android.common.constant.KEY_COLLECTED
import com.shijingfeng.wan_android.common.constant.OFFICIAL_ACCOUNT_INDEX_STR
import com.shijingfeng.wan_android.common.constant.PART_UPDATE_COLLECTION_STATUS
import com.shijingfeng.wan_android.common.constant.PART_UPDATE_FLAG
import com.shijingfeng.wan_android.common.constant.PART_UPDATE_THEME
import com.shijingfeng.wan_android.common.constant.TAB_LAYOUT_VISIBILITY
import com.shijingfeng.wan_android.common.constant.VIEW_ARTICLE_DETAIL
import com.shijingfeng.wan_android.databinding.FragmentWanAndroidOfficialAccountChildBinding
import com.shijingfeng.wan_android.entity.event.ArticleCollectionEvent
import com.shijingfeng.wan_android.entity.event.UserInfoEvent
import com.shijingfeng.wan_android.entity.OfficialAccountChildItem
import com.shijingfeng.wan_android.entity.OfficialAccountIndexEntity
import com.shijingfeng.wan_android.entity.event.ThemeEvent
import com.shijingfeng.wan_android.source.network.getOfficialAccountChildNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.getOfficialAccountChildRepositoryInstance
import com.shijingfeng.wan_android.view_model.OfficialAccountChildViewModel
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * 创建 ProjectChildFragment 实例
 */
internal fun createOfficialAccountChildFragment(bundle: Bundle) = OfficialAccountChildFragment().apply {
    arguments = bundle
}

/**
 * Function: 公众号 文章列表 Fragment
 * Date: 2020/4/29 16:26
 * Description:
 * @author ShiJingFeng
 */
@BindEventBus
@Route(path = FRAGMENT_WAN_ANDROID_OFFICIAL_ACCOUNT_CHILD)
internal class OfficialAccountChildFragment : WanAndroidBaseFragment<FragmentWanAndroidOfficialAccountChildBinding, OfficialAccountChildViewModel>() {

    /** 公众号 二级数据 列表适配器 */
    private var mOfficialAccountChildAdapter: OfficialAccountChildAdapter? = null

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel(): OfficialAccountChildViewModel? {
        val officialAccountChildRepository = getOfficialAccountChildRepositoryInstance(
            networkSource = getOfficialAccountChildNetworkSourceInstance()
        )
        val factory =
            createCommonViewModelFactory(
                repository = officialAccountChildRepository
            )

        return createViewModel(OfficialAccountChildViewModel::class.java, factory)
    }

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.officialAccountChildViewModel, mViewModel)
    }

    /**
     * 获取视图ID
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.fragment_wan_android_official_account_child

    /**
     * 初始化参数
     */
    override fun initParam() {
        super.initParam()
        mDataBundle?.run {
            val dataStr = getString(OFFICIAL_ACCOUNT_INDEX_STR, EMPTY_OBJECT)

            mViewModel?.mOfficialAccountIndex = deserialize(dataStr, OfficialAccountIndexEntity::class.java)
        }
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

        activity?.run {
            mOfficialAccountChildAdapter = OfficialAccountChildAdapter(
                this,
                mViewModel?.mOfficialAccountChildItemList
            )
            // 注意此处不要使用 rv_content 或 findViewById  否则会导致 ViewPager中相同 Fragment 类,
            // 只会显示最先出现的第一个Fragment页面, 其他为空白, 具体原因应该和 kotlin 省略findViewById写法有关,
            // 如果ViewPager中没有相同 Fragment类 则不会出现此种情况
            mDataBinding.rvContent.layoutManager = LinearLayoutManager(this)
            mDataBinding.rvContent.adapter = mOfficialAccountChildAdapter
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
//                    mOnItemEvent?.invoke(recyclerView, null, View.GONE,
//                        TAB_LAYOUT_VISIBILITY
//                    )
//                    return
//                }
                if (!recyclerView.canScrollVertically(-1)) {
                    //滑倒顶部，显示
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
        mOfficialAccountChildAdapter?.setOnItemEventListener { _, data, position, flag ->
            when (flag) {
                // 查看文章详情
                VIEW_ARTICLE_DETAIL -> {
                    val officialAccountChildItem = data as OfficialAccountChildItem

                    navigation(
                        activity = activity,
                        path = ACTIVITY_WAN_ANDROID_WEB_VIEW,
                        bundle = Bundle().apply {
                            putString(TITLE, officialAccountChildItem.title)
                            putString(URL, officialAccountChildItem.link)
                        }
                    )
                }
                //收藏或取消收藏
                ARTICLE_ITEM_COLLECTION -> {
                    mViewModel?.run {
                        val officialAccountChildItem = mViewModel!!.mOfficialAccountChildItemList[position]
                        val collected = data as Boolean

                        if (collected) {
                            //收藏
                            collected(officialAccountChildItem.getId())
                        } else {
                            //取消收藏
                            uncollected(officialAccountChildItem.getId())
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
        mViewModel?.mOfficialAccountChildDataChangeEvent?.observe(viewLifecycleOwner, Observer ObserverLabel@{ (type, _, _, extraData, knowledgeClassifyChildItemList, _) ->
            when (type) {
                // 加载, 刷新
                LOAD, REFRESH -> mOfficialAccountChildAdapter?.notifyDataSetChanged()
                // 添加
                ADD -> {
                    if (knowledgeClassifyChildItemList.isNullOrEmpty()) {
                        return@ObserverLabel
                    }

                    val oldSize = extraData as Int

                    if (oldSize <= 0) {
                        mOfficialAccountChildAdapter?.notifyDataSetChanged()
                    } else {
                        // oldSize - 1 是为了更新 oldSize下标位置 前面的Item下面的ItemDecoration
                        // 单独使用 notifyItemChanged 是为了避免 RecyclerView item更新动画 不美观
                        mOfficialAccountChildAdapter?.notifyItemChanged(oldSize - 1)
                        mOfficialAccountChildAdapter?.notifyItemRangeInserted(
                            oldSize,
                            knowledgeClassifyChildItemList.size
                        )
                    }
                }
                // 插入
                INSERT -> {}
                // 删除
                REMOVE -> {}
                // 更新
                UPDATE -> {}
                else -> {}
            }
        })
        //收藏状态改变监听器
        mViewModel?.mCollectedStatusEvent?.observe(viewLifecycleOwner, Observer { sparseArray ->
            //收藏还是取消收藏  true:收藏  false:取消收藏
            val collected = sparseArray[KEY_COLLECTED] as Boolean
            val articleId = sparseArray[KEY_ARTICLE_ID] as String
            val position = getPositionById(articleId, mViewModel?.mOfficialAccountChildItemList!!)

            if (position != -1) {
                val knowledgeClassifyChildItem = mViewModel!!.mOfficialAccountChildItemList[position]

                knowledgeClassifyChildItem.collected = collected
                mOfficialAccountChildAdapter?.notifyItemChanged(position, mutableMapOf<String, Any>().apply {
                    put(
                        PART_UPDATE_FLAG,
                        PART_UPDATE_COLLECTION_STATUS
                    )
                })
            }
        })
    }

    /**
     * 页面可见
     */
    override fun onResume() {
        super.onResume()
        if (mViewModel?.mNeedUpdateTheme == true) {
            val size = mViewModel!!.mOfficialAccountChildItemList.size

            mViewModel?.mNeedUpdateTheme = false
            if (size > 0) {
                // 考虑到 RecyclerView 的缓存问题，故使用 notifyItemRangeChanged 全局刷新
                mOfficialAccountChildAdapter?.notifyItemRangeChanged(0, size, mutableMapOf<String, Any>().apply {
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
            if (mOfficialAccountChildItemList.isNotEmpty()) {
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
     * 更新 收藏
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getCollectionEvent(event: ArticleCollectionEvent) {
        if (OfficialAccountChildFragment::class.java.name == event.fromName) {
            return
        }
//        if (TextUtils.isEmpty(event.id)) {
//            return
//        }

        //因为服务器返回字段设计问题，导致 收藏列表中被收藏的文章 的 id 和 收藏列表以外的文章的 id 不相等, 故采用全局刷新的方式
        mViewModel?.refresh()
    }

    /**
     * 获取 主题更新 Event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getThemeEvent(event: ThemeEvent) {
        val size = mViewModel!!.mOfficialAccountChildItemList.size

        if (size > 0) {
            if (mIsVisible) {
                // 考虑到 RecyclerView 的缓存问题，故使用 notifyItemRangeChanged 全局刷新
                mOfficialAccountChildAdapter?.notifyItemRangeChanged(0, size, mutableMapOf<String, Any>().apply {
                    put(PART_UPDATE_FLAG, PART_UPDATE_THEME)
                })
            } else {
                mViewModel?.mNeedUpdateTheme = true
            }
        }
    }

}