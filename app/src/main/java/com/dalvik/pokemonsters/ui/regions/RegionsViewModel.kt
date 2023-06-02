package com.dalvik.pokemonsters.ui.regions

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dalvik.pokemonsters.R
import com.dalvik.pokemonsters.network.ResultData
import com.dalvik.pokemonsters.network.model.pokemon.Pokemon
import com.dalvik.pokemonsters.network.model.regions.Region
import com.dalvik.pokemonsters.ui.base.BaseViewModel
import com.dalvik.pokemonsters.uses_cases.GetPokemonRegionUseCase
import com.dalvik.pokemonsters.utils.App
import com.dalvik.pokemonsters.utils.CustomLoader
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegionsViewModel @Inject constructor(private val getPokemonRegionUseCase: GetPokemonRegionUseCase) :
    BaseViewModel(App.instance) {

    var itemList = MutableLiveData<ArrayList<Region>>(arrayListOf())
    var pokemonList = MutableLiveData<ArrayList<Pokemon>>(arrayListOf())

    init {
        getPokemonRegion()
    }


    @SuppressLint("SuspiciousIndentation")
    fun getRegions() {
        val list = ArrayList<Region>()
        list.add(getRegion(1))
        itemList.postValue(list)
    }

    private fun getRegion(region: Int): Region {
        return when (region) {
            1 -> Region()
            2 -> Region(
                id = App.instance.getString(R.string.jhoto_id).toInt(),
                name = App.instance.getString(R.string.jhoto_name),
                totalPokemon = App.instance.getString(R.string.jhoto_total_pokemon),
                imgUrl = R.drawable.region_jhoto,
                serieUrl = "https://www.pokemon.com/el/episodios-pokemon/episodios-pokemon/temporadas-de-tv-pokemon/2/",
                firstMedalImgUrl = R.drawable.zafiro_medal,
                firstMedalName = App.instance.getString(R.string.jhoto_first_medal),
                secondMedalImgUrl = R.drawable.colmena_medal,
                secondMedalName = App.instance.getString(R.string.jhoto_second_medal),
                thirdMedalImgUrl = R.drawable.planicie_medal,
                thirdMedalName = App.instance.getString(R.string.jhoto_third_medal),
                forthMedalImgUrl = R.drawable.niebla_medal,
                forthMedalName = App.instance.getString(R.string.jhoto_forth_medal),
                fifthMedalImgUrl = R.drawable.tormenta_medal,
                fifthMedalName = App.instance.getString(R.string.jhoto_fifth_medal),
                sixthMedalImgUrl = R.drawable.mineral_medal,
                sixthMedalName = App.instance.getString(R.string.jhoto_sixth_medal),
                seventhMedalImgUrl = R.drawable.glaciar_medal,
                seventhMedalName = App.instance.getString(R.string.jhoto_seventh_medal),
                eightMedalImgUrl = R.drawable.dragon_medal,
                eightMedalName = App.instance.getString(R.string.jhoto_eigth_medal)
            )

            else -> Region()
        }
    }


    private fun getPokemonRegion() {
        viewModelScope.launch {
            when (val resultPokemonRegion = getPokemonRegionUseCase(
                loader = CustomLoader.Type.SOFT,
                params = 1,
                viewModel = this@RegionsViewModel
            )) {
                is ResultData.Error -> {
                    //Nothing here this error is management by BaseViewModel class
                    //The same error is here resultCharacter.message to send viewmodel inside xml
                }

                is ResultData.Success -> {
                    pokemonList.postValue(resultPokemonRegion.model)
                }
            }

        }
    }


}