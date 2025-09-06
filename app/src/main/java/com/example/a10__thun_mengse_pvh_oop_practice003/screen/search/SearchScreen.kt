package com.example.a10__thun_mengse_pvh_oop_practice003.screen.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.rounded.Cancel
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.a10__thun_mengse_pvh_oop_practice003.component.FilterSection
import com.example.a10__thun_mengse_pvh_oop_practice003.component.SearchField
import com.example.a10__thun_mengse_pvh_oop_practice003.component.ShowSheet
import com.example.a10__thun_mengse_pvh_oop_practice003.component.checkBrand
import com.example.a10__thun_mengse_pvh_oop_practice003.component.checkCategory

@Composable
fun SearchScreen(navController: NavController){

    var isSheet by remember { mutableStateOf(false) }

    Column {
        TopSearchApp(navController){
            it -> isSheet = it
        }

        EggSection(navController)

        ShowSheet (isSheet){
            isSheet = it
        }

    }
}

@Composable
fun TopSearchApp(navController: NavController, toggle : (Boolean) -> Unit){

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
        ){
            SearchField(isTrailing = true, navController = navController)
        }
        IconButton(
            onClick = {
                toggle(true)
            }
        ) {
            Icon(
                imageVector = Icons.Default.Tune,
                contentDescription = "Filter icon",
                modifier = Modifier
                    .size(30.dp)

            )
        }
    }
}


