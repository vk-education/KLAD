package com.example.finema.ui.tmp;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0010\u001a\u00020\u0011J\u001c\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/example/finema/ui/tmp/TmpViewModel;", "Lcom/example/finema/ui/base/BaseViewModel;", "stat", "Landroidx/lifecycle/SavedStateHandle;", "apiRepository", "Lcom/example/finema/api/MoviesRepository;", "BDRepository", "Lcom/example/finema/database/room/RoomRepository;", "(Landroidx/lifecycle/SavedStateHandle;Lcom/example/finema/api/MoviesRepository;Lcom/example/finema/database/room/RoomRepository;)V", "genreListVM", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/finema/models/GenreRequest/GenreList;", "getGenreListVM", "()Landroidx/lifecycle/MutableLiveData;", "setGenreListVM", "(Landroidx/lifecycle/MutableLiveData;)V", "getGenres", "", "insert", "Lkotlinx/coroutines/Job;", "genreModel", "Lcom/example/finema/models/databaseModels/GenreModel;", "onSuccess", "Lkotlin/Function0;", "app_debug"})
public final class TmpViewModel extends com.example.finema.ui.base.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.example.finema.models.GenreRequest.GenreList> genreListVM;
    private final androidx.lifecycle.SavedStateHandle stat = null;
    private final com.example.finema.api.MoviesRepository apiRepository = null;
    private final com.example.finema.database.room.RoomRepository BDRepository = null;
    
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
    
    public TmpViewModel(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.SavedStateHandle stat, @org.jetbrains.annotations.NotNull()
    com.example.finema.api.MoviesRepository apiRepository, @org.jetbrains.annotations.NotNull()
    com.example.finema.database.room.RoomRepository BDRepository) {
        super();
    }
}