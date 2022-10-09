package com.dalvik.pokemonsters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dalvik.pokemonsters.databinding.FragmentRegionHomeBinding
import com.dalvik.pokemonsters.ui.base.BaseFragment
import com.dalvik.pokemonsters.ui.news.NewsViewModel
import com.dalvik.pokemonsters.ui.regions.RegionsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RegionHomeFragment : BaseFragment<FragmentRegionHomeBinding, RegionsViewModel, RegionsViewModel>(
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
    }

    override fun subscribeToEvents() {
    }


}