package com.example.finema.util
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.finema.R
import com.example.finema.ui.higherlower.MovieAdapter

fun ImageView.downloadAndSetImage(url:String){
    Glide
        .with(this)
        .load(url)
        .centerCrop()
        .placeholder(R.drawable.movies_24)
        .into(this);
}