package com.example.finema.ui.tournaments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0013\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0017H\u0014J\u0006\u0010\u001b\u001a\u00020\u0017R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/example/finema/ui/tournaments/TournamentGenresVM;", "Lcom/example/finema/ui/base/BaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_movies", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/finema/models/movieResponse/MovieResponse;", "allGenres", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/finema/models/databaseModels/GenreModel;", "getAllGenres", "()Landroidx/lifecycle/LiveData;", "apiTG", "Lcom/example/finema/api/MoviesApi;", "job", "Lkotlinx/coroutines/Job;", "movies", "getMovies", "()Landroidx/lifecycle/MutableLiveData;", "repository", "Lcom/example/finema/api/MoviesRepository;", "", "genre", "", "onCleared", "signOut", "app_debug"})
public final class TournamentGenresVM extends com.example.finema.ui.base.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.finema.models.databaseModels.GenreModel>> allGenres = null;
    private kotlinx.coroutines.Job job;
    private final com.example.finema.api.MoviesApi apiTG = null;
    private final com.example.finema.api.MoviesRepository repository = null;
    private final androidx.lifecycle.MutableLiveData<com.example.finema.models.movieResponse.MovieResponse> _movies = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.finema.models.databaseModels.GenreModel>> getAllGenres() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.finema.models.movieResponse.MovieResponse> getMovies() {
        return null;
    }
    
    public final void getMovies(@org.jetbrains.annotations.NotNull()
    java.lang.String genre) {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    public final void signOut() {
    }
    
    public TournamentGenresVM(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
}