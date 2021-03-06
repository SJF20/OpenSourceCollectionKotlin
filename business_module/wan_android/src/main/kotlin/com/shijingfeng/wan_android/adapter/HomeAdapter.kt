package com.shijingfeng.wan_android.adapter

import android.content.Context
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.LinearLayout
import android.widget.TextView
import com.blankj.utilcode.util.ConvertUtils
import com.blankj.utilcode.util.ScreenUtils
import com.blankj.utilcode.util.SizeUtils.dp2px
import com.shijingfeng.base_adapter.viewholder.CommonViewHolder
import com.shijingfeng.base.util.*
import com.shijingfeng.base_adapter.BaseMultiItemAdapter
import com.shijingfeng.base_adapter.support.MultiItemTypeSupport
import com.shijingfeng.sjf_banner.banner.entity.BaseIndicatorData
import com.shijingfeng.sjf_banner.banner.entity.CombineIndicatorData
import com.shijingfeng.sjf_banner.banner.entity.ShapeIndicatorData
import com.shijingfeng.sjf_banner.banner.entity.TitleIndicatorData
import com.shijingfeng.sjf_banner.banner.view.BannerView
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.common.constant.ARTICLE_ITEM_COLLECTION
import com.shijingfeng.wan_android.common.constant.HOME_ARTICLE
import com.shijingfeng.wan_android.common.constant.HOME_BANNER
import com.shijingfeng.wan_android.common.constant.HOME_TOP_ARTICLE
import com.shijingfeng.wan_android.common.constant.PART_UPDATE_COLLECTION_STATUS
import com.shijingfeng.wan_android.common.constant.PART_UPDATE_FLAG
import com.shijingfeng.wan_android.common.constant.PART_UPDATE_THEME
import com.shijingfeng.wan_android.common.constant.VIEW_ARTICLE_DETAIL
import com.shijingfeng.wan_android.common.global.setThemeBackground
import com.shijingfeng.wan_android.common.global.setThemeButtonDrawable
import com.shijingfeng.wan_android.common.global.setThemeTextColor
import com.shijingfeng.wan_android.entity.adapter.HomeBannerListItem
import com.shijingfeng.wan_android.entity.adapter.HomeItem
import com.shijingfeng.wan_android.entity.adapter.HomeTopArticleItem
import com.shijingfeng.wan_android.entity.HomeArticleItem
import java.util.*


/**
 * Function: ?????? ???????????????
 * Date: 2020/2/3 21:54
 * Description:
 * Author: ShiJingFeng
 */
internal class HomeAdapter(
    context: Context,
    dataList: List<HomeItem>? = null,
    multiItemTypeSupport: MultiItemTypeSupport<HomeItem>
) : BaseMultiItemAdapter<HomeItem>(
    context = context,
    dataList = dataList,
    multiItemTypeSupport = multiItemTypeSupport
) {

    /** ?????????????????????  null: ???????????? (????????? 0)  not null: ??????????????? */
    private var mBannerIndex: Int? = null

    /**
     * ??????????????????????????? (??????Item??? ????????????)
     * @param holder ViewHolder
     * @param data ??????
     * @param position ????????????
     */
    override fun convert(
        holder: CommonViewHolder,
        data: HomeItem,
        position: Int
    ) {
        when(data.getType()) {
            //?????????
            HOME_BANNER -> initBannerItemData(holder, data as HomeBannerListItem)
            //????????????
            HOME_TOP_ARTICLE -> initTopArticleItemData(holder, data as HomeTopArticleItem)
            //??????
            HOME_ARTICLE -> initArticleItemData(holder, data as HomeArticleItem)
        }
    }

    /**
     * ??????????????????????????? (??????Item??? ????????????)
     * @param holder ViewHolder
     * @param data ??????
     * @param position ????????????
     * @param payloads ?????????????????? (??????????????????List????????????Object, ?????????Item??????View???????????????????????????????????????????????????????????????????????????????????????List???)
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
                    //??????????????????
                    PART_UPDATE_COLLECTION_STATUS -> {
                        val collected = when(data) {
                            //?????? Item
                            is HomeArticleItem -> data.collected
                            //???????????? Item
                            is HomeTopArticleItem -> data.collected
                            else -> false
                        }

                        holder.run {
                            setChecked(R.id.ckb_collection, collected)

                            if (collected) {
                                setThemeButtonDrawable(
                                    getView<CheckBox>(R.id.ckb_collection)!!,
                                    resName = getStringById(R.string.drawable_id_ic_collected)
                                )
                            } else {
                                setButtonDrawable(R.id.ckb_collection, R.drawable.ic_uncollected)
                            }

                            //?????? ??? ????????????
                            setOnClickListener(
                                viewId = R.id.ckb_collection,
                                listener = OnClickListener { v ->
                                    val isChecked = (v as CompoundButton).isChecked

                                    onItemEvent?.invoke(v, isChecked, position,
                                        ARTICLE_ITEM_COLLECTION
                                    )
                                }
                            )
                        }
                    }
                    // ????????????
                    PART_UPDATE_THEME -> {
                        when (data) {
                            // ????????????
                            is HomeTopArticleItem -> {
                                setThemeBackground(
                                    holder.getView(R.id.tv_set_to_top)!!,
                                    holder.getView(R.id.tv_latest)!!,
                                    resName = getStringById(R.string.drawable_id_shape_set_to_top_bg)
                                )
                                setThemeTextColor(
                                    holder.getView(R.id.tv_set_to_top)!!,
                                    holder.getView(R.id.tv_latest)!!
                                )
                                if (data.collected) {
                                    setThemeButtonDrawable(
                                        holder.getView<CheckBox>(R.id.ckb_collection)!!,
                                        resName = getStringById(R.string.drawable_id_ic_collected)
                                    )
                                } else {
                                    holder.setButtonDrawable(R.id.ckb_collection, R.drawable.ic_uncollected)
                                }
                            }
                            // ??????
                            is HomeArticleItem -> {
                                setThemeBackground(
                                    holder.getView(R.id.tv_latest)!!,
                                    resName = getStringById(R.string.drawable_id_shape_set_to_top_bg)
                                )
                                setThemeTextColor(
                                    holder.getView(R.id.tv_latest)!!
                                )
                                if (data.collected) {
                                    setThemeButtonDrawable(
                                        holder.getView<CheckBox>(R.id.ckb_collection)!!,
                                        resName = getStringById(R.string.drawable_id_ic_collected)
                                    )
                                } else {
                                    holder.setButtonDrawable(R.id.ckb_collection, R.drawable.ic_uncollected)
                                }
                            }
                            else -> {}
                        }
                    }
                    else -> {}
                }
            }
        }
    }

    /**
     * ????????? ????????? ??????
     * @param holder CommonViewHolder
     * @param homeBannerItem ????????????????????????
     */
    private fun initBannerItemData(holder: CommonViewHolder, homeBannerItem: HomeBannerListItem) {
        val bannerView = holder.getView<BannerView>(R.id.bv_banner)
        val homeBannerList = homeBannerItem.homeBannerList
        val titleTextList = ArrayList<String>(homeBannerList.size)

        for (homeBanner in homeBannerList) {
            titleTextList.add(homeBanner.title)
        }

        //??????????????? ??????
        val titleIndicatorData = TitleIndicatorData()
            .setCurRealPosition(mBannerIndex ?: 0)
            .setTotalRealCount(homeBannerList.size)
            .setTitleTextList(titleTextList)
            .setTitleColor(getColorById(R.color.white))
            .setTitleSize(18)
            .setTitleGravity(Gravity.START or Gravity.CENTER_VERTICAL)
        //??????????????? ??????
        val shapeIndicatorData = ShapeIndicatorData()
            .setCurRealPosition(mBannerIndex ?: 0)
            .setTotalRealCount(homeBannerList.size)
            .setGravity(Gravity.END or Gravity.CENTER_VERTICAL)
        //?????????????????????
        val indicatorDataList: MutableList<BaseIndicatorData<*>> = ArrayList<BaseIndicatorData<*>>().apply {
            add(titleIndicatorData)
            add(shapeIndicatorData)
        }
        //??????????????? ??????
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
        val pagerAdapter = HomeBannerPagerAdapter(context, homeBannerList)

        pagerAdapter.setOnItemEventListener { view: View, any: Any, pos: Int, flag: String ->
            onItemEvent?.invoke(view, any, pos, flag)
        }
        bannerView
            ?.setPagerAdapter(pagerAdapter)
            ?.setCurrentRealItem(mBannerIndex ?: 0, false)
            ?.setIndicator(combineIndicatorData)
            ?.start()
    }

    /**
     * ????????? ???????????? ??????
     * @param holder CommonViewHolder
     * @param homeSetToTopItem ???????????????????????????
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
            // "??????" ????????????
            setTag(
                viewId = R.id.tv_set_to_top,
                tag = getStringById(R.string.????????????????????????TAG)
            )
            // "???" ????????????
            setVisibility(R.id.tv_latest, if (isFresh) View.VISIBLE else View.GONE)
            setTag(
                viewId = R.id.tv_latest,
                tag = getStringById(R.string.????????????????????????TAG)
            )
            // ????????? ??? ?????????
            setText(R.id.tv_author, if (TextUtils.isEmpty(author)) shareUser else author)
            // ???????????? ??? ????????????
            setText(R.id.tv_date_time, niceDate)
            // ??????
            setText(R.id.tv_title, title)
            // ???????????? (??????: ?????????)
            setText(R.id.tv_first_type, firstType)
            // ???????????? (??????: Flutter)
            setText(R.id.tv_second_type, if (TextUtils.isEmpty(secondType)) "" else " / $secondType")
            // ???????????????
            setChecked(R.id.ckb_collection, isCollected)

            setThemeBackground(
                getView(R.id.tv_set_to_top)!!,
                getView(R.id.tv_latest)!!,
                resName = getStringById(R.string.drawable_id_shape_set_to_top_bg)
            )
            setThemeTextColor(
                getView(R.id.tv_set_to_top)!!,
                getView(R.id.tv_latest)!!
            )
            if (isCollected) {
                setThemeButtonDrawable(
                    getView<CheckBox>(R.id.ckb_collection)!!,
                    resName = getStringById(R.string.drawable_id_ic_collected)
                )
            } else {
                setButtonDrawable(R.id.ckb_collection, R.drawable.ic_uncollected)
            }

            //????????????
            setOnClickListener(
                viewId = R.id.ll_top_article_content,
                listener = OnClickListener { v ->
                    onItemEvent?.invoke(v, homeSetToTopItem, holder.adapterPosition,
                        VIEW_ARTICLE_DETAIL
                    )
                }
            )
            //?????????????????????
            setOnClickListener(
                viewId = R.id.ckb_collection,
                listener = OnClickListener { v ->
                    val isChecked = (v as CompoundButton).isChecked

                    onItemEvent?.invoke(v, isChecked, holder.adapterPosition,
                        ARTICLE_ITEM_COLLECTION
                    )
                }
            )
        }

        // ???????????? View ?????? ??????
        val llTagList = holder.getView<LinearLayout>(R.id.ll_tag_list)
        // ???????????? View ??????
        val tagViewList = ArrayList<View>()

        //?????????View
        llTagList?.removeAllViews()
        // ?????? ????????????TextView ??????
        for (homeArticleItemTag in tagList) {
            tagViewList.add(TextView(context).apply {
                height = ConvertUtils.dp2px(23f)
                setPadding(ConvertUtils.dp2px(5f), 0, ConvertUtils.dp2px(5f), 0)
                gravity = Gravity.CENTER
                setBackgroundResource(R.drawable.shape_tag)
                text = homeArticleItemTag.name
                setTextColor(getColorById(R.color.dodger_blue))
            })
        }

        // ???????????? ???????????? ????????????????????????
        val tagListMaxWidth = ScreenUtils.getScreenWidth() - 2 * ConvertUtils.dp2px(15f) - measureTotalWidth(
            // "??????" ????????????
            holder.getView(R.id.tv_set_to_top),
            // "???" ????????????
            holder.getView(R.id.tv_latest),
            // ????????? ??? ?????????
            holder.getView(R.id.tv_author),
            // ???????????? ??? ????????????
            holder.getView(R.id.tv_date_time)
        )

        if (llTagList != null) {
            // ??? ????????????TextView ?????????????????? (????????????????????????????????????????????????)
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
     * ????????? ?????? ??????
     * @param holder CommonViewHolder
     * @param homeArticleItem ?????????????????????
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
            // "???"
            setVisibility(R.id.tv_latest, if (isFresh) View.VISIBLE else View.GONE)
            setTag(
                viewId = R.id.tv_latest,
                tag = getStringById(R.string.????????????????????????TAG)
            )
            // ????????? ??? ?????????
            setText(R.id.tv_author, if (TextUtils.isEmpty(author)) shareUser else author)
            // ???????????? ??? ????????????
            setText(R.id.tv_date_time, niceDate)
            // ??????
            setText(R.id.tv_title, title)
            // ???????????? (??????: ?????????)
            setText(R.id.tv_first_type, firstType)
            // ???????????? (??????: Flutter)
            setText(R.id.tv_second_type, if (TextUtils.isEmpty(secondType)) "" else " / $secondType")
            // ???????????????
            setChecked(R.id.ckb_collection, isCollected)

            setThemeBackground(
                getView(R.id.tv_latest)!!,
                resName = getStringById(R.string.drawable_id_shape_set_to_top_bg)
            )
            setThemeTextColor(
                getView(R.id.tv_latest)!!
            )
            if (isCollected) {
                setThemeButtonDrawable(
                    getView<CheckBox>(R.id.ckb_collection)!!,
                    resName = getStringById(R.string.drawable_id_ic_collected)
                )
            } else {
                setButtonDrawable(R.id.ckb_collection, R.drawable.ic_uncollected)
            }

            //????????????
            setOnClickListener(
                viewId = R.id.ll_article_content,
                listener = OnClickListener { v ->
                    onItemEvent?.invoke(v, homeArticleItem, holder.adapterPosition,
                        VIEW_ARTICLE_DETAIL
                    )
                }
            )
            //?????????????????????
            setOnClickListener(
                viewId = R.id.ckb_collection,
                listener = OnClickListener { v ->
                    val isChecked = (v as CompoundButton).isChecked

                    onItemEvent?.invoke(v, isChecked, holder.adapterPosition,
                        ARTICLE_ITEM_COLLECTION
                    )
                }
            )
        }

        // ???????????? View ?????? ??????
        val llTagList = holder.getView<LinearLayout>(R.id.ll_tag_list)
        // ???????????? View ?????? ??????
        val tagViewList = ArrayList<View>()

        //?????????View
        llTagList?.removeAllViews()
        // ?????? ????????????TextView ??????
        for (homeArticleItemTag in tagList) {
            tagViewList.add(TextView(context).apply {
                height = ConvertUtils.dp2px(23f)
                setPadding(ConvertUtils.dp2px(5f), 0, ConvertUtils.dp2px(5f), 0)
                gravity = Gravity.CENTER
                setBackgroundResource(R.drawable.shape_tag)
                text = homeArticleItemTag.name
                setTextColor(getColorById(R.color.dodger_blue))
            })
        }

        // ???????????? ???????????? ????????????????????????
        val tagListMaxWidth = ScreenUtils.getScreenWidth() - 2 * ConvertUtils.dp2px(15f) - measureTotalWidth(
            // "???" ????????????
            holder.getView(R.id.tv_latest),
            // ????????? ??? ?????????
            holder.getView(R.id.tv_author),
            // ???????????? ??? ????????????
            holder.getView(R.id.tv_date_time)
        )

        if (llTagList != null) {
            // ??? ????????????TextView ?????????????????? (????????????????????????????????????????????????)
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
     * View ????????? Window ??? (??????)
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
     * View ??? Window ????????? (?????????)
     */
    override fun onViewDetachedFromWindow(holder: CommonViewHolder) {
        val position = holder.layoutPosition
        val itemType = getItemViewType(position)

        if (itemType == HOME_BANNER) {
            val bannerView = holder.getView<BannerView>(R.id.bv_banner)

            // ???????????? ????????? ??????
            mBannerIndex = if (mBannerIndex == null) 0 else bannerView?.currentRealItem
        }
        super.onViewDetachedFromWindow(holder)
    }

    /**
     * View ?????????
     */
    override fun onViewRecycled(holder: CommonViewHolder) {
        val position = holder.layoutPosition
        val itemType = getItemViewType(position)

        if (itemType == HOME_BANNER) {
            val bannerView = holder.getView<BannerView>(R.id.bv_banner)

            // ?????? BannerView ??????????????????
            bannerView?.destroy()
        }
        super.onViewRecycled(holder)
    }

    /**
     * ????????????????????????
     */
    fun notifyDataChanged() {
        mBannerIndex = null
        notifyDataSetChanged()
    }

}