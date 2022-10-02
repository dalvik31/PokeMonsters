package com.dalvik.pokemonsters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.dalvik.pokemonsters.databinding.FragmentHomeBinding
import com.dalvik.pokemonsters.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, NewsViewModel, NewsViewModel>(
    NewsViewModel::class.java,
    NewsViewModel::class.java
) {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun bindViewModel(binding: FragmentHomeBinding, viewModel: NewsViewModel) {
        binding.viewModel = viewModel    }

    override fun setupUiBehavior() {
        viewModel.getNews()
    }

    override fun subscribeToEvents() {
    }
}