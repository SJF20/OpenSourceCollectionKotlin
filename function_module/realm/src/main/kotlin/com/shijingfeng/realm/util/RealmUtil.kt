@file:JvmName("RealmUtil")
package com.shijingfeng.realm.util

import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Function: Realm 工具类
 * Date: 2020/5/17 9:50
 * Description:
 * Author: ShiJingFeng
 */

/** Realm 实例 */
private var realm: Realm? = null

/**
 * 创建 Realm 实例
 *
 * @return Realm 实例
 */
private fun createRealmInstance(): Realm {
    // Realm 数据库 配置
    val realmConfiguration = RealmConfiguration.Builder()
        .name("open_source_collection_kotlin.realm")
        .schemaVersion(0L)
        .allowQueriesOnUiThread(true)
        .allowWritesOnUiThread(true)
        .build()

    return Realm.getInstance(realmConfiguration)
}

/**
 * 获取 Realm 实例
 *
 * @return Realm 实例
 */
fun getRealmInstance(): Realm {
    if (realm == null) {
        realm = createRealmInstance()
    }
    return realm!!
}

/**
 * 关闭 Realm 实例
 */
fun closeRealmInstance() {
    realm?.run {
        if (!isClosed) {
            close()
            realm = null
        }
    }
}