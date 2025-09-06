package com.example.a10__thun_mengse_pvh_oop_practice003.screen.explore.exploreProduct

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Tune
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.a10__thun_mengse_pvh_oop_practice003.component.ShowSheet
import com.example.a10__thun_mengse_pvh_oop_practice003.navigation.Screen

@Composable
fun BeverageScreen(navController: NavController){

    var isSheet by remember { mutableStateOf(false) }

    Column {
        TopBeverageBar(navController){
            isSheet = it
        }

        BeverageSection(navController)

        ShowSheet (isSheet){
            isSheet = it
        }
    }
}

@Composable
fun TopBeverageBar(navController: NavController, toggle : (Boolean) -> Unit){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        IconButton(
            onClick = {
                navController.navigate(Screen.Explore.route)
            }
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBackIosNew,
                contentDescription = "Back Arrow"
            )
        }


        Text(
            text = "Beverages",
            fontWeight = FontWeight.Bold,
            fontSize = 23.sp
        )

        Icon(
//            imageVector = Icons.Default.AddRoad,
            imageVector = Icons.Default.Tune,
            contentDescription = "filter",
            modifier = Modifier
                .size(30.dp)
                .clickable{
                    toggle(true)
                }
        )
    }
}