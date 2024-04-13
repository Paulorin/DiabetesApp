package ru.diabetes.composediabetestake2.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "line")
data class Line (
    val dateAdded: String,
    val timeAdded: String,
    val suger: String,
    val boluse: String,
    val carbs: String,

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)