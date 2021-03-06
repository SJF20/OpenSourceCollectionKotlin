package com.shijingfeng.wan_android.adapter

import android.content.Context
import android.text.TextUtils
import android.view.View.OnClickListener
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.ImageView
import com.shijingfeng.base_adapter.BaseAdapter
import com.shijingfeng.base_adapter.viewholder.CommonViewHolder
import com.shijingfeng.base.util.cast
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.base.util.image_load.ImageLoader
import com.shijingfeng.base.util.image_load.getImageLoaderInstance
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.common.constant.ARTICLE_ITEM_COLLECTION
import com.shijingfeng.wan_android.common.constant.PART_UPDATE_COLLECTION_STATUS
import com.shijingfeng.wan_android.common.constant.PART_UPDATE_FLAG
import com.shijingfeng.wan_android.common.constant.PART_UPDATE_THEME
import com.shijingfeng.wan_android.common.constant.VIEW_ARTICLE_DETAIL
import com.shijingfeng.wan_android.common.global.setThemeButtonDrawable
import com.shijingfeng.wan_android.entity.ProjectChildItem

/**
 * Function: 项目 二级数据 列表适配器
 * Date: 20-5-3 下午5:01
 * Description:
 * Author: shijingfeng
 */
internal class ProjectChildAdapter(
    context: Context,
    dataList: List<ProjectChildItem>? = null
) : BaseAdapter<ProjectChildItem>(context, R.layout.adapter_item_wan_android_project_child, dataList) {

    /**
     * 用户自定义处理数据 (单个Item内 全局刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     */
    override fun convert(holder: CommonViewHolder, data: ProjectChildItem, position: Int) {
        val imagePath = data.envelopePic
        val author = data.author
        val shareUser = data.shareUser
        val niceDate = data.niceDate
        val title = data.title
        val intro = data.desc
        val firstType = data.superChapterName
        val secondType = data.chapterName
        val isCollected = data.collected

        holder.run {
            // 图片
            getImageLoaderInstance().displayImage(context, getView(R.id.iv_image)!!, imagePath)
            // 原作者 或 转载人
            setText(R.id.tv_author, if (TextUtils.isEmpty(author)) shareUser else author)
            // 文章日期 或 转载日期
            setText(R.id.tv_date_time, niceDate)
            // 标题
            setText(R.id.tv_title, title)
            // 简介
            setText(R.id.tv_intro, intro)
            // 领域名称 (例如: 跨平台)
            setText(R.id.tv_first_type, firstType)
            // 方向名称 (例如: Flutter)
            setText(R.id.tv_second_type, if (TextUtils.isEmpty(secondType)) "" else " / $secondType")
            // 是否已收藏
            setChecked(R.id.ckb_collection, isCollected)

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
        data: ProjectChildItem,
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