package com.dalvik.pokemonsters.ui.table_type

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dalvik.pokemonsters.R
import com.dalvik.pokemonsters.databinding.FragmentTypeDetailsBinding
import com.dalvik.pokemonsters.ui.base.BaseFragment
import com.dalvik.pokemonsters.ui.base.BaseViewModel
import com.dalvik.pokemonsters.utils.PARAM_ITEM_POKEMON_NAME
import com.dalvik.pokemonsters.utils.PARAM_ITEM_POKEMON_SRC
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TypeDetailsFragment :
    BaseFragment<FragmentTypeDetailsBinding, TableTypeViewModel, BaseViewModel>(
        TableTypeViewModel::class.java,
        BaseViewModel::class.java
    ) {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTypeDetailsBinding
        get() = FragmentTypeDetailsBinding::inflate

    override fun setupUiBehavior() {
        searchArguments()
    }

    override fun subscribeToEvents() {
    }

    override fun bindViewModel(binding: FragmentTypeDetailsBinding, viewModel: TableTypeViewModel) {
        binding.viemodel = viewModel
    }


    private fun searchArguments() {
        arguments?.getInt(PARAM_ITEM_POKEMON_NAME)?.let {
            binding.pokemonName = it
            when (it) {
                R.string.type_normal -> viewModel.loadListNormalType()
                R.string.type_fighting -> viewModel.loadListFightingType()
                R.string.type_flying -> viewModel.loadListFlying()
                R.string.type_steel -> viewModel.loadListSteel()
                R.string.type_water -> viewModel.loadListWater()
                R.string.type_ice -> viewModel.loadListIce()
                R.string.type_grass -> viewModel.loadListGrass()
                R.string.type_bug -> viewModel.loadListBug()
                R.string.type_electric -> viewModel.loadListElectric()
                R.string.type_rock -> viewModel.loadListRock()
                R.string.type_ground -> viewModel.loadListGround()
                R.string.type_fire -> viewModel.loadListFire()
                R.string.type_fairy -> viewModel.loadListFairy()
                R.string.type_psychic -> viewModel.loadListPsychic()
                R.string.type_poison -> viewModel.loadListPoison()
                R.string.type_dragon -> viewModel.loadListDragon()
                R.string.type_ghost -> viewModel.loadListGhost()
                R.string.type_dark -> viewModel.loadListDark()
            }
        }

        arguments?.getInt(PARAM_ITEM_POKEMON_SRC)?.let {
            binding.pokemonSrc = it
        }
    }
}