package com.dalvik.pokemonsters.utils


import com.dalvik.pokemonsters.R

fun String.getThumbnail(): String {
    if (this.length > 10) return this
    return "https://pokemon-project.com/pokedex/img/sprite/Home/256/".plus(this ?: "1").plus(".png")
}

fun String.getThumbnailShiny(): String {
    if (this.length > 10) return this
    return "https://pokemon-project.com/pokedex/img/sprite/Home/shiny/".plus(this ?: "1")
        .plus(".png")
}

fun String.getImage(): String {
    return "https://pokemon-project.com/pokedex/img/sprite/Home/".plus(this ?: "1").plus(".png")
}

fun Int.getPokemonType(): Int {
    return when (this ?: 1) {
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
        11 -> R.drawable.ic_electric
        12 -> R.drawable.ic_ground
        13 -> R.drawable.ic_ice
        14 -> R.drawable.ic_normal
        15 -> R.drawable.ic_psychic
        16 -> R.drawable.ic_rock
        17 -> R.drawable.ic_steel
        18 -> R.drawable.ic_water
        else -> R.drawable.ic_grass
    }
}

fun String.numberFormat(): String {
    return String.format("#%03d", this.toInt() ?: 0);
}