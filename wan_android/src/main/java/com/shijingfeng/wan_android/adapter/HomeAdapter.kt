package com.shijingfeng.wan_android.adapter

import android.content.Context
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.widget.CompoundButton
import android.widget.LinearLayout
import android.widget.TextView
import com.blankj.utilcode.util.ClickUtils
import com.blankj.utilcode.util.ConvertUtils
import com.blankj.utilcode.util.ResourceUtils
import com.blankj.utilcode.util.ScreenUtils
import com.shijingfeng.base.base.adapter.common.CommonMultiItemAdapter
import com.shijingfeng.base.base.adapter.common.support.MultiItemTypeSupport
import com.shijingfeng.base.base.adapter.common.viewholder.CommonViewHolder
import com.shijingfeng.base.util.cast
import com.shijingfeng.base.util.layout
import com.shijingfeng.library.banner.entity.BaseIndicatorData
import com.shijingfeng.library.banner.entity.CombineIndicatorData
import com.shijingfeng.library.banner.entity.ShapeIndicatorData
import com.shijingfeng.library.banner.entity.TitleIndicatorData
import com.shijingfeng.library.banner.view.BannerView
import com.shijingfeng.library.util.DensityUtil
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.constant.*
import com.shijingfeng.wan_android.entity.adapter.HomeBannerItem
import com.shijingfeng.wan_android.entity.adapter.HomeItem
import com.shijingfeng.wan_android.entity.adapter.HomeSetToTopItem
import com.shijingfeng.wan_android.entity.network.HomeArticleItem
import com.shijingfeng.wan_android.entity.network.HomeBannerEntity
import java.util.*


/**
 * Function: 首页 列表适配器
 * Date: 2020/2/3 21:54
 * Description:
 * @author ShiJingFeng
 */
class HomeAdapter(
    context: Context,
    dataList: List<HomeItem>? = null,
    multiItemTypeSupport: MultiItemTypeSupport<HomeItem>
) : CommonMultiItemAdapter<HomeItem>(context, dataList, multiItemTypeSupport) {

    private var mBannerIndex = 0

    /**
     * 用户自定义处理数据 (单个Item内 全局刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     */
    override fun convert(
        holder: CommonViewHolder,
        data: HomeItem,
        position: Int
    ) {
        when(data.getType()) {
            //轮播图
            HOME_BANNER -> {
                val bannerView = holder.getView<BannerView>(R.id.bv_banner)

                val homeBannerItem = data as HomeBannerItem
                val homeBannerList: List<HomeBannerEntity> = homeBannerItem.homeBannerList
                val titleTextList = ArrayList<String>(homeBannerList.size)

                for (homeBanner in homeBannerList) {
                    titleTextList.add(homeBanner.title)
                }

                //标题指示器 数据
                val titleIndicatorData = TitleIndicatorData()
                    .setCurRealPosition(mBannerIndex)
                    .setTotalRealCount(homeBannerList.size)
                    .setTitleTextList(titleTextList)
                    .setTitleColor(mContext.resources.getColor(R.color.white))
                    .setTitleSize(18)
                    .setTitleGravity(Gravity.START or Gravity.CENTER_VERTICAL)
                //图形指示器 数据
                val shapeIndicatorData = ShapeIndicatorData()
                    .setCurRealPosition(mBannerIndex)
                    .setTotalRealCount(homeBannerList.size)
                    .setGravity(Gravity.END or Gravity.CENTER_VERTICAL)
                //指示器数据列表
                val indicatorDataList: MutableList<BaseIndicatorData<*>> = ArrayList<BaseIndicatorData<*>>().apply {
                    add(titleIndicatorData)
                    add(shapeIndicatorData)
                }
                //组合指示器 数据
                val combineIndicatorData = CombineIndicatorData()
                    .setWidth(ViewGroup.LayoutParams.MATCH_PARENT)
                    .setHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
                    .setGravity(Gravity.BOTTOM)
                    .setPaddingTop(DensityUtil.dp2px(10f))
                    .setPaddingBottom(DensityUtil.dp2px(10f))
                    .setPaddingStart(DensityUtil.dp2px(10f))
                    .setPaddingEnd(DensityUtil.dp2px(10f))
                    .setBackground(ResourceUtils.getDrawable(R.color.home_banner_title_bg))
                    .setIndicatorDataList(indicatorDataList)
                val pagerAdapter = HomeBannerPagerAdapter(mContext, homeBannerList)

                pagerAdapter.setOnItemEventListener { view: View, any: Any, pos: Int, flag: String ->
                    mOnItemEventListener?.invoke(view, any, pos, flag)
                }
                bannerView
                    ?.setPagerAdapter(pagerAdapter)
                    ?.setCurrentRealItem(mBannerIndex, false)
                    ?.setIndicator(combineIndicatorData)
                    ?.start()
            }
            //置顶文章
            HOME_SET_TO_TOP -> {
                val homeSetToTopItem = data as HomeSetToTopItem
                val isFresh = homeSetToTopItem.fresh
                val tagList = homeSetToTopItem.tagList
                val author = homeSetToTopItem.author
                val shareUser = homeSetToTopItem.shareUser
                val niceDate = homeSetToTopItem.niceDate
                val title = homeSetToTopItem.title
                val firstType = homeSetToTopItem.superChapterName
                val secondType = homeSetToTopItem.chapterName
                val isCollected = homeSetToTopItem.collected

                //查看详情
                ClickUtils.applySingleDebouncing(holder.itemView) { v ->
                    mOnItemEventListener?.invoke(v, homeSetToTopItem, position, VIEW_ARTICLE_DETAIL)
                }
                //收藏或取消收藏
                ClickUtils.applySingleDebouncing(holder.getView<View>(R.id.ckb_collection)) { v ->
                    val isChecked = (v as CompoundButton).isChecked

                    mOnItemEventListener?.invoke(v, isChecked, position, ARTICLE_ITEM_COLLECTION)
                }

                holder.run {
                    setVisibility(R.id.tv_latest, if (isFresh) View.VISIBLE else View.GONE)
                    setText(R.id.tv_author, if (TextUtils.isEmpty(author)) shareUser else author)
                    setText(R.id.tv_date_time, niceDate)
                    setText(R.id.tv_title, title)
                    setText(R.id.tv_first_type, firstType)
                    setText(R.id.tv_second_type, if (TextUtils.isEmpty(secondType)) "" else " / $secondType")
                    setChecked(R.id.ckb_collection, isCollected)
                    setButtonDrawable(R.id.ckb_collection, if (isCollected) R.drawable.ic_collected else R.drawable.ic_uncollected)
                }
                val llTagList = holder.getView<LinearLayout>(R.id.ll_tag_list)
                val tagViewList = ArrayList<View>()

                //清空子View
                llTagList?.removeAllViews()
                for (homeArticleItemTag in tagList) {
                    tagViewList.add(TextView(mContext).apply {
                        height = ConvertUtils.dp2px(23f)
                        setPadding(ConvertUtils.dp2px(5f), 0, ConvertUtils.dp2px(5f), 0)
                        gravity = Gravity.CENTER
                        setBackgroundResource(R.drawable.shape_home_article_tag)
                        text = homeArticleItemTag.name
                        setTextColor(mContext.resources.getColor(R.color.dodger_blue))
                    })
                }

                val tagListMaxWidth = ScreenUtils.getScreenWidth() - 2 * ConvertUtils.dp2px(15f) - measureTotalWidth(
                    holder.getView(R.id.tv_set_to_top),
                    holder.getView(R.id.tv_latest),
                    holder.getView(R.id.tv_author),
                    holder.getView(R.id.tv_date_time)
                )

                if (llTagList != null) {
                    layout(
                        llTagList,
                        tagViewList,
                        tagListMaxWidth,
                        ConvertUtils.dp2px(10f),
                        Gravity.START
                    )
                }
            }
            //文章
            HOME_ARTICLE -> {
                val homeArticleItem = data as HomeArticleItem
                val isFresh = homeArticleItem.fresh
                val tagList = homeArticleItem.tagList
                val author = homeArticleItem.author
                val shareUser = homeArticleItem.shareUser
                val niceDate = homeArticleItem.niceDate
                val title = homeArticleItem.title
                val firstType = homeArticleItem.superChapterName
                val secondType = homeArticleItem.chapterName
                val isCollected = homeArticleItem.collected

                //查看详情
                ClickUtils.applySingleDebouncing(holder.itemView) { v ->
                    mOnItemEventListener?.invoke(v, homeArticleItem, position, VIEW_ARTICLE_DETAIL)
                }
                //收藏或取消收藏
                ClickUtils.applySingleDebouncing(holder.getView<View>(R.id.ckb_collection)) { v ->
                    val isChecked = (v as CompoundButton).isChecked

                    mOnItemEventListener?.invoke(v, isChecked, position, ARTICLE_ITEM_COLLECTION)
                }

                holder.run {
                    setVisibility(R.id.tv_latest, if (isFresh) View.VISIBLE else View.GONE)
                    setText(R.id.tv_author, if (TextUtils.isEmpty(author)) shareUser else author)
                    setText(R.id.tv_date_time, niceDate)
                    setText(R.id.tv_title, title)
                    setText(R.id.tv_first_type, firstType)
                    setText(R.id.tv_second_type, if (TextUtils.isEmpty(secondType)) "" else " / $secondType")
                    setChecked(R.id.ckb_collection, isCollected)
                    setButtonDrawable(R.id.ckb_collection, if (isCollected) R.drawable.ic_collected else R.drawable.ic_uncollected)
                }

                val llTagList = holder.getView<LinearLayout>(R.id.ll_tag_list)
                val tagViewList = ArrayList<View>()

                //清空子View
                llTagList?.removeAllViews()
                for (homeArticleItemTag in tagList) {
                    tagViewList.add(TextView(mContext).apply {
                        height = ConvertUtils.dp2px(23f)
                        setPadding(ConvertUtils.dp2px(5f), 0, ConvertUtils.dp2px(5f), 0)
                        gravity = Gravity.CENTER
                        setBackgroundResource(R.drawable.shape_home_article_tag)
                        text = homeArticleItemTag.name
                        setTextColor(mContext.resources.getColor(R.color.dodger_blue))
                    })
                }

                val tagListMaxWidth = ScreenUtils.getScreenWidth() - 2 * ConvertUtils.dp2px(15f) - measureTotalWidth(
                    holder.getView(R.id.tv_latest),
                    holder.getView(R.id.tv_author),
                    holder.getView(R.id.tv_date_time)
                )

                if (llTagList != null) {
                    layout(
                        llTagList,
                        tagViewList,
                        tagListMaxWidth,
                        ConvertUtils.dp2px(10f),
                        Gravity.START
                    )
                }
            }
        }
    }

    /**
     * 用户自定义处理数据 (单个Item内 局部刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     * @param payloads 局部刷新标记 (注：为什么是List，而不是Object, 因为在Item中的View刷新之前，可能存在短时间刷新多次，所以就会有多个占位符存入List中)
     */
    override fun partialConvert(
        holder: CommonViewHolder,
        data: HomeItem,
        position: Int,
        payloads: List<Any>
    ) {
        super.partialConvert(holder, data, position, payloads)
        val any = payloads[payloads.size - 1]

        if (any is Map<*, *>) {
            val dataMap = cast<Map<String, Any>>(any)
            val partUpdateFlag = dataMap[PART_UPDATE_FLAG] as String?

            if (partUpdateFlag != null) {
                when(partUpdateFlag) {
                    //更新收藏状态
                    PART_UPDATE_COLLECTION_STATUS -> {
                        when(data) {
                            //文章 Item
                            is HomeArticleItem -> {
                                //收藏或取消收藏
                                ClickUtils.applySingleDebouncing(holder.getView<View>(R.id.ckb_collection)) { v ->
                                    val isChecked = (v as CompoundButton).isChecked

                                    mOnItemEventListener?.invoke(v, isChecked, position, ARTICLE_ITEM_COLLECTION)
                                }

                                holder.run {
                                    setChecked(R.id.ckb_collection, data.collected)
                                    setButtonDrawable(R.id.ckb_collection, if (data.collected) R.drawable.ic_collected else R.drawable.ic_uncollected)
                                }
                            }
                            //置顶文章 Item
                            is HomeSetToTopItem -> {
                                //收藏或取消收藏
                                ClickUtils.applySingleDebouncing(holder.getView<View>(R.id.ckb_collection)) { v ->
                                    val isChecked = (v as CompoundButton).isChecked

                                    mOnItemEventListener?.invoke(v, isChecked, position, ARTICLE_ITEM_COLLECTION)
                                }

                                holder.run {
                                    setChecked(R.id.ckb_collection, data.collected)
                                    setButtonDrawable(R.id.ckb_collection, if (data.collected) R.drawable.ic_collected else R.drawable.ic_uncollected)
                                }
                            }
                        }
                    }
                    else -> {}
                }
            }
        }
    }

    override fun onViewAttachedToWindow(holder: CommonViewHolder) {
        super.onViewAttachedToWindow(holder)
    }

    override fun onViewDetachedFromWindow(holder: CommonViewHolder) {
        val position = holder.layoutPosition
        val itemType = getItemViewType(position)

        if (itemType == HOME_BANNER) {
            val bannerView = holder.getView<BannerView>(R.id.bv_banner)

            mBannerIndex = bannerView?.currentRealItem ?: 0
        }
        super.onViewDetachedFromWindow(holder)
    }

    /**
     * 测量多个View的宽
     * @param viewArray View数组
     * @return 总宽度
     */
    private fun measureTotalWidth(vararg viewArray: View?): Int {
        var totalWidth = 0

        for (view in viewArray) {
            if (view == null) {
                continue
            }

            val widthMeasureSpec = View.MeasureSpec.makeMeasureSpec((1 shl 30) - 1, View.MeasureSpec.AT_MOST)
            val heightMeasureSpec = View.MeasureSpec.makeMeasureSpec((1 shl 30) - 1, View.MeasureSpec.AT_MOST)

            view.measure(widthMeasureSpec, heightMeasureSpec)

            totalWidth += if (view.layoutParams is MarginLayoutParams) {
                val marginLayoutParams = view.layoutParams as MarginLayoutParams

                view.measuredWidth + marginLayoutParams.marginStart + marginLayoutParams.marginEnd
            } else {
                view.measuredWidth
            }
        }
        return totalWidth
    }

}