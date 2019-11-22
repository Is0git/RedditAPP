package com.example.redditclone.ui.fragments.home_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.redditclone.databinding.MainLayoutBinding
import dagger.android.support.DaggerFragment

class HomeFragment : DaggerFragment(){
    lateinit var binding: MainLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }
}