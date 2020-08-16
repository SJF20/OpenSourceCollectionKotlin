package com.shijingfeng.wan_android.databinding;
import com.shijingfeng.wan_android.R;
import com.shijingfeng.wan_android.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityWanAndroidPersonalCollectionBindingImpl extends ActivityWanAndroidPersonalCollectionBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.fl_title_bar, 2);
        sViewsWithIds.put(R.id.tl_tabs, 3);
        sViewsWithIds.put(R.id.vp_content, 4);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityWanAndroidPersonalCollectionBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private ActivityWanAndroidPersonalCollectionBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.FrameLayout) bindings[2]
            , (android.widget.ImageView) bindings[1]
            , (com.google.android.material.tabs.TabLayout) bindings[3]
            , (com.shijingfeng.base.widget.NoScrollViewPager) bindings[4]
            );
        this.ivBack.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.personalCollectionViewModel == variableId) {
            setPersonalCollectionViewModel((com.shijingfeng.wan_android.view_model.PersonalCollectionViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setPersonalCollectionViewModel(@Nullable com.shijingfeng.wan_android.view_model.PersonalCollectionViewModel PersonalCollectionViewModel) {
        this.mPersonalCollectionViewModel = PersonalCollectionViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.personalCollectionViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
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
        com.shijingfeng.wan_android.view_model.PersonalCollectionViewModel personalCollectionViewModel = mPersonalCollectionViewModel;
        android.view.View.OnClickListener personalCollectionViewModelMBackClickListener = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (personalCollectionViewModel != null) {
                    // read personalCollectionViewModel.mBackClickListener
                    personalCollectionViewModelMBackClickListener = personalCollectionViewModel.getMBackClickListener();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.shijingfeng.base.databinding.view_adapter.ViewViewAdapter.onClick(this.ivBack, personalCollectionViewModelMBackClickListener, (boolean)false, (int)0);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): personalCollectionViewModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}