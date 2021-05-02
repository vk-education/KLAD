package com.example.finema.ui.higherlower;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u001d\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/finema/ui/higherlower/MovieAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/finema/ui/higherlower/MovieAdapter$MovieViewHolder;", "movies", "", "Lcom/example/finema/models/TMDBMovie;", "listener", "Lcom/example/finema/ui/higherlower/MovieAdapter$MovieViewHolder$Listener;", "(Ljava/util/List;Lcom/example/finema/ui/higherlower/MovieAdapter$MovieViewHolder$Listener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "MovieViewHolder", "app_debug"})
public final class MovieAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.finema.ui.higherlower.MovieAdapter.MovieViewHolder> {
    private final java.util.List<com.example.finema.models.TMDBMovie> movies = null;
    private final com.example.finema.ui.higherlower.MovieAdapter.MovieViewHolder.Listener listener = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.finema.ui.higherlower.MovieAdapter.MovieViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.finema.ui.higherlower.MovieAdapter.MovieViewHolder holder, int position) {
    }
    
    public MovieAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.finema.models.TMDBMovie> movies, @org.jetbrains.annotations.NotNull()
    com.example.finema.ui.higherlower.MovieAdapter.MovieViewHolder.Listener listener) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/example/finema/ui/higherlower/MovieAdapter$MovieViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/finema/databinding/MovieItemBinding;", "listener", "Lcom/example/finema/ui/higherlower/MovieAdapter$MovieViewHolder$Listener;", "(Lcom/example/finema/databinding/MovieItemBinding;Lcom/example/finema/ui/higherlower/MovieAdapter$MovieViewHolder$Listener;)V", "BASE_URL_POSTER", "", "bindMovie", "", "movie", "Lcom/example/finema/models/TMDBMovie;", "Listener", "app_debug"})
    public static final class MovieViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final java.lang.String BASE_URL_POSTER = "https://image.tmdb.org/t/p/w342/";
        private final com.example.finema.databinding.MovieItemBinding binding = null;
        private final com.example.finema.ui.higherlower.MovieAdapter.MovieViewHolder.Listener listener = null;
        
        public final void bindMovie(@org.jetbrains.annotations.Nullable()
        com.example.finema.models.TMDBMovie movie) {
        }
        
        public MovieViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.finema.databinding.MovieItemBinding binding, @org.jetbrains.annotations.NotNull()
        com.example.finema.ui.higherlower.MovieAdapter.MovieViewHolder.Listener listener) {
            super(null);
        }
        
        @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/finema/ui/higherlower/MovieAdapter$MovieViewHolder$Listener;", "", "onMovieClicked", "", "position", "", "app_debug"})
        public static abstract interface Listener {
            
            public abstract void onMovieClicked(int position);
        }
    }
}