package com.dalvik.pokemonsters.ui.region_pokemon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.dalvik.pokemonsters.R
import com.dalvik.pokemonsters.databinding.FragmentRegionPokemonBinding
import com.dalvik.pokemonsters.ui.base.BaseFragment
import com.dalvik.pokemonsters.utils.PARAM_ITEM_REGION
import com.dalvik.pokemonsters.utils.PARAM_ITEM_REGION_NAME
import com.dalvik.pokemonsters.utils.PARAM_ITEM_REGION_TOTAL
import com.dalvik.pokemonsters.utils.PARAM_URL_NEWS
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

        binding.fabOpenWeb.setOnClickListener {
            it.findNavController().navigate(
                R.id.action_regionPokemonFragment_to_webViewFragment,
                Bundle().apply {
                    putString(
                        PARAM_URL_NEWS,
                        "https://www.pokemon.com/el/episodios-pokemon/episodios-pokemon/temporadas-de-tv-pokemon/1/"
                    )
                }
            )
        }
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
                binding.showFabWebView = true
                binding.nameRegion = it
            }
        }
    }

}