package com.dalvik.pokemonsters.ui.contact

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.dalvik.pokemonsters.R
import com.dalvik.pokemonsters.databinding.FragmentContactBinding
import com.dalvik.pokemonsters.ui.base.BaseFragment
import com.dalvik.pokemonsters.utils.PARAM_URL_NEWS
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ContactFragment : BaseFragment<FragmentContactBinding, ContactViewModel, ContactViewModel>(
    ContactViewModel::class.java,
    ContactViewModel::class.java
) {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentContactBinding
        get() = FragmentContactBinding::inflate

    override fun bindViewModel(binding: FragmentContactBinding, viewModel: ContactViewModel) {

    }

    override fun setupUiBehavior() {
        binding.textContactEmail.setOnClickListener {
            sendEmail()
        }
        binding.textContactPhone.setOnClickListener {
            openCall()
        }

        binding.textContactSource.setOnClickListener {
            it.findNavController().navigate(
                R.id.action_contactFragment_to_webViewFragment,
                Bundle().apply {
                    putString(
                        PARAM_URL_NEWS,
                        getString(R.string.textview_contact_source_url)
                    )
                }
            )
        }
    }

    private fun sendEmail() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("eeph31@gmail.com"))
        //put the Subject in the intent
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name))
        startActivity(Intent.createChooser(intent, getString(R.string.app_name)))
    }

    private fun openCall() {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.setData(Uri.parse("tel:+525548562659"))
        startActivity(intent)
    }

    override fun subscribeToEvents() {
        /*Nothing else*/
    }
}