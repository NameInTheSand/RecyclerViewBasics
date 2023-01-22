package com.example.recyclerview.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Sam Naduiev on 1/15/2023.
 */

private const val DEFAULT_OFFSET = 0

class SpacingDecoration(private val offset: Int) : RecyclerView.ItemDecoration() {

	override fun getItemOffsets(
		outRect: Rect,
		view: View,
		parent: RecyclerView,
		state: RecyclerView.State
	) {
		outRect.apply {
			top = if (parent.getChildAdapterPosition(view) == 0) offset else DEFAULT_OFFSET
			bottom = offset
		}
	}

}