package com.shijingfeng.base.base.activity

import android.os.Bundle

/**
 * Function: 实现 单Activity多Fragment 架构的 Activity 基类
 * Date: 2020/3/21 12:50
 * Description:
 * @author ShiJingFeng
 */
abstract class BaseFragmentActivity : BaseActivity() {

    /**
     * 初始化
     * @param savedInstanceState Activity重启 携带的Bundle数据
     */
    override fun init(savedInstanceState: Bundle?) {
        super.init(savedInstanceState)
        initStatusBar()
        setContentView(getLayoutId())
        initParam()
        initData()
        initAction()
    }

}