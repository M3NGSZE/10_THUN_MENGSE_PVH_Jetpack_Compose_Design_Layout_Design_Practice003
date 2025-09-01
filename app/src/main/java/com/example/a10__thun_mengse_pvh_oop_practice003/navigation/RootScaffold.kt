package com.example.a10__thun_mengse_pvh_oop_practice003.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.a10__thun_mengse_pvh_oop_practice003.component.NectarBottomBar
import com.example.a10__thun_mengse_pvh_oop_practice003.navigation.rootNavGraph

@Composable
fun RootScaffold(navController: NavHostController){
    Scaffold (
        bottomBar = {
            NectarBottomBar()
        }
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(paddingValues = innerPadding),
            startDestination = ROOT_GRAPH_ROUTE,
            navController = navController,
        ){
            rootNavGraph(navController = navController)
//            authNavGraph(navController = navController)
        }

    }
}