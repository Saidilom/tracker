package com.example.trackerhabit.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.trackerhabit.model.Habit

@Dao
interface HabitDao {
    // С использованием корутин для вставки данных
    @Insert
    suspend fun insert(habit: Habit)

    @Query("SELECT * FROM habit_table")
    fun getAllHabits(): LiveData<List<Habit>>
}
