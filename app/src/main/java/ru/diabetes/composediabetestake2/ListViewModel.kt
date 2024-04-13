package ru.diabetes.composediabetestake2

import androidx.compose.runtime.MutableDoubleState
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.ExperimentalCoroutinesApi
import ru.diabetes.composediabetestake2.data.LineDao
import ru.diabetes.composediabetestake2.data.MainDatabase


@OptIn(ExperimentalCoroutinesApi::class)
class ListViewModel(database: MainDatabase): ViewModel() {
    val itemsList = database.dao.getLinesOrderedByDateAdded()


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