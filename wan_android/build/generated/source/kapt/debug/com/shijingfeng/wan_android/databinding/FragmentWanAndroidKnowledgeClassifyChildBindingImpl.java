package com.shijingfeng.wan_android.databinding;
import com.shijingfeng.wan_android.R;
import com.shijingfeng.wan_android.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentWanAndroidKnowledgeClassifyChildBindingImpl extends FragmentWanAndroidKnowledgeClassifyChildBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rv_content, 2);
        sViewsWithIds.put(R.id.fab_to_top, 3);
    }
    // views
    @NonNull
    private final android.widget.FrameLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentWanAndroidKnowledgeClassifyChildBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private FragmentWanAndroidKnowledgeClassifyChildBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[3]
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
        if (BR.knowledgeClassifyChildViewModel == variableId) {
            setKnowledgeClassifyChildViewModel((com.shijingfeng.wan_android.view_model.KnowledgeClassifyChildViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setKnowledgeClassifyChildViewModel(@Nullable com.shijingfeng.wan_android.view_model.KnowledgeClassifyChildViewModel KnowledgeClassifyChildViewModel) {
        this.mKnowledgeClassifyChildViewModel = KnowledgeClassifyChildViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.knowledgeClassifyChildViewModel);
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
        com.scwang.smartrefresh.layout.listener.OnLoadMoreListener knowledgeClassifyChildViewModelMOnLoadMoreListener = null;
        com.shijingfeng.wan_android.view_model.KnowledgeClassifyChildViewModel knowledgeClassifyChildViewModel = mKnowledgeClassifyChildViewModel;
        com.scwang.smartrefresh.layout.listener.OnRefreshListener knowledgeClassifyChildViewModelMOnRefreshListener = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (knowledgeClassifyChildViewModel != null) {
                    // read knowledgeClassifyChildViewModel.mOnLoadMoreListener
                    knowledgeClassifyChildViewModelMOnLoadMoreListener = knowledgeClassifyChildViewModel.getMOnLoadMoreListener();
                    // read knowledgeClassifyChildViewModel.mOnRefreshListener
                    knowledgeClassifyChildViewModelMOnRefreshListener = knowledgeClassifyChildViewModel.getMOnRefreshListener();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.shijingfeng.base.databinding.view_adapter.SmartRefreshLayoutViewAdapter.setOnLoadMoreListener(this.srlRefresh, knowledgeClassifyChildViewModelMOnLoadMoreListener);
            com.shijingfeng.base.databinding.view_adapter.SmartRefreshLayoutViewAdapter.setOnRefreshListener(this.srlRefresh, knowledgeClassifyChildViewModelMOnRefreshListener);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): knowledgeClassifyChildViewModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}