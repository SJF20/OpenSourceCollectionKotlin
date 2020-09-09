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
import com.shijingfeng.base.base.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.util.deserialize
import com.shijingfeng.base.util.getPositionById
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.base.widget.LinearDividerItemDecoration
import com.shijingfeng.skin_changer.constant.BACK_GROUND
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
import com.shijingfeng.wan_android.source.network.getKnowledgeClassifyChildNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.getKnowledgeClassifyChildRepositoryInstance
import com.shijingfeng.wan_android.view_model.KnowledgeClassifyDetailChildViewModel
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * 创建 KnowledgeClassifyChildFragment 实例
 */
internal fun createKnowledgeClassifyDetailChildFragment(bundle: Bundle) = KnowledgeClassifyDetailChildFragment().apply {
    arguments = bundle
}

/**
 * Function: 知识体系 二级数据 Fragment
 * Date: 20-4-25 下午9:41
 * Description:
 * @author shijingfeng
 */
@BindEventBus
@Route(path = FRAGMENT_WAN_ANDROID_KNOWLEDGE_CLASSIFY_DETAIL_CHILD)
internal class KnowledgeClassifyDetailChildFragment : WanAndroidBaseFragment<FragmentWanAndroidKnowledgeClassifyDetailChildBinding, KnowledgeClassifyDetailChildViewModel>() {

    private var mKnowledgeClassifyChildAdapter: KnowledgeClassifyChildAdapter? = null

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel(): KnowledgeClassifyDetailChildViewModel? {
        val knowledgeClassifyChildRepository = getKnowledgeClassifyChildRepositoryInstance(
            networkSource = getKnowledgeClassifyChildNetworkSourceInstance()
        )
        val factory = createCommonViewModelFactory(
            repository = knowledgeClassifyChildRepository
        )

        return createViewModel(KnowledgeClassifyDetailChildViewModel::class.java, factory)
    }

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.knowledgeClassifyChildViewModel, mViewModel)
    }

    /**
     * 获取视图ID
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.fragment_wan_android_knowledge_classify_detail_child

    /**
     * 初始化参数
     */
    override fun initParam() {
        super.initParam()
        mDataBundle?.run {
            val dataStr = getString(KNOWLEDGE_CLASSIFY_CHILDREN_STR, EMPTY_OBJECT)

            mViewModel?.mKnowledgeClassifyChildren = deserialize(dataStr, KnowledgeClassifyChildren::class.java)
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
        if (mViewModel == null || !mViewModel!!.mHasInited) {
            showCallback(LOAD_SERVICE_LOADING)
        }

        activity?.run {
            mKnowledgeClassifyChildAdapter = KnowledgeClassifyChildAdapter(
                this,
                mViewModel?.mKnowledgeClassifyChildItemList
            )
            // 注意此处不要使用 rv_content 或 findViewById  否则会导致 ViewPager中相同 Fragment 类,
            // 只会显示最先出现的第一个Fragment页面, 其他为空白, 具体原因应该和 kotlin 省略findViewById写法有关,
            // 如果ViewPager中没有相同 Fragment类 则不会出现此种情况
            mDataBinding.rvContent.layoutManager = LinearLayoutManager(this)
            mDataBinding.rvContent.adapter = mKnowledgeClassifyChildAdapter
            mDataBinding.rvContent.addItemDecoration(LinearDividerItemDecoration())
        }
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
                    setToTopButtonVisibility(GONE)
                    return
                }
                if (!recyclerView.canScrollVertically(-1)) {
                    //滑倒顶部，显示
                    setToTopButtonVisibility(VISIBLE)
                    return
                }
                setToTopButtonVisibility(if (dy > 0) GONE else VISIBLE)
            }

        })
        // 置顶
        ClickUtils.applySingleDebouncing(mDataBinding.fabToTop) {
            scrollToTop()
        }
        mKnowledgeClassifyChildAdapter?.setOnItemEventListener { _, data, position, flag ->
            when (flag) {
                // 查看二级数据文章详情
                VIEW_ARTICLE_DETAIL -> {
                    val knowledgeClassifyChildItem = data as KnowledgeClassifyDetailChildItem

                    // 跳转到 WebViewActivity
                    navigation(
                        activity = activity,
                        path = ACTIVITY_WAN_ANDROID_WEB_VIEW,
                        bundle = Bundle().apply {
                            putString(URL, knowledgeClassifyChildItem.link)
                            putString(TITLE, knowledgeClassifyChildItem.title)
                        }
                    )
                }
                //文章 收藏 或 取消收藏
                ARTICLE_ITEM_COLLECTION -> {
                    mViewModel?.run {
                        val knowledgeClassifyChildItem = mKnowledgeClassifyChildItemList[position]
                        val collected = data as Boolean

                        if (collected) {
                            //收藏
                            collected(knowledgeClassifyChildItem.getId())
                        } else {
                            //取消收藏
                            uncollected(knowledgeClassifyChildItem.getId())
                        }
                    }
                }
            }
        }
    }

    /**
     * 初始化 LiveData Observer
     */
    override fun initObserver() {
        super.initObserver()
        //RecyclerView 适配器和数据列表 LiveData 监听器
        mViewModel?.mKnowledgeClassifyChildDataChangeEvent?.observe(viewLifecycleOwner, Observer ObserverLabel@{ (type, _, _, extraData, knowledgeClassifyChildItemList, _) ->
            when (type) {
                // 加载, 刷新
                LOAD, REFRESH -> mKnowledgeClassifyChildAdapter?.notifyDataSetChanged()
                // 添加
                ADD -> {
                    if (knowledgeClassifyChildItemList.isNullOrEmpty()) {
                        return@ObserverLabel
                    }

                    val oldSize = extraData as Int

                    if (oldSize <= 0) {
                        mKnowledgeClassifyChildAdapter?.notifyDataSetChanged()
                    } else {
                        // oldSize - 1 是为了更新 oldSize下标位置 前面的Item下面的ItemDecoration
                        // 单独使用 notifyItemChanged 是为了避免 RecyclerView item更新动画 不美观
                        mKnowledgeClassifyChildAdapter?.notifyItemChanged(oldSize - 1)
                        mKnowledgeClassifyChildAdapter?.notifyItemRangeInserted(
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
     * 设置 置顶按钮 的可见性
     * @param visibility 可见性
     */
    private fun setToTopButtonVisibility(visibility: Int) {
        if (mDataBinding.fabToTop.tag == null) {
            mDataBinding.fabToTop.tag = VISIBLE
        }
        if (visibility == VISIBLE) {
            //设置为可见
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
            //设置为不可见
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
            if (mKnowledgeClassifyChildItemList.isNotEmpty()) {
                mDataBinding.rvContent.smoothScrollToPosition(0)
            }
        }
    }

    /**
     * 获取资源 (用于切换主题的资源)
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
        if (KnowledgeClassifyDetailChildFragment::class.java.name == event.fromName) {
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
        val size = mViewModel!!.mKnowledgeClassifyChildItemList.size

        if (size > 0) {
            // 考虑到 RecyclerView 的缓存问题，故使用 notifyItemRangeChanged 全局刷新
            mKnowledgeClassifyChildAdapter?.notifyItemRangeChanged(0, size, mutableMapOf<String, Any>().apply {
                put(PART_UPDATE_FLAG, PART_UPDATE_THEME)
            })
        }
    }

}