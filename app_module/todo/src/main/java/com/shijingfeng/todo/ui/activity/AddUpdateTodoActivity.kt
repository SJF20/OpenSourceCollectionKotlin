package com.shijingfeng.todo.ui.activity

import android.util.SparseArray
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.GsonUtils
import com.shijingfeng.base.arouter.ACTIVITY_ADD_UPDATE_TODO
import com.shijingfeng.base.base.adapter.support.MultiItemTypeSupport
import com.shijingfeng.base.base.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.base.common.constant.EMPTY_ARRAY
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.todo.BR
import com.shijingfeng.todo.R
import com.shijingfeng.todo.adapter.TodoChildAdapter
import com.shijingfeng.todo.annotation.define.TodoChildType.ITEM_TYPE_IMAGE
import com.shijingfeng.todo.annotation.define.TodoChildType.ITEM_TYPE_TEXT
import com.shijingfeng.todo.annotation.define.TodoType
import com.shijingfeng.todo.base.TodoBaseActivity
import com.shijingfeng.todo.constant.*
import com.shijingfeng.todo.constant.PAGE_TYPE
import com.shijingfeng.todo.constant.TYPE
import com.shijingfeng.todo.constant.TYPE_ALL
import com.shijingfeng.todo.constant.TYPE_LIFE
import com.shijingfeng.todo.constant.TYPE_STUDY
import com.shijingfeng.todo.constant.TYPE_WORK
import com.shijingfeng.todo.databinding.ActivityTodoAddUpdateTodoBinding
import com.shijingfeng.todo.entity.adapter.TodoChildItem
import com.shijingfeng.todo.source.network.getAddUpdateTodoNetworkSourceInstance
import com.shijingfeng.todo.source.repository.getAddUpdateTodoRepositoryInstance
import com.shijingfeng.todo.view_model.AddUpdateTodoViewModel
import okhttp3.internal.EMPTY_BYTE_ARRAY

/**
 * Function: 添加 待办事项 Activity
 * Date: 2020/5/17 16:22
 * Description:
 * @author ShiJingFeng
 */
@Route(path = ACTIVITY_ADD_UPDATE_TODO)
internal class AddUpdateTodoActivity : TodoBaseActivity<ActivityTodoAddUpdateTodoBinding, AddUpdateTodoViewModel>() {

    /** Item Child 适配器 */
    private var mTodoChildAdapter: TodoChildAdapter? = null
    /** Item Child 列表 */
    private val mTodoChildItemList = mutableListOf<TodoChildItem>()

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel(): AddUpdateTodoViewModel? {
        val repository = getAddUpdateTodoRepositoryInstance(
            networkSource = getAddUpdateTodoNetworkSourceInstance()
        )
        val factory = createCommonViewModelFactory(
            repository = repository
        )

        return createViewModel(AddUpdateTodoViewModel::class.java, factory)
    }

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.addUpdateTodoViewModel, mViewModel)
    }

    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.activity_todo_add_update_todo

    /**
     * 初始化参数
     */
    override fun initParam() {
        super.initParam()
        mDataBundle?.run {
            mViewModel?.mPageType = getInt(PAGE_TYPE, TODO_ADD)
            mViewModel?.mType = getInt(TYPE, TYPE_ALL)

            val todoChildItemListStr = getString(TODO_CHILD_LIST_STR, EMPTY_ARRAY)
            val todoChildItemList = GsonUtils.fromJson<List<TodoChildItem>>()
        }
    }

    /**
     * 初始化数据
     */
    override fun initData() {
        super.initData()
        setType(mViewModel!!.mType)
        mTodoChildAdapter = TodoChildAdapter(
            context = this,
            dataList = mTodoChildItemList,
            multiItemTypeSupport = object : MultiItemTypeSupport<TodoChildItem> {

                /**
                 * 根据 Item类型 获取 Layout Id
                 * @param itemType Item类型
                 * @return Layout Id
                 */
                override fun getLayoutId(itemType: Int) = when (itemType) {
                    // 文本
                    ITEM_TYPE_TEXT -> R.layout.adapter_item_todo_todo_child_text
                    // 其他 (图片, 视频, 音频等等)
                    ITEM_TYPE_IMAGE -> R.layout.adapter_item_todo_todo_child_other
                    else -> 0
                }

                /**
                 * 获取 Item类型
                 * @param position 下标位置
                 * @param data 数据
                 * @return Item类型
                 */
                override fun getItemViewType(position: Int, data: TodoChildItem) = data.getType()

            }
        )
        mDataBinding.rvItemList.adapter = mTodoChildAdapter
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
        mTodoChildAdapter?.setOnItemEventListener { view, data, position, flag ->
            when (flag) {
                // 删除Item
                REMOVE_ITEM -> {

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
    }

    /**
     * 设置类型
     */
    private fun setType(@TodoType type: Int) {
        mViewModel?.mType = type
        when (type) {
            // 全部
            TYPE_ALL -> mDataBinding.tvType.text = getStringById(R.string.全部)
            // 学习
            TYPE_STUDY -> mDataBinding.tvType.text = getStringById(R.string.学习)
            // 工作
            TYPE_WORK -> mDataBinding.tvType.text = getStringById(R.string.工作)
            // 生活
            TYPE_LIFE -> mDataBinding.tvType.text = getStringById(R.string.生活)
            else -> mDataBinding.tvType.text = getStringById(R.string.全部)
        }
    }

}