package com.shijingfeng.base.base.activity

import android.os.Bundle
import com.shijingfeng.base.R
import com.shijingfeng.base.common.constant.NO_LAYOUT

/**
 * Function: 实现 单Activity多Fragment 架构的 Activity 基类
 * Date: 2020/3/21 12:50
 * Description:
 * Author: ShiJingFeng
 */
abstract class BaseFragmentActivity : BaseActivity() {

    /**
     * 初始化
     * @param savedInstanceState Activity重启 携带的Bundle数据
     */
    override fun init(savedInstanceState: Bundle?) {
        super.init(savedInstanceState)
        val layoutId = getLayoutId()

        if (layoutId != NO_LAYOUT) {
            setContentView(layoutId)
        }
        initParam()
        initData()
        initAction()
    }

}