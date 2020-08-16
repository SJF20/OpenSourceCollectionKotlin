package com.shijingfeng.wan_android.databinding;
import com.shijingfeng.wan_android.R;
import com.shijingfeng.wan_android.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityWanAndroidMainBindingImpl extends ActivityWanAndroidMainBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(11);
        sIncludes.setIncludes(0, 
            new String[] {"layout_wan_android_main_activity_drawer"},
            new int[] {1},
            new int[] {com.shijingfeng.wan_android.R.layout.layout_wan_android_main_activity_drawer});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.sbv_status_bar, 2);
        sViewsWithIds.put(R.id.ll_title_bar, 3);
        sViewsWithIds.put(R.id.iv_menu, 4);
        sViewsWithIds.put(R.id.tv_title, 5);
        sViewsWithIds.put(R.id.iv_search, 6);
        sViewsWithIds.put(R.id.vp_content, 7);
        sViewsWithIds.put(R.id.ll_tabs, 8);
        sViewsWithIds.put(R.id.tl_tabs, 9);
        sViewsWithIds.put(R.id.fab_to_top, 10);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityWanAndroidMainBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private ActivityWanAndroidMainBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (androidx.drawerlayout.widget.DrawerLayout) bindings[0]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[10]
            , (com.shijingfeng.wan_android.databinding.LayoutWanAndroidMainActivityDrawerBinding) bindings[1]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.LinearLayout) bindings[3]
            , (com.shijingfeng.base.widget.StatusBarView) bindings[2]
            , (com.google.android.material.tabs.TabLayout) bindings[9]
            , (android.widget.TextView) bindings[5]
            , (androidx.viewpager.widget.ViewPager) bindings[7]
            );
        this.dwlDrawer.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        includeDrawer.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (includeDrawer.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.mainViewModel == variableId) {
            setMainViewModel((com.shijingfeng.wan_android.view_model.MainViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setMainViewModel(@Nullable com.shijingfeng.wan_android.view_model.MainViewModel MainViewModel) {
        this.mMainViewModel = MainViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.mainViewModel);
        super.requestRebind();
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        includeDrawer.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeIncludeDrawer((com.shijingfeng.wan_android.databinding.LayoutWanAndroidMainActivityDrawerBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeIncludeDrawer(com.shijingfeng.wan_android.databinding.LayoutWanAndroidMainActivityDrawerBinding IncludeDrawer, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.shijingfeng.wan_android.view_model.MainViewModel mainViewModel = mMainViewModel;

        if ((dirtyFlags & 0x6L) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            this.includeDrawer.setMainViewModel(mainViewModel);
        }
        executeBindingsOn(includeDrawer);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): includeDrawer
        flag 1 (0x2L): mainViewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}