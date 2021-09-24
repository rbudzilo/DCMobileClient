package com.budzilo.dcmobileclient

import androidx.fragment.app.Fragment

typealias ResultListener<T> = (T) -> Unit

fun Fragment.navigator(): Navigator {
    return requireActivity() as Navigator
}

interface Navigator {
    fun showLogin()

    fun showRegister()
}