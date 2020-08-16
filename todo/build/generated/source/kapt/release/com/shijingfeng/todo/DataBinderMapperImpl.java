package com.shijingfeng.todo;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.shijingfeng.todo.databinding.ActivityTodoMainBindingImpl;
import com.shijingfeng.todo.databinding.FragmentTodoMainDoneBindingImpl;
import com.shijingfeng.todo.databinding.FragmentTodoMainTodoBindingImpl;
import com.shijingfeng.todo.databinding.FragmentTodoNullBindingImpl;
import com.shijingfeng.todo.databinding.LayoutTodoTitleBarBindingImpl;
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
  private static final int LAYOUT_ACTIVITYTODOMAIN = 1;

  private static final int LAYOUT_FRAGMENTTODOMAINDONE = 2;

  private static final int LAYOUT_FRAGMENTTODOMAINTODO = 3;

  private static final int LAYOUT_FRAGMENTTODONULL = 4;

  private static final int LAYOUT_LAYOUTTODOTITLEBAR = 5;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(5);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.todo.R.layout.activity_todo_main, LAYOUT_ACTIVITYTODOMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.todo.R.layout.fragment_todo_main_done, LAYOUT_FRAGMENTTODOMAINDONE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.todo.R.layout.fragment_todo_main_todo, LAYOUT_FRAGMENTTODOMAINTODO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.todo.R.layout.fragment_todo_null, LAYOUT_FRAGMENTTODONULL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.shijingfeng.todo.R.layout.layout_todo_title_bar, LAYOUT_LAYOUTTODOTITLEBAR);
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
        case  LAYOUT_ACTIVITYTODOMAIN: {
          if ("layout/activity_todo_main_0".equals(tag)) {
            return new ActivityTodoMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_todo_main is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTTODOMAINDONE: {
          if ("layout/fragment_todo_main_done_0".equals(tag)) {
            return new FragmentTodoMainDoneBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_todo_main_done is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTTODOMAINTODO: {
          if ("layout/fragment_todo_main_todo_0".equals(tag)) {
            return new FragmentTodoMainTodoBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_todo_main_todo is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTTODONULL: {
          if ("layout/fragment_todo_null_0".equals(tag)) {
            return new FragmentTodoNullBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_todo_null is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTTODOTITLEBAR: {
          if ("layout/layout_todo_title_bar_0".equals(tag)) {
            return new LayoutTodoTitleBarBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_todo_title_bar is invalid. Received: " + tag);
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
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(2);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    result.add(new com.shijingfeng.base.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(9);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "backgroundDrawable");
      sKeys.put(2, "doneViewModel");
      sKeys.put(3, "ivBackClick");
      sKeys.put(4, "ivOperateClick");
      sKeys.put(5, "mainViewModel");
      sKeys.put(6, "titleBarHeight");
      sKeys.put(7, "todoViewModel");
      sKeys.put(8, "tvOperateClick");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(5);

    static {
      sKeys.put("layout/activity_todo_main_0", com.shijingfeng.todo.R.layout.activity_todo_main);
      sKeys.put("layout/fragment_todo_main_done_0", com.shijingfeng.todo.R.layout.fragment_todo_main_done);
      sKeys.put("layout/fragment_todo_main_todo_0", com.shijingfeng.todo.R.layout.fragment_todo_main_todo);
      sKeys.put("layout/fragment_todo_null_0", com.shijingfeng.todo.R.layout.fragment_todo_null);
      sKeys.put("layout/layout_todo_title_bar_0", com.shijingfeng.todo.R.layout.layout_todo_title_bar);
    }
  }
}
