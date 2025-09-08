package com.example.a10__thun_mengse_pvh_oop_practice003.screen.detailProduct

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.a10__thun_mengse_pvh_oop_practice003.component.NectarButton
import com.example.a10__thun_mengse_pvh_oop_practice003.screen.home.exclusiveOfferItem

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailProductScreen(navController: NavController, productId: String?){
    Scaffold (
        bottomBar = {
            Column (
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            ){
                NectarButton("Add to Basket", navController, "")
            }
        }
    ){
        val index: Int? = productId?.toInt()?.minus(1)

        val product = index?.let { exclusiveOfferItem[it] }

        Column (
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ){

            TopImgSection(navController,product)

            DetailProductSection(product, navController)


        }
    }


}