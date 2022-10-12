package com.dalvik.pokemonsters.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.dalvik.pokemonsters.R
import com.dalvik.pokemonsters.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpBottomNavigationView()
    }

    private fun setUpBottomNavigationView() {
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment)?.let { fragment ->
            NavigationUI.setupWithNavController(
                binding.mainFragmentBottomNavigationView,
                fragment.findNavController()
            )
        }
    }

}