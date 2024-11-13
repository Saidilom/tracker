package com.example.trackerhabit.ui


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.trackerhabit.model.Habit

class HabitAdapter : ListAdapter<Habit, HabitAdapter.HabitViewHolder>(HabitDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val binding = HabitItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HabitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HabitViewHolder, position: Int) {
        val habit = getItem(position)
        holder.bind(habit)
    }

    inner class HabitViewHolder(private val binding: HabitItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(habit: Habit) {
            binding.habit = habit
            binding.executePendingBindings()
        }
    }

    class HabitDiffCallback : androidx.recyclerview.widget.DiffUtil.ItemCallback<Habit>() {
        override fun areItemsTheSame(oldItem: Habit, newItem: Habit): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Habit, newItem: Habit): Boolean {
            return oldItem == newItem
        }
    }
}

class HabitItemBinding {
    fun executePendingBindings() {
        TODO("Not yet implemented")
    }

    lateinit var habit: Habit
    val root: View
        get() {
            TODO()
        }

    companion object {
        fun inflate(from: LayoutInflater?, parent: ViewGroup, b: Boolean): HabitItemBinding {
            TODO("Not yet implemented")
        }
    }

}
