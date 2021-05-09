package com.example.finema.utlis

import com.example.finema.MainActivity
import com.example.finema.database.DatabaseRepository

const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"
lateinit var REPOSITORY: DatabaseRepository
lateinit var APP_ACTIVITY: MainActivity


const val API_KEY = "4ea6320d4adb7c437bf83d5a51b1d931"
const val BASE_URL = "https://api.themoviedb.org"
const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"
const val GENRE_LIST ="/3/genre/movie/list?api_key=4ea6320d4adb7c437bf83d5a51b1d931&language=ru-Ru"
const val GENRE = "3/movie/top_rated?api_key=c18b134e9a9c6e98abf8cb11df9c5afa&page=1&language=ru-Ru"
