package ru.diabetes.composediabetestake2.ui

sealed interface LineEvent {
    object SaveLine: LineEvent
    data class SetDateTime(val addedDate: Long): LineEvent
    object ShowDialog: LineEvent
    object HideDialog: LineEvent

}