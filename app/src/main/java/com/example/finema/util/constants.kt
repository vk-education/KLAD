package com.example.finema.utlis

import com.example.finema.MainActivity
import com.example.finema.database.DatabaseRepository

const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"
lateinit var REPOSITORY: DatabaseRepository
lateinit var APP_ACTIVITY: MainActivity


const val API_KEY = "bbf5a3000e95f1dddf266b5e187d4b21"
const val BASE_URL = "https://api.themoviedb.org"
const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"
const val GENRE_LIST ="/3/genre/movie/list?api_key=bbf5a3000e95f1dddf266b5e187d4b21&language=ru-Ru"
const val GENRE = "/3/movie/top_rated?api_key=bbf5a3000e95f1dddf266b5e187d4b21&language=ru-Ru"
