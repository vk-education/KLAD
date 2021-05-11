package com.example.finema.ui.movieDetail;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0011H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/finema/ui/movieDetail/MovieDetailsViewModel;", "Lcom/example/finema/ui/base/BaseViewModel;", "()V", "api", "Lcom/example/finema/api/MoviesApi;", "film", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/finema/models/movieResponse/MovieDetails;", "getFilm", "()Landroidx/lifecycle/MutableLiveData;", "setFilm", "(Landroidx/lifecycle/MutableLiveData;)V", "job", "Lkotlinx/coroutines/Job;", "repository", "Lcom/example/finema/api/DimaVersion/MoviesRepository;", "getMovieDetails", "", "id", "", "onCleared", "app_debug"})
public final class MovieDetailsViewModel extends com.example.finema.ui.base.BaseViewModel {
    private final com.example.finema.api.MoviesApi api = null;
    private final com.example.finema.api.DimaVersion.MoviesRepository repository = null;
    private kotlinx.coroutines.Job job;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.example.finema.models.movieResponse.MovieDetails> film;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.finema.models.movieResponse.MovieDetails> getFilm() {
        return null;
    }
    
    public final void setFilm(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.example.finema.models.movieResponse.MovieDetails> p0) {
    }
    
    public final void getMovieDetails(long id) {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    public MovieDetailsViewModel() {
        super(null);
    }
}