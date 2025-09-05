package com.example.a10__thun_mengse_pvh_oop_practice003.screen.account

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun AccountScreen(navController: NavController){
    Column {
        TopBarAcc(navController)
        AccountMenuSection(navController)
    }
}