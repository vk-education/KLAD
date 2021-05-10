package com.example.finema.database;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J*\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\rH\u0016J\'\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\tH\u0016R\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/example/finema/database/DatabaseRepository;", "", "allGenres", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/finema/models/databaseModels/GenreModel;", "getAllGenres", "()Landroidx/lifecycle/LiveData;", "connectToDatabase", "", "onSuccess", "Lkotlin/Function0;", "onFail", "Lkotlin/Function1;", "", "insert", "genre", "(Lcom/example/finema/models/databaseModels/GenreModel;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signOut", "app_debug"})
public abstract interface DatabaseRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.finema.models.databaseModels.GenreModel>> getAllGenres();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.example.finema.models.databaseModels.GenreModel genre, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p2);
    
    public abstract void connectToDatabase(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onFail);
    
    public abstract void signOut();
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        public static void connectToDatabase(@org.jetbrains.annotations.NotNull()
        com.example.finema.database.DatabaseRepository $this, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onFail) {
        }
        
        public static void signOut(@org.jetbrains.annotations.NotNull()
        com.example.finema.database.DatabaseRepository $this) {
        }
    }
}