package com.dalvik.pokemonsters.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.dalvik.pokemonsters.R
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
        binding.btnInfo.setOnClickListener {
           /* it.findNavController().navigate(
                R.id.action_homeFragment_to_contactFragment,
            )*/
        }
    }

    override fun subscribeToEvents() {
        /*Nothing else*/
    }
}