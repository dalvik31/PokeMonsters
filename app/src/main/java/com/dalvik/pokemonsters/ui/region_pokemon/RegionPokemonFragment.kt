package com.dalvik.pokemonsters.ui.region_pokemon

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dalvik.pokemonsters.R
import com.dalvik.pokemonsters.databinding.FragmentRegionPokemonBinding
import com.dalvik.pokemonsters.network.model.news.News
import com.dalvik.pokemonsters.ui.base.BaseFragment
import com.dalvik.pokemonsters.utils.PARAM_ITEM_NEWS
import com.dalvik.pokemonsters.utils.PARAM_ITEM_REGION
import com.dalvik.pokemonsters.utils.PARAM_ITEM_REGION_NAME
import com.dalvik.pokemonsters.utils.PARAM_ITEM_REGION_TOTAL
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
        arguments?.let { Bundle ->
            Bundle.getInt(PARAM_ITEM_REGION).let {
                viewModel.getPokemon(it)
            }
            Bundle.getString(PARAM_ITEM_REGION_TOTAL).let {
                binding.subtitle = getString(R.string.textview_subtitle_region_pokemon,it)
            }
            Bundle.getString(PARAM_ITEM_REGION_NAME).let {
                binding.nameRegion = it
            }
        }
    }

}