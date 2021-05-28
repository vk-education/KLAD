package com.example.finema.util
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.finema.R


fun ImageView.downloadAndSetImageUrl(url:String){
    Glide
        .with(this)
        .load(url)
        .centerCrop()
        .override(500, 500)
        .placeholder(R.drawable.movies_24)
        .into(this);
}

fun ImageView.downloadAndSetImageUri(uri: Uri){
    Glide
        .with(this)
        .load(uri)
        .centerCrop()
        .override(500, 500)
        .placeholder(R.drawable.movies_24)
        .into(this);
}
