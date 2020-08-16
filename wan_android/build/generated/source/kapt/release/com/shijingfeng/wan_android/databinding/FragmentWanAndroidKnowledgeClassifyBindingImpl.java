package com.shijingfeng.wan_android.databinding;
import com.shijingfeng.wan_android.R;
import com.shijingfeng.wan_android.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentWanAndroidKnowledgeClassifyBindingImpl extends FragmentWanAndroidKnowledgeClassifyBinding  {

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
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentWanAndroidKnowledgeClassifyBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private FragmentWanAndroidKnowledgeClassifyBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.recyclerview.widget.RecyclerView) bindings[2]
            , (com.scwang.smartrefresh.layout.SmartRefreshLayout) bindings[1]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
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
        if (BR.knowledgeClassifyViewModel == variableId) {
            setKnowledgeClassifyViewModel((com.shijingfeng.wan_android.view_model.KnowledgeClassifyViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setKnowledgeClassifyViewModel(@Nullable com.shijingfeng.wan_android.view_model.KnowledgeClassifyViewModel KnowledgeClassifyViewModel) {
        this.mKnowledgeClassifyViewModel = KnowledgeClassifyViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.knowledgeClassifyViewModel);
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
        com.scwang.smartrefresh.layout.listener.OnRefreshListener knowledgeClassifyViewModelMOnRefreshListener = null;
        com.shijingfeng.wan_android.view_model.KnowledgeClassifyViewModel knowledgeClassifyViewModel = mKnowledgeClassifyViewModel;

        if ((dirtyFlags & 0x3L) != 0) {



                if (knowledgeClassifyViewModel != null) {
                    // read knowledgeClassifyViewModel.mOnRefreshListener
                    knowledgeClassifyViewModelMOnRefreshListener = knowledgeClassifyViewModel.getMOnRefreshListener();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.shijingfeng.base.databinding.view_adapter.SmartRefreshLayoutViewAdapter.setOnRefreshListener(this.srlRefresh, knowledgeClassifyViewModelMOnRefreshListener);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): knowledgeClassifyViewModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}