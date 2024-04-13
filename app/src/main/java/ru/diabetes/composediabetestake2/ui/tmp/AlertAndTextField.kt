package ru.diabetes.composediabetestake2.ui.tmp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp

@Composable
fun TextFieldTest(){
    val message = remember{ mutableStateOf("") }

    Column {
        Text(message.value, fontSize = 28.sp)
        TextField(
            value = message.value,
            textStyle = TextStyle(fontSize=25.sp),
            onValueChange = {newText -> message.value = newText},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            leadingIcon = { Icon(Icons.Filled.Create, contentDescription = "Проверено") }
        )
    }
}

@Composable
fun AlertTest(){
    val openDialog = remember { mutableStateOf(false) }
    Button({ openDialog.value = true }) {
        Text("Удалить", fontSize = 22.sp)
    }
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false},
            title = { Text(text = "Подтверждение действия") },
            text = { Text("Вы действительно хотите удалить выбранный элемент?") },
            confirmButton = {
                Button({ openDialog.value = false }) {
                    Text("OK", fontSize = 22.sp)
                }
            }
        )
    }
}