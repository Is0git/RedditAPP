package com.example.redditclone

import android.content.SharedPreferences
import com.example.redditclone.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject

class App : DaggerApplication() {
   @Inject lateinit var preferences: SharedPreferences
    var isLoggedIn = true
    override fun onCreate() {
        super.onCreate()
       isLoggedIn = !preferences.getString("access_token", "").isNullOrEmpty()
    }
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}