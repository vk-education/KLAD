package com.example.finema.ui.tmp;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/finema/ui/tmp/TmpViewModel;", "Lcom/example/finema/ui/base/BaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "allGenres", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/finema/models/databaseModels/GenreModel;", "getAllGenres", "()Landroidx/lifecycle/LiveData;", "mAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "mContext", "insert", "Lkotlinx/coroutines/Job;", "genreModel", "onSuccess", "Lkotlin/Function0;", "", "logIn", "activity", "Landroid/app/Activity;", "app_debug"})
public final class TmpViewModel extends com.example.finema.ui.base.BaseViewModel {
    private final com.google.firebase.auth.FirebaseAuth mAuth = null;
    private final android.app.Application mContext = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.finema.models.databaseModels.GenreModel>> allGenres = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.finema.models.databaseModels.GenreModel>> getAllGenres() {
        return null;
    }
    
    public final void logIn(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job insert(@org.jetbrains.annotations.NotNull()
    com.example.finema.models.databaseModels.GenreModel genreModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
        return null;
    }
    
    public TmpViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
}