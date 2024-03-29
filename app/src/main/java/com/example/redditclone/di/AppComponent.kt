package com.example.redditclone.di

import android.app.Application
import com.example.redditclone.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Component(modules = [AndroidInjectionModule::class, ActivityBuilder::class, NetworkModule::class, EncryptedSharePreferencesModule::class])
@Singleton
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        fun build() : AppComponent

        @BindsInstance
        fun application(application: Application) : Builder
    }

}