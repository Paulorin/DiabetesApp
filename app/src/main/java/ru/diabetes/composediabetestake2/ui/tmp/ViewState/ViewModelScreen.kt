package ru.diabetes.composediabetestake2.ui.tmp.ViewState

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Screeeeen(isSwiched: Boolean = false){
    val viewModel = viewModel<ContactsViewModel>()

    Surface (
        modifier = Modifier.fillMaxSize(),
        color = viewModel.backgroundColor
    ) {
        Button (onClick = {
            viewModel.changeBackgroundColor(isSwiched = isSwiched)
           //isSwiched = true
        }) {
            Text(text = "Change color")
        }
    }
}