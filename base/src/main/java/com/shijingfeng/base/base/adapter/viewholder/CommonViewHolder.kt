package com.shijingfeng.base.base.adapter.viewholder

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.IntRange
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.blankj.utilcode.util.ClickUtils
import com.shijingfeng.base.R
import com.shijingfeng.base.base.adapter.BaseAdapter
import com.shijingfeng.base.base.entity.BaseEntity
import com.shijingfeng.base.util.cast
import com.shijingfeng.base.util.image_load.getImageLoaderInstance

/**
 * 简单工厂模式创建对象
 */
fun createCommonViewHolder(context: Context, @LayoutRes layoutId: Int, parent: ViewGroup) : CommonViewHolder {
    val view = LayoutInflater.from(context).inflate(layoutId, parent, false)

    return CommonViewHolder(
        context,
        view
    )
}

/**
 * Function: 通用ViewHolder
 * Date: 2020/1/23 21:57
 * Description:
 * @author ShiJingFeng
 */
class CommonViewHolder constructor (
    private val mContext: Context,
    mItemView: View
) : RecyclerView.ViewHolder(mItemView) {

    private val mViewSparseArray = SparseArray<View?>()

    /**
     * 通过View Id 获取 View实例
     * @param viewId View Id
     * @return View 实例
     */
    fun <T : View> getView(@IdRes viewId: Int): T? {
        var view = mViewSparseArray[viewId]

        if (view == null) {
            view = itemView.findViewById(viewId)
            mViewSparseArray.put(viewId, view)
        }
        return if (view == null) null else cast(view)
    }

    /**
     * View 设置可见性
     * @param viewId View Id
     * @param visibility 可见性
     * @return CommonViewHolder
     */
    fun setVisibility(
        @IdRes viewId: Int,
        visibility: Int
    ): CommonViewHolder {
        getView<View>(viewId)?.visibility = visibility
        return this
    }

    /**
     * TextView 设置文本
     * @param viewId TextView Id
     * @param text 文本
     * @return CommonViewHolder
     */
    fun setText(
        @IdRes viewId: Int,
        text: String
    ): CommonViewHolder {
        getView<TextView>(viewId)?.text = text
        return this
    }

    /**
     * ImageView 设置 Drawable资源
     * @param viewId ImageView Id
     * @param resId Drawable资源 Id
     * @return CommonViewHolder
     */
    fun setImageResource(
        @IdRes viewId: Int,
        @DrawableRes resId: Int
    ): CommonViewHolder {
        getView<ImageView>(viewId)?.setImageResource(resId)
        return this
    }

    /**
     * ImageView 设置 Drawable
     * @param viewId ImageView Id
     * @param drawable Drawable
     * @return CommonViewHolder
     */
    fun setImageDrawable(
        @IdRes viewId: Int,
        drawable: Drawable
    ): CommonViewHolder {
        getView<ImageView>(viewId)?.setImageDrawable(drawable)
        return this
    }

    /**
     * ImageView 背景 Drawable (不支持换肤)
     * @param viewId View Id
     * @param drawable Drawable
     * @return CommonViewHolder
     */
    fun setBackground(
        @IdRes viewId: Int,
        drawable: Drawable
    ): CommonViewHolder {
        getView<View>(viewId)?.background = drawable
        return this
    }

    /**
     * ImageView 背景 资源 (支持换肤)
     * @param viewId View Id
     * @param drawableRes Drawable
     * @return CommonViewHolder
     */
    fun setBackgroundResource(
        @IdRes viewId: Int,
        @DrawableRes drawableRes: Int
    ): CommonViewHolder {
        getView<View>(viewId)?.setBackgroundResource(drawableRes)
        return this
    }

    /**
     * ImageView 设置 本地路径或网络路径资源
     * @param viewId ImageView Id
     * @param path 本地路径或网络路径
     * @param placeholder 占位图片 (加载中)
     * @param error 错误图片 (加载失败)
     * @return CommonViewHolder
     */
    fun setImagePath(
        @IdRes viewId: Int,
        path: String,
        @DrawableRes placeholder: Int = R.drawable.ic_image,
        @DrawableRes error: Int = R.drawable.ic_image
    ): CommonViewHolder {
        val imageView = getView<ImageView>(viewId) ?: return this

        getImageLoaderInstance().displayImage(
            context = mContext,
            imageView = imageView,
            imagePath = path,
            placeholder = placeholder,
            error = error
        )
        return this
    }

    /**
     * 设置是否选中
     * @param viewId View ID
     * @param checked true 选中  false 不选中
     * @return CommonViewHolder
     */
    fun setChecked(
        @IdRes viewId: Int,
        checked: Boolean
    ): CommonViewHolder {
        getView<CompoundButton>(viewId)?.isChecked = checked
        return this
    }

    /**
     * 设置 CompoundButton 背景图
     * @param viewId View ID
     * @param drawableRes 资源ID
     * @return CommonViewHolder
     */
    fun setButtonDrawable(
        @IdRes viewId: Int,
        @DrawableRes drawableRes: Int
    ): CommonViewHolder {
        getView<CompoundButton>(viewId)?.setButtonDrawable(drawableRes)
        return this
    }

    /**
     * 设置 CompoundButton 背景图
     * @param viewId View ID
     * @param drawable Drawable
     * @return CommonViewHolder
     */
    fun setButtonDrawable(
        @IdRes viewId: Int,
        drawable: Drawable
    ): CommonViewHolder {
        getView<CompoundButton>(viewId)?.buttonDrawable = drawable
        return this
    }

    /**
     * View 设置 是否可用
     * @param viewId View Id
     * @param enabled 是否可用
     * @return CommonViewHolder
     */
    fun setEnabled(
        @IdRes viewId: Int,
        enabled: Boolean
    ): CommonViewHolder {
        getView<View>(viewId)?.isEnabled = enabled
        return this
    }

    /**
     * RecyclerView 设置 垂直线性布局适配器
     * @param viewId RecyclerView
     * @param adapter 适配器
     * @param orientation 线性方向
     * @param <T> 泛型
     * @return CommonViewHolder
     */
    fun <T : BaseEntity> setLinearAdapter(
        @IdRes viewId: Int,
        adapter: BaseAdapter<T>,
        @RecyclerView.Orientation orientation: Int = VERTICAL
    ): CommonViewHolder {
        getView<RecyclerView>(viewId)?.let { recyclerView ->
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(mContext, orientation, false)
        }
        return this
    }

    /**
     * RecyclerView 设置 网格布局适配器
     * @param viewId RecyclerView
     * @param adapter 适配器
     * @param spanCount 网格列数
     * @param <T> 泛型
     * @return CommonViewHolder
     */
    fun <T : BaseEntity> setGridAdapter(
        @IdRes viewId: Int,
        adapter: BaseAdapter<T>,
        spanCount: Int
    ): CommonViewHolder {
        getView<RecyclerView>(viewId)?.let { recyclerView ->
            recyclerView.adapter = adapter
            recyclerView.layoutManager = GridLayoutManager(mContext, spanCount)
        }
        return this
    }

    /**
     * View 设置 OnClickListener
     * @param viewId View Id
     * @param duration 下一次可点击的间隔时间(毫秒值) (防连击) (默认 200 ms)
     * @param listener OnClickListener
     * @return CommonViewHolder
     */
    fun setOnClickListener(
        @IdRes viewId: Int,
        @IntRange(from = 0) duration: Long = 200,
        listener: View.OnClickListener?
    ): CommonViewHolder? {
        val view = getView<View>(viewId)

        ClickUtils.applySingleDebouncing(view, duration, listener)
        return this
    }

    /**
     * View 设置 OnClickListener
     * @param view View
     * @param duration 下一次可点击的间隔时间 (防连击)
     * @param listener OnClickListener
     * @return CommonViewHolder
     */
    fun setOnClickListener(
        view: View,
        @IntRange(from = 0) duration: Long = 200,
        listener: View.OnClickListener?
    ): CommonViewHolder? {
        ClickUtils.applySingleDebouncing(view, duration, listener)
        return this
    }

    /**
     * View 设置 OnLongClickListener
     * @param viewId View Id
     * @param listener OnLongClickListener
     * @return CommonViewHolder
     */
    fun setOnLongClickListener(
        @IdRes viewId: Int,
        listener: OnLongClickListener?
    ): CommonViewHolder {
        getView<View>(viewId)?.setOnLongClickListener(listener)
        return this
    }

    /**
     * CompoundButton 设置 OnCheckedChangeListener
     * @param viewId View Id
     * @param listener OnCheckedChangeListener
     * @return CommonViewHolder
     */
    fun setOnCheckedListener(
        @IdRes viewId: Int,
        listener: CompoundButton.OnCheckedChangeListener?
    ): CommonViewHolder {
        getView<CompoundButton>(viewId)?.setOnCheckedChangeListener(listener)
        return this
    }

}