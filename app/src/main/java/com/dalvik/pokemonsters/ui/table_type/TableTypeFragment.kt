package com.dalvik.pokemonsters.ui.table_type

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dalvik.pokemonsters.databinding.FragmentTableTypeBinding
import com.dalvik.pokemonsters.ui.base.BaseFragment
import com.dalvik.pokemonsters.ui.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TableTypeFragment : BaseFragment<FragmentTableTypeBinding, TableTypeViewModel, BaseViewModel>(
    TableTypeViewModel::class.java,
    BaseViewModel::class.java
) {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTableTypeBinding
        get() = FragmentTableTypeBinding::inflate

    override fun setupUiBehavior() {
        viewModel.loadListTypes()
    }

    override fun subscribeToEvents() {
    }

    override fun bindViewModel(binding: FragmentTableTypeBinding, viewModel: TableTypeViewModel) {
        binding.viemodel = viewModel
    }
}