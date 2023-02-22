package com.dalvik.pokemonsters.utils

import android.content.Context
import android.view.View
import android.view.animation.Animation

class AnimationUtils {

    companion object {

        fun fadeOut(context: Context, view: View) {
            val popOut: Animation =
                android.view.animation.AnimationUtils.loadAnimation(
                    context,
                    android.R.anim.fade_out
                )
            view.startAnimation(popOut)
        }
    }
}