package com.example.redditclone.ui.fragments.login_fragment

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.redditclone.R
import com.example.redditclone.databinding.LoginLayoutBinding
import com.example.redditclone.ui.ViewModelFactory
import com.example.redditclone.util.contracts.AUTH_URL
import com.example.redditclone.util.contracts.CLIENT_KEY
import com.example.redditclone.util.contracts.SCOPES
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class LoginFragment : DaggerFragment(), AuthStateHandle.AuthStateListener {
    lateinit var binding: LoginLayoutBinding
    lateinit var navController: NavController
    @Inject lateinit var viewModelFactory: ViewModelFactory
    lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginViewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)
        binding = LoginLayoutBinding.inflate(inflater, container, false)
        binding.loginButton.setOnClickListener { getAuthRedirection() }

//        navController.navigate(R.id.action_loginFragment_to_homeFragment)
        return binding.root
    }


    fun getAuthRedirection() {
        val intent = Intent(Intent.ACTION_VIEW,AUTH_URL.toUri())
        startActivity(intent)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    override fun onLoginStart() {

    }

    override fun onLoginFailed() {

    }

    override fun onLoginCanceled() {

    }

    override fun onLoginSuccess() {

    }



}