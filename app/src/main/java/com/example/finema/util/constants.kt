package com.example.finema.util

import com.example.finema.MainActivity
import com.example.finema.database.DatabaseRepository
import com.google.firebase.database.DatabaseReference

// TODO убрать в классы где нужны
const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"
lateinit var REPOSITORY: DatabaseRepository
lateinit var APP_ACTIVITY: MainActivity

const val GENRE_LIST = "/3/genre/movie/list?api_key=bbf5a3000e95f1dddf266b5e187d4b21&language=ru-Ru"
const val TOP_RATED_LIST = "movie/top_rated?api_key=bbf5a3000e95f1dddf266b5e187d4b21&language=ru-Ru"
lateinit var REF_DATABASE: DatabaseReference
lateinit var REF_DATABASE_USER: DatabaseReference
lateinit var REF_DATABASE_USER_SAVED: DatabaseReference
