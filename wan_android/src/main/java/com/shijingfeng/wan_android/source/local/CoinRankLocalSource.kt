package com.shijingfeng.wan_android.source.local

import com.shijingfeng.base.base.application.realm
import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.base.global.runOnUiThread
import com.shijingfeng.base.http.exception.E
import com.shijingfeng.wan_android.entity.CoinRankEntity
import com.shijingfeng.wan_android.entity.CoinRankItem
import com.shijingfeng.wan_android.entity.realm.CoinRankRealm
import io.realm.RealmResults
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
 * @author ShiJingFeng
 */
internal class CoinRankLocalSource : BaseLocalSource() {

    /** 单线程 线程池 */
    private val mExecutorService = Executors.newSingleThreadExecutor()

    /**
     * 获取 积分排行榜 列表
     *
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getCoinRankList(onSuccess: onSuccess<CoinRankEntity?>, onFailure: onFailure) {
        mExecutorService.execute {
            try {
                val results = realm.where<CoinRankRealm>().findAll()
                val coinRank = CoinRankEntity()

                results?.forEach { coinRankRealm ->
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
                    onFailure(E(throwable = e))
                }
            } finally {
                // 关闭 Realm 数据库
                if (!realm.isClosed) {
                    realm.close()
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
        onSuccess: onSuccess<List<CoinRankItem>>,
        onFailure: onFailure
    ) {
        realm.executeTransactionAsync({
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
            onSuccess(coinRankList)
        }, { throwable ->
            // 失败回调
            onFailure(E(throwable = throwable))
        })
    }

    /**
     * 清空
     *
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun clear(
        onSuccess: onSuccess<Any?>,
        onFailure: onFailure
    ) {
        realm.executeTransactionAsync({
            realm
                .where<CoinRankRealm>()
                .findAll()
                .deleteAllFromRealm()
        }, {
            // 成功回调
            onSuccess(null)
        }, { throwable ->
            // 失败回调
            onFailure(E(throwable = throwable))
        })
    }

    /**
     * 清除数据
     */
    override fun onCleared() {
        super.onCleared()
        // 关闭 Realm 数据库
        if (!realm.isClosed) {
            realm.close()
        }
        // 关闭线程池
        mExecutorService.shutdownNow()
    }
}