package com.budzilo.dcmobileclient.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.budzilo.dcmobileclient.Options
import com.budzilo.dcmobileclient.contract.*
import com.budzilo.dcmobileclient.R
import com.budzilo.dcmobileclient.databinding.FragmentLoginBinding

class LoginFragment : Fragment(), HasCustomTitle {

    private lateinit var options: Options

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        options = savedInstanceState?.getParcelable(KEY_OPTIONS) ?: Options.DEFAULT
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentLoginBinding.inflate(inflater, container, false)

        navigator().listenResult(Options::class.java, viewLifecycleOwner) {
            this.options = it
        }
        binding.registerButton.setOnClickListener { onRegisterButtonPressed() }
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_OPTIONS, options)
    }

    private fun onRegisterButtonPressed() {
        navigator().showRegisterFragment()
    }

    override fun getTitleRes(): Int = R.string.login

    companion object {
        @JvmStatic private val KEY_OPTIONS = "OPTIONS"
    }

}