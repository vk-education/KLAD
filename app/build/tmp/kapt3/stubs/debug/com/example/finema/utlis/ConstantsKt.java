package com.example.finema.utlis;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\u00020\u0003X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u001a\u0010\f\u001a\u00020\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"API_KEY", "", "APP_ACTIVITY", "Lcom/example/finema/MainActivity;", "getAPP_ACTIVITY", "()Lcom/example/finema/MainActivity;", "setAPP_ACTIVITY", "(Lcom/example/finema/MainActivity;)V", "BASE_URL", "GENRE", "GENRE_LIST", "POSTER_BASE_URL", "REPOSITORY", "Lcom/example/finema/database/DatabaseRepository;", "getREPOSITORY", "()Lcom/example/finema/database/DatabaseRepository;", "setREPOSITORY", "(Lcom/example/finema/database/DatabaseRepository;)V", "TYPE_FIREBASE", "TYPE_ROOM", "app_debug"})
public final class ConstantsKt {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TYPE_ROOM = "type_room";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TYPE_FIREBASE = "type_firebase";
    public static com.example.finema.database.DatabaseRepository REPOSITORY;
    public static com.example.finema.MainActivity APP_ACTIVITY;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String API_KEY = "bbf5a3000e95f1dddf266b5e187d4b21";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_URL = "https://api.themoviedb.org";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GENRE_LIST = "/3/genre/movie/list?api_key=bbf5a3000e95f1dddf266b5e187d4b21&language=ru-Ru";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GENRE = "/3/movie/top_rated?api_key=bbf5a3000e95f1dddf266b5e187d4b21&language=ru-Ru";
    
    @org.jetbrains.annotations.NotNull()
    public static final com.example.finema.database.DatabaseRepository getREPOSITORY() {
        return null;
    }
    
    public static final void setREPOSITORY(@org.jetbrains.annotations.NotNull()
    com.example.finema.database.DatabaseRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.example.finema.MainActivity getAPP_ACTIVITY() {
        return null;
    }
    
    public static final void setAPP_ACTIVITY(@org.jetbrains.annotations.NotNull()
    com.example.finema.MainActivity p0) {
    }
}