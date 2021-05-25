package com.example.finema.ui.favourite

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finema.R
import com.example.finema.models.databaseModels.MovieModel


class FavouriteAdapter(
    private val navigateToMovie: (Long) -> Unit
) :
    RecyclerView.Adapter<FavouriteAdapter.MovieViewHolder>() {

    private var movies: List<MovieModel> = emptyList()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.favourite_movie_item, viewGroup, false)

        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(viewholder: MovieViewHolder, position: Int) {
        Log.d("gypsy", position.toString())
        viewholder.bind(movies[position], navigateToMovie)
    }

    override fun getItemCount() = movies.size

    fun update(movies: List<MovieModel>){
        this.movies = movies
    }

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //        val imageMovie: ImageView = view.findViewById(R.id.imageMovie) as ImageView
        var filmTitle: TextView? = null
        var rating: TextView? = null
        var genre: TextView? = null

        init {
            filmTitle = view.findViewById(R.id.filmTitle)
            rating = view.findViewById(R.id.rating)
            genre = view.findViewById(R.id.genre)
        }

        fun bind(movie: MovieModel, navigateToMovie: (Long) -> Unit) = itemView.apply {
            filmTitle?.text = movie.title
            rating?.text = movie.rating
            genre?.text = movie.genres

            setOnClickListener { navigateToMovie(movie.id) }
        }
    }
}