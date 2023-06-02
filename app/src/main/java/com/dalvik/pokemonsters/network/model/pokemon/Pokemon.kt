package com.dalvik.pokemonsters.network.model.pokemon

import com.dalvik.pokemonsters.utils.getPokemonType
import com.dalvik.pokemonsters.utils.getThumbnail

data class Pokemon(
    val id: String?,
    val name: String?,
    val type_first: Int?,
    val type_second: Int?,
    val isMega: Boolean?,
    val alternateImage: String?,
) {

    fun getThumbnail(): String {
        return alternateImage ?: (id ?: "").getThumbnail()
    }

    fun getType(type: Int): Int? {
        return type.getPokemonType()
    }

    override fun toString(): String {
        return "$id - $name"
    }

}
