package com.example.finema.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u0006H\'\u00a8\u0006\u000b"}, d2 = {"Lcom/example/finema/api/RetrofitInterface;", "", "getMovie", "Lretrofit2/Call;", "Lcom/example/finema/models/OverviewMode/OverviewModel;", "id", "", "getMovieTMDB", "Lcom/example/finema/models/TMDBMovie;", "", "key", "app_debug"})
public abstract interface RetrofitInterface {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "title/get-overview-details?currentCountry=US")
    public abstract retrofit2.Call<com.example.finema.models.OverviewMode.OverviewModel> getMovie(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "tconst")
    java.lang.String id);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "movie/{movie_id}?")
    public abstract retrofit2.Call<com.example.finema.models.TMDBMovie> getMovieTMDB(@retrofit2.http.Path(value = "movie_id")
    int id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "api_key")
    java.lang.String key);
}