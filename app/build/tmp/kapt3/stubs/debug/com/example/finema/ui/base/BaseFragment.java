package com.example.finema.ui.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0004R\u001c\u0010\u0007\u001a\u00028\u0001X\u0084.\u00a2\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00028\u0000X\u0094.\u00a2\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001c"}, d2 = {"Lcom/example/finema/ui/base/BaseFragment;", "VModel", "Lcom/example/finema/ui/base/BaseViewModel;", "Binding", "Landroidx/viewbinding/ViewBinding;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "setBinding", "(Landroidx/viewbinding/ViewBinding;)V", "Landroidx/viewbinding/ViewBinding;", "viewModel", "getViewModel", "()Lcom/example/finema/ui/base/BaseViewModel;", "setViewModel", "(Lcom/example/finema/ui/base/BaseViewModel;)V", "Lcom/example/finema/ui/base/BaseViewModel;", "getViewModelClass", "Ljava/lang/Class;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "showError", "app_debug"})
public abstract class BaseFragment<VModel extends com.example.finema.ui.base.BaseViewModel, Binding extends androidx.viewbinding.ViewBinding> extends androidx.fragment.app.Fragment {
    protected VModel viewModel;
    protected Binding binding;
    
    @org.jetbrains.annotations.NotNull()
    protected VModel getViewModel() {
        return null;
    }
    
    protected void setViewModel(@org.jetbrains.annotations.NotNull()
    VModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final Binding getBinding() {
        return null;
    }
    
    protected final void setBinding(@org.jetbrains.annotations.NotNull()
    Binding p0) {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    protected final void showError() {
    }
    
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    private final java.lang.Class<VModel> getViewModelClass() {
        return null;
    }
    
    public BaseFragment() {
        super();
    }
}