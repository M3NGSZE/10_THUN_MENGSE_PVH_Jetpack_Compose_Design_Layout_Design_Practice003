package com.example.a10__thun_mengse_pvh_oop_practice003

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a10__thun_mengse_pvh_oop_practice003.ui.theme._10__THUN_MENGSE_PVH_OOP_Practice003Theme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            _10__THUN_MENGSE_PVH_OOP_Practice003Theme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//                SplashCard()
//
//                LaunchedEffect(Unit) {
//                    delay(2000)
//                    startActivity(Intent(this@MainActivity, MainActivity::class.java))
//                    finish()
//                }

//                AppContent()
//            }
//            AppContent()
//            Text("Hello world")
            Onboard()
        }
    }
}

@Composable
fun Onboard(){
    Scaffold {
        paddingValues ->
        Text("hello onboard", modifier = Modifier.padding(paddingValues))
    }
}

@Preview(showBackground = true)
@Composable
fun SplashCard() {
    Box(modifier = Modifier.fillMaxSize().background(Color(0xFF53B175))
    ){
        Row (modifier =
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Icon(
                painter = painterResource(R.drawable.carrot_logo),
                contentDescription = "splash card icon",
                tint = Color(0xFFFFFFFF),
                modifier = Modifier.size(60.dp)
            )
            Text("nectar",
                color = Color(0xFFFFFFFF),
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold,
//                fontFamily = poppins,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _10__THUN_MENGSE_PVH_OOP_Practice003Theme {
        Greeting("Android")
    }
}

//@Composable
//fun AppContent() {
//    var showSplash by remember { mutableStateOf(false) }
//
//    LaunchedEffect(Unit) {
//        delay(2000L) // Show splash for 2 seconds
//        showSplash = true
//    }
//
//    if (showSplash) {
//        SplashScreen()
//    } else {
////        LearnConstraintLayout() // Your existing composable
//    }
//}