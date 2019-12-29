package com.chukimmuoi.mbase.extensions

import android.content.res.Resources

/**
 * @author  : Chu Kim Muoi
 * @Skype   : chukimmuoi
 * @Mobile  : +84 373 672 505
 * @Email   : chukimmuoi@gmail.com
 * @Project : accesstrade
 * Created by chukimmuoi on 2019-11-24.
 */
// https://stackoverflow.com/questions/4605527/converting-pixels-to-dp#12147550

/**
 * Converts a pixel value to a density independent pixels (DPs).
 *
 * @param resources A reference to the [Resources] in the current context.
 * @return The value of {@code pixels} in DPs.
 */
fun Float.convertPixelToDp(resources: Resources) : Float {
    return this / resources.displayMetrics.density
}

/**
 * Converts a density independent pixels (DPs) value to a pixel.
 *
 * @param resources A reference to the [Resources] in the current context.
 * @return The value of {@code Dps} in pixels.
 */
fun Float.convertDpToPixel(resources: Resources) : Float {
    return this * resources.displayMetrics.density
}

/**
 * Converts a pixel value to a density independent pixels (DPs).
 *
 * @param resources A reference to the [Resources] in the current context.
 * @return The value of {@code pixels} in DPs.
 */
fun Int.convertPixelToDp(resources: Resources) : Int {
    return Math.round(this / resources.displayMetrics.density)
}

/**
 * Converts a density independent pixels (DPs) value to a pixel.
 *
 * @param resources A reference to the [Resources] in the current context.
 * @return The value of {@code Dps} in pixels.
 */
fun Int.convertDpToPixel(resources: Resources) : Int{
    return Math.round(this * resources.displayMetrics.density)
}

fun Int.getCountAndSpaceInGrid(resources: Resources, percent: Float) : Pair<Int, Int> {
    var output = Pair(0, 0)
    try {
        val widthFullScreen = resources.displayMetrics.widthPixels
        val widthUseCalculator = widthFullScreen * percent
        val spanCount = (widthUseCalculator / this).toInt()
        val space = ((widthUseCalculator - spanCount * this) / (spanCount + 1) / 2).toInt()
        output = Pair(spanCount, space)
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return output
}