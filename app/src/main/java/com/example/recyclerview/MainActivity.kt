package com.example.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerview.adapters.EmployeeAdapter
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding
	private val names: List<String> = listOf("John", "James", "Sam", "Peter", "Mike")
	private val surnames: List<String> = listOf("Johnson", "Jameson", "Samson", "Peterson", "Wall")


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		initRecyclerView()
	}

	private fun initRecyclerView() {
		binding.rvEmployees.adapter = EmployeeAdapter().also {
			it.setItems(generateRandomItems())
		}

	}

	private fun generateRandomItems(): List<LineItem> {
		val lineItems = mutableListOf<LineItem>()
		for (i in 0..20) {
			lineItems.add(
				LineItem(names[i % 5], surnames[i % 5], i)
			)
		}
		return lineItems
	}

}

data class LineItem(
	val name: String,
	val surname: String,
	val age: Int
)