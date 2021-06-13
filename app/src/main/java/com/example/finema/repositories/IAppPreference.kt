package com.example.finema.repositories

import android.content.Context
import android.content.SharedPreferences
import com.google.firebase.auth.FirebaseAuth

interface IAppPreference {
    val context: Context
    val googleUser: FirebaseAuth
    var mPreferences: SharedPreferences

    fun getPreference()

    fun setInitUser(init: Boolean)

    fun getInitUser(): Boolean

    fun googleUserSignOut()

    fun getNumOfFilms(): Int

    fun setNumOfFilms(num: Int)

    fun getTournamentType(): String?

    fun setTournamentType(type: String)

    fun getGenreId(): String?

    fun setGenre(genre: String)

    fun getGenreName(): String?

    fun setGenreName(genre: String)

    fun getCategoryLink(): Int

    fun setCategoryLink(categoryLink: Int)

    fun getCategoryName(): String?

    fun setCategoryName(categoryName: String)

    fun setFragment(name: String)

    fun getFragment(): String?

    fun setFirstSignIn(init: Boolean)

    fun getFirstSignIn(): Boolean

    fun getGuestOrAuth(): String?

    fun setGuestOrAuth(name: String)
}
