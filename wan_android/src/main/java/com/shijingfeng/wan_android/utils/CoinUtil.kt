package com.shijingfeng.wan_android.utils

import com.blankj.utilcode.util.SPUtils
import com.shijingfeng.base.util.decrypt
import com.shijingfeng.base.util.deserialize
import com.shijingfeng.base.util.encrypt
import com.shijingfeng.base.util.serialize
import com.shijingfeng.wan_android.constant.COIN_INFO
import com.shijingfeng.wan_android.constant.SP_APP_NAME
import com.shijingfeng.wan_android.entity.network.CoinInfoEntity

/**
 * Function: 积分工具类
 * Date: 2020/2/3 16:09
 * Description:
 * @author ShiJingFeng
 */
internal object CoinUtil {

    /** 积分数据  */
    private var mCoinInfoEntity: CoinInfoEntity? = null

    /**
     * 更新积分信息
     * @param coinInfoEntity 新的积分信息
     */
    fun updateCoinInfo(coinInfoEntity: CoinInfoEntity) {
        mCoinInfoEntity = coinInfoEntity

        SPUtils.getInstance(SP_APP_NAME).put(COIN_INFO, encrypt(serialize(mCoinInfoEntity)))
    }

    /**
     * 获取积分信息
     * @return 积分信息
     */
    fun getCoinInfo(): CoinInfoEntity? {
        if (mCoinInfoEntity == null) {
            val encryptCoinInfoStr = SPUtils.getInstance(SP_APP_NAME).getString(COIN_INFO, "")
            val coinInfoStr: String = decrypt(encryptCoinInfoStr)

            mCoinInfoEntity = deserialize(coinInfoStr, CoinInfoEntity::class.java)
        }
        return mCoinInfoEntity
    }

}