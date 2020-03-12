package com.shijingfeng.wan_android.source.local

import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.wan_android.entity.network.CoinInfoEntity
import com.shijingfeng.base.common.extension.OnFailure
import com.shijingfeng.base.common.extension.OnSuccess
import com.shijingfeng.wan_android.utils.CoinUtil
import com.shijingfeng.wan_android.utils.UserUtil

/** 单例实例 */
@Volatile
private var sInstance: MainLocalSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
fun getMainLocalSourceInstance(): MainLocalSource {
    if (sInstance == null) {
        synchronized(MainLocalSource::class.java) {
            if (sInstance == null) {
                sInstance = MainLocalSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 主页 Activity 本地源
 * Date: 2020/3/10 16:21
 * Description:
 * @author ShiJingFeng
 */
class MainLocalSource : BaseLocalSource() {

    /**
     * 获取 积分信息
     * @return 积分信息实体类
     */
    fun getCoinInfo() = CoinUtil.getCoinInfo()

    /**
     * 退出登录
     */
    fun logout() {
        // 清除本地用户数据
        UserUtil.logout()
    }

}