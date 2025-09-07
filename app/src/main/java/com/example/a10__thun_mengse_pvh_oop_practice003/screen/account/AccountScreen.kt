package com.example.a10__thun_mengse_pvh_oop_practice003.screen.account

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Logout
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.example.a10__thun_mengse_pvh_oop_practice003.navigation.Screen

@Composable
fun AccountScreen(navController: NavController){
    Column {
        TopBarAcc(navController)
        AccountMenuSection(navController)

//        AccountConstraint(navController)
    }
}

@Composable
fun AccountConstraint(navController: NavController){
    ConstraintLayout (
        modifier = Modifier
            .fillMaxSize()
    ){
        val (menu, button) = createRefs()

        Column (
            modifier = Modifier.constrainAs(menu) {
                top.linkTo(parent.top)
            }
        ){
            AccountMenuSection(navController)
        }

        Column (
            modifier = Modifier.constrainAs(button) {
                bottom.linkTo(parent.bottom, margin = 24.dp) // <--- key change
                start.linkTo(parent.start, margin = 18.dp)
                end.linkTo(parent.end, margin = 18.dp)
                width = Dimension.fillToConstraints
            }
        ){
            AccountButton(
                text = "Log Out",
                navController = navController,
                screenName = Screen.Login.route,
            )
        }

    }
}

@Composable
fun AccountButton(
    text: String,
    navController: NavController,
    screenName: String,
){
    Button(
        onClick = {
            if (screenName != ""){
                navController.navigate(screenName)
            }
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0x67D5D4D4),
            contentColor = Color(0xFF53B175),
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Icon(
                imageVector = Icons.Rounded.Logout,
                contentDescription = "Log out",
            )

            Text(
                text = text,
                fontSize = 23.sp,
                fontWeight = FontWeight.W900
            )

            Text(
                text = "",
            )
        }


    }
}