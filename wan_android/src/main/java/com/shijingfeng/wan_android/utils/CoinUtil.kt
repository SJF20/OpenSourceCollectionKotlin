package com.shijingfeng.wan_android.utils

import com.blankj.utilcode.util.SPUtils
import com.shijingfeng.base.util.decrypt
import com.shijingfeng.base.util.deserialize
import com.shijingfeng.base.util.encrypt
import com.shijingfeng.base.util.serialize
import com.shijingfeng.wan_android.constant.COIN_INFO
import com.shijingfeng.wan_android.constant.SP_APP_NAME
import com.shijingfeng.wan_android.entity.event.CoinInfoEvent
import com.shijingfeng.wan_android.entity.network.CoinInfoEntity
import org.greenrobot.eventbus.EventBus

/**
 * Function: 积分工具类
 * Date: 2020/2/3 16:09
 * Description:
 * @author ShiJingFeng
 */
internal object CoinUtil {

    /** 积分数据  */
    private var mCoinInfo: CoinInfoEntity? = null

    var coinInfo: CoinInfoEntity?
    get() {
        if (mCoinInfo == null) {
            val encryptCoinInfoStr = SPUtils.getInstance(SP_APP_NAME).getString(COIN_INFO, "")
            val coinInfoStr: String = decrypt(encryptCoinInfoStr)

            mCoinInfo = deserialize(coinInfoStr, CoinInfoEntity::class.java)
        }
        return mCoinInfo
    }
    set(coinInfo) {
        mCoinInfo = coinInfo

        if (coinInfo == null) {
            SPUtils.getInstance(SP_APP_NAME).remove(COIN_INFO, true)
        } else {
            SPUtils.getInstance(SP_APP_NAME).put(COIN_INFO, encrypt(serialize(mCoinInfo)), true)
        }

        // 通知 积分信息数据 改变
        EventBus.getDefault().post(CoinInfoEvent())
    }

}