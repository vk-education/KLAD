package com.example.finema.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/example/finema/util/AppPreference;", "", "()V", "INIT_GENRES", "", "INIT_USER", "NAME_PREF", "mPreferences", "Landroid/content/SharedPreferences;", "getGeneratedGenres", "", "getInitUser", "getPreference", "context", "Landroid/content/Context;", "setGeneratedGenres", "", "init", "setInitUser", "app_debug"})
public final class AppPreference {
    private static final java.lang.String INIT_USER = "initUser";
    private static final java.lang.String INIT_GENRES = "initGenres";
    private static final java.lang.String NAME_PREF = "preference";
    private static android.content.SharedPreferences mPreferences;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.finema.util.AppPreference INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences getPreference(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    public final void setInitUser(boolean init) {
    }
    
    public final boolean getInitUser() {
        return false;
    }
    
    public final boolean getGeneratedGenres() {
        return false;
    }
    
    public final void setGeneratedGenres(boolean init) {
    }
    
    private AppPreference() {
        super();
    }
}