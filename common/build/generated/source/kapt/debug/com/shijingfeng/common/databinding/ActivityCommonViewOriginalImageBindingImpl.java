package com.shijingfeng.common.databinding;
import com.shijingfeng.common.R;
import com.shijingfeng.common.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityCommonViewOriginalImageBindingImpl extends ActivityCommonViewOriginalImageBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(4);
        sIncludes.setIncludes(0, 
            new String[] {"layout_status_bar"},
            new int[] {1},
            new int[] {com.shijingfeng.base.R.layout.layout_status_bar});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tv_count, 2);
        sViewsWithIds.put(R.id.vp_image, 3);
    }
    // views
    @Nullable
    private final com.shijingfeng.base.databinding.LayoutStatusBarBinding mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView01;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityCommonViewOriginalImageBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private ActivityCommonViewOriginalImageBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[2]
            , (com.shijingfeng.base.widget.PhotoViewPager) bindings[3]
            );
        this.mboundView0 = (com.shijingfeng.base.databinding.LayoutStatusBarBinding) bindings[1];
        setContainedBinding(this.mboundView0);
        this.mboundView01 = (android.widget.LinearLayout) bindings[0];
        this.mboundView01.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        mboundView0.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (mboundView0.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.viewOriginalImageViewModel == variableId) {
            setViewOriginalImageViewModel((com.shijingfeng.common.viewmodel.ViewOriginalImageViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewOriginalImageViewModel(@Nullable com.shijingfeng.common.viewmodel.ViewOriginalImageViewModel ViewOriginalImageViewModel) {
        this.mViewOriginalImageViewModel = ViewOriginalImageViewModel;
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        mboundView0.setLifecycleOwner(lifecycleOwner);
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
        // batch finished
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.mboundView0.setBackgroundDrawable(androidx.databinding.adapters.Converters.convertColorToDrawable(getColorFromResource(getRoot(), R.color.black)));
        }
        executeBindingsOn(mboundView0);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewOriginalImageViewModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}