package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.shijingfeng.view_original_image.ui.activity.ViewOriginalImageActivity;
import java.lang.Override;
import java.lang.String;
import java.util.Map;

/**
 * DO NOT EDIT THIS FILE!!! IT WAS GENERATED BY AROUTER. */
public class ARouter$$Group$$common implements IRouteGroup {
  @Override
  public void loadInto(Map<String, RouteMeta> atlas) {
    atlas.put("/common/activity/ViewOriginalImageActivity", RouteMeta.build(RouteType.ACTIVITY, ViewOriginalImageActivity.class, "/common/activity/vieworiginalimageactivity", "common", null, -1, -2147483648));
  }
}
