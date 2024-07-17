package com.dalvik.pokemonsters.utils


import com.dalvik.pokemonsters.R
import java.text.SimpleDateFormat
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale
import java.util.TimeZone

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

fun Int.getPokemonTypeString(): Int {
    return when (this ?: 1) {
        1 -> R.string.type_poison
        2 -> R.string.type_grass
        3 -> R.string.type_bug
        4 -> R.string.type_dark
        5 -> R.string.type_dragon
        6 -> R.string.type_fairy
        7 -> R.string.type_fighting
        8 -> R.string.type_fire
        9 -> R.string.type_flying
        10 -> R.string.type_ghost
        11 -> R.string.type_electric
        12 -> R.string.type_ground
        13 -> R.string.type_ice
        14 -> R.string.type_normal
        15 -> R.string.type_psychic
        16 -> R.string.type_rock
        17 -> R.string.type_steel
        18 -> R.string.type_water
        else -> R.string.type_normal
    }
}

fun String.numberFormat(): String {
    return String.format("#%03d", this.toInt() ?: 0)
}

fun Long.dateFormat(): String {
    val formatter = SimpleDateFormat("dd 'de' MMMM 'de' yyyy",  Locale("es", "ES"))
    formatter.timeZone = TimeZone.getTimeZone("UTC")
    /**Return long date in this format dd de mm de yy*/
    return formatter.format(this)
}
