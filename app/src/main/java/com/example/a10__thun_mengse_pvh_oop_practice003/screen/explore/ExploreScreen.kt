@file:OptIn(ExperimentalFoundationApi::class)

package com.example.a10__thun_mengse_pvh_oop_practice003.screen.explore

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.a10__thun_mengse_pvh_oop_practice003.component.SearchField
import com.example.a10__thun_mengse_pvh_oop_practice003.navigation.Screen

@Composable
fun ExploreScreen(navController: NavController){
    Column {
        HeaderSticky(navController = navController)
        GridProduct(navController)
    }
}

@Composable
fun HeaderSticky(navController: NavController){
    Column (
        modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp)
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .clickable{
                    navController.navigate(Screen.Search.route)
                }
            ,
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = "Find Products",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        NavigateOnFocusTextField(navController)
    }
}

@Composable
fun NavigateOnFocusTextField(navController: NavController) {
//    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    TextField(
        value = "",
        onValueChange = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
            .clip(RoundedCornerShape(20.dp))
            .onFocusChanged() { focusState ->
                if (focusState.isFocused) {
                    // Navigate when focused
                    navController.navigate(Screen.Search.route)
                    focusManager.clearFocus() // remove focus so it doesn’t reopen keyboard
                }
            },
        placeholder = {
            Text(
                text = "Search Store",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(top = 3.dp)
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Search,
                contentDescription = "Search Icon",
                modifier = Modifier
                    .padding(start = 15.dp)
                    .size(30.dp)
            )
        },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,   // remove line when focused
            unfocusedIndicatorColor = Color.Transparent, // remove line when not focused
            disabledIndicatorColor = Color.Transparent // remove line when disabled
        ),
    )
}
