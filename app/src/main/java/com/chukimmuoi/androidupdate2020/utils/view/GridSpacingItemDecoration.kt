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
class GridSpacingItemDecoration(private val spanCount: Int,
                                private val spacing: Int,
                                private val includeEdge: Boolean = false)
    : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view)
        val column = position % spanCount

        if (includeEdge) {
            // spacing - column * ((1f / spanCount) * spacing)
            outRect.left = spacing - column * spacing / spanCount
            // (column + 1) * ((1f / spanCount) * spacing)
            outRect.right = (column + 1) * spacing / spanCount

            if (position < spanCount) { // top edge
                outRect.top = spacing
            }
            outRect.bottom = spacing // item bottom
        } else {
            // column * ((1f / spanCount) * spacing)
            outRect.left = column * spacing / spanCount
            // spacing - (column + 1) * ((1f /    spanCount) * spacing)
            outRect.right = spacing - (column + 1) * spacing / spanCount
            if (position >= spanCount) {
                outRect.top = spacing // item top
            }
        }
    }
}