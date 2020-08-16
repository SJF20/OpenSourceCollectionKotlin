package com.shijingfeng.wan_android.databinding;
import com.shijingfeng.wan_android.R;
import com.shijingfeng.wan_android.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityWanAndroidLoginBindingImpl extends ActivityWanAndroidLoginBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(10);
        sIncludes.setIncludes(0, 
            new String[] {"layout_wan_android_title_bar"},
            new int[] {8},
            new int[] {com.shijingfeng.wan_android.R.layout.layout_wan_android_title_bar});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tv_retrieve_password, 9);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView7;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener etUsernameandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of loginViewModel.MUsername.get()
            //         is loginViewModel.MUsername.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(etUsername);
            // localize variables for thread safety
            // loginViewModel.MUsername
            androidx.databinding.ObservableField<java.lang.String> loginViewModelMUsername = null;
            // loginViewModel != null
            boolean loginViewModelJavaLangObjectNull = false;
            // loginViewModel.MUsername.get()
            java.lang.String loginViewModelMUsernameGet = null;
            // loginViewModel.MUsername != null
            boolean loginViewModelMUsernameJavaLangObjectNull = false;
            // loginViewModel
            com.shijingfeng.wan_android.view_model.LoginViewModel loginViewModel = mLoginViewModel;



            loginViewModelJavaLangObjectNull = (loginViewModel) != (null);
            if (loginViewModelJavaLangObjectNull) {


                loginViewModelMUsername = loginViewModel.getMUsername();

                loginViewModelMUsernameJavaLangObjectNull = (loginViewModelMUsername) != (null);
                if (loginViewModelMUsernameJavaLangObjectNull) {




                    loginViewModelMUsername.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener etVerifyCodeandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of loginViewModel.MPassword.get()
            //         is loginViewModel.MPassword.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(etVerifyCode);
            // localize variables for thread safety
            // loginViewModel != null
            boolean loginViewModelJavaLangObjectNull = false;
            // loginViewModel.MPassword.get()
            java.lang.String loginViewModelMPasswordGet = null;
            // loginViewModel.MPassword != null
            boolean loginViewModelMPasswordJavaLangObjectNull = false;
            // loginViewModel
            com.shijingfeng.wan_android.view_model.LoginViewModel loginViewModel = mLoginViewModel;
            // loginViewModel.MPassword
            androidx.databinding.ObservableField<java.lang.String> loginViewModelMPassword = null;



            loginViewModelJavaLangObjectNull = (loginViewModel) != (null);
            if (loginViewModelJavaLangObjectNull) {


                loginViewModelMPassword = loginViewModel.getMPassword();

                loginViewModelMPasswordJavaLangObjectNull = (loginViewModelMPassword) != (null);
                if (loginViewModelMPasswordJavaLangObjectNull) {




                    loginViewModelMPassword.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ActivityWanAndroidLoginBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }
    private ActivityWanAndroidLoginBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 8
            , (android.widget.EditText) bindings[1]
            , (android.widget.EditText) bindings[3]
            , (com.shijingfeng.wan_android.databinding.LayoutWanAndroidTitleBarBinding) bindings[8]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[9]
            );
        this.etUsername.setTag(null);
        this.etVerifyCode.setTag(null);
        this.ivClearPassword.setTag(null);
        this.ivClearUsername.setTag(null);
        this.ivPasswordVisibility.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView7 = (android.widget.LinearLayout) bindings[7];
        this.mboundView7.setTag(null);
        this.tvLogin.setTag(this.tvLogin.getResources().getString(com.shijingfeng.wan_android.R.string.登录注册页面TAG));
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x200L;
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
        if (BR.loginViewModel == variableId) {
            setLoginViewModel((com.shijingfeng.wan_android.view_model.LoginViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setLoginViewModel(@Nullable com.shijingfeng.wan_android.view_model.LoginViewModel LoginViewModel) {
        this.mLoginViewModel = LoginViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x100L;
        }
        notifyPropertyChanged(BR.loginViewModel);
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
                return onChangeLoginViewModelMPasswordClearVisibility((androidx.databinding.ObservableInt) object, fieldId);
            case 1 :
                return onChangeLoginViewModelMIsCleartextPassword((androidx.databinding.ObservableBoolean) object, fieldId);
            case 2 :
                return onChangeIncludeTitleBar((com.shijingfeng.wan_android.databinding.LayoutWanAndroidTitleBarBinding) object, fieldId);
            case 3 :
                return onChangeLoginViewModelMIsLoginEnable((androidx.databinding.ObservableBoolean) object, fieldId);
            case 4 :
                return onChangeLoginViewModelMPasswordSecrecyIcon((androidx.databinding.ObservableField<android.graphics.drawable.Drawable>) object, fieldId);
            case 5 :
                return onChangeLoginViewModelMUsernameClearVisibility((androidx.databinding.ObservableInt) object, fieldId);
            case 6 :
                return onChangeLoginViewModelMPassword((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 7 :
                return onChangeLoginViewModelMUsername((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeLoginViewModelMPasswordClearVisibility(androidx.databinding.ObservableInt LoginViewModelMPasswordClearVisibility, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeLoginViewModelMIsCleartextPassword(androidx.databinding.ObservableBoolean LoginViewModelMIsCleartextPassword, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeIncludeTitleBar(com.shijingfeng.wan_android.databinding.LayoutWanAndroidTitleBarBinding IncludeTitleBar, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeLoginViewModelMIsLoginEnable(androidx.databinding.ObservableBoolean LoginViewModelMIsLoginEnable, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeLoginViewModelMPasswordSecrecyIcon(androidx.databinding.ObservableField<android.graphics.drawable.Drawable> LoginViewModelMPasswordSecrecyIcon, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeLoginViewModelMUsernameClearVisibility(androidx.databinding.ObservableInt LoginViewModelMUsernameClearVisibility, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeLoginViewModelMPassword(androidx.databinding.ObservableField<java.lang.String> LoginViewModelMPassword, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x40L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeLoginViewModelMUsername(androidx.databinding.ObservableField<java.lang.String> LoginViewModelMUsername, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x80L;
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
        int loginViewModelMUsernameClearVisibilityGet = 0;
        android.view.View.OnClickListener loginViewModelMClearUsernameClickListener = null;
        androidx.databinding.ObservableInt loginViewModelMPasswordClearVisibility = null;
        android.view.View.OnClickListener loginViewModelMClearPasswordClickListener = null;
        android.view.View.OnClickListener loginViewModelMPasswordVisibilityClickListener = null;
        android.view.View.OnClickListener loginViewModelMLoginClickListener = null;
        android.view.View.OnClickListener loginViewModelMRetrievePasswordClickListener = null;
        android.graphics.drawable.Drawable loginViewModelMPasswordSecrecyIconGet = null;
        android.view.View.OnClickListener loginViewModelMBackClickListener = null;
        java.lang.String loginViewModelMPasswordGet = null;
        androidx.databinding.ObservableBoolean loginViewModelMIsCleartextPassword = null;
        androidx.databinding.ObservableBoolean loginViewModelMIsLoginEnable = null;
        androidx.databinding.ObservableField<android.graphics.drawable.Drawable> loginViewModelMPasswordSecrecyIcon = null;
        androidx.databinding.ObservableInt loginViewModelMUsernameClearVisibility = null;
        androidx.databinding.ObservableField<java.lang.String> loginViewModelMPassword = null;
        androidx.databinding.ObservableField<java.lang.String> loginViewModelMUsername = null;
        java.lang.String loginViewModelMUsernameGet = null;
        android.view.View.OnClickListener loginViewModelMTextOperateClickListener = null;
        int loginViewModelMPasswordClearVisibilityGet = 0;
        boolean loginViewModelMIsCleartextPasswordGet = false;
        boolean loginViewModelMIsLoginEnableGet = false;
        com.shijingfeng.wan_android.view_model.LoginViewModel loginViewModel = mLoginViewModel;

        if ((dirtyFlags & 0x3fbL) != 0) {


            if ((dirtyFlags & 0x300L) != 0) {

                    if (loginViewModel != null) {
                        // read loginViewModel.MClearUsernameClickListener
                        loginViewModelMClearUsernameClickListener = loginViewModel.getMClearUsernameClickListener();
                        // read loginViewModel.MClearPasswordClickListener
                        loginViewModelMClearPasswordClickListener = loginViewModel.getMClearPasswordClickListener();
                        // read loginViewModel.MPasswordVisibilityClickListener
                        loginViewModelMPasswordVisibilityClickListener = loginViewModel.getMPasswordVisibilityClickListener();
                        // read loginViewModel.MLoginClickListener
                        loginViewModelMLoginClickListener = loginViewModel.getMLoginClickListener();
                        // read loginViewModel.MRetrievePasswordClickListener
                        loginViewModelMRetrievePasswordClickListener = loginViewModel.getMRetrievePasswordClickListener();
                        // read loginViewModel.MBackClickListener
                        loginViewModelMBackClickListener = loginViewModel.getMBackClickListener();
                        // read loginViewModel.MTextOperateClickListener
                        loginViewModelMTextOperateClickListener = loginViewModel.getMTextOperateClickListener();
                    }
            }
            if ((dirtyFlags & 0x301L) != 0) {

                    if (loginViewModel != null) {
                        // read loginViewModel.MPasswordClearVisibility
                        loginViewModelMPasswordClearVisibility = loginViewModel.getMPasswordClearVisibility();
                    }
                    updateRegistration(0, loginViewModelMPasswordClearVisibility);


                    if (loginViewModelMPasswordClearVisibility != null) {
                        // read loginViewModel.MPasswordClearVisibility.get()
                        loginViewModelMPasswordClearVisibilityGet = loginViewModelMPasswordClearVisibility.get();
                    }
            }
            if ((dirtyFlags & 0x302L) != 0) {

                    if (loginViewModel != null) {
                        // read loginViewModel.MIsCleartextPassword
                        loginViewModelMIsCleartextPassword = loginViewModel.getMIsCleartextPassword();
                    }
                    updateRegistration(1, loginViewModelMIsCleartextPassword);


                    if (loginViewModelMIsCleartextPassword != null) {
                        // read loginViewModel.MIsCleartextPassword.get()
                        loginViewModelMIsCleartextPasswordGet = loginViewModelMIsCleartextPassword.get();
                    }
            }
            if ((dirtyFlags & 0x308L) != 0) {

                    if (loginViewModel != null) {
                        // read loginViewModel.MIsLoginEnable
                        loginViewModelMIsLoginEnable = loginViewModel.getMIsLoginEnable();
                    }
                    updateRegistration(3, loginViewModelMIsLoginEnable);


                    if (loginViewModelMIsLoginEnable != null) {
                        // read loginViewModel.MIsLoginEnable.get()
                        loginViewModelMIsLoginEnableGet = loginViewModelMIsLoginEnable.get();
                    }
            }
            if ((dirtyFlags & 0x310L) != 0) {

                    if (loginViewModel != null) {
                        // read loginViewModel.MPasswordSecrecyIcon
                        loginViewModelMPasswordSecrecyIcon = loginViewModel.getMPasswordSecrecyIcon();
                    }
                    updateRegistration(4, loginViewModelMPasswordSecrecyIcon);


                    if (loginViewModelMPasswordSecrecyIcon != null) {
                        // read loginViewModel.MPasswordSecrecyIcon.get()
                        loginViewModelMPasswordSecrecyIconGet = loginViewModelMPasswordSecrecyIcon.get();
                    }
            }
            if ((dirtyFlags & 0x320L) != 0) {

                    if (loginViewModel != null) {
                        // read loginViewModel.MUsernameClearVisibility
                        loginViewModelMUsernameClearVisibility = loginViewModel.getMUsernameClearVisibility();
                    }
                    updateRegistration(5, loginViewModelMUsernameClearVisibility);


                    if (loginViewModelMUsernameClearVisibility != null) {
                        // read loginViewModel.MUsernameClearVisibility.get()
                        loginViewModelMUsernameClearVisibilityGet = loginViewModelMUsernameClearVisibility.get();
                    }
            }
            if ((dirtyFlags & 0x340L) != 0) {

                    if (loginViewModel != null) {
                        // read loginViewModel.MPassword
                        loginViewModelMPassword = loginViewModel.getMPassword();
                    }
                    updateRegistration(6, loginViewModelMPassword);


                    if (loginViewModelMPassword != null) {
                        // read loginViewModel.MPassword.get()
                        loginViewModelMPasswordGet = loginViewModelMPassword.get();
                    }
            }
            if ((dirtyFlags & 0x380L) != 0) {

                    if (loginViewModel != null) {
                        // read loginViewModel.MUsername
                        loginViewModelMUsername = loginViewModel.getMUsername();
                    }
                    updateRegistration(7, loginViewModelMUsername);


                    if (loginViewModelMUsername != null) {
                        // read loginViewModel.MUsername.get()
                        loginViewModelMUsernameGet = loginViewModelMUsername.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x380L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etUsername, loginViewModelMUsernameGet);
        }
        if ((dirtyFlags & 0x200L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etUsername, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etUsernameandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etVerifyCode, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etVerifyCodeandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0x340L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etVerifyCode, loginViewModelMPasswordGet);
        }
        if ((dirtyFlags & 0x302L) != 0) {
            // api target 1

            com.shijingfeng.base.databinding.view_adapter.EditTextViewAdapter.setCleartext(this.etVerifyCode, loginViewModelMIsCleartextPasswordGet);
        }
        if ((dirtyFlags & 0x300L) != 0) {
            // api target 1

            this.includeTitleBar.setIvBackClick(loginViewModelMBackClickListener);
            this.includeTitleBar.setTvOperateClick(loginViewModelMTextOperateClickListener);
            com.shijingfeng.base.databinding.view_adapter.ViewViewAdapter.onClick(this.ivClearPassword, loginViewModelMClearPasswordClickListener, (boolean)false, (int)0);
            com.shijingfeng.base.databinding.view_adapter.ViewViewAdapter.onClick(this.ivClearUsername, loginViewModelMClearUsernameClickListener, (boolean)false, (int)0);
            com.shijingfeng.base.databinding.view_adapter.ViewViewAdapter.onClick(this.ivPasswordVisibility, loginViewModelMPasswordVisibilityClickListener, (boolean)false, (int)0);
            com.shijingfeng.base.databinding.view_adapter.ViewViewAdapter.onClick(this.mboundView7, loginViewModelMRetrievePasswordClickListener, (boolean)false, (int)0);
            com.shijingfeng.base.databinding.view_adapter.ViewViewAdapter.onClick(this.tvLogin, loginViewModelMLoginClickListener, (boolean)false, (int)0);
        }
        if ((dirtyFlags & 0x301L) != 0) {
            // api target 1

            this.ivClearPassword.setVisibility(loginViewModelMPasswordClearVisibilityGet);
        }
        if ((dirtyFlags & 0x320L) != 0) {
            // api target 1

            this.ivClearUsername.setVisibility(loginViewModelMUsernameClearVisibilityGet);
        }
        if ((dirtyFlags & 0x310L) != 0) {
            // api target 1

            androidx.databinding.adapters.ImageViewBindingAdapter.setImageDrawable(this.ivPasswordVisibility, loginViewModelMPasswordSecrecyIconGet);
        }
        if ((dirtyFlags & 0x308L) != 0) {
            // api target 1

            this.tvLogin.setEnabled(loginViewModelMIsLoginEnableGet);
        }
        executeBindingsOn(includeTitleBar);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): loginViewModel.MPasswordClearVisibility
        flag 1 (0x2L): loginViewModel.MIsCleartextPassword
        flag 2 (0x3L): includeTitleBar
        flag 3 (0x4L): loginViewModel.MIsLoginEnable
        flag 4 (0x5L): loginViewModel.MPasswordSecrecyIcon
        flag 5 (0x6L): loginViewModel.MUsernameClearVisibility
        flag 6 (0x7L): loginViewModel.MPassword
        flag 7 (0x8L): loginViewModel.MUsername
        flag 8 (0x9L): loginViewModel
        flag 9 (0xaL): null
    flag mapping end*/
    //end
}