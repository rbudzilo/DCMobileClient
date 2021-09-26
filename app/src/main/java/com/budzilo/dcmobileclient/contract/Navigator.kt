package com.budzilo.dcmobileclient.contract

import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner

typealias ResultListener<T> = (T) -> Unit

fun Fragment.navigator(): Navigator {
    return requireActivity() as Navigator
}

interface Navigator {

    fun showRegisterFragment()

    fun showLoginFragment()

    fun goBack()

    fun <T : Parcelable> listenResult(clazz: Class<T>, owner: LifecycleOwner, listener: ResultListener<T>)

}