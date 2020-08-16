package com.shijingfeng.wan_android.databinding;
import com.shijingfeng.wan_android.R;
import com.shijingfeng.wan_android.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class LayoutWanAndroidTitleBarBindingImpl extends LayoutWanAndroidTitleBarBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tv_title, 4);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public LayoutWanAndroidTitleBarBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private LayoutWanAndroidTitleBarBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.FrameLayout) bindings[0]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[4]
            );
        this.flTitleBar.setTag(this.flTitleBar.getResources().getString(com.shijingfeng.wan_android.R.string.wan_android_theme_color_background));
        this.ivBack.setTag(null);
        this.ivOperate.setTag(null);
        this.tvOperate.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
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
        if (BR.ivBackClick == variableId) {
            setIvBackClick((android.view.View.OnClickListener) variable);
        }
        else if (BR.tvOperateClick == variableId) {
            setTvOperateClick((android.view.View.OnClickListener) variable);
        }
        else if (BR.ivOperateClick == variableId) {
            setIvOperateClick((android.view.View.OnClickListener) variable);
        }
        else if (BR.titleBarHeight == variableId) {
            setTitleBarHeight((float) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setIvBackClick(@Nullable android.view.View.OnClickListener IvBackClick) {
        this.mIvBackClick = IvBackClick;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.ivBackClick);
        super.requestRebind();
    }
    public void setTvOperateClick(@Nullable android.view.View.OnClickListener TvOperateClick) {
        this.mTvOperateClick = TvOperateClick;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.tvOperateClick);
        super.requestRebind();
    }
    public void setIvOperateClick(@Nullable android.view.View.OnClickListener IvOperateClick) {
        this.mIvOperateClick = IvOperateClick;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.ivOperateClick);
        super.requestRebind();
    }
    public void setTitleBarHeight(float TitleBarHeight) {
        this.mTitleBarHeight = TitleBarHeight;
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
        android.view.View.OnClickListener ivBackClick = mIvBackClick;
        android.view.View.OnClickListener tvOperateClick = mTvOperateClick;
        android.view.View.OnClickListener ivOperateClick = mIvOperateClick;

        if ((dirtyFlags & 0x11L) != 0) {
        }
        if ((dirtyFlags & 0x12L) != 0) {
        }
        if ((dirtyFlags & 0x14L) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0x11L) != 0) {
            // api target 1

            com.shijingfeng.base.databinding.view_adapter.ViewViewAdapter.onClick(this.ivBack, ivBackClick, (boolean)false, (int)0);
        }
        if ((dirtyFlags & 0x14L) != 0) {
            // api target 1

            com.shijingfeng.base.databinding.view_adapter.ViewViewAdapter.onClick(this.ivOperate, ivOperateClick, (boolean)false, (int)0);
        }
        if ((dirtyFlags & 0x12L) != 0) {
            // api target 1

            com.shijingfeng.base.databinding.view_adapter.ViewViewAdapter.onClick(this.tvOperate, tvOperateClick, (boolean)false, (int)0);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): ivBackClick
        flag 1 (0x2L): tvOperateClick
        flag 2 (0x3L): ivOperateClick
        flag 3 (0x4L): titleBarHeight
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}