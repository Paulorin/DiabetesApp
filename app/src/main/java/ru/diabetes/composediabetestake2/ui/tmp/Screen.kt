package ru.diabetes.composediabetestake2.ui.tmp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun Screen(modifier: Modifier = Modifier){
    Column(Modifier.fillMaxSize())
    {
        Row(Modifier.weight(1f)){
            ScreenHalf(text = "Hello world!", backgroundColor = Color(0xFFEADDFF))
        }
        Row(Modifier.weight(10f)){
            ScreenHalf(text = "Goodbye world!", backgroundColor = Color(0xFFD0BCFF))
        }
    }

//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .fillMaxHeight(),
//        verticalArrangement = Arrangement.Bottom,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ){
//        Row(){
//            Text(
//                text = "-- Hello world!",
//                fontSize = 15.sp,
//                textAlign = TextAlign.Start,
//                modifier = Modifier
//                    .padding(end = 40.dp)
//                    .fillMaxWidth()
//                    .background(color = Color.Cyan)
//            )
//            Text(
//                text = "-- Goodbye World!",
//                fontSize = 15.sp,
//                textAlign = TextAlign.Start,
//                modifier = Modifier
//                    .padding(end = 40.dp)
//                    .fillMaxWidth()
//                    .background(color = Color.Cyan)
//            )
//        }
//    }
}
