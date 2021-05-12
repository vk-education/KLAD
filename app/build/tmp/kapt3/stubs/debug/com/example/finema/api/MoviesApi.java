package com.example.finema.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J+\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J+\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0013\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/example/finema/api/MoviesApi;", "", "getGenreList", "Lretrofit2/Response;", "Lcom/example/finema/models/GenreRequest/GenreList;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMovieDetails", "Lcom/example/finema/models/movieResponse/MovieDetails;", "id", "", "language", "", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMovies", "Lcom/example/finema/models/movieResponse/MovieResponse;", "page", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMoviesWithGenre", "with_genres", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public abstract interface MoviesApi {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.finema.api.MoviesApi.Companion Companion = null;
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "movie/popular?api_key=bbf5a3000e95f1dddf266b5e187d4b21")
    public abstract java.lang.Object getMovies(@retrofit2.http.Query(value = "page")
    int page, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.finema.models.movieResponse.MovieResponse>> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/3/genre/movie/list?api_key=bbf5a3000e95f1dddf266b5e187d4b21&language=ru-Ru")
    public abstract java.lang.Object getGenreList(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.finema.models.GenreRequest.GenreList>> p0);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "movie/{movie_id}?api_key=bbf5a3000e95f1dddf266b5e187d4b21")
    public abstract java.lang.Object getMovieDetails(@retrofit2.http.Path(value = "movie_id")
    long id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "language")
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.finema.models.movieResponse.MovieDetails>> p2);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "movie/popular?api_key=bbf5a3000e95f1dddf266b5e187d4b21")
    public abstract java.lang.Object getMoviesWithGenre(@retrofit2.http.Query(value = "page")
    int page, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "with_genres")
    java.lang.String with_genres, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.finema.models.movieResponse.MovieResponse>> p2);
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u0086\u0002\u00a8\u0006\u0005"}, d2 = {"Lcom/example/finema/api/MoviesApi$Companion;", "", "()V", "invoke", "Lcom/example/finema/api/MoviesApi;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.finema.api.MoviesApi invoke() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}