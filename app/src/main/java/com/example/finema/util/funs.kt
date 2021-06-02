package com.example.finema.util
import android.content.Context
import android.net.Uri
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.finema.R


fun ImageView.downloadAndSetImageUrl(url: String?) {
    Glide
        .with(this)
        .load(url)
        .centerCrop()
        .override(500, 500)
        .placeholder(R.drawable.movies_24)
        .into(this);
}

fun ImageView.downloadAndSetImageUri(uri: Uri?) {
    Glide
        .with(this)
        .load(uri)
        .centerCrop()
        .override(500, 500)
        .placeholder(R.drawable.movies_24)
        .into(this);
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}
