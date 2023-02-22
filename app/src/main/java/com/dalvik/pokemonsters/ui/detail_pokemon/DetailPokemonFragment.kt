package com.dalvik.pokemonsters.ui.detail_pokemon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dalvik.pokemonsters.R
import com.dalvik.pokemonsters.databinding.FragmentDetailPokemonBinding
import com.dalvik.pokemonsters.ui.base.BaseFragment
import com.dalvik.pokemonsters.utils.PARAM_ITEM_POKEMON_ID
import com.dalvik.pokemonsters.utils.PARAM_ITEM_POKEMON_NAME
import com.dalvik.pokemonsters.utils.PARAM_ITEM_POKEMON_SRC
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
        binding.fabOpenTableTypes.setOnClickListener {
            viewModel.pokemonType.value?.let {
                binding.fabOpenTableTypes.visibility = View.VISIBLE
                findNavController().navigate(R.id.action_detailPokemonFragment_to_typeDetailsFragment,
                    Bundle().apply {
                        putInt(
                            PARAM_ITEM_POKEMON_NAME,
                            viewModel.pokemonType.value ?: R.string.type_normal
                        )
                        putInt(
                            PARAM_ITEM_POKEMON_SRC,
                            viewModel.pokemonSrc.value ?: R.drawable.ic_normal
                        )
                    })
            }

        }
    }

    override fun subscribeToEvents() {
        viewModel.pokemon.observe(this) {
            it?.let {
                binding.fabOpenTableTypes.visibility = View.VISIBLE
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