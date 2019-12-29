package com.chukimmuoi.mbase.log

import android.util.Log
import timber.log.Timber

/**
 * @author  : Chu Kim Muoi
 * @Skype   : chukimmuoi
 * @Mobile  : +84 373 672 505
 * @Email   : chukimmuoi@gmail.com
 * @Project : accesstrade
 * Created by chukimmuoi on 2019-11-10.
 */
class ReleaseTree : Timber.Tree() {

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) return

        //FakeCrashLibrary.log(priority, tag, message)

        if (t != null) {
            if (priority == Log.ERROR) {
                //FakeCrashLibrary.logError(t)
            } else if (priority == Log.WARN) {
                //FakeCrashLibrary.logWarning(t)
            }
        }
    }
}