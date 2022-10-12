package com.dalvik.pokemonsters.ui.detail_pokemon

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dalvik.pokemonsters.databinding.FragmentDetailPokemonBinding
import com.dalvik.pokemonsters.ui.base.BaseFragment
import com.dalvik.pokemonsters.utils.PARAM_ITEM_POKEMON_ID
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailPokemonFragment :
    BaseFragment<FragmentDetailPokemonBinding, DetailPokemonViewModel, DetailPokemonViewModel>(
        DetailPokemonViewModel::class.java,
        DetailPokemonViewModel::class.java
    ) {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailPokemonBinding
        get() = FragmentDetailPokemonBinding::inflate

    override fun bindViewModel(
        binding: FragmentDetailPokemonBinding,
        viewModel: DetailPokemonViewModel
    ) {
    }

    override fun setupUiBehavior() {
        searchArguments()



    }

    override fun subscribeToEvents() {
        viewModel.pokemon.observe(this){
            it?.let {
                binding.pokemon = it
            }
        }
    }

    private fun searchArguments() {
        arguments?.let { Bundle ->
            Bundle.getString(PARAM_ITEM_POKEMON_ID)?.let {
                viewModel.getPokemon(it)
            }

        }
    }

}