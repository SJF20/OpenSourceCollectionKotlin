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
import com.shijingfeng.base.annotation.define.PageOperateType
import com.shijingfeng.base.arouter.ACTIVITY_WEATHER_CITY_SEARCH
import com.shijingfeng.base.common.constant.PAGE_OPERATE_TYPE_LOAD
import com.shijingfeng.base.common.constant.PAGE_OPERATE_TYPE_LOAD_MORE
import com.shijingfeng.base.common.global.runOnUiThread
import com.shijingfeng.base.util.*
import com.shijingfeng.weather.R
import com.shijingfeng.weather.adapter.CitySearchListAdapter
import com.shijingfeng.weather.base.WeatherBaseActivity
import com.shijingfeng.weather.contract.CitySearchContract
import com.shijingfeng.weather.databinding.ActivityWeatherCitySearchBinding
import com.shijingfeng.weather.entity.CitySearchInfoEntity
import com.shijingfeng.weather.presenter.CitySearchPresenter
import kotlinx.android.synthetic.main.activity_weather_city_search.*
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
            val view = LayoutInflater.from(this@CitySearchActivity).inflate(R.layout.layout_hot_city_lable, null) as TextView

            mViewBinding.flHotCity.addView(view.apply {
                text = hotCityName
            })
            // 选中标签监听
            ClickUtils.applySingleDebouncing(view) { view -> 

            }
        }
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