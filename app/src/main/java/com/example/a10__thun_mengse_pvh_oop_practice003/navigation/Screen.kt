package com.example.a10__thun_mengse_pvh_oop_practice003.navigation

const val ROOT_GRAPH_ROUTE = "root"

const val AUTH_GRAPH_ROUTE = "auth"
sealed class Screen(val route: String, val title: String){
    object Splash : Screen("splash_screen", "splash")
    object Onboarding : Screen("onboarding_screen", "onboarding")
    object Login : Screen("login_screen", "login")
    object SignUp : Screen("signup_screen", "signup")
    object Home : Screen("home_screen", "home")
    object RootScaffold : Screen("Root_Scaffold", "Root")

    object Explore : Screen("Explore_Screen", "Explore")
    object Cart : Screen("Cart_Screen", "Cart")
    object Favorite : Screen("Favorite_Screen", "Favorite")
    object Account : Screen("Account_Screen", "Account")
    object Beverage : Screen("Beverage_Screen", "Beverage")

}