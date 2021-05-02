package com.example.finema.models.OverviewMode;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0005H\u00c6\u0003J\t\u0010#\u001a\u00020\u0007H\u00c6\u0003J\t\u0010$\u001a\u00020\tH\u00c6\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u00c6\u0003J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\'\u001a\u00020\u000eH\u00c6\u0003J\t\u0010(\u001a\u00020\u0010H\u00c6\u0003J_\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u00c6\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010-\u001a\u00020.H\u00d6\u0001J\t\u0010/\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \u00a8\u00060"}, d2 = {"Lcom/example/finema/models/OverviewMode/OverviewModel;", "", "id", "", "title", "Lcom/cronocode/moviecatalog/models/OverviewMode/Title;", "certificates", "Lcom/cronocode/moviecatalog/models/OverviewMode/Certificates;", "ratings", "Lcom/cronocode/moviecatalog/models/OverviewMode/Ratings;", "genres", "", "releaseDate", "plotOutline", "Lcom/cronocode/moviecatalog/models/OverviewMode/PlotOutline;", "plotSummary", "Lcom/cronocode/moviecatalog/models/OverviewMode/PlotSummary;", "(Ljava/lang/String;Lcom/cronocode/moviecatalog/models/OverviewMode/Title;Lcom/cronocode/moviecatalog/models/OverviewMode/Certificates;Lcom/cronocode/moviecatalog/models/OverviewMode/Ratings;Ljava/util/List;Ljava/lang/String;Lcom/cronocode/moviecatalog/models/OverviewMode/PlotOutline;Lcom/cronocode/moviecatalog/models/OverviewMode/PlotSummary;)V", "getCertificates", "()Lcom/cronocode/moviecatalog/models/OverviewMode/Certificates;", "getGenres", "()Ljava/util/List;", "getId", "()Ljava/lang/String;", "getPlotOutline", "()Lcom/cronocode/moviecatalog/models/OverviewMode/PlotOutline;", "getPlotSummary", "()Lcom/cronocode/moviecatalog/models/OverviewMode/PlotSummary;", "getRatings", "()Lcom/cronocode/moviecatalog/models/OverviewMode/Ratings;", "getReleaseDate", "getTitle", "()Lcom/cronocode/moviecatalog/models/OverviewMode/Title;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class OverviewModel {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "id")
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "title")
    private final com.cronocode.moviecatalog.models.OverviewMode.Title title = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "certificates")
    private final com.cronocode.moviecatalog.models.OverviewMode.Certificates certificates = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "ratings")
    private final com.cronocode.moviecatalog.models.OverviewMode.Ratings ratings = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "genres")
    private final java.util.List<java.lang.String> genres = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "releaseDate")
    private final java.lang.String releaseDate = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "plotOutline")
    private final com.cronocode.moviecatalog.models.OverviewMode.PlotOutline plotOutline = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "plotSummary")
    private final com.cronocode.moviecatalog.models.OverviewMode.PlotSummary plotSummary = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.cronocode.moviecatalog.models.OverviewMode.Title getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.cronocode.moviecatalog.models.OverviewMode.Certificates getCertificates() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.cronocode.moviecatalog.models.OverviewMode.Ratings getRatings() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getGenres() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getReleaseDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.cronocode.moviecatalog.models.OverviewMode.PlotOutline getPlotOutline() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.cronocode.moviecatalog.models.OverviewMode.PlotSummary getPlotSummary() {
        return null;
    }
    
    public OverviewModel(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    com.cronocode.moviecatalog.models.OverviewMode.Title title, @org.jetbrains.annotations.NotNull()
    com.cronocode.moviecatalog.models.OverviewMode.Certificates certificates, @org.jetbrains.annotations.NotNull()
    com.cronocode.moviecatalog.models.OverviewMode.Ratings ratings, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> genres, @org.jetbrains.annotations.NotNull()
    java.lang.String releaseDate, @org.jetbrains.annotations.NotNull()
    com.cronocode.moviecatalog.models.OverviewMode.PlotOutline plotOutline, @org.jetbrains.annotations.NotNull()
    com.cronocode.moviecatalog.models.OverviewMode.PlotSummary plotSummary) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.cronocode.moviecatalog.models.OverviewMode.Title component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.cronocode.moviecatalog.models.OverviewMode.Certificates component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.cronocode.moviecatalog.models.OverviewMode.Ratings component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.cronocode.moviecatalog.models.OverviewMode.PlotOutline component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.cronocode.moviecatalog.models.OverviewMode.PlotSummary component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.finema.models.OverviewMode.OverviewModel copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    com.cronocode.moviecatalog.models.OverviewMode.Title title, @org.jetbrains.annotations.NotNull()
    com.cronocode.moviecatalog.models.OverviewMode.Certificates certificates, @org.jetbrains.annotations.NotNull()
    com.cronocode.moviecatalog.models.OverviewMode.Ratings ratings, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> genres, @org.jetbrains.annotations.NotNull()
    java.lang.String releaseDate, @org.jetbrains.annotations.NotNull()
    com.cronocode.moviecatalog.models.OverviewMode.PlotOutline plotOutline, @org.jetbrains.annotations.NotNull()
    com.cronocode.moviecatalog.models.OverviewMode.PlotSummary plotSummary) {
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