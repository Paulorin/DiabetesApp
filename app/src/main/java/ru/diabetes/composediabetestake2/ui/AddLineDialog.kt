package ru.diabetes.composediabetestake2.ui
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
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun AddContactDialog(
//    state: LineState,
//    onEvent: (LineEvent) -> Unit,
//    modifier: Modifier = Modifier
//) {
//    AlertDialog(
//        modifier = modifier,
//        onDismissRequest = {
//            onEvent(LineEvent.HideDialog)
//        },
//        title = { Text(text = "Add contact") },
//        text = {
//            Column(
//                verticalArrangement = Arrangement.spacedBy(8.dp)
//            ) {
//                TextField(
//                    value = state.dateTime,
//                    onValueChange = {
//                        onEvent(LineEvent.SetDateTime(it))
//                    },
//                    placeholder = {
//                        Text(text = "DateTime")
//                    }
//                )
//                TextField(
//                    value = state.suger,
//                    onValueChange = {
//                        onEvent(LineEvent.SetSuger(it))
//                    },
//                    placeholder = {
//                        Text(text = "Suger")
//                    }
//                )
//                TextField(
//                    value = state.boluse,
//                    onValueChange = {
//                        onEvent(LineEvent.SetBoluse(it))
//                    },
//                    placeholder = {
//                        Text(text = "Boluse")
//                    }
//                )
//            }
//        },
//        buttons = {
//            Box(
//                modifier = Modifier.fillMaxWidth(),
//                contentAlignment = Alignment.CenterEnd
//            ) {
//                Button(onClick = {
//                    onEvent(LineEvent.SaveLine)
//                }) {
//                    Text(text = "Save")
//                }
//            }
//        }
//    )
//}