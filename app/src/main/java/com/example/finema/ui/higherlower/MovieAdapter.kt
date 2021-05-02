package com.example.finema.ui.higherlower

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finema.databinding.MovieItemBinding
import com.example.finema.models.TMDBMovie

class MovieAdapter(
    private val movies: List<TMDBMovie?>,
    private val listener: MovieViewHolder.Listener

) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    class MovieViewHolder(
        private val binding: MovieItemBinding,
        private val listener : Listener) : RecyclerView.ViewHolder(binding.root){

        private val BASE_URL_POSTER = "https://image.tmdb.org/t/p/w342/"

        interface Listener{
            fun onMovieClicked(position: Int)
        }

        fun bindMovie(movie: TMDBMovie?){
            binding.movieTitle.text = movie?.title
            binding.movieReleaseDate.text = movie?.releaseDate
            if(movie?.posterPath != null) {
                Glide.with(itemView).load(BASE_URL_POSTER+movie.posterPath).into(binding.moviePoster)
            }

            itemView.setOnClickListener {
                listener.onMovieClicked(adapterPosition)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            MovieItemBinding.inflate(LayoutInflater
                .from(parent.context),
                parent,
                false),
            listener
        )
    }

    override fun getItemCount(): Int = 2

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        return holder.bindMovie(movies[position])
    }
}
