package ru.diabetes.composediabetestake2.ui.tmp.Navigation

// Sealed class allows only internal classes to inherite from Screen
// Or classes inside file
sealed class Screen(val route: String) {
    object MainScreen: Screen("main_screen")
    object DetailScreen: Screen("detail_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach {
                arg -> append("/$arg")
            }
        }
    }
}