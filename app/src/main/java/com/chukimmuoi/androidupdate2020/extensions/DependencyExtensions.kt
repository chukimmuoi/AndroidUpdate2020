package com.chukimmuoi.androidupdate2020.extensions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

/**
 * @author  : Chu Kim Muoi
 * @Skype   : chukimmuoi
 * @Mobile  : +84 373 672 505
 * @Email   : chukimmuoi@gmail.com
 * @Project : AndroidUpdate2020
 * Created by chukimmuoi on 2019-12-30.
 */

/**
 * Kotlin extensions for dependency injection
 */
inline fun <reified T : ViewModel> FragmentActivity.injectViewModel(factory: ViewModelProvider.Factory): T {
    return ViewModelProviders.of(this, factory)[T::class.java]
}

inline fun <reified T : ViewModel> Fragment.injectViewModel(factory: ViewModelProvider.Factory): T {
    return ViewModelProviders.of(this, factory)[T::class.java]
}