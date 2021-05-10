package com.example.finema.database.room;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\'\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\fH\u0016R \u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/example/finema/database/room/RoomRepository;", "Lcom/example/finema/database/DatabaseRepository;", "roomDao", "Lcom/example/finema/database/room/RoomDao;", "(Lcom/example/finema/database/room/RoomDao;)V", "allGenres", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/finema/models/databaseModels/GenreModel;", "getAllGenres", "()Landroidx/lifecycle/LiveData;", "insert", "", "genre", "onSuccess", "Lkotlin/Function0;", "(Lcom/example/finema/models/databaseModels/GenreModel;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signOut", "app_debug"})
public final class RoomRepository implements com.example.finema.database.DatabaseRepository {
    private final com.example.finema.database.room.RoomDao roomDao = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<java.util.List<com.example.finema.models.databaseModels.GenreModel>> getAllGenres() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.example.finema.models.databaseModels.GenreModel genre, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p2) {
        return null;
    }
    
    @java.lang.Override()
    public void signOut() {
    }
    
    public RoomRepository(@org.jetbrains.annotations.NotNull()
    com.example.finema.database.room.RoomDao roomDao) {
        super();
    }
    
    public void connectToDatabase(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onFail) {
    }
}