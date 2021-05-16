package com.example.finema.ui.tmp;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0016J\u001c\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/example/finema/ui/tmp/TmpViewModel;", "Lcom/example/finema/ui/base/BaseViewModel;", "()V", "apiTmp", "Lcom/example/finema/api/MoviesApi;", "genreListVM", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/finema/models/GenreRequest/GenreList;", "getGenreListVM", "()Landroidx/lifecycle/MutableLiveData;", "setGenreListVM", "(Landroidx/lifecycle/MutableLiveData;)V", "repository", "Lcom/example/finema/api/MoviesRepository;", "getGenres", "", "initDatabase", "context", "Landroid/content/Context;", "type", "", "onSuccess", "Lkotlin/Function0;", "insert", "Lkotlinx/coroutines/Job;", "genreModel", "Lcom/example/finema/models/databaseModels/GenreModel;", "app_debug"})
public final class TmpViewModel extends com.example.finema.ui.base.BaseViewModel {
    private final com.example.finema.api.MoviesApi apiTmp = null;
    private final com.example.finema.api.MoviesRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.example.finema.models.GenreRequest.GenreList> genreListVM;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.finema.models.GenreRequest.GenreList> getGenreListVM() {
        return null;
    }
    
    public final void setGenreListVM(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.example.finema.models.GenreRequest.GenreList> p0) {
    }
    
    public final void getGenres() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job insert(@org.jetbrains.annotations.NotNull()
    com.example.finema.models.databaseModels.GenreModel genreModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
        return null;
    }
    
    public final void initDatabase(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    public TmpViewModel() {
        super();
    }
}