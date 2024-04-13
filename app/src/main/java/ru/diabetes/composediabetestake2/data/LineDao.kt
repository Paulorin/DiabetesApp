package ru.diabetes.composediabetestake2.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface LineDao {
    @Upsert
    suspend fun upsertLine(line: Line)

    @Delete
    suspend fun deleteLine(line: Line)

    @Query("SELECT * FROM line")
    fun getLinesOrderedByDateAdded(): Flow<List<Line>>
}