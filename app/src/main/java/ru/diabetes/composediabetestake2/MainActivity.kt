package ru.diabetes.composediabetestake2

//import ru.diabetes.composediabetestake2.ui.LineViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ru.diabetes.composediabetestake2.ui.MainScreen
import ru.diabetes.composediabetestake2.ui.theme.ComposeDiabetesTake2Theme
import ru.diabetes.composediabetestake2.ui.tmp.AlertTest


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }

//    @Preview(showBackground = true, showSystemUi = true)
//    @Composable
//    fun Screen() {
//        ComposeDiabetesTake2Theme {
//            MainScreen()
//        }
//    }
}
