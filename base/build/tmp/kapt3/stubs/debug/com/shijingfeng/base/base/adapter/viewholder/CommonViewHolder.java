package com.shijingfeng.base.base.adapter.viewholder;

import java.lang.System;

/**
 * Function: 通用ViewHolder
 * Date: 2020/1/23 21:57
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J!\u0010\t\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\n*\u00020\u00052\b\b\u0001\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\u0011\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0012\u001a\u00020\fJ\u0018\u0010\u0013\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\u0013\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0012\u001a\u00020\fJ\u0018\u0010\u0014\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016J\u0018\u0010\u0017\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0016J0\u0010\u0019\u001a\u00020\u0000\"\b\b\u0000\u0010\n*\u00020\u001a2\b\b\u0001\u0010\u000b\u001a\u00020\f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\n0\u001c2\u0006\u0010\u001d\u001a\u00020\fJ\u0018\u0010\u001e\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J,\u0010\u001f\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\f2\u0006\u0010 \u001a\u00020!2\b\b\u0003\u0010\"\u001a\u00020\f2\b\b\u0003\u0010#\u001a\u00020\fJ\u001a\u0010$\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010%\u001a\u00020\fJ2\u0010&\u001a\u00020\u0000\"\b\b\u0000\u0010\n*\u00020\u001a2\b\b\u0001\u0010\u000b\u001a\u00020\f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\n0\u001c2\b\b\u0002\u0010\'\u001a\u00020\fJ\u001a\u0010(\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\u0010)\u001a\u0004\u0018\u00010*J$\u0010+\u001a\u0004\u0018\u00010\u00002\u0006\u0010,\u001a\u00020\u00052\b\b\u0003\u0010-\u001a\u00020.2\b\u0010)\u001a\u0004\u0018\u00010/J&\u0010+\u001a\u0004\u0018\u00010\u00002\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0003\u0010-\u001a\u00020.2\b\u0010)\u001a\u0004\u0018\u00010/J\u001a\u00100\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\u0010)\u001a\u0004\u0018\u000101J-\u00102\u001a\u0002032\b\b\u0001\u0010\u000b\u001a\u00020\f2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\f2\n\b\u0002\u00105\u001a\u0004\u0018\u000106\u00a2\u0006\u0002\u00107J\u0018\u00108\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\f2\u0006\u00109\u001a\u00020!J\u0018\u0010:\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\f2\u0006\u0010;\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006<"}, d2 = {"Lcom/shijingfeng/base/base/adapter/viewholder/CommonViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mContext", "Landroid/content/Context;", "mItemView", "Landroid/view/View;", "(Landroid/content/Context;Landroid/view/View;)V", "mViewSparseArray", "Landroid/util/SparseArray;", "getView", "T", "viewId", "", "(I)Landroid/view/View;", "setBackground", "drawable", "Landroid/graphics/drawable/Drawable;", "setBackgroundResource", "drawableRes", "setButtonDrawable", "setChecked", "checked", "", "setEnabled", "enabled", "setGridAdapter", "Lcom/shijingfeng/base/base/entity/BaseEntity;", "adapter", "Lcom/shijingfeng/base/base/adapter/BaseAdapter;", "spanCount", "setImageDrawable", "setImagePath", "path", "", "placeholder", "error", "setImageResource", "resId", "setLinearAdapter", "orientation", "setOnCheckedListener", "listener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "setOnClickListener", "view", "duration", "", "Landroid/view/View$OnClickListener;", "setOnLongClickListener", "Landroid/view/View$OnLongClickListener;", "setTag", "", "key", "tag", "", "(ILjava/lang/Integer;Ljava/lang/Object;)V", "setText", "text", "setVisibility", "visibility", "base_debug"})
public final class CommonViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
    private final android.util.SparseArray<android.view.View> mViewSparseArray = null;
    private final android.content.Context mContext = null;
    
    /**
     * 通过View Id 获取 View实例
     * @param viewId View Id
     * @return View 实例
     */
    @org.jetbrains.annotations.Nullable()
    public final <T extends android.view.View>T getView(@androidx.annotation.IdRes()
    int viewId) {
        return null;
    }
    
    /**
     * View 设置可见性
     * @param viewId View Id
     * @param visibility 可见性
     * @return CommonViewHolder
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder setVisibility(@androidx.annotation.IdRes()
    int viewId, int visibility) {
        return null;
    }
    
    /**
     * TextView 设置文本
     * @param viewId TextView Id
     * @param text 文本
     * @return CommonViewHolder
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder setText(@androidx.annotation.IdRes()
    int viewId, @org.jetbrains.annotations.NotNull()
    java.lang.String text) {
        return null;
    }
    
    /**
     * ImageView 设置 Drawable资源
     * @param viewId ImageView Id
     * @param resId Drawable资源 Id
     * @return CommonViewHolder
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder setImageResource(@androidx.annotation.IdRes()
    int viewId, @androidx.annotation.DrawableRes()
    int resId) {
        return null;
    }
    
    /**
     * ImageView 设置 Drawable
     * @param viewId ImageView Id
     * @param drawable Drawable
     * @return CommonViewHolder
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder setImageDrawable(@androidx.annotation.IdRes()
    int viewId, @org.jetbrains.annotations.NotNull()
    android.graphics.drawable.Drawable drawable) {
        return null;
    }
    
    /**
     * ImageView 背景 Drawable (不支持换肤)
     * @param viewId View Id
     * @param drawable Drawable
     * @return CommonViewHolder
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder setBackground(@androidx.annotation.IdRes()
    int viewId, @org.jetbrains.annotations.NotNull()
    android.graphics.drawable.Drawable drawable) {
        return null;
    }
    
    /**
     * ImageView 背景 资源 (支持换肤)
     * @param viewId View Id
     * @param drawableRes Drawable
     * @return CommonViewHolder
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder setBackgroundResource(@androidx.annotation.IdRes()
    int viewId, @androidx.annotation.DrawableRes()
    int drawableRes) {
        return null;
    }
    
    /**
     * ImageView 设置 本地路径或网络路径资源
     * @param viewId ImageView Id
     * @param path 本地路径或网络路径
     * @param placeholder 占位图片 (加载中)
     * @param error 错误图片 (加载失败)
     * @return CommonViewHolder
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder setImagePath(@androidx.annotation.IdRes()
    int viewId, @org.jetbrains.annotations.NotNull()
    java.lang.String path, @androidx.annotation.DrawableRes()
    int placeholder, @androidx.annotation.DrawableRes()
    int error) {
        return null;
    }
    
    /**
     * 设置是否选中
     * @param viewId View ID
     * @param checked true 选中  false 不选中
     * @return CommonViewHolder
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder setChecked(@androidx.annotation.IdRes()
    int viewId, boolean checked) {
        return null;
    }
    
    /**
     * 设置 CompoundButton 背景图
     * @param viewId View ID
     * @param drawableRes 资源ID
     * @return CommonViewHolder
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder setButtonDrawable(@androidx.annotation.IdRes()
    int viewId, @androidx.annotation.DrawableRes()
    int drawableRes) {
        return null;
    }
    
    /**
     * 设置 CompoundButton 背景图
     * @param viewId View ID
     * @param drawable Drawable
     * @return CommonViewHolder
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder setButtonDrawable(@androidx.annotation.IdRes()
    int viewId, @org.jetbrains.annotations.NotNull()
    android.graphics.drawable.Drawable drawable) {
        return null;
    }
    
    /**
     * View 设置 是否可用
     * @param viewId View Id
     * @param enabled 是否可用
     * @return CommonViewHolder
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder setEnabled(@androidx.annotation.IdRes()
    int viewId, boolean enabled) {
        return null;
    }
    
    /**
     * RecyclerView 设置 垂直线性布局适配器
     * @param viewId RecyclerView
     * @param adapter 适配器
     * @param orientation 线性方向
     * @param <T> 泛型
     * @return CommonViewHolder
     */
    @org.jetbrains.annotations.NotNull()
    public final <T extends com.shijingfeng.base.base.entity.BaseEntity>com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder setLinearAdapter(@androidx.annotation.IdRes()
    int viewId, @org.jetbrains.annotations.NotNull()
    com.shijingfeng.base.base.adapter.BaseAdapter<T> adapter, @androidx.recyclerview.widget.RecyclerView.Orientation()
    int orientation) {
        return null;
    }
    
    /**
     * RecyclerView 设置 网格布局适配器
     * @param viewId RecyclerView
     * @param adapter 适配器
     * @param spanCount 网格列数
     * @param <T> 泛型
     * @return CommonViewHolder
     */
    @org.jetbrains.annotations.NotNull()
    public final <T extends com.shijingfeng.base.base.entity.BaseEntity>com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder setGridAdapter(@androidx.annotation.IdRes()
    int viewId, @org.jetbrains.annotations.NotNull()
    com.shijingfeng.base.base.adapter.BaseAdapter<T> adapter, int spanCount) {
        return null;
    }
    
    /**
     * 设置标签
     * @param viewId
     * @param key
     * @param tag
     * @return CommonViewHolder
     */
    public final void setTag(@androidx.annotation.IdRes()
    int viewId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer key, @org.jetbrains.annotations.Nullable()
    java.lang.Object tag) {
    }
    
    /**
     * View 设置 OnClickListener
     * @param viewId View Id
     * @param duration 下一次可点击的间隔时间(毫秒值) (防连击) (默认 200 ms)
     * @param listener OnClickListener
     * @return CommonViewHolder
     */
    @org.jetbrains.annotations.Nullable()
    public final com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder setOnClickListener(@androidx.annotation.IdRes()
    int viewId, @androidx.annotation.IntRange(from = 0L)
    long duration, @org.jetbrains.annotations.Nullable()
    android.view.View.OnClickListener listener) {
        return null;
    }
    
    /**
     * View 设置 OnClickListener
     * @param view View
     * @param duration 下一次可点击的间隔时间 (防连击)
     * @param listener OnClickListener
     * @return CommonViewHolder
     */
    @org.jetbrains.annotations.Nullable()
    public final com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder setOnClickListener(@org.jetbrains.annotations.NotNull()
    android.view.View view, @androidx.annotation.IntRange(from = 0L)
    long duration, @org.jetbrains.annotations.Nullable()
    android.view.View.OnClickListener listener) {
        return null;
    }
    
    /**
     * View 设置 OnLongClickListener
     * @param viewId View Id
     * @param listener OnLongClickListener
     * @return CommonViewHolder
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder setOnLongClickListener(@androidx.annotation.IdRes()
    int viewId, @org.jetbrains.annotations.Nullable()
    android.view.View.OnLongClickListener listener) {
        return null;
    }
    
    /**
     * CompoundButton 设置 OnCheckedChangeListener
     * @param viewId View Id
     * @param listener OnCheckedChangeListener
     * @return CommonViewHolder
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder setOnCheckedListener(@androidx.annotation.IdRes()
    int viewId, @org.jetbrains.annotations.Nullable()
    android.widget.CompoundButton.OnCheckedChangeListener listener) {
        return null;
    }
    
    public CommonViewHolder(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.NotNull()
    android.view.View mItemView) {
        super(null);
    }
}