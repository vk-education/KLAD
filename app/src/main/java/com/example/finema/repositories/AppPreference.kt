package com.example.finema.repositories

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.firebase.auth.FirebaseAuth

// TODO Сделать репозиторием с интерфейсом
class AppPreference(
    override val context: Context
) : IAppPreference {

    companion object {
        private const val INIT_USER = "initUser"
        private const val NAME_PREF = "preference"
        private const val NUM_FILMS = "numFilms"
        private const val TOURNAMENT_TYPE = "tournamentType"
        private const val GENRE_ID = "genre_id"
        private const val GENRE_NAME = "genre_name"
        private const val CATEGORY_LINK = "category_link"
        private const val CATEGORY_NAME = "category_name"
        private const val FRAGMENT = "fragment"
        private const val FIRST_SIGN_IN = "firstSignIn"
        private const val GUEST_OR_AUTH = "guestOrAuth"
        private const val DEFAULT_NULL_VAL = ""

        private const val DEFAULT_NUM_VAL = 8
        private const val DEFAULT_NUM__CAT_VAL = -1
    }

    override val googleUser: FirebaseAuth = FirebaseAuth.getInstance()
    override lateinit var mPreferences: SharedPreferences

    override fun getPreference() {
        mPreferences = context.getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE)
    }

    override fun setInitUser(init: Boolean) {
        mPreferences.edit()
            .putBoolean(INIT_USER, init)
            .apply()
    }

    override fun getInitUser(): Boolean {
        return mPreferences.getBoolean(INIT_USER, false)
    }

    override fun googleUserSignOut() {
        googleUser.signOut()
        Log.d("OJOF", googleUser.currentUser?.displayName.orEmpty())
    }

    override fun getNumOfFilms(): Int {
        return mPreferences.getInt(NUM_FILMS, DEFAULT_NUM_VAL)
    }

    override fun setNumOfFilms(num: Int) {
        mPreferences.edit()
            .putInt(NUM_FILMS, num)
            .apply()
    }

    override fun getTournamentType(): String? {
        return mPreferences.getString(TOURNAMENT_TYPE, DEFAULT_NULL_VAL)
    }

    override fun setTournamentType(type: String) {
        mPreferences.edit()
            .putString(TOURNAMENT_TYPE, type)
            .apply()
    }

    override fun getGenreId(): String? {
        return mPreferences.getString(GENRE_ID, DEFAULT_NULL_VAL)
    }

    override fun setGenre(genre: String) {
        mPreferences.edit()
            .putString(GENRE_ID, genre)
            .apply()
    }

    override fun getGenreName(): String? {
        return mPreferences.getString(GENRE_NAME, DEFAULT_NULL_VAL)
    }

    override fun setGenreName(genre: String) {
        mPreferences.edit()
            .putString(GENRE_NAME, genre)
            .apply()
    }

    override fun getCategoryLink(): Int {
        return mPreferences.getInt(CATEGORY_LINK, DEFAULT_NUM__CAT_VAL)
    }

    override fun setCategoryLink(categoryLink: Int) {
        mPreferences.edit()
            .putInt(CATEGORY_LINK, categoryLink)
            .apply()
    }

    override fun getCategoryName(): String? {
        return mPreferences.getString(CATEGORY_NAME, DEFAULT_NULL_VAL)
    }

    override fun setCategoryName(categoryName: String) {
        mPreferences.edit()
            .putString(CATEGORY_NAME, categoryName)
            .apply()
    }

    override fun setFragment(name: String) {
        mPreferences.edit()
            .putString(FRAGMENT, name)
            .apply()
    }

    override fun getFragment(): String? {
        return mPreferences.getString(FRAGMENT, DEFAULT_NULL_VAL)
    }

    override fun setFirstSignIn(init: Boolean) {
        mPreferences.edit()
            .putBoolean(FIRST_SIGN_IN, init)
            .apply()
    }

    override fun getFirstSignIn(): Boolean {
        return mPreferences.getBoolean(FIRST_SIGN_IN, false)
    }

    override fun getGuestOrAuth(): String? {
        return mPreferences.getString(GUEST_OR_AUTH, DEFAULT_NULL_VAL)
    }

    override fun setGuestOrAuth(name: String) {
        mPreferences.edit()
            .putString(GUEST_OR_AUTH, name)
            .apply()
    }
}
