package com.example.a10__thun_mengse_pvh_oop_practice003.screen.home

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
import androidx.navigation.NavController
import com.example.a10__thun_mengse_pvh_oop_practice003.R
import com.example.a10__thun_mengse_pvh_oop_practice003.data.BottomNavigation
import com.example.a10__thun_mengse_pvh_oop_practice003.data.ExclusiveOffer
import com.example.a10__thun_mengse_pvh_oop_practice003.ui.HomeActivity.exclusiveOfferItem
import com.example.a10__thun_mengse_pvh_oop_practice003.component.RowSection
import com.example.a10__thun_mengse_pvh_oop_practice003.component.SearchField

@Composable
fun HomeScreen(navController: NavController) {

    LazyColumn(

    ){
        item {

            TopHomeSection()

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

@Composable
fun TopHomeSection(){
    Column (
        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
    ){
        NectarTopBar()

        Spacer(modifier = Modifier.height(15.dp))

        SearchField()

        Spacer(modifier = Modifier.height(20.dp))

        HomeBanner()
    }
}

@Composable
fun HomeBanner(){
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
}




@Composable
fun ProductSection() {
    LazyRow {
        items(exclusiveOfferItem.size){it ->
            ItemRender(it)

        }
//        items(exclusiveOfferItem, key = { item ->
//            item.id
//
//        }) { it ->
//            ItemRender(it)
//        }
//        items(1000){
//
//        }
    }
}

@Composable
fun ItemRender(index: Int) {
    val exclusive = exclusiveOfferItem[index]
    var lastPaddingEnd = 0.dp

    if (index == exclusiveOfferItem.size - 1) {
        lastPaddingEnd = 16.dp
    }

    Box(
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = lastPaddingEnd
            )
    ) {
        Column(
            modifier = Modifier
                .border(
                    width = 1.dp,               // thickness of the border
                    color = Color.Gray,          // border color
                    shape = RoundedCornerShape(13.dp) // optional: rounded corners
                )
                .width(190.dp)
                .padding(10.dp)
                .clickable {}
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
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

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
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
                        .clickable {},
                    contentAlignment = Alignment.Center
                ) {
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
        id = 1,
        name = "Organic Bananas",
        des = "7pcs, Priceg",
        price = 4.99,
        img = R.drawable.banana
    ),
    ExclusiveOffer(
        id = 2,
        name = "Red Apple",
        des = "1kg, Priceg",
        price = 4.99,
        img = R.drawable.apple
    ),
    ExclusiveOffer(
        id = 3,
        name = "Bell Pepper Red",
        des = "1kg, Priceg",
        price = 4.99,
        img = R.drawable.bell_pepper
    ),
    ExclusiveOffer(
        id = 4,
        name = "Ginger",
        des = "250gm, Priceg",
        price = 4.99,
        img = R.drawable.ginger
    ),
    ExclusiveOffer(
        id = 5,
        name = "Beef Bone",
        des = "1kg, Priceg",
        price = 4.99,
        img = R.drawable.beef_bone
    ),
    ExclusiveOffer(
        id = 6,
        name = "Broiler Chicken",
        des = "1kg, Priceg",
        price = 4.99,
        img = R.drawable.boiler_chicken
    )
)


@Composable
fun NectarTopBar() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.orange_carrot),
            contentDescription = "Carrot Icon",
            modifier = Modifier.size(40.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        Row(

            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
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



