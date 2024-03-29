package com.example.redditclone.di.main_activity

import com.example.redditclone.di.main_activity.home_fragment.HomeFragmentScope
import com.example.redditclone.di.main_activity.login_fragment.LoginFragmentScope
import com.example.redditclone.di.main_activity.login_fragment.LoginViewModelModule
import com.example.redditclone.di.main_activity.login_fragment.RetrofitModule
import com.example.redditclone.ui.fragments.home_fragment.HomeFragment
import com.example.redditclone.ui.fragments.login_fragment.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {
    @ContributesAndroidInjector
    @HomeFragmentScope
    abstract fun homeFragment() : HomeFragment

    @ContributesAndroidInjector(modules = [RetrofitModule::class, LoginViewModelModule::class])
    @LoginFragmentScope
    abstract fun loginFragment() : LoginFragment
}