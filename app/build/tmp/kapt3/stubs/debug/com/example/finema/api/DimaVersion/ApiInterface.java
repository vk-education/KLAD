package com.example.finema.api.DimaVersion;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\'\u00a8\u0006\t"}, d2 = {"Lcom/example/finema/api/DimaVersion/ApiInterface;", "", "getFilm", "Lretrofit2/Call;", "Lcom/example/finema/models/movieResponse/MovieResponse;", "with_genres", "", "getGenreList", "Lcom/example/finema/models/GenreRequest/GenreList;", "app_debug"})
public abstract interface ApiInterface {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/3/genre/movie/list?api_key=bbf5a3000e95f1dddf266b5e187d4b21&language=ru-Ru")
    public abstract retrofit2.Call<com.example.finema.models.GenreRequest.GenreList> getGenreList();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/3/movie/top_rated?api_key=bbf5a3000e95f1dddf266b5e187d4b21&language=ru-Ru")
    public abstract retrofit2.Call<com.example.finema.models.movieResponse.MovieResponse> getFilm(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "with_genres")
    java.lang.String with_genres);
}