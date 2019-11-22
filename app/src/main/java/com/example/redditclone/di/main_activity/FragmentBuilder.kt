package com.example.redditclone.di.main_activity

import com.example.redditclone.di.main_activity.home_fragment.HomeFragmentScope
import com.example.redditclone.di.main_activity.login_fragment.LoginFragmentScope
import com.example.redditclone.ui.fragments.HomeFragment
import com.example.redditclone.ui.fragments.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {
    @ContributesAndroidInjector
    @HomeFragmentScope
    abstract fun homeFragment() : HomeFragment

    @ContributesAndroidInjector
    @LoginFragmentScope
    abstract fun loginFragment() : LoginFragment
}