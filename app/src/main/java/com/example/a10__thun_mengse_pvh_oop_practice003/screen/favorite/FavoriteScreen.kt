package com.example.a10__thun_mengse_pvh_oop_practice003.screen.favorite

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Cancel
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.example.a10__thun_mengse_pvh_oop_practice003.R
import com.example.a10__thun_mengse_pvh_oop_practice003.component.CartItem
import com.example.a10__thun_mengse_pvh_oop_practice003.component.NectarButton
import com.example.a10__thun_mengse_pvh_oop_practice003.component.NormalButton
import com.example.a10__thun_mengse_pvh_oop_practice003.component.TopbarGeneral
import com.example.a10__thun_mengse_pvh_oop_practice003.navigation.Screen
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.exploreProduct.beverageItems

@Composable
fun FavoriteScreen(navController: NavController){
    Column {
        TopbarGeneral("Favorite")
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
            FavoriteSection(navController)
        }

        Column (
            modifier = Modifier.constrainAs(button) {
                bottom.linkTo(parent.bottom, margin = 24.dp) // <--- key change
                start.linkTo(parent.start, margin = 18.dp)
                end.linkTo(parent.end, margin = 18.dp)
                width = Dimension.fillToConstraints
            }
        ){
            NectarButton("Add All To Cart", navController, Screen.Cart.route)
        }
    }
}

@Composable
fun FailCheckout(text: String, navController: NavController){

    var showDialog by remember { mutableStateOf(false) }

    Button(
        onClick = {
            showDialog = true
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF53B175),
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Text(
            text = text,
            fontSize = 23.sp,
            fontWeight = FontWeight.W900
        )
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false }, // closes when tapped outside
            containerColor = Color.White,
            title = {
                IconButton(
                    onClick = {
                        showDialog = false
                    }
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Cancel,
                        contentDescription = "Cancel"
                    )
                }
            },
            text = {
                AlertImg(navController){ showDialog = false}
            },
            confirmButton = {}
        )
    }


}
@Composable
fun AlertImg(navController: NavController, onOff: (Boolean) -> Unit){
    Column (
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.fail_order),
            contentDescription = "",
            modifier = Modifier.size(200.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Something went terribly wrong.",
            color = Color.Gray,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

//        NectarButton("Please Try Again", navController, Screen.Favorite.route)
        NormalButton("Please Try Again", false) { it-> onOff(it) }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Back to Home",
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .clickable{
                    navController.navigate(Screen.Home.route)
                }
        )
    }
}


@Composable
fun FavoriteSection(navController: NavController){
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
    ){
        items(beverageItems, key = { item -> item.id}){
                it -> CartItem(it, navController, false)
        }
    }
}