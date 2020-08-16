package com.shijingfeng.common.ui.activity;

import java.lang.System;

/**
 * Function: 查看原图 Activity
 * Date: 2020/1/29 9:40
 * Description:
 * @author ShiJingFeng
 */
@com.alibaba.android.arouter.facade.annotation.Route(path = "/common/activity/ViewOriginalImageActivity")
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0014J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0014J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\u000f\u001a\u00020\u0010H\u0015J\b\u0010\u0011\u001a\u00020\u0010H\u0015J\b\u0010\u0012\u001a\u00020\u0010H\u0014J\b\u0010\u0013\u001a\u00020\u0010H\u0014J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0003J\b\u0010\u0018\u001a\u00020\u0010H\u0003R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/shijingfeng/common/ui/activity/ViewOriginalImageActivity;", "Lcom/shijingfeng/common/base/CommonBaseActivity;", "Lcom/shijingfeng/common/databinding/ActivityCommonViewOriginalImageBinding;", "Lcom/shijingfeng/common/viewmodel/ViewOriginalImageViewModel;", "()V", "mLongClickDialog", "Lcom/shijingfeng/base/widget/dialog/CommonDialog;", "mViewOriginalImageAdapter", "Lcom/shijingfeng/common/adapter/ViewOriginalImageAdapter;", "getLayoutId", "", "getVariableSparseArray", "Landroid/util/SparseArray;", "", "getViewModel", "initAction", "", "initData", "initParam", "onDestroy", "saveImage", "", "inputStream", "Ljava/io/InputStream;", "showLongClickDialog", "common_release"})
@com.shijingfeng.base.annotation.NeedPermissions()
public final class ViewOriginalImageActivity extends com.shijingfeng.common.base.CommonBaseActivity<com.shijingfeng.common.databinding.ActivityCommonViewOriginalImageBinding, com.shijingfeng.common.viewmodel.ViewOriginalImageViewModel> {
    
    /**
     * ViewPager 适配器
     */
    private com.shijingfeng.common.adapter.ViewOriginalImageAdapter mViewOriginalImageAdapter;
    
    /**
     * 长按弹框
     */
    private com.shijingfeng.base.widget.dialog.CommonDialog mLongClickDialog;
    private java.util.HashMap _$_findViewCache;
    
    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    @java.lang.Override()
    protected int getLayoutId() {
        return 0;
    }
    
    /**
     * 获取ViewModel
     *
     * @return ViewModel
     */
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected com.shijingfeng.common.viewmodel.ViewOriginalImageViewModel getViewModel() {
        return null;
    }
    
    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     *
     * @return DataBinding 变量SparseArray
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected android.util.SparseArray<java.lang.Object> getVariableSparseArray() {
        return null;
    }
    
    /**
     * 初始化参数
     */
    @java.lang.Override()
    protected void initParam() {
    }
    
    /**
     * 初始化数据
     */
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    @java.lang.Override()
    protected void initData() {
    }
    
    /**
     * 初始化事件
     */
    @android.annotation.SuppressLint(value = {"DefaultLocale"})
    @java.lang.Override()
    protected void initAction() {
    }
    
    /**
     * 显示长按 Dialog
     */
    @android.annotation.SuppressLint(value = {"InflateParams"})
    private final void showLongClickDialog() {
    }
    
    /**
     * 保存图片 (API 29 以后保存文件需要 MediaStore 或 SAF)
     * @param inputStream InputStream 输入流
     * @return true 保存成功  false 保存失败
     */
    @androidx.annotation.WorkerThread()
    private final boolean saveImage(java.io.InputStream inputStream) {
        return false;
    }
    
    /**
     * Activity 销毁回调
     */
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    public ViewOriginalImageActivity() {
        super();
    }
}