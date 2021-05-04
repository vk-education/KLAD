package com.example.finema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.finema.databinding.ActivityMainBinding
import com.example.finema.utlis.APP_ACTIVITY
import com.example.finema.utlis.AppPreference

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        APP_ACTIVITY = this
        AppPreference.getPreference(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}