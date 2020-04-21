package com.shijingfeng.wan_android.adapter

import android.content.Context
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.LinearLayout
import android.widget.TextView
import com.blankj.utilcode.util.ConvertUtils
import com.blankj.utilcode.util.ScreenUtils
import com.blankj.utilcode.util.SizeUtils.dp2px
import com.shijingfeng.base.base.adapter.BaseMultiItemAdapter
import com.shijingfeng.base.base.adapter.support.MultiItemTypeSupport
import com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder
import com.shijingfeng.base.util.*
import com.shijingfeng.sjf_banner.library.banner.entity.BaseIndicatorData
import com.shijingfeng.sjf_banner.library.banner.entity.CombineIndicatorData
import com.shijingfeng.sjf_banner.library.banner.entity.ShapeIndicatorData
import com.shijingfeng.sjf_banner.library.banner.entity.TitleIndicatorData
import com.shijingfeng.sjf_banner.library.banner.view.BannerView
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.constant.*
import com.shijingfeng.wan_android.entity.adapter.HomeBannerListItem
import com.shijingfeng.wan_android.entity.adapter.HomeItem
import com.shijingfeng.wan_android.entity.adapter.HomeTopArticleItem
import com.shijingfeng.wan_android.entity.network.HomeArticleItem
import java.util.*


/**
 * Function: 首页 列表适配器
 * Date: 2020/2/3 21:54
 * Description:
 * @author ShiJingFeng
 */
internal class HomeAdapter(
    context: Context,
    dataList: List<HomeItem>? = null,
    multiItemTypeSupport: MultiItemTypeSupport<HomeItem>
) : BaseMultiItemAdapter<HomeItem>(context, dataList, multiItemTypeSupport) {

    /** 轮播图当前下标  null: 最初状态 (下标为 0)  not null: 轮播图下标 */
    private var mBannerIndex: Int? = null

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
            HOME_BANNER -> initBannerItemData(holder, data as HomeBannerListItem)
            //置顶文章
            HOME_TOP_ARTICLE -> initTopArticleItemData(holder, data as HomeTopArticleItem)
            //文章
            HOME_ARTICLE -> initArticleItemData(holder, data as HomeArticleItem)
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
                        val collected = when(data) {
                            //文章 Item
                            is HomeArticleItem -> data.collected
                            //置顶文章 Item
                            is HomeTopArticleItem -> data.collected
                            else -> false
                        }

                        holder.run {
                            setChecked(R.id.ckb_collection, collected)
                            setButtonDrawable(R.id.ckb_collection, if (collected) R.drawable.ic_collected else R.drawable.ic_uncollected)

                            //收藏 或 取消收藏
                            setOnClickListener(
                                viewId = R.id.ckb_collection,
                                listener = OnClickListener { v ->
                                    val isChecked = (v as CompoundButton).isChecked

                                    mOnItemEvent?.invoke(v, isChecked, position, ARTICLE_ITEM_COLLECTION)
                                }
                            )
                        }
                    }
                    else -> {}
                }
            }
        }
    }

    /**
     * 初始化 轮播图 数据
     * @param holder CommonViewHolder
     * @param homeBannerItem 轮播图数据实体类
     */
    private fun initBannerItemData(holder: CommonViewHolder, homeBannerItem: HomeBannerListItem) {
        val bannerView = holder.getView<BannerView>(R.id.bv_banner)
        val homeBannerList = homeBannerItem.homeBannerList
        val titleTextList = ArrayList<String>(homeBannerList.size)

        for (homeBanner in homeBannerList) {
            titleTextList.add(homeBanner.title)
        }

        //标题指示器 数据
        val titleIndicatorData = TitleIndicatorData()
            .setCurRealPosition(mBannerIndex ?: 0)
            .setTotalRealCount(homeBannerList.size)
            .setTitleTextList(titleTextList)
            .setTitleColor(getColorById(R.color.white))
            .setTitleSize(18)
            .setTitleGravity(Gravity.START or Gravity.CENTER_VERTICAL)
        //图形指示器 数据
        val shapeIndicatorData = ShapeIndicatorData()
            .setCurRealPosition(mBannerIndex ?: 0)
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
            .setPaddingTop(dp2px(10f))
            .setPaddingBottom(dp2px(10f))
            .setPaddingStart(dp2px(10f))
            .setPaddingEnd(dp2px(10f))
            .setBackground(getDrawableById(R.color.home_banner_title_bg))
            .setIndicatorDataList(indicatorDataList)
        val pagerAdapter = HomeBannerPagerAdapter(mContext, homeBannerList)

        pagerAdapter.setOnItemEventListener { view: View, any: Any, pos: Int, flag: String ->
            mOnItemEvent?.invoke(view, any, pos, flag)
        }
        bannerView
            ?.setPagerAdapter(pagerAdapter)
            ?.setCurrentRealItem(mBannerIndex ?: 0, false)
            ?.setIndicator(combineIndicatorData)
            ?.start()
    }

    /**
     * 初始化 置顶文章 数据
     * @param holder CommonViewHolder
     * @param homeSetToTopItem 置顶文章数据实体类
     */
    private fun initTopArticleItemData(holder: CommonViewHolder, homeSetToTopItem: HomeTopArticleItem) {
        val isFresh = homeSetToTopItem.fresh
        val tagList = homeSetToTopItem.tagList
        val author = homeSetToTopItem.author
        val shareUser = homeSetToTopItem.shareUser
        val niceDate = homeSetToTopItem.niceDate
        val title = homeSetToTopItem.title
        val firstType = homeSetToTopItem.superChapterName
        val secondType = homeSetToTopItem.chapterName
        val isCollected = homeSetToTopItem.collected

        holder.run {
            // "新" 醒目标签
            setVisibility(R.id.tv_latest, if (isFresh) View.VISIBLE else View.GONE)
            // 原作者 或 转载人
            setText(R.id.tv_author, if (TextUtils.isEmpty(author)) shareUser else author)
            // 文章日期 或 转载日期
            setText(R.id.tv_date_time, niceDate)
            // 标题
            setText(R.id.tv_title, title)
            // 领域名称 (例如: 跨平台)
            setText(R.id.tv_first_type, firstType)
            // 方向名称 (例如: Flutter)
            setText(R.id.tv_second_type, if (TextUtils.isEmpty(secondType)) "" else " / $secondType")
            // 是否已收藏
            setChecked(R.id.ckb_collection, isCollected)
            setButtonDrawable(R.id.ckb_collection, if (isCollected) R.drawable.ic_collected else R.drawable.ic_uncollected)

            //查看详情
            setOnClickListener(
                viewId = R.id.ll_top_article_content,
                listener = OnClickListener { v ->
                    mOnItemEvent?.invoke(v, homeSetToTopItem, holder.adapterPosition, VIEW_ARTICLE_DETAIL)
                }
            )
            //收藏或取消收藏
            setOnClickListener(
                viewId = R.id.ckb_collection,
                listener = OnClickListener { v ->
                    val isChecked = (v as CompoundButton).isChecked

                    mOnItemEvent?.invoke(v, isChecked, holder.adapterPosition, ARTICLE_ITEM_COLLECTION)
                }
            )
        }

        // 普通标签 View 列表 容器
        val llTagList = holder.getView<LinearLayout>(R.id.ll_tag_list)
        // 普通标签 View 列表
        val tagViewList = ArrayList<View>()

        //清空子View
        llTagList?.removeAllViews()
        // 添加 普通标签TextView 列表
        for (homeArticleItemTag in tagList) {
            tagViewList.add(TextView(mContext).apply {
                height = ConvertUtils.dp2px(23f)
                setPadding(ConvertUtils.dp2px(5f), 0, ConvertUtils.dp2px(5f), 0)
                gravity = Gravity.CENTER
                setBackgroundResource(R.drawable.shape_home_article_tag)
                text = homeArticleItemTag.name
                setTextColor(getColorById(R.color.dodger_blue))
            })
        }

        // 测量得到 标签列表 可容纳的最大宽度
        val tagListMaxWidth = ScreenUtils.getScreenWidth() - 2 * ConvertUtils.dp2px(15f) - measureTotalWidth(
            // "置顶" 醒目标签
            holder.getView(R.id.tv_set_to_top),
            // "新" 醒目标签
            holder.getView(R.id.tv_latest),
            // 原作者 或 转载者
            holder.getView(R.id.tv_author),
            // 文章日期 或 转载日期
            holder.getView(R.id.tv_date_time)
        )

        if (llTagList != null) {
            // 对 普通标签TextView 进行整体布局 (按控件宽度逐行排列，没有固定列数)
            layout(
                llTagList,
                tagViewList,
                tagListMaxWidth,
                ConvertUtils.dp2px(10f),
                Gravity.START
            )
        }
    }

    /**
     * 初始化 文章 数据
     * @param holder CommonViewHolder
     * @param homeArticleItem 文章数据实体类
     */
    private fun initArticleItemData(holder: CommonViewHolder, homeArticleItem: HomeArticleItem) {
        val isFresh = homeArticleItem.fresh
        val tagList = homeArticleItem.tagList
        val author = homeArticleItem.author
        val shareUser = homeArticleItem.shareUser
        val niceDate = homeArticleItem.niceDate
        val title = homeArticleItem.title
        val firstType = homeArticleItem.superChapterName
        val secondType = homeArticleItem.chapterName
        val isCollected = homeArticleItem.collected

        holder.run {
            // "新"
            setVisibility(R.id.tv_latest, if (isFresh) View.VISIBLE else View.GONE)
            // 原作者 或 转载人
            setText(R.id.tv_author, if (TextUtils.isEmpty(author)) shareUser else author)
            // 文章日期 或 转载日期
            setText(R.id.tv_date_time, niceDate)
            // 标题
            setText(R.id.tv_title, title)
            // 领域名称 (例如: 跨平台)
            setText(R.id.tv_first_type, firstType)
            // 方向名称 (例如: Flutter)
            setText(R.id.tv_second_type, if (TextUtils.isEmpty(secondType)) "" else " / $secondType")
            // 是否已收藏
            setChecked(R.id.ckb_collection, isCollected)
            setButtonDrawable(R.id.ckb_collection, if (isCollected) R.drawable.ic_collected else R.drawable.ic_uncollected)

            //查看详情
            setOnClickListener(
                viewId = R.id.ll_article_content,
                listener = OnClickListener { v ->
                    mOnItemEvent?.invoke(v, homeArticleItem, holder.adapterPosition, VIEW_ARTICLE_DETAIL)
                }
            )
            //收藏或取消收藏
            setOnClickListener(
                viewId = R.id.ckb_collection,
                listener = OnClickListener { v ->
                    val isChecked = (v as CompoundButton).isChecked

                    mOnItemEvent?.invoke(v, isChecked, holder.adapterPosition, ARTICLE_ITEM_COLLECTION)
                }
            )
        }

        // 普通标签 View 列表 容器
        val llTagList = holder.getView<LinearLayout>(R.id.ll_tag_list)
        // 普通标签 View 列表 容器
        val tagViewList = ArrayList<View>()

        //清空子View
        llTagList?.removeAllViews()
        // 添加 普通标签TextView 列表
        for (homeArticleItemTag in tagList) {
            tagViewList.add(TextView(mContext).apply {
                height = ConvertUtils.dp2px(23f)
                setPadding(ConvertUtils.dp2px(5f), 0, ConvertUtils.dp2px(5f), 0)
                gravity = Gravity.CENTER
                setBackgroundResource(R.drawable.shape_home_article_tag)
                text = homeArticleItemTag.name
                setTextColor(getColorById(R.color.dodger_blue))
            })
        }

        // 测量得到 标签列表 可容纳的最大宽度
        val tagListMaxWidth = ScreenUtils.getScreenWidth() - 2 * ConvertUtils.dp2px(15f) - measureTotalWidth(
            // "新" 醒目标签
            holder.getView(R.id.tv_latest),
            // 原作者 或 转载者
            holder.getView(R.id.tv_author),
            // 文章日期 或 转载日期
            holder.getView(R.id.tv_date_time)
        )

        if (llTagList != null) {
            // 对 普通标签TextView 进行整体布局 (按控件宽度逐行排列，没有固定列数)
            layout(
                llTagList,
                tagViewList,
                tagListMaxWidth,
                ConvertUtils.dp2px(10f),
                Gravity.START
            )
        }
    }

    /**
     * View 绑定到 Window 上 (可见)
     */
    override fun onViewAttachedToWindow(holder: CommonViewHolder) {
        super.onViewAttachedToWindow(holder)
        val position = holder.layoutPosition
        val itemType = getItemViewType(position)

        if (itemType == HOME_BANNER) {
            val bannerView = holder.getView<BannerView>(R.id.bv_banner)

            bannerView?.currentRealItem = mBannerIndex ?: 0
        }
    }

    /**
     * View 从 Window 上解绑 (不可见)
     */
    override fun onViewDetachedFromWindow(holder: CommonViewHolder) {
        val position = holder.layoutPosition
        val itemType = getItemViewType(position)

        if (itemType == HOME_BANNER) {
            val bannerView = holder.getView<BannerView>(R.id.bv_banner)

            // 记录当前 轮播图 下标
            mBannerIndex = if (mBannerIndex == null) 0 else bannerView?.currentRealItem
        }
        super.onViewDetachedFromWindow(holder)
    }

    /**
     * View 被销毁
     */
    override fun onViewRecycled(holder: CommonViewHolder) {
        val position = holder.layoutPosition
        val itemType = getItemViewType(position)

        if (itemType == HOME_BANNER) {
            val bannerView = holder.getView<BannerView>(R.id.bv_banner)

            // 销毁 BannerView 防止内存泄漏
            bannerView?.destroy()
        }
        super.onViewRecycled(holder)
    }

    /**
     * 全部数据视图更新
     */
    fun notifyDataChanged() {
        mBannerIndex = null
        notifyDataSetChanged()
    }

}