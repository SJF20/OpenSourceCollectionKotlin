package com.shijingfeng.wan_android.adapter

import android.content.Context
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.view.View.OnClickListener
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.LinearLayout
import android.widget.TextView
import com.blankj.utilcode.util.ConvertUtils
import com.blankj.utilcode.util.ScreenUtils
import com.shijingfeng.base_adapter.BaseAdapter
import com.shijingfeng.base_adapter.viewholder.CommonViewHolder
import com.shijingfeng.base.util.*
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.common.constant.ARTICLE_ITEM_COLLECTION
import com.shijingfeng.wan_android.common.constant.PART_UPDATE_COLLECTION_STATUS
import com.shijingfeng.wan_android.common.constant.PART_UPDATE_FLAG
import com.shijingfeng.wan_android.common.constant.PART_UPDATE_THEME
import com.shijingfeng.wan_android.common.constant.VIEW_ARTICLE_DETAIL
import com.shijingfeng.wan_android.common.global.setThemeBackground
import com.shijingfeng.wan_android.common.global.setThemeButtonDrawable
import com.shijingfeng.wan_android.common.global.setThemeTextColor
import com.shijingfeng.wan_android.entity.OfficialAccountChildItem
import java.util.*

/**
 * Function: 公众号 二级数据 列表适配器
 * Date: 2020/2/3 21:54
 * Description:
 * Author: ShiJingFeng
 */
internal class OfficialAccountChildAdapter(
    context: Context,
    dataList: List<OfficialAccountChildItem>? = null
) : BaseAdapter<OfficialAccountChildItem>(context, R.layout.adapter_item_wan_android_official_account_child, dataList) {

    /**
     * 用户自定义处理数据 (单个Item内 全局刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     */
    override fun convert(
        holder: CommonViewHolder,
        data: OfficialAccountChildItem,
        position: Int
    ) {
        val isFresh = data.fresh
        val tagList = data.tagList
        val author = data.author
        val shareUser = data.shareUser
        val niceDate = data.niceDate
        val title = data.title
        val firstType = data.superChapterName
        val secondType = data.chapterName
        val isCollected = data.collected

        holder.run {
            // "新"
            setVisibility(R.id.tv_latest, if (isFresh) View.VISIBLE else View.GONE)
            setTag(
                viewId = R.id.tv_latest,
                tag = getStringById(R.string.置顶标签或新标签TAG)
            )
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

            //查看详情
            setOnClickListener(
                viewId = R.id.ll_article_content,
                listener = OnClickListener { v ->
                    onItemEvent?.invoke(v, data, holder.adapterPosition,
                        VIEW_ARTICLE_DETAIL
                    )
                }
            )
            //收藏或取消收藏
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

        // 普通标签 View 列表 容器
        val llTagList = holder.getView<LinearLayout>(R.id.ll_tag_list)
        // 普通标签 View 列表 容器
        val tagViewList = ArrayList<View>()

        //清空子View
        llTagList?.removeAllViews()
        // 添加 普通标签TextView 列表
        for (tag in tagList) {
            tagViewList.add(TextView(context).apply {
                height = ConvertUtils.dp2px(23f)
                setPadding(ConvertUtils.dp2px(5f), 0, ConvertUtils.dp2px(5f), 0)
                gravity = Gravity.CENTER
                setBackgroundResource(R.drawable.shape_tag)
                text = tag.name
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
     * 用户自定义处理数据 (单个Item内 局部刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     * @param payloads 局部刷新标记 (注：为什么是List，而不是Object, 因为在Item中的View刷新之前，可能存在短时间刷新多次，所以就会有多个占位符存入List中)
     */
    override fun partialConvert(
        holder: CommonViewHolder,
        data: OfficialAccountChildItem,
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
                        val collected = data.collected

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

                            //收藏 或 取消收藏
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
                    // 更新主题
                    PART_UPDATE_THEME -> {
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
        }
    }

}