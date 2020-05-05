package com.shijingfeng.wan_android.view_model

import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
import com.shijingfeng.wan_android.source.repository.SearchListRepository

/**
 * Function: 搜索列表 ViewModel
 * Date: 20-5-3 下午9:26
 * Description:
 * @author shijingfeng
 */
internal class SearchListViewModel(
    repository: SearchListRepository? = null
) : WanAndroidBaseViewModel<SearchListRepository>(repository) {

    /**
     * 初始化
     */
    override fun init() {
        super.init()
    }

    /**
     * 获取搜索数据
     */
    private fun getSearchData() {

    }

}