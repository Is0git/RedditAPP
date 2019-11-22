package com.example.redditclone.di.main_activity.login_fragment

import androidx.lifecycle.ViewModel
import com.example.redditclone.di.ViewModelKey
import com.example.redditclone.di.main_activity.login_fragment.LoginFragmentScope
import com.example.redditclone.ui.fragments.login_fragment.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class LoginViewModelModule {
    @Binds
    @LoginFragmentScope
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun getLoginViewModel(viewModel: LoginViewModel) : ViewModel
}