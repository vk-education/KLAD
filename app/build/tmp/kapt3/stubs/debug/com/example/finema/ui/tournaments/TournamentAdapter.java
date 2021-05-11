package com.example.finema.ui.tournaments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0014\u0010\u0014\u001a\u00020\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/finema/ui/tournaments/TournamentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/finema/ui/tournaments/TournamentAdapter$TournamentHolder;", "listener", "Lcom/example/finema/ui/tournaments/TournamentAdapter$TournamentHolder$Listener;", "(Lcom/example/finema/ui/tournaments/TournamentAdapter$TournamentHolder$Listener;)V", "mListGenres", "", "Lcom/example/finema/models/databaseModels/GenreModel;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "setList", "list", "TournamentHolder", "app_debug"})
public final class TournamentAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.finema.ui.tournaments.TournamentAdapter.TournamentHolder> {
    private java.util.List<com.example.finema.models.databaseModels.GenreModel> mListGenres;
    private final com.example.finema.ui.tournaments.TournamentAdapter.TournamentHolder.Listener listener = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.finema.ui.tournaments.TournamentAdapter.TournamentHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.finema.ui.tournaments.TournamentAdapter.TournamentHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.finema.models.databaseModels.GenreModel> list) {
    }
    
    @java.lang.Override()
    public void onViewAttachedToWindow(@org.jetbrains.annotations.NotNull()
    com.example.finema.ui.tournaments.TournamentAdapter.TournamentHolder holder) {
    }
    
    public TournamentAdapter(@org.jetbrains.annotations.NotNull()
    com.example.finema.ui.tournaments.TournamentAdapter.TournamentHolder.Listener listener) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u000bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/example/finema/ui/tournaments/TournamentAdapter$TournamentHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "listener", "Lcom/example/finema/ui/tournaments/TournamentAdapter$TournamentHolder$Listener;", "(Landroid/view/View;Lcom/example/finema/ui/tournaments/TournamentAdapter$TournamentHolder$Listener;)V", "genreName", "Landroid/widget/TextView;", "getGenreName", "()Landroid/widget/TextView;", "Listener", "app_debug"})
    public static final class TournamentHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView genreName = null;
        private final com.example.finema.ui.tournaments.TournamentAdapter.TournamentHolder.Listener listener = null;
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getGenreName() {
            return null;
        }
        
        public TournamentHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view, @org.jetbrains.annotations.NotNull()
        com.example.finema.ui.tournaments.TournamentAdapter.TournamentHolder.Listener listener) {
            super(null);
        }
        
        @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/example/finema/ui/tournaments/TournamentAdapter$TournamentHolder$Listener;", "", "onMovieClicked", "", "view", "Landroid/view/View;", "genreModel", "Lcom/example/finema/models/databaseModels/GenreModel;", "app_debug"})
        public static abstract interface Listener {
            
            public abstract void onMovieClicked(@org.jetbrains.annotations.NotNull()
            android.view.View view, @org.jetbrains.annotations.NotNull()
            com.example.finema.models.databaseModels.GenreModel genreModel);
        }
    }
}