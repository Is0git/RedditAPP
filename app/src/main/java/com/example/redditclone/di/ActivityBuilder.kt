package com.example.redditclone.di

import com.example.redditclone.di.main_activity.FragmentBuilder
import com.example.redditclone.di.main_activity.MainActivityScope
import com.example.redditclone.di.main_activity.ViewModelFactoryModule
import com.example.redditclone.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [FragmentBuilder::class, ViewModelFactoryModule::class])
    @MainActivityScope
    abstract fun mainActivity() : MainActivity
}