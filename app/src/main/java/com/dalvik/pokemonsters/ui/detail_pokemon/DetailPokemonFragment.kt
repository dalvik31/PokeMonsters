package com.dalvik.pokemonsters.ui.detail_pokemon

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dalvik.pokemonsters.databinding.FragmentDetailPokemonBinding
import com.dalvik.pokemonsters.ui.base.BaseFragment
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
    }

    override fun subscribeToEvents() {
    }

}