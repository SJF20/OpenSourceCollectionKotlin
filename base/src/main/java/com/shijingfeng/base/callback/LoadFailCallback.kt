package com.shijingfeng.base.callback

import com.kingja.loadsir.callback.Callback
import com.shijingfeng.base.R

/**
 * Function: 网络中断 Callback
 * Date: 2020/1/18 18:28
 * Description:
 * @author ShiJingFeng
 */
class LoadFailCallback : Callback() {

    override fun onCreateView() = R.layout.callback_load_fail

}