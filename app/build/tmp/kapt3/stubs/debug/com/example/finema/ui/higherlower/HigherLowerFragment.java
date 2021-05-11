package com.example.finema.ui.higherlower;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0007H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/example/finema/ui/higherlower/HigherLowerFragment;", "Lcom/example/finema/ui/base/BaseFragment;", "Lcom/example/finema/ui/higherlower/HigherLowerViewModel;", "Lcom/example/finema/databinding/HigherLowerFragmentBinding;", "Lcom/example/finema/ui/higherlower/MovieAdapter$MovieViewHolder$Listener;", "()V", "add", "", "getAdd", "()I", "setAdd", "(I)V", "add2", "getAdd2", "setAdd2", "api", "Lcom/example/finema/api/MoviesApi;", "factory", "Lcom/example/finema/ui/higherlower/MoviesViewModelFactory;", "layout", "Lcom/example/finema/ui/higherlower/CustomGridLayoutManager;", "repository", "Lcom/example/finema/api/MoviesRepository;", "viewModel", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onMovieClicked", "position", "app_debug"})
public final class HigherLowerFragment extends com.example.finema.ui.base.BaseFragment<com.example.finema.ui.higherlower.HigherLowerViewModel, com.example.finema.databinding.HigherLowerFragmentBinding> implements com.example.finema.ui.higherlower.MovieAdapter.MovieViewHolder.Listener {
    private int add = 0;
    private int add2 = 1;
    private com.example.finema.ui.higherlower.MoviesViewModelFactory factory;
    private com.example.finema.ui.higherlower.CustomGridLayoutManager layout;
    private final com.example.finema.api.MoviesApi api = null;
    private final com.example.finema.api.MoviesRepository repository = null;
    private final com.example.finema.ui.higherlower.HigherLowerViewModel viewModel = null;
    
    public final int getAdd() {
        return 0;
    }
    
    public final void setAdd(int p0) {
    }
    
    public final int getAdd2() {
        return 0;
    }
    
    public final void setAdd2(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onActivityCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onMovieClicked(int position) {
    }
    
    public HigherLowerFragment() {
        super();
    }
}