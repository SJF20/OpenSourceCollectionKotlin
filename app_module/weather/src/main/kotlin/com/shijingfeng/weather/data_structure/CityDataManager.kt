package com.shijingfeng.weather.data_structure

import com.shijingfeng.base.common.extension.move
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.base.common.extension.swap
import com.shijingfeng.base.common.global.runOnUiThread
import com.shijingfeng.base.http.exception.E
import com.shijingfeng.weather.common.constant.CITY_DATA_OPERATE_ADD
import com.shijingfeng.weather.common.constant.CITY_DATA_OPERATE_MOVE
import com.shijingfeng.weather.common.constant.CITY_DATA_OPERATE_REMOVE
import com.shijingfeng.weather.common.constant.CITY_DATA_OPERATE_SWAP
import com.shijingfeng.weather.common.constant.CITY_DATA_OPERATE_UPDATE
import com.shijingfeng.weather.entity.CityDataItem
import com.shijingfeng.weather.entity.event.CityDataChangeEvent
import com.shijingfeng.weather.entity.realm.CityDataRealm
import com.shijingfeng.weather.util.getRealmInstance
import io.realm.RealmAsyncTask
import io.realm.kotlin.where
import org.greenrobot.eventbus.EventBus
import java.util.*
import kotlin.IllegalArgumentException

/**
 * Function: 城市数据 管理器
 * Date: 2020/10/31 16:53
 * Description:
 * @author ShiJingFeng
 */
internal class CityDataManager private constructor() {

    /** 城市数据 Map (Key: 城市代码, 对应高德中的adCode  Value: 城市数据), 因为散列表检索时间复杂度为O(1), 故用于检索城市数据 */
    private val mCityDataMap = hashMapOf<String, CityDataItem>()

    /** 城市数据列表 */
    private val mCityDataList = LinkedList<CityDataItem>()

    companion object {

        /**
         * 异步初始化获取数据
         *
         * @param onSuccess 初始化成功
         * @param onFailure 初始化失败
         */
        fun init(
            onSuccess: onSuccess<CityDataManager>? = null,
            onFailure: onFailure? = null
        ) {
            getRealmInstance().executeTransaction { realm ->
                try {
                    val cityDataResults = realm.where<CityDataRealm>().findAll()
                    val cityDataList = CityDataManager().apply {
                        mCityDataMap.clear()
                        mCityDataList.clear()
                        cityDataResults.forEach { cityDataRealm ->
                            val cityData = cityDataRealm.toCityDataItem()

                            mCityDataMap[cityDataRealm.cityCode] = cityData
                            mCityDataList.add(cityData)
                        }
                    }

                    runOnUiThread {
                        onSuccess?.invoke(cityDataList)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    runOnUiThread {
                        onFailure?.invoke(
                            E(
                                error = e
                            )
                        )
                    }
                }
            }
        }

    }

    /**
     * 通过 城市代码 获取 下标
     */
    fun getIndex(
        cityCode: String
    ): Int {
        if (cityCode.isEmpty()) {
            return -1
        }
        mCityDataList.forEachIndexed { index, cityData ->
            if (cityCode == cityData.getId()) {
                return index
            }
        }
        return -1
    }

    /**
     * 通过 城市代码 获取 城市数据
     */
    fun getCityData(
        cityCode: String
    ): CityDataItem? {
        if (cityCode.isEmpty()) {
            return null
        }
        return mCityDataMap[cityCode]
    }

    /**
     * 获取可读不可写的城市数据列表
     * 注意: 严格来说，在外部不可以进行列表的增删，但是可以更新列表中的 [CityDataItem] 数据
     * 但 [CityDataItem] 已被设置为可读不可写, 故 [CityDataItem] 数据在外部也不可更新
     */
    val dataList: List<CityDataItem>
        get() = mCityDataList

    /**
     * 城市数据列表中 是否包含 该城市代码的城市数据
     *
     * @param cityCode 城市代码
     */
    fun contains(
        cityCode: String
    ): Boolean {
        if (cityCode.isEmpty()) {
            return false
        }

        return mCityDataMap.contains(cityCode)
    }

    /**
     * 添加
     *
     * @param cityData 要添加的数据
     * @param index 要插入到的下标 (默认添加到列表尾部)
     * @param isAsync 是否异步添加  true: 异步添加  false: 同步添加
     * @param onSuccess 异步添加成功回调 (异步添加有效), 注意在回调中UI操作要判空处理
     * @param onFailure 异步添加失败回调 (异步添加有效), 注意在回调中UI操作要判空处理
     */
    fun add(
        cityData: CityDataItem,
        index: Int = mCityDataList.size,
        isAsync: Boolean = true,
        onSuccess: onSuccess<List<CityDataItem>>? = null,
        onFailure: onFailure? = null
    ) {
        // 0下标数据是当前定位的数据项，恒定在0下标位置
        if (index < 1 || index > mCityDataList.size) {
            throw IllegalArgumentException("索引下标必须 大于等于1 或 小于等于列表的长度")
        }
        // 数据不完整，则不添加
        if (!cityData.isValid()) {
            throw IllegalArgumentException("城市数据不完整")
        }
        // 内存中缓存
        mCityDataList.add(index, cityData)
        mCityDataMap[cityData.cityCode] = cityData

        val cityDataRealm = CityDataRealm(
            cityCode = cityData.cityCode,
            longitude = cityData.longitude!!,
            latitude = cityData.latitude!!,
            cityName = cityData.cityName!!,
            cityFullName = cityData.cityFullName!!,
            weatherType = cityData.weatherType!!,
            weatherDesc = cityData.weatherDesc!!,
            curTemp = cityData.curTemp!!,
            lowestTemp = cityData.lowestTemp!!,
            highestTemp = cityData.highestTemp!!,
            weatherData = cityData.weatherData!!
        )

        // 数据库中缓存
        if (isAsync) {
            // 异步添加
            getRealmInstance().executeTransactionAsync({ realm ->
                realm.copyToRealmOrUpdate(cityDataRealm)
            }, {
                // 成功回调
                onSuccess?.invoke(mCityDataList)
            }, { throwable ->
                // 失败回调
                onFailure?.invoke(E(error = throwable))
            })
        } else {
            // 同步添加
            getRealmInstance().executeTransaction { realm ->
                realm.copyToRealmOrUpdate(cityDataRealm)
            }
        }
        // 通知视图更新
        EventBus.getDefault().post(
            CityDataChangeEvent(
                type = CITY_DATA_OPERATE_ADD,
                indexList = listOf(index)
            )
        )
    }

    /**
     * 批量添加
     *
     * @param cityDataMap 城市数据Map,  Key: 索引下标  Value: 城市数据
     * @param isAsync 是否异步添加  true: 异步添加  false: 同步添加
     * @param onSuccess 异步全部添加成功回调 (异步添加有效), 注意在回调中UI操作要判空处理
     * @param onFailure 异步全部添加失败回调 (异步添加有效), 注意在回调中UI操作要判空处理
     */
    fun add(
        cityDataMap: Map<Int, CityDataItem>,
        isAsync: Boolean = true,
        onSuccess: onSuccess<List<CityDataItem>>? = null,
        onFailure: onFailure? = null
    ) {
        if (cityDataMap.isEmpty()) {
            throw IllegalArgumentException("城市数据列表不能为空列表")
        }
        // 检查下标有效性 和 数据完整性
        cityDataMap.forEach { entry ->
            val index = entry.key
            val cityData = entry.value

            // 0下标数据是当前定位的数据项，恒定在0下标位置
            if (index < 1 || index > mCityDataList.size) {
                throw IllegalArgumentException("索引下标必须 大于等于1 或 小于等于列表的长度")
            }
            // 数据不完整，则不添加
            if (!cityData.isValid()) {
                throw IllegalArgumentException("城市数据不完整")
            }
        }

        val indexList = mutableListOf<Int>()
        val sortedCityDataMap = TreeMap<Int, CityDataItem> { key1, key2 ->
            // 从大到小排序
            key2 - key1
        }
        val cityDataRealmList = mutableListOf<CityDataRealm>()

        sortedCityDataMap.putAll(cityDataMap)
        sortedCityDataMap.forEach { entry ->
            val index = entry.key
            val cityData = entry.value

            indexList.add(index)
            mCityDataList.add(index, cityData)
            mCityDataMap[cityData.cityCode] = cityData
            cityDataRealmList.add(CityDataRealm(
                cityCode = cityData.cityCode,
                longitude = cityData.longitude!!,
                latitude = cityData.latitude!!,
                cityName = cityData.cityName!!,
                cityFullName = cityData.cityFullName!!,
                weatherType = cityData.weatherType!!,
                weatherDesc = cityData.weatherDesc!!,
                curTemp = cityData.curTemp!!,
                lowestTemp = cityData.lowestTemp!!,
                highestTemp = cityData.highestTemp!!,
                weatherData = cityData.weatherData!!
            ))
        }

        if (isAsync) {
            // 异步操作
            getRealmInstance().executeTransactionAsync({ realm ->
                realm.insertOrUpdate(cityDataRealmList)
            }, {
                // 成功回调
                onSuccess?.invoke(mCityDataList)
            }, { throwable ->
                // 失败回调
                onFailure?.invoke(E(error = throwable))
            })
        } else {
            // 同步操作
            getRealmInstance().executeTransaction { realm ->
                realm.insertOrUpdate(cityDataRealmList)
            }
        }
        EventBus.getDefault().post(
            CityDataChangeEvent(
                type = CITY_DATA_OPERATE_ADD,
                indexList = indexList
            )
        )
    }

    /**
     * 添加列表
     *
     * @param cityDataList 城市数据列表
     * @param index 要插入到的下标 (默认添加到列表尾部)
     * @param isAsync 是否异步添加  true: 异步添加  false: 同步添加
     * @param onSuccess 异步全部添加成功回调 (异步添加有效), 注意在回调中UI操作要判空处理
     * @param onFailure 异步全部添加失败回调 (异步添加有效), 注意在回调中UI操作要判空处理
     */
    fun addAll(
        cityDataList: List<CityDataItem>,
        index: Int = mCityDataList.size,
        isAsync: Boolean = true,
        onSuccess: onSuccess<List<CityDataItem>>? = null,
        onFailure: onFailure? = null
    ) {
        // 0下标数据是当前定位的数据项，恒定在0下标位置
        if (index < 1 || index > mCityDataList.size) {
            throw IllegalArgumentException("索引下标必须 大于等于1 或 小于等于列表的长度")
        }

        val indexList = mutableListOf<Int>()
        var curIndex = index
        val cityDataRealmList = mutableListOf<CityDataRealm>()

        // 过滤掉数据不完整的实体类
        cityDataList.forEach { cityData ->
            if (!cityData.isValid()) {
                throw IllegalArgumentException("城市数据不完整")
            }
            indexList.add(curIndex++)
            mCityDataMap[cityData.cityCode] = cityData
            cityDataRealmList.add(CityDataRealm(
                cityCode = cityData.cityCode,
                longitude = cityData.longitude!!,
                latitude = cityData.latitude!!,
                cityName = cityData.cityName!!,
                cityFullName = cityData.cityFullName!!,
                weatherType = cityData.weatherType!!,
                weatherDesc = cityData.weatherDesc!!,
                curTemp = cityData.curTemp!!,
                lowestTemp = cityData.lowestTemp!!,
                highestTemp = cityData.highestTemp!!,
                weatherData = cityData.weatherData!!
            ))
        }
        mCityDataList.addAll(index, cityDataList)
        if (isAsync) {
            // 异步操作
            getRealmInstance().executeTransactionAsync({ realm ->
                realm.copyToRealmOrUpdate(cityDataRealmList)
            }, {
                // 成功回调
                onSuccess?.invoke(mCityDataList)
            }, { throwable ->
                // 失败回调
                onFailure?.invoke(E(error = throwable))
            })
        } else {
            // 同步操作
            getRealmInstance().executeTransaction { realm ->
                realm.copyToRealmOrUpdate(cityDataRealmList)
            }
        }
        EventBus.getDefault().post(
            CityDataChangeEvent(
                type = CITY_DATA_OPERATE_ADD,
                indexList = indexList
            )
        )
    }

    /**
     * 更新
     *
     * @param index 要更新的索引下标
     * @param cityData 要更新的数据实体类 (如果该实体类中某字段为 null , 则不更新此字段数据)
     * @param isAsync 是否异步添加  true: 异步添加  false: 同步添加
     * @param onSuccess 异步全部添加成功回调 (异步添加有效), 注意在回调中UI操作要判空处理
     * @param onFailure 异步全部添加失败回调 (异步添加有效), 注意在回调中UI操作要判空处理
     */
    fun update(
        index: Int = -1,
        cityData: CityDataItem,
        isAsync: Boolean = true,
        onSuccess: onSuccess<List<CityDataItem>>? = null,
        onFailure: onFailure? = null
    ) {
        if (index < 0 || index > mCityDataList.size - 1) {
            throw IllegalArgumentException("索引下标必须 大于等于0 或 小于列表的长度")
        }

        val oldCityData = mCityDataList[index]
        val newCityData = CityDataItem(
            cityCode = oldCityData.cityCode,
            longitude = cityData.longitude ?: oldCityData.longitude,
            latitude = cityData.latitude ?: oldCityData.latitude,
            cityName = cityData.cityName ?: oldCityData.cityName,
            cityFullName = cityData.cityFullName ?: oldCityData.cityFullName,
            weatherType = cityData.weatherType ?: oldCityData.weatherType,
            weatherDesc = cityData.weatherDesc ?: oldCityData.weatherDesc,
            curTemp = cityData.curTemp ?: oldCityData.curTemp,
            lowestTemp = cityData.lowestTemp ?: oldCityData.lowestTemp,
            highestTemp = cityData.highestTemp ?: oldCityData.highestTemp,
            weatherData = cityData.weatherData ?: oldCityData.weatherData
        )

        mCityDataList[index] = newCityData
        mCityDataMap[oldCityData.cityCode] = newCityData
        if (isAsync) {
            // 异步操作
            getRealmInstance().executeTransactionAsync({ realm ->
                realm.insertOrUpdate(cityDataRealmList)
            }, {
                // 成功回调
                onSuccess?.invoke(mCityDataList)
            }, { throwable ->
                // 失败回调
                onFailure?.invoke(E(error = throwable))
            })
        } else {
            // 同步操作
            getRealmInstance().executeTransaction { realm ->
                realm.copyToRealmOrUpdate(cityDataRealmList)
            }
        }
        EventBus.getDefault().post(
            CityDataChangeEvent(
                type = CITY_DATA_OPERATE_UPDATE,
                indexList = listOf(index)
            )
        )
    }

    /**
     * 批量更新
     *
     * @param cityDataMap 城市数据Map,  Key: 索引下标  Value: 要更新的数据实体类 (如果该实体类中某字段为 null , 则不更新此字段数据)
     */
    fun update(
        cityDataMap: Map<Int, CityDataItem>
    ) {
        if (cityDataMap.isEmpty()) {
            throw IllegalArgumentException("城市数据散列表不能为空散列表")
        }

        val indexList = mutableListOf<Int>()

        cityDataMap.forEach { entry ->
            val index = entry.key
            val cityData = entry.value

            if (index < 0 || index > mCityDataList.size - 1) {
                throw IllegalArgumentException("索引下标必须 大于等于0 或 小于列表的长度")
            }

            val oldCityData = mCityDataList[index]
            val newCityData = CityDataItem(
                cityCode = oldCityData.cityCode,
                longitude = cityData.longitude ?: oldCityData.longitude,
                latitude = cityData.latitude ?: oldCityData.latitude,
                cityName = cityData.cityName ?: oldCityData.cityName,
                cityFullName = cityData.cityFullName ?: oldCityData.cityFullName,
                weatherType = cityData.weatherType ?: oldCityData.weatherType,
                weatherDesc = cityData.weatherDesc ?: oldCityData.weatherDesc,
                curTemp = cityData.curTemp ?: oldCityData.curTemp,
                lowestTemp = cityData.lowestTemp ?: oldCityData.lowestTemp,
                highestTemp = cityData.highestTemp ?: oldCityData.highestTemp,
                weatherData = cityData.weatherData ?: oldCityData.weatherData
            )

            indexList.add(index)
            mCityDataList[index] = newCityData
            mCityDataMap[oldCityData.cityCode] = newCityData
        }
        EventBus.getDefault().post(
            CityDataChangeEvent(
                type = CITY_DATA_OPERATE_UPDATE,
                indexList = indexList
            )
        )
    }

    /**
     * 移动元素
     *
     * @param oldIndex 旧的索引下标位置
     * @param newIndex 新的索引下标位置
     * @return true: 移动成功   false: 移动失败(不需移动)
     */
    fun move(
        oldIndex: Int,
        newIndex: Int
    ) {
        if (oldIndex == 0 || newIndex == 0) {
            // 0下标数据是当前定位的数据项，恒定在0下标位置，禁止移动操作
            throw IllegalArgumentException("索引下标不能为0, 因为0下标数据是当前定位的数据项，恒定在0下标位置，禁止移动操作")
        }

        if (mCityDataList.move(oldIndex, newIndex)) {
            EventBus.getDefault().post(
                CityDataChangeEvent(
                    type = CITY_DATA_OPERATE_MOVE,
                    indexList = listOf(oldIndex, newIndex)
                )
            )
        }
    }

    /**
     * 批量移动
     *
     * @param oldIndexList 旧的索引下标列表
     * @param newIndexList 新的索引下标列表
     */
    fun move(
        oldIndexList: List<Int>,
        newIndexList: List<Int>
    ) {
        if (oldIndexList.isEmpty() || newIndexList.isEmpty()) {
            throw IllegalArgumentException("索引下标列表不能为空列表")
        }
        if (oldIndexList.size != newIndexList.size) {
            throw IllegalArgumentException("移动前的索引下标列表 和 移动后的索引下标列表 不对应")
        }

        val indexList = mutableListOf<Int>()

        oldIndexList.forEachIndexed { index, oldIndex ->
            val newIndex = newIndexList[index]

            if (oldIndex == 0 || newIndex == 0) {
                // 0下标数据是当前定位的数据项，恒定在0下标位置，禁止移动操作
                throw IllegalArgumentException("索引下标不能为0, 因为0下标数据是当前定位的数据项，恒定在0下标位置，禁止移动操作")
            }
            if (oldIndex < 0 || oldIndex > mCityDataList.size - 1) {
                throw IllegalArgumentException("移动前的索引下标超界")
            }
            if (newIndex < 0 || newIndex > mCityDataList.size - 1) {
                throw IllegalArgumentException("移动后的索引下标超界")
            }
            if (mCityDataList.size < 2) {
                throw IllegalArgumentException("列表大小必须大于等于2")
            }
            if (mCityDataList.move(oldIndex, newIndex)) {
                indexList.add(oldIndex)
                indexList.add(newIndex)
            }
        }
        EventBus.getDefault().post(
            CityDataChangeEvent(
                type = CITY_DATA_OPERATE_MOVE,
                indexList = indexList
            )
        )
    }

    /**
     * 交换
     *
     * @param index1 第一个索引下标
     * @param index2 第二个索引下标
     */
    fun swap(
        index1: Int,
        index2: Int
    ) {
        if (index1 == 0 || index2 == 0) {
            // 0下标数据是当前定位的数据项，恒定在0下标位置，禁止移动操作
            throw IllegalArgumentException("索引下标不能为0, 因为0下标数据是当前定位的数据项，恒定在0下标位置，禁止交换操作")
        }
        if (index1 < 0 || index1 > mCityDataList.size - 1
            || index2 < 0 || index2 > mCityDataList.size - 1
        ) {
            throw IllegalArgumentException("索引下标超界")
        }
        if (mCityDataList.size < 2) {
            throw IllegalArgumentException("列表大小必须大于等于2")
        }
        if (mCityDataList.swap(index1, index2)) {
            EventBus.getDefault().post(
                CityDataChangeEvent(
                    type = CITY_DATA_OPERATE_SWAP,
                    indexList = listOf(index1, index2)
                )
            )
        }
    }

    /**
     * 批量交换
     *
     * @param oldIndexList 旧的索引下标列表
     * @param newIndexList 新的索引下标列表
     */
    fun swap(
        indexList1: List<Int>,
        indexList2: List<Int>
    ) {
        if (indexList1.isEmpty() || indexList2.isEmpty()) {
            throw IllegalArgumentException("索引下标列表不能为空列表")
        }
        if (indexList1.size != indexList2.size) {
            throw IllegalArgumentException("索引下标列表1 和 索引下标列表2 不对应")
        }

        val indexList = mutableListOf<Int>()

        indexList1.forEachIndexed { index, index1 ->
            val index2 = indexList2[index]

            if (index1 == 0 || index2 == 0) {
                // 0下标数据是当前定位的数据项，恒定在0下标位置，禁止移动操作
                throw IllegalArgumentException("索引下标不能为0, 因为0下标数据是当前定位的数据项，恒定在0下标位置，禁止移动操作")
            }
            if (index1 < 0 || index1 > mCityDataList.size - 1
                || index2 < 0 || index2 > mCityDataList.size - 1
            ) {
                throw IllegalArgumentException("索引下标超界")
            }
            if (mCityDataList.size < 2) {
                throw IllegalArgumentException("列表大小必须大于等于2")
            }
            if (mCityDataList.swap(index1, index2)) {
                indexList.add(index1)
                indexList.add(index2)
            }
        }
        EventBus.getDefault().post(
            CityDataChangeEvent(
                type = CITY_DATA_OPERATE_SWAP,
                indexList = indexList
            )
        )
    }

    /**
     * 通过下标索引 删除元素
     *
     * @param index 下标
     */
    fun removeAt(
        index: Int,
    ) {
        // 0下标数据是当前定位的数据项，恒定在0下标位置，禁止删除操作
        if (index < 1 || index > mCityDataList.size - 1) {
            return
        }

        val cityData = mCityDataList.removeAt(index)

        mCityDataMap.remove(cityData.cityCode)
        EventBus.getDefault().post(
            CityDataChangeEvent(
                type = CITY_DATA_OPERATE_REMOVE,
                indexList = listOf(index)
            )
        )
    }

    /**
     * 通过 多个下标索引 批量删除
     *
     * @param indexList 下标索引列表
     */
    fun removeAt(
        indexList: List<Int>
    ) {
        if (indexList.isEmpty()) {
            return
        }

        val validIndexList = mutableListOf<Int>()

        // 过滤出有效的下标
        indexList.forEach { index ->
            if (index >= 1 && index <= mCityDataList.size - 1) {
                validIndexList.add(index)
            }
        }
        // 对下标进行排序(从大到小), 用于从后到前删除，防止删除后下标对应的元素已改变
        validIndexList.sortWith { o1, o2 ->
            o2 - o1
        }
        // 批量删除数据
        validIndexList.forEach { index ->
            val cityData = mCityDataList.removeAt(index)

            mCityDataMap.remove(cityData.cityCode)
        }
        EventBus.getDefault().post(
            CityDataChangeEvent(
                type = CITY_DATA_OPERATE_REMOVE,
                indexList = validIndexList
            )
        )
    }

    /**
     * 清空城市数据
     */
    fun clear() {
        mCityDataList.clear()
        mCityDataMap.clear()
        EventBus.getDefault().post(
            CityDataChangeEvent(
                type = CITY_DATA_OPERATE_REMOVE,
            )
        )
    }

}