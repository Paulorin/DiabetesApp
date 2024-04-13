package ru.diabetes.composediabetestake2.ui

import ru.diabetes.composediabetestake2.data.Line

data class LineState (
    val lines: List<Line> = emptyList(),
    val dateAdded: String = "",
    val timeAdded: String = "",
    val suger: String = "",
    val boluse: String = "",
    val carbs: String = "",
    val isAddingLine: Boolean = false,
)


