package com.shijingfeng.app;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.shijingfeng.app.databinding.ActivityAppMainBindingImpl;
import com.shijingfeng.app.databinding.ActivityAppSplashBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYAPPMAIN = 1;

  private static final int LAYOUT_ACTIVITYAPPSPLASH = 2;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(2);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.app.R.layout.activity_app_main, LAYOUT_ACTIVITYAPPMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.app.R.layout.activity_app_splash, LAYOUT_ACTIVITYAPPSPLASH);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYAPPMAIN: {
          if ("layout/activity_app_main_0".equals(tag)) {
            return new ActivityAppMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_app_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYAPPSPLASH: {
          if ("layout/activity_app_splash_0".equals(tag)) {
            return new ActivityAppSplashBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_app_splash is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(7);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    result.add(new com.shijingfeng.background_service.DataBinderMapperImpl());
    result.add(new com.shijingfeng.base.DataBinderMapperImpl());
    result.add(new com.shijingfeng.common.DataBinderMapperImpl());
    result.add(new com.shijingfeng.tencent_x5.DataBinderMapperImpl());
    result.add(new com.shijingfeng.todo.DataBinderMapperImpl());
    result.add(new com.shijingfeng.wan_android.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(35);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "aboutUsViewModel");
      sKeys.put(2, "backgroundDrawable");
      sKeys.put(3, "classifyViewModel");
      sKeys.put(4, "coinRankViewModel");
      sKeys.put(5, "coinRecordViewModel");
      sKeys.put(6, "doneViewModel");
      sKeys.put(7, "homeViewModel");
      sKeys.put(8, "ivBackClick");
      sKeys.put(9, "ivOperateClick");
      sKeys.put(10, "knowledgeClassifyChildViewModel");
      sKeys.put(11, "knowledgeClassifyDetailViewModel");
      sKeys.put(12, "knowledgeClassifyViewModel");
      sKeys.put(13, "loginViewModel");
      sKeys.put(14, "mainViewModel");
      sKeys.put(15, "navigationClassifyViewModel");
      sKeys.put(16, "officialAccountChildViewModel");
      sKeys.put(17, "officialAccountViewModel");
      sKeys.put(18, "personalCollectionArticleViewModel");
      sKeys.put(19, "personalCollectionViewModel");
      sKeys.put(20, "personalCollectionWebsiteViewModel");
      sKeys.put(21, "projectChildViewModel");
      sKeys.put(22, "projectViewModel");
      sKeys.put(23, "registerViewModel");
      sKeys.put(24, "searchListViewModel");
      sKeys.put(25, "searchViewModel");
      sKeys.put(26, "settingViewModel");
      sKeys.put(27, "splashViewModel");
      sKeys.put(28, "squareViewModel");
      sKeys.put(29, "titleBarHeight");
      sKeys.put(30, "todoViewModel");
      sKeys.put(31, "tvOperateClick");
      sKeys.put(32, "userInfoViewModel");
      sKeys.put(33, "viewOriginalImageViewModel");
      sKeys.put(34, "webViewViewModel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(2);

    static {
      sKeys.put("layout/activity_app_main_0", com.shijingfeng.app.R.layout.activity_app_main);
      sKeys.put("layout/activity_app_splash_0", com.shijingfeng.app.R.layout.activity_app_splash);
    }
  }
}
