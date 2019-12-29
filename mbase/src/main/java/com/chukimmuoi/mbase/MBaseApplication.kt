package com.chukimmuoi.mbase

import android.app.Application
import com.chukimmuoi.mbase.log.DebugTree
import com.chukimmuoi.mbase.log.ReleaseTree
import timber.log.Timber

/**
 * @author  : Chu Kim Muoi
 * @Skype   : chukimmuoi
 * @Mobile  : +84 373 672 505
 * @Email   : chukimmuoi@gmail.com
 * @Project : accesstrade
 * Created by chukimmuoi on 2019-11-23.
 */
open class MBaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        // Setup log.
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        } else {
            Timber.plant(ReleaseTree())
        }
    }
}