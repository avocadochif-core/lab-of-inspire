package com.lab.of.inspire.view.ui.aspectRatioImageView

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

class AspectRatioImageView : AppCompatImageView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private var aspectRatio: Double = -1.0

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        if (aspectRatio == -1.0) return
        val width = measuredWidth
        val height = (width * aspectRatio).toInt()
        if (height == measuredHeight) return
        setMeasuredDimension(width, height)
    }

    fun setAspectRatio(width: Int?, height: Int?) {
        if (width != null && height != null) {
            aspectRatio = height.toDouble() / width.toDouble()
        }
    }
}