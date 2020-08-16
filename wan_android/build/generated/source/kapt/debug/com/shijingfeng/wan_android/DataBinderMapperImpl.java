package com.shijingfeng.wan_android;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidAboutUsBindingImpl;
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidBmobTestBindingImpl;
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidCoinRankBindingImpl;
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidCoinRecordBindingImpl;
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidKnowledgeClassifyDetailBindingImpl;
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidLoginBindingImpl;
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidMainBindingImpl;
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidPersonalCollectionBindingImpl;
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidRegisterBindingImpl;
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidSearchBindingImpl;
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidSearchListBindingImpl;
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidSettingBindingImpl;
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidSplashBindingImpl;
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidUserInfoBindingImpl;
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidWebViewBindingImpl;
import com.shijingfeng.wan_android.databinding.FragmentWanAndroidClassifyBindingImpl;
import com.shijingfeng.wan_android.databinding.FragmentWanAndroidHomeBindingImpl;
import com.shijingfeng.wan_android.databinding.FragmentWanAndroidKnowledgeClassifyBindingImpl;
import com.shijingfeng.wan_android.databinding.FragmentWanAndroidKnowledgeClassifyChildBindingImpl;
import com.shijingfeng.wan_android.databinding.FragmentWanAndroidNavigationClassifyBindingImpl;
import com.shijingfeng.wan_android.databinding.FragmentWanAndroidNullBindingImpl;
import com.shijingfeng.wan_android.databinding.FragmentWanAndroidOfficialAccountBindingImpl;
import com.shijingfeng.wan_android.databinding.FragmentWanAndroidOfficialAccountChildBindingImpl;
import com.shijingfeng.wan_android.databinding.FragmentWanAndroidPersonalCollectionArticleBindingImpl;
import com.shijingfeng.wan_android.databinding.FragmentWanAndroidPersonalCollectionWebsiteBindingImpl;
import com.shijingfeng.wan_android.databinding.FragmentWanAndroidProjectBindingImpl;
import com.shijingfeng.wan_android.databinding.FragmentWanAndroidProjectChildBindingImpl;
import com.shijingfeng.wan_android.databinding.FragmentWanAndroidSquareBindingImpl;
import com.shijingfeng.wan_android.databinding.LayoutWanAndroidMainActivityDrawerBindingImpl;
import com.shijingfeng.wan_android.databinding.LayoutWanAndroidTitleBarBindingImpl;
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
  private static final int LAYOUT_ACTIVITYWANANDROIDABOUTUS = 1;

  private static final int LAYOUT_ACTIVITYWANANDROIDBMOBTEST = 2;

  private static final int LAYOUT_ACTIVITYWANANDROIDCOINRANK = 3;

  private static final int LAYOUT_ACTIVITYWANANDROIDCOINRECORD = 4;

  private static final int LAYOUT_ACTIVITYWANANDROIDKNOWLEDGECLASSIFYDETAIL = 5;

  private static final int LAYOUT_ACTIVITYWANANDROIDLOGIN = 6;

  private static final int LAYOUT_ACTIVITYWANANDROIDMAIN = 7;

  private static final int LAYOUT_ACTIVITYWANANDROIDPERSONALCOLLECTION = 8;

  private static final int LAYOUT_ACTIVITYWANANDROIDREGISTER = 9;

  private static final int LAYOUT_ACTIVITYWANANDROIDSEARCH = 10;

  private static final int LAYOUT_ACTIVITYWANANDROIDSEARCHLIST = 11;

  private static final int LAYOUT_ACTIVITYWANANDROIDSETTING = 12;

  private static final int LAYOUT_ACTIVITYWANANDROIDSPLASH = 13;

  private static final int LAYOUT_ACTIVITYWANANDROIDUSERINFO = 14;

  private static final int LAYOUT_ACTIVITYWANANDROIDWEBVIEW = 15;

  private static final int LAYOUT_FRAGMENTWANANDROIDCLASSIFY = 16;

  private static final int LAYOUT_FRAGMENTWANANDROIDHOME = 17;

  private static final int LAYOUT_FRAGMENTWANANDROIDKNOWLEDGECLASSIFY = 18;

  private static final int LAYOUT_FRAGMENTWANANDROIDKNOWLEDGECLASSIFYCHILD = 19;

  private static final int LAYOUT_FRAGMENTWANANDROIDNAVIGATIONCLASSIFY = 20;

  private static final int LAYOUT_FRAGMENTWANANDROIDNULL = 21;

  private static final int LAYOUT_FRAGMENTWANANDROIDOFFICIALACCOUNT = 22;

  private static final int LAYOUT_FRAGMENTWANANDROIDOFFICIALACCOUNTCHILD = 23;

  private static final int LAYOUT_FRAGMENTWANANDROIDPERSONALCOLLECTIONARTICLE = 24;

  private static final int LAYOUT_FRAGMENTWANANDROIDPERSONALCOLLECTIONWEBSITE = 25;

  private static final int LAYOUT_FRAGMENTWANANDROIDPROJECT = 26;

  private static final int LAYOUT_FRAGMENTWANANDROIDPROJECTCHILD = 27;

  private static final int LAYOUT_FRAGMENTWANANDROIDSQUARE = 28;

  private static final int LAYOUT_LAYOUTWANANDROIDMAINACTIVITYDRAWER = 29;

  private static final int LAYOUT_LAYOUTWANANDROIDTITLEBAR = 30;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(30);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.wan_android.R.layout.activity_wan_android_about_us, LAYOUT_ACTIVITYWANANDROIDABOUTUS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.wan_android.R.layout.activity_wan_android_bmob_test, LAYOUT_ACTIVITYWANANDROIDBMOBTEST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.wan_android.R.layout.activity_wan_android_coin_rank, LAYOUT_ACTIVITYWANANDROIDCOINRANK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.wan_android.R.layout.activity_wan_android_coin_record, LAYOUT_ACTIVITYWANANDROIDCOINRECORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.wan_android.R.layout.activity_wan_android_knowledge_classify_detail, LAYOUT_ACTIVITYWANANDROIDKNOWLEDGECLASSIFYDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.wan_android.R.layout.activity_wan_android_login, LAYOUT_ACTIVITYWANANDROIDLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.wan_android.R.layout.activity_wan_android_main, LAYOUT_ACTIVITYWANANDROIDMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.wan_android.R.layout.activity_wan_android_personal_collection, LAYOUT_ACTIVITYWANANDROIDPERSONALCOLLECTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.wan_android.R.layout.activity_wan_android_register, LAYOUT_ACTIVITYWANANDROIDREGISTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.wan_android.R.layout.activity_wan_android_search, LAYOUT_ACTIVITYWANANDROIDSEARCH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.wan_android.R.layout.activity_wan_android_search_list, LAYOUT_ACTIVITYWANANDROIDSEARCHLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.wan_android.R.layout.activity_wan_android_setting, LAYOUT_ACTIVITYWANANDROIDSETTING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.wan_android.R.layout.activity_wan_android_splash, LAYOUT_ACTIVITYWANANDROIDSPLASH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.wan_android.R.layout.activity_wan_android_user_info, LAYOUT_ACTIVITYWANANDROIDUSERINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.wan_android.R.layout.activity_wan_android_web_view, LAYOUT_ACTIVITYWANANDROIDWEBVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.wan_android.R.layout.fragment_wan_android_classify, LAYOUT_FRAGMENTWANANDROIDCLASSIFY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.wan_android.R.layout.fragment_wan_android_home, LAYOUT_FRAGMENTWANANDROIDHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.wan_android.R.layout.fragment_wan_android_knowledge_classify, LAYOUT_FRAGMENTWANANDROIDKNOWLEDGECLASSIFY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.wan_android.R.layout.fragment_wan_android_knowledge_classify_child, LAYOUT_FRAGMENTWANANDROIDKNOWLEDGECLASSIFYCHILD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.wan_android.R.layout.fragment_wan_android_navigation_classify, LAYOUT_FRAGMENTWANANDROIDNAVIGATIONCLASSIFY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.wan_android.R.layout.fragment_wan_android_null, LAYOUT_FRAGMENTWANANDROIDNULL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.wan_android.R.layout.fragment_wan_android_official_account, LAYOUT_FRAGMENTWANANDROIDOFFICIALACCOUNT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.wan_android.R.layout.fragment_wan_android_official_account_child, LAYOUT_FRAGMENTWANANDROIDOFFICIALACCOUNTCHILD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.wan_android.R.layout.fragment_wan_android_personal_collection_article, LAYOUT_FRAGMENTWANANDROIDPERSONALCOLLECTIONARTICLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.wan_android.R.layout.fragment_wan_android_personal_collection_website, LAYOUT_FRAGMENTWANANDROIDPERSONALCOLLECTIONWEBSITE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.wan_android.R.layout.fragment_wan_android_project, LAYOUT_FRAGMENTWANANDROIDPROJECT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.wan_android.R.layout.fragment_wan_android_project_child, LAYOUT_FRAGMENTWANANDROIDPROJECTCHILD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.wan_android.R.layout.fragment_wan_android_square, LAYOUT_FRAGMENTWANANDROIDSQUARE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.wan_android.R.layout.layout_wan_android_main_activity_drawer, LAYOUT_LAYOUTWANANDROIDMAINACTIVITYDRAWER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.wan_android.R.layout.layout_wan_android_title_bar, LAYOUT_LAYOUTWANANDROIDTITLEBAR);
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
        case  LAYOUT_ACTIVITYWANANDROIDABOUTUS: {
          if ("layout/activity_wan_android_about_us_0".equals(tag)) {
            return new ActivityWanAndroidAboutUsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_wan_android_about_us is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYWANANDROIDBMOBTEST: {
          if ("layout/activity_wan_android_bmob_test_0".equals(tag)) {
            return new ActivityWanAndroidBmobTestBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_wan_android_bmob_test is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYWANANDROIDCOINRANK: {
          if ("layout/activity_wan_android_coin_rank_0".equals(tag)) {
            return new ActivityWanAndroidCoinRankBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_wan_android_coin_rank is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYWANANDROIDCOINRECORD: {
          if ("layout/activity_wan_android_coin_record_0".equals(tag)) {
            return new ActivityWanAndroidCoinRecordBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_wan_android_coin_record is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYWANANDROIDKNOWLEDGECLASSIFYDETAIL: {
          if ("layout/activity_wan_android_knowledge_classify_detail_0".equals(tag)) {
            return new ActivityWanAndroidKnowledgeClassifyDetailBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_wan_android_knowledge_classify_detail is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYWANANDROIDLOGIN: {
          if ("layout/activity_wan_android_login_0".equals(tag)) {
            return new ActivityWanAndroidLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_wan_android_login is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYWANANDROIDMAIN: {
          if ("layout/activity_wan_android_main_0".equals(tag)) {
            return new ActivityWanAndroidMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_wan_android_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYWANANDROIDPERSONALCOLLECTION: {
          if ("layout/activity_wan_android_personal_collection_0".equals(tag)) {
            return new ActivityWanAndroidPersonalCollectionBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_wan_android_personal_collection is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYWANANDROIDREGISTER: {
          if ("layout/activity_wan_android_register_0".equals(tag)) {
            return new ActivityWanAndroidRegisterBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_wan_android_register is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYWANANDROIDSEARCH: {
          if ("layout/activity_wan_android_search_0".equals(tag)) {
            return new ActivityWanAndroidSearchBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_wan_android_search is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYWANANDROIDSEARCHLIST: {
          if ("layout/activity_wan_android_search_list_0".equals(tag)) {
            return new ActivityWanAndroidSearchListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_wan_android_search_list is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYWANANDROIDSETTING: {
          if ("layout/activity_wan_android_setting_0".equals(tag)) {
            return new ActivityWanAndroidSettingBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_wan_android_setting is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYWANANDROIDSPLASH: {
          if ("layout/activity_wan_android_splash_0".equals(tag)) {
            return new ActivityWanAndroidSplashBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_wan_android_splash is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYWANANDROIDUSERINFO: {
          if ("layout/activity_wan_android_user_info_0".equals(tag)) {
            return new ActivityWanAndroidUserInfoBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_wan_android_user_info is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYWANANDROIDWEBVIEW: {
          if ("layout/activity_wan_android_web_view_0".equals(tag)) {
            return new ActivityWanAndroidWebViewBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_wan_android_web_view is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTWANANDROIDCLASSIFY: {
          if ("layout/fragment_wan_android_classify_0".equals(tag)) {
            return new FragmentWanAndroidClassifyBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_wan_android_classify is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTWANANDROIDHOME: {
          if ("layout/fragment_wan_android_home_0".equals(tag)) {
            return new FragmentWanAndroidHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_wan_android_home is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTWANANDROIDKNOWLEDGECLASSIFY: {
          if ("layout/fragment_wan_android_knowledge_classify_0".equals(tag)) {
            return new FragmentWanAndroidKnowledgeClassifyBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_wan_android_knowledge_classify is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTWANANDROIDKNOWLEDGECLASSIFYCHILD: {
          if ("layout/fragment_wan_android_knowledge_classify_child_0".equals(tag)) {
            return new FragmentWanAndroidKnowledgeClassifyChildBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_wan_android_knowledge_classify_child is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTWANANDROIDNAVIGATIONCLASSIFY: {
          if ("layout/fragment_wan_android_navigation_classify_0".equals(tag)) {
            return new FragmentWanAndroidNavigationClassifyBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_wan_android_navigation_classify is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTWANANDROIDNULL: {
          if ("layout/fragment_wan_android_null_0".equals(tag)) {
            return new FragmentWanAndroidNullBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_wan_android_null is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTWANANDROIDOFFICIALACCOUNT: {
          if ("layout/fragment_wan_android_official_account_0".equals(tag)) {
            return new FragmentWanAndroidOfficialAccountBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_wan_android_official_account is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTWANANDROIDOFFICIALACCOUNTCHILD: {
          if ("layout/fragment_wan_android_official_account_child_0".equals(tag)) {
            return new FragmentWanAndroidOfficialAccountChildBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_wan_android_official_account_child is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTWANANDROIDPERSONALCOLLECTIONARTICLE: {
          if ("layout/fragment_wan_android_personal_collection_article_0".equals(tag)) {
            return new FragmentWanAndroidPersonalCollectionArticleBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_wan_android_personal_collection_article is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTWANANDROIDPERSONALCOLLECTIONWEBSITE: {
          if ("layout/fragment_wan_android_personal_collection_website_0".equals(tag)) {
            return new FragmentWanAndroidPersonalCollectionWebsiteBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_wan_android_personal_collection_website is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTWANANDROIDPROJECT: {
          if ("layout/fragment_wan_android_project_0".equals(tag)) {
            return new FragmentWanAndroidProjectBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_wan_android_project is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTWANANDROIDPROJECTCHILD: {
          if ("layout/fragment_wan_android_project_child_0".equals(tag)) {
            return new FragmentWanAndroidProjectChildBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_wan_android_project_child is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTWANANDROIDSQUARE: {
          if ("layout/fragment_wan_android_square_0".equals(tag)) {
            return new FragmentWanAndroidSquareBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_wan_android_square is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTWANANDROIDMAINACTIVITYDRAWER: {
          if ("layout/layout_wan_android_main_activity_drawer_0".equals(tag)) {
            return new LayoutWanAndroidMainActivityDrawerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_wan_android_main_activity_drawer is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTWANANDROIDTITLEBAR: {
          if ("layout/layout_wan_android_title_bar_0".equals(tag)) {
            return new LayoutWanAndroidTitleBarBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_wan_android_title_bar is invalid. Received: " + tag);
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
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(5);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    result.add(new com.shijingfeng.background_service.DataBinderMapperImpl());
    result.add(new com.shijingfeng.base.DataBinderMapperImpl());
    result.add(new com.shijingfeng.common.DataBinderMapperImpl());
    result.add(new com.shijingfeng.tencent_x5.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(32);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "aboutUsViewModel");
      sKeys.put(2, "backgroundDrawable");
      sKeys.put(3, "classifyViewModel");
      sKeys.put(4, "coinRankViewModel");
      sKeys.put(5, "coinRecordViewModel");
      sKeys.put(6, "homeViewModel");
      sKeys.put(7, "ivBackClick");
      sKeys.put(8, "ivOperateClick");
      sKeys.put(9, "knowledgeClassifyChildViewModel");
      sKeys.put(10, "knowledgeClassifyDetailViewModel");
      sKeys.put(11, "knowledgeClassifyViewModel");
      sKeys.put(12, "loginViewModel");
      sKeys.put(13, "mainViewModel");
      sKeys.put(14, "navigationClassifyViewModel");
      sKeys.put(15, "officialAccountChildViewModel");
      sKeys.put(16, "officialAccountViewModel");
      sKeys.put(17, "personalCollectionArticleViewModel");
      sKeys.put(18, "personalCollectionViewModel");
      sKeys.put(19, "personalCollectionWebsiteViewModel");
      sKeys.put(20, "projectChildViewModel");
      sKeys.put(21, "projectViewModel");
      sKeys.put(22, "registerViewModel");
      sKeys.put(23, "searchListViewModel");
      sKeys.put(24, "searchViewModel");
      sKeys.put(25, "settingViewModel");
      sKeys.put(26, "squareViewModel");
      sKeys.put(27, "titleBarHeight");
      sKeys.put(28, "tvOperateClick");
      sKeys.put(29, "userInfoViewModel");
      sKeys.put(30, "viewOriginalImageViewModel");
      sKeys.put(31, "webViewViewModel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(30);

    static {
      sKeys.put("layout/activity_wan_android_about_us_0", com.shijingfeng.wan_android.R.layout.activity_wan_android_about_us);
      sKeys.put("layout/activity_wan_android_bmob_test_0", com.shijingfeng.wan_android.R.layout.activity_wan_android_bmob_test);
      sKeys.put("layout/activity_wan_android_coin_rank_0", com.shijingfeng.wan_android.R.layout.activity_wan_android_coin_rank);
      sKeys.put("layout/activity_wan_android_coin_record_0", com.shijingfeng.wan_android.R.layout.activity_wan_android_coin_record);
      sKeys.put("layout/activity_wan_android_knowledge_classify_detail_0", com.shijingfeng.wan_android.R.layout.activity_wan_android_knowledge_classify_detail);
      sKeys.put("layout/activity_wan_android_login_0", com.shijingfeng.wan_android.R.layout.activity_wan_android_login);
      sKeys.put("layout/activity_wan_android_main_0", com.shijingfeng.wan_android.R.layout.activity_wan_android_main);
      sKeys.put("layout/activity_wan_android_personal_collection_0", com.shijingfeng.wan_android.R.layout.activity_wan_android_personal_collection);
      sKeys.put("layout/activity_wan_android_register_0", com.shijingfeng.wan_android.R.layout.activity_wan_android_register);
      sKeys.put("layout/activity_wan_android_search_0", com.shijingfeng.wan_android.R.layout.activity_wan_android_search);
      sKeys.put("layout/activity_wan_android_search_list_0", com.shijingfeng.wan_android.R.layout.activity_wan_android_search_list);
      sKeys.put("layout/activity_wan_android_setting_0", com.shijingfeng.wan_android.R.layout.activity_wan_android_setting);
      sKeys.put("layout/activity_wan_android_splash_0", com.shijingfeng.wan_android.R.layout.activity_wan_android_splash);
      sKeys.put("layout/activity_wan_android_user_info_0", com.shijingfeng.wan_android.R.layout.activity_wan_android_user_info);
      sKeys.put("layout/activity_wan_android_web_view_0", com.shijingfeng.wan_android.R.layout.activity_wan_android_web_view);
      sKeys.put("layout/fragment_wan_android_classify_0", com.shijingfeng.wan_android.R.layout.fragment_wan_android_classify);
      sKeys.put("layout/fragment_wan_android_home_0", com.shijingfeng.wan_android.R.layout.fragment_wan_android_home);
      sKeys.put("layout/fragment_wan_android_knowledge_classify_0", com.shijingfeng.wan_android.R.layout.fragment_wan_android_knowledge_classify);
      sKeys.put("layout/fragment_wan_android_knowledge_classify_child_0", com.shijingfeng.wan_android.R.layout.fragment_wan_android_knowledge_classify_child);
      sKeys.put("layout/fragment_wan_android_navigation_classify_0", com.shijingfeng.wan_android.R.layout.fragment_wan_android_navigation_classify);
      sKeys.put("layout/fragment_wan_android_null_0", com.shijingfeng.wan_android.R.layout.fragment_wan_android_null);
      sKeys.put("layout/fragment_wan_android_official_account_0", com.shijingfeng.wan_android.R.layout.fragment_wan_android_official_account);
      sKeys.put("layout/fragment_wan_android_official_account_child_0", com.shijingfeng.wan_android.R.layout.fragment_wan_android_official_account_child);
      sKeys.put("layout/fragment_wan_android_personal_collection_article_0", com.shijingfeng.wan_android.R.layout.fragment_wan_android_personal_collection_article);
      sKeys.put("layout/fragment_wan_android_personal_collection_website_0", com.shijingfeng.wan_android.R.layout.fragment_wan_android_personal_collection_website);
      sKeys.put("layout/fragment_wan_android_project_0", com.shijingfeng.wan_android.R.layout.fragment_wan_android_project);
      sKeys.put("layout/fragment_wan_android_project_child_0", com.shijingfeng.wan_android.R.layout.fragment_wan_android_project_child);
      sKeys.put("layout/fragment_wan_android_square_0", com.shijingfeng.wan_android.R.layout.fragment_wan_android_square);
      sKeys.put("layout/layout_wan_android_main_activity_drawer_0", com.shijingfeng.wan_android.R.layout.layout_wan_android_main_activity_drawer);
      sKeys.put("layout/layout_wan_android_title_bar_0", com.shijingfeng.wan_android.R.layout.layout_wan_android_title_bar);
    }
  }
}
