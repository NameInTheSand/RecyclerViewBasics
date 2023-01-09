package com.example.recyclerview.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.LineItem
import com.example.recyclerview.databinding.ListItemEmployeBinding

/**
 * Created by Sam Naduiev on 1/8/2023.
 */
class EmployeeAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

	private val lineItems = mutableListOf<LineItem>()

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
		return EmployeeViewHolder(
			ListItemEmployeBinding.inflate(
				LayoutInflater.from(parent.context),
				parent,
				false
			)
		)
	}

	override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
		(holder as EmployeeViewHolder).bind(lineItems[position])
	}

	override fun getItemCount(): Int = lineItems.size

	@SuppressLint("NotifyDataSetChanged")
	fun setItems(newLineItems: List<LineItem>) {
		lineItems.apply {
			clear()
			addAll(newLineItems)
		}
		notifyDataSetChanged()
	}

	private class EmployeeViewHolder(
		private val binding: ListItemEmployeBinding
	) : RecyclerView.ViewHolder(binding.root) {

		fun bind(lineItem: LineItem) {
			binding.apply {
				tvName.text = lineItem.name
				tvSurname.text = lineItem.surname
				tvAge.text = lineItem.age.toString()
			}
		}

	}

}