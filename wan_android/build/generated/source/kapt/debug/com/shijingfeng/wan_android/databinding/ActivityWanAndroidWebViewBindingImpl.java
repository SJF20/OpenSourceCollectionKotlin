package com.shijingfeng.wan_android.databinding;
import com.shijingfeng.wan_android.R;
import com.shijingfeng.wan_android.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityWanAndroidWebViewBindingImpl extends ActivityWanAndroidWebViewBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(6);
        sIncludes.setIncludes(1, 
            new String[] {"layout_wan_android_title_bar"},
            new int[] {2},
            new int[] {com.shijingfeng.wan_android.R.layout.layout_wan_android_title_bar});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.pb_progress, 3);
        sViewsWithIds.put(R.id.wv_content, 4);
        sViewsWithIds.put(R.id.frame_video, 5);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityWanAndroidWebViewBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private ActivityWanAndroidWebViewBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.FrameLayout) bindings[5]
            , (com.shijingfeng.wan_android.databinding.LayoutWanAndroidTitleBarBinding) bindings[2]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.ProgressBar) bindings[3]
            , (com.shijingfeng.tencent_x5.widget.CustomX5WebView) bindings[4]
            );
        this.llWebView.setTag(null);
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
        if (BR.webViewViewModel == variableId) {
            setWebViewViewModel((com.shijingfeng.wan_android.view_model.WebViewViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setWebViewViewModel(@Nullable com.shijingfeng.wan_android.view_model.WebViewViewModel WebViewViewModel) {
        this.mWebViewViewModel = WebViewViewModel;
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
        // batch finished
        executeBindingsOn(includeTitleBar);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): includeTitleBar
        flag 1 (0x2L): webViewViewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}