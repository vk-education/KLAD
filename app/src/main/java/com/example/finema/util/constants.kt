package com.example.finema.util

import com.example.finema.MainActivity
import com.example.finema.database.DatabaseRepository
import com.google.firebase.database.DatabaseReference

// TODO убрать в классы где нужны
lateinit var APP_ACTIVITY: MainActivity

lateinit var REF_DATABASE: DatabaseReference
lateinit var REF_DATABASE_USER: DatabaseReference
lateinit var REF_DATABASE_USER_SAVED: DatabaseReference
