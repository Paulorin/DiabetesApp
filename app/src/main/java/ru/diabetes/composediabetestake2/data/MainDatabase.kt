package ru.diabetes.composediabetestake2.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [Line::class],
    version = 2
)
@TypeConverters(DateConverter::class)
abstract class MainDatabase: RoomDatabase() {
    abstract val dao: LineDao

    companion object {
        fun createDataBase(context: Context): MainDatabase {
            return Room.databaseBuilder(
                context,
                MainDatabase::class.java,
                "MainDatabase.db"
            ).build()
        }
    }
}