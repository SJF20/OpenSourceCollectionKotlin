package com.shijingfeng.wan_android.ui.activity;

import java.lang.System;

/**
 * Function: 首页 Activity
 * Date: 2020/2/11 13:55
 * Description:
 * @author ShiJingFeng
 */
@com.alibaba.android.arouter.facade.annotation.Route(path = "/wan_android/activity/MainActivity")
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0003J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0017H\u0007J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0014J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\u001c\u001a\u00020\fH\u0014J\b\u0010\u001d\u001a\u00020\fH\u0015J\b\u0010\u001e\u001a\u00020\fH\u0014J\b\u0010\u001f\u001a\u00020 H\u0014J\"\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00102\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\u001a\u0010&\u001a\u00020 2\u0006\u0010\'\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u0010H\u0002J\b\u0010+\u001a\u00020\fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/shijingfeng/wan_android/ui/activity/MainActivity;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseActivity;", "Lcom/shijingfeng/wan_android/databinding/ActivityWanAndroidMainBinding;", "Lcom/shijingfeng/wan_android/view_model/MainViewModel;", "()V", "mCurIndicatorImageView", "Landroid/widget/ImageView;", "mCurIndicatorTextView", "Landroid/widget/TextView;", "mMainFragmentPagerAdapter", "Lcom/shijingfeng/wan_android/ui/activity/MainFragmentPagerAdapter;", "getCoinInfoEvent", "", "event", "Lcom/shijingfeng/wan_android/entity/event/CoinInfoEvent;", "getLayoutId", "", "getTabView", "Landroid/view/View;", "position", "getThemeEvent", "Lcom/shijingfeng/wan_android/entity/event/ThemeEvent;", "getUserInfoEvent", "Lcom/shijingfeng/wan_android/entity/event/UserInfoEvent;", "getVariableSparseArray", "Landroid/util/SparseArray;", "", "getViewModel", "initAction", "initData", "initObserver", "isSetCustomStatusBar", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onKeyDown", "keyCode", "Landroid/view/KeyEvent;", "setTabLayoutVisibility", "visibility", "showLogoutDialog", "wan_android_debug"})
@com.shijingfeng.base.annotation.BindEventBus()
public final class MainActivity extends com.shijingfeng.wan_android.base.WanAndroidBaseActivity<com.shijingfeng.wan_android.databinding.ActivityWanAndroidMainBinding, com.shijingfeng.wan_android.view_model.MainViewModel> {
    
    /**
     * 主页 ViewPager Fragment 适配器
     */
    private com.shijingfeng.wan_android.ui.activity.MainFragmentPagerAdapter mMainFragmentPagerAdapter;
    
    /**
     * 当前 TabLayout指示器 TextView
     */
    private android.widget.TextView mCurIndicatorTextView;
    
    /**
     * 当前 TabLayout指示器 ImageView
     */
    private android.widget.ImageView mCurIndicatorImageView;
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
     * @return ViewModel
     */
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected com.shijingfeng.wan_android.view_model.MainViewModel getViewModel() {
        return null;
    }
    
    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected android.util.SparseArray<java.lang.Object> getVariableSparseArray() {
        return null;
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
    @java.lang.Override()
    protected void initAction() {
    }
    
    /**
     * 初始化 LiveData Observer
     */
    @java.lang.Override()
    protected void initObserver() {
    }
    
    /**
     * 是否自定义设置状态栏
     *
     * @return true 自定义设置  false 默认设置
     */
    @java.lang.Override()
    protected boolean isSetCustomStatusBar() {
        return false;
    }
    
    /**
     * 设置 TabLayout 和 置顶按钮 的可见性
     * @param visibility 可见性
     */
    private final void setTabLayoutVisibility(int visibility) {
    }
    
    /**
     * 获取要加载的 Tab CustomView
     * @param position 位置
     * @return View 要加载的View
     */
    @android.annotation.SuppressLint(value = {"InflateParams"})
    private final android.view.View getTabView(int position) {
        return null;
    }
    
    /**
     * 显示 退出登录确认对话框
     */
    private final void showLogoutDialog() {
    }
    
    /**
     * Dispatch incoming result to the correct fragment.
     */
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    /**
     * 模拟按键 按下监听
     */
    @java.lang.Override()
    public boolean onKeyDown(int keyCode, @org.jetbrains.annotations.Nullable()
    android.view.KeyEvent event) {
        return false;
    }
    
    /**
     * 接收 用户信息 数据更新 Event
     * @param event 用户信息 数据更新 Event
     */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public final void getUserInfoEvent(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.wan_android.entity.event.UserInfoEvent event) {
    }
    
    /**
     * 接收 积分信息 数据更新 Event
     * @param event 积分信息 数据更新 Event
     */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public final void getCoinInfoEvent(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.wan_android.entity.event.CoinInfoEvent event) {
    }
    
    /**
     * 切换主题 Event
     */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public final void getThemeEvent(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.wan_android.entity.event.ThemeEvent event) {
    }
    
    public MainActivity() {
        super();
    }
}