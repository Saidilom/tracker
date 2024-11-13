package com.example.trackerhabit.ui


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trackerhabit.R
import com.example.trackerhabit.viewmodel.HabitViewModel
import kotlin.properties.ReadOnlyProperty

class MainActivity : AppCompatActivity() {
    private val habitViewModel: HabitViewModel by viewModels()

    private fun viewModels(): ReadOnlyProperty<MainActivity, HabitViewModel> {
        TODO("Not yet implemented")
    }

    private lateinit var habitAdapter: HabitAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Настройка RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        habitAdapter = HabitAdapter()
        recyclerView.adapter = habitAdapter

        // Подписка на изменения данных
        habitViewModel.getAllHabits().observe(this, Observer { habits ->
            habits?.let {
                habitAdapter.submitList(it)
            }
        })

        // Кнопка для добавления новой привычки
        findViewById<Button>(R.id.buttonAddHabit).setOnClickListener {
            startActivity(Intent(this, AddHabitActivity::class.java))
        }
    }
}

