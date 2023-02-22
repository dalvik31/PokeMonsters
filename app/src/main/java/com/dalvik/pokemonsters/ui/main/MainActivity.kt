package com.dalvik.pokemonsters.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
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

    @SuppressLint("SuspiciousIndentation")
    private fun setUpBottomNavigationView() {


        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        binding.mainFragmentBottomNavigationView.setupWithNavController(navHostFragment.navController)

        binding.mainFragmentBottomNavigationView.setOnItemSelectedListener { item ->
            onNavDestinationSelected(item, navHostFragment.navController)
            return@setOnItemSelectedListener true
        }


        binding.mainFragmentBottomNavigationView.setOnItemReselectedListener {

            when (it.itemId) {
                R.id.homeFragment -> {
                    navHostFragment.navController.popBackStack(R.id.homeFragment, false)
                }

                R.id.regionFragment -> {
                    navHostFragment.navController.popBackStack(R.id.regionFragment, false)
                }
                R.id.tableTypeFragment -> {
                    navHostFragment.navController.popBackStack(R.id.tableTypeFragment, false)
                }

            }
        }

    }
}