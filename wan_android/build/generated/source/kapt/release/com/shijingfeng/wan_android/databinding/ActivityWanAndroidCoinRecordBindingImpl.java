package com.shijingfeng.wan_android.databinding;
import com.shijingfeng.wan_android.R;
import com.shijingfeng.wan_android.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityWanAndroidCoinRecordBindingImpl extends ActivityWanAndroidCoinRecordBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(7);
        sIncludes.setIncludes(1, 
            new String[] {"layout_wan_android_title_bar"},
            new int[] {3},
            new int[] {com.shijingfeng.wan_android.R.layout.layout_wan_android_title_bar});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tv_coin_quantity, 4);
        sViewsWithIds.put(R.id.rv_content, 5);
        sViewsWithIds.put(R.id.fab_to_top, 6);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityWanAndroidCoinRecordBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private ActivityWanAndroidCoinRecordBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[6]
            , (com.shijingfeng.wan_android.databinding.LayoutWanAndroidTitleBarBinding) bindings[3]
            , (android.widget.LinearLayout) bindings[1]
            , (androidx.recyclerview.widget.RecyclerView) bindings[5]
            , (com.scwang.smartrefresh.layout.SmartRefreshLayout) bindings[2]
            , (android.widget.TextView) bindings[4]
            );
        this.llHeader.setTag(this.llHeader.getResources().getString(com.shijingfeng.wan_android.R.string.wan_android_theme_color_background));
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
        if (BR.coinRecordViewModel == variableId) {
            setCoinRecordViewModel((com.shijingfeng.wan_android.view_model.CoinRecordViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setCoinRecordViewModel(@Nullable com.shijingfeng.wan_android.view_model.CoinRecordViewModel CoinRecordViewModel) {
        this.mCoinRecordViewModel = CoinRecordViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.coinRecordViewModel);
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
        com.shijingfeng.wan_android.view_model.CoinRecordViewModel coinRecordViewModel = mCoinRecordViewModel;
        android.view.View.OnClickListener coinRecordViewModelMBackClickListener = null;
        com.scwang.smartrefresh.layout.listener.OnLoadMoreListener coinRecordViewModelMOnLoadMoreListener = null;
        com.scwang.smartrefresh.layout.listener.OnRefreshListener coinRecordViewModelMOnRefreshListener = null;
        android.view.View.OnClickListener coinRecordViewModelMTextOperateClickListener = null;

        if ((dirtyFlags & 0x6L) != 0) {



                if (coinRecordViewModel != null) {
                    // read coinRecordViewModel.mBackClickListener
                    coinRecordViewModelMBackClickListener = coinRecordViewModel.getMBackClickListener();
                    // read coinRecordViewModel.mOnLoadMoreListener
                    coinRecordViewModelMOnLoadMoreListener = coinRecordViewModel.getMOnLoadMoreListener();
                    // read coinRecordViewModel.mOnRefreshListener
                    coinRecordViewModelMOnRefreshListener = coinRecordViewModel.getMOnRefreshListener();
                    // read coinRecordViewModel.mTextOperateClickListener
                    coinRecordViewModelMTextOperateClickListener = coinRecordViewModel.getMTextOperateClickListener();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            this.includeTitleBar.setIvBackClick(coinRecordViewModelMBackClickListener);
            this.includeTitleBar.setIvOperateClick(coinRecordViewModelMTextOperateClickListener);
            com.shijingfeng.base.databinding.view_adapter.SmartRefreshLayoutViewAdapter.setOnLoadMoreListener(this.srlRefresh, coinRecordViewModelMOnLoadMoreListener);
            com.shijingfeng.base.databinding.view_adapter.SmartRefreshLayoutViewAdapter.setOnRefreshListener(this.srlRefresh, coinRecordViewModelMOnRefreshListener);
        }
        executeBindingsOn(includeTitleBar);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): includeTitleBar
        flag 1 (0x2L): coinRecordViewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}