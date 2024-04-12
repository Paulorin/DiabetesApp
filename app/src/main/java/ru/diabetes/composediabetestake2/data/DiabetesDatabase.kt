package ru.diabetes.composediabetestake2.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Line::class],
    version = 1
)

abstract class DiabetesDatabase: RoomDatabase() {
    abstract val dao: LineDao
}