package com.dalvik.pokemonsters.network.model.regions

import android.support.annotation.DrawableRes

data class Region(
    val name: String,
    val totalPokemon: String,
    @DrawableRes val imgUrl: Int?,
    val firstMedalImgUrl: Int,
    val firstMedalName: String,
    val secondMedalImgUrl: Int,
    val secondMedalName: String,
    val thirdMedalImgUrl: Int,
    val thirdMedalName: String,
    val forthMedalImgUrl: Int,
    val forthMedalName: String,
    val fifthMedalImgUrl: Int,
    val fifthMedalName: String,
    val sixthMedalImgUrl: Int,
    val sixthMedalName: String,
    val seventhMedalImgUrl: Int,
    val seventhMedalName: String,
    val eightMedalImgUrl: Int,
    val eightMedalName: String,
)
