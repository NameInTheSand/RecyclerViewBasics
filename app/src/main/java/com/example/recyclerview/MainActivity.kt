package com.example.recyclerview

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.recyclerview.adapters.EmployeeAdapter
import com.example.recyclerview.databinding.ActivityMainBinding
import com.example.recyclerview.utils.SpacingDecoration
import com.example.recyclerview.utils.addEmptyListObserver

private const val OFFSET = 15

class MainActivity : AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding
	private lateinit var employeeAdapter: EmployeeAdapter
	private val names: List<String> = listOf("John", "James", "Sam", "Peter", "Mike")
	private val surnames: List<String> = listOf("Johnson", "Jameson", "Samson", "Peterson", "Wall")


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		employeeAdapter = EmployeeAdapter()
		initRecyclerView()
		setItems()
	}

	private fun initRecyclerView() {
		binding.apply {
			rvEmployees.apply {
				adapter = employeeAdapter.also {
					it.addEmptyListObserver(tvNoData)
				}
				addItemDecoration(SpacingDecoration(OFFSET))
			}
		}
	}

	private fun setItems() {
		Handler(Looper.getMainLooper()).postDelayed(
			{
				employeeAdapter.setItems(generateRandomItems())
				binding.apply {
					progressBar.isVisible = false
				}
			},
			5000L
		)
	}

	private fun generateRandomItems(): List<LineItem> {
		val lineItems = mutableListOf<LineItem>()
		for (i in 0..20) {
			lineItems.add(
				LineItem(id = i, name = names[i % 5], surname = surnames[i % 5], age = i)
			)
		}
		return lineItems
	}

}

data class LineItem(
	val id: Int,
	val name: String,
	val surname: String,
	val age: Int
)