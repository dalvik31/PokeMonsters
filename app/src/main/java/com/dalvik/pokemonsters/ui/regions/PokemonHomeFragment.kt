package com.dalvik.pokemonsters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dalvik.pokemonsters.databinding.FragmentPokemonHomeBinding
import com.dalvik.pokemonsters.ui.base.BaseFragment
import com.dalvik.pokemonsters.ui.news.NewsViewModel
import com.dalvik.pokemonsters.ui.regions.RegionsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PokemonFragment : BaseFragment<FragmentPokemonHomeBinding, RegionsViewModel, RegionsViewModel>(
    RegionsViewModel::class.java,
    RegionsViewModel::class.java
) {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPokemonHomeBinding
        get() = FragmentPokemonHomeBinding::inflate

    override fun bindViewModel(binding: FragmentPokemonHomeBinding, viewModel: RegionsViewModel) {
        binding.viewModel = viewModel
    }

    override fun setupUiBehavior() {
        viewModel.getRegions()
    }

    override fun subscribeToEvents() {
    }


}