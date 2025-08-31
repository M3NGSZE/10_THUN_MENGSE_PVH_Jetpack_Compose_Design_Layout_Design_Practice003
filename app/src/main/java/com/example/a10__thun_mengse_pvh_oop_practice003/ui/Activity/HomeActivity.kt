package com.example.a10__thun_mengse_pvh_oop_practice003.ui.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.PersonOutline
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.rounded.StoreMallDirectory
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a10__thun_mengse_pvh_oop_practice003.R
import com.example.a10__thun_mengse_pvh_oop_practice003.data.BottomNavigation
import com.example.a10__thun_mengse_pvh_oop_practice003.data.ExclusiveOffer
import com.example.a10__thun_mengse_pvh_oop_practice003.data.Groceries
import com.example.a10__thun_mengse_pvh_oop_practice003.ui.component.RowSection
import com.example.a10__thun_mengse_pvh_oop_practice003.ui.component.SearchField

class HomeActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Home()
        }
    }
}



//@Preview(showSystemUi = true)
@Composable
fun Home(){
    Scaffold (
        bottomBar = {
            NectarBottomBar()
        }
    ) { paddingValues ->
        LazyColumn (
            modifier = Modifier
                .padding(paddingValues)
                .padding(25.dp)
        ) {
            item {
                NectarTopBar()

                Spacer(modifier = Modifier.height(15.dp))

                SearchField()

                Spacer(modifier = Modifier.height(20.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()      // make Box fill the screen width
                        .height(130.dp)
                        .clip(RoundedCornerShape(15.dp))
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.banner),
                        contentDescription = "Banner img",
                        modifier = Modifier
                            .fillMaxWidth()   // make Image fill the Box width
                            .fillMaxHeight(), // optional: match Box height
                        contentScale = ContentScale.Crop // scales image to fill width nicely
                    )
                }

                RowSection(sectionName = "Exclusive Offers", seeAll = "See All")

                ProductSection()

                RowSection(sectionName = "Best Selling", seeAll = "See All")

                ProductSection()

                RowSection(sectionName = "Groceries", seeAll = "See All")

                GroceriesSection()

                Spacer(modifier = Modifier.height(20.dp))

                ProductSection()
            }
        }
    }
}

@Composable
fun GroceriesSection(){
    LazyRow {
        items(groceryItems.size) {it ->
            GroceryRender(it)
        }
    }
}

@Composable
fun GroceryRender(index: Int){
    val groceries = groceryItems[index]
    var firstPaddingStart = 16.dp
    var lastPaddingEnd = 0.dp

    if (index == exclusiveOfferItem.size - 1){
        lastPaddingEnd = 16.dp
    }

    if (index == 0){
        firstPaddingStart = 0.dp
    }

    val bgColor = if (index == 0) 0xFFFCF0E3 else 0xFFE4F2E9

    Box(
        modifier = Modifier
            .padding(
                start = firstPaddingStart,
                end = lastPaddingEnd
            )
    ){
        Row (
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(Color(bgColor))
                .width(300.dp)
                .height(140.dp)
                .padding(10.dp)
                .clickable{},
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
//                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(groceries.img),
                    contentDescription = groceries.name,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .size(110.dp)
                )
            }

            Spacer(modifier = Modifier.width(15.dp))

            Text(
                text = groceries.name,
                fontSize = 25.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

val groceryItems = listOf(
    Groceries(
        name = "Pulses",
        img = R.drawable.pulses
    ),
    Groceries(
        name = "Rice",
        img = R.drawable.rice
    )
)

@Composable
fun  ProductSection( ){
    LazyRow {
        items(exclusiveOfferItem.size) {it ->
            ItemRender(it)
        }
    }
}

@Composable
fun ItemRender(index: Int){
    val exclusive = exclusiveOfferItem[index]
    var firstPaddingStart = 16.dp
    var lastPaddingEnd = 0.dp

    if (index == exclusiveOfferItem.size - 1){
        lastPaddingEnd = 16.dp
    }

    if (index == 0){
        firstPaddingStart = 0.dp
    }

    Box(
        modifier = Modifier
            .padding(
                start = firstPaddingStart,
                end = lastPaddingEnd
            )
    ){
        Column (
            modifier = Modifier
                .border(
                    width = 1.dp,               // thickness of the border
                    color = Color.Gray,          // border color
                    shape = RoundedCornerShape(13.dp) // optional: rounded corners
                )
                .width(200.dp)
                .padding(10.dp)
                .clickable{}
        ){
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(exclusive.img),
                    contentDescription = exclusive.name,
                    modifier = Modifier.size(130.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = exclusive.name,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = exclusive.des,
                fontWeight = FontWeight.Medium,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "$ ${exclusive.price}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color(0xFF53B175))
                        .size(50.dp)
                        .clickable{},
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        imageVector = Icons.Rounded.Add,
                        contentDescription = "Add icon",
                        tint = Color.White
                    )
                }
            }


        }
    }
}



// initialize value for render data
val exclusiveOfferItem = listOf(
    ExclusiveOffer(
        name = "Organic Bananas",
        des = "7pcs, Priceg",
        price = 4.99,
        img = R.drawable.banana
    ),
    ExclusiveOffer(
        name = "Red Apple",
        des = "1kg, Priceg",
        price = 4.99,
        img = R.drawable.apple
    ),
    ExclusiveOffer(
        name = "Bell Pepper Red",
        des = "1kg, Priceg",
        price = 4.99,
        img = R.drawable.bell_pepper
    ),
    ExclusiveOffer(
        name = "Ginger",
        des = "250gm, Priceg",
        price = 4.99,
        img = R.drawable.ginger
    ),
    ExclusiveOffer(
        name = "Beef Bone",
        des = "1kg, Priceg",
        price = 4.99,
        img = R.drawable.beef_bone
    ),
    ExclusiveOffer(
        name = "Broiler Chicken",
        des = "1kg, Priceg",
        price = 4.99,
        img = R.drawable.boiler_chicken
    )
)

//@Preview
@Composable
fun NectarTopBar(){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.orange_carrot),
            contentDescription = "Carrot Icon",
            modifier = Modifier.size(40.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        Row (

            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                imageVector = Icons.Rounded.LocationOn,
                contentDescription = "Location Icon"
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Dhaka, Banassre",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
//                color = Color(0xFF919090),
            )
        }


    }
}

val bottomBarItems = listOf(
    BottomNavigation(
        label = "Shop",
        icon = Icons.Rounded.StoreMallDirectory
    ),
    BottomNavigation(
        label = "Explore",
        icon = Icons.Rounded.Search
    ),
    BottomNavigation(
        label = "Cart",
        icon = Icons.Rounded.ShoppingCart
    ),
    BottomNavigation(
        label = "Favorite",
        icon = Icons.Rounded.FavoriteBorder
    ),
    BottomNavigation(
        label = "Account",
        icon = Icons.Rounded.PersonOutline
    )
)

//@Preview
@Composable
fun NectarBottomBar(){
    Surface (
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
    ) {
        NavigationBar {
            Row (
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.inverseOnSurface)
                    .padding(10.dp)
                    .clip(RoundedCornerShape(20.dp))
            ){
                bottomBarItems.forEachIndexed {
                        index, item ->
                    NavigationBarItem(
                        selected = index == 0,
                        onClick = {},
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.label,
                            )
                        },
                        label = {
                            Text(
                                text = item.label,
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF53B175),
                            selectedTextColor = Color(0xFF53B175),
                            indicatorColor = Color.Transparent
                        )
                    )
                }
            }
        }
    }
}