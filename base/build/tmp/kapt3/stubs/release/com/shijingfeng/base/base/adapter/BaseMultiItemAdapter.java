package com.shijingfeng.base.base.adapter;

import java.lang.System;

/**
 * Function: 通用多类型Item RecyclerView 适配器
 * Date: 2020/1/27 10:55
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000eH\u0016R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lcom/shijingfeng/base/base/adapter/BaseMultiItemAdapter;", "T", "Lcom/shijingfeng/base/base/entity/BaseEntity;", "Lcom/shijingfeng/base/base/adapter/BaseAdapter;", "mContext", "Landroid/content/Context;", "mDataList", "", "mMultiItemTypeSupport", "Lcom/shijingfeng/base/base/adapter/support/MultiItemTypeSupport;", "(Landroid/content/Context;Ljava/util/List;Lcom/shijingfeng/base/base/adapter/support/MultiItemTypeSupport;)V", "getMMultiItemTypeSupport", "()Lcom/shijingfeng/base/base/adapter/support/MultiItemTypeSupport;", "getItemViewType", "", "position", "onCreateViewHolder", "Lcom/shijingfeng/base/base/adapter/viewholder/CommonViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "base_release"})
public abstract class BaseMultiItemAdapter<T extends com.shijingfeng.base.base.entity.BaseEntity> extends com.shijingfeng.base.base.adapter.BaseAdapter<T> {
    @org.jetbrains.annotations.NotNull()
    private final com.shijingfeng.base.base.adapter.support.MultiItemTypeSupport<T> mMultiItemTypeSupport = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final com.shijingfeng.base.base.adapter.support.MultiItemTypeSupport<T> getMMultiItemTypeSupport() {
        return null;
    }
    
    public BaseMultiItemAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.Nullable()
    java.util.List<? extends T> mDataList, @org.jetbrains.annotations.NotNull()
    com.shijingfeng.base.base.adapter.support.MultiItemTypeSupport<T> mMultiItemTypeSupport) {
        super(null, 0, null);
    }
}