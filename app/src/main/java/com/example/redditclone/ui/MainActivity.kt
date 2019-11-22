package com.example.redditclone.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.example.redditclone.App
import com.example.redditclone.R
import com.example.redditclone.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        navController = findNavController(R.id.main_fragment_container)
        if ((application as App).isLoggedIn) navController.navigate(R.id.action_global_main_nav)

    }
}