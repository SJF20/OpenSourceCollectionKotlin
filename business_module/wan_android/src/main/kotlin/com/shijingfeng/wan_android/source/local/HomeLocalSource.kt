package com.shijingfeng.wan_android.source.local

import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.network.extension.onFailure
import com.shijingfeng.network.extension.onSuccess
import com.shijingfeng.wan_android.database.room.WanAndroidDatabase
import com.shijingfeng.wan_android.database.room.getWanAndroidDataBase
import com.shijingfeng.wan_android.entity.HomeArticleEntity
import com.shijingfeng.wan_android.entity.HomeArticleItem
import com.shijingfeng.wan_android.entity.HomeArticleItemTag
import com.shijingfeng.wan_android.entity.HomeDataEntity
import com.shijingfeng.wan_android.entity.adapter.HomeBannerItem
import com.shijingfeng.wan_android.entity.adapter.HomeBannerListItem
import com.shijingfeng.wan_android.entity.adapter.HomeTopArticleItem
import java.util.concurrent.Executors

/** 单例实例 */
@Volatile
private var sInstance: HomeLocalSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getHomeLocalSourceInstance(): HomeLocalSource {
    if (sInstance == null) {
        synchronized(HomeLocalSource::class.java) {
            if (sInstance == null) {
                sInstance = HomeLocalSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 首页 本地源
 * Date: 2020/5/10 20:38
 * Description:
 * Author: ShiJingFeng
 */
internal class HomeLocalSource : BaseLocalSource() {

    private val mExecutorService = Executors.newSingleThreadExecutor()
    private var mWanAndroidDatabase: WanAndroidDatabase? = null

    /**
     * 获取首页数据
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getHomeDataList(onSuccess: onSuccess<HomeDataEntity?>, onFailure: onFailure) {
        mExecutorService.execute {
            try {
                mWanAndroidDatabase = getWanAndroidDataBase()
                mWanAndroidDatabase?.run {
                    val homeBannerList = getHomeBannerDao().getAll()
                    val homeTopArticleCombineList = getHomeTopArticleDao().getAll()
                    val homeArticleCombineList = getHomeArticleDao().getAll()
                    val homeDataNetwork = HomeDataEntity()

                    // 首页轮播图
                    val homeBannerList1 = mutableListOf<HomeBannerItem>()

                    homeBannerList?.forEach { homeBanner ->
                        homeBannerList1.add(HomeBannerItem().apply {
                            identity = homeBanner.identity
                            desc = homeBanner.desc
                            imagePath = homeBanner.imagePath
                            isVisible = homeBanner.isVisible
                            order = homeBanner.order
                            title = homeBanner.title
                            type = homeBanner.type
                            url = homeBanner.url
                        })
                    }

                    // 首页置顶文章
                    val homeTopArticleItemList = mutableListOf<HomeTopArticleItem>()

                    homeTopArticleCombineList?.forEach { homeTopArticleCombine ->
                        homeTopArticleItemList.add(HomeTopArticleItem().apply {
                            identity = homeTopArticleCombine.homeTopArticle?.identity ?: 0
                            apkLink = homeTopArticleCombine.homeTopArticle?.apkLink ?: ""
                            audit = homeTopArticleCombine.homeTopArticle?.audit ?: 0
                            author = homeTopArticleCombine.homeTopArticle?.author ?: ""
                            chapterId = homeTopArticleCombine.homeTopArticle?.chapterId ?: 0
                            chapterName = homeTopArticleCombine.homeTopArticle?.chapterName ?: ""
                            collected = homeTopArticleCombine.homeTopArticle?.collected != 0
                            courseId = homeTopArticleCombine.homeTopArticle?.courseId ?: 0
                            desc = homeTopArticleCombine.homeTopArticle?.desc ?: ""
                            envelopePic = homeTopArticleCombine.homeTopArticle?.envelopePic ?: ""
                            fresh = homeTopArticleCombine.homeTopArticle?.fresh != 0
                            link = homeTopArticleCombine.homeTopArticle?.link ?: ""
                            niceDate = homeTopArticleCombine.homeTopArticle?.niceDate ?: ""
                            niceShareDate = homeTopArticleCombine.homeTopArticle?.niceShareDate ?: ""
                            origin = homeTopArticleCombine.homeTopArticle?.origin ?: ""
                            prefix = homeTopArticleCombine.homeTopArticle?.prefix ?: ""
                            projectLink = homeTopArticleCombine.homeTopArticle?.projectLink ?: ""
                            publishTime = homeTopArticleCombine.homeTopArticle?.publishTime ?: 0L
                            selfVisible = homeTopArticleCombine.homeTopArticle?.selfVisible ?: 0
                            shareDate = homeTopArticleCombine.homeTopArticle?.shareDate ?: 0L
                            shareUser = homeTopArticleCombine.homeTopArticle?.shareUser ?: ""
                            superChapterId = homeTopArticleCombine.homeTopArticle?.superChapterId ?: 0
                            superChapterName = homeTopArticleCombine.homeTopArticle?.superChapterName ?: ""
                            tagList = homeTopArticleCombine.homeTopArticleTagList?.map { homeTopArticleTag ->
                                HomeArticleItemTag().apply {
                                    name = homeTopArticleTag.name
                                    url = homeTopArticleTag.url
                                }
                            } ?: mutableListOf()
                            title = homeTopArticleCombine.homeTopArticle?.title ?: ""
                            itemType = homeTopArticleCombine.homeTopArticle?.itemType ?: 0
                            userId = homeTopArticleCombine.homeTopArticle?.userId ?: 0
                            visible = homeTopArticleCombine.homeTopArticle?.visible ?: 0
                            zan = homeTopArticleCombine.homeTopArticle?.zan ?: 0
                        })
                    }

                    // 首页置顶文章
                    val homeArticle = HomeArticleEntity(
                        curPage = -1
                    )

                    homeArticleCombineList?.forEach { homeArticleCombine ->
                        homeArticle.dataList.add(HomeArticleItem().apply {
                            identity = homeArticleCombine.homeArticle?.identity ?: 0
                            apkLink = homeArticleCombine.homeArticle?.apkLink ?: ""
                            audit = homeArticleCombine.homeArticle?.audit ?: 0
                            author = homeArticleCombine.homeArticle?.author ?: ""
                            chapterId = homeArticleCombine.homeArticle?.chapterId ?: 0
                            chapterName = homeArticleCombine.homeArticle?.chapterName ?: ""
                            collected = homeArticleCombine.homeArticle?.collected != 0
                            courseId = homeArticleCombine.homeArticle?.courseId ?: 0
                            desc = homeArticleCombine.homeArticle?.desc ?: ""
                            envelopePic = homeArticleCombine.homeArticle?.envelopePic ?: ""
                            fresh = homeArticleCombine.homeArticle?.fresh != 0
                            link = homeArticleCombine.homeArticle?.link ?: ""
                            niceDate = homeArticleCombine.homeArticle?.niceDate ?: ""
                            niceShareDate = homeArticleCombine.homeArticle?.niceShareDate ?: ""
                            origin = homeArticleCombine.homeArticle?.origin ?: ""
                            prefix = homeArticleCombine.homeArticle?.prefix ?: ""
                            projectLink = homeArticleCombine.homeArticle?.projectLink ?: ""
                            publishTime = homeArticleCombine.homeArticle?.publishTime ?: 0L
                            selfVisible = homeArticleCombine.homeArticle?.selfVisible ?: 0
                            shareDate = homeArticleCombine.homeArticle?.shareDate ?: 0L
                            shareUser = homeArticleCombine.homeArticle?.shareUser ?: ""
                            superChapterId = homeArticleCombine.homeArticle?.superChapterId ?: 0
                            superChapterName = homeArticleCombine.homeArticle?.superChapterName ?: ""
                            tagList = homeArticleCombine.homeArticleTagList?.map { homeArticleTag ->
                                HomeArticleItemTag().apply {
                                    name = homeArticleTag.name
                                    url = homeArticleTag.url
                                }
                            } ?: mutableListOf()
                            title = homeArticleCombine.homeArticle?.title ?: ""
                            itemType = homeArticleCombine.homeArticle?.itemType ?: 0
                            userId = homeArticleCombine.homeArticle?.userId ?: 0
                            visible = homeArticleCombine.homeArticle?.visible ?: 0
                            zan = homeArticleCombine.homeArticle?.zan ?: 0
                        })
                    }

                    homeDataNetwork.homeBannerListItem = HomeBannerListItem(homeBannerList1)
                    homeDataNetwork.homeTopArticleItemList = homeTopArticleItemList
                    homeDataNetwork.homeArticle = homeArticle
                    onSuccess(homeDataNetwork)
                }
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
                onFailure(null)
            }
        }
    }

    /**
     * 清除数据
     */
    override fun onCleared() {
        super.onCleared()
        mWanAndroidDatabase?.close()
        mExecutorService.shutdownNow()
    }
}