package com.example.finema.repositories;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/example/finema/repositories/Singleton;", "", "()V", "allFilms", "Ljava/util/ArrayList;", "Lcom/example/finema/models/movieResponse/Movie;", "getAllFilms", "()Ljava/util/ArrayList;", "setAllFilms", "(Ljava/util/ArrayList;)V", "signInAsGuest", "", "getSignInAsGuest", "()Z", "setSignInAsGuest", "(Z)V", "app_debug"})
public final class Singleton {
    private static boolean signInAsGuest = false;
    @org.jetbrains.annotations.NotNull()
    private static java.util.ArrayList<com.example.finema.models.movieResponse.Movie> allFilms;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.finema.repositories.Singleton INSTANCE = null;
    
    public final boolean getSignInAsGuest() {
        return false;
    }
    
    public final void setSignInAsGuest(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.finema.models.movieResponse.Movie> getAllFilms() {
        return null;
    }
    
    public final void setAllFilms(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.finema.models.movieResponse.Movie> p0) {
    }
    
    private Singleton() {
        super();
    }
}