package com.dalvik.pokemonsters.network.model.pokemon

import com.dalvik.pokemonsters.R

data class Pokemon(
    val name: String,
    val image: String,
    val type_first: Int,
    val type_second: Int,
) {

    fun getImgFirstType(): Int? {
        return when (type_first) {
            1 -> R.drawable.ic_poison
            2 -> R.drawable.ic_grass
            3 -> R.drawable.ic_bug
            4 -> R.drawable.ic_dark
            5 -> R.drawable.ic_dragon
            6 -> R.drawable.ic_fairy
            7 -> R.drawable.ic_fighting
            8 -> R.drawable.ic_fire
            9 -> R.drawable.ic_flying
            10 -> R.drawable.ic_ghost
            11 -> R.drawable.ic_grass
            12 -> R.drawable.ic_ground
            13 -> R.drawable.ic_ice
            14 -> R.drawable.ic_normal
            15 -> R.drawable.ic_psychic
            16 -> R.drawable.ic_rock
            17 -> R.drawable.ic_steel
            18 -> R.drawable.ic_water
            else -> null
        }
    }

    fun getImgSecondType(): Int? {
        return when (type_second) {
            1 -> R.drawable.ic_poison
            2 -> R.drawable.ic_grass
            3 -> R.drawable.ic_bug
            4 -> R.drawable.ic_dark
            5 -> R.drawable.ic_dragon
            6 -> R.drawable.ic_fairy
            7 -> R.drawable.ic_fighting
            8 -> R.drawable.ic_fire
            9 -> R.drawable.ic_flying
            10 -> R.drawable.ic_ghost
            11 -> R.drawable.ic_grass
            12 -> R.drawable.ic_ground
            13 -> R.drawable.ic_ice
            14 -> R.drawable.ic_normal
            15 -> R.drawable.ic_psychic
            16 -> R.drawable.ic_rock
            17 -> R.drawable.ic_steel
            18 -> R.drawable.ic_water
            else -> null
        }
    }
}
