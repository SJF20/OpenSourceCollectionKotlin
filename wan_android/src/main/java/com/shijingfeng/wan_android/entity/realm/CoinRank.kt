package com.shijingfeng.wan_android.entity.realm

import com.shijingfeng.base.base.entity.BaseRealmEntity
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import io.realm.annotations.RealmField
import io.realm.annotations.Required

/**
 * Function: 积分排行榜 Realm 实体类 集合
 * Date: 2020/5/11 14:27
 * Description:
 * @author ShiJingFeng
 */
@RealmClass(name = "coin_rank")
internal open class CoinRankRealm(

    @PrimaryKey
    @Required
    @RealmField(name = "userId")
    var userId: String = "",

    @Required
    @RealmField(name = "username")
    var username: String = "",

    @RealmField(name = "level")
    var level: Int = 1,

    @RealmField(name = "rank")
    var rank: Int = 1,

    @RealmField(name = "coinCount")
    var coinCount: Int = 0

) : BaseRealmEntity()