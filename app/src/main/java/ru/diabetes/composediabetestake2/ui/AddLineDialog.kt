package ru.diabetes.composediabetestake2.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.datetime.time.timepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

//
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.material3.AlertDialog
//import androidx.compose.material3.Button
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import ru.diabetes.composediabetestake2.ui.LineEvent
//import ru.diabetes.composediabetestake2.ui.LineState

@Composable
fun AddLineDialog(
    state: LineState,
    onEvent: (LineEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        onDismissRequest = { onEvent(LineEvent.HideDialog)},
        modifier = Modifier.fillMaxWidth(),
        title = { Text(text = "Введите данные", fontSize = 25.sp) },
        text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row {
                    val dateDialogState = rememberMaterialDialogState()
                    val timeDialogState = rememberMaterialDialogState()
                    var pickedDate by remember{ mutableStateOf(LocalDate.now()) }
                    var pickedTime by remember{ mutableStateOf(LocalTime.now()) }

                    Column(){
                        Row(){
                            Text(text = "Нажмите для изменения:")
                            ClickableText(
                                text = AnnotatedString("$pickedDate"),
                                modifier = Modifier.padding(start = 8.dp),
                                onClick = {
                                    dateDialogState.show()
                                }
                            )
                        }
                        Row(){
                            Text(text = "Нажмите для изменения:",)
                            ClickableText(
                                text = AnnotatedString(DateTimeFormatter.ofPattern("hh:mm").format(pickedTime)),
                                modifier = Modifier.padding(start = 8.dp),
                                onClick = {
                                    timeDialogState.show()
                                }
                            )
                        }
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp)
                        ){
                            TextField(
                                value = state.suger,
                                onValueChange = {
                                    onEvent(LineEvent.SetSuger(it))
                                }
                            )
                            TextField(
                                value = state.boluse,
                                onValueChange = {
                                    onEvent(LineEvent.SetBoluse(it))
                                }
                            )
                            TextField(
                                value = state.carbs,
                                onValueChange = {
                                    onEvent(LineEvent.SetCarbs(it))
                                }
                            )
                        }
                    }

                    MaterialDialog(
                        dialogState = dateDialogState,
                        buttons = {
                            positiveButton(text = "Ok") {

                            }
                            negativeButton(text = "Cancel")
                        }
                    ) {
                        this.datepicker(
                            initialDate = LocalDate.now(),
                            title = "Pick a date",
                        ) {
                            pickedDate = it
                            onEvent(LineEvent.SetDate(pickedDate.toString()))
                        }
                    }
                    MaterialDialog(
                        dialogState = timeDialogState,
                        buttons = {
                            positiveButton(text = "Ok") {
                            }
                            negativeButton(text = "Cancel")
                        }
                        // backgroundColor =
                        // shape =
                        // onCloseRequest =
                    ) {
                        this.timepicker(
                            initialTime = LocalTime.NOON,
                            title = "Pick time",
                        ) {
                            pickedTime = it
                            onEvent(LineEvent.SetTime(DateTimeFormatter.ofPattern("hh:mm").format(pickedTime)))
                        }
                    }
                }

            }
        },
        confirmButton = {
            Box(
              modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Button(
                    onClick = {
                        onEvent(LineEvent.SaveLine)
                    }
                ) {
                    Text(text = "Добавить")
                }
            }
        }
    )
}