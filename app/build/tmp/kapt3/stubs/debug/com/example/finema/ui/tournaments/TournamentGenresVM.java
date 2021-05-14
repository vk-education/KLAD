package com.example.finema.ui.tournaments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0013R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR&\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00070\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/finema/ui/tournaments/TournamentGenresVM;", "Lcom/example/finema/ui/base/BaseViewModel;", "repository", "Lcom/example/finema/api/MoviesRepository;", "(Lcom/example/finema/api/MoviesRepository;)V", "allGenres", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/finema/models/databaseModels/GenreModel;", "getAllGenres", "()Landroidx/lifecycle/LiveData;", "filmListVM", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/finema/models/movieResponse/Movie;", "getFilmListVM", "()Landroidx/lifecycle/MutableLiveData;", "setFilmListVM", "(Landroidx/lifecycle/MutableLiveData;)V", "getMovies", "", "genre", "", "signOut", "app_debug"})
public final class TournamentGenresVM extends com.example.finema.ui.base.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.finema.models.databaseModels.GenreModel>> allGenres = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.List<com.example.finema.models.movieResponse.Movie>> filmListVM;
    private final com.example.finema.api.MoviesRepository repository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.finema.models.databaseModels.GenreModel>> getAllGenres() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.example.finema.models.movieResponse.Movie>> getFilmListVM() {
        return null;
    }
    
    public final void setFilmListVM(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.util.List<com.example.finema.models.movieResponse.Movie>> p0) {
    }
    
    public final void getMovies(@org.jetbrains.annotations.NotNull()
    java.lang.String genre) {
    }
    
    public final void signOut() {
    }
    
    public TournamentGenresVM(@org.jetbrains.annotations.NotNull()
    com.example.finema.api.MoviesRepository repository) {
        super();
    }
}