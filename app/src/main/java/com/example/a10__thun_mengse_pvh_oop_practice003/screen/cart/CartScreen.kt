package com.example.a10__thun_mengse_pvh_oop_practice003.screen.cart

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Cancel
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
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
import com.example.a10__thun_mengse_pvh_oop_practice003.component.NormalButton
import com.example.a10__thun_mengse_pvh_oop_practice003.component.TopbarGeneral
import com.example.a10__thun_mengse_pvh_oop_practice003.navigation.Screen
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.favorite.AlertImg
import kotlin.random.Random

@Composable
fun CartScreen(navController: NavController){

    var isShow by remember { mutableStateOf(false) }


    Column {
//        var olo: Boolean? by remember { mutableStateOf(null) }
//
//        if (olo == true){
//            Text("olo 1")
//            olo = null
//        }else if (olo == false){
//            Text("olo 2")
//            olo = null
//        }
//
//        Button(
//            onClick = {
//                olo = Random.nextBoolean()
//            }
//        ) {
//            Text("click here")
//        }

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
fun ConstraintButton1(navController: NavController, getShow: (Boolean) -> Unit) {
    val listState = rememberLazyListState()
    val showButton = remember { mutableStateOf(true) } // visible at top initially

    // previous values to detect direction
    val prevIndex = remember { mutableStateOf(0) }
    val prevOffset = remember { mutableStateOf(0) }

    // Listen to the listState changes safely with snapshotFlow
    LaunchedEffect (listState) {
        snapshotFlow { listState.firstVisibleItemIndex to listState.firstVisibleItemScrollOffset }
            .collect { (index, offset) ->
                val scrollingUp = if (index != prevIndex.value) {
                    index < prevIndex.value
                } else {
                    offset < prevOffset.value
                }

                prevIndex.value = index
                prevOffset.value = offset

                val visible = scrollingUp || index == 0 // show at top or when scrolling up
                if (visible != showButton.value) {
                    showButton.value = visible
                    getShow(visible) // notify parent only when changed
                }
            }
    }

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (cartRef, buttonRef) = createRefs()

        Column(
            modifier = Modifier.constrainAs(cartRef) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                height = Dimension.fillToConstraints
            }
        ) {
            // IMPORTANT: MyCartSection must use this listState (see below)
            MyCartSection(navController = navController, listState = listState)
        }

        AnimatedVisibility(
            visible = showButton.value,
            modifier = Modifier.constrainAs(buttonRef) {
                bottom.linkTo(parent.bottom, margin = 26.dp)
                start.linkTo(parent.start, margin = 18.dp)
                end.linkTo(parent.end, margin = 18.dp)
                width = Dimension.fillToConstraints
            }
        ) {
            CheckoutButton(
                text = "Go to Checkout",
                12.97
            ) {
                getShow(it)
            }
        }
    }
}


@Composable
fun ConstraintButton(navController: NavController, getShow: (Boolean)-> Unit) {

    val listState = rememberLazyListState()

    // Track scroll direction
    var previousIndex by remember { mutableStateOf(0) }
    var previousScrollOffset by remember { mutableStateOf(0) }

    val isScrollingUp by remember {
        derivedStateOf {
            if (listState.firstVisibleItemIndex != previousIndex) {
                val scrollingUp = listState.firstVisibleItemIndex < previousIndex
                previousIndex = listState.firstVisibleItemIndex
                previousScrollOffset = listState.firstVisibleItemScrollOffset
                scrollingUp
            } else {
                val scrollingUp = listState.firstVisibleItemScrollOffset < previousScrollOffset
                previousScrollOffset = listState.firstVisibleItemScrollOffset
                scrollingUp
            }
        }
    }

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
            MyCartSection(navController, listState)
        }

        //        Column(
//            modifier = Modifier.constrainAs(button) {
//                bottom.linkTo(parent.bottom, margin = 26.dp) // <--- key change
//                start.linkTo(parent.start, margin = 18.dp)
//                end.linkTo(parent.end, margin = 18.dp)
//                width = Dimension.fillToConstraints
//            }
//        ) {
//            CheckoutButton(
//                text = "Go to Checkout",
//                12.97
//            ){
//                getShow(it)
//            }
//        }

        AnimatedVisibility (
            visible = isScrollingUp,
            modifier = Modifier.constrainAs(button) {
                bottom.linkTo(parent.bottom, margin = 26.dp)
                start.linkTo(parent.start, margin = 18.dp)
                end.linkTo(parent.end, margin = 18.dp)
                width = Dimension.fillToConstraints
            }
        ) {
            CheckoutButton(
                text = "Go to Checkout",
                12.97
            ) {
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

                    IconButton(
                        onClick = {
                            showSheet = false
                            getSheet(showSheet)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Cancel,
                            contentDescription = "Close bottom sheet",
                        )
                    }

                }

                CheckoutRow("Delivery", "Select Method")

                CheckoutRow("Payment", "", true, R.drawable.payment)

                CheckoutRow("Promo Code", "Pick Method")

                CheckoutRow("Total Cost", "$13.97")

                OrderButton(navController){ showSheet = it}

            }
        }
    }
}

@Composable
fun OrderButton(navController: NavController, offSheet: (Boolean) -> Unit){

    offSheet(false)

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

        var showDialog: Boolean? by remember { mutableStateOf(null) }

        val randomBool = Random.nextBoolean()

        NormalButton("Place Order", randomBool) { showDialog = it}

        if (showDialog == false) {
            AlertDialog(
                onDismissRequest = { showDialog = false }, // closes when tapped outside
                containerColor = Color.White,
                title = {
                    IconButton(
                        onClick = {
                            showDialog = null
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Cancel,
                            contentDescription = "Cancel"
                        )
                    }
                },
                text = {
                    AlertImg(navController){ showDialog = null}
                },
                confirmButton = {}
            )
        }
        if (showDialog == true){
            navController.navigate(Screen.Accept.route)
            showDialog = null
        }
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