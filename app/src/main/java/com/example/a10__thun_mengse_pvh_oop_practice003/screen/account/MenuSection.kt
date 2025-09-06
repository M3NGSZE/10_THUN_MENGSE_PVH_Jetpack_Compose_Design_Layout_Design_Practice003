package com.example.a10__thun_mengse_pvh_oop_practice003.screen.account

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.material.icons.rounded.CoPresent
import androidx.compose.material.icons.rounded.HelpOutline
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.NotificationsNone
import androidx.compose.material.icons.rounded.Payment
import androidx.compose.material.icons.rounded.QrCode
import androidx.compose.material.icons.rounded.ShoppingBag
import androidx.compose.material.icons.rounded.WarningAmber
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.a10__thun_mengse_pvh_oop_practice003.data.AccountMenu

val menuItems = listOf(
    AccountMenu(
        id = 1,
        leadIcon = Icons.Rounded.ShoppingBag,
        title = "Orders",
        trailIcon = Icons.Rounded.ArrowForwardIos,
    ),
    AccountMenu(
        id = 2,
        leadIcon = Icons.Rounded.CoPresent,
        title = "My Details",
        trailIcon = Icons.Rounded.ArrowForwardIos,
    ),
    AccountMenu(
        id = 3,
        leadIcon = Icons.Rounded.LocationOn,
        title = "Delivery Address",
        trailIcon = Icons.Rounded.ArrowForwardIos,
    ),
    AccountMenu(
        id = 4,
        leadIcon = Icons.Rounded.Payment,
        title = "Payment Methods",
        trailIcon = Icons.Rounded.ArrowForwardIos,
    ),
    AccountMenu(
        id = 5,
        leadIcon = Icons.Rounded.QrCode,
        title = "Promo Code",
        trailIcon = Icons.Rounded.ArrowForwardIos,
    ),
    AccountMenu(
        id = 6,
        leadIcon = Icons.Rounded.NotificationsNone,
        title = "Notification",
        trailIcon = Icons.Rounded.ArrowForwardIos,
    ),
    AccountMenu(
        id = 7,
        leadIcon = Icons.Rounded.HelpOutline,
        title = "Help",
        trailIcon = Icons.Rounded.ArrowForwardIos,
    ),
    AccountMenu(
        id = 8,
        leadIcon = Icons.Rounded.WarningAmber,
        title = "About",
        trailIcon = Icons.Rounded.ArrowForwardIos,
    )
)

@Composable
fun AccountMenuSection(navController: NavController){
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
    ){
        items(menuItems, key = { item -> item.id }){it->
            MenuItemCard(it, navController)
        }
    }
}

@Composable
fun MenuItemCard(item: AccountMenu, navController: NavController){
    Row (
        modifier = Modifier
            .clickable{

            }
            .fillMaxWidth()
            .border(
                border = BorderStroke(0.1.dp, Color(0x2E636363)),
                shape = RectangleShape
            )
            .padding(start = 16.dp, end = 16.dp, top = 30.dp, bottom = 30.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Row {
            Icon(
                imageVector = item.leadIcon,
                contentDescription = item.title
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(
                text = item.title,
                fontSize = 18.sp
            )

        }
        Icon(
            imageVector = item.trailIcon,
            contentDescription = item.title,
            modifier = Modifier
                .clickable{}
        )
    }
}