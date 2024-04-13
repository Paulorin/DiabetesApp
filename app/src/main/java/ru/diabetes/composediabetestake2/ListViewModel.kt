package ru.diabetes.composediabetestake2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.diabetes.composediabetestake2.data.Line
import ru.diabetes.composediabetestake2.data.MainDatabase
import ru.diabetes.composediabetestake2.ui.LineEvent
import ru.diabetes.composediabetestake2.ui.LineState


@OptIn(ExperimentalCoroutinesApi::class)
class ListViewModel(database: MainDatabase): ViewModel() {
    private val dao = database.dao
    private val lines = database.dao.getLinesOrderedByDateAdded()
    private val _state = MutableStateFlow(LineState())
    val state = combine(_state, lines) { state, lines ->
        state.copy (
            lines = lines
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), LineState())

    /**
     * Создаем фабрику для создания класса ViewModel с конструктором
     */
    companion object {
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                val database = (checkNotNull(extras[APPLICATION_KEY]) as App).database
                return ListViewModel(database) as T
            }
        }
    }

    fun onEvent(event: LineEvent) {
        when(event) {
            is LineEvent.HideDialog -> {
                _state.update { it.copy(
                    isAddingLine = false
                )}
            }
            is LineEvent.ShowDialog -> {
                _state.update { it.copy (
                    isAddingLine = true
                )}
            }
            is LineEvent.SaveLine -> {
                val dateAdded = state.value.dateAdded
                val timeAdded = state.value.timeAdded
                val suger = state.value.suger
                val boluse = state.value.boluse
                val carbs = state.value.carbs

                val line = Line(
                    dateAdded = dateAdded,
                    timeAdded = timeAdded,
                    suger = suger,
                    boluse = boluse,
                    carbs = carbs
                )
                /**
                 * Добавление строки в базу
                 */
                viewModelScope.launch {
                    dao.upsertLine(line)
                }
                _state.update {
                    it.copy(
                        isAddingLine = false,
                        dateAdded = "",
                        timeAdded = "",
                        suger = "",
                        boluse = "",
                        carbs = ""
                    )
                }
            }

            is LineEvent.SetBoluse -> {
                _state.update {
                    it.copy(
                        boluse = event.boluse
                    )
                }
            }
            is LineEvent.SetCarbs -> {
                _state.update {
                    it.copy(
                        carbs = event.carbs
                    )
                }
            }
            is LineEvent.SetDate -> {
                _state.update {
                    it.copy(
                        dateAdded = event.addedDate
                    )
                }
            }
            is LineEvent.SetSuger -> {
                _state.update {
                    it.copy(
                        suger = event.suger
                    )
                }
            }
            is LineEvent.SetTime -> {
                _state.update {
                    it.copy (
                        timeAdded = event.timeAdded
                    )
                }
            }

            is LineEvent.DeleteLine -> {
                viewModelScope.launch {
                    dao.deleteLine(event.line)
                }
            }
        }
    }

}

//class LineViewModel(private val dao: LineDao): ViewModel() {
//    private val _lines = dao.getLinesOrderedByDateAdded()
//
//    private val _state = MutableStateFlow(LineState())
//    val state = combine(_state, _lines) { state, lines ->
//        state.copy(
//            lines = lines,
//        )
//    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), LineState())
//
//    fun onEvent(event: LineEvent){
//        when(event){
//            LineEvent.SaveLine -> TODO()
//            is LineEvent.SetDateTime -> TODO()
//        }
//    }
//}