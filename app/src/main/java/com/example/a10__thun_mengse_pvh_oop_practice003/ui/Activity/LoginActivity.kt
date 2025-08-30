package com.example.a10__thun_mengse_pvh_oop_practice003.ui.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a10__thun_mengse_pvh_oop_practice003.R

class LoginActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Login()
        }
    }
}

@Composable
private fun Login(){
    Column (
        modifier = Modifier
            .systemBarsPadding()
            .padding(16.dp)
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.orange_carrot),
                contentDescription = "Orange Carrot",
                modifier = Modifier.size(60.dp)
            )
        }

        Text(
            text = "Loging",
            fontSize = 30.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "Enter your emails and password",
            fontSize = 17.sp,
            color = Color(0xFF919090),
        )

        Spacer(modifier = Modifier.height(35.dp))

        var email by remember { mutableStateOf("") }

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            value = email,
            onValueChange = { newText -> email = newText },
            label = {
                Text(
                    text = "Email",
                    fontSize = 18.sp,
                    color = Color(0xFF919090),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color(0xFF53B175),
                unfocusedIndicatorColor = Color(0x73919090)
            ),
            singleLine = true,
            textStyle = TextStyle(
                fontSize = 18.sp
            )
        )

        Spacer(modifier = Modifier.height(35.dp))

        var password by remember { mutableStateOf("") }
        var passwordVisibility by remember { mutableStateOf(false) }

        val icon = if (passwordVisibility)
            painterResource(id = R.drawable.visible_icon)
        else
            painterResource(id = R.drawable.invisible_icon)


        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            value = password,
            onValueChange = { password = it },
            label = {
                Text(
                    text = "Password",
                    fontSize = 18.sp,
                    color = Color(0xFF919090),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color(0xFF53B175),
                unfocusedIndicatorColor = Color(0x73919090)
            ),
            singleLine = true,
            textStyle = TextStyle(
                fontSize = 18.sp
            ),
            trailingIcon = {
                IconButton(
                    onClick = {
                        passwordVisibility = !passwordVisibility
                    }
                ) {
                    Icon(
                        painter = icon,
                        contentDescription = "Visible Icon",
                        modifier = Modifier.size(20.dp),
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password, // Keyboard type
                imeAction = ImeAction.Done            // Action button on keyboard
            ),
            visualTransformation = if (passwordVisibility)
                VisualTransformation.None
            else
                PasswordVisualTransformation(),
        )
    }
}

