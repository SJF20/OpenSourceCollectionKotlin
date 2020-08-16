package com.shijingfeng.todo.databinding;
import com.shijingfeng.todo.R;
import com.shijingfeng.todo.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityTodoMainBindingImpl extends ActivityTodoMainBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(8);
        sIncludes.setIncludes(1, 
            new String[] {"layout_todo_title_bar"},
            new int[] {2},
            new int[] {com.shijingfeng.todo.R.layout.layout_todo_title_bar});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.sbv_status_bar1, 3);
        sViewsWithIds.put(R.id.vp_content, 4);
        sViewsWithIds.put(R.id.ll_tabs, 5);
        sViewsWithIds.put(R.id.tl_tabs, 6);
        sViewsWithIds.put(R.id.fab_add, 7);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final com.google.android.material.appbar.AppBarLayout mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityTodoMainBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private ActivityTodoMainBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[7]
            , (com.shijingfeng.todo.databinding.LayoutTodoTitleBarBinding) bindings[2]
            , (android.widget.LinearLayout) bindings[5]
            , (com.shijingfeng.base.widget.StatusBarView) bindings[3]
            , (com.google.android.material.tabs.TabLayout) bindings[6]
            , (androidx.viewpager.widget.ViewPager) bindings[4]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (com.google.android.material.appbar.AppBarLayout) bindings[1];
        this.mboundView1.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        includeTitleBar.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (includeTitleBar.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.mainViewModel == variableId) {
            setMainViewModel((com.shijingfeng.todo.view_model.MainViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setMainViewModel(@Nullable com.shijingfeng.todo.view_model.MainViewModel MainViewModel) {
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
        includeTitleBar.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeIncludeTitleBar((com.shijingfeng.todo.databinding.LayoutTodoTitleBarBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeIncludeTitleBar(com.shijingfeng.todo.databinding.LayoutTodoTitleBarBinding IncludeTitleBar, int fieldId) {
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
        com.shijingfeng.todo.view_model.MainViewModel mainViewModel = mMainViewModel;
        android.view.View.OnClickListener mainViewModelMBackClickListener = null;

        if ((dirtyFlags & 0x6L) != 0) {



                if (mainViewModel != null) {
                    // read mainViewModel.mBackClickListener
                    mainViewModelMBackClickListener = mainViewModel.getMBackClickListener();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            this.includeTitleBar.setIvBackClick(mainViewModelMBackClickListener);
        }
        executeBindingsOn(includeTitleBar);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): includeTitleBar
        flag 1 (0x2L): mainViewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}