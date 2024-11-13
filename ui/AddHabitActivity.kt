package com.example.trackerhabit.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.trackerhabit.R
import com.example.trackerhabit.model.Habit
import com.example.trackerhabit.viewmodel.HabitViewModel
import kotlin.properties.ReadOnlyProperty


class AddHabitActivity : AppCompatActivity() {
    private val habitViewModel: HabitViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_habit)

        val habitNameEditText: EditText = findViewById(R.id.editTextHabitName)
        val habitDescriptionEditText: EditText = findViewById(R.id.editTextHabitDescription)
        val saveButton: Button = findViewById(R.id.buttonSaveHabit)

        saveButton.setOnClickListener {
            val name = habitNameEditText.text.toString()
            val description = habitDescriptionEditText.text.toString()

            if (name.isNotBlank() && description.isNotBlank()) {
                // Не передаем id, он будет сгенерирован автоматически
                val habit = Habit(
                    name = name,
                    description = description
                )

                habitViewModel.addHabit(habit)
                Toast.makeText(this, "Привычка сохранена", Toast.LENGTH_SHORT).show()
                finish() // Закрытие активити после сохранения
            } else {
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
