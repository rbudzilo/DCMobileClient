package com.budzilo.dcmobileclient.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.budzilo.dcmobileclient.contract.*
import com.budzilo.dcmobileclient.Options
import com.budzilo.dcmobileclient.R
import com.budzilo.dcmobileclient.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment(), HasCustomTitle {

    private lateinit var options: Options

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        options = savedInstanceState?.getParcelable(KEY_OPTIONS) ?: Options.DEFAULT
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentRegisterBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_register, container, false)

        navigator().listenResult(Options::class.java, viewLifecycleOwner) {
            this.options = it
        }
        binding.loginButton.setOnClickListener { onLoginButtonPressed() }
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_OPTIONS, options)
    }

    private fun onLoginButtonPressed() {
        // navigator().showLoginFragment()
        navigator().goBack()
    }

    override fun getTitleRes(): Int = R.string.register

    companion object {
        @JvmStatic private val KEY_OPTIONS = "OPTIONS"
    }
}