package com.shijingfeng.wan_android.databinding;
import com.shijingfeng.wan_android.R;
import com.shijingfeng.wan_android.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentWanAndroidOfficialAccountChildBindingImpl extends FragmentWanAndroidOfficialAccountChildBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rv_content, 2);
    }
    // views
    @NonNull
    private final android.widget.FrameLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentWanAndroidOfficialAccountChildBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private FragmentWanAndroidOfficialAccountChildBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.recyclerview.widget.RecyclerView) bindings[2]
            , (com.scwang.smartrefresh.layout.SmartRefreshLayout) bindings[1]
            );
        this.mboundView0 = (android.widget.FrameLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.srlRefresh.setTag(null);
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
        if (BR.officialAccountChildViewModel == variableId) {
            setOfficialAccountChildViewModel((com.shijingfeng.wan_android.view_model.OfficialAccountChildViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setOfficialAccountChildViewModel(@Nullable com.shijingfeng.wan_android.view_model.OfficialAccountChildViewModel OfficialAccountChildViewModel) {
        this.mOfficialAccountChildViewModel = OfficialAccountChildViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.officialAccountChildViewModel);
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
        com.scwang.smartrefresh.layout.listener.OnLoadMoreListener officialAccountChildViewModelMOnLoadMoreListener = null;
        com.scwang.smartrefresh.layout.listener.OnRefreshListener officialAccountChildViewModelMOnRefreshListener = null;
        com.shijingfeng.wan_android.view_model.OfficialAccountChildViewModel officialAccountChildViewModel = mOfficialAccountChildViewModel;

        if ((dirtyFlags & 0x3L) != 0) {



                if (officialAccountChildViewModel != null) {
                    // read officialAccountChildViewModel.mOnLoadMoreListener
                    officialAccountChildViewModelMOnLoadMoreListener = officialAccountChildViewModel.getMOnLoadMoreListener();
                    // read officialAccountChildViewModel.mOnRefreshListener
                    officialAccountChildViewModelMOnRefreshListener = officialAccountChildViewModel.getMOnRefreshListener();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.shijingfeng.base.databinding.view_adapter.SmartRefreshLayoutViewAdapter.setOnRefreshListener(this.srlRefresh, officialAccountChildViewModelMOnRefreshListener);
            com.shijingfeng.base.databinding.view_adapter.SmartRefreshLayoutViewAdapter.setOnLoadMoreListener(this.srlRefresh, officialAccountChildViewModelMOnLoadMoreListener);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): officialAccountChildViewModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}