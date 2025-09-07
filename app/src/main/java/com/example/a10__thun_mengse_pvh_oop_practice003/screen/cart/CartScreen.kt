package com.example.a10__thun_mengse_pvh_oop_practice003.screen.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Cancel
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.example.a10__thun_mengse_pvh_oop_practice003.R
import com.example.a10__thun_mengse_pvh_oop_practice003.component.NectarButton
import com.example.a10__thun_mengse_pvh_oop_practice003.component.TopbarGeneral
import com.example.a10__thun_mengse_pvh_oop_practice003.navigation.Screen

@Composable
fun CartScreen(navController: NavController){

    var isShow by remember { mutableStateOf(false) }

    Column {

        TopbarGeneral("My Cart")
//        MyCartSection(navController)
        ConstraintButton(navController){
            isShow = it
        }

        ShowCheckout(isShow, navController) {
            isShow = it
        }
    }

}

@Composable
fun ConstraintButton(navController: NavController, getShow: (Boolean)-> Unit) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (cart, button) = createRefs()

        Column(
            modifier = Modifier.constrainAs(cart) {
                top.linkTo(parent.top)
            }
        ) {
            MyCartSection(navController)
        }

        Column(
            modifier = Modifier.constrainAs(button) {
                bottom.linkTo(parent.bottom, margin = 26.dp) // <--- key change
                start.linkTo(parent.start, margin = 18.dp)
                end.linkTo(parent.end, margin = 18.dp)
                width = Dimension.fillToConstraints
            }
        ) {
            CheckoutButton(
                text = "Go to Checkout",
                12.97
            ){
                getShow(it)
            }
        }
    }
}

@Composable
fun CheckoutButton(
    text: String,
    total: Double,
    getShow: (Boolean) -> Unit
){
    Button(
        onClick = {
            getShow(true)
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF53B175),
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "$ ${total}",
                color = Color(0xFF53B074),
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .padding(5.dp)
            )

            Text(
                text = text,
                fontSize = 20.sp,
                fontWeight = FontWeight.W900
            )

            Text(
                text = "$ ${total}",
                color = Color.White,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF489D67))
                    .padding(5.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowCheckout(isSheet: Boolean, navController: NavController, getSheet : (Boolean) -> Unit){
    var showSheet = isSheet
    val sheetState = rememberModalBottomSheetState()
    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                showSheet = false
                getSheet(showSheet)
            },
            sheetState = sheetState,
            dragHandle = null,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(75.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Checkout",
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Icon(
                        imageVector = Icons.Rounded.Cancel,
                        contentDescription = "Close bottom sheet",
                        modifier = Modifier
                            .clickable{
                                showSheet = false
                                getSheet(showSheet)
                            }
                    )
                }

                CheckoutRow("Delivery", "Select Method")

                CheckoutRow("Payment", "", true, R.drawable.payment)

                CheckoutRow("Promo Code", "Pick Method")

                CheckoutRow("Total Cost", "$13.97")

                OrderButton(navController)

            }
        }
    }
}

@Composable
fun OrderButton(navController: NavController){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .drawBehind {
                val strokeWidth = 0.3.dp.toPx()
                drawLine(
                    color = Color.Gray,
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    strokeWidth = strokeWidth
                )
            }
            .padding(top = 16.dp, bottom = 16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ){

        Text(
            text = "By placing an order you agree to our",
            fontSize = 15.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row {
            Text(
                text = "Term",
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.clickable{}
            )

            Text(
                text = " and",
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Gray,
            )

            Text(
                text = " Condition",
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.clickable{}
            )
        }

        Spacer(modifier = Modifier.height(23.dp))

        NectarButton("Place Order", navController, Screen.Accept.route)
    }
}


@Composable
fun CheckoutRow(title: String, des: String = "", isImg: Boolean = false, img: Int = 0){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .drawBehind {
                val strokeWidth = 0.3.dp.toPx()
                drawLine(
                    color = Color.Gray,
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    strokeWidth = strokeWidth
                )
            }
            .padding(top = 16.dp, bottom = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Gray
        )

        Row (
            verticalAlignment = Alignment.CenterVertically
        ){

            if (isImg){
                Image(
                    painter = painterResource(img),
                    contentDescription = "payment"
                )
            } else {
                Text(
                    text = des,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                )
            }

            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowRight,
                    contentDescription = "Arrow right"
                )
            }
        }
    }
}