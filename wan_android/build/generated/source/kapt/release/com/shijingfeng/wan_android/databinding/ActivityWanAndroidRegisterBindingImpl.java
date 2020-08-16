package com.shijingfeng.wan_android.databinding;
import com.shijingfeng.wan_android.R;
import com.shijingfeng.wan_android.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityWanAndroidRegisterBindingImpl extends ActivityWanAndroidRegisterBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(9);
        sIncludes.setIncludes(0, 
            new String[] {"layout_wan_android_title_bar"},
            new int[] {8},
            new int[] {com.shijingfeng.wan_android.R.layout.layout_wan_android_title_bar});
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener etPasswordandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of registerViewModel.MPassword.get()
            //         is registerViewModel.MPassword.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(etPassword);
            // localize variables for thread safety
            // registerViewModel != null
            boolean registerViewModelJavaLangObjectNull = false;
            // registerViewModel
            com.shijingfeng.wan_android.view_model.RegisterViewModel registerViewModel = mRegisterViewModel;
            // registerViewModel.MPassword.get()
            java.lang.String registerViewModelMPasswordGet = null;
            // registerViewModel.MPassword
            androidx.databinding.ObservableField<java.lang.String> registerViewModelMPassword = null;
            // registerViewModel.MPassword != null
            boolean registerViewModelMPasswordJavaLangObjectNull = false;



            registerViewModelJavaLangObjectNull = (registerViewModel) != (null);
            if (registerViewModelJavaLangObjectNull) {


                registerViewModelMPassword = registerViewModel.getMPassword();

                registerViewModelMPasswordJavaLangObjectNull = (registerViewModelMPassword) != (null);
                if (registerViewModelMPasswordJavaLangObjectNull) {




                    registerViewModelMPassword.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener etPasswordConfirmandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of registerViewModel.MConfirmPassword.get()
            //         is registerViewModel.MConfirmPassword.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(etPasswordConfirm);
            // localize variables for thread safety
            // registerViewModel.MConfirmPassword != null
            boolean registerViewModelMConfirmPasswordJavaLangObjectNull = false;
            // registerViewModel.MConfirmPassword.get()
            java.lang.String registerViewModelMConfirmPasswordGet = null;
            // registerViewModel != null
            boolean registerViewModelJavaLangObjectNull = false;
            // registerViewModel.MConfirmPassword
            androidx.databinding.ObservableField<java.lang.String> registerViewModelMConfirmPassword = null;
            // registerViewModel
            com.shijingfeng.wan_android.view_model.RegisterViewModel registerViewModel = mRegisterViewModel;



            registerViewModelJavaLangObjectNull = (registerViewModel) != (null);
            if (registerViewModelJavaLangObjectNull) {


                registerViewModelMConfirmPassword = registerViewModel.getMConfirmPassword();

                registerViewModelMConfirmPasswordJavaLangObjectNull = (registerViewModelMConfirmPassword) != (null);
                if (registerViewModelMConfirmPasswordJavaLangObjectNull) {




                    registerViewModelMConfirmPassword.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener etUsernameandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of registerViewModel.MUsername.get()
            //         is registerViewModel.MUsername.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(etUsername);
            // localize variables for thread safety
            // registerViewModel != null
            boolean registerViewModelJavaLangObjectNull = false;
            // registerViewModel.MUsername.get()
            java.lang.String registerViewModelMUsernameGet = null;
            // registerViewModel.MUsername != null
            boolean registerViewModelMUsernameJavaLangObjectNull = false;
            // registerViewModel
            com.shijingfeng.wan_android.view_model.RegisterViewModel registerViewModel = mRegisterViewModel;
            // registerViewModel.MUsername
            androidx.databinding.ObservableField<java.lang.String> registerViewModelMUsername = null;



            registerViewModelJavaLangObjectNull = (registerViewModel) != (null);
            if (registerViewModelJavaLangObjectNull) {


                registerViewModelMUsername = registerViewModel.getMUsername();

                registerViewModelMUsernameJavaLangObjectNull = (registerViewModelMUsername) != (null);
                if (registerViewModelMUsernameJavaLangObjectNull) {




                    registerViewModelMUsername.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ActivityWanAndroidRegisterBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private ActivityWanAndroidRegisterBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 5
            , (android.widget.EditText) bindings[3]
            , (android.widget.EditText) bindings[5]
            , (android.widget.EditText) bindings[1]
            , (com.shijingfeng.wan_android.databinding.LayoutWanAndroidTitleBarBinding) bindings[8]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.TextView) bindings[7]
            );
        this.etPassword.setTag(null);
        this.etPasswordConfirm.setTag(null);
        this.etUsername.setTag(null);
        this.ivClearConfirmPassword.setTag(null);
        this.ivClearPassword.setTag(null);
        this.ivClearUsername.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvRegister.setTag(this.tvRegister.getResources().getString(com.shijingfeng.wan_android.R.string.登录注册页面TAG));
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x40L;
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
        if (BR.registerViewModel == variableId) {
            setRegisterViewModel((com.shijingfeng.wan_android.view_model.RegisterViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setRegisterViewModel(@Nullable com.shijingfeng.wan_android.view_model.RegisterViewModel RegisterViewModel) {
        this.mRegisterViewModel = RegisterViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x20L;
        }
        notifyPropertyChanged(BR.registerViewModel);
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
                return onChangeRegisterViewModelMUsername((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeRegisterViewModelMIsRegisterEnable((androidx.databinding.ObservableBoolean) object, fieldId);
            case 2 :
                return onChangeIncludeTitleBar((com.shijingfeng.wan_android.databinding.LayoutWanAndroidTitleBarBinding) object, fieldId);
            case 3 :
                return onChangeRegisterViewModelMPassword((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 4 :
                return onChangeRegisterViewModelMConfirmPassword((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeRegisterViewModelMUsername(androidx.databinding.ObservableField<java.lang.String> RegisterViewModelMUsername, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeRegisterViewModelMIsRegisterEnable(androidx.databinding.ObservableBoolean RegisterViewModelMIsRegisterEnable, int fieldId) {
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
    private boolean onChangeRegisterViewModelMPassword(androidx.databinding.ObservableField<java.lang.String> RegisterViewModelMPassword, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeRegisterViewModelMConfirmPassword(androidx.databinding.ObservableField<java.lang.String> RegisterViewModelMConfirmPassword, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
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
        boolean textUtilsIsEmptyRegisterViewModelMUsername = false;
        int textUtilsIsEmptyRegisterViewModelMPasswordInt8Int0 = 0;
        int textUtilsIsEmptyRegisterViewModelMUsernameInt8Int0 = 0;
        androidx.databinding.ObservableField<java.lang.String> registerViewModelMUsername = null;
        android.view.View.OnClickListener registerViewModelMRegisterClickListener = null;
        androidx.databinding.ObservableBoolean registerViewModelMIsRegisterEnable = null;
        java.lang.String registerViewModelMUsernameGet = null;
        boolean textUtilsIsEmptyRegisterViewModelMConfirmPassword = false;
        com.shijingfeng.wan_android.view_model.RegisterViewModel registerViewModel = mRegisterViewModel;
        int textUtilsIsEmptyRegisterViewModelMConfirmPasswordInt8Int0 = 0;
        java.lang.String registerViewModelMConfirmPasswordGet = null;
        android.view.View.OnClickListener registerViewModelMClearUsernameClickListener = null;
        android.view.View.OnClickListener registerViewModelMClearPasswordClickListener = null;
        android.view.View.OnClickListener registerViewModelMBackClickListener = null;
        androidx.databinding.ObservableField<java.lang.String> registerViewModelMPassword = null;
        android.view.View.OnClickListener registerViewModelMClearConfirmPasswordClickListener = null;
        boolean registerViewModelMIsRegisterEnableGet = false;
        androidx.databinding.ObservableField<java.lang.String> registerViewModelMConfirmPassword = null;
        boolean textUtilsIsEmptyRegisterViewModelMPassword = false;
        java.lang.String registerViewModelMPasswordGet = null;

        if ((dirtyFlags & 0x7bL) != 0) {


            if ((dirtyFlags & 0x61L) != 0) {

                    if (registerViewModel != null) {
                        // read registerViewModel.MUsername
                        registerViewModelMUsername = registerViewModel.getMUsername();
                    }
                    updateRegistration(0, registerViewModelMUsername);


                    if (registerViewModelMUsername != null) {
                        // read registerViewModel.MUsername.get()
                        registerViewModelMUsernameGet = registerViewModelMUsername.get();
                    }


                    // read TextUtils.isEmpty(registerViewModel.MUsername.get())
                    textUtilsIsEmptyRegisterViewModelMUsername = android.text.TextUtils.isEmpty(registerViewModelMUsernameGet);
                if((dirtyFlags & 0x61L) != 0) {
                    if(textUtilsIsEmptyRegisterViewModelMUsername) {
                            dirtyFlags |= 0x400L;
                    }
                    else {
                            dirtyFlags |= 0x200L;
                    }
                }


                    // read TextUtils.isEmpty(registerViewModel.MUsername.get()) ? 8 : 0
                    textUtilsIsEmptyRegisterViewModelMUsernameInt8Int0 = ((textUtilsIsEmptyRegisterViewModelMUsername) ? (8) : (0));
            }
            if ((dirtyFlags & 0x60L) != 0) {

                    if (registerViewModel != null) {
                        // read registerViewModel.MRegisterClickListener
                        registerViewModelMRegisterClickListener = registerViewModel.getMRegisterClickListener();
                        // read registerViewModel.MClearUsernameClickListener
                        registerViewModelMClearUsernameClickListener = registerViewModel.getMClearUsernameClickListener();
                        // read registerViewModel.MClearPasswordClickListener
                        registerViewModelMClearPasswordClickListener = registerViewModel.getMClearPasswordClickListener();
                        // read registerViewModel.MBackClickListener
                        registerViewModelMBackClickListener = registerViewModel.getMBackClickListener();
                        // read registerViewModel.MClearConfirmPasswordClickListener
                        registerViewModelMClearConfirmPasswordClickListener = registerViewModel.getMClearConfirmPasswordClickListener();
                    }
            }
            if ((dirtyFlags & 0x62L) != 0) {

                    if (registerViewModel != null) {
                        // read registerViewModel.MIsRegisterEnable
                        registerViewModelMIsRegisterEnable = registerViewModel.getMIsRegisterEnable();
                    }
                    updateRegistration(1, registerViewModelMIsRegisterEnable);


                    if (registerViewModelMIsRegisterEnable != null) {
                        // read registerViewModel.MIsRegisterEnable.get()
                        registerViewModelMIsRegisterEnableGet = registerViewModelMIsRegisterEnable.get();
                    }
            }
            if ((dirtyFlags & 0x68L) != 0) {

                    if (registerViewModel != null) {
                        // read registerViewModel.MPassword
                        registerViewModelMPassword = registerViewModel.getMPassword();
                    }
                    updateRegistration(3, registerViewModelMPassword);


                    if (registerViewModelMPassword != null) {
                        // read registerViewModel.MPassword.get()
                        registerViewModelMPasswordGet = registerViewModelMPassword.get();
                    }


                    // read TextUtils.isEmpty(registerViewModel.MPassword.get())
                    textUtilsIsEmptyRegisterViewModelMPassword = android.text.TextUtils.isEmpty(registerViewModelMPasswordGet);
                if((dirtyFlags & 0x68L) != 0) {
                    if(textUtilsIsEmptyRegisterViewModelMPassword) {
                            dirtyFlags |= 0x100L;
                    }
                    else {
                            dirtyFlags |= 0x80L;
                    }
                }


                    // read TextUtils.isEmpty(registerViewModel.MPassword.get()) ? 8 : 0
                    textUtilsIsEmptyRegisterViewModelMPasswordInt8Int0 = ((textUtilsIsEmptyRegisterViewModelMPassword) ? (8) : (0));
            }
            if ((dirtyFlags & 0x70L) != 0) {

                    if (registerViewModel != null) {
                        // read registerViewModel.MConfirmPassword
                        registerViewModelMConfirmPassword = registerViewModel.getMConfirmPassword();
                    }
                    updateRegistration(4, registerViewModelMConfirmPassword);


                    if (registerViewModelMConfirmPassword != null) {
                        // read registerViewModel.MConfirmPassword.get()
                        registerViewModelMConfirmPasswordGet = registerViewModelMConfirmPassword.get();
                    }


                    // read TextUtils.isEmpty(registerViewModel.MConfirmPassword.get())
                    textUtilsIsEmptyRegisterViewModelMConfirmPassword = android.text.TextUtils.isEmpty(registerViewModelMConfirmPasswordGet);
                if((dirtyFlags & 0x70L) != 0) {
                    if(textUtilsIsEmptyRegisterViewModelMConfirmPassword) {
                            dirtyFlags |= 0x1000L;
                    }
                    else {
                            dirtyFlags |= 0x800L;
                    }
                }


                    // read TextUtils.isEmpty(registerViewModel.MConfirmPassword.get()) ? 8 : 0
                    textUtilsIsEmptyRegisterViewModelMConfirmPasswordInt8Int0 = ((textUtilsIsEmptyRegisterViewModelMConfirmPassword) ? (8) : (0));
            }
        }
        // batch finished
        if ((dirtyFlags & 0x68L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etPassword, registerViewModelMPasswordGet);
            this.ivClearPassword.setVisibility(textUtilsIsEmptyRegisterViewModelMPasswordInt8Int0);
        }
        if ((dirtyFlags & 0x40L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etPassword, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etPasswordandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etPasswordConfirm, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etPasswordConfirmandroidTextAttrChanged);
            com.shijingfeng.base.databinding.view_adapter.EditTextViewAdapter.filterEmoji(this.etUsername, true);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etUsername, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etUsernameandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0x70L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etPasswordConfirm, registerViewModelMConfirmPasswordGet);
            this.ivClearConfirmPassword.setVisibility(textUtilsIsEmptyRegisterViewModelMConfirmPasswordInt8Int0);
        }
        if ((dirtyFlags & 0x61L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etUsername, registerViewModelMUsernameGet);
            this.ivClearUsername.setVisibility(textUtilsIsEmptyRegisterViewModelMUsernameInt8Int0);
        }
        if ((dirtyFlags & 0x60L) != 0) {
            // api target 1

            this.includeTitleBar.setIvBackClick(registerViewModelMBackClickListener);
            com.shijingfeng.base.databinding.view_adapter.ViewViewAdapter.onClick(this.ivClearConfirmPassword, registerViewModelMClearConfirmPasswordClickListener, (boolean)false, (int)0);
            com.shijingfeng.base.databinding.view_adapter.ViewViewAdapter.onClick(this.ivClearPassword, registerViewModelMClearPasswordClickListener, (boolean)false, (int)0);
            com.shijingfeng.base.databinding.view_adapter.ViewViewAdapter.onClick(this.ivClearUsername, registerViewModelMClearUsernameClickListener, (boolean)false, (int)0);
            com.shijingfeng.base.databinding.view_adapter.ViewViewAdapter.onClick(this.tvRegister, registerViewModelMRegisterClickListener, (boolean)false, (int)0);
        }
        if ((dirtyFlags & 0x62L) != 0) {
            // api target 1

            this.tvRegister.setEnabled(registerViewModelMIsRegisterEnableGet);
        }
        executeBindingsOn(includeTitleBar);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): registerViewModel.MUsername
        flag 1 (0x2L): registerViewModel.MIsRegisterEnable
        flag 2 (0x3L): includeTitleBar
        flag 3 (0x4L): registerViewModel.MPassword
        flag 4 (0x5L): registerViewModel.MConfirmPassword
        flag 5 (0x6L): registerViewModel
        flag 6 (0x7L): null
        flag 7 (0x8L): TextUtils.isEmpty(registerViewModel.MPassword.get()) ? 8 : 0
        flag 8 (0x9L): TextUtils.isEmpty(registerViewModel.MPassword.get()) ? 8 : 0
        flag 9 (0xaL): TextUtils.isEmpty(registerViewModel.MUsername.get()) ? 8 : 0
        flag 10 (0xbL): TextUtils.isEmpty(registerViewModel.MUsername.get()) ? 8 : 0
        flag 11 (0xcL): TextUtils.isEmpty(registerViewModel.MConfirmPassword.get()) ? 8 : 0
        flag 12 (0xdL): TextUtils.isEmpty(registerViewModel.MConfirmPassword.get()) ? 8 : 0
    flag mapping end*/
    //end
}