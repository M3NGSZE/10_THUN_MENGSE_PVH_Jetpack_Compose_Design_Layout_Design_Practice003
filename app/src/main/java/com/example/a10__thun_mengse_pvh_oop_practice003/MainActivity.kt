package com.example.a10__thun_mengse_pvh_oop_practice003

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.a10__thun_mengse_pvh_oop_practice003.navigation.AppNavigation
import com.example.a10__thun_mengse_pvh_oop_practice003.ui.OnboardingActivity.OnboardingActivity
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            SplashScreen()
//            LaunchedEffect(Unit) {
//                delay(2000)
//                startActivity(Intent(this@MainActivity, OnboardingActivity::class.java))
//                finish()
//            }
            navController = rememberNavController()
            AppNavigation(navController = navController)
        }
    }
}

//@Preview(showSystemUi = true)
//@Composable
//private fun SplashScreen() {
//    Row (
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color(0xFF53B175)),
//        horizontalArrangement = Arrangement.Center,
//        verticalAlignment = Alignment.CenterVertically
//    ){
//        Image(
//            painter = painterResource(id = R.drawable.carrot_logo),
//            contentDescription = "App Logo",
//            modifier = Modifier.size(60.dp)
//        )
//
//        Spacer(
//            modifier = Modifier.width(10.dp)
//        )
//
//        Text(
//            text = "nectar",
//            color = Color.White,
//            fontSize = 50.sp)
//    }
//}