// Generated by data binding compiler. Do not edit!
package com.shijingfeng.wan_android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.shijingfeng.wan_android.R;
import com.shijingfeng.wan_android.view_model.SettingViewModel;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityWanAndroidSettingBinding extends ViewDataBinding {
  @NonNull
  public final CircleImageView civThemeColor;

  @NonNull
  public final LayoutWanAndroidTitleBarBinding includeTitleBar;

  @NonNull
  public final LinearLayout llThemeColor;

  @Bindable
  protected SettingViewModel mSettingViewModel;

  protected ActivityWanAndroidSettingBinding(Object _bindingComponent, View _root,
      int _localFieldCount, CircleImageView civThemeColor,
      LayoutWanAndroidTitleBarBinding includeTitleBar, LinearLayout llThemeColor) {
    super(_bindingComponent, _root, _localFieldCount);
    this.civThemeColor = civThemeColor;
    this.includeTitleBar = includeTitleBar;
    setContainedBinding(this.includeTitleBar);
    this.llThemeColor = llThemeColor;
  }

  public abstract void setSettingViewModel(@Nullable SettingViewModel settingViewModel);

  @Nullable
  public SettingViewModel getSettingViewModel() {
    return mSettingViewModel;
  }

  @NonNull
  public static ActivityWanAndroidSettingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_wan_android_setting, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityWanAndroidSettingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityWanAndroidSettingBinding>inflateInternal(inflater, R.layout.activity_wan_android_setting, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityWanAndroidSettingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_wan_android_setting, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityWanAndroidSettingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityWanAndroidSettingBinding>inflateInternal(inflater, R.layout.activity_wan_android_setting, null, false, component);
  }

  public static ActivityWanAndroidSettingBinding bind(@NonNull View view) {
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
  public static ActivityWanAndroidSettingBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivityWanAndroidSettingBinding)bind(component, view, R.layout.activity_wan_android_setting);
  }
}