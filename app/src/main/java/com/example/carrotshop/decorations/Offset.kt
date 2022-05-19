package com.example.carrotshop.decorations

import android.graphics.Rect
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotshop.R

class Offset : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView) {
        val aSide = parent.context.resources.getDimension(R.dimen.dp10).toInt()
        outRect.set(aSide,aSide,aSide,aSide)
    }
}