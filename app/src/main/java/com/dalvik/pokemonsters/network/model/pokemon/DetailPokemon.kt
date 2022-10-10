package com.dalvik.pokemonsters.network.model.pokemon

import com.dalvik.pokemonsters.R

data class DetailPokemon(
    val name: String,
    val images: ArrayList<String>,
    val number: String,
    val category: String,
    val height: String,
    val weight: String,
    val hp: Int,
    val attack: Int,
    val defence: Int,
    val attack_special: Int,
    val defence_special: Int,
    val velocity: Int,
    val total: Int,
    val descriptionList: ArrayList<String>,
    val type_first: Int?,
    val type_second: Int?,
    val first_name_pokemon: String,
    val first_num_pokemon: String,
    val second_name_pokemon: String,
    val second_num_pokemon: String,
    val third_name_pokemon: String,
    val third_num_pokemon: String,
    val level_first_evolution: String,
    val level_second_evolution: String,
    val strengths_list: ArrayList<String>,
    val weaknesses_list: ArrayList<String>,
    val interestingData: String,
){
    fun urlImage(numberPokemon: Int) :String{
        return "https://pokemon-project.com/pokedex/img/sprite/Home/128/".plus(numberPokemon).plus(".png")
    }
    fun urlLargeImage(numberPokemon: Int) :String{
        return "https://pokemon-project.com/pokedex/img/sprite/Home/".plus(numberPokemon).plus(".png")
    }

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
