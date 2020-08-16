package com.shijingfeng.wan_android.databinding;
import com.shijingfeng.wan_android.R;
import com.shijingfeng.wan_android.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class LayoutWanAndroidMainActivityDrawerBindingImpl extends LayoutWanAndroidMainActivityDrawerBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.sbv_status_bar, 9);
        sViewsWithIds.put(R.id.iv_portrait, 10);
        sViewsWithIds.put(R.id.tv_name, 11);
        sViewsWithIds.put(R.id.tv_id, 12);
        sViewsWithIds.put(R.id.tv_level, 13);
        sViewsWithIds.put(R.id.tv_rank, 14);
        sViewsWithIds.put(R.id.ll_menu, 15);
        sViewsWithIds.put(R.id.iv_coin, 16);
        sViewsWithIds.put(R.id.tv_coin, 17);
        sViewsWithIds.put(R.id.tv_coin_quantity, 18);
        sViewsWithIds.put(R.id.iv_collection, 19);
        sViewsWithIds.put(R.id.tv_collection, 20);
        sViewsWithIds.put(R.id.iv_todo, 21);
        sViewsWithIds.put(R.id.tv_todo, 22);
        sViewsWithIds.put(R.id.iv_setting, 23);
        sViewsWithIds.put(R.id.tv_setting, 24);
        sViewsWithIds.put(R.id.iv_about, 25);
        sViewsWithIds.put(R.id.tv_about, 26);
        sViewsWithIds.put(R.id.iv_logout, 27);
        sViewsWithIds.put(R.id.tv_logout, 28);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public LayoutWanAndroidMainActivityDrawerBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 29, sIncludes, sViewsWithIds));
    }
    private LayoutWanAndroidMainActivityDrawerBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[25]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.ImageView) bindings[19]
            , (android.widget.ImageView) bindings[27]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[10]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.ImageView) bindings[23]
            , (android.widget.ImageView) bindings[21]
            , (android.widget.LinearLayout) bindings[7]
            , (android.widget.LinearLayout) bindings[3]
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.LinearLayout) bindings[15]
            , (android.widget.LinearLayout) bindings[0]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.LinearLayout) bindings[5]
            , (com.shijingfeng.base.widget.StatusBarView) bindings[9]
            , (android.widget.TextView) bindings[26]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[18]
            , (android.widget.TextView) bindings[20]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[28]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[24]
            , (android.widget.TextView) bindings[22]
            );
        this.ivRank.setTag(null);
        this.llAbout.setTag(null);
        this.llCoin.setTag(null);
        this.llCollection.setTag(null);
        this.llHeader.setTag(this.llHeader.getResources().getString(com.shijingfeng.wan_android.R.string.wan_android_theme_color_background));
        this.llLogout.setTag(null);
        this.llNav.setTag(null);
        this.llSetting.setTag(null);
        this.llTodo.setTag(null);
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
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.mainViewModel);
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
        android.view.View.OnClickListener mainViewModelMLogoutClickListener = null;
        android.view.View.OnClickListener mainViewModelMTodoClickListener = null;
        android.view.View.OnClickListener mainViewModelMCollectionClickListener = null;
        android.view.View.OnClickListener mainViewModelMRankClickListener = null;
        android.view.View.OnClickListener mainViewModelMHeaderClickListener = null;
        android.view.View.OnClickListener mainViewModelMSettingClickListener = null;
        com.shijingfeng.wan_android.view_model.MainViewModel mainViewModel = mMainViewModel;
        android.view.View.OnClickListener mainViewModelMCoinRecordClickListener = null;
        android.view.View.OnClickListener mainViewModelMAboutClickListener = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (mainViewModel != null) {
                    // read mainViewModel.mLogoutClickListener
                    mainViewModelMLogoutClickListener = mainViewModel.getMLogoutClickListener();
                    // read mainViewModel.mTodoClickListener
                    mainViewModelMTodoClickListener = mainViewModel.getMTodoClickListener();
                    // read mainViewModel.mCollectionClickListener
                    mainViewModelMCollectionClickListener = mainViewModel.getMCollectionClickListener();
                    // read mainViewModel.mRankClickListener
                    mainViewModelMRankClickListener = mainViewModel.getMRankClickListener();
                    // read mainViewModel.mHeaderClickListener
                    mainViewModelMHeaderClickListener = mainViewModel.getMHeaderClickListener();
                    // read mainViewModel.mSettingClickListener
                    mainViewModelMSettingClickListener = mainViewModel.getMSettingClickListener();
                    // read mainViewModel.mCoinRecordClickListener
                    mainViewModelMCoinRecordClickListener = mainViewModel.getMCoinRecordClickListener();
                    // read mainViewModel.mAboutClickListener
                    mainViewModelMAboutClickListener = mainViewModel.getMAboutClickListener();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.shijingfeng.base.databinding.view_adapter.ViewViewAdapter.onClick(this.ivRank, mainViewModelMRankClickListener, (boolean)false, (int)0);
            com.shijingfeng.base.databinding.view_adapter.ViewViewAdapter.onClick(this.llAbout, mainViewModelMAboutClickListener, (boolean)false, (int)0);
            com.shijingfeng.base.databinding.view_adapter.ViewViewAdapter.onClick(this.llCoin, mainViewModelMCoinRecordClickListener, (boolean)false, (int)0);
            com.shijingfeng.base.databinding.view_adapter.ViewViewAdapter.onClick(this.llCollection, mainViewModelMCollectionClickListener, (boolean)false, (int)0);
            com.shijingfeng.base.databinding.view_adapter.ViewViewAdapter.onClick(this.llHeader, mainViewModelMHeaderClickListener, (boolean)false, (int)0);
            com.shijingfeng.base.databinding.view_adapter.ViewViewAdapter.onClick(this.llLogout, mainViewModelMLogoutClickListener, (boolean)false, (int)0);
            com.shijingfeng.base.databinding.view_adapter.ViewViewAdapter.onClick(this.llSetting, mainViewModelMSettingClickListener, (boolean)false, (int)0);
            com.shijingfeng.base.databinding.view_adapter.ViewViewAdapter.onClick(this.llTodo, mainViewModelMTodoClickListener, (boolean)false, (int)0);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): mainViewModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}