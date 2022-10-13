package com.dalvik.pokemonsters.utils

import android.app.Activity
import android.content.ContextWrapper
import android.view.View

fun View.getActivity(): Activity? {
    var context = context
    while (context is ContextWrapper) {
        if (context is Activity) {
            return context
        }
        context = context.baseContext
    }
    return null
}
