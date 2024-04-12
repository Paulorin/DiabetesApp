package ru.diabetes.composediabetestake2.ui.tmp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@Composable
fun TestDateTime(){
    val date = remember {
        // Current date
        //LocalDate.now()
        //.dayOfYear
        //.dayOfWeek
        //.dayOfMonth
        //.plusDays(13)

        // LocalTime.now()
//            .toNanoOfDay()
//            .minute
//            .second
//            .hour

        // Равно то, что нужно использовать для добавления даты и времени вручную
        // Преобразование типа из строки в число возможно при помощи .toIntOrNull() ?: -1
        // LocalDateTime.of(2022, 11, 1, 20, 14)
        //LocalDateTime.parse("2022-11-22")
//        ZonedDateTime.now()
//            .toEpochSecond() * 1000
//        ZonedDateTime.ofInstant(
//            Instant.ofEpochMilli(System.currentTimeMillis()),
//            ZoneId.systemDefault() // We can specify the time zone
//        )
        ZonedDateTime.now()
    }
    val formattedDateTime = remember {
        DateTimeFormatter.ofPattern("EEE dd MM yyyy HH:mm:ss")
            .format(date)
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = formattedDateTime.toString())
    }
}