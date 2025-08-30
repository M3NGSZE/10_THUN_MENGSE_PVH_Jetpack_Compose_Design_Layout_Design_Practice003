package com.example.a10__thun_mengse_pvh_oop_practice003.ui.component

import android.content.Context
import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.w3c.dom.Text

@Composable
fun NectarButton(context: Context, screen: ComponentActivity, text: String){
    Button(
        onClick = {
            val intent = Intent(context, screen::class.java)
            context.startActivity(intent)
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF53B175)
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        Text(
            text = text,
            fontSize = 23.sp,
            fontWeight = FontWeight.ExtraBold
        )
    }
}


@Composable
fun NectarTextField(label: String, setEmail: (String) -> Unit){

    var email by remember { mutableStateOf("") }
    setEmail(email)

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        value = email,
        onValueChange = { newText -> email = newText },
        label = {
            Text(
                text = label,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
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
}