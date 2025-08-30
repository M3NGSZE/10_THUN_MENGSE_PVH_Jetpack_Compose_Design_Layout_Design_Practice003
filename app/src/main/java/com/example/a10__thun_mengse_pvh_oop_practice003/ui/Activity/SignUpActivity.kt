package com.example.a10__thun_mengse_pvh_oop_practice003.ui.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

class SignUpActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Signup()
        }
    }
}

@Composable
fun Signup(){
    Column (
        modifier = Modifier
            .systemBarsPadding()
    ) {
        Text("Sign up screen")
    }
}