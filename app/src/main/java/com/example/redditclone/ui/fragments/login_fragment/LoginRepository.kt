package com.example.redditclone.ui.fragments.login_fragment

import android.content.SharedPreferences
import android.util.Base64
import androidx.lifecycle.MutableLiveData
import com.example.redditclone.data.models.AuthResponse
import com.example.redditclone.data.services.AuthService
import com.example.redditclone.di.main_activity.login_fragment.LoginFragmentScope
import com.example.redditclone.util.contracts.CLIENT_KEY
import com.example.redditclone.util.contracts.REDIRECT_URL
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okio.Utf8
import retrofit2.Retrofit
import javax.inject.Inject

@LoginFragmentScope
class LoginRepository @Inject constructor(
    private val retrofit: Retrofit,
    val encryptedSharedPreferences: SharedPreferences.Editor
) {
    val authState = MutableLiveData<AuthStateHandle.States>()
    val authService = retrofit.create(AuthService::class.java)
    suspend fun getAuth(code: String) {
        authState.postValue(AuthStateHandle.States.START)
      val encodedAuthString = "Basic " + Base64.encodeToString("$CLIENT_KEY:".toByteArray(), Base64.NO_WRAP)
        val authResult = withContext(Dispatchers.IO) {
            authService.getAuthToken(
                "authorization_code",
                code,
                REDIRECT_URL,
                encodedAuthString
            )
        }
        when {
            authResult.isSuccessful -> encryptDataInPreferences(authResult.body())
            else -> {
                authState.postValue(AuthStateHandle.States.FAILED)
                throw CancellationException("ERROR: ${authResult.message()}")
            }
        }
    }

    fun encryptDataInPreferences(data: AuthResponse?) {

        data?.let {
            encryptedSharedPreferences.apply {
                putString("access_token", data.access_token)
                putString("token_type", data.token_type)
                putLong("expires_in", data.expires_in)
                putString("scope", data.scope)
                putString("refresh_token", data.refresh_token)
            }.commit()
        }

        authState.postValue(AuthStateHandle.States.SUCCESS)

    }

}