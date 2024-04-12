package ru.diabetes.composediabetestake2.data

data class LineState (
    val lines: List<Line> = emptyList(),
    val dateTime: Long,
    val suger: Double,
    val boluse: Double,
    val carbs: Double,
    val isAddingLine: Boolean = false,
)


