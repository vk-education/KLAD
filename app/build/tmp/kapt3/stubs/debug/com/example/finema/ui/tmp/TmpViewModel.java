package com.example.finema.ui.tmp;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0012\u001a\u00020\u0013J\u001c\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u0018J\b\u0010\u0019\u001a\u00020\u0013H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/finema/ui/tmp/TmpViewModel;", "Lcom/example/finema/ui/base/BaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "apiTmp", "Lcom/example/finema/api/MoviesApi;", "genreListVM", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/finema/models/GenreRequest/GenreList;", "getGenreListVM", "()Landroidx/lifecycle/MutableLiveData;", "setGenreListVM", "(Landroidx/lifecycle/MutableLiveData;)V", "job", "Lkotlinx/coroutines/Job;", "repository", "Lcom/example/finema/api/MoviesRepository;", "getGenres", "", "insert", "genreModel", "Lcom/example/finema/models/databaseModels/GenreModel;", "onSuccess", "Lkotlin/Function0;", "onCleared", "app_debug"})
public final class TmpViewModel extends com.example.finema.ui.base.BaseViewModel {
    private kotlinx.coroutines.Job job;
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