package com.dalvik.pokemonsters.ui.regions

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.dalvik.pokemonsters.R
import com.dalvik.pokemonsters.network.model.regions.Region
import com.dalvik.pokemonsters.ui.base.BaseViewModel
import com.dalvik.pokemonsters.utils.App
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.collections.ArrayList

@HiltViewModel
class RegionsViewModel @Inject constructor() : BaseViewModel(App.instance) {

    var itemList = MutableLiveData<ArrayList<Region>>(arrayListOf())
    var itemVideo = MutableLiveData("")


    @SuppressLint("SuspiciousIndentation")
    fun getRegions() {
      val list = ArrayList<Region>()
        list.add(getRegion(1))
        list.add(getRegion(2))
        itemList.postValue(list)
    }

    private fun getRegion(region: Int):Region{
        return when(region){
            1 -> Region()
            2 -> Region(
                id = App.instance.getString(R.string.jhoto_id).toInt(),
                name =  App.instance.getString(R.string.jhoto_name),
                totalPokemon = App.instance.getString(R.string.jhoto_total_pokemon),
                imgUrl = R.drawable.region_jhoto,
                serieUrl = "https://www.pokemon.com/el/episodios-pokemon/episodios-pokemon/temporadas-de-tv-pokemon/2/",
                firstMedalImgUrl = R.drawable.zafiro_medal,
                firstMedalName =  App.instance.getString(R.string.jhoto_first_medal),
                secondMedalImgUrl = R.drawable.colmena_medal,
                secondMedalName =  App.instance.getString(R.string.jhoto_second_medal),
                thirdMedalImgUrl = R.drawable.planicie_medal,
                thirdMedalName =  App.instance.getString(R.string.jhoto_third_medal),
                forthMedalImgUrl = R.drawable.niebla_medal,
                forthMedalName =  App.instance.getString(R.string.jhoto_forth_medal),
                fifthMedalImgUrl = R.drawable.tormenta_medal,
                fifthMedalName =  App.instance.getString(R.string.jhoto_fifth_medal),
                sixthMedalImgUrl = R.drawable.mineral_medal,
                sixthMedalName =  App.instance.getString(R.string.jhoto_sixth_medal),
                seventhMedalImgUrl = R.drawable.glaciar_medal,
                seventhMedalName =  App.instance.getString(R.string.jhoto_seventh_medal),
                eightMedalImgUrl = R.drawable.dragon_medal,
                eightMedalName =  App.instance.getString(R.string.jhoto_eigth_medal))
            else -> Region()
        }
    }
}