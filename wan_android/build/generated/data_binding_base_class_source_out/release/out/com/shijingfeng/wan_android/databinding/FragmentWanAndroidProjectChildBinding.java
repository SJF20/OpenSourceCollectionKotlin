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
import com.shijingfeng.wan_android.view_model.ProjectChildViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentWanAndroidProjectChildBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView rvContent;

  @NonNull
  public final SmartRefreshLayout srlRefresh;

  @Bindable
  protected ProjectChildViewModel mProjectChildViewModel;

  protected FragmentWanAndroidProjectChildBinding(Object _bindingComponent, View _root,
      int _localFieldCount, RecyclerView rvContent, SmartRefreshLayout srlRefresh) {
    super(_bindingComponent, _root, _localFieldCount);
    this.rvContent = rvContent;
    this.srlRefresh = srlRefresh;
  }

  public abstract void setProjectChildViewModel(
      @Nullable ProjectChildViewModel projectChildViewModel);

  @Nullable
  public ProjectChildViewModel getProjectChildViewModel() {
    return mProjectChildViewModel;
  }

  @NonNull
  public static FragmentWanAndroidProjectChildBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_wan_android_project_child, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentWanAndroidProjectChildBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentWanAndroidProjectChildBinding>inflateInternal(inflater, R.layout.fragment_wan_android_project_child, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentWanAndroidProjectChildBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_wan_android_project_child, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentWanAndroidProjectChildBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentWanAndroidProjectChildBinding>inflateInternal(inflater, R.layout.fragment_wan_android_project_child, null, false, component);
  }

  public static FragmentWanAndroidProjectChildBinding bind(@NonNull View view) {
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
  public static FragmentWanAndroidProjectChildBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentWanAndroidProjectChildBinding)bind(component, view, R.layout.fragment_wan_android_project_child);
  }
}
