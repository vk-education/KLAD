package com.example.finema.ui.higherlower;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/finema/ui/higherlower/MovieAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/finema/ui/higherlower/MovieAdapter$MovieViewHolder;", "movies", "Lcom/example/finema/models/movieResponse/MovieResponse;", "listener", "Lcom/example/finema/ui/higherlower/MovieAdapter$MovieViewHolder$Listener;", "(Lcom/example/finema/models/movieResponse/MovieResponse;Lcom/example/finema/ui/higherlower/MovieAdapter$MovieViewHolder$Listener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "MovieViewHolder", "app_debug"})
public final class MovieAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.finema.ui.higherlower.MovieAdapter.MovieViewHolder> {
    private final com.example.finema.models.movieResponse.MovieResponse movies = null;
    private final com.example.finema.ui.higherlower.MovieAdapter.MovieViewHolder.Listener listener = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342";
    @org.jetbrains.annotations.NotNull()
    public static final com.example.finema.ui.higherlower.MovieAdapter.Companion Companion = null;
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.finema.ui.higherlower.MovieAdapter.MovieViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.finema.ui.higherlower.MovieAdapter.MovieViewHolder holder, int position) {
    }
    
    public MovieAdapter(@org.jetbrains.annotations.NotNull()
    com.example.finema.models.movieResponse.MovieResponse movies, @org.jetbrains.annotations.NotNull()
    com.example.finema.ui.higherlower.MovieAdapter.MovieViewHolder.Listener listener) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/example/finema/ui/higherlower/MovieAdapter$MovieViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "recyclerviewMovieBinding", "Lcom/example/finema/databinding/MovieItemBinding;", "listener", "Lcom/example/finema/ui/higherlower/MovieAdapter$MovieViewHolder$Listener;", "(Lcom/example/finema/databinding/MovieItemBinding;Lcom/example/finema/ui/higherlower/MovieAdapter$MovieViewHolder$Listener;)V", "bindMovie", "", "movies", "Lcom/example/finema/models/movieResponse/MovieResponse;", "Listener", "app_debug"})
    public static final class MovieViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.example.finema.databinding.MovieItemBinding recyclerviewMovieBinding = null;
        private final com.example.finema.ui.higherlower.MovieAdapter.MovieViewHolder.Listener listener = null;
        
        public final void bindMovie(@org.jetbrains.annotations.NotNull()
        com.example.finema.models.movieResponse.MovieResponse movies) {
        }
        
        public MovieViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.finema.databinding.MovieItemBinding recyclerviewMovieBinding, @org.jetbrains.annotations.NotNull()
        com.example.finema.ui.higherlower.MovieAdapter.MovieViewHolder.Listener listener) {
            super(null);
        }
        
        @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/finema/ui/higherlower/MovieAdapter$MovieViewHolder$Listener;", "", "onMovieClicked", "", "position", "", "app_debug"})
        public static abstract interface Listener {
            
            public abstract void onMovieClicked(int position);
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/finema/ui/higherlower/MovieAdapter$Companion;", "", "()V", "POSTER_BASE_URL", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}