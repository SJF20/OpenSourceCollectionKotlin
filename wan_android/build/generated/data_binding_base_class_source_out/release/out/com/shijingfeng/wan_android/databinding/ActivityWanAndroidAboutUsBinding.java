// Generated by data binding compiler. Do not edit!
package com.shijingfeng.wan_android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.shijingfeng.base.widget.rich_text.RichTextView;
import com.shijingfeng.wan_android.R;
import com.shijingfeng.wan_android.view_model.AboutUsViewModel;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityWanAndroidAboutUsBinding extends ViewDataBinding {
  @NonNull
  public final CircleImageView civLogo;

  @NonNull
  public final LayoutWanAndroidTitleBarBinding includeTitleBar;

  @NonNull
  public final RichTextView tvContent;

  @NonNull
  public final TextView tvVersionName;

  @Bindable
  protected AboutUsViewModel mAboutUsViewModel;

  protected ActivityWanAndroidAboutUsBinding(Object _bindingComponent, View _root,
      int _localFieldCount, CircleImageView civLogo,
      LayoutWanAndroidTitleBarBinding includeTitleBar, RichTextView tvContent,
      TextView tvVersionName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.civLogo = civLogo;
    this.includeTitleBar = includeTitleBar;
    setContainedBinding(this.includeTitleBar);
    this.tvContent = tvContent;
    this.tvVersionName = tvVersionName;
  }

  public abstract void setAboutUsViewModel(@Nullable AboutUsViewModel aboutUsViewModel);

  @Nullable
  public AboutUsViewModel getAboutUsViewModel() {
    return mAboutUsViewModel;
  }

  @NonNull
  public static ActivityWanAndroidAboutUsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_wan_android_about_us, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityWanAndroidAboutUsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityWanAndroidAboutUsBinding>inflateInternal(inflater, R.layout.activity_wan_android_about_us, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityWanAndroidAboutUsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_wan_android_about_us, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityWanAndroidAboutUsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityWanAndroidAboutUsBinding>inflateInternal(inflater, R.layout.activity_wan_android_about_us, null, false, component);
  }

  public static ActivityWanAndroidAboutUsBinding bind(@NonNull View view) {
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
  public static ActivityWanAndroidAboutUsBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivityWanAndroidAboutUsBinding)bind(component, view, R.layout.activity_wan_android_about_us);
  }
}
