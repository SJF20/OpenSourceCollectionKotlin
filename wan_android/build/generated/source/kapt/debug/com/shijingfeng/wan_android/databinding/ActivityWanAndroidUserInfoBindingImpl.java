package com.shijingfeng.wan_android.databinding;
import com.shijingfeng.wan_android.R;
import com.shijingfeng.wan_android.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityWanAndroidUserInfoBindingImpl extends ActivityWanAndroidUserInfoBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(2);
        sIncludes.setIncludes(0, 
            new String[] {"layout_wan_android_title_bar"},
            new int[] {1},
            new int[] {com.shijingfeng.wan_android.R.layout.layout_wan_android_title_bar});
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityWanAndroidUserInfoBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 2, sIncludes, sViewsWithIds));
    }
    private ActivityWanAndroidUserInfoBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (com.shijingfeng.wan_android.databinding.LayoutWanAndroidTitleBarBinding) bindings[1]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
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
        if (BR.userInfoViewModel == variableId) {
            setUserInfoViewModel((com.shijingfeng.wan_android.view_model.UserInfoViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setUserInfoViewModel(@Nullable com.shijingfeng.wan_android.view_model.UserInfoViewModel UserInfoViewModel) {
        this.mUserInfoViewModel = UserInfoViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.userInfoViewModel);
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
                return onChangeIncludeTitleBar((com.shijingfeng.wan_android.databinding.LayoutWanAndroidTitleBarBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeIncludeTitleBar(com.shijingfeng.wan_android.databinding.LayoutWanAndroidTitleBarBinding IncludeTitleBar, int fieldId) {
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
        com.shijingfeng.wan_android.view_model.UserInfoViewModel userInfoViewModel = mUserInfoViewModel;
        android.view.View.OnClickListener userInfoViewModelMBackClickListener = null;

        if ((dirtyFlags & 0x6L) != 0) {



                if (userInfoViewModel != null) {
                    // read userInfoViewModel.mBackClickListener
                    userInfoViewModelMBackClickListener = userInfoViewModel.getMBackClickListener();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            this.includeTitleBar.setIvBackClick(userInfoViewModelMBackClickListener);
        }
        executeBindingsOn(includeTitleBar);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): includeTitleBar
        flag 1 (0x2L): userInfoViewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}