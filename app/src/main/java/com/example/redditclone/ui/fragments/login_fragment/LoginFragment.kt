package com.example.redditclone.ui.fragments.login_fragment

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.redditclone.R
import com.example.redditclone.databinding.LoginLayoutBinding
import com.example.redditclone.ui.ViewModelFactory
import com.example.redditclone.util.contracts.AUTH_URL
import com.example.redditclone.util.contracts.STRING_DATA
import dagger.android.support.DaggerFragment
import java.net.URI
import javax.inject.Inject
const val TAG = "LOGINFRAGMENT"
class LoginFragment : DaggerFragment(), AuthStateHandle.AuthStateListener {
    lateinit var binding: LoginLayoutBinding
    lateinit var navController: NavController
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)
        binding = LoginLayoutBinding.inflate(inflater, container, false)
        binding.loginButton.setOnClickListener { getAuthRedirection() }

        loginViewModel.authState.observe(viewLifecycleOwner, Observer {
            if (it != null)
                when (it) {
                    AuthStateHandle.States.FAILED -> onLoginFailed()
                    AuthStateHandle.States.START -> onLoginStart()
                    AuthStateHandle.States.SUCCESS -> onLoginSuccess()
                    AuthStateHandle.States.CANCELED -> onLoginCanceled()
                    else -> Log.i(TAG, "ERROR WITH AuthStates")
                }
        })

        return binding.root
    }


    fun getAuthRedirection() {
        val intent = Intent(Intent.ACTION_VIEW, AUTH_URL.toUri())
        startActivity(intent)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }


    override fun onResume() {
        super.onResume()
        val uri = activity?.intent?.data
        if(uri != null) {
            val code = uri.getQueryParameters("code") ?: return
            loginViewModel.getAuth(code[0])
        }
    }
    override fun onLoginStart() {
            Log.d(TAG, "START")
    }

    override fun onLoginFailed() {
        Log.d(TAG, "FAILED")
    }

    override fun onLoginCanceled() {
        Log.d(TAG, "CANCELED")
    }

    override fun onLoginSuccess() {
        Log.d(TAG, "SUCCESS")
        navController.navigate(R.id.action_loginFragment_to_homeFragment)
    }


}