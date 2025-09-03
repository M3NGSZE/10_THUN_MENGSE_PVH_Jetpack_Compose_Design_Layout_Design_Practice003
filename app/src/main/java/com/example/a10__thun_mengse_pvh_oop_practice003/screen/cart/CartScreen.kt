package com.example.a10__thun_mengse_pvh_oop_practice003.screen.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.example.a10__thun_mengse_pvh_oop_practice003.component.NectarButton

@Composable
fun CartScreen(navController: NavController){
    Column {
        TopbarGeneral("My Cart")
//        MyCartSection(navController)
        ConstraintButton(navController)
    }

}

@Composable
fun TopbarGeneral(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .drawBehind {
                val strokeWidth = 2.dp.toPx()
                val y = size.height - strokeWidth / 2
                drawLine(
                    color = Color(0xFFB2B2B2),
                    start = Offset(0f, y),
                    end = Offset(size.width, y),
                    strokeWidth = strokeWidth
                )
            },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(top = 20.dp, bottom = 40.dp)
        )
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
                bottom.linkTo(parent.bottom, margin = 24.dp) // <--- key change
                start.linkTo(parent.start, margin = 16.dp)
                end.linkTo(parent.end, margin = 16.dp)
                width = Dimension.fillToConstraints
        }
        ){
            NectarButton("Go to Checkout", navController, "",)
        }
    }
}