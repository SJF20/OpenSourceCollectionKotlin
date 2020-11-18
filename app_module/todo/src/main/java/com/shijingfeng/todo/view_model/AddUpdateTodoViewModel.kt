package com.shijingfeng.todo.view_model

import androidx.databinding.ObservableField
import com.blankj.utilcode.util.TimeUtils
import com.blankj.utilcode.util.ToastUtils
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.todo.R
import com.shijingfeng.todo.annotation.define.TodoPriority
import com.shijingfeng.todo.annotation.define.TodoType
import com.shijingfeng.todo.base.TodoBaseViewModel
import com.shijingfeng.todo.constant.PRIORITY_NOT_IMPORTANT_NOT_URGENCY
import com.shijingfeng.todo.constant.TODO_ADD
import com.shijingfeng.todo.constant.TYPE_ALL
import com.shijingfeng.todo.entity.adapter.TodoChildItem
import com.shijingfeng.todo.entity.event.DataUpdateEvent
import com.shijingfeng.todo.source.network.getAddUpdateTodoNetworkSourceInstance
import com.shijingfeng.todo.source.repository.AddUpdateTodoRepository
import com.shijingfeng.todo.source.repository.getAddUpdateTodoRepositoryInstance
import com.shijingfeng.todo.ui.activity.MAIN_NEED_TO_DO
import org.greenrobot.eventbus.EventBus

/**
 * Function:
 * Date: 2020/9/17 10:34
 * Description:
 * @author ShiJingFeng
 */
internal class AddUpdateTodoViewModel : TodoBaseViewModel<AddUpdateTodoRepository>() {

    /** 页面类型 */
    var mPageType = TODO_ADD

    /** 标题  */
    val mTitle = ObservableField("")
    /** 类型 */
    @TodoType var mType = TYPE_ALL
    /** 优先级 */
    @TodoPriority var mPriority = PRIORITY_NOT_IMPORTANT_NOT_URGENCY
    /** 待办日期 */
    var mDate = System.currentTimeMillis()

    /** 内容 */
    val mTodoChildList = mutableListOf<TodoChildItem>()

    /**
     * 获取 Repository
     * @return Repository
     */
    override fun getRepository() = getAddUpdateTodoRepositoryInstance(
        networkSource = getAddUpdateTodoNetworkSourceInstance()
    )

    /**
     * 添加 待办事项
     */
    fun addTodo() {
        val title = mTitle.get()
//        val content = mContent
        val dateStr = TimeUtils.millis2String(mDate, "yyyy-MM-dd")

        if (title.isNullOrEmpty()) {
            ToastUtils.showShort(getStringById(R.string.标题不能为空))
            return
        }
//        if (content.isNullOrEmpty()) {
//            ToastUtils.showShort(getStringById(R.string.内容不能为空))
//            return
//        }
        showLoadingView()
        mRepository?.addTodo(hashMapOf<String, Any>().apply {
            put("title", title)
//            put("content", content)
            put("date", dateStr)
            put("type", mType)
            put("priority", mPriority)
        }, onSuccess = {
            EventBus.getDefault().post(DataUpdateEvent(MAIN_NEED_TO_DO))
            hideLoadingView()
            ToastUtils.showShort(getStringById(R.string.添加成功))
            finish()
        }, onFailure = {
            hideLoadingView()
        })
    }

}