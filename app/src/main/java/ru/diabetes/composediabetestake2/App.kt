package ru.diabetes.composediabetestake2

import android.app.Application
import ru.diabetes.composediabetestake2.data.MainDatabase


/**
 * Класс содержит правила инициализации баыз данных
 */
class App : Application() {
    /**
     * lazy создает базу если ее нет, либо передает существующую базу
     */
    val database by lazy { MainDatabase.createDataBase(this) }

}