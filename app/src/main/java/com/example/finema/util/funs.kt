package com.example.finema.util
import android.content.Context
import android.net.Uri
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.finema.R

private const val PICTURE_MEASURES = 500
private const val FLAG_ZERO = 0

fun ImageView.downloadAndSetImageUrl(url: String?) {
    Glide
        .with(this)
        .load(url)
        .centerInside()
        .override(PICTURE_MEASURES, PICTURE_MEASURES)
        .placeholder(R.drawable.movies_24)
        .into(this)
}

fun ImageView.downloadAndSetImageUri(uri: Uri?) {
    Glide
        .with(this)
        .load(uri)
        .centerInside()
        .placeholder(R.drawable.movies_24)
        .into(this)
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, FLAG_ZERO)
}
