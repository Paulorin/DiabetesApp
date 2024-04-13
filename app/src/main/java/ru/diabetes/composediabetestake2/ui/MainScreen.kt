package ru.diabetes.composediabetestake2.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    //mainViewModel: ListViewModel = viewModel(factory = ListViewModel.factory)
){
    //val itemsList = mainViewModel.itemsList.collectAsState(initial = emptyList())

    var openDialog = remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text(text = "Diabets App")})},
        floatingActionButton = {
            FloatingActionButton(onClick = { openDialog.value = true/*TODO - Вызов добавления*/ }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Добавить результат")
            }
        }
    ) {_ ->
        if (openDialog.value) {
            AlertDialog(
                onDismissRequest = { openDialog.value = false},
                modifier = Modifier.fillMaxWidth(),
                title = { Text(text = "Введите данные", fontSize = 25.sp) },
                text = {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row {
                            val dateDialogState = rememberMaterialDialogState()
                            val timeDialogState = rememberMaterialDialogState()
                            var pickedDate by remember{ mutableStateOf(LocalDate.now())}
                            var pickedTime by remember{ mutableStateOf(LocalTime.now())}

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
                                    TextField(value = "Сахар", onValueChange = {})
                                    TextField(value = "Укол", onValueChange = {})
                                    TextField(value = "Углеводы", onValueChange = {})
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
                                }
                            }
                        }
//                        val dateDialogState = rememberMaterialDialogState()
//                        IconButton(onClick = { dateDialogState.show() }) {
//                            Icon(imageVector = Icons.Default.DateRange, contentDescription = "Открыть календарь")
//                        }
//                        TextField(
//                            value = "Дата и время",//state.firstName,
//                            onValueChange = {
//                                //onEvent(ContactEvent.SetFirstName(it))
//                            },
//                            placeholder = {
//                                Text(text = "First name")
//                            }
//                        )

                    }
                },
                confirmButton = {
                    Button({ openDialog.value = false }) {
                        Text("Сохранить", fontSize = 15.sp)
                    }
                }
            )
        }
        Text("Выбор даты", modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, top = 70.dp))
        LazyColumn(
            contentPadding = PaddingValues(10.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 90.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
//            items(itemsList.value) {
//                ListItem()
//            }
            items(6){
                ListItem()
            }
        }

    }
}

@Composable
fun ListItem(){
    Card() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text (
                "Время",
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(10.dp)
            )
            Text (
                "Сахар",
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(10.dp)
            )
            Text (
                "Укол",
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(10.dp)
            )
            Text(
                "ХЕ",
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(10.dp)
            )
            IconButton(
                onClick = {/*TODO*/}
            ){
                Icon(imageVector = Icons.Default.Edit, contentDescription = "Изменить")
            }
            IconButton(
                onClick = { /*TODO*/

                }) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "Удаление")
            }
        }
    }
}


//Row(
//                        modifier = Modifier.fillMaxWidth()
//                    ) {
//                        Column(
//                            modifier = Modifier.weight(1f)
//                        ) {
//                            Text(
//                                text = "firstpart secondpart",
//                                fontSize = 20.sp
//                            )
//                            Text(text = "thirdpart", fontSize = 12.sp)
//                        }
//                        IconButton(onClick = {
//                            /*onEvent(ContactEvent.DeleteContact(contact))*/
//                        }) {
//                            Icon(
//                                imageVector = Icons.Default.Delete,
//                                contentDescription = "Delete contact"
//                            )
//                        }