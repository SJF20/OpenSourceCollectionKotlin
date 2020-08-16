// Generated by data binding compiler. Do not edit!
package com.shijingfeng.wan_android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.shijingfeng.base.widget.StatusBarView;
import com.shijingfeng.wan_android.R;
import com.shijingfeng.wan_android.view_model.MainViewModel;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class LayoutWanAndroidMainActivityDrawerBinding extends ViewDataBinding {
  @NonNull
  public final ImageView ivAbout;

  @NonNull
  public final ImageView ivCoin;

  @NonNull
  public final ImageView ivCollection;

  @NonNull
  public final ImageView ivLogout;

  @NonNull
  public final CircleImageView ivPortrait;

  @NonNull
  public final ImageView ivRank;

  @NonNull
  public final ImageView ivSetting;

  @NonNull
  public final ImageView ivTodo;

  @NonNull
  public final LinearLayout llAbout;

  @NonNull
  public final LinearLayout llCoin;

  @NonNull
  public final LinearLayout llCollection;

  @NonNull
  public final LinearLayout llHeader;

  @NonNull
  public final LinearLayout llLogout;

  @NonNull
  public final LinearLayout llMenu;

  @NonNull
  public final LinearLayout llNav;

  @NonNull
  public final LinearLayout llSetting;

  @NonNull
  public final LinearLayout llTodo;

  @NonNull
  public final StatusBarView sbvStatusBar;

  @NonNull
  public final TextView tvAbout;

  @NonNull
  public final TextView tvCoin;

  @NonNull
  public final TextView tvCoinQuantity;

  @NonNull
  public final TextView tvCollection;

  @NonNull
  public final TextView tvId;

  @NonNull
  public final TextView tvLevel;

  @NonNull
  public final TextView tvLogout;

  @NonNull
  public final TextView tvName;

  @NonNull
  public final TextView tvRank;

  @NonNull
  public final TextView tvSetting;

  @NonNull
  public final TextView tvTodo;

  @Bindable
  protected MainViewModel mMainViewModel;

  protected LayoutWanAndroidMainActivityDrawerBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ImageView ivAbout, ImageView ivCoin, ImageView ivCollection,
      ImageView ivLogout, CircleImageView ivPortrait, ImageView ivRank, ImageView ivSetting,
      ImageView ivTodo, LinearLayout llAbout, LinearLayout llCoin, LinearLayout llCollection,
      LinearLayout llHeader, LinearLayout llLogout, LinearLayout llMenu, LinearLayout llNav,
      LinearLayout llSetting, LinearLayout llTodo, StatusBarView sbvStatusBar, TextView tvAbout,
      TextView tvCoin, TextView tvCoinQuantity, TextView tvCollection, TextView tvId,
      TextView tvLevel, TextView tvLogout, TextView tvName, TextView tvRank, TextView tvSetting,
      TextView tvTodo) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ivAbout = ivAbout;
    this.ivCoin = ivCoin;
    this.ivCollection = ivCollection;
    this.ivLogout = ivLogout;
    this.ivPortrait = ivPortrait;
    this.ivRank = ivRank;
    this.ivSetting = ivSetting;
    this.ivTodo = ivTodo;
    this.llAbout = llAbout;
    this.llCoin = llCoin;
    this.llCollection = llCollection;
    this.llHeader = llHeader;
    this.llLogout = llLogout;
    this.llMenu = llMenu;
    this.llNav = llNav;
    this.llSetting = llSetting;
    this.llTodo = llTodo;
    this.sbvStatusBar = sbvStatusBar;
    this.tvAbout = tvAbout;
    this.tvCoin = tvCoin;
    this.tvCoinQuantity = tvCoinQuantity;
    this.tvCollection = tvCollection;
    this.tvId = tvId;
    this.tvLevel = tvLevel;
    this.tvLogout = tvLogout;
    this.tvName = tvName;
    this.tvRank = tvRank;
    this.tvSetting = tvSetting;
    this.tvTodo = tvTodo;
  }

  public abstract void setMainViewModel(@Nullable MainViewModel mainViewModel);

  @Nullable
  public MainViewModel getMainViewModel() {
    return mMainViewModel;
  }

  @NonNull
  public static LayoutWanAndroidMainActivityDrawerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.layout_wan_android_main_activity_drawer, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static LayoutWanAndroidMainActivityDrawerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<LayoutWanAndroidMainActivityDrawerBinding>inflateInternal(inflater, R.layout.layout_wan_android_main_activity_drawer, root, attachToRoot, component);
  }

  @NonNull
  public static LayoutWanAndroidMainActivityDrawerBinding inflate(
      @NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.layout_wan_android_main_activity_drawer, null, false, component)
   */
  @NonNull
  @Deprecated
  public static LayoutWanAndroidMainActivityDrawerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<LayoutWanAndroidMainActivityDrawerBinding>inflateInternal(inflater, R.layout.layout_wan_android_main_activity_drawer, null, false, component);
  }

  public static LayoutWanAndroidMainActivityDrawerBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static LayoutWanAndroidMainActivityDrawerBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (LayoutWanAndroidMainActivityDrawerBinding)bind(component, view, R.layout.layout_wan_android_main_activity_drawer);
  }
}
