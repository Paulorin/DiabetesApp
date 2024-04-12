package ru.diabetes.composediabetestake2.data

sealed interface LineEvent {
    object SaveLine: LineEvent
    data class SetDateTime(val addedDate: Long): LineEvent
    data class SetSuger(val suger: Double): LineEvent
    data class SetBoluse(val boluse: Double): LineEvent
    data class SetCarbs(val carbs: Double): LineEvent
    object ShowDialog: LineEvent
    object HideDialoh: LineEvent
    data class DelecteLine(val line: Line): LineEvent
    data class UpdateLine(val line: Line): LineEvent
}