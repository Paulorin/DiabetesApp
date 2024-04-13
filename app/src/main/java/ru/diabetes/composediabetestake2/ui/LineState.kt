package ru.diabetes.composediabetestake2.ui

import ru.diabetes.composediabetestake2.data.Line

data class LineState (
    val lines: List<Line> = emptyList(),
    val dateTime: Long = 0,
    val isAddingLine: Boolean = false,
)


