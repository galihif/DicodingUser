package com.giftech.dicodinguser.ui.navigation


sealed class Screen(val route: String) {
    object Home : Screen("home")
    object DetailUser : Screen("detail/{userId}") {
        fun createRoute(userId: Long) = "detail/$userId"
    }
    object Aboout : Screen("about")
}