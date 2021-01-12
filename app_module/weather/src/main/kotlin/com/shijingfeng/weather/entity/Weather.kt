package com.shijingfeng.weather.entity

import com.google.gson.annotations.SerializedName
import com.shijingfeng.base.base.entity.BaseEntity

/**
 * Function: 天气 实体类
 * Date: 2020/10/9 16:28
 * Description:
 * Author: ShiJingFeng
 */

internal data class Weather(

    /** 成功: ok  失败: failed */
    @SerializedName("status")
    val status: String = "", // ok

    /** 当 status == "failed", error字段才有效 */
    @SerializedName("error")
    val error: String = "",

    @SerializedName("api_version")
    val apiVersion: String = "", // v2.5

    @SerializedName("api_status")
    val apiStatus: String = "", // active

    @SerializedName("lang")
    val lang: String = "", // zh_CN

    @SerializedName("unit")
    val unit: String = "", // metric

    @SerializedName("tzshift")
    val tzshift: Int = 0, // 28800

    @SerializedName("timezone")
    val timezone: String = "", // Asia/Shanghai

    @SerializedName("server_time")
    val serverTime: Long = 0L, // 1602230981

    /** 经纬度位置: 数组下标0: 纬度  数组下标1: 经度 */
    @SerializedName("location")
    val location: List<Double> = listOf(0.0, 0.0), // [ 39.91488908, 116.40387397 ]

    @SerializedName("result")
    val result: WeatherResult,

    ) : BaseEntity()

internal data class WeatherResult(

    /** 实况天气 */
    @SerializedName("realtime")
    val realtime: RealTimeWeather,

    /** 分钟级降雨预报 */
    @SerializedName("minutely")
    val minutely: MinutelyWeather,

    /** 小时级预报 */
    @SerializedName("hourly")
    val hourly: HourlyWeather,

    /** 天级预报 */
    @SerializedName("daily")
    val daily: DailyWeather,

    /** 预警信息 */
    @SerializedName("alert")
    val alert: AlertInfo,

    @SerializedName("primary")
    val primary: Int, // 0

    @SerializedName("forecast_keypoint")
    val forecastKeyPoint: String // "空气不太好，在室内休息休息吧"

) : BaseEntity()

/**
 * 实况天气
 */
internal class RealTimeWeather(

    /** 状态 */
    @SerializedName("status")
    val status: String, // ok

    /** 温度: 地表2米气温 */
    @SerializedName("temperature")
    val temperature: Double, // 21

    /** 相对湿度(%): 地表2米湿度 */
    @SerializedName("humidity")
    val humidity: Double, // 0.5

    /** 云量(0.0-1.0): 全天总云量 */
    @SerializedName("cloudrate")
    val cloudRate: Double, // 0

    /** 天气状况: 参考天气现象代码 [https://open.caiyunapp.com/%E9%80%9A%E7%94%A8%E9%A2%84%E6%8A%A5%E6%8E%A5%E5%8F%A3/v2.5#.E5.A4.A9.E6.B0.94.E7.8E.B0.E8.B1.A1.E4.BB.A3.E7.A0.81] */
    @SerializedName("skycon")
    val skyCon: String, // LIGHT_HAZE

    /** 能见度: 地表水平能见度 */
    @SerializedName("visibility")
    val visibility: Double, // 34.76

    /** 短波辐射(W/M2): 地表向下短波辐射通量 */
    @SerializedName("dswrf")
    val dswrf: Double, // 420.8

    /** 风 */
    @SerializedName("wind")
    val wind: Wind,

    /** 气压(Pa): 地面气压 */
    @SerializedName("pressure")
    val pressure: Double, // 101236.75

    /** 体感温度 */
    @SerializedName("apparent_temperature")
    val apparentTemperature: Double, // 19.7

    /** 降水 */
    @SerializedName("precipitation")
    val precipitation: Precipitation,

    /** 空气质量 */
    @SerializedName("air_quality")
    val airQuality: AirQuality,

    /** 生活指数 */
    @SerializedName("life_index")
    val lifeIndex: LifeIndex

) : BaseEntity() {

    /**
     * 风
     */
    internal data class Wind(

        /** 风速: 地表10米风速 */
        @SerializedName("speed")
        val speed: Double, // 10.8

        /** 风向: 地表10米风向 */
        @SerializedName("direction")
        val direction: Double // 216

    ) : BaseEntity()

    /**
     * 降水
     */
    internal data class Precipitation(

        /** 本地降水量 */
        @SerializedName("local")
        val local: Local,

        /** 最近降水量 */
        @SerializedName("nearest")
        val nearest: Nearest

    ) : BaseEntity() {

        /**
         * 本地降水量
         */
        internal data class Local(

            /** 状态 */
            @SerializedName("status")
            val status: String, // ok

            /** 数据源: 例如雷达 */
            @SerializedName("datasource")
            val dataSource: String, // radar

            /** 本地降水强度(雷达降水强度): 最近降水处的降水强度 */
            @SerializedName("intensity")
            val intensity: Double // 0

        ) : BaseEntity()

        /**
         * 最近降水量
         */
        internal data class Nearest(

            /** 状态 */
            @SerializedName("status")
            val status: String, // ok

            /** 最近降水距离: 最近降水带与本地的距离 */
            @SerializedName("distance")
            val distance: Double, // 149.66

            /** 最近降水强度: 最近降水处的降水强度 */
            @SerializedName("intensity")
            val intensity: Double // 0.1875

        ) : BaseEntity()

    }

    /**
     * 空气质量
     */
    internal data class AirQuality(

        /** PM2.5浓度(μg/m3) */
        @SerializedName("pm25")
        val pm25: Double, // 113

        /** PM10浓度(μg/m3) */
        @SerializedName("pm10")
        val pm10: Double, // 110

        /** 臭氧浓度(μg/m3) */
        @SerializedName("o3")
        val o3: Double, // 103

        /** 二氧化硫浓度(μg/m3) */
        @SerializedName("so2")
        val so2: Double, // 9

        /** 二氧化氮浓度(μg/m3) */
        @SerializedName("no2")
        val no2: Double, // 59

        /** 一氧化碳浓度(mg/m3) */
        @SerializedName("co")
        val co: Double, // 0.9

        /** AQI(国标) */
        @SerializedName("aqi")
        val aqi: Aqi,

        /** 污染程度文本描述 */
        @SerializedName("description")
        val description: Description

    ) : BaseEntity() {

        /**
         * AQI 污染程度
         */
        internal data class Aqi(

            /** 污染程度(国标) */
            @SerializedName("chn")
            val chn: Double, // 147

            /** 污染程度(美标) */
            @SerializedName("usa")
            val usa: Double // 181

        ) : BaseEntity()

        /**
         * 污染程度文本描述
         */
        internal data class Description(

            /** 污染程度文本描述(国标) */
            @SerializedName("chn")
            val chn: String, // 轻度污染

            /** 污染程度文本描述(美标) */
            @SerializedName("usa")
            val usa: String // 中度污染

        ) : BaseEntity()

    }

    /**
     * 生活指数
     */
    internal data class LifeIndex(

        /** 紫外线 */
        @SerializedName("ultraviolet")
        val ultraviolet: Ultraviolet,

        /** 舒适度*/
        @SerializedName("comfort")
        val comfort: Comfort

    ) : BaseEntity() {

        /**
         * 紫外线
         */
        internal data class Ultraviolet(

            /** 紫外线指数: 参考生活指数等级 [https://open.caiyunapp.com/%E9%80%9A%E7%94%A8%E9%A2%84%E6%8A%A5%E6%8E%A5%E5%8F%A3/v2.5#.E7.94.9F.E6.B4.BB.E6.8C.87.E6.95.B0.E7.AD.89.E7.BA.A7] */
            @SerializedName("index")
            val index: Int, // 4

            /** 紫外线文本描述 */
            @SerializedName("desc")
            val desc: String // 弱

        ) : BaseEntity()

        /**
         * 舒适度
         */
        internal data class Comfort(

            /** 舒适度指数: 参考生活指数等级 [https://open.caiyunapp.com/%E9%80%9A%E7%94%A8%E9%A2%84%E6%8A%A5%E6%8E%A5%E5%8F%A3/v2.5#.E7.94.9F.E6.B4.BB.E6.8C.87.E6.95.B0.E7.AD.89.E7.BA.A7] */
            @SerializedName("index")
            val index: Int, // 5

            /** 舒适度文本描述 */
            @SerializedName("desc")
            val desc: String // 舒适

        ) : BaseEntity()

    }

}

/**
 * 分钟级降雨预报
 */
internal data class MinutelyWeather(

    /** 状态 */
    @SerializedName("status")
    val status: String, // ok

    /** 数据源: 例如雷达 */
    @SerializedName("datasource")
    val dataSource: String, // radar

    /** 两小时降水强度(0.0~1.0): 本地未来2小时逐分钟短临降水强度预报 */
    @SerializedName("precipitation_2h")
    val precipitation2h: List<Double>,

    /** 一小时降水强度(0.0~1.0): 本地未来1小时逐分钟短临降水强度预报 */
    @SerializedName("precipitation")
    val precipitation: List<Double>,

    /** 降水概率(0.0~1.0) */
    @SerializedName("probability")
    val probability: List<Double>,

    /** 描述 */
    @SerializedName("description")
    val description: String,

) : BaseEntity()

/**
 * 小时级降雨预报
 */
internal data class HourlyWeather(

    /** 状态 */
    @SerializedName("status")
    val status: String, // ok

    /** 自然语言描述 */
    @SerializedName("description")
    val description: String, // 晴，明天下午15点钟后转多云，其后云渐少

    /** 降雨量 */
    @SerializedName("precipitation")
    val precipitation: List<Precipitation>,

    /** 温度 */
    @SerializedName("temperature")
    val temperature: List<Temperature>,

    /** 风 */
    @SerializedName("wind")
    val wind: List<Wind>,

    /** 相对湿度 */
    @SerializedName("humidity")
    val humidity: List<Humidity>,

    /** 云 */
    @SerializedName("cloudrate")
    val cloudRate: List<CloudRate>,

    /** 天气状况 */
    @SerializedName("skycon")
    val skyCon: List<SkyCon>,

    /** 气压 */
    @SerializedName("pressure")
    val pressure: List<Pressure>,

    /** 能见度 */
    @SerializedName("visibility")
    val visibility: List<Visibility>,

    /** 向下短波辐射通量 */
    @SerializedName("dswrf")
    val dswrf: List<Dswrf>,

    /** 空气质量 */
    @SerializedName("air_quality")
    val airQuality: AirQuality

) : BaseEntity() {

    /**
     * 降水量
     */
    internal data class Precipitation(

        /** 日期文本 */
        @SerializedName("datetime")
        val datetime: String, // 2020-10-09T16:00+08:00

        /** 降水量(mm/h): 本地降水量 */
        @SerializedName("value")
        val value: Double // 0

    ) : BaseEntity()

    /**
     * 温度
     */
    internal data class Temperature(

        /** 日期文本 */
        @SerializedName("datetime")
        val datetime: String, // 2020-10-09T16:00+08:00

        /** 温度: 地表2米气温 */
        @SerializedName("value")
        val value: Double // 21

    ) : BaseEntity()

    /**
     * 风
     */
    internal data class Wind(

        /** 日期文本 */
        @SerializedName("datetime")
        val datetime: String, // 2020-10-09T16:00+08:00

        /** 风速: 地表10米风速 */
        @SerializedName("speed")
        val speed: Double, // 10.8

        /** 风向: 地表10米风向 */
        @SerializedName("direction")
        val direction: Double // 216

    ) : BaseEntity()

    /**
     * 相对湿度
     */
    internal data class Humidity(

        /** 日期文本 */
        @SerializedName("datetime")
        val datetime: String, // 2020-10-09T16:00+08:00

        /** 相对湿度(%): 地表2米湿度 */
        @SerializedName("value")
        val value: Double // 0.5

    ) : BaseEntity()

    /**
     * 云
     */
    internal data class CloudRate(

        /** 日期文本 */
        @SerializedName("datetime")
        val datetime: String, // 2020-10-09T16:00+08:00

        /** 云量(0.0-1.0): 全天总云量 */
        @SerializedName("value")
        val value: Double // 0

    ) : BaseEntity()

    /**
     * 天气状况
     */
    internal data class SkyCon(

        /** 日期文本 */
        @SerializedName("datetime")
        val datetime: String, // 2020-10-09T16:00+08:00

        /** 天气状况  参考天气现象代码 [https://open.caiyunapp.com/%E9%80%9A%E7%94%A8%E9%A2%84%E6%8A%A5%E6%8E%A5%E5%8F%A3/v2.5#.E5.A4.A9.E6.B0.94.E7.8E.B0.E8.B1.A1.E4.BB.A3.E7.A0.81]*/
        @SerializedName("value")
        val value: String // LIGHT_HAZE

    ) : BaseEntity()

    /**
     * 气压
     */
    internal data class Pressure(

        /** 日期文本 */
        @SerializedName("datetime")
        val datetime: String, // 2020-10-09T16:00+08:00

        /** 气压(Pa): 地面气压 */
        @SerializedName("value")
        val value: Double // 101236.7545393842

    ) : BaseEntity()

    /**
     * 能见度
     */
    internal data class Visibility(

        /** 日期文本 */
        @SerializedName("datetime")
        val datetime: String, // 2020-10-09T16:00+08:00

        /** 地表水平能见度 */
        @SerializedName("value")
        val value: Double // 34.76

    ) : BaseEntity()

    /**
     * 向下短波辐射通量
     */
    internal data class Dswrf(

        /** 日期文本 */
        @SerializedName("datetime")
        val datetime: String, // 2020-10-09T16:00+08:00

        /** 向下短波辐射通量(W/M2): 地表向下短波辐射通量 */
        @SerializedName("value")
        val value: Double // 420.7514382034

    ) : BaseEntity()

    /**
     * 空气质量
     */
    internal data class AirQuality(

        /** AQI */
        @SerializedName("aqi")
        val aqi: List<Aqi>,

        /** PM2.5浓度(μg/m3) */
        @SerializedName("pm25")
        val pm25: List<Pm25>

    ) : BaseEntity() {

        /**
         * AQI
         */
        internal data class Aqi(

            /** 日期文本 */
            @SerializedName("datetime")
            val datetime: String, // 2020-10-09T16:00+08:00

            /** AQI 值 */
            @SerializedName("value")
            val value: Value

        ) : BaseEntity() {

            /**
             * AQI 值
             */
            internal data class Value(

                /** 国标值 */
                @SerializedName("chn")
                val chn: Double, // 147

                /** 美标值 */
                @SerializedName("usa")
                val usa: Double // 147

            ) : BaseEntity()

        }

        /**
         * PM2.5
         */
        internal data class Pm25(

            /** 日期文本 */
            @SerializedName("datetime")
            val datetime: String, // 2020-10-09T16:00+08:00

            /** PM2.5 值 */
            @SerializedName("value")
            val value: Double // 113

        ) : BaseEntity()

    }

}

/**
 * 天级降雨预报
 */
internal data class DailyWeather(

    /** 状态 */
    @SerializedName("status")
    val status: String, // ok

    /** 日出日落(当地时区的时刻，tzshift不作用在这个变量) */
    @SerializedName("astro")
    val astro: List<Astro>,

    /** 降水量 */
    @SerializedName("precipitation")
    val precipitation: List<Precipitation>,

    /** 温度 */
    @SerializedName("temperature")
    val temperature: List<Temperature>,

    /** 风 */
    @SerializedName("wind")
    val wind: List<Wind>,

    /** 相对湿度 */
    @SerializedName("humidity")
    val humidity: List<Humidity>,

    /** 云量 */
    @SerializedName("cloudrate")
    val cloudRate: List<CloudRate>,

    /** 气压 */
    @SerializedName("pressure")
    val pressure: List<Pressure>,

    /** 能见度 */
    @SerializedName("visibility")
    val visibility: List<Visibility>,

    /** 短波辐射 */
    @SerializedName("dswrf")
    val dswrf: List<Dswrf>,

    /** 空气质量 */
    @SerializedName("air_quality")
    val airQuality: AirQuality,

    /** 全天主要天气现象 */
    @SerializedName("skycon")
    val skyCon: List<SkyCon>,

    /** 白天主要天气现象 */
    @SerializedName("skycon_08h_20h")
    val skyCon08h20h: List<SkyCon08h20h>,

    /** 夜晚主要天气现象 */
    @SerializedName("skycon_20h_32h")
    val skyCon20h32h: List<SkyCon20h32h>,

    /** 生活指数 */
    @SerializedName("life_index")
    val lifeIndex: LifeIndex

) : BaseEntity() {

    /**
     * 日出日落 (当地时区的时刻，tzshift不作用在这个变量)
     */
    internal data class Astro(

        /** 日期文本 */
        @SerializedName("date")
        val date: String, // 2020-10-09T00:00+08:00

        /** 日出 */
        @SerializedName("sunrise")
        val sunrise: AstroValue,

        /** 日落 */
        @SerializedName("sunset")
        val sunset: AstroValue

    ) : BaseEntity() {

        /**
         * 日出日落值
         */
        internal data class AstroValue(

            /** 时间 */
            @SerializedName("time")
            val time: String // 17:44

        ) : BaseEntity()

    }

    /**
     * 降水量
     */
    internal data class Precipitation(

        /** 日期文本 */
        @SerializedName("date")
        val date: String, // 2020-10-09T00:00+08:00

        /** 最大降水量(mm/h) */
        @SerializedName("max")
        val max: Double, // 0

        /** 最小降水量(mm/h) */
        @SerializedName("min")
        val min: Double, // 0

        /** 平均降水量(mm/h) */
        @SerializedName("avg")
        val avg: Double // 0
    ) : BaseEntity()

    /**
     * 温度
     */
    internal data class Temperature(

        /** 日期文本 */
        @SerializedName("date")
        val date: String, // 2020-10-09T00:00+08:00

        /** 最大温度 */
        @SerializedName("max")
        val max: Double, // 21

        /** 最小温度 */
        @SerializedName("min")
        val min: Double, // 11

        /** 平均温度 */
        @SerializedName("avg")
        val avg: Double // 16.69

    ) : BaseEntity()

    /**
     * 风
     */
    internal data class Wind(

        /** 日期文本 */
        @SerializedName("date")
        val date: String, // 2020-10-09T00:00+08:00

        /** 最大风 */
        @SerializedName("max")
        val max: WindValue,

        /** 最小风 */
        @SerializedName("min")
        val min: WindValue,

        /** 平均风 */
        @SerializedName("avg")
        val avg: WindValue

    ) : BaseEntity() {

        /**
         * 风值
         */
        internal data class WindValue(

            /** 风速 */
            @SerializedName("speed")
            val speed: Double, // 10.8

            /** 风向 */
            @SerializedName("direction")
            val direction: Double // 216

        ) : BaseEntity()

    }

    /**
     * 相对湿度
     */
    internal data class Humidity(

        /** 日期文本 */
        @SerializedName("date")
        val date: String, // 2020-10-09T00:00+08:00

        /** 最大值 */
        @SerializedName("max")
        val max: Double, // 0.5

        /** 最小值 */
        @SerializedName("min")
        val min: Double, // 0.27

        /** 平均值 */
        @SerializedName("avg")
        val avg: Double // 0.39

    ) : BaseEntity()

    /**
     * 云量
     */
    internal data class CloudRate(

        /** 日期文本 */
        @SerializedName("date")
        val date: String, // 2020-10-09T00:00+08:00

        /** 最大值 */
        @SerializedName("max")
        val max: Double, // 0.95

        /** 最小值 */
        @SerializedName("min")
        val min: Double, // 0

        /** 平均值 */
        @SerializedName("avg")
        val avg: Double // 0

    ) : BaseEntity()

    /**
     * 压力
     */
    internal data class Pressure(

        /** 日期文本 */
        @SerializedName("date")
        val date: String, // 2020-10-09T00:00+08:00

        /** 最大值 */
        @SerializedName("max")
        val max: Double, // 101857.63

        /** 最小值 */
        @SerializedName("min")
        val min: Double, // 101217.62

        /** 平均值 */
        @SerializedName("avg")
        val avg: Double // 101280.47

    ) : BaseEntity()

    /**
     * 能见度
     */
    internal data class Visibility(

        /** 日期文本 */
        @SerializedName("date")
        val date: String, // 2020-10-09T00:00+08:00

        /** 最大值 */
        @SerializedName("max")
        val max: Double, // 35.07

        /** 最小值 */
        @SerializedName("min")
        val min: Double, // 5.52

        /** 平均值 */
        @SerializedName("avg")
        val avg: Double // 31.17

    ) : BaseEntity()

    /**
     * 短波辐射
     */
    internal data class Dswrf(

        /** 日期文本 */
        @SerializedName("date")
        val date: String, // 2020-10-09T00:00+08:00

        /** 最大值 */
        @SerializedName("max")
        val max: Double, // 529.1

        /** 最小值 */
        @SerializedName("min")
        val min: Double, // 0

        /** 平均值 */
        @SerializedName("avg")
        val avg: Double // 174

    ) : BaseEntity()

    /**
     * 空气质量
     */
    internal data class AirQuality(

        /** AQI */
        @SerializedName("aqi")
        val aqi: List<Aqi>,

        /** PM2.5 */
        @SerializedName("pm25")
        val pm25: List<Pm25>

    ) : BaseEntity() {

        /**
         * AQI
         */
        internal data class Aqi(

            /** 日期文本 */
            @SerializedName("date")
            val date: String, // 2020-10-09T00:00+08:00

            /** 最大值 */
            @SerializedName("max")
            val max: AqiValue,

            /** 平均值 */
            @SerializedName("avg")
            val avg: AqiValue,

            /** 最小值 */
            @SerializedName("min")
            val min: AqiValue

        ) : BaseEntity() {

            /**
             * AQI 值
             */
            internal data class AqiValue(

                /** 国标值 */
                @SerializedName("chn")
                val chn: Double, // 174

                /** 美标值 */
                @SerializedName("usa")
                val usa: Double // 174

            ) : BaseEntity()

        }

        /**
         * PM2.5
         */
        internal data class Pm25(

            /** 日期文本 */
            @SerializedName("date")
            val date: String, // 2020-10-09T00:00+08:00

            /** 最大值 */
            @SerializedName("max")
            val max: Double, // 132

            /** 平均值 */
            @SerializedName("avg")
            val avg: Double, // 107.5

            /** 最小值 */
            @SerializedName("min")
            val min: Double // 78

        ) : BaseEntity()

    }

    /**
     * 全天主要天气现象
     */
    internal data class SkyCon(

        /** 日期文本 */
        @SerializedName("date")
        val date: String, // 2020-10-09T00:00+08:00

        /** 全天主要天气现象，参考天气现象代码 [https://open.caiyunapp.com/%E9%80%9A%E7%94%A8%E9%A2%84%E6%8A%A5%E6%8E%A5%E5%8F%A3/v2.5#.E5.A4.A9.E6.B0.94.E7.8E.B0.E8.B1.A1.E4.BB.A3.E7.A0.81] */
        @SerializedName("value")
        val value: String // LIGHT_HAZE

    ) : BaseEntity()

    /**
     * 白天主要天气现象
     */
    internal data class SkyCon08h20h(

        /** 日期文本 */
        @SerializedName("date")
        val date: String, // 2020-10-09T00:00+08:00

        /** 白天主要天气现象, 参考天气现象代码 [https://open.caiyunapp.com/%E9%80%9A%E7%94%A8%E9%A2%84%E6%8A%A5%E6%8E%A5%E5%8F%A3/v2.5#.E5.A4.A9.E6.B0.94.E7.8E.B0.E8.B1.A1.E4.BB.A3.E7.A0.81] */
        @SerializedName("value")
        val value: String // LIGHT_HAZE

    ) : BaseEntity()

    /**
     * 夜晚主要天气现象
     */
    internal data class SkyCon20h32h(

        /** 日期文本 */
        @SerializedName("date")
        val date: String, // 2020-10-09T00:00+08:00

        /** 夜晚主要天气现象，参考天气现象代码 [https://open.caiyunapp.com/%E9%80%9A%E7%94%A8%E9%A2%84%E6%8A%A5%E6%8E%A5%E5%8F%A3/v2.5#.E5.A4.A9.E6.B0.94.E7.8E.B0.E8.B1.A1.E4.BB.A3.E7.A0.81] */
        @SerializedName("value")
        val value: String // LIGHT_HAZE

    ) : BaseEntity()

    /**
     * 生活指数
     */
    internal data class LifeIndex(

        /** 紫外线指数 */
        @SerializedName("ultraviolet")
        val ultraviolet: List<LifeIndexValue>,

        /** 洗车指数 */
        @SerializedName("carWashing")
        val carWashing: List<LifeIndexValue>,

        /** 穿衣指数 */
        @SerializedName("dressing")
        val dressing: List<LifeIndexValue>,

        /** 舒适度指数 */
        @SerializedName("comfort")
        val comfort: List<LifeIndexValue>,

        /** 感冒指数 */
        @SerializedName("coldRisk")
        val coldRisk: List<LifeIndexValue>

    ) : BaseEntity() {

        /**
         * 生活指数 值
         */
        internal data class LifeIndexValue(

            /** 日期文本 */
            @SerializedName("date")
            val date: String, // 2020-10-09T00:00+08:00

            /** 生活指数值 */
            @SerializedName("index")
            val index: String, // 3

            /** 生活指数语言描述 */
            @SerializedName("desc")
            val desc: String // 中等 或 舒适 或 较适宜 或 极易发 或 温暖

        ) : BaseEntity()

    }

}

/**
 * 预警信息
 */
internal data class AlertInfo(

    /** 状态 */
    @SerializedName("status")
    val status: String,

    /** 内容 */
    @SerializedName("content")
    val content: List<AlertInfoContent>

) : BaseEntity() {

    /**
     * 预警信息 内容
     */
    internal data class AlertInfoContent(

        /** 请求状态 */
        @SerializedName("request_status")
        val requestStatus: String, // ok

        /** 预警ID */
        @SerializedName("alertId")
        val alertId: String, // 35040041600001_20200421123203

        /** 经纬度位置: 数组下标0: 纬度  数组下标1: 经度 */
        @SerializedName("latlon")
        val latLon: List<Double>,

        /** 发布时间 时间戳 */
        @SerializedName("pubtimestamp")
        val pubTimeStamp: Long, // 1587443583

        /** 状态 */
        @SerializedName("status")
        val status: String, // 预警中

        /** 区域 ID */
        @SerializedName("regionId")
        val regionId: String, // unknown

        /** 邮政编码 */
        @SerializedName("adcode")
        val adCode: String, // 350400

        /** 位置文本 */
        @SerializedName("location")
        val location: String, // 福建省三明市

        /** 省 */
        @SerializedName("province")
        val province: String, // 福建省

        /** 市 */
        @SerializedName("city")
        val city: String, // 三明市

        /** 县 */
        @SerializedName("county")
        val county: String, // 无

        /** 预警代码 */
        @SerializedName("code")
        val code: String, // 0902

        /** 发布源 */
        @SerializedName("source")
        val source: String, // 国家预警信息发布中心

        /** 预警标题 */
        @SerializedName("title")
        val title: String, // 三明市气象台发布雷电黄色预警[Ⅲ级/较重]

        /** 预警描述 */
        @SerializedName("description")
        val description: String // 三明市气象台2020年04月21日12时19分继续发布雷电黄色预警信号：预计未来6小时我市有雷电活动，局地伴有短时强降水、6-8级雷雨大风等强对流天气。请注意防范！

    ) : BaseEntity() {

        /**
         * 获取ID
         * @return ID
         */
        override fun getId() = alertId

    }

}