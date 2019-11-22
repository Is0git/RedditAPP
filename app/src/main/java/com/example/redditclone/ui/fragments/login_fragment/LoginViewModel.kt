package com.example.redditclone.ui.fragments.login_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.redditclone.di.main_activity.login_fragment.LoginFragmentScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@LoginFragmentScope
class LoginViewModel @Inject constructor(val repo: LoginRepository) : ViewModel() {
    val authState = repo.authState

    fun getAuth(code: String) {
        viewModelScope.launch {
            repo.getAuth(code)
        }
    }
}