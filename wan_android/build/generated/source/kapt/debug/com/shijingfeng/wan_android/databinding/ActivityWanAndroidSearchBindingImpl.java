package com.shijingfeng.wan_android.databinding;
import com.shijingfeng.wan_android.R;
import com.shijingfeng.wan_android.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityWanAndroidSearchBindingImpl extends ActivityWanAndroidSearchBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.ll_title_bar, 6);
        sViewsWithIds.put(R.id.ll_hot_word, 7);
        sViewsWithIds.put(R.id.rv_history, 8);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener etInputandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of searchViewModel.mSearchInput.get()
            //         is searchViewModel.mSearchInput.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(etInput);
            // localize variables for thread safety
            // searchViewModel
            com.shijingfeng.wan_android.view_model.SearchViewModel searchViewModel = mSearchViewModel;
            // searchViewModel.mSearchInput
            androidx.databinding.ObservableField<java.lang.String> searchViewModelMSearchInput = null;
            // searchViewModel.mSearchInput.get()
            java.lang.String searchViewModelMSearchInputGet = null;
            // searchViewModel != null
            boolean searchViewModelJavaLangObjectNull = false;
            // searchViewModel.mSearchInput != null
            boolean searchViewModelMSearchInputJavaLangObjectNull = false;



            searchViewModelJavaLangObjectNull = (searchViewModel) != (null);
            if (searchViewModelJavaLangObjectNull) {


                searchViewModelMSearchInput = searchViewModel.getMSearchInput();

                searchViewModelMSearchInputJavaLangObjectNull = (searchViewModelMSearchInput) != (null);
                if (searchViewModelMSearchInputJavaLangObjectNull) {




                    searchViewModelMSearchInput.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ActivityWanAndroidSearchBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private ActivityWanAndroidSearchBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.EditText) bindings[2]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.LinearLayout) bindings[7]
            , (android.widget.LinearLayout) bindings[6]
            , (androidx.recyclerview.widget.RecyclerView) bindings[8]
            , (android.widget.TextView) bindings[5]
            );
        this.etInput.setTag(null);
        this.ivBack.setTag(null);
        this.ivClearInput.setTag(null);
        this.ivSearch.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvClearHistory.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
        if (BR.searchViewModel == variableId) {
            setSearchViewModel((com.shijingfeng.wan_android.view_model.SearchViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setSearchViewModel(@Nullable com.shijingfeng.wan_android.view_model.SearchViewModel SearchViewModel) {
        this.mSearchViewModel = SearchViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.searchViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeSearchViewModelMSearchInputClearVisibility((androidx.databinding.ObservableInt) object, fieldId);
            case 1 :
                return onChangeSearchViewModelMSearchInput((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeSearchViewModelMSearchInputClearVisibility(androidx.databinding.ObservableInt SearchViewModelMSearchInputClearVisibility, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeSearchViewModelMSearchInput(androidx.databinding.ObservableField<java.lang.String> SearchViewModelMSearchInput, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
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
        androidx.databinding.ObservableInt searchViewModelMSearchInputClearVisibility = null;
        android.view.View.OnClickListener searchViewModelMSearchInputClearClickListener = null;
        int searchViewModelMSearchInputClearVisibilityGet = 0;
        androidx.databinding.ObservableField<java.lang.String> searchViewModelMSearchInput = null;
        android.view.View.OnClickListener searchViewModelMClearHistoryClickListener = null;
        android.view.View.OnClickListener searchViewModelMBackClickListener = null;
        com.shijingfeng.wan_android.view_model.SearchViewModel searchViewModel = mSearchViewModel;
        android.view.View.OnClickListener searchViewModelMSearchClickListener = null;
        java.lang.String searchViewModelMSearchInputGet = null;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xdL) != 0) {

                    if (searchViewModel != null) {
                        // read searchViewModel.mSearchInputClearVisibility
                        searchViewModelMSearchInputClearVisibility = searchViewModel.getMSearchInputClearVisibility();
                    }
                    updateRegistration(0, searchViewModelMSearchInputClearVisibility);


                    if (searchViewModelMSearchInputClearVisibility != null) {
                        // read searchViewModel.mSearchInputClearVisibility.get()
                        searchViewModelMSearchInputClearVisibilityGet = searchViewModelMSearchInputClearVisibility.get();
                    }
            }
            if ((dirtyFlags & 0xcL) != 0) {

                    if (searchViewModel != null) {
                        // read searchViewModel.mSearchInputClearClickListener
                        searchViewModelMSearchInputClearClickListener = searchViewModel.getMSearchInputClearClickListener();
                        // read searchViewModel.mClearHistoryClickListener
                        searchViewModelMClearHistoryClickListener = searchViewModel.getMClearHistoryClickListener();
                        // read searchViewModel.mBackClickListener
                        searchViewModelMBackClickListener = searchViewModel.getMBackClickListener();
                        // read searchViewModel.mSearchClickListener
                        searchViewModelMSearchClickListener = searchViewModel.getMSearchClickListener();
                    }
            }
            if ((dirtyFlags & 0xeL) != 0) {

                    if (searchViewModel != null) {
                        // read searchViewModel.mSearchInput
                        searchViewModelMSearchInput = searchViewModel.getMSearchInput();
                    }
                    updateRegistration(1, searchViewModelMSearchInput);


                    if (searchViewModelMSearchInput != null) {
                        // read searchViewModel.mSearchInput.get()
                        searchViewModelMSearchInputGet = searchViewModelMSearchInput.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etInput, searchViewModelMSearchInputGet);
        }
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            com.shijingfeng.base.databinding.view_adapter.EditTextViewAdapter.filterEmoji(this.etInput, true);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etInput, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etInputandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            com.shijingfeng.base.databinding.view_adapter.ViewViewAdapter.onClick(this.ivBack, searchViewModelMBackClickListener, (boolean)false, (int)0);
            com.shijingfeng.base.databinding.view_adapter.ViewViewAdapter.onClick(this.ivClearInput, searchViewModelMSearchInputClearClickListener, (boolean)false, (int)0);
            com.shijingfeng.base.databinding.view_adapter.ViewViewAdapter.onClick(this.ivSearch, searchViewModelMSearchClickListener, (boolean)false, (int)0);
            com.shijingfeng.base.databinding.view_adapter.ViewViewAdapter.onClick(this.tvClearHistory, searchViewModelMClearHistoryClickListener, (boolean)false, (int)0);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            this.ivClearInput.setVisibility(searchViewModelMSearchInputClearVisibilityGet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): searchViewModel.mSearchInputClearVisibility
        flag 1 (0x2L): searchViewModel.mSearchInput
        flag 2 (0x3L): searchViewModel
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}