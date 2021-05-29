package com.example.finema.util

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.finema.database.room.RoomRepository
import com.google.firebase.auth.FirebaseAuth

//TODO Сделать репозиторием с интерфейсом
object AppPreference {

    private const val INIT_USER = "initUser"
    private const val INIT_GENRES = "initGenres"
    private const val NAME_PREF = "preference"
    private const val NUM_FILMS = "numFilms"
    private const val TOURNAMENT_TYPE = "tournamentType"
    private const val GENRE_ID = "genre_id"
    private const val GENRE_NAME = "genre_name"
    private const val CATEGORY_LINK = "category_link"
    private const val CATEGORY_NAME = "category_name"
    private const val MOVIE_ONE = "movieOne"

    private val googleUser: FirebaseAuth = FirebaseAuth.getInstance()
    private lateinit var mPreferences: SharedPreferences

    //TODO такого не должно быть, преференсы должны исполььзоваться только здесь
    fun getPreference(context: Context) {
        mPreferences = context.getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE)
    }

    fun setInitUser(init: Boolean) {
        mPreferences.edit()
            .putBoolean(INIT_USER, init)
            .apply()
    }

    fun getInitUser(): Boolean {
        return mPreferences.getBoolean(INIT_USER, false)
    }


    fun googleUserSignOut() {
        googleUser.signOut()
        Log.d("OJOF", googleUser.currentUser?.displayName.orEmpty())
    }

    fun getNumOfFilms(): Int {
        return mPreferences.getInt(NUM_FILMS, 8)
    }

    fun setNumOfFilms(num: Int) {
        mPreferences.edit()
            .putInt(NUM_FILMS, num)
            .apply()
    }

    fun getTournamentType(): String? {
        return mPreferences.getString(TOURNAMENT_TYPE, "")
    }

    fun setTournamentType(type: String) {
        mPreferences.edit()
            .putString(TOURNAMENT_TYPE, type)
            .apply()
    }

    fun getGenreId(): String? {
        return mPreferences.getString(GENRE_ID, "")
    }

    fun setGenre(genre: String) {
        mPreferences.edit()
            .putString(GENRE_ID, genre)
            .apply()
    }

    fun getGenreName(): String? {
        return mPreferences.getString(GENRE_NAME, "")
    }

    fun setGenreName(genre: String) {
        mPreferences.edit()
            .putString(GENRE_NAME, genre)
            .apply()
    }

    fun getCategoryLink(): Int? {
        return mPreferences.getInt(CATEGORY_LINK, -1)
    }

    fun setCategoryLink(categoryLink: Int) {
        mPreferences.edit()
            .putInt(CATEGORY_LINK, categoryLink)
            .apply()
    }

    fun getCategoryName(): String? {
        return mPreferences.getString(CATEGORY_NAME, "")
    }

    fun setCategoryName(categoryName: String) {
        mPreferences.edit()
            .putString(CATEGORY_NAME, categoryName)
            .apply()
    }


    fun setMovieAddedToFav(movie :String) {
            mPreferences.edit()
                .putString(MOVIE_ONE, movie)
                .apply()
    }

    fun getMovieAddedToFav(): String? {
        return mPreferences.getString(MOVIE_ONE, "")
    }

}