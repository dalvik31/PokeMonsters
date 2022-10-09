package com.dalvik.pokemonsters.ui.region_pokemon

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dalvik.pokemonsters.databinding.FragmentRegionPokemonBinding
import com.dalvik.pokemonsters.network.model.news.News
import com.dalvik.pokemonsters.ui.base.BaseFragment
import com.dalvik.pokemonsters.utils.PARAM_ITEM_NEWS
import com.dalvik.pokemonsters.utils.PARAM_ITEM_REGION
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegionPokemonFragment :
    BaseFragment<FragmentRegionPokemonBinding, RegionPokemonViewModel, RegionPokemonViewModel>(
        RegionPokemonViewModel::class.java,
        RegionPokemonViewModel::class.java
    ) {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentRegionPokemonBinding
        get() = FragmentRegionPokemonBinding::inflate

    override fun bindViewModel(
        binding: FragmentRegionPokemonBinding,
        viewModel: RegionPokemonViewModel
    ) {
        binding.viewModel = viewModel
    }

    override fun setupUiBehavior() {
        searchArguments()
    }

    override fun subscribeToEvents() {

    }

    private fun searchArguments() {
        arguments?.getInt(PARAM_ITEM_REGION)?.let {
            viewModel.getPokemon(it)
        }
    }

}