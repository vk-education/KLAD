package com.example.finema.ui.higherlower

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finema.models.movieResponse.MovieResponse
import com.example.finema.R
import com.example.finema.databinding.MovieItemBinding

class MovieAdapter (
    private val movies: MovieResponse,
    private val listener: MovieViewHolder.Listener
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    companion object{
        const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"
    }

    override fun getItemCount() = movies.movies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MovieViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.movie_item,
                parent,
                false
            ),
            listener
        )

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        return holder.bindMovie(movies)
    }


class MovieViewHolder(
        private val recyclerviewMovieBinding: MovieItemBinding,
        private val listener: Listener
    ) : RecyclerView.ViewHolder(recyclerviewMovieBinding.root){

        interface Listener{
            fun onMovieClicked(position: Int)
        }

        fun bindMovie(movies: MovieResponse){
            recyclerviewMovieBinding.textViewTitle.text = movies.movies[position].title

            Glide.with(itemView).
            load(POSTER_BASE_URL + movies.movies[position].posterPath).
            into(recyclerviewMovieBinding.imageView)

            recyclerviewMovieBinding.
            textViewVotesCount.text = movies.movies[position].popularity.toString()
            recyclerviewMovieBinding.
            textViewLikePercent.text = movies.movies[position].voteAverage.toString()

            recyclerviewMovieBinding.cardView.setOnClickListener {
                listener.onMovieClicked(adapterPosition)
            }
        }
    }
}