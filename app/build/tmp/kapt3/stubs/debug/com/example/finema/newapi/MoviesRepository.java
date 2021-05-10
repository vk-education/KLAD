package com.example.finema.newapi;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/example/finema/newapi/MoviesRepository;", "Lcom/example/finema/repositories/SafeApiRequest;", "api", "Lcom/example/finema/api/MoviesApi;", "(Lcom/example/finema/api/MoviesApi;)V", "getGenres", "Lcom/example/finema/models/GenreRequest/GenreList;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMovieDetails", "Lcom/example/finema/models/movieResponse/MovieDetails;", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMovies", "Lcom/example/finema/models/movieResponse/MovieResponse;", "page", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class MoviesRepository extends com.example.finema.repositories.SafeApiRequest {
    private final com.example.finema.api.MoviesApi api = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getMovies(int page, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.finema.models.movieResponse.MovieResponse> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getGenres(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.finema.models.GenreRequest.GenreList> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getMovieDetails(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.finema.models.movieResponse.MovieDetails> p1) {
        return null;
    }
    
    public MoviesRepository(@org.jetbrains.annotations.NotNull()
    com.example.finema.api.MoviesApi api) {
        super();
    }
}