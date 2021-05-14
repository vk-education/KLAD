package com.example.finema.ui.tournaments

import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finema.R
import com.example.finema.models.databaseModels.GenreModel

class TournamentAdapter(
    private val listener: TournamentHolder.Listener

) : RecyclerView.Adapter<TournamentAdapter.TournamentHolder>() {

    private var mListGenres = emptyList<GenreModel>()
//    private lateinit var dialog: Dialog

    class TournamentHolder(
        view: View,
        private val listener: Listener
    ) : RecyclerView.ViewHolder(view) {
        val genreName: TextView = view.findViewById(R.id.item_genre_name)
//
        interface Listener {
            fun onMovieClicked(view: View, genreModel: GenreModel)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TournamentHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.genre_item, parent, false)
        return TournamentHolder(view, listener)
    }

    override fun onBindViewHolder(holder: TournamentHolder, position: Int) {
        holder.genreName.text = mListGenres[position].name
    }

    override fun getItemCount(): Int = mListGenres.size


    fun setList(list: List<GenreModel>) {
        mListGenres = list
        notifyDataSetChanged()
    }

    //TODO перенести в холдер
    override fun onViewAttachedToWindow(holder: TournamentHolder) {
        holder.itemView.setOnClickListener {
            listener.onMovieClicked(holder.itemView,mListGenres[holder.adapterPosition])
        }
    }

}