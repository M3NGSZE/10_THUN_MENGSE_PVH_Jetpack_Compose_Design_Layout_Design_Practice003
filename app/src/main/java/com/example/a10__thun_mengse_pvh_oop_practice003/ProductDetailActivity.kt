package com.example.a10__thun_mengse_pvh_oop_practice003

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.a10__thun_mengse_pvh_oop_practice003.ui.PracticeActivity.TopSection


class ProductDetailActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProductDetail()
        }
    }
}

@Composable
fun ProductDetail(){
    Scaffold {
        paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            TopSection()
        }
    }
}