package com.lab.of.inspire.view.recyclerview.decorator

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lab.of.inspire.utils.DimensionUtils

/**
 * @param spaceFirstLast -> margin from top side of first item and bottom side of last item in recyclerView
 * @param spaceBetweenItems -> margin between items in recyclerView
 */
class VerticalItemDecorator(private val spaceFirstLast: Int, private val spaceBetweenItems: Int): RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = (view.layoutParams as RecyclerView.LayoutParams).viewAdapterPosition
        val countOfItems = parent.layoutManager?.itemCount
        val spaceFirstLast = DimensionUtils.pxToDp(spaceFirstLast).toInt()
        val spaceBetweenItems = DimensionUtils.pxToDp(spaceBetweenItems).toInt()

        //top & bottom space
        countOfItems?.let {
            when (position) {
                0 -> {
                    outRect.top = spaceFirstLast
                    outRect.bottom = spaceBetweenItems / 2
                }
                countOfItems - 1 -> {
                    outRect.top = spaceBetweenItems / 2
                    outRect.bottom = spaceFirstLast
                }
                else -> {
                    outRect.top = spaceBetweenItems / 2
                    outRect.bottom = spaceBetweenItems / 2
                }
            }
        }

        //left & right space
        outRect.left = 0
        outRect.right = 0
    }

}