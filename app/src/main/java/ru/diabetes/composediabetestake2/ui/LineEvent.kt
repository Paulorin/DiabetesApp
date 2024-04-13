package ru.diabetes.composediabetestake2.ui

import ru.diabetes.composediabetestake2.data.Line

sealed interface LineEvent {
    object SaveLine: LineEvent
    data class SetDate(val addedDate: String): LineEvent
    data class SetTime(val timeAdded: String): LineEvent
    data class SetSuger(val suger: String): LineEvent
    data class SetBoluse(val boluse: String): LineEvent
    data class SetCarbs(val carbs: String): LineEvent
    object ShowDialog: LineEvent
    object HideDialog: LineEvent
    data class DeleteLine(val line: Line): LineEvent
}