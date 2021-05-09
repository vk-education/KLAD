package com.example.finema.ui.tournaments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.finema.MainActivity
import com.example.finema.R
import com.example.finema.models.databaseModels.GenreModel
import com.example.finema.utlis.APP_ACTIVITY

class TournamentAdapter:RecyclerView.Adapter<TournamentAdapter.TournamentHolder>() {

    private var mListGenres = emptyList<GenreModel>()

    class TournamentHolder(view: View): RecyclerView.ViewHolder(view) {
        val genreName: TextView = view.findViewById(R.id.item_genre_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TournamentHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.genre_item,parent,false)
        return TournamentHolder(view)
    }

    override fun onBindViewHolder(holder: TournamentHolder, position: Int) {
        holder.genreName.text = mListGenres[position].name
    }

    override fun getItemCount(): Int = mListGenres.size


    fun setList(list: List<GenreModel>) {
        mListGenres = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: TournamentHolder) {
        holder.itemView.setOnClickListener {
            TournamentGenresFragment.click(mListGenres[holder.adapterPosition])
        }
    }

}