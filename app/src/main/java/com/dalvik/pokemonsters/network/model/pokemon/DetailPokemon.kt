package com.dalvik.pokemonsters.network.model.pokemon

import com.dalvik.pokemonsters.network.model.images.Images
import com.dalvik.pokemonsters.network.model.text_pokedex.TextPokedex
import com.dalvik.pokemonsters.utils.getPokemonType
import com.dalvik.pokemonsters.utils.getPokemonTypeString
import com.dalvik.pokemonsters.utils.getThumbnail
import com.dalvik.pokemonsters.utils.numberFormat

data class DetailPokemon(
    val id: String?,
    val name: String?,
    val originalName: String?,
    val images: ArrayList<Images>?,
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
    val pokemon_num_evol: String?,
    val pokemon_name_evol: String?,
    val mega_name_pokemon: String?,
    val mega_num_pokemon: String?,
    val mega_url_pokemon: String?,
    val level_first_evolution: String?,
    val level_second_evolution: String?,
    val strengths_list: ArrayList<String>?,
    val weaknesses_list: ArrayList<String>?,
    val interestingData: String?,
    val isMega: Boolean?,
    val elementMega: String?,
    val onlyOneEvolution: Boolean?,
    val manyEvolution: Boolean?,
    val numberFirstManyEvoluton: String?,
    val nameFirstManyEvoluton: String?,
    val numberFirstEvolutionManyEvoluton: String?,
    val nameFirstEvolutionManyEvoluton: String?,
    val elementFirstManyEvoluton: String?,

    val numberSecondManyEvoluton: String?,
    val nameSecondManyEvoluton: String?,
    val numberSecondEvolutionManyEvoluton: String?,
    val nameSecondEvolutionManyEvoluton: String?,
    val elementSecondManyEvoluton: String?,

    val numberThirdManyEvoluton: String?,
    val nameThirdManyEvoluton: String?,
    val numberThirdEvolutionManyEvoluton: String?,
    val nameThirdEvolutionManyEvoluton: String?,
    val elementThirdManyEvoluton: String?,

    val numberFourthManyEvoluton: String?,
    val nameFourthManyEvoluton: String?,
    val numberFourthEvolutionManyEvoluton: String?,
    val nameFourthEvolutionManyEvoluton: String?,
    val elementFourthManyEvoluton: String?,

    val numberFifthManyEvoluton: String?,
    val nameFifthManyEvoluton: String?,
    val numberFifthEvolutionManyEvoluton: String?,
    val nameFifthEvolutionManyEvoluton: String?,
    val elementFifthManyEvoluton: String?,

    val numberSixthManyEvoluton: String?,
    val nameSixthManyEvoluton: String?,
    val numberSixthEvolutionManyEvoluton: String?,
    val nameSixthEvolutionManyEvoluton: String?,
    val elementSixthManyEvoluton: String?,

    val numberSeventhManyEvoluton: String?,
    val nameSeventhManyEvoluton: String?,
    val numberSeventhEvolutionManyEvoluton: String?,
    val nameSeventhEvolutionManyEvoluton: String?,
    val elementSeventhManyEvoluton: String?,

    val numberEighthManyEvoluton: String?,
    val nameEighthManyEvoluton: String?,
    val numberEighthEvolutionManyEvoluton: String?,
    val nameEighthEvolutionManyEvoluton: String?,
    val elementEighththManyEvoluton: String?,
) {

    fun getThumbnail(idPokemon: String?): String {
        if (idPokemon.isNullOrEmpty()) return ""
        return idPokemon.getThumbnail()
    }

    fun getType(type: Int): Int {
        return type.getPokemonType()
    }

    fun getTypeName(): Int {
        return (type_first ?: 0).getPokemonTypeString()
    }

    fun getTypeSrc(): Int {
        return (type_first ?: 0).getPokemonType()
    }


    fun getOrderDescriptionList(): MutableList<TextPokedex> {
        val array = (descriptionList ?: arrayListOf())
        return array.toMutableList().asReversed()
    }

    fun getFormatNumber(number: String?): String {
        if (number.isNullOrEmpty()) return ""
        return number.numberFormat()
    }

    fun getThumbnailMega(megaNumber: String?): String {
        return (mega_url_pokemon ?: (megaNumber ?: "").getThumbnail())
    }
}
