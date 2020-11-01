package com.shijingfeng.weather.ui.activity

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.TextView
import androidx.annotation.IntRange
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.ClickUtils
import com.google.gson.JsonPrimitive
import com.shijingfeng.base.annotation.define.PageOperateType
import com.shijingfeng.base.arouter.ACTIVITY_WEATHER_CITY_SEARCH
import com.shijingfeng.base.common.constant.ADD
import com.shijingfeng.base.common.constant.MOVE
import com.shijingfeng.base.common.constant.PAGE_OPERATE_TYPE_LOAD
import com.shijingfeng.base.common.constant.PAGE_OPERATE_TYPE_LOAD_MORE
import com.shijingfeng.base.common.global.runOnUiThread
import com.shijingfeng.base.util.*
import com.shijingfeng.weather.R
import com.shijingfeng.weather.adapter.CitySearchListAdapter
import com.shijingfeng.weather.base.WeatherBaseActivity
import com.shijingfeng.weather.common.constant.CHOOSE_CITY
import com.shijingfeng.weather.common.constant.UNKNOWN_WEATHER
import com.shijingfeng.weather.common.global.cityDataManager
import com.shijingfeng.weather.common.global.cityDataMap
import com.shijingfeng.weather.contract.CitySearchContract
import com.shijingfeng.weather.databinding.ActivityWeatherCitySearchBinding
import com.shijingfeng.weather.entity.CitySearchInfoEntity
import com.shijingfeng.weather.entity.event.CityDataChangeEvent
import com.shijingfeng.weather.entity.realm.CityData
import com.shijingfeng.weather.presenter.CitySearchPresenter
import com.shijingfeng.weather.util.getWeatherDesc
import com.shijingfeng.weather.util.getWeatherType
import org.greenrobot.eventbus.EventBus
import java.lang.Thread.sleep
import kotlin.Exception

/**
 * Function: 城市搜索 页面
 * Date: 2020/10/22 17:15
 * Description:
 * @author ShiJingFeng
 */
@Route(path = ACTIVITY_WEATHER_CITY_SEARCH)
internal class CitySearchActivity : WeatherBaseActivity<ActivityWeatherCitySearchBinding, CitySearchContract.Presenter>(), CitySearchContract.View {

    /** 城市搜索信息列表 适配器 */
    private lateinit var mCitySearchListAdapter: CitySearchListAdapter

    /** 城市搜索信息列表 */
    private val mCitySearchList = arrayListOf<CitySearchInfoEntity>()

    /** 当前页码 */
    private var mCurPage = FIRST_PAGE

    /** 页面操作类型  */
    @PageOperateType
    private var mPageOperateType = PAGE_OPERATE_TYPE_LOAD

    /** 当前是 取消搜索 还是 手动搜索   true: 手动搜索  false: 取消搜索 */
    private var mCanSearch = false

    /** 延时器 */
    private val mDelayer = Delayer {
        mCurPage = FIRST_PAGE
        mPageOperateType = PAGE_OPERATE_TYPE_LOAD
        search()
    }

    companion object {
        /** 城市搜索页面 页码 从 1 开始 */
        private const val FIRST_PAGE = 1

        /** 热门城市列表 */
        private const val HOT_CITY_LIST = 0

        /** 城市搜索列表 */
        private const val CITY_SEARCH_LIST = 1

        /** 城市搜索列表 无数据 */
        private const val CITY_SEARCH_NO_DATA = 2

        /** 搜索间隔时间 默认 1000毫秒 (用于解决搜索框中快速增删导致频繁搜索) */
        private const val SEARCH_DELAY_MILLI = 1000L
    }

    /**
     * 创建 ViewBinding
     */
    override fun createViewBinding() = ActivityWeatherCitySearchBinding.inflate(layoutInflater)

    /**
     * 创建 Presenter
     *
     * @return Presenter
     */
    override fun createPresenter() = CitySearchPresenter(this)

    /**
     * 是否设置状态栏内容颜色为深色
     * @return true 深色  false 浅色
     */
    override fun isStatusBarContentDark() = true

    /**
     * 初始化数据
     */
    override fun initData() {
        super.initData()
        registerLoadingView(mViewBinding.flContent, getString(R.string.搜索中))

        // 初始化热门城市
        initHotCity()

        // 当不满 1 页时禁止开启上拉加载
        mViewBinding.srlCityList.setEnableLoadMoreWhenContentNotFull(false)

        mCitySearchListAdapter = CitySearchListAdapter(this, mCitySearchList)
        mViewBinding.rvCityList.adapter = mCitySearchListAdapter
        mViewBinding.rvCityList.layoutManager = LinearLayoutManager(this)
    }

    /**
     * 初始化热门城市
     */
    @SuppressLint("InflateParams")
    private fun initHotCity() {
        for (hotCityName in getStringArrayById(R.array.hotCityNameList) ?: emptyArray()) {
            val hotCityData = getHotCityData(hotCityName)
            val view = LayoutInflater.from(this@CitySearchActivity).inflate(R.layout.layout_hot_city_lable, null) as TextView

            hotCityData.isAdded = cityDataMap.contains(hotCityData.adCode)
            mViewBinding.flHotCity.addView(view.apply {
                text = hotCityName
                setBackgroundResource(if (hotCityData.isAdded) R.drawable.shape_hot_city_label_added_bg else R.drawable.shape_hot_city_label_bg)
            })
            // 选中标签监听
            ClickUtils.applySingleDebouncing(view) {
                getWeather(hotCityData)
            }
        }
    }

    /**
     * 获取热门城市数据
     *
     * @param cityName 城市名称
     */
    private fun getHotCityData(
        cityName: String
    ) = when (cityName) {
        getStringById(R.string.北京市) -> CitySearchInfoEntity(
            adCode = "110100",
            centerJsonElement = JsonPrimitive("116.405285,39.904989"),
            level = "city",
            cityName = "北京城区",
            cityFullName = "北京市",
        )
        getStringById(R.string.上海市) -> CitySearchInfoEntity(
            adCode = "310100",
            centerJsonElement = JsonPrimitive("121.472644,31.231706"),
            level = "city",
            cityName = "上海城区",
            cityFullName = "上海市",
        )
        getStringById(R.string.广州市) -> CitySearchInfoEntity(
            adCode = "440100",
            centerJsonElement = JsonPrimitive("113.280637,23.125178"),
            level = "city",
            cityName = "广州市",
            cityFullName = "广州市",
        )
        getStringById(R.string.深圳市) -> CitySearchInfoEntity(
            adCode = "440300",
            centerJsonElement = JsonPrimitive("114.085947,22.547"),
            level = "city",
            cityName = "深圳市",
            cityFullName = "深圳市",
        )
        getStringById(R.string.珠海市) -> CitySearchInfoEntity(
            adCode = "440400",
            centerJsonElement = JsonPrimitive("113.553986,22.224979"),
            level = "city",
            cityName = "珠海市",
            cityFullName = "珠海市",
        )
        getStringById(R.string.佛山市) -> CitySearchInfoEntity(
            adCode = "440600",
            centerJsonElement = JsonPrimitive("113.122717,23.028762"),
            level = "city",
            cityName = "佛山市",
            cityFullName = "佛山市",
        )
        getStringById(R.string.南京市) -> CitySearchInfoEntity(
            adCode = "320100",
            centerJsonElement = JsonPrimitive("118.767413,32.041544"),
            level = "city",
            cityName = "南京市",
            cityFullName = "南京市",
        )
        getStringById(R.string.苏州市) -> CitySearchInfoEntity(
            adCode = "320500",
            centerJsonElement = JsonPrimitive("120.619585,31.299379"),
            level = "city",
            cityName = "苏州市",
            cityFullName = "苏州市",
        )
        getStringById(R.string.厦门市) -> CitySearchInfoEntity(
            adCode = "350200",
            centerJsonElement = JsonPrimitive("118.11022,24.490474"),
            level = "city",
            cityName = "厦门市",
            cityFullName = "厦门市",
        )
        getStringById(R.string.南宁市) -> CitySearchInfoEntity(
            adCode = "450100",
            centerJsonElement = JsonPrimitive("108.320004,22.82402"),
            level = "city",
            cityName = "南宁市",
            cityFullName = "南宁市",
        )
        getStringById(R.string.成都市) -> CitySearchInfoEntity(
            adCode = "510100",
            centerJsonElement = JsonPrimitive("104.065735,30.659462"),
            level = "city",
            cityName = "成都市",
            cityFullName = "成都市",
        )
        getStringById(R.string.长沙市) -> CitySearchInfoEntity(
            adCode = "430100",
            centerJsonElement = JsonPrimitive("112.982279,28.19409"),
            level = "city",
            cityName = "长沙市",
            cityFullName = "长沙市",
        )
        getStringById(R.string.福州市) -> CitySearchInfoEntity(
            adCode = "350100",
            centerJsonElement = JsonPrimitive("119.306239,26.075302"),
            level = "city",
            cityName = "福州市",
            cityFullName = "福州市",
        )
        getStringById(R.string.杭州市) -> CitySearchInfoEntity(
            adCode = "330100",
            centerJsonElement = JsonPrimitive("120.153576,30.287459"),
            level = "city",
            cityName = "杭州市",
            cityFullName = "杭州市",
        )
        getStringById(R.string.武汉市) -> CitySearchInfoEntity(
            adCode = "420100",
            centerJsonElement = JsonPrimitive("114.298572,30.584355"),
            level = "city",
            cityName = "武汉市",
            cityFullName = "武汉市",
        )
        getStringById(R.string.青岛市) -> CitySearchInfoEntity(
            adCode = "370200",
            centerJsonElement = JsonPrimitive("120.355173,36.082982"),
            level = "city",
            cityName = "青岛市",
            cityFullName = "青岛市",
        )
        getStringById(R.string.西安市) -> CitySearchInfoEntity(
            adCode = "610100",
            centerJsonElement = JsonPrimitive("108.948024,34.263161"),
            level = "city",
            cityName = "西安市",
            cityFullName = "西安市",
        )
        getStringById(R.string.太原市) -> CitySearchInfoEntity(
            adCode = "140100",
            centerJsonElement = JsonPrimitive("112.549248,37.857014"),
            level = "city",
            cityName = "太原市",
            cityFullName = "太原市",
        )
        getStringById(R.string.石家庄市) -> CitySearchInfoEntity(
            adCode = "130100",
            centerJsonElement = JsonPrimitive("114.502461,38.045474"),
            level = "city",
            cityName = "石家庄市",
            cityFullName = "石家庄市",
        )
        getStringById(R.string.沈阳市) -> CitySearchInfoEntity(
            adCode = "210100",
            centerJsonElement = JsonPrimitive("123.429096,41.796767"),
            level = "city",
            cityName = "沈阳市",
            cityFullName = "沈阳市",
        )
        getStringById(R.string.重庆市) -> CitySearchInfoEntity(
            adCode = "500100",
            centerJsonElement = JsonPrimitive("106.504962,29.533155"),
            level = "city",
            cityName = "重庆城区",
            cityFullName = "重庆市",
        )
        getStringById(R.string.天津市) -> CitySearchInfoEntity(
            adCode = "120100",
            centerJsonElement = JsonPrimitive("117.190182,39.125596"),
            level = "city",
            cityName = "天津城区",
            cityFullName = "天津市",
        )
        else -> CitySearchInfoEntity()
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
        // 搜索框过滤
        mViewBinding.etSearch.filters = arrayOf(
            // 过滤表情
            getProhibitSystemEmojiInputFilter()
        )
        // 搜索框输入
        mViewBinding.etSearch.addTextChangedListener(object : TextWatcherAdapter {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (mViewBinding.etSearch.length() == 0) {
                    // 显示热门城市
                    mCanSearch = false
                    mViewBinding.tvCancelOrSearch.text = getStringById(R.string.取消)
                    mDelayer.dispose()
                    setPageStatus(HOT_CITY_LIST)
                } else {
                    // 显示搜索列表
                    mCanSearch = true
                    mViewBinding.tvCancelOrSearch.text = getStringById(R.string.搜索)
                    mDelayer.delay(SEARCH_DELAY_MILLI)
                }
            }
        })
        // 取消搜索 或 手动点击搜索
        ClickUtils.applySingleDebouncing(mViewBinding.tvCancelOrSearch) {
            if (mCanSearch) {
                // 手动搜索
                mCurPage = FIRST_PAGE
                mPageOperateType = PAGE_OPERATE_TYPE_LOAD
                setForbidInput(true)
                showLoadingView()
                search()
            } else {
                // 取消搜索
                finish()
            }
        }
        // 上拉加载监听
        mViewBinding.srlCityList.setOnLoadMoreListener {
            mPageOperateType = PAGE_OPERATE_TYPE_LOAD_MORE
            search(page = mCurPage + 1)
        }
        // 适配器监听
        mCitySearchListAdapter.setOnItemEventListener { view, data, position, flag ->
            when (flag) {
                CHOOSE_CITY -> {
                    val citySearchInfo = data as CitySearchInfoEntity

                    getWeather(citySearchInfo)
                }
            }
        }
    }

    /**
     * 设置页面状态
     *
     * @param status 页面状态
     */
    private fun setPageStatus(
        @IntRange(from = HOT_CITY_LIST.toLong(), to = CITY_SEARCH_NO_DATA.toLong())
        status: Int
    ) {
        when (status) {
            // 热门城市列表
            HOT_CITY_LIST -> mViewBinding.run {
                srlCityList.visibility = GONE
                includeNoData.visibility = GONE
                nsvHotCity.visibility = VISIBLE
            }
            // 城市搜索列表
            CITY_SEARCH_LIST -> mViewBinding.run {
                nsvHotCity.visibility = GONE
                includeNoData.visibility = GONE
                srlCityList.visibility = VISIBLE
            }
            // 城市搜索列表 无数据
            CITY_SEARCH_NO_DATA -> mViewBinding.run {
                nsvHotCity.visibility = GONE
                srlCityList.visibility = GONE
                includeNoData.visibility = VISIBLE
            }
            else -> {}
        }
    }

    /**
     * 是否禁止输入
     *
     * @param isForbid  true: 禁止输入  false: 可以输入
     */
    private fun setForbidInput(
        isForbid: Boolean
    ) {
        mViewBinding.run {
            if (isForbid) {
                // 禁止输入
                etSearch.clearFocus()
                etSearch.isEnabled = false
                tvCancelOrSearch.isEnabled = false
            } else {
                // 可以输入
                etSearch.isEnabled = true
                etSearch.requestFocus()
                tvCancelOrSearch.isEnabled = true
            }
        }
    }

    /**
     * 搜索
     *
     * @param page 页码
     */
    @SuppressLint("SwitchIntDef")
    private fun search(
        page: Int = mCurPage
    ) {
        mPresenter?.search(
            keywords = mViewBinding.etSearch.text.toString(),
            page = page,
            onSuccess = { citySearch ->
                val dataList = citySearch.districts

                when (mPageOperateType) {
                    // 加载
                    PAGE_OPERATE_TYPE_LOAD -> {
                        mCitySearchList.clear()
                        mCitySearchList.addAll(dataList)
                        if (dataList.isEmpty()) {
                            setPageStatus(CITY_SEARCH_NO_DATA)
                        } else {
                            mCitySearchListAdapter.notifyDataSetChanged()
                            setPageStatus(CITY_SEARCH_LIST)
                        }
                        setForbidInput(false)
                        hideLoadingView()
                    }
                    // 上拉加载
                    PAGE_OPERATE_TYPE_LOAD_MORE -> {
                        val oldSize = mCitySearchList.size

                        ++mCurPage
                        if (dataList.isEmpty()) {
                            mViewBinding.srlCityList.finishLoadMoreWithNoMoreData()
                        } else {
                            mViewBinding.srlCityList.finishLoadMore(true)
                        }
                        mCitySearchList.addAll(dataList)
                        if (oldSize <= 0) {
                            mCitySearchListAdapter.notifyDataSetChanged()
                        } else {
                            // oldSize - 1 是为了更新 oldSize下标位置 前面的Item下面的ItemDecoration
                            // 单独使用 notifyItemChanged 是为了避免 RecyclerView item更新动画 不美观
                            mCitySearchListAdapter.notifyItemChanged(oldSize - 1)
                            mCitySearchListAdapter.notifyItemRangeInserted(
                                oldSize,
                                mCitySearchList.size
                            )
                        }
                    }
                    else -> {}
                }
            },
            onFailure = {
                when (mPageOperateType) {
                    // 加载
                    PAGE_OPERATE_TYPE_LOAD -> {
                        setForbidInput(false)
                        hideLoadingView()
                    }
                    // 上拉加载
                    PAGE_OPERATE_TYPE_LOAD_MORE -> mViewBinding.srlCityList.finishLoadMore(false)
                    else -> {}
                }
            }
        )
    }

    /**
     * 获取天气数据
     */
    private fun getWeather(citySearchInfo: CitySearchInfoEntity) {
        setForbidInput(true)
        showLoadingView()
        mPresenter?.getWeather(
            longitude = citySearchInfo.longitude,
            latitude = citySearchInfo.latitude,
            onSuccess = { weather ->
                if (citySearchInfo.isAdded) {
                    // 已添加
                    // 原来的下标
                    var oldIndex = -1

                    // 查找数据下标
                    cityDataManager.forEachIndexed { index, cityData ->
                        if (cityData.cityCode == citySearchInfo.adCode) {
                            oldIndex = index
                            return@forEachIndexed
                        }
                    }
                    // 移动数据位置
                    cityDataManager.move(
                        oldIndex = oldIndex,
                        newIndex = 1
                    )
                    // 下标为0时是当前位置的城市数据(恒定存在，不能被删除), 下标为1时就处于次顶部, 不需要改变位置
                    if (oldIndex != 1) {
                        // 已添加
                        EventBus.getDefault().post(CityDataChangeEvent(
                            type = MOVE,
                            indexList = listOf(oldIndex, 1)
                        ))
                    }
                } else {
                    // 天气类型
                    val weatherType: Int
                    // 天气描述 例如: 晴, 阴, 多云, 小雨
                    val weatherDesc: String
                    // 当前温度
                    val curTemp: Double
                    // 最低温度
                    val lowestTemp: Double
                    // 最高温度
                    val highestTemp: Double

                    if (weather.result.daily.skyCon.isEmpty()) {
                        weatherType = UNKNOWN_WEATHER
                        weatherDesc = ""
                    } else {
                        weatherType = getWeatherType(weatherTypeStr = weather.result.daily.skyCon[0].value)
                        weatherDesc = getWeatherDesc(weatherType)
                    }
                    if (weather.result.daily.temperature.isEmpty()) {
                        curTemp = 0.0
                        lowestTemp = 0.0
                        highestTemp = 0.0
                    } else {
                        weather.result.daily.temperature[0].run {
                            curTemp = avg
                            lowestTemp = min
                            highestTemp = max
                        }
                    }

                    // 未添加
                    val cityData = CityData(
                        cityCode = citySearchInfo.adCode,
                        longitude = citySearchInfo.longitude,
                        latitude = citySearchInfo.latitude,
                        cityName = citySearchInfo.cityName,
                        cityFullName = citySearchInfo.cityFullName,
                        weatherType = weatherType,
                        weatherDesc = weatherDesc,
                        curTemp = curTemp,
                        lowestTemp = lowestTemp,
                        highestTemp = highestTemp,
                        weatherData = serialize(weather)
                    )

                    cityDataManager.add(1, cityData)
                    cityDataMap[cityData.cityCode] = cityData
                    EventBus.getDefault().post(CityDataChangeEvent(
                        type = ADD
                    ))
                }
                hideLoadingView()
                // 选择完成，关掉此页面
                finish()
            },
            onFailure = {
                setForbidInput(false)
                hideLoadingView()
            }
        )
    }

    /**
     * Activity销毁回调
     */
    override fun onDestroy() {
        super.onDestroy()
        mDelayer.dispose()
    }
}

/**
 * 延时器
 */
internal class Delayer(
    callback: () -> Unit = {}
) {

    /** 结束时间戳(毫秒值) */
    @Volatile
    private var mEndMs = 0L

    /** 回调函数 */
    private var mCallback = callback

    /** 延时线程 */
    private var mThread: Thread? = null

    /**
     * 获取和设置结束时的时间戳(毫秒值)
     */
    var endMillis
        get() = mEndMs
        set(endMillis) {
            this.mEndMs = endMillis
        }

    /**
     * 获取和设置回调函数
     */
    var callback
        get() = mCallback
        set(callback) {
            this.mCallback = callback
        }

    /**
     * 延迟毫秒数
     */
    fun delay(delayMs: Long) {
        val thread = mThread

        mEndMs = System.currentTimeMillis() + delayMs
        if (thread == null || !thread.isAlive) {
            mThread = Thread {
                mThread?.run {
                    try {
                        while (!isInterrupted) {
                            val curMs = System.currentTimeMillis()

                            if (curMs >= mEndMs) {
                                interrupt()
                                runOnUiThread {
                                    mCallback.invoke()
                                }
                            } else {
                                sleep(mEndMs - curMs)
                            }
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }.apply {
                start()
            }
        }
    }

    /**
     * 销毁
     */
    fun dispose() {
        mThread?.run {
            if (!isInterrupted) {
                interrupt()
            }
        }
    }

}