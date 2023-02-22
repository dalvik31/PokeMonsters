package com.dalvik.pokemonsters.ui.table_type

import androidx.lifecycle.MutableLiveData
import com.dalvik.pokemonsters.R
import com.dalvik.pokemonsters.network.model.type.TypePokemon
import com.dalvik.pokemonsters.ui.base.BaseViewModel
import com.dalvik.pokemonsters.utils.App
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TableTypeViewModel @Inject constructor() : BaseViewModel(App.instance) {

    val listTypesPokemon = MutableLiveData<ArrayList<TypePokemon>>()
    val listEffective = MutableLiveData<ArrayList<TypePokemon>>()
    val listWeak = MutableLiveData<ArrayList<TypePokemon>>()
    val listResist = MutableLiveData<ArrayList<TypePokemon>>()
    val listVulnerability = MutableLiveData<ArrayList<TypePokemon>>()
    private val arrayListEffective = ArrayList<TypePokemon>()
    private val arrayListWeak = ArrayList<TypePokemon>()
    private val arrayListResist = ArrayList<TypePokemon>()
    private val arrayListVulnerability = ArrayList<TypePokemon>()

    fun loadListTypes() {
        var arrayList = ArrayList<TypePokemon>()
        arrayList.add(TypePokemon(R.string.type_normal, R.drawable.ic_normal, true))
        arrayList.add(TypePokemon(R.string.type_fighting, R.drawable.ic_fighting, true))
        arrayList.add(TypePokemon(R.string.type_flying, R.drawable.ic_flying, true))
        arrayList.add(TypePokemon(R.string.type_poison, R.drawable.ic_poison, true))
        arrayList.add(TypePokemon(R.string.type_ground, R.drawable.ic_ground, true))
        arrayList.add(TypePokemon(R.string.type_rock, R.drawable.ic_rock, true))
        arrayList.add(TypePokemon(R.string.type_bug, R.drawable.ic_bug, true))
        arrayList.add(TypePokemon(R.string.type_ghost, R.drawable.ic_ghost, true))
        arrayList.add(TypePokemon(R.string.type_steel, R.drawable.ic_steel, true))
        arrayList.add(TypePokemon(R.string.type_fire, R.drawable.ic_fire, true))
        arrayList.add(TypePokemon(R.string.type_water, R.drawable.ic_water, true))
        arrayList.add(TypePokemon(R.string.type_grass, R.drawable.ic_grass, true))
        arrayList.add(TypePokemon(R.string.type_electric, R.drawable.ic_electric, true))
        arrayList.add(TypePokemon(R.string.type_psychic, R.drawable.ic_psychic, true))
        arrayList.add(TypePokemon(R.string.type_ice, R.drawable.ic_ice, true))
        arrayList.add(TypePokemon(R.string.type_dragon, R.drawable.ic_dragon, true))
        arrayList.add(TypePokemon(R.string.type_fairy, R.drawable.ic_fairy, true))
        arrayList.add(TypePokemon(R.string.type_dark, R.drawable.ic_dark, true))
        listTypesPokemon.postValue(arrayList)
    }


    fun loadListNormalType() {
        arrayListWeak.add(TypePokemon(R.string.type_rock, R.drawable.ic_rock))
        arrayListWeak.add(TypePokemon(R.string.type_steel, R.drawable.ic_steel))
        listWeak.postValue(arrayListWeak)

        arrayListResist.add(TypePokemon(R.string.type_ghost, R.drawable.ic_ghost))
        listResist.postValue(arrayListResist)

        arrayListVulnerability.add(TypePokemon(R.string.type_fighting, R.drawable.ic_fighting))
        listVulnerability.postValue(arrayListVulnerability)
    }


    fun loadListFightingType() {
        arrayListEffective.add(TypePokemon(R.string.type_normal, R.drawable.ic_normal))
        arrayListEffective.add(TypePokemon(R.string.type_rock, R.drawable.ic_rock))
        arrayListEffective.add(TypePokemon(R.string.type_steel, R.drawable.ic_steel))
        arrayListEffective.add(TypePokemon(R.string.type_ice, R.drawable.ic_ice))
        arrayListEffective.add(TypePokemon(R.string.type_dark, R.drawable.ic_dark))
        listEffective.postValue(arrayListEffective)

        arrayListWeak.add(TypePokemon(R.string.type_flying, R.drawable.ic_flying))
        arrayListWeak.add(TypePokemon(R.string.type_poison, R.drawable.ic_poison))
        arrayListWeak.add(TypePokemon(R.string.type_psychic, R.drawable.ic_psychic))
        arrayListWeak.add(TypePokemon(R.string.type_bug, R.drawable.ic_bug))
        arrayListWeak.add(TypePokemon(R.string.type_fairy, R.drawable.ic_fairy))
        listWeak.postValue(arrayListWeak)

        arrayListVulnerability.add(TypePokemon(R.string.type_flying, R.drawable.ic_flying))
        arrayListVulnerability.add(TypePokemon(R.string.type_psychic, R.drawable.ic_psychic))
        arrayListVulnerability.add(TypePokemon(R.string.type_fairy, R.drawable.ic_fairy))
        listVulnerability.postValue(arrayListVulnerability)
    }

    fun loadListFlying() {
        arrayListEffective.add(TypePokemon(R.string.type_fighting, R.drawable.ic_fighting))
        arrayListEffective.add(TypePokemon(R.string.type_bug, R.drawable.ic_bug))
        arrayListEffective.add(TypePokemon(R.string.type_grass, R.drawable.ic_grass))
        listEffective.postValue(arrayListEffective)

        arrayListWeak.add(TypePokemon(R.string.type_electric, R.drawable.ic_electric))
        arrayListWeak.add(TypePokemon(R.string.type_rock, R.drawable.ic_rock))
        arrayListWeak.add(TypePokemon(R.string.type_steel, R.drawable.ic_steel))
        listWeak.postValue(arrayListWeak)

        arrayListResist.add(TypePokemon(R.string.type_ground, R.drawable.ic_ground))
        listResist.postValue(arrayListResist)

        arrayListVulnerability.add(TypePokemon(R.string.type_electric, R.drawable.ic_electric))
        arrayListVulnerability.add(TypePokemon(R.string.type_rock, R.drawable.ic_rock))
        arrayListVulnerability.add(TypePokemon(R.string.type_ice, R.drawable.ic_ice))
        listVulnerability.postValue(arrayListVulnerability)
    }

    fun loadListSteel() {
        arrayListEffective.add(TypePokemon(R.string.type_ice, R.drawable.ic_ice))
        arrayListEffective.add(TypePokemon(R.string.type_rock, R.drawable.ic_rock))
        arrayListEffective.add(TypePokemon(R.string.type_fairy, R.drawable.ic_fairy))
        listEffective.postValue(arrayListEffective)

        arrayListWeak.add(TypePokemon(R.string.type_steel, R.drawable.ic_steel))
        arrayListWeak.add(TypePokemon(R.string.type_electric, R.drawable.ic_electric))
        arrayListWeak.add(TypePokemon(R.string.type_water, R.drawable.ic_water))
        arrayListWeak.add(TypePokemon(R.string.type_fire, R.drawable.ic_fire))
        listWeak.postValue(arrayListWeak)

        arrayListResist.add(TypePokemon(R.string.type_poison, R.drawable.ic_poison))
        listResist.postValue(arrayListResist)


        arrayListVulnerability.add(TypePokemon(R.string.type_fighting, R.drawable.ic_fighting))
        arrayListVulnerability.add(TypePokemon(R.string.type_fire, R.drawable.ic_fire))
        arrayListVulnerability.add(TypePokemon(R.string.type_ground, R.drawable.ic_ground))
        listVulnerability.postValue(arrayListVulnerability)


    }

    fun loadListWater() {
        arrayListEffective.add(TypePokemon(R.string.type_fire, R.drawable.ic_fire))
        arrayListEffective.add(TypePokemon(R.string.type_ground, R.drawable.ic_ground))
        arrayListEffective.add(TypePokemon(R.string.type_rock, R.drawable.ic_rock))
        listEffective.postValue(arrayListEffective)

        arrayListWeak.add(TypePokemon(R.string.type_water, R.drawable.ic_water))
        arrayListWeak.add(TypePokemon(R.string.type_grass, R.drawable.ic_grass))
        arrayListWeak.add(TypePokemon(R.string.type_dragon, R.drawable.ic_dragon))
        listWeak.postValue(arrayListWeak)

        arrayListVulnerability.add(TypePokemon(R.string.type_grass, R.drawable.ic_grass))
        arrayListVulnerability.add(TypePokemon(R.string.type_electric, R.drawable.ic_electric))
        listVulnerability.postValue(arrayListVulnerability)
    }


    fun loadListIce() {
        arrayListEffective.add(TypePokemon(R.string.type_flying, R.drawable.ic_flying))
        arrayListEffective.add(TypePokemon(R.string.type_dragon, R.drawable.ic_dragon))
        arrayListEffective.add(TypePokemon(R.string.type_grass, R.drawable.ic_grass))
        arrayListEffective.add(TypePokemon(R.string.type_ground, R.drawable.ic_ground))
        listEffective.postValue(arrayListEffective)

        arrayListWeak.add(TypePokemon(R.string.type_steel, R.drawable.ic_steel))
        arrayListWeak.add(TypePokemon(R.string.type_water, R.drawable.ic_water))
        arrayListWeak.add(TypePokemon(R.string.type_fire, R.drawable.ic_fire))
        arrayListWeak.add(TypePokemon(R.string.type_ice, R.drawable.ic_ice))
        listWeak.postValue(arrayListWeak)

        arrayListVulnerability.add(TypePokemon(R.string.type_steel, R.drawable.ic_steel))
        arrayListVulnerability.add(TypePokemon(R.string.type_rock, R.drawable.ic_rock))
        arrayListVulnerability.add(TypePokemon(R.string.type_fire, R.drawable.ic_fire))
        arrayListVulnerability.add(TypePokemon(R.string.type_fighting, R.drawable.ic_fighting))
        listVulnerability.postValue(arrayListVulnerability)

    }

    fun loadListGrass() {
        arrayListEffective.add(TypePokemon(R.string.type_water, R.drawable.ic_water))
        arrayListEffective.add(TypePokemon(R.string.type_ground, R.drawable.ic_ground))
        arrayListEffective.add(TypePokemon(R.string.type_rock, R.drawable.ic_rock))
        listEffective.postValue(arrayListEffective)

        arrayListWeak.add(TypePokemon(R.string.type_steel, R.drawable.ic_steel))
        arrayListWeak.add(TypePokemon(R.string.type_flying, R.drawable.ic_flying))
        arrayListWeak.add(TypePokemon(R.string.type_grass, R.drawable.ic_grass))
        arrayListWeak.add(TypePokemon(R.string.type_bug, R.drawable.ic_bug))
        arrayListWeak.add(TypePokemon(R.string.type_fire, R.drawable.ic_fire))
        arrayListWeak.add(TypePokemon(R.string.type_poison, R.drawable.ic_poison))
        arrayListWeak.add(TypePokemon(R.string.type_dragon, R.drawable.ic_dragon))
        listWeak.postValue(arrayListWeak)

        arrayListVulnerability.add(TypePokemon(R.string.type_flying, R.drawable.ic_flying))
        arrayListVulnerability.add(TypePokemon(R.string.type_ice, R.drawable.ic_ice))
        arrayListVulnerability.add(TypePokemon(R.string.type_bug, R.drawable.ic_bug))
        arrayListVulnerability.add(TypePokemon(R.string.type_fire, R.drawable.ic_fire))
        arrayListVulnerability.add(TypePokemon(R.string.type_poison, R.drawable.ic_poison))
        listVulnerability.postValue(arrayListVulnerability)
    }

    fun loadListBug() {
        arrayListEffective.add(TypePokemon(R.string.type_grass, R.drawable.ic_grass))
        arrayListEffective.add(TypePokemon(R.string.type_psychic, R.drawable.ic_psychic))
        arrayListEffective.add(TypePokemon(R.string.type_dark, R.drawable.ic_dark))
        listEffective.postValue(arrayListEffective)

        arrayListWeak.add(TypePokemon(R.string.type_steel, R.drawable.ic_steel))
        arrayListWeak.add(TypePokemon(R.string.type_flying, R.drawable.ic_flying))
        arrayListWeak.add(TypePokemon(R.string.type_fire, R.drawable.ic_fire))
        arrayListWeak.add(TypePokemon(R.string.type_fighting, R.drawable.ic_fighting))
        arrayListWeak.add(TypePokemon(R.string.type_fairy, R.drawable.ic_fairy))
        arrayListWeak.add(TypePokemon(R.string.type_poison, R.drawable.ic_poison))
        arrayListWeak.add(TypePokemon(R.string.type_dragon, R.drawable.ic_dragon))
        listWeak.postValue(arrayListWeak)

        arrayListVulnerability.add(TypePokemon(R.string.type_flying, R.drawable.ic_flying))
        arrayListVulnerability.add(TypePokemon(R.string.type_fire, R.drawable.ic_fire))
        arrayListVulnerability.add(TypePokemon(R.string.type_rock, R.drawable.ic_rock))
        listVulnerability.postValue(arrayListVulnerability)
    }

    fun loadListElectric() {
        arrayListEffective.add(TypePokemon(R.string.type_flying, R.drawable.ic_flying))
        arrayListEffective.add(TypePokemon(R.string.type_water, R.drawable.ic_water))
        listEffective.postValue(arrayListEffective)

        arrayListWeak.add(TypePokemon(R.string.type_grass, R.drawable.ic_grass))
        arrayListWeak.add(TypePokemon(R.string.type_electric, R.drawable.ic_electric))
        arrayListWeak.add(TypePokemon(R.string.type_dragon, R.drawable.ic_dragon))
        listWeak.postValue(arrayListWeak)

        arrayListVulnerability.add(TypePokemon(R.string.type_ground, R.drawable.ic_ground))
        listVulnerability.postValue(arrayListVulnerability)
    }

    fun loadListRock() {
        arrayListEffective.add(TypePokemon(R.string.type_flying, R.drawable.ic_flying))
        arrayListEffective.add(TypePokemon(R.string.type_ice, R.drawable.ic_ice))
        arrayListEffective.add(TypePokemon(R.string.type_bug, R.drawable.ic_bug))
        arrayListEffective.add(TypePokemon(R.string.type_fire, R.drawable.ic_fire))
        listEffective.postValue(arrayListEffective)

        arrayListWeak.add(TypePokemon(R.string.type_steel, R.drawable.ic_steel))
        arrayListWeak.add(TypePokemon(R.string.type_ground, R.drawable.ic_ground))
        arrayListWeak.add(TypePokemon(R.string.type_fighting, R.drawable.ic_fighting))
        listWeak.postValue(arrayListWeak)

        arrayListVulnerability.add(TypePokemon(R.string.type_steel, R.drawable.ic_steel))
        arrayListVulnerability.add(TypePokemon(R.string.type_grass, R.drawable.ic_grass))
        arrayListVulnerability.add(TypePokemon(R.string.type_water, R.drawable.ic_water))
        arrayListVulnerability.add(TypePokemon(R.string.type_ground, R.drawable.ic_ground))
        arrayListVulnerability.add(TypePokemon(R.string.type_fighting, R.drawable.ic_fighting))
        listVulnerability.postValue(arrayListVulnerability)
    }

    fun loadListGround() {
        arrayListEffective.add(TypePokemon(R.string.type_steel, R.drawable.ic_steel))
        arrayListEffective.add(TypePokemon(R.string.type_electric, R.drawable.ic_electric))
        arrayListEffective.add(TypePokemon(R.string.type_rock, R.drawable.ic_rock))
        arrayListEffective.add(TypePokemon(R.string.type_fire, R.drawable.ic_fire))
        arrayListEffective.add(TypePokemon(R.string.type_poison, R.drawable.ic_poison))
        listEffective.postValue(arrayListEffective)

        arrayListWeak.add(TypePokemon(R.string.type_grass, R.drawable.ic_grass))
        arrayListWeak.add(TypePokemon(R.string.type_bug, R.drawable.ic_bug))
        listWeak.postValue(arrayListWeak)

        arrayListResist.add(TypePokemon(R.string.type_electric, R.drawable.ic_electric))
        listResist.postValue(arrayListResist)

        arrayListVulnerability.add(TypePokemon(R.string.type_grass, R.drawable.ic_grass))
        arrayListVulnerability.add(TypePokemon(R.string.type_water, R.drawable.ic_water))
        arrayListVulnerability.add(TypePokemon(R.string.type_ice, R.drawable.ic_ice))
        listVulnerability.postValue(arrayListVulnerability)
    }

    fun loadListFire() {
        arrayListEffective.add(TypePokemon(R.string.type_steel, R.drawable.ic_steel))
        arrayListEffective.add(TypePokemon(R.string.type_ice, R.drawable.ic_ice))
        arrayListEffective.add(TypePokemon(R.string.type_grass, R.drawable.ic_grass))
        arrayListEffective.add(TypePokemon(R.string.type_bug, R.drawable.ic_bug))
        listEffective.postValue(arrayListEffective)

        arrayListWeak.add(TypePokemon(R.string.type_water, R.drawable.ic_water))
        arrayListWeak.add(TypePokemon(R.string.type_rock, R.drawable.ic_rock))
        arrayListWeak.add(TypePokemon(R.string.type_fire, R.drawable.ic_fire))
        arrayListWeak.add(TypePokemon(R.string.type_dragon, R.drawable.ic_dragon))
        listWeak.postValue(arrayListWeak)

        arrayListVulnerability.add(TypePokemon(R.string.type_water, R.drawable.ic_water))
        arrayListVulnerability.add(TypePokemon(R.string.type_rock, R.drawable.ic_rock))
        arrayListVulnerability.add(TypePokemon(R.string.type_ground, R.drawable.ic_ground))
        listVulnerability.postValue(arrayListVulnerability)
    }

    fun loadListFairy() {
        arrayListEffective.add(TypePokemon(R.string.type_fighting, R.drawable.ic_fighting))
        arrayListEffective.add(TypePokemon(R.string.type_dragon, R.drawable.ic_dragon))
        arrayListEffective.add(TypePokemon(R.string.type_dark, R.drawable.ic_dark))
        listEffective.postValue(arrayListEffective)

        arrayListWeak.add(TypePokemon(R.string.type_steel, R.drawable.ic_steel))
        arrayListWeak.add(TypePokemon(R.string.type_fire, R.drawable.ic_fire))
        arrayListWeak.add(TypePokemon(R.string.type_poison, R.drawable.ic_poison))
        listWeak.postValue(arrayListWeak)

        arrayListResist.add(TypePokemon(R.string.type_dragon, R.drawable.ic_dragon))
        listResist.postValue(arrayListResist)

        arrayListVulnerability.add(TypePokemon(R.string.type_steel, R.drawable.ic_steel))
        arrayListVulnerability.add(TypePokemon(R.string.type_poison, R.drawable.ic_poison))
        listVulnerability.postValue(arrayListVulnerability)
    }

    fun loadListPsychic() {
        arrayListEffective.add(TypePokemon(R.string.type_fighting, R.drawable.ic_fighting))
        arrayListEffective.add(TypePokemon(R.string.type_poison, R.drawable.ic_poison))
        listEffective.postValue(arrayListEffective)

        arrayListWeak.add(TypePokemon(R.string.type_steel, R.drawable.ic_steel))
        arrayListWeak.add(TypePokemon(R.string.type_psychic, R.drawable.ic_psychic))
        listWeak.postValue(arrayListWeak)

        arrayListVulnerability.add(TypePokemon(R.string.type_bug, R.drawable.ic_bug))
        arrayListVulnerability.add(TypePokemon(R.string.type_dark, R.drawable.ic_dark))
        arrayListVulnerability.add(TypePokemon(R.string.type_ghost, R.drawable.ic_ghost))
        listVulnerability.postValue(arrayListVulnerability)
    }

    fun loadListPoison() {
        arrayListEffective.add(TypePokemon(R.string.type_grass, R.drawable.ic_grass))
        arrayListEffective.add(TypePokemon(R.string.type_fairy, R.drawable.ic_fairy))
        listEffective.postValue(arrayListEffective)

        arrayListWeak.add(TypePokemon(R.string.type_rock, R.drawable.ic_rock))
        arrayListWeak.add(TypePokemon(R.string.type_poison, R.drawable.ic_poison))
        arrayListWeak.add(TypePokemon(R.string.type_ground, R.drawable.ic_ground))
        arrayListWeak.add(TypePokemon(R.string.type_ghost, R.drawable.ic_ghost))
        listWeak.postValue(arrayListWeak)

        arrayListVulnerability.add(TypePokemon(R.string.type_ground, R.drawable.ic_ground))
        arrayListVulnerability.add(TypePokemon(R.string.type_psychic, R.drawable.ic_psychic))
        listVulnerability.postValue(arrayListVulnerability)
    }

    fun loadListDragon() {
        arrayListEffective.add(TypePokemon(R.string.type_dragon, R.drawable.ic_dragon))
        listEffective.postValue(arrayListEffective)

        arrayListWeak.add(TypePokemon(R.string.type_steel, R.drawable.ic_steel))
        listWeak.postValue(arrayListWeak)

        arrayListVulnerability.add(TypePokemon(R.string.type_ice, R.drawable.ic_ice))
        arrayListVulnerability.add(TypePokemon(R.string.type_dragon, R.drawable.ic_dragon))
        arrayListVulnerability.add(TypePokemon(R.string.type_fairy, R.drawable.ic_fairy))
        listVulnerability.postValue(arrayListVulnerability)

    }

    fun loadListGhost() {
        arrayListEffective.add(TypePokemon(R.string.type_psychic, R.drawable.ic_psychic))
        arrayListEffective.add(TypePokemon(R.string.type_ghost, R.drawable.ic_ghost))
        listEffective.postValue(arrayListEffective)

        arrayListWeak.add(TypePokemon(R.string.type_dark, R.drawable.ic_dark))
        listWeak.postValue(arrayListWeak)

        arrayListVulnerability.add(TypePokemon(R.string.type_ghost, R.drawable.ic_ghost))
        arrayListVulnerability.add(TypePokemon(R.string.type_dark, R.drawable.ic_dark))
        listVulnerability.postValue(arrayListVulnerability)

        arrayListResist.add(TypePokemon(R.string.type_fighting, R.drawable.ic_fighting))
        arrayListResist.add(TypePokemon(R.string.type_normal, R.drawable.ic_normal))
        listResist.postValue(arrayListResist)

    }

    fun loadListDark() {
        arrayListEffective.add(TypePokemon(R.string.type_psychic, R.drawable.ic_psychic))
        arrayListEffective.add(TypePokemon(R.string.type_ghost, R.drawable.ic_ghost))
        listEffective.postValue(arrayListEffective)

        arrayListWeak.add(TypePokemon(R.string.type_fighting, R.drawable.ic_fighting))
        arrayListWeak.add(TypePokemon(R.string.type_fairy, R.drawable.ic_fairy))
        arrayListWeak.add(TypePokemon(R.string.type_dark, R.drawable.ic_dark))
        listWeak.postValue(arrayListWeak)

        arrayListVulnerability.add(TypePokemon(R.string.type_bug, R.drawable.ic_bug))
        arrayListVulnerability.add(TypePokemon(R.string.type_fighting, R.drawable.ic_fighting))
        arrayListVulnerability.add(TypePokemon(R.string.type_fairy, R.drawable.ic_fairy))
        listVulnerability.postValue(arrayListVulnerability)

        arrayListResist.add(TypePokemon(R.string.type_psychic, R.drawable.ic_psychic))
        listResist.postValue(arrayListResist)
    }

}