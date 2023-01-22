package com.example.recyclerview.utils

import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Sam Naduiev on 1/22/2023.
 */


fun RecyclerView.Adapter<RecyclerView.ViewHolder>.addEmptyListObserver(tvNoData: TextView) {

	tvNoData.isVisible = this@addEmptyListObserver.itemCount == 0

	this.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {
		override fun onChanged() {
			tvNoData.isVisible = this@addEmptyListObserver.itemCount == 0
		}
	})

}