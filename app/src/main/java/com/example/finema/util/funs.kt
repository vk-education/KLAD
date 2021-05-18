package com.example.finema.util
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.finema.R

fun ImageView.downloadAndSetImage(url:String){
    Glide
        .with(this)
        .load(url)
        .centerCrop()
        .override(500, 500)
        .placeholder(R.drawable.movies_24)
        .into(this);
}