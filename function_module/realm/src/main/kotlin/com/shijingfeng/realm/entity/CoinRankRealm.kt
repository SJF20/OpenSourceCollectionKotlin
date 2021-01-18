package com.shijingfeng.realm.entity

import io.realm.RealmModel
import io.realm.annotations.*

/**
 * Function: 积分排行榜 Realm 实体类 集合
 * Date: 2020/5/11 14:27
 * Description:
 * Author: ShiJingFeng
 */
@RealmClass(name = "coin_rank")
open class CoinRankRealm(

    @PrimaryKey
    @Required
    @RealmField(name = "userId")
    var userId: String = "",

    @RealmField(name = "username")
    var username: String = "",

    @RealmField(name = "level")
    var level: Int = 1,

    @RealmField(name = "rank")
    var rank: Int = 1,

    @RealmField(name = "coinCount")
    var coinCount: Int = 0

) : RealmModel