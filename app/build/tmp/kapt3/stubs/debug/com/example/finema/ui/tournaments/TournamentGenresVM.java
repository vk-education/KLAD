package com.example.finema.ui.tournaments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u0019H\u0014J\u0006\u0010\u001d\u001a\u00020\u0019R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00070\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/example/finema/ui/tournaments/TournamentGenresVM;", "Lcom/example/finema/ui/base/BaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "allGenres", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/finema/models/databaseModels/GenreModel;", "getAllGenres", "()Landroidx/lifecycle/LiveData;", "apiTG", "Lcom/example/finema/api/MoviesApi;", "filmListVM", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/finema/models/movieResponse/Movie;", "getFilmListVM", "()Landroidx/lifecycle/MutableLiveData;", "setFilmListVM", "(Landroidx/lifecycle/MutableLiveData;)V", "job", "Lkotlinx/coroutines/Job;", "repository", "Lcom/example/finema/api/MoviesRepository;", "getMovies", "", "genre", "", "onCleared", "signOut", "app_debug"})
public final class TournamentGenresVM extends com.example.finema.ui.base.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.finema.models.databaseModels.GenreModel>> allGenres = null;
    private kotlinx.coroutines.Job job;
    private final com.example.finema.api.MoviesApi apiTG = null;
    private final com.example.finema.api.MoviesRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.List<com.example.finema.models.movieResponse.Movie>> filmListVM;
    
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