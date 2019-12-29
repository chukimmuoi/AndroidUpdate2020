package com.chukimmuoi.mbase.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.drakeet.support.toast.ToastCompat
import timber.log.Timber

/**
 * @author  : Chu Kim Muoi
 * @Skype   : chukimmuoi
 * @Mobile  : +84 373 672 505
 * @Email   : chukimmuoi@gmail.com
 * @Project : accesstrade
 * Created by chukimmuoi on 2019-11-10.
 */
open class BaseActivity : AppCompatActivity() {

    var baseToast: ToastCompat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.i("onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        Timber.i("onStart")
        super.onStart()
    }

    override fun onResume() {
        Timber.i("onResume")
        super.onResume()
    }

    override fun onPause() {
        Timber.i("onPause")
        super.onPause()
    }

    override fun onStop() {
        Timber.i("onStop")
        super.onStop()
    }

    override fun onRestart() {
        Timber.i("onRestart")
        super.onRestart()
    }

    override fun onDestroy() {
        Timber.i("onDestroy")
        baseToast = null

        super.onDestroy()
    }
}