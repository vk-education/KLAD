package com.example.finema.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J!\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lcom/example/finema/api/MoviesRepository;", "Lcom/example/finema/api/IMoviesRepository;", "Lcom/example/finema/repositories/SafeApiRequest;", "api", "Lcom/example/finema/api/MoviesApi;", "(Lcom/example/finema/api/MoviesApi;)V", "getGenres", "Lcom/example/finema/models/GenreRequest/GenreList;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMovieDetails", "Lcom/example/finema/models/movieResponse/MovieDetails;", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMovies", "Lcom/example/finema/models/movieResponse/MovieResponse;", "page", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMoviesWithGenre", "with_genres", "", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class MoviesRepository extends com.example.finema.repositories.SafeApiRequest implements com.example.finema.api.IMoviesRepository {
    private final com.example.finema.api.MoviesApi api = null;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getMovies(int page, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.finema.models.movieResponse.MovieResponse> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getGenres(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.finema.models.GenreRequest.GenreList> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getMoviesWithGenre(int page, @org.jetbrains.annotations.NotNull()
    java.lang.String with_genres, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.finema.models.movieResponse.MovieResponse> p2) {
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
    
    public MoviesRepository() {
        super();
    }
}