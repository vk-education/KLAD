package com.example.finema.ui.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0084.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/example/finema/ui/base/BaseViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "errorMessage", "Landroidx/lifecycle/MutableLiveData;", "", "job", "Lkotlinx/coroutines/Job;", "getJob", "()Lkotlinx/coroutines/Job;", "setJob", "(Lkotlinx/coroutines/Job;)V", "publicErrorMessage", "Landroidx/lifecycle/LiveData;", "getPublicErrorMessage", "()Landroidx/lifecycle/LiveData;", "showError", "", "throwable", "", "app_debug"})
public class BaseViewModel extends androidx.lifecycle.ViewModel {
    protected kotlinx.coroutines.Job job;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> errorMessage = null;
    
    @org.jetbrains.annotations.NotNull()
    protected final kotlinx.coroutines.Job getJob() {
        return null;
    }
    
    protected final void setJob(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.Job p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getPublicErrorMessage() {
        return null;
    }
    
    public final void showError(@org.jetbrains.annotations.NotNull()
    java.lang.Throwable throwable) {
    }
    
    public BaseViewModel() {
        super();
    }
}