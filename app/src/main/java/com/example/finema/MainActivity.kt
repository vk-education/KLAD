package com.example.finema

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.appcompat.app.AppCompatActivity
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

        binding.topAppBar.setNavigationOnClickListener {
            binding.drawerLayout.open()
        }

        binding.navView.setNavigationItemSelectedListener {
            binding.drawerLayout.close()

            when (it.itemId) {

                R.id.budget -> Navigation.findNavController(this, R.id.fragment)
                    .navigate(R.id.action_global_fragmentHigherLower)

                R.id.tournament -> Navigation.findNavController(this, R.id.fragment)
                    .navigate(R.id.action_global_fragmentTmp)

                R.id.settings -> Navigation.findNavController(this, R.id.fragment)
                    .navigate(R.id.action_global_fragmentSettings)

            }

            true
        }
    }
}