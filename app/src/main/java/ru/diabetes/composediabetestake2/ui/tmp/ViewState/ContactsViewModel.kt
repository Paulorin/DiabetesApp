package ru.diabetes.composediabetestake2.ui.tmp.ViewState

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel


// Destroied only after different screen
class ContactsViewModel: ViewModel() {

    var backgroundColor by mutableStateOf(Color.White)
        private set

    fun changeBackgroundColor(isSwiched: Boolean ) {
        backgroundColor = if(isSwiched) Color.White else Color.Red
    }
}