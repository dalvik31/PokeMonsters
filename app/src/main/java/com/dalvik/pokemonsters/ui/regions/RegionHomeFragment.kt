package com.dalvik.pokemonsters.ui.regions


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.navigation.findNavController
import com.dalvik.pokemonsters.R
import com.dalvik.pokemonsters.databinding.FragmentRegionHomeBinding
import com.dalvik.pokemonsters.network.model.pokemon.Pokemon
import com.dalvik.pokemonsters.ui.base.BaseFragment
import com.dalvik.pokemonsters.utils.PARAM_ITEM_POKEMON_ID
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RegionHomeFragment :
    BaseFragment<FragmentRegionHomeBinding, RegionsViewModel, RegionsViewModel>(
        RegionsViewModel::class.java,
        RegionsViewModel::class.java
    ) {
    var adapter: ArrayAdapter<Pokemon>? = null


    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentRegionHomeBinding
        get() = FragmentRegionHomeBinding::inflate

    override fun bindViewModel(binding: FragmentRegionHomeBinding, viewModel: RegionsViewModel) {
        binding.viewModel = viewModel
    }

    override fun setupUiBehavior() {
        viewModel.getRegions()

        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(searchText: Editable?) {
                adapter?.let { arrayPokemon ->
                    if (searchText.isNullOrEmpty()) {
                        binding.regionResults.visibility = View.VISIBLE
                        binding.listResults.visibility = View.GONE
                    } else {
                        binding.regionResults.visibility = View.GONE
                        binding.listResults.visibility = View.VISIBLE
                        arrayPokemon.filter.filter(searchText)
                    }

                }
            }

        })

        binding.listResults.onItemClickListener =
            AdapterView.OnItemClickListener { parent, _, position, _ ->
                binding.etSearch.setText("")
                binding.listResults.findNavController().navigate(
                    R.id.action_regionFragment_to_detailPokemonFragment,
                    Bundle().apply {
                        putString(
                            PARAM_ITEM_POKEMON_ID,
                            (parent.getItemAtPosition(position) as Pokemon).id
                        )
                    }
                )
            }

    }

    override fun subscribeToEvents() {
        viewModel.pokemonList.observe(this) {
            adapter =
                ArrayAdapter<Pokemon>(requireContext(), android.R.layout.simple_list_item_1, it)
            binding.listResults.adapter = adapter
        }
    }


}