package com.dalvik.pokemonsters.utils

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.dalvik.pokemonsters.R
import com.dalvik.pokemonsters.databinding.LoaderBinding
import com.dalvik.pokemonsters.utils.getActivity

/**
 * Custom ui loader to easy show over current activity/fragment
 */
class CustomLoader(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private var _binding: LoaderBinding? = null

    fun show(config: LoaderConfig) {
        when (config.type) {
            Type.SOFT -> showSoft()
            Type.FULL -> showFull()
        }
    }

    private fun showSoft() {
        val view = inflate()
        view.findViewById<ConstraintLayout>(R.id.loader_container)
            .setBackgroundColor(ContextCompat.getColor(context, R.color.transparent))
    }

    private fun showFull() = inflate()

    private fun inflate(): View {
        val view = getActivity()?.findViewById<View>(R.id.loader_container)
        if (view != null) {
            _binding = LoaderBinding.bind(view)
            return view
        }
        val root = getActivity()?.findViewById<FrameLayout>(android.R.id.content)
        _binding = LoaderBinding.inflate(LayoutInflater.from(context), root, true)
        return requireNotNull(_binding).root
    }

    fun hide() {
        try {
            val root = getActivity()?.findViewById<FrameLayout>(android.R.id.content)
            val view = root?.findViewById<ConstraintLayout>(R.id.loader_container)
            view?.let {
                AnimationUtils.fadeOut(context, view)
                root.removeView(view)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    class LoaderConfig(val visible: Boolean, val type: Type = Type.FULL)
    enum class Type { FULL, SOFT }
}