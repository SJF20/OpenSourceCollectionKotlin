package com.shijingfeng.wan_android.databinding;
import com.shijingfeng.wan_android.R;
import com.shijingfeng.wan_android.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityWanAndroidCoinRankBindingImpl extends ActivityWanAndroidCoinRankBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(5);
        sIncludes.setIncludes(0, 
            new String[] {"layout_wan_android_title_bar"},
            new int[] {2},
            new int[] {com.shijingfeng.wan_android.R.layout.layout_wan_android_title_bar});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rv_list, 3);
        sViewsWithIds.put(R.id.fab_to_top, 4);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityWanAndroidCoinRankBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private ActivityWanAndroidCoinRankBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[4]
            , (com.shijingfeng.wan_android.databinding.LayoutWanAndroidTitleBarBinding) bindings[2]
            , (androidx.recyclerview.widget.RecyclerView) bindings[3]
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
        if (BR.coinRankViewModel == variableId) {
            setCoinRankViewModel((com.shijingfeng.wan_android.view_model.CoinRankViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setCoinRankViewModel(@Nullable com.shijingfeng.wan_android.view_model.CoinRankViewModel CoinRankViewModel) {
        this.mCoinRankViewModel = CoinRankViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.coinRankViewModel);
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
        android.view.View.OnClickListener coinRankViewModelMBackClickListener = null;
        com.scwang.smartrefresh.layout.listener.OnLoadMoreListener coinRankViewModelMOnLoadMoreListener = null;
        com.shijingfeng.wan_android.view_model.CoinRankViewModel coinRankViewModel = mCoinRankViewModel;
        com.scwang.smartrefresh.layout.listener.OnRefreshListener coinRankViewModelMOnRefreshListener = null;

        if ((dirtyFlags & 0x6L) != 0) {



                if (coinRankViewModel != null) {
                    // read coinRankViewModel.mBackClickListener
                    coinRankViewModelMBackClickListener = coinRankViewModel.getMBackClickListener();
                    // read coinRankViewModel.mOnLoadMoreListener
                    coinRankViewModelMOnLoadMoreListener = coinRankViewModel.getMOnLoadMoreListener();
                    // read coinRankViewModel.mOnRefreshListener
                    coinRankViewModelMOnRefreshListener = coinRankViewModel.getMOnRefreshListener();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            this.includeTitleBar.setIvBackClick(coinRankViewModelMBackClickListener);
            com.shijingfeng.base.databinding.view_adapter.SmartRefreshLayoutViewAdapter.setOnLoadMoreListener(this.srlRefresh, coinRankViewModelMOnLoadMoreListener);
            com.shijingfeng.base.databinding.view_adapter.SmartRefreshLayoutViewAdapter.setOnRefreshListener(this.srlRefresh, coinRankViewModelMOnRefreshListener);
        }
        executeBindingsOn(includeTitleBar);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): includeTitleBar
        flag 1 (0x2L): coinRankViewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}