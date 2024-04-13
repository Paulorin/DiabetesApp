package ru.diabetes.composediabetestake2.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.diabetes.composediabetestake2.ListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    mainViewModel: ListViewModel = viewModel(factory = ListViewModel.factory),
) {
    val state by mainViewModel.state.collectAsState()
    val onEvent = mainViewModel::onEvent

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text(text = "Diabets App")})},
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onEvent(LineEvent.ShowDialog)
                }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Добавить результат")
            }
        }
    ) {_ ->
        if (state.isAddingLine) {
            AddLineDialog(state = state, onEvent = onEvent)
        }
        Text("${state.dateAdded}", modifier = Modifier
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
            items(state.lines){ line->
                Card() {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text (
                            "${line.timeAdded}",
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                                .padding(10.dp)
                        )
                        Text (
                            "${line.suger}",
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                                .padding(10.dp)
                        )
                        Text (
                            "${line.boluse}",
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                                .padding(10.dp)
                        )
                        Text(
                            "${line.carbs}",
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                                .padding(10.dp)
                        )
                        IconButton(
                            onClick = {/*TODO - Implement edit*/}
                        ){
                            Icon(imageVector = Icons.Default.Edit, contentDescription = "Изменить")
                        }
                        IconButton(
                            onClick = {
                                onEvent(LineEvent.DeleteLine(line))
                            }) {
                            Icon(imageVector = Icons.Default.Delete, contentDescription = "Удаление")
                        }
                    }
                }
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