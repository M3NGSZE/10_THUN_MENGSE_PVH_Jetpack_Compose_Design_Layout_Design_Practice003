package com.example.a10__thun_mengse_pvh_oop_practice003.screen.detailProduct

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.home.exclusiveOfferItem

@Composable
fun DetailProductScreen(navController: NavController, productId: String?){

//    val index: Int? = productId?.toInt()?.minus(1)

//    val product = index?.let { exclusiveOfferItem[it] }



    val product = exclusiveOfferItem[2-1]

    Column {

        TopImgSection(product, navController)
    }

}

@Composable
fun DetailProductSection(){

}

@Composable
fun IconComparison() {

    Icon(
        imageVector = Icons.Default.FavoriteBorder,
        contentDescription = "Favorite"
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        // IconButton
        IconButton (onClick = { println("IconButton clicked") }) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Favorite"
            )
        }

        // Icon + clickable
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "Favorite",
            modifier = Modifier
                .size(24.dp) // smaller touch area
                .clickable() { println("Icon clicked") }
        )
    }
}
