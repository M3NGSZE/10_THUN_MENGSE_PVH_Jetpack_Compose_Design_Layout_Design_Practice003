package com.example.a10__thun_mengse_pvh_oop_practice003.screen.cart

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Minimize
import androidx.compose.material.icons.filled.PlusOne
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.a10__thun_mengse_pvh_oop_practice003.R
import com.example.a10__thun_mengse_pvh_oop_practice003.data.ProductMoreFields

val cartItems = listOf(
    ProductMoreFields(
        id = 1,
        name = "Bell Pepper Red",
        des = "1kg, Priceg",
        price = 4.99,
        img = R.drawable.bell_pepper
    ),
    ProductMoreFields(
        id = 2,
        name = "Egg Chicken Red",
        des = "4pcs, Price",
        price = 1.99,
        img = R.drawable.egg_chicken
    ),
    ProductMoreFields(
        id = 3,
        name = "Organic Bananas",
        des = "7pcs, Priceg",
        price = 4.99,
        img = R.drawable.banana
    ),
    ProductMoreFields(
        id = 4,
        name = "Ginger",
        des = "250gm, Priceg",
        price = 4.99,
        img = R.drawable.ginger
    ),
    ProductMoreFields(
        id = 5,
        name = "Mayonnaise Eggless",
        des = "325ml, Price",
        price = 4.99,
        img = R.drawable.maynonnias_egg
    ),
    ProductMoreFields(
        id = 6,
        name = "Egg Noodles",
        des = "350ml, Price",
        price = 4.99,
        img = R.drawable.egg_noodle_purple
    ),
    ProductMoreFields(
        id = 7,
        name = "Diet Coke",
        des = "355ml, Price",
        price = 1.99,
        img = R.drawable.diet_coke
    ),
    ProductMoreFields(
        id = 8,
        name = "Sprite Can",
        des = "325ml, Price",
        price = 1.50,
        img = R.drawable.sprike_can
    ),
)

@Composable
fun MyCartSection(navController: NavController){
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
    ){
        items(cartItems, key = {item -> item.id}){
                it -> CartItem(it, navController)
        }
    }
}

@Composable
fun CartItem(item: ProductMoreFields, navController: NavController){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .drawBehind {
                val strokeWidth = 1.dp.toPx()
                val y = size.height - strokeWidth / 2
                drawLine(
                    color = Color(0xFFB2B2B2),
                    start = Offset(0f, y),
                    end = Offset(size.width, y),
                    strokeWidth = strokeWidth
                )
            },
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ){
        Box(
//            modifier = Modifier.background(Color(0xFF8664DB))
        ){
            Image(
                painter = painterResource(item.img),
                contentDescription = item.name,
                modifier = Modifier.size(120.dp)
            )
        }

        Spacer(modifier = Modifier.width(25.dp))

        Row (
            modifier = Modifier.fillMaxWidth()
                .padding(top = 20.dp, bottom = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Column {
                Text(
                    text = item.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.height(7.dp))

                Text(
                    text = item.des,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(20.dp))

                Row (
                    modifier = Modifier.width(150.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    IconButton(
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = Color.Gray,
                                shape = RoundedCornerShape(16.dp)
                            ),
                        onClick = {},
                    ) {
                        Icon(
                            imageVector = Icons.Default.Remove,
                            contentDescription = "Close",
                            tint = Color(0xFFB2B2B2),
                            modifier = Modifier.size(30.dp)
                        )
                    }

                    Text(
                        text = "${1}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )

                    IconButton(
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = Color.Gray,
                                shape = RoundedCornerShape(16.dp)
                            ),
                        onClick = {},
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Close",
                            tint = Color(0xFF53B074),
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            }

            Column (
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End
            ){
                IconButton(
                    modifier = Modifier.padding(bottom = 50.dp),
                    onClick = {},
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close",
                        tint = Color(0xFFB2B2B2),
                        modifier = Modifier.size(30.dp)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "$ ${item.price}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
        }

    }

//    Card (
//        modifier = Modifier
//            .padding(start = 10.dp, end = 10.dp, top = 16.dp)
//            .height(320.dp)
//            .fillMaxWidth()
//            .clickable {
//
//            },
//        elevation = CardDefaults.cardElevation(8.dp),
//        colors = CardDefaults.cardColors(
//            containerColor = Color.White
//        )
//    ) {
//        Row (
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(20.dp),
////            verticalArrangement = Arrangement.SpaceBetween
//        ){
//            Box(
////                modifier = Modifier.fillMaxWidth(),
//                contentAlignment = Alignment.Center
//            ){
//                Image(
//                    painter = painterResource(item.img),
//                    contentDescription = item.name,
//                    modifier = Modifier.size(80.dp)
//                )
//            }
//
//            Spacer(modifier = Modifier.height(15.dp))
//
//            Text(
//                text = item.name,
//                fontWeight = FontWeight.Bold,
//                fontSize = 20.sp,
////                maxLines = 1
//            )
//
//            Spacer(modifier = Modifier.height(5.dp))
//
//            Text(
//                text = item.des,
//                fontSize = 15.sp,
//                color = Color.Gray
//            )
//
//            Spacer(modifier = Modifier.height(15.dp))
//
//            Row (
//                modifier = Modifier
//                    .fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceBetween,
//                verticalAlignment = Alignment.CenterVertically
//            ){
//                Text(
//                    text = "$ ${item.price}",
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 20.sp,
//                )
//
//                Box(
//                    modifier = Modifier
//                        .clip(RoundedCornerShape(20.dp))
//                        .background(Color(0xFF53B175))
//                        .size(50.dp)
//                        .clickable {},
//                    contentAlignment = Alignment.Center
//                ) {
//                    Icon(
//                        imageVector = Icons.Rounded.Add,
//                        contentDescription = "Add icon",
//                        tint = Color.White
//                    )
//                }
//            }
//        }
//    }
}


