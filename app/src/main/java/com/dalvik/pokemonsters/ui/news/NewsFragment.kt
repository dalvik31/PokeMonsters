package com.dalvik.pokemonsters.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dalvik.pokemonsters.databinding.FragmentHomeBinding
import com.dalvik.pokemonsters.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : BaseFragment<FragmentHomeBinding, NewsViewModel, NewsViewModel>(
    NewsViewModel::class.java,
    NewsViewModel::class.java
) {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun bindViewModel(binding: FragmentHomeBinding, viewModel: NewsViewModel) {
        binding.viewModel = viewModel
    }

    override fun setupUiBehavior() {
        /*Nothing else*/
    }

    override fun subscribeToEvents() {
        /*Nothing else*/
    }
}