package com.example.a10__thun_mengse_pvh_oop_practice003.screen.cart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.example.a10__thun_mengse_pvh_oop_practice003.component.NectarButton
import com.example.a10__thun_mengse_pvh_oop_practice003.component.TopbarGeneral

@Composable
fun CartScreen(navController: NavController){
    Column {
        TopbarGeneral("My Cart")
//        MyCartSection(navController)
        ConstraintButton(navController)
    }

}

@Composable
fun ConstraintButton(navController: NavController){
    ConstraintLayout (
        modifier = Modifier
            .fillMaxSize()
    ){
        val (cart, button) = createRefs()

        Column (
            modifier = Modifier.constrainAs(cart) {
                top.linkTo(parent.top)
            }
        ){
            MyCartSection(navController)
        }

        Column (
            modifier = Modifier.constrainAs(button) {
                bottom.linkTo(parent.bottom, margin = 26.dp) // <--- key change
                start.linkTo(parent.start, margin = 18.dp)
                end.linkTo(parent.end, margin = 18.dp)
                width = Dimension.fillToConstraints
        }
        ){
            NectarButton("Go to Checkout", navController, "")
        }
    }
}