package com.dalvik.pokemonsters.network.model.pokemon

import com.dalvik.pokemonsters.network.model.text_pokedex.TextPokedex
import com.dalvik.pokemonsters.utils.getPokemonType
import com.dalvik.pokemonsters.utils.getThumbnail

data class DetailPokemon(
    val id: String?,
    val name: String?,
    val images: ArrayList<String>?,
    val category: String?,
    val ability: String?,
    val ability_description: String?,
    val height: String?,
    val weight: String?,
    val hp: Int?,
    val attack: Int?,
    val defence: Int?,
    val attack_special: Int?,
    val defence_special: Int?,
    val speed: Int?,
    val total: Int?,
    val descriptionList: ArrayList<TextPokedex>?,
    val type_first: Int?,
    val type_second: Int?,
    val first_name_pokemon: String?,
    val first_num_pokemon: String?,
    val second_name_pokemon: String?,
    val second_num_pokemon: String?,
    val third_name_pokemon: String?,
    val third_num_pokemon: String?,
    val level_first_evolution: String?,
    val level_second_evolution: String?,
    val strengths_list: ArrayList<String>?,
    val weaknesses_list: ArrayList<String>?,
    val interestingData: String?,
    val isMega: Boolean?,
) {

    fun getThumbnail(idPokemon : String): String{
        return idPokemon.getThumbnail()
    }

    fun getType(type: Int): Int {
        return type.getPokemonType()
    }

    fun getOrderDescriptionList():  MutableList<TextPokedex>{
        val array = (descriptionList ?: arrayListOf())
        return array.toMutableList().asReversed()
    }
}
