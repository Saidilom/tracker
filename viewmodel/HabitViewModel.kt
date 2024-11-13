package com.example.trackerhabit.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.trackerhabit.database.HabitDatabase
import com.example.trackerhabit.model.Habit
import kotlinx.coroutines.launch

class HabitViewModel(application: Application) : AndroidViewModel(application) {
    private val habitDao = HabitDatabase.getDatabase(application).habitDao()

    fun addHabit(habit: Habit) {
        viewModelScope.launch {
            habitDao.insert(habit) // Добавление привычки в базу данных
        }
    }

    fun getAllHabits() = habitDao.getAllHabits() // Получение всех привычек из базы данных
}
