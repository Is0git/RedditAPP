package com.example.redditclone.ui.fragments.login_fragment

sealed class AuthStateHandle {
    enum class States {
        START, FAILED, CANCELED, SUCCESS
    }
  interface AuthStateListener{
      fun onLoginStart()

      fun onLoginFailed()

      fun onLoginCanceled()

      fun onLoginSuccess()
  }
}