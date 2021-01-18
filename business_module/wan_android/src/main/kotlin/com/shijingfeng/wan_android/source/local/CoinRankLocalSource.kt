package com.shijingfeng.wan_android.source.local

import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.base.common.constant.DATA_SOURCE_LOCAL
import com.shijingfeng.network.extension.onFailure
import com.shijingfeng.network.extension.onSuccess
import com.shijingfeng.base.common.global.runOnUiThread
import com.shijingfeng.network.http.exception.E
import com.shijingfeng.realm.entity.CoinRankRealm
import com.shijingfeng.realm.util.closeRealmInstance
import com.shijingfeng.realm.util.getRealmInstance
import com.shijingfeng.wan_android.entity.CoinRankEntity
import com.shijingfeng.wan_android.entity.CoinRankItem
import io.realm.kotlin.where
import java.util.concurrent.Executors

/** 单例实例 */
@Volatile
private var sInstance: CoinRankLocalSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getCoinRankLocalSourceInstance(): CoinRankLocalSource {
    if (sInstance == null) {
        synchronized(CoinRankLocalSource::class.java) {
            if (sInstance == null) {
                sInstance = CoinRankLocalSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 积分排行榜 本地源
 * Date: 2020/5/11 14:53
 * Description:
 * Author: ShiJingFeng
 */
internal class CoinRankLocalSource : BaseLocalSource() {

    /** 线程池 */
    private val mExecutorService = Executors.newCachedThreadPool()

    /**
     * 获取 积分排行榜 列表
     *
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getCoinRankList(onSuccess: onSuccess<CoinRankEntity?>, onFailure: onFailure) {
        getRealmInstance().executeTransactionAsync { realm ->
            try {
                val results = realm.where<CoinRankRealm>().findAll()
                val coinRank = CoinRankEntity()

                coinRank.dataSource = DATA_SOURCE_LOCAL
                results.forEach { coinRankRealm ->
                    coinRank.coinRankItemList.add(CoinRankItem().apply {
                        userId = coinRankRealm.userId
                        username = coinRankRealm.username
                        level = coinRankRealm.level
                        rank = coinRankRealm.rank
                        coinCount = coinRankRealm.coinCount
                    })
                }
                runOnUiThread {
                    onSuccess(coinRank)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                runOnUiThread {
                    onFailure(E(error = e))
                }
            }
        }
    }

    /**
     * 添加 积分排行榜 列表
     *
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun addCoinRankList(
        coinRankList: List<CoinRankItem>,
        onSuccess: onSuccess<List<CoinRankItem>>? = null,
        onFailure: onFailure? = null
    ) {
        getRealmInstance().executeTransactionAsync({ realm ->
            val coinRankRealmList = coinRankList.map { coinRankItem ->
                CoinRankRealm().apply {
                    userId = coinRankItem.userId
                    username = coinRankItem.username
                    level = coinRankItem.level
                    rank = coinRankItem.rank
                    coinCount = coinRankItem.coinCount
                }
            }

            realm.copyToRealmOrUpdate(coinRankRealmList)
        }, {
            // 成功回调
            onSuccess?.invoke(coinRankList)
        }, { throwable ->
            // 失败回调
            onFailure?.invoke(E(error = throwable))
        })
    }

    /**
     * 清空
     *
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun clear(
        onSuccess: onSuccess<Any?>? = null,
        onFailure: onFailure? = null
    ) {
        getRealmInstance().executeTransactionAsync({ realm ->
            realm
                .where<CoinRankRealm>()
                .findAll()
                .deleteAllFromRealm()
        }, {
            // 成功回调
            onSuccess?.invoke(null)
        }, { throwable ->
            // 失败回调
            onFailure?.invoke(E(error = throwable))
        })
    }

    /**
     * 清除数据
     */
    override fun onCleared() {
        super.onCleared()
        // 关闭线程池
        mExecutorService.shutdown()
        // 关闭 Realm 数据库
        closeRealmInstance()
    }
}