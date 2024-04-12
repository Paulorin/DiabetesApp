package ru.diabetes.composediabetestake2.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.diabetes.composediabetestake2.data.LineDao
import ru.diabetes.composediabetestake2.data.LineEvent
import ru.diabetes.composediabetestake2.data.LineState

// Constructor
//class LineViewModel(private val dao: LineDao): ViewModel() {
//    private val _state = MutableStateFlow(LineState())
//    private val _lines = dao.getLinesOrderedByDateAdded()
//
//    fun onEvent(event: LineEvent){
//        when(event){
//            is LineEvent.DelecteLine -> {
//                viewModelScope.launch {
//                    dao.deleteLine(event.line)
//                }
//            }
//            LineEvent.HideDialoh -> {
//                _state.update {
//                    it.copy(
//                        isAddingLine = false
//                    )
//                }
//            }
//            LineEvent.SaveLine -> {
//
//            }
//            is LineEvent.SetBoluse -> {
//                _state.update {
//                    it.copy(
//                        boluse = event.boluse
//                    )
//                }
//            }
//            is LineEvent.SetCarbs -> {
//                _state.update {
//                    it.copy(
//                        carbs = event.carbs
//                    )
//                }
//            }
//            is LineEvent.SetDateTime -> {
//                _state.update {
//                    it.copy(
//                        dateTime = event.addedDate
//                    )
//                }
//            }
//            is LineEvent.SetSuger -> {
//                _state.update {
//                    it.copy(
//                        suger = event.suger
//                    )
//                }
//            }
//            LineEvent.ShowDialog -> {
//                _state.update {
//                    it.copy(
//                        isAddingLine = true
//                    )
//                }
//            }
//            is LineEvent.UpdateLine -> TODO()
//        }
//    }
//}