package com.example.redditclone.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.redditclone.R
import dagger.android.DaggerActivity
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
