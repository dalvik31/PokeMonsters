package com.dalvik.pokemonsters.utils

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.core.view.isVisible
import com.dalvik.pokemonsters.R
import com.dalvik.pokemonsters.databinding.AlertSnackViewBinding


class SnackAlertView(context: Context?) : LinearLayout(context) {
    companion object {
        private const val DEFAULT_VALUE = -1
        private const val ANIMATION_VALUE = 1000L
    }

    private var _binding: AlertSnackViewBinding? = null
    private val binding: AlertSnackViewBinding
        get() = _binding ?: throw RuntimeException("Binding must be non-null")
    private var data: Data? = null

    private fun inflate(): View {
        val view = getActivity()?.findViewById<View>(R.id.loaderSnackAlertView)
        if (view != null) {
            _binding = AlertSnackViewBinding.bind(view)
            return view
        }
        val root = getActivity()?.findViewById<FrameLayout>(android.R.id.content)
        _binding = AlertSnackViewBinding.inflate(LayoutInflater.from(context), root, true)
        return requireNotNull(_binding).root
    }

    private fun hideView() {
        try {
            val root = getActivity()?.findViewById<FrameLayout>(android.R.id.content)
            val view = root?.findViewById<LinearLayout>(R.id.loaderSnackAlertView)
            root?.removeView(view)
            _binding = null
            data?.onHide?.invoke()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun load(
        data: Data
    ) {
        this.data = data
        loadView()
    }

    private fun loadView() {
        inflate()
        loadMessage()
        loadClick()
        show()
    }

    private fun show() {
        val animation: Animation = AnimationUtils.loadAnimation(context, android.R.anim.fade_in)

        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(p0: Animation?) {}

            override fun onAnimationEnd(p0: Animation?) {
                loadAutoClose()
            }

            override fun onAnimationStart(p0: Animation?) {
                visibility = View.VISIBLE
            }
        })
        binding.loaderSnackAlertView.startAnimation(animation)
    }

    private fun hide() {
        val animation: Animation = AnimationUtils.loadAnimation(context, android.R.anim.fade_out)
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(p0: Animation?) {}

            override fun onAnimationEnd(p0: Animation?) {
                visibility = View.GONE
                hideView()
            }

            override fun onAnimationStart(p0: Animation?) {
            }
        })
        binding.loaderSnackAlertView.startAnimation(animation)
    }

    private fun loadClick() {
        binding.root.setOnClickListener {

        }
    }

    private fun loadMessage() {
        data?.let {
            data!!.backgroundColor.let {
                binding.root.backgroundTintList =
                    android.content.res.ColorStateList.valueOf(
                        androidx.core.content.ContextCompat.getColor(
                            context,
                            it
                        )
                    )
            }

            (binding.loaderSnackAlertView.layoutParams as FrameLayout.LayoutParams).gravity =
                Gravity.TOP

            data!!.leftIcon?.let {
                binding.alertIcon.isVisible = true
                binding.alertIcon.setImageResource(it)
            } ?: run { binding.alertIcon.isVisible = false }

            data!!.strText?.let {
                binding.message.text = it
                binding.message.isVisible = true
            }
            data!!.text?.let {
                if (it != DEFAULT_VALUE) {
                    binding.message.text = context.getText(it)
                    binding.message.isVisible = true
                }
            }
            if (data!!.text == null && data!!.strText == null) {
                binding.message.isVisible = false
            }

        }


    }

    private fun loadAutoClose() {
        if (data?.autoClose == true) {
            binding.root.postDelayed({
                hide()
            }, ANIMATION_VALUE)
        }
    }

    sealed class Data constructor(
        var leftIcon: Int? = null,
        var rightIcon: Int? = null,
        var onLeftClick: (() -> Unit)? = null,
        val showType: ShowType = ShowType.FROM_TOP,
        val text: Int? = null,
        val strText: String? = null,
        val textStyle: Int,
        val backgroundColor: Int,
        val autoClose: Boolean = true,
        val onHide: (() -> Unit)? = null,
    ) {
        class Success(
            text: Int? = null,
            strText: String? = null,
            showType: ShowType = ShowType.FROM_TOP,
            autoClose: Boolean = true,
            leftIcon: Int? = R.drawable.ic_success,
            onHide: (() -> Unit)? = null
        ) :
            Data(
                text = text,
                strText = strText,
                backgroundColor = android.R.color.white,
                showType = showType,
                autoClose = autoClose,
                leftIcon = leftIcon,
                onHide = onHide,
                textStyle = 0
            )

        class Error(
            text: Int? = null,
            strText: String? = null,
            showType: ShowType = ShowType.FROM_TOP,
            autoClose: Boolean = true,
            leftIcon: Int? = R.drawable.ic_cancel,
            onHide: (() -> Unit)? = null
        ) :
            Data(
                text = text,
                strText = strText,
                backgroundColor = android.R.color.white,
                showType = showType,
                autoClose = autoClose,
                leftIcon = leftIcon,
                onHide = onHide,
                textStyle = 0
            )
    }

    enum class ShowType(
        val fromXDelta: Float,
        val toXDelta: Float,
        val fromYDelta: Float,
        val toYDelta: Float
    ) {
        FROM_BOTTOM(0f, 0f, 300f, 0f),
        FROM_TOP(0f, 0f, -300f, 0f),
        FROM_RIGHT(1000f, 0f, 0f, 0f),
        FROM_LEFT(-1000f, 0f, 0f, 0f);
    }
}