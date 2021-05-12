package com.example.finema.ui.tournaments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\nH\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\nH\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0002J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0018\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u000bH\u0016J\u001a\u0010%\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/example/finema/ui/tournaments/TournamentGenresFragment;", "Lcom/example/finema/ui/base/BaseFragment;", "Lcom/example/finema/ui/tournaments/TournamentGenresVM;", "Lcom/example/finema/databinding/FragmentTournamentGenresBinding;", "Lcom/example/finema/ui/tournaments/TournamentAdapter$TournamentHolder$Listener;", "()V", "mAdapter", "Lcom/example/finema/ui/tournaments/TournamentAdapter;", "mObserverList", "Landroidx/lifecycle/Observer;", "", "Lcom/example/finema/models/databaseModels/GenreModel;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mViewModel", "dialogBinding", "", "list1", "Lcom/example/finema/models/movieResponse/Movie;", "getFilms", "genreID", "", "goNext", "num", "", "initialization", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onMovieClicked", "view", "genreModel", "onViewCreated", "app_debug"})
public final class TournamentGenresFragment extends com.example.finema.ui.base.BaseFragment<com.example.finema.ui.tournaments.TournamentGenresVM, com.example.finema.databinding.FragmentTournamentGenresBinding> implements com.example.finema.ui.tournaments.TournamentAdapter.TournamentHolder.Listener {
    private final com.example.finema.ui.tournaments.TournamentGenresVM mViewModel = null;
    private androidx.recyclerview.widget.RecyclerView mRecyclerView;
    private com.example.finema.ui.tournaments.TournamentAdapter mAdapter;
    private androidx.lifecycle.Observer<java.util.List<com.example.finema.models.databaseModels.GenreModel>> mObserverList;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initialization() {
    }
    
    @java.lang.Override()
    public void onMovieClicked(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.NotNull()
    com.example.finema.models.databaseModels.GenreModel genreModel) {
    }
    
    private final void getFilms(java.lang.String genreID) {
    }
    
    private final void dialogBinding(java.util.List<com.example.finema.models.movieResponse.Movie> list1) {
    }
    
    private final void goNext(int num, java.util.List<com.example.finema.models.movieResponse.Movie> list1) {
    }
    
    public TournamentGenresFragment() {
        super();
    }
}