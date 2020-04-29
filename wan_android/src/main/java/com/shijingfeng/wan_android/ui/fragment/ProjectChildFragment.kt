package com.shijingfeng.wan_android.ui.fragment

import android.os.Bundle
import android.util.SparseArray
import androidx.recyclerview.widget.LinearLayoutManager
import com.kingja.loadsir.core.LoadSir
import com.shijingfeng.base.annotation.BindEventBus
import com.shijingfeng.base.base.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.base.common.constant.EMPTY_OBJECT
import com.shijingfeng.base.common.constant.LOAD_SERVICE_LOADING
import com.shijingfeng.base.util.deserialize
import com.shijingfeng.base.widget.LinearDividerItemDecoration
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.adapter.KnowledgeClassifyChildAdapter
import com.shijingfeng.wan_android.base.WanAndroidBaseFragment
import com.shijingfeng.wan_android.constant.PROJECT_INDEX_STR
import com.shijingfeng.wan_android.databinding.FragmentWanAndroidProjectChildBinding
import com.shijingfeng.wan_android.entity.event.UserInfoEvent
import com.shijingfeng.wan_android.entity.network.ProjectIndexEntity
import com.shijingfeng.wan_android.source.network.getProjectChildNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.getProjectChildRepositoryInstance
import com.shijingfeng.wan_android.view_model.ProjectChildViewModel
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * 创建 ProjectChildFragment 实例
 */
internal fun createProjectChildFragment(bundle: Bundle) = ProjectChildFragment().apply {
    arguments = bundle
}

/**
 * Function: 项目 二级数据 Fragment
 * Date: 20-4-29 下午10:29
 * Description:
 * @author shijingfeng
 */
@BindEventBus
internal class ProjectChildFragment : WanAndroidBaseFragment<FragmentWanAndroidProjectChildBinding, ProjectChildViewModel>() {

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel(): ProjectChildViewModel? {
        val projectChildRepository = getProjectChildRepositoryInstance(
            networkSource = getProjectChildNetworkSourceInstance()
        )
        val factory = createCommonViewModelFactory(
            repository = projectChildRepository
        )

        return createViewModel(ProjectChildViewModel::class.java, factory)
    }

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.projectChildViewModel, mViewModel)
    }

    /**
     * 获取视图ID
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.fragment_wan_android_project_child

    /**
     * 初始化参数
     */
    override fun initParam() {
        super.initParam()
        mDataBundle?.run {
            val dataStr = getString(PROJECT_INDEX_STR, EMPTY_OBJECT)

            mViewModel?.mProjectIndex = deserialize(dataStr, ProjectIndexEntity::class.java)
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

//        activity?.run {
//            mProjectChildAdapter = KnowledgeClassifyChildAdapter(
//                this,
//                R.layout.adapter_item_wan_android_knowledge_classify_child,
//                mViewModel?.mProjectChildItemList
//            )
//            // 注意此处不要使用 rv_content 或 findViewById  否则会导致 ViewPager中相同 Fragment 类,
//            // 只会显示最先出现的第一个Fragment页面, 其他为空白, 具体原因应该和 kotlin 省略findViewById写法有关,
//            // 如果ViewPager中没有相同 Fragment类 则不会出现此种情况
//            mDataBinding.rvContent.layoutManager = LinearLayoutManager(this)
//            mDataBinding.rvContent.adapter = mProjectChildAdapter
//            mDataBinding.rvContent.addItemDecoration(LinearDividerItemDecoration())
//        }
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
    }

    /**
     * 初始化 LiveData Observer
     */
    override fun initObserver() {
        super.initObserver()
    }

    /**
     * 是否开启懒加载 (用于ViewPager)
     *
     * @return true 开启  false 关闭  默认关闭
     */
    override fun isEnableLazyLoad() = true

    /**
     * 获取 用户信息 改变 Event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getUserInfoEvent(event: UserInfoEvent) {
        // 自动刷新
        mDataBinding.srlRefresh.autoRefresh()
    }

}