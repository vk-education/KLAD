package com.example.finema.ui.tmp;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0018\u001a\u00020\u0019J\u001c\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u000b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001dJ\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\u0019H\u0014R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/example/finema/ui/tmp/TmpViewModel;", "Lcom/example/finema/ui/base/BaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_genreList", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/finema/models/GenreRequest/GenreList;", "allGenres", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/finema/models/databaseModels/GenreModel;", "getAllGenres", "()Landroidx/lifecycle/LiveData;", "genreList", "getGenreList", "()Landroidx/lifecycle/MutableLiveData;", "job", "Lkotlinx/coroutines/Job;", "mAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "mContext", "repository", "Lcom/example/finema/newapi/MoviesRepository;", "getGenres", "", "insert", "genreModel", "onSuccess", "Lkotlin/Function0;", "logIn", "activity", "Landroid/app/Activity;", "onCleared", "app_debug"})
public final class TmpViewModel extends com.example.finema.ui.base.BaseViewModel {
    private final com.google.firebase.auth.FirebaseAuth mAuth = null;
    private final android.app.Application mContext = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.finema.models.databaseModels.GenreModel>> allGenres = null;
    private kotlinx.coroutines.Job job;
    private com.example.finema.newapi.MoviesRepository repository;
    private final androidx.lifecycle.MutableLiveData<com.example.finema.models.GenreRequest.GenreList> _genreList = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.finema.models.databaseModels.GenreModel>> getAllGenres() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.finema.models.GenreRequest.GenreList> getGenreList() {
        return null;
    }
    
    public final void logIn(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
    }
    
    public final void getGenres() {
    }
    
    @java.lang.Override()
    protected void onCleared() {
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