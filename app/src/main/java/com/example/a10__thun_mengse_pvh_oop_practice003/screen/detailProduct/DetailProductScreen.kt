package com.example.a10__thun_mengse_pvh_oop_practice003.screen.detailProduct

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.home.exclusiveOfferItem

@Composable
fun DetailProductScreen(navController: NavController, productId: String?){

    val index: Int? = productId?.toInt()?.minus(1)

    val product = index?.let { exclusiveOfferItem[it] }



//    val product = exclusiveOfferItem[2-1]

    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ){

        TopImgSection(navController,product)

        DetailProductSection(product, navController)
    }
}