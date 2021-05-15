package com.example.finema.ui.higherlower;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u000f\u001a\u00020\u0013H\u0002J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/example/finema/ui/higherlower/HigherLowerViewModel;", "Lcom/example/finema/ui/base/BaseViewModel;", "repository", "Lcom/example/finema/api/MoviesRepository;", "(Lcom/example/finema/api/MoviesRepository;)V", "_movies", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/finema/models/movieResponse/MovieResponse;", "add", "", "getAdd", "()I", "setAdd", "(I)V", "movies", "getMovies", "()Landroidx/lifecycle/MutableLiveData;", "opp", "changeMovRes", "", "clickedRight", "clickedWrong", "onMovieClicked", "position", "app_debug"})
public final class HigherLowerViewModel extends com.example.finema.ui.base.BaseViewModel {
    private final androidx.lifecycle.MutableLiveData<com.example.finema.models.movieResponse.MovieResponse> _movies = null;
    private com.example.finema.models.movieResponse.MovieResponse opp;
    private int add = 0;
    private final com.example.finema.api.MoviesRepository repository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.finema.models.movieResponse.MovieResponse> getMovies() {
        return null;
    }
    
    public final int getAdd() {
        return 0;
    }
    
    public final void setAdd(int p0) {
    }
    
    private final void getMovies() {
    }
    
    private final void clickedRight() {
    }
    
    private final void clickedWrong() {
    }
    
    private final void changeMovRes() {
    }
    
    public final void onMovieClicked(int position) {
    }
    
    public HigherLowerViewModel(@org.jetbrains.annotations.NotNull()
    com.example.finema.api.MoviesRepository repository) {
        super();
    }
}