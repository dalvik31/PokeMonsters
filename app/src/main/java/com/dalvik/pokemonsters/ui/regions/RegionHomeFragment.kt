package com.dalvik.pokemonsters.ui.regions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.dalvik.pokemonsters.R
import com.dalvik.pokemonsters.databinding.FragmentRegionHomeBinding
import com.dalvik.pokemonsters.ui.base.BaseFragment
import com.dalvik.pokemonsters.utils.PARAM_ITEM_POKEMON_ID
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RegionHomeFragment :
    BaseFragment<FragmentRegionHomeBinding, RegionsViewModel, RegionsViewModel>(
        RegionsViewModel::class.java,
        RegionsViewModel::class.java
    ) {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentRegionHomeBinding
        get() = FragmentRegionHomeBinding::inflate

    override fun bindViewModel(binding: FragmentRegionHomeBinding, viewModel: RegionsViewModel) {
        binding.viewModel = viewModel
    }

    override fun setupUiBehavior() {
        viewModel.getRegions()

        binding.btnSearch.setOnClickListener {
            it.findNavController().navigate(
                R.id.action_regionFragment_to_detailPokemonFragment,
                Bundle().apply {
                    putString(
                        PARAM_ITEM_POKEMON_ID,
                        binding.etSearch.text.toString()
                    )
                }
            )
        }
    }

    override fun subscribeToEvents() {
    }


}