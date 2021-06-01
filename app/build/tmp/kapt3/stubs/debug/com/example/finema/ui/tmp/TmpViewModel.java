package com.example.finema.ui.tmp;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/example/finema/ui/tmp/TmpViewModel;", "Lcom/example/finema/ui/base/BaseViewModel;", "DBRepository", "Lcom/example/finema/database/room/RoomRepository;", "fbRepository", "Lcom/example/finema/database/firebase/FirebaseRepository;", "(Lcom/example/finema/database/room/RoomRepository;Lcom/example/finema/database/firebase/FirebaseRepository;)V", "allMovies", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/finema/models/databaseModels/MovieModel;", "initRoomFromFirebaseToRoom", "", "app_debug"})
public final class TmpViewModel extends com.example.finema.ui.base.BaseViewModel {
    private final androidx.lifecycle.LiveData<java.util.List<com.example.finema.models.databaseModels.MovieModel>> allMovies = null;
    private final com.example.finema.database.room.RoomRepository DBRepository = null;
    private final com.example.finema.database.firebase.FirebaseRepository fbRepository = null;
    
    public final void initRoomFromFirebaseToRoom() {
    }
    
    public TmpViewModel(@org.jetbrains.annotations.NotNull()
    com.example.finema.database.room.RoomRepository DBRepository, @org.jetbrains.annotations.NotNull()
    com.example.finema.database.firebase.FirebaseRepository fbRepository) {
        super();
    }
}