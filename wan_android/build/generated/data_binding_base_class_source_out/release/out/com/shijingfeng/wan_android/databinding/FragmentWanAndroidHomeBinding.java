// Generated by data binding compiler. Do not edit!
package com.shijingfeng.wan_android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.shijingfeng.wan_android.R;
import com.shijingfeng.wan_android.view_model.HomeViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentWanAndroidHomeBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView rvContent;

  @NonNull
  public final SmartRefreshLayout srlRefresh;

  @Bindable
  protected HomeViewModel mHomeViewModel;

  protected FragmentWanAndroidHomeBinding(Object _bindingComponent, View _root,
      int _localFieldCount, RecyclerView rvContent, SmartRefreshLayout srlRefresh) {
    super(_bindingComponent, _root, _localFieldCount);
    this.rvContent = rvContent;
    this.srlRefresh = srlRefresh;
  }

  public abstract void setHomeViewModel(@Nullable HomeViewModel homeViewModel);

  @Nullable
  public HomeViewModel getHomeViewModel() {
    return mHomeViewModel;
  }

  @NonNull
  public static FragmentWanAndroidHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_wan_android_home, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentWanAndroidHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentWanAndroidHomeBinding>inflateInternal(inflater, R.layout.fragment_wan_android_home, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentWanAndroidHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_wan_android_home, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentWanAndroidHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentWanAndroidHomeBinding>inflateInternal(inflater, R.layout.fragment_wan_android_home, null, false, component);
  }

  public static FragmentWanAndroidHomeBinding bind(@NonNull View view) {
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
  public static FragmentWanAndroidHomeBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentWanAndroidHomeBinding)bind(component, view, R.layout.fragment_wan_android_home);
  }
}
