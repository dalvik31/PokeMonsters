package com.dalvik.pokemonsters.network.model.regions

import com.dalvik.pokemonsters.R
import com.dalvik.pokemonsters.utils.App

data class Region(
    val id: Int = App.instance.getString(R.string.kanto_id).toInt(),
    val name: String = App.instance.getString(R.string.kanto_name),
    val totalPokemon: String = App.instance.getString(R.string.kanto_total_pokemon),
    val imgUrl: Int = R.drawable.region_kanto,
    val serieUrl: String = "https://www.pokemon.com/el/dibujos-animados/temporadas/1",
    val comingSoon: Boolean = false,
    val firstMedalImgUrl: Int = R.drawable.rock_medal,
    val firstMedalName: String = App.instance.getString(R.string.kanto_first_medal),
    val secondMedalImgUrl: Int = R.drawable.watterfall_medal,
    val secondMedalName: String = App.instance.getString(R.string.kanto_second_medal),
    val thirdMedalImgUrl: Int = R.drawable.thunder_medal,
    val thirdMedalName: String = App.instance.getString(R.string.kanto_third_medal),
    val forthMedalImgUrl: Int = R.drawable.rainbow_medal,
    val forthMedalName: String = App.instance.getString(R.string.kanto_forth_medal),
    val fifthMedalImgUrl: Int = R.drawable.soul_medal,
    val fifthMedalName: String = App.instance.getString(R.string.kanto_fifth_medal),
    val sixthMedalImgUrl: Int = R.drawable.swamp_medal,
    val sixthMedalName: String = App.instance.getString(R.string.kanto_sixth_medal),
    val seventhMedalImgUrl: Int = R.drawable.volcano_medal,
    val seventhMedalName: String = App.instance.getString(R.string.kanto_seventh_medal),
    val eightMedalImgUrl: Int = R.drawable.ground_medal,
    val eightMedalName: String = App.instance.getString(R.string.kanto_eigth_medal),
)
