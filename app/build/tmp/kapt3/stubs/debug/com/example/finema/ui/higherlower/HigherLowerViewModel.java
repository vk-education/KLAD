package com.example.finema.ui.higherlower;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u0012\u001a\u00020\u0019H\u0002J\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r\u00a8\u0006\u001f"}, d2 = {"Lcom/example/finema/ui/higherlower/HigherLowerViewModel;", "Lcom/example/finema/ui/base/BaseViewModel;", "repository", "Lcom/example/finema/api/MoviesRepository;", "(Lcom/example/finema/api/MoviesRepository;)V", "_movies", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/finema/models/movieResponse/MovieResponse;", "img1", "", "getImg1", "()I", "setImg1", "(I)V", "img2", "getImg2", "setImg2", "movies", "getMovies", "()Landroidx/lifecycle/MutableLiveData;", "page", "score", "getScore", "setScore", "changeMovRes", "", "clickedRight", "clickedWrong", "onMovieClicked", "position", "Companion", "app_debug"})
public final class HigherLowerViewModel extends com.example.finema.ui.base.BaseViewModel {
    private final androidx.lifecycle.MutableLiveData<com.example.finema.models.movieResponse.MovieResponse> _movies = null;
    private int score = 0;
    private int img1 = 0;
    private int img2 = 1;
    private int page = 1;
    private final com.example.finema.api.MoviesRepository repository = null;
    public static final int DEFAULT_PAGE_INDEX = 1;
    public static final int RESET_SCORE_INDEX = 0;
    public static final int ADD_SCORE_POINT = 1;
    public static final int NEXT_PAGE = 1;
    public static final int MOVIE_SIZE_RESET = 19;
    public static final int IMG1_INDEX = 0;
    public static final int IMG2_INDEX = 1;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.finema.ui.higherlower.HigherLowerViewModel.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.finema.models.movieResponse.MovieResponse> getMovies() {
        return null;
    }
    
    public final int getScore() {
        return 0;
    }
    
    public final void setScore(int p0) {
    }
    
    public final int getImg1() {
        return 0;
    }
    
    public final void setImg1(int p0) {
    }
    
    public final int getImg2() {
        return 0;
    }
    
    public final void setImg2(int p0) {
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
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/finema/ui/higherlower/HigherLowerViewModel$Companion;", "", "()V", "ADD_SCORE_POINT", "", "DEFAULT_PAGE_INDEX", "IMG1_INDEX", "IMG2_INDEX", "MOVIE_SIZE_RESET", "NEXT_PAGE", "RESET_SCORE_INDEX", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}