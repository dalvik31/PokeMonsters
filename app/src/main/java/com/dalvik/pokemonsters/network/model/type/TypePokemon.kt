package com.dalvik.pokemonsters.network.model.type

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class TypePokemon(
    @StringRes val name: Int,
    @DrawableRes val image: Int,
    val isClickable: Boolean = false
): Parcelable