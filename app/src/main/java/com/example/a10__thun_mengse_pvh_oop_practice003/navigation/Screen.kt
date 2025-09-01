package com.example.a10__thun_mengse_pvh_oop_practice003.navigation

const val ROOT_GRAPH_ROUTE = "root"

const val AUTH_GRAPH_ROUTE = "auth"
sealed class Screen(val route: String, val title: String){
    object Splash : Screen("splash_screen", "splash")
    object Onboarding : Screen("home_screen", "home")
    object Login : Screen("home_screen", "home")
    object SignUp : Screen("home_screen", "home")
    object Home : Screen("home_screen", "home")
    object RootScaffold : Screen("Root_Scaffold", "Root")
}