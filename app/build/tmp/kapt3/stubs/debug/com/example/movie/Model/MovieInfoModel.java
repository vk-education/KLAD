package com.example.movie.Model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bE\b\u0086\b\u0018\u00002\u00020\u0001B\u00e5\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0001\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\n\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\n\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\b\u0012\u0006\u0010\u001b\u001a\u00020\b\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\n\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\u0006\u0010\u001f\u001a\u00020\u0005\u0012\u0006\u0010 \u001a\u00020\u0005\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u0013\u0012\u0006\u0010#\u001a\u00020\b\u00a2\u0006\u0002\u0010$J\t\u0010D\u001a\u00020\u0003H\u00c6\u0003J\t\u0010E\u001a\u00020\u0005H\u00c6\u0003J\t\u0010F\u001a\u00020\u0005H\u00c6\u0003J\t\u0010G\u001a\u00020\u0013H\u00c6\u0003J\t\u0010H\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00160\nH\u00c6\u0003J\u000f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00180\nH\u00c6\u0003J\t\u0010K\u001a\u00020\u0005H\u00c6\u0003J\t\u0010L\u001a\u00020\bH\u00c6\u0003J\t\u0010M\u001a\u00020\bH\u00c6\u0003J\u000f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u001d0\nH\u00c6\u0003J\t\u0010O\u001a\u00020\u0005H\u00c6\u0003J\t\u0010P\u001a\u00020\u0005H\u00c6\u0003J\t\u0010Q\u001a\u00020\u0005H\u00c6\u0003J\t\u0010R\u001a\u00020\u0005H\u00c6\u0003J\t\u0010S\u001a\u00020\u0003H\u00c6\u0003J\t\u0010T\u001a\u00020\u0013H\u00c6\u0003J\t\u0010U\u001a\u00020\bH\u00c6\u0003J\t\u0010V\u001a\u00020\u0001H\u00c6\u0003J\t\u0010W\u001a\u00020\bH\u00c6\u0003J\u000f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u00c6\u0003J\t\u0010Y\u001a\u00020\u0005H\u00c6\u0003J\t\u0010Z\u001a\u00020\bH\u00c6\u0003J\t\u0010[\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\\\u001a\u00020\u0005H\u00c6\u0003J\u009b\u0002\u0010]\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00052\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\n2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\n2\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\b2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\n2\b\b\u0002\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00132\b\b\u0002\u0010#\u001a\u00020\bH\u00c6\u0001J\u0013\u0010^\u001a\u00020\u00032\b\u0010_\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010`\u001a\u00020\bH\u00d6\u0001J\t\u0010a\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R\u0011\u0010\u0006\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010(R\u0011\u0010\r\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010,R\u0011\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010(R\u0011\u0010\u000f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010(R\u0011\u0010\u0010\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010(R\u0011\u0010\u0011\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010(R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u0010\u0014\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010(R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\n\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010.R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\n\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010.R\u0011\u0010\u0019\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010(R\u0011\u0010\u001a\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010,R\u0011\u0010\u001b\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010,R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010.R\u0011\u0010\u001e\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010(R\u0011\u0010\u001f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010(R\u0011\u0010 \u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010(R\u0011\u0010!\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010&R\u0011\u0010\"\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u00106R\u0011\u0010#\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010,\u00a8\u0006b"}, d2 = {"Lcom/example/movie/Model/MovieInfoModel;", "", "adult", "", "backdrop_path", "", "belongs_to_collection", "budget", "", "genres", "", "Lcom/example/movie/Model/Genre;", "homepage", "id", "imdb_id", "original_language", "original_title", "overview", "popularity", "", "poster_path", "production_companies", "Lcom/example/movie/Model/ProductionCompany;", "production_countries", "Lcom/example/movie/Model/ProductionCountry;", "release_date", "revenue", "runtime", "spoken_languages", "Lcom/example/movie/Model/SpokenLanguage;", "status", "tagline", "title", "video", "vote_average", "vote_count", "(ZLjava/lang/String;Ljava/lang/Object;ILjava/util/List;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;IILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZDI)V", "getAdult", "()Z", "getBackdrop_path", "()Ljava/lang/String;", "getBelongs_to_collection", "()Ljava/lang/Object;", "getBudget", "()I", "getGenres", "()Ljava/util/List;", "getHomepage", "getId", "getImdb_id", "getOriginal_language", "getOriginal_title", "getOverview", "getPopularity", "()D", "getPoster_path", "getProduction_companies", "getProduction_countries", "getRelease_date", "getRevenue", "getRuntime", "getSpoken_languages", "getStatus", "getTagline", "getTitle", "getVideo", "getVote_average", "getVote_count", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class MovieInfoModel {
    private final boolean adult = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String backdrop_path = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object belongs_to_collection = null;
    private final int budget = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.movie.Model.Genre> genres = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String homepage = null;
    private final int id = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String imdb_id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String original_language = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String original_title = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String overview = null;
    private final double popularity = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String poster_path = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.movie.Model.ProductionCompany> production_companies = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.movie.Model.ProductionCountry> production_countries = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String release_date = null;
    private final int revenue = 0;
    private final int runtime = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.movie.Model.SpokenLanguage> spoken_languages = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String status = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String tagline = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    private final boolean video = false;
    private final double vote_average = 0.0;
    private final int vote_count = 0;
    
    public final boolean getAdult() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBackdrop_path() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getBelongs_to_collection() {
        return null;
    }
    
    public final int getBudget() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.movie.Model.Genre> getGenres() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHomepage() {
        return null;
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getImdb_id() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOriginal_language() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOriginal_title() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOverview() {
        return null;
    }
    
    public final double getPopularity() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPoster_path() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.movie.Model.ProductionCompany> getProduction_companies() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.movie.Model.ProductionCountry> getProduction_countries() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRelease_date() {
        return null;
    }
    
    public final int getRevenue() {
        return 0;
    }
    
    public final int getRuntime() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.movie.Model.SpokenLanguage> getSpoken_languages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTagline() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    public final boolean getVideo() {
        return false;
    }
    
    public final double getVote_average() {
        return 0.0;
    }
    
    public final int getVote_count() {
        return 0;
    }
    
    public MovieInfoModel(boolean adult, @org.jetbrains.annotations.NotNull()
    java.lang.String backdrop_path, @org.jetbrains.annotations.NotNull()
    java.lang.Object belongs_to_collection, int budget, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.movie.Model.Genre> genres, @org.jetbrains.annotations.NotNull()
    java.lang.String homepage, int id, @org.jetbrains.annotations.NotNull()
    java.lang.String imdb_id, @org.jetbrains.annotations.NotNull()
    java.lang.String original_language, @org.jetbrains.annotations.NotNull()
    java.lang.String original_title, @org.jetbrains.annotations.NotNull()
    java.lang.String overview, double popularity, @org.jetbrains.annotations.NotNull()
    java.lang.String poster_path, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.movie.Model.ProductionCompany> production_companies, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.movie.Model.ProductionCountry> production_countries, @org.jetbrains.annotations.NotNull()
    java.lang.String release_date, int revenue, int runtime, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.movie.Model.SpokenLanguage> spoken_languages, @org.jetbrains.annotations.NotNull()
    java.lang.String status, @org.jetbrains.annotations.NotNull()
    java.lang.String tagline, @org.jetbrains.annotations.NotNull()
    java.lang.String title, boolean video, double vote_average, int vote_count) {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component3() {
        return null;
    }
    
    public final int component4() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.movie.Model.Genre> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    public final int component7() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    public final double component12() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.movie.Model.ProductionCompany> component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.movie.Model.ProductionCountry> component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component16() {
        return null;
    }
    
    public final int component17() {
        return 0;
    }
    
    public final int component18() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.movie.Model.SpokenLanguage> component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component20() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component21() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component22() {
        return null;
    }
    
    public final boolean component23() {
        return false;
    }
    
    public final double component24() {
        return 0.0;
    }
    
    public final int component25() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.movie.Model.MovieInfoModel copy(boolean adult, @org.jetbrains.annotations.NotNull()
    java.lang.String backdrop_path, @org.jetbrains.annotations.NotNull()
    java.lang.Object belongs_to_collection, int budget, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.movie.Model.Genre> genres, @org.jetbrains.annotations.NotNull()
    java.lang.String homepage, int id, @org.jetbrains.annotations.NotNull()
    java.lang.String imdb_id, @org.jetbrains.annotations.NotNull()
    java.lang.String original_language, @org.jetbrains.annotations.NotNull()
    java.lang.String original_title, @org.jetbrains.annotations.NotNull()
    java.lang.String overview, double popularity, @org.jetbrains.annotations.NotNull()
    java.lang.String poster_path, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.movie.Model.ProductionCompany> production_companies, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.movie.Model.ProductionCountry> production_countries, @org.jetbrains.annotations.NotNull()
    java.lang.String release_date, int revenue, int runtime, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.movie.Model.SpokenLanguage> spoken_languages, @org.jetbrains.annotations.NotNull()
    java.lang.String status, @org.jetbrains.annotations.NotNull()
    java.lang.String tagline, @org.jetbrains.annotations.NotNull()
    java.lang.String title, boolean video, double vote_average, int vote_count) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}