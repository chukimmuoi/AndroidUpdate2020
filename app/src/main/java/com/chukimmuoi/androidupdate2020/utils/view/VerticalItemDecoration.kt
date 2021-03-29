package com.chukimmuoi.androidupdate2020.utils.view

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @author  : Chu Kim Muoi
 * @Skype   : chukimmuoi
 * @Mobile  : +84 373 672 505
 * @Email   : chukimmuoi@gmail.com
 * @Project : AndroidUpdate2020
 * Created by chukimmuoi on 2019-12-30.
 */
class VerticalItemDecoration(private val margin: Int,
                             private val includeEdge: Boolean = false) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View,
                                parent: RecyclerView, state: RecyclerView.State) {
        with(outRect) {
            if (includeEdge && parent.getChildAdapterPosition(view) == 0) top = margin
            bottom = margin
        }
    }
}