package ru.diabetes.composediabetestake2.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Line (
    val dateAdded: Long,
    val suger: Double,
    val boluse: Double,
    val carbs: Double,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)